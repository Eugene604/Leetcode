package Problems;

import java.util.*;


import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob94 {
	
	private static Integer[] treeArr1 = {1,3,2,5,3,null,9};
	private static Integer[] treeArr2 = {1,2,3};
	private static Integer[] treeArr3 = {2,null,0,null,4,null,3,null,1};
	private static Integer[] treeArr4 = {1,null,2,3};
	
	static TreeNode buildTree(Integer[] arr) {
		int arrL = arr.length;
		TreeNode[] treeArr = new TreeNode[arrL];
		for (int i = 0; i < arrL; i++) {
			if (arr[i] != null) {
				treeArr[i] = new TreeNode(arr[i]);
			}
		}
		int currNodeInx, lastAccessedNodeInx;
		
		for (currNodeInx = 0, lastAccessedNodeInx = 1; lastAccessedNodeInx < arrL; currNodeInx++) {
			try {

				treeArr[currNodeInx].left = treeArr[lastAccessedNodeInx];
				//System.out.println(currNodeInx + " L:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;

				treeArr[currNodeInx].right = treeArr[lastAccessedNodeInx];
				//System.out.println(currNodeInx + " R:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			} catch (NullPointerException e) {
				continue;
			}
		}//rof	
		
		return treeArr[0];
	}
	

	
	public static void test() {
		Solution94 sol = new Solution94();
		
		TreeNode tree = buildTree(treeArr4);
		TreeUtils.displayTree(tree);
		System.out.println("list: " + sol.inorderTraversal(tree)); 

	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution94 {
	
	private List<Integer> ansList;
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	ansList = new ArrayList<>(100);
    	traverseInOrder(root);    	   
        return ansList;
    }//end method
    
    /**
     * recursively traverse tree in order and put val into list
     * precondition:
     * required global variable(s) is instantiated - ansList     
     * 
     * @param node - TreeNode, 
     */
    private void traverseInOrder(TreeNode node) {
    	if (node == null) {
    		return;
    	}//fi
    	traverseInOrder(node.left);
    	ansList.add(node.val);
    	traverseInOrder(node.right);
    }//end method
}//end class



 