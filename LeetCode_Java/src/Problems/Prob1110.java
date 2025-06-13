package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1110 {
	
	

	
	public static void test() {
		Solution1110 sol = new Solution1110();
		
		Integer[] treeArr;
		int[] to_delete;
		TreeNode root;
		List<TreeNode> ansList;
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[1,2,3,4,5,6,7]", Integer[].class);
            to_delete = mapper.readValue("[3,5]", int[].class);
            root = TreeUtils.buildTree(treeArr);
            ansList = sol.delNodes(root, to_delete);
            TreeUtils.displayTree(ansList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1110 {
	Set<Integer> deleteSet;
	List<TreeNode> ansList;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	deleteSet = new HashSet<>();
    	for (int nodeID:to_delete) {
    		deleteSet.add(nodeID);
    	}//rof
    	ansList = new ArrayList<>();
    	
    	if (deleteSet.contains(root.val)) {
    		deleteSet.remove(root.val);
    		traverse(root, true);
    	} else {
    		ansList.add(root);
    		traverse(root, false);
    	}//fi
    	
		
		
        return ansList;
    }//end method
    
    /**
     * precondition:
     * - deleteSet is available and valid
     * @param node - TreeNode
     * @param isToBeDeleted - whether the node at current iteration should be deleted or not
     */
    void traverse(TreeNode currNode, boolean isDeleteCurrNode) {
    	
    	if (currNode.left != null) {    	
	    	if (deleteSet.contains(currNode.left.val)) {
	    		deleteSet.remove(currNode.left.val);
	    		traverse(currNode.left, true);
	    		currNode.left = null;	    		
	    	} else  {
	    		traverse(currNode.left, false);
	    		if (isDeleteCurrNode) {
	    			ansList.add(currNode.left);
	    		}//fi
	    	}//fi
    	}//fi
    	
    	if (currNode.right != null) {    	
	    	if (deleteSet.contains(currNode.right.val)) {
	    		deleteSet.remove(currNode.right.val);
	    		traverse(currNode.right, true);
	    		currNode.right = null;	    		
	    	} else  {
	    		traverse(currNode.right, false);
	    		if (isDeleteCurrNode) {
	    			ansList.add(currNode.right);
	    		}//fi
	    	}//fi
    	}//fi
    }//end method
}//end class



 