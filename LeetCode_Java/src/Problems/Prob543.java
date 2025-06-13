package Problems;

import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob543 {
	
	private static Integer[] treeArr1 = {1,2,3,4,5};
	private static Integer[] treeArr2 = {1,null,2,null,0,3};
	private static Integer[] treeArr3 = {2,null,0,null,4,null,3,null,1};
	
	

	

	
	public static void test() {
		Solution543 sol = new Solution543();
		TreeNode root;

		root = TreeUtils.buildTree(treeArr1);
		TreeUtils.displayTree(root);
		System.out.println("max dia: " + sol.diameterOfBinaryTree(root));
		
		
		//*/	
	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution543 {
	
	int globalMaxDiameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		globalMaxDiameter = 0;
		getLongestChainAndUpdateDiameter(root);		
        return globalMaxDiameter;
    }//end method
	
	/**
	 * Determine the longest possible chain from node to any of its leaf also update diameter
	 * precondition:
	 * - it is assumed that node is not null
	 * - global variable globalMaxDiameter is present and initalized
	 * @param node - TreeNode, the starting node
	 * @return int, longest chain length. [node 1] - [node 2] is treated as length 1
	 */
	private int getLongestChainAndUpdateDiameter(TreeNode node) {
		int leftBranch=0, rightBranch=0;
		if (node.left != null) {
			leftBranch = 1+getLongestChainAndUpdateDiameter(node.left);
		}//fi
		
		if (node.right != null) {
			rightBranch = 1+getLongestChainAndUpdateDiameter(node.right);
		}//fi		
		globalMaxDiameter = Math.max(globalMaxDiameter, leftBranch + rightBranch);
		return Math.max(leftBranch, rightBranch);
	}//end method
}//end class



class Solution543_v2 {
	
	int globalMaxDiameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		int leftBranchLength = 0, rightBranchLength = 0;
				
		if (root.left != null) {
			leftBranchLength = 1+longestChain(root.left);
			//System.out.println("leftBranchLength: " + leftBranchLength);
			diameterOfBinaryTree(root.left);			
		}//fi
		
		if (root.right != null) {
			rightBranchLength = 1+longestChain(root.right);
			//System.out.println("rightBranchLength: " + rightBranchLength);
			diameterOfBinaryTree(root.right);			
		}//fi	
					
		globalMaxDiameter = Math.max(globalMaxDiameter, leftBranchLength + rightBranchLength);
		
        return globalMaxDiameter;
    }//end method
	
	/**
	 * Determine the longest possible chain from node to any of its leaf
	 * precondition:
	 * it is assumed that node is not null
	 * @param node - TreeNode, the starting node
	 * @return int, longest chain length. [node 1] - [node 2] is treated as length 1
	 */
	private int longestChain(TreeNode node) {
		int length=0;
		if (node.left != null) {
			length = 1+longestChain(node.left);
		}//fi
		
		if (node.right != null) {
			length = Math.max(length, 1+longestChain(node.right));
		}//fi		
		return length;
	}//end method
}//end class
 