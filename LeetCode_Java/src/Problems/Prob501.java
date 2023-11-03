package Problems;

import java.util.*;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob501 {

	private static Integer[] treeArr1 = {1,null,2,2};
	private static Integer[] treeArr2 = {0};
	private static Integer[] treeArr3 = {2,1,3};

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
				// System.out.println(currNodeInx + " L:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;

				treeArr[currNodeInx].right = treeArr[lastAccessedNodeInx];
				// System.out.println(currNodeInx + " R:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			} catch (NullPointerException e) {
				continue;
			}
		} // rof

		return treeArr[0];
	}//end method

	public static void test() {
		Solution501 solObj = new Solution501();
		TreeNode tree;
		
		/*
		tree = buildTree(treeArr1);
		TreeUtils.displayTree(tree);
		System.out.println("mode Arr: " + Arrays.toString(solObj.findMode(tree)));
		
		tree = buildTree(treeArr2);
		TreeUtils.displayTree(tree);
		System.out.println("mode Arr: " + Arrays.toString(solObj.findMode(tree)));
		//*/
		
		tree = buildTree(treeArr3);
		TreeUtils.displayTree(tree);
		System.out.println("mode Arr: " + Arrays.toString(solObj.findMode(tree)));
	}

	public static void main(String[] args) {
		test();
	}

}

class Solution501 {
	
	private static int[] stackArr = new int[16384];
	private int currAvailableInx = 0;
	private int currEleVal = Integer.MIN_VALUE;
	private int currEleCount = 0;
	private int currModeFrequency = 0;

	public int[] findMode(TreeNode root) {
		currAvailableInx = 0;
		currEleVal = Integer.MIN_VALUE;
		currEleCount = 0;
		currModeFrequency = 0;
		traverseBST(root);
		return getModeArr();
	}// end method

	/**
	 * traverse the binary search tree and push each node value to the mode stack array
	 * 
	 * @param root - TreeNode
	 */
	private void traverseBST(TreeNode root) {
		if (root == null) {
			return;
		}//fi
		traverseBST(root.left);
		push(root.val);
		traverseBST(root.right);
	}//end method
	
	/**
	 * push element to mode counting stack 
	 * 
	 * precondition:
	 * data structure and variables for mode counting stack are instantiated and prepared 
	 * 
	 * @param val - int value, not equal to Integer.MIN_VALUE
	 */
	private void push(int val) {
		if (val == currEleVal) {
			currEleCount++;
			return;
		}//fi
		
		if (currEleCount == currModeFrequency){
			stackArr[currAvailableInx] = currEleVal;	
			currAvailableInx++;
		} else if (currEleCount > currModeFrequency) {
			stackArr[0] = currEleVal;
			currAvailableInx = 1;		
			currModeFrequency = currEleCount;
		}//fi
		currEleCount = 1;
		currEleVal = val;		
	}//end method
	
	/**
	 * return array of mode values from stack array
	 * postcondition:
	 * temporary stored element value and count will be processed and flushed
	 * @return int[]
	 */
	private int[] getModeArr() {
		if (currEleCount == currModeFrequency){
			stackArr[currAvailableInx] = currEleVal;		
			currAvailableInx++;
		} else if (currEleCount > currModeFrequency) {
			stackArr[0] = currEleVal;
			currAvailableInx = 1;		
			currModeFrequency = currEleCount;
		}//fi
		return Arrays.copyOf(stackArr, currAvailableInx);
	}//end method
	
}// end class
