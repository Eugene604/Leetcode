const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');
/**
 * @param {TreeNode} root
 * @return {string}
 */
var smallestFromLeaf = function(root) {
	let minStr = "~";
	
	/**
	 * 
	 * Recursively traverses the tree from the given node and constructs an array representing the path values.
	 * 
	 * Preconditions:
	 * - The provided node and arr are valid TreeNode and Array objects, respectively.
	 * - The external variable minStr is available and used to store the minimum path encountered so far.
	 * 
	 * @param {TreeNode} node - The current node being processed.
	 * @param {number[]} str - The char array representing the path values from root to the current node.
 	*/
	let findMinStr = function(node, str){
		
		let currStr = String.fromCharCode(97 + node.val) + str;		
		if (!node.left && !node.right) {			
			minStr = (currStr > minStr)? minStr : currStr;			
			return;
		}//fi
		if (node.left) {
			findMinStr(node.left, currStr);
		}//fi
		
		if (node.right) {
			findMinStr(node.right, currStr);
		}//fi
	};//end method
			
	findMinStr(root, "");

    return minStr;
};

var testFunc = function() {
	let valArr1 = [0,1,2,3,4,3,4];
	let valArr2 = [2,2,1,null,1,0,null,0];


	let root;
	

	root = TreeUtils.buildTree(valArr1);
	
	TreeUtils.displayTree(root);
	console.log('ans: ' + smallestFromLeaf(root));
	
	
};



testFunc();

/**
 * @param {TreeNode} root
 * @return {string}
 */
var smallestFromLeaf_v2 = function(root) {
	let minArr = [111];
	
	/**
	 * 
	 * Recursively traverses the tree from the given node and constructs an array representing the path values.
	 * 
	 * Preconditions:
	 * - The provided node and arr are valid TreeNode and Array objects, respectively.
	 * - The external variable minArr is available and used to store the minimum path encountered so far.
	 * 
	 * @param {TreeNode} node - The current node being processed.
	 * @param {number[]} arr - The array representing the path values from root to the current node.
 	*/
	let findMinArr = function(node, arr){
		let currArr = [node.val, ...arr];		
		if (!node.left && !node.right) {
			minArr = getMinArr(currArr, minArr);					
			return;
		}//fi
		
		if (node.left) {
			findMinArr(node.left, currArr);
		}//fi
		
		if (node.right) {
			findMinArr(node.right, currArr);
		}//fi
	};//end method
	
	/**

	 * 
	 * Compares two arrays lexicographically and returns the smaller one.
	 * 
	 * Preconditions:
	 * - Both arr1 and arr2 are valid Array objects.
	 * 
	 * @param {number[]} arr1 - The first array to compare.
	 * @param {number[]} arr2 - The second array to compare.
	 * @return {number[]} - The smaller array lexicographically.
	 */
	let getMinArr = function(arr1, arr2) {
		//console.log('comparing: ' + arr1 + ' : ' + arr2);
		let shorterArr = (arr1.length > arr2.length) ? arr2 : arr1;
		for (let i=0; i<shorterArr.length; i++){
			if (arr1[i] > arr2[i]) {
				return arr2;
			} else if (arr1[i] < arr2[i]) {
				return arr1;
			}//fi
		}//rof
		return shorterArr;
	};//end method
	
	findMinArr(root, []);
	minArr = minArr.map(num => num + 97);
	

    return String.fromCharCode(...minArr);;
};

