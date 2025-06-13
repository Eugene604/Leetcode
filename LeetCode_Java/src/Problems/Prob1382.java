package Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1382 {
	
	

	
	public static void test() {
		Solution1382 sol = new Solution1382();
		
		Integer[] treeArr;
		TreeNode root;
		TreeNode newRoot;
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[1,null,2,null,3,null,4,null,null]", Integer[].class);
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            newRoot = sol.balanceBST(root);
            TreeUtils.displayTree(newRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1382 {
	
	List<Integer> nodeValList;
	
    public TreeNode balanceBST(TreeNode root) {
    	nodeValList = new ArrayList<>();
    	flattenTree(root);
    	
    	
        return buildBSTFromList(0, nodeValList.size()-1);
    }//end method
    
    /**
     * Traverses the tree in an in-order manner and flattens it into a list.
     * 
     * precondition:
     * - it is assumed that nodeValList is available and instantiated 
     * @param node - TreeNode, the root of the tree to be flattened. If the node is null, the method returns immediately.
     */
    private void flattenTree(TreeNode node) {
    	if (node == null) {
    		return;
    	}//fi
    	
    	flattenTree(node.left);
    	nodeValList.add(node.val);
    	flattenTree(node.right);
    }//end method

    /**
     * Builds a balanced BST from the values in nodeValList within the specified range.
     * 
     * precondition:
     * - nodeValList is available and valid
     * - start and end indices are valid
     * @param startInx - int, the start index of the sublist from nodeValList to be used for building the BST.
     * @param endInx - int, the end index of the sublist from nodeValList to be used for building the BST.
     * @return
     */
    private TreeNode buildBSTFromList(int startInx, int endInx) {
    	TreeNode node = new TreeNode();
    	//base cases:
    	if (startInx == endInx) {
    		node.val = nodeValList.get(startInx);
    		return node;
    	} else if (endInx - startInx == 1) {
    		node.val = nodeValList.get(startInx);
    		node.right = new TreeNode(nodeValList.get(endInx));
    		return node;
    	}//fi
    	
    	
    	int midInx = (startInx + endInx)/2;
    	node.val = nodeValList.get(midInx);
    	node.right = buildBSTFromList(midInx+1, endInx);
    	node.left = buildBSTFromList(startInx, midInx-1);
    	return node;
    }
}//end class



 