const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');

/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function(root) {
	/**
	 * Recursively traverses the binary tree to compute the sum of all left leaves.
	 * precondition:
	 * it is assumed that node is not null
	 * @param {TreeNode} node - The current node being processed.
	 * @param {boolean} isLeftNode - Indicates whether the current node is a left child.
	 * @returns {number} - The sum of left leaves starting from the given node.
	 */
	let traverse = function(node, isLeftNode) {
		
		if (!node.left && !node.right) {
			return isLeftNode ? node.val : 0;
		}//fi
		
		//console.log('process node: ' + node.toString());
		
		let leftValFromLeftChild;
		let leftValFromRightChild;
		
		if (!node.left){
			leftValFromLeftChild = 0;
		} else {
			leftValFromLeftChild = traverse(node.left, true);	
		}//fi
		
		if (!node.right){
			leftValFromRightChild = 0;
		} else {
			leftValFromRightChild = traverse(node.right, false);
		}//fi
					
		return leftValFromLeftChild + leftValFromRightChild;
	};//end method
	
    return traverse(root, false);
};

var testFunc = function() {
	let valArr1 = [3,9,20,null,null,15,7];
	let valArr2 = [1];
	let valArr3 = [1,2,3,4,5];

	let root;
	let start;

	root = TreeUtils.buildTree(valArr3);	
	TreeUtils.displayTree(root);
	console.log("ans: " + sumOfLeftLeaves(root, start));
};



testFunc();
