const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');

/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
	let totalSum = 0;
	
	let traverse = function(node, accomulatedSum) {
		
		accomulatedSum = accomulatedSum*10 + node.val;		
		//console.log('gone here ' + node + ':' + accomulatedSum);
		if (!node.left && !node.right) {//leaf node			
			totalSum += accomulatedSum;
			return;
		}//fi		
		
		if (node.left) {			
			traverse(node.left, accomulatedSum);			
		}//fi
		
		if (node.right) {
			traverse(node.right, accomulatedSum);			
		}//fi
	};//end method
	
	traverse(root, 0);
    return totalSum;
};

var testFunc = function() {
	let valArr1 = [1,2,3];
	let valArr2 = [4,9,0,5,1];


	let root;


	root = TreeUtils.buildTree(valArr1);	
	TreeUtils.displayTree(root);
	console.log("ans: " + sumNumbers(root));
};



testFunc();
