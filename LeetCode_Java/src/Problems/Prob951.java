package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob951 {
	
	

	
	public static void test() {
		Solution951 sol = new Solution951();
		
		Integer[] treeArr1, treeArr2;
		TreeNode root1, root2;
	

		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr1 = mapper.readValue("[1,2,3,4,5,6,null,null,null,7,8]", Integer[].class);
            treeArr2 = mapper.readValue("[1,3,2,null,6,4,5,null,null,null,null,8,7]", Integer[].class);
        
            
            root1 = TreeUtils.buildTree(treeArr1);
            TreeUtils.displayTree(root1);
            
            root2 = TreeUtils.buildTree(treeArr2);
            TreeUtils.displayTree(root2);
            
            sol.flipEquiv(root1, root2);

        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution951 {
	
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    	//base cases
    	if (root1 == null && root2 == null) {//both are null
    		return true;
    	} else if (root1 == null) {//one of nodes is null
    		return false;
    	} else if (root2 == null) {//one of nodes is null
    		return false;
    	} else if (root2.val != root1.val) {//node values are not equal
    		return false;
    	}//fi
    	
    	if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
    		return true;
    	} else if (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right)) {
    		return true;    		
    	}//fi
        return false;
    }//end method
    
}//end class



 