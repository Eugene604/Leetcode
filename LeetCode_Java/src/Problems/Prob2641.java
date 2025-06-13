package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob2641 {
	
	

	
	public static void test() {
		Solution2641 sol = new Solution2641();
		
		Integer[] treeArr;
		TreeNode root;
		int k;

		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[5,4,9,1,10,null,7]", Integer[].class);
            k = 2;
            
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            sol.replaceValueInTree(root);
            TreeUtils.displayTree(root);
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution2641 {
	static final int MAX_LEVEL = 100_000;
	int[] lvSumArr;
	
    public TreeNode replaceValueInTree(TreeNode root) {

        	
    	//step 1: populate level sum and close sibling sum
    	int rootVal = root.val;
    	lvSumArr = new int[MAX_LEVEL+1];    	
    	populateLevelAndChildrenSum(root, 1);
    	//System.out.println("lvSumArr: " + Arrays.toString(lvSumArr));
    	//TreeUtils.displayTree(root);
    	
    	 //step 2: replace value
    	replaceVal(root, rootVal, 1);
    	
        return root;
    }//end method
    
     /**
     * This function performs two tasks:
     * 1. Populates level sums and stores them in the level sum array.
     * 2. Surveys the children's values and stores the sum of children into the node's val field.
     * 
     * Preconditions:
     * - lvSumArr is initialized.
     * 
     * Postconditions:
     * - The val field becomes the sum of the child nodes' values.
     * 
     * @param currNode - TreeNode, the current node being processed.
     * @param currLv - int, the current level of the tree.
     * @return the original value of the current node.
     */
    private int populateLevelAndChildrenSum(TreeNode currNode, int currLv) {
    	//base case: node is null
    	if (currNode == null) {
    		return 0;
    	}//fi
    	
    	int origVal = currNode.val;
    	lvSumArr[currLv] += origVal;
    	    	
    	currNode.val = populateLevelAndChildrenSum(currNode.left, currLv+1);
    	currNode.val += populateLevelAndChildrenSum(currNode.right, currLv+1);
    	
    	return origVal;
    }//end method
    
    /**
     * This function replaces the value of each node by calculating the difference between the level sum 
     * and the sibling value, as part of the tree transformation.
     * 
     * Preconditions:
     * - lvSumArr is populated.
     * 
     * Postconditions:
     * - The val field of the current node is updated with the new value based on the level sum.
     * 
     * @param currNode - TreeNode, the current node being processed.
     * @param siblingVal - int, the value of the sibling node, used in the replacement calculation.
     * @param currLv - int, the current level of the tree.
     */
    private void replaceVal(TreeNode currNode, int siblingVal, int currLv) {
    	//base case: node is null, do nothing
    	if (currNode == null) {
    		return;
    	}//fi
    	   	    	
    	replaceVal(currNode.left, currNode.val, currLv+1);
    	replaceVal(currNode.right, currNode.val, currLv+1);
    	
    	currNode.val = lvSumArr[currLv] - siblingVal;
    	
    	return;
    }//end method
}//end class



 