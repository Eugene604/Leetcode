package Problems;

import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob513 {
	
	private static Integer[] treeArr1 = {2,1,3};
	private static Integer[] treeArr2 = {1,2,3,4,null,5,6,null,null,7};

	

	

	
	public static void test() {
		Solution513 sol = new Solution513();
		TreeNode root;

		root = TreeUtils.buildTree(treeArr1);
		TreeUtils.displayTree(root);
		System.out.println("ans: " + sol.findBottomLeftValue(root));
		
		
		//*/	
	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution513 {
	
	private int deepestLevel;
	private int firstVal;
	public int findBottomLeftValue(TreeNode root) {
		deepestLevel = -1;
		findBottomLeftValue(root, 0);
        return firstVal;
    }//end method
	
	/**
	 * recursively find bottom left value by using post order traversal
	 * precondition:
	 * - assume global variable deepestLevel and firstVal are present and set
	 * @param node - TreeNode
	 * @param level - int
	 */
	private void findBottomLeftValue(TreeNode node, int level) {
		if (node == null) {
			return;
		}//fi

		findBottomLeftValue(node.left, level+1);
		findBottomLeftValue(node.right, level+1);
		
		if (level > deepestLevel) {
			deepestLevel = level;
			firstVal = node.val;
		}//fi
		

	}//end method
}//end class



 