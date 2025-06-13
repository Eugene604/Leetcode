

/**
 * Build a binary tree based on an array of node values.
 * Precondition: first array element must not be null
 * @param {number[]} nodeValArr, Array of node values, where index position decides parental and children relationship
 * @returns {TreeNode} the root of the tree
 */
var displayMatrix = function(mat) {

	
	
	for (let i=0; i<mat.length; i++){
		console.log(JSON.stringify(mat[i]));
	}//rof
	
};


module.exports = {
	displayMatrix
};