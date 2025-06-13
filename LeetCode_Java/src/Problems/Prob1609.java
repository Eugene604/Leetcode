package Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1609 {
	
	private static Integer[] treeArr1 = {1,10,4,3,null,7,9,12,8,6,null,null,2};
	private static Integer[] treeArr2 = {5,4,2,3,3,7};
	private static Integer[] treeArr3 = {5,9,1,3,5,7};

	
	
	public static void test() {
		Solution1609 sol = new Solution1609();
		TreeNode tree;
		
	
		tree = TreeUtils.buildTree(treeArr1);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.isEvenOddTree(tree));
		
		
		tree = TreeUtils.buildTree(treeArr2);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.isEvenOddTree(tree));
		
		tree = TreeUtils.buildTree(treeArr3);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.isEvenOddTree(tree));
		//*/
	}
	
	public static void main(String[] args) {
		//System.out.println("test: " + 1023/2);
		test();
	}

}

class Solution1609 {
	static final int INIT_ODD_PREVNUM = Integer.MAX_VALUE;
	static final int INIT_EVEN_PREVNUM = Integer.MIN_VALUE;
	public boolean isEvenOddTree(TreeNode root) {
		//step 1, setup variables for bfs
		Deque<TreeNode> nodeQueue = new ArrayDeque<>();
		int level = 0;
		nodeQueue.offer(root);
		int numOfNodes;
		int prevNum = INIT_EVEN_PREVNUM;
		TreeNode currNode;
		while(!nodeQueue.isEmpty()) {			
			for (numOfNodes = nodeQueue.size(); numOfNodes > 0; numOfNodes--) {
				currNode = nodeQueue.poll();
				if (isEven(level + currNode.val)) {
					//System.out.println("false at 1 : " + currNode.val);
					return false;
				}//fi				
				if (currNode.val == prevNum || (isEven(level)^(currNode.val>prevNum))) {
					//System.out.println("false at 2 : " + currNode.val);
					return false;
				}//fi
				prevNum = currNode.val;
				if (currNode.left!=null) {
					nodeQueue.offer(currNode.left);
				}//fi
				if (currNode.right!=null) {
					nodeQueue.offer(currNode.right);
				}//fi				
			}//rof
			level++;
			if (isEven(level)) {
				prevNum = INIT_EVEN_PREVNUM;
			} else {
				prevNum = INIT_ODD_PREVNUM;
			}//fi
		}//end while
		
		
        return true;
    }//end method
	
	/**
	 * Check if value is even
	 * @param val - int
	 * @return true if the value is even
	 */
	private boolean isEven(int val) {		
		return val%2 == 0;
	}//fi
	
}//end class



 