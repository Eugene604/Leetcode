package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob2196 {
	
	

	
	public static void test() {
		Solution2196 sol = new Solution2196();
		
		int[][] descriptions;
		TreeNode root;
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            descriptions = mapper.readValue(" [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]", int[][].class);
            
            root = sol.createBinaryTree(descriptions);
            TreeUtils.displayTree(root);
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution2196 {
	
    public TreeNode createBinaryTree(int[][] descriptions) {
    	//key: node val, value: tree node object
    	Map<Integer, TreeNode> nodeMap = new HashMap<>();
    	//key: child node value (id), value: its parent's value (id)
    	Map<Integer, Integer> parentMap = new HashMap<>();
    	TreeNode parent, child;
    	for (int[] description:descriptions) {
    		parent = nodeMap.get(description[0]);
    		if (parent == null) {
    			parent = new TreeNode(description[0]);
    			nodeMap.put(description[0], parent);
    		}//fi
    		child = nodeMap.get(description[1]);
    		if (child == null) {
    			child = new TreeNode(description[1]);
    			nodeMap.put(description[1], child);
    		}//fi
    		
    		if (description[2]==0) {
    			parent.right = child;
    		} else {
    			parent.left = child;
    		}//fi
    		
    		parentMap.put(child.val, parent.val);
    		
    	}//rof
    	Integer nodeID = descriptions[0][0];
    	Integer parentID;
    	while ((parentID = parentMap.get(nodeID)) != null) {
    		nodeID = parentID;
    	}//end while
    	
        return nodeMap.get(nodeID);
    }//end method
}//end class



 