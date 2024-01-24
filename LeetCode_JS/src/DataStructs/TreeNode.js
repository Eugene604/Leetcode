function TreeNode(val, left, right) {
	this.val = (val === undefined ? 0 : val)
	this.left = (left === undefined ? null : left)
	this.right = (right === undefined ? null : right)
	
	this.toString = function() {
        return '[' + this.val + ']';
    };
}

module.exports = TreeNode;