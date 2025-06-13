const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');

/**
 * @param {TreeNode} root
 * @param {number} val
 * @param {number} depth
 * @return {TreeNode}
 */
var addOneRow = function(root, val, depth) {
	//edge case, depth = 1
	if (depth === 1) {
		let tmpRoot = root;
		root = new TreeNode(val);
		root.left = tmpRoot;
		return root;
	}//fi
	
	/**
	 * Traverses the binary tree to find the node at the specified depth.
	 * Precondition: 
	 * variable val and depth are externally available and valid
	 *
	 * @param {TreeNode} node - The current node being visited.
	 * @param {number} currDepth - The current depth of the traversal.
	 */
	let traverse = function(node, currDepth) {
		//case 1, node is null
		if (!node) {
			return;
		}//fi
		
		//case 2, depth not arrived yet
		if (currDepth !== depth-1) {			
			traverse(node.left, currDepth+1);
			traverse(node.right, currDepth+1);
			return;
		}//fi
		
		//case 3, will reach the depth to add node
		let newLeftChild = new TreeNode(val);		
		let newRightChild = new TreeNode(val);
		newLeftChild.left = node.left;
		newRightChild.right = node.right;
		

		node.left = newLeftChild;
		node.right = newRightChild;

		
	};//end method
	
	traverse(root, 1, true);
    return root;
};

var testFunc = function() {
	let valArr1 = [4,2,6,3,1,5];
	let valArr2 = [4,2,null,3,1];


	let root, val, depth;
	

	root = TreeUtils.buildTree(valArr2);
	val = 1;
	depth = 3;	
	TreeUtils.displayTree(root);
	console.log();
	root = addOneRow(root, val, depth);
	TreeUtils.displayTree(root);
	console.log();
};



testFunc();
