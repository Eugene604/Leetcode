package Problems;

import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob2265 {
	
	private static Integer[] treeArr1 = {4,8,5,0,1,null,6};
	private static Integer[] treeArr2 = {1};
	
	
	
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
		Solution2265 sol = new Solution2265();
		
		TreeNode tree;
		
		tree = buildTree(treeArr1);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.averageOfSubtree(tree)); 
	
		
		tree = buildTree(treeArr2);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.averageOfSubtree(tree)); 
	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution2265 {
	
	private static final int SUM_VAL_BIT = 20;
	private static final int SUM_VAL_MASK = 0b11_111_111_111_111_111_111;
	private static final int UNIT_NODE_COUNT = 0b100_000_000_000_000_000_000;
	private int nodesEqASCount;
	public int averageOfSubtree(TreeNode root) {
		nodesEqASCount = 0;
		traverseAndPopulate(root);
        return nodesEqASCount;
    }//method
	
	/**
	 * traverse and populate the statistics of each subtree in post-order
	 * preconditions: 
	 * required variables are properly set - SUM_VAL_BIT, SUM_VAL_MASK
	 * does NOT not check the validity of the above constants
	 *
	 * @param root - TreeNode
	 * @return int - contains the stat. last SUM_VAL_BIT bits are used to store sum of this subtree, remaining bits are to store # of nodes
	 */
	private int traverseAndPopulate(TreeNode root) {		
		//base case, root is null
		if (root == null) {
			return 0;
		}//fi
		
		int stat = UNIT_NODE_COUNT + root.val;		
		stat += traverseAndPopulate(root.left);
		stat += traverseAndPopulate(root.right);
		
		int numOfNodes = stat>>SUM_VAL_BIT;
		int sumOfNodes = stat&SUM_VAL_MASK;
		
		if (root.val == (sumOfNodes/numOfNodes) ) {
			nodesEqASCount++;
		}//ri
		
		return stat;
	}//end method
    
    

}//end class



 