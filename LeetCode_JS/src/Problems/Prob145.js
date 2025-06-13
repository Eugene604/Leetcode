const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
	let eleArr = [];
	/**
	 * Recursively performs a postorder traversal on the binary tree.
	 * 
	 * In a postorder traversal, the left subtree is processed first, 
	 * followed by the right subtree, and then the current node's value 
	 * is added to the results array.
	 * 
	 * @param {TreeNode} node - The current node being traversed. 
	 * If null, the function returns immediately.
	 */
	let postOrderTraverse = function(node){
		if (node === null) {
			return;
		}//fi
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		eleArr.push(node.val);
	};//end method
	
	postOrderTraverse(root);
    return eleArr;
};

var testFunc = function() {


	let root;

	root = TreeUtils.buildTree([1,null,2,3]);	
	TreeUtils.displayTree(root);
	console.log("ans: " + JSON.stringify(postorderTraversal(root)));
};



testFunc();
