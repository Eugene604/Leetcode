package Problems;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1038 {
	
	

	
	public static void test() {
		Solution1038 sol = new Solution1038();
		
		Integer[] treeArr;
		TreeNode root;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]", Integer[].class);
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            sol.bstToGst(root);
            TreeUtils.displayTree(root);
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1038 {
	
    public TreeNode bstToGst(TreeNode root) {
    	update(root, 0);    	
        return root;
    }//end method
    
    
    /**
     * Updates the values of the nodes in the BST to the Greater Sum Tree (GST) in reverse in-order traversal.
     * 
     * @param node - TreeNode, the current TreeNode being processed
     * @param sumFromParent - int, the cumulative sum from the parent nodes and right subtrees
     * @return int - the sum of all nodes' values processed from this node's subtree
     */

    private int update(TreeNode node, int sumFromParent) {
    	if (node == null) {
    		return 0;
    	}//fi
    	int sumFromRight = update(node.right, sumFromParent);
    	int originalVal = node.val;
    	node.val += sumFromRight + sumFromParent;
    	int sumFromLeft = update (node.left, originalVal + sumFromRight + sumFromParent);
    	return sumFromRight + originalVal + sumFromLeft;
    }//end method

}//end class



 