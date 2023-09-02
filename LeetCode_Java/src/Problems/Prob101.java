package Problems;

import java.util.ArrayList;
import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob101 {
	
	private static Integer[] treeArr1 = {8,3,10,1,6,null,14,null,null,4,7,13};
	private static Integer[] treeArr2 = {1,null,2,null,0,3};
	private static Integer[] treeArr3 = {2,null,0,null,4,null,3,null,1};
	private static Integer[] treeArr4 = {1,2,2,3,4,4,3};
	private static Integer[] treeArr5 = {1,2,2,2,null,2};
	
	
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
		Solution101 sol = new Solution101();
		TreeNode tree;
		
		/*
		tree = buildTree(treeArr1);
		TreeUtils.displayTree(tree);
		System.out.println("isSymmetric: " + sol.isSymmetric(tree)); 
		tree = buildTree(treeArr2);
		TreeUtils.displayTree(tree);
		System.out.println("isSymmetric: " + sol.isSymmetric(tree)); 
		tree = buildTree(treeArr3);
		TreeUtils.displayTree(tree);
		System.out.println("isSymmetric: " + sol.isSymmetric(tree)); //*/ 	
		tree = buildTree(treeArr4);
		TreeUtils.displayTree(tree);
		System.out.println("isSymmetric: " + sol.isSymmetric(tree)); 	
		
		tree = buildTree(treeArr5);
		TreeUtils.displayTree(tree);
		System.out.println("isSymmetric: " + sol.isSymmetric(tree));
	}
	
	public static void main(String[] args) {
		//System.out.println("test: " + 1023/2);
		test();
	}

}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
    	
    	if (root == null) {
    		return true;
    	}//fi
    	
    	ArrayList<Integer> leftTravesalList = new ArrayList<>();
    	ArrayList<Integer> rightTravesalList = new ArrayList<>();
    	
    	//step 1, put trees inside integer array in in-order
    	buildLeftTravesalList(root.left, leftTravesalList);
    	buildRightTravesalList(root.right, rightTravesalList);
    	
    	//System.out.println("leftTravesalList: " + leftTravesalList);
    	//System.out.println("rightTravesalList: " + rightTravesalList);
    	//step 2, check if array is symmetric
    	return leftTravesalList.equals(rightTravesalList);
    }//end method
    
 
    
    /**
     *  travel tree recursively and put node values in in-order into given list
     * @param root  reference to node object
     * @param list  the array list that stores tree node values
     */
    private void buildLeftTravesalList(TreeNode root, ArrayList<Integer> list) {
    	if (root == null) {
    		list.add(null);
    		return; 
    	}//fi
    	list.add(Integer.MAX_VALUE);
    	buildLeftTravesalList(root.left, list);
    	list.add(root.val);
    	list.add(Integer.MIN_VALUE);
    	buildLeftTravesalList(root.right, list);
    }//end method
    
    /**
     *  travel tree recursively and put node values in mirrored in-order into given list
     * @param root  reference to node object
     * @param list  the array list that stores tree node values
     */
    private void buildRightTravesalList(TreeNode root, ArrayList<Integer> list) {
    	if (root == null) {
    		list.add(null);
    		return; 
    	}//fi
    	list.add(Integer.MAX_VALUE);
    	buildRightTravesalList(root.right, list);    	
    	list.add(root.val);
    	list.add(Integer.MIN_VALUE);
    	buildRightTravesalList(root.left, list);
    }//end method
}



 