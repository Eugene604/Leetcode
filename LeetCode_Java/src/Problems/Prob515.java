package Problems;

import java.util.*;


import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob515 {
	
	private static Integer[] treeArr1 = {1,3,2,5,3,null,9};
	private static Integer[] treeArr2 = {1,2,3};
	private static Integer[] treeArr3 = {2,null,0,null,4,null,3,null,1};
	
	
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
		Solution515 sol = new Solution515();
		
		TreeNode tree1 = buildTree(treeArr1);
		TreeUtils.displayTree(tree1);
		System.out.println("list: " + sol.largestValues(tree1)); 

	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution515 {
	
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> ansList = new ArrayList<>(10);
    	    	
    	//special case root is null
    	if (root == null) {
    		return ansList;
    	}//fi
    	
    	//step 1: add root node to the queue and initialize node queue
    	Deque<TreeNode> nodeQueue = new ArrayDeque<>(512);
    	nodeQueue.add(root);
    	int currRowCount = 1, nextRowCount = 0;
    	int currMax = Integer.MIN_VALUE;
    	TreeNode currNode;
    	while (currRowCount!=0 || nextRowCount !=0) {
    		//System.out.println("deque: " + nodeQueue);
    		if (currRowCount == 0) {//current row nodes have been scanned, store the max value and go to next row
    			ansList.add(currMax);
    			currMax = Integer.MIN_VALUE;
    			currRowCount = nextRowCount;
    			nextRowCount = 0;
    		} else {
    			currNode = nodeQueue.pollFirst();    			
    			currRowCount--;
    			if (currMax<currNode.val) {
    				currMax = currNode.val;
    			}//fi
    	    	if (currNode.left != null) {
    	    		nodeQueue.addLast(currNode.left);
    	    		nextRowCount++;
    	    	}//fi
    	    	if (currNode.right != null) {
    	    		nodeQueue.addLast(currNode.right);
    	    		nextRowCount++;
    	    	}//fi
    		}//fi
    	}//end while
    	ansList.add(currMax);
        return ansList;
    }//end method
}//end class



 