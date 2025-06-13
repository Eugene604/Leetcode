

 function TreeNode(val, left, right) {
     this.val = (val===undefined ? 0 : val)
     this.left = (left===undefined ? null : left)
     this.right = (right===undefined ? null : right)
 }
 
/**
 * @param {TreeNode} root
 * @param {number} target
 * @return {TreeNode}
 */
var removeLeafNodes = function(root, target) {
   
    if (!root) {
        return null;
    }//fi

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    
    if (!root.left && !root.right && root.val === target) {//this node is or has become a leaf
        return null;
    }//end if

    return root;
  
};