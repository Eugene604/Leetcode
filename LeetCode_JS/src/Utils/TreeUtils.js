const TreeNode = require('../DataStructs/TreeNode.js');

/**
 * Build a binary tree based on an array of node values.
 * Precondition: first array element must not be null
 * @param {number[]} nodeValArr, Array of node values, where index position decides parental and children relationship
 * @returns {TreeNode} the root of the tree
 */
var buildTree = function(nodeValArr) {

	let nodeRefArr = [nodeValArr.length];
	
	for (let i=0; i<nodeValArr.length; i++){
		if (nodeValArr[i] !== null){
			nodeRefArr[i] = new TreeNode(nodeValArr[i]);
		}//fi
	}//rof
	
	let arrInx = 0;
	for (let i=0; i<nodeRefArr.length; i++){
		if (nodeRefArr[i] !== undefined){
			nodeRefArr[i].left = nodeRefArr[++arrInx];
			nodeRefArr[i].right = nodeRefArr[++arrInx];
		}//fi
	}//rof
	
	return nodeRefArr[0];
};

var displayTree = function(root) {
	const MAX_DEPTH =4; // Maximum depth to display
	const indents = [
		" ".repeat(48),
		" ".repeat(26),
		" ".repeat(10),
		" ".repeat(3),
		" ".repeat(0)
	];

	const spacesBtwNodes = [
		" ".repeat(5),
		" ".repeat(45),
		" ".repeat(24),
		" ".repeat(11),
		" ".repeat(4)
	];

	const displayNode = (nodeArr, depth) => {
		if (nodeArr === null || depth > MAX_DEPTH) {
			return;
		}//fi

		let nextNodeArr = [Math.pow(2, depth)];
		let nodeLine = indents[depth];
		let separatorLine = indents[depth];
		for (let arrInx = 0; arrInx < Math.pow(2, depth); arrInx++) {
			if (nodeArr[arrInx] !== null && nodeArr[arrInx] !== undefined) {
				nodeLine += "[" + nodeArr[arrInx].val + "]";
				nodeLine += spacesBtwNodes[depth];

				nextNodeArr[arrInx * 2] = nodeArr[arrInx].left;
				nextNodeArr[arrInx * 2 + 1] = nodeArr[arrInx].right;
			} else {
				nodeLine += "[N]";
				nodeLine += spacesBtwNodes[depth];
				nextNodeArr[arrInx * 2] = null;
				nextNodeArr[arrInx * 2 + 1] = null;
			}//fi		
			separatorLine += "/" + " ".repeat(4-depth) + "\\";
			separatorLine += spacesBtwNodes[depth];	
		}//rof
		console.log(nodeLine);
		console.log(separatorLine);

		displayNode(nextNodeArr, depth + 1);
	};

	let nodeArr = [1];
	nodeArr[0] = root;
	displayNode(nodeArr, 0);
};

module.exports = {
	buildTree,
	displayTree
};