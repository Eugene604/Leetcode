package Problems;

import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1026 {
	
	private static Integer[] treeArr1 = {8,3,10,1,6,null,14,null,null,4,7,13};
	private static Integer[] treeArr2 = {1,null,2,null,0,3};
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
		Solution1026 sol = new Solution1026();
		TreeNode root;

		root = buildTree(treeArr1);
		TreeUtils.displayTree(root);
		System.out.println("max diff: " + sol.maxAncestorDiff(root));
		
		root = buildTree(treeArr2);
		TreeUtils.displayTree(root);
		System.out.println("max diff: " + sol.maxAncestorDiff(root));
		
		root = buildTree(treeArr3);
		TreeUtils.displayTree(root);
		System.out.println("max diff: " + sol.maxAncestorDiff(root));
		//*/	
	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1026 {
		
	int maxPosDiff;
	int maxNegDiff;

    public int maxAncestorDiff(TreeNode root) {
    	maxPosDiff = 0;
    	maxNegDiff = 0;
    	findDiffs(root, root.val, root.val);
        return Math.max(maxPosDiff, -maxNegDiff);
    }//end method
    

    /**
     * Recursively traverse the tree and update max positive and negative differences.
     * 
     * Preconditions:
     * - global variables maxPosDiff & maxNegDiff are present and initialized.
     * 
     * @param node - TreeNode
     * @param maxAncestorVal - int, current highest node value along the path
     * @param minAncestorVal - int, current lowest node value along the path
     */
    private void findDiffs(TreeNode node, int maxAncestorVal, int minAncestorVal) {
    	//base case, node is null
    	if (node == null) {
    		return;
    	}//fi
    	
    	if (node.val >= maxAncestorVal) {
    		maxAncestorVal = node.val;
    		maxNegDiff = Math.min(maxNegDiff, minAncestorVal - node.val);
    	} else if (node.val < minAncestorVal) {
    		minAncestorVal = node.val;
    		maxPosDiff = Math.max(maxPosDiff, maxAncestorVal - node.val);
    	} else {
    		// do nothing, max diffs only change when encountering local maxima or minima
    	}//fi
    	findDiffs(node.left, maxAncestorVal, minAncestorVal);
    	findDiffs(node.right, maxAncestorVal, minAncestorVal);    	
    }//end method
}//end class

class Solution1026_v2 {
	
	static final int DECLINING = 1;
	static final int INCLINING = -1;
	
	int maxDiff;

    public int maxAncestorDiff(TreeNode root) {
    	this.maxDiff = Integer.MIN_VALUE;
    	int[] initParamArr = {
    	Integer.MIN_VALUE,
    	Integer.MIN_VALUE,
    	Integer.MAX_VALUE,
    	Integer.MAX_VALUE,};

    	
    	TreeNode leftChild = root.left;
    	TreeNode rightChild = root.right;
    	int diff;
    	int[] paramArr;
    	if (leftChild != null) {
    		diff = root.val - leftChild.val;
    		paramArr = Arrays.copyOf(initParamArr, 5);
    		if (diff < 0) { // incline situation
    			paramArr[4] = INCLINING;
    			paramArr[2] = diff;
    			paramArr[3] = root.val;
    		} else { // decline situation
    			paramArr[4] = DECLINING;
    			paramArr[0] = diff;
    			paramArr[1] = root.val;
    		}
    		findDiffs(paramArr, leftChild);
    	}//fi
    	if (rightChild != null) {
    		diff = root.val - rightChild.val;
    		paramArr = Arrays.copyOf(initParamArr, 5);
    		if (diff < 0) { // incline situation
    			paramArr[4] = INCLINING;
    			paramArr[2] = diff;
    			paramArr[3] = root.val;
    		} else { // decline situation
    			paramArr[4] = DECLINING;
    			paramArr[0] = diff;
    			paramArr[1] = root.val;
    		}
    		findDiffs(paramArr, rightChild);   		
    	}
        return maxDiff;
    }
    
    /**
     * recursively find for max incline and max decline of this path
     * @param prevParamArr parameter int array <br>
     * 			index 0 - stores current maximum decline difference (decline definition: ancestor - descendant > 0) <br>
     * 			index 1 - stores current highest point (highest node value along the path up to current node) <br>
     * 			index 2 - stores current maximum incline difference (incline definition: ancestor - descendant < 0) <br>
     * 			index 3 - stores current lowest point (lowest node value along the path up to current node)<br>  
     * 			index 4 - Sloping trend. DECLINING or INCLINING. Default is DECLINING when slope is horizontal at root (but subsequent horizontal situation does not alter trend)
     * @param node TreeNode 
     */
    private void findDiffs(int[] prevParamArr, TreeNode node) {
       	TreeNode leftChild = node.left;
    	TreeNode rightChild = node.right;
    	int diff, sameSlopeDiff;
    	int[] paramArr;
    	if (leftChild == null && rightChild == null) {
			/* case 0: tail node reached
			 * 
			 */
    		prevParamArr[2] *= -1;
    		//System.out.println(node.val + " node, diffs: " + prevParamArr[0] + " : " + prevParamArr[2]);
    		maxDiff = prevParamArr[0] > maxDiff ? prevParamArr[0] : maxDiff;
    		maxDiff = prevParamArr[2] > maxDiff ? prevParamArr[2] : maxDiff;
    		return;
    	}
    	if (leftChild != null) {
    		diff = node.val - leftChild.val;    		
    		if (diff == 0){
    			/* case 1: Horizontal situation
    			 *  /\
    			 * /  \___ <- here
    			 */
    			findDiffs(prevParamArr, leftChild);
    		} else if(diff < 0) { 
    			/* case 2: Incline situation
    			 *   /\
    			 *  /  \  / <- case 2-1
    			 * /    \/  <- case 2-2
    			 */
    			paramArr = Arrays.copyOf(prevParamArr, 5);
    			if (prevParamArr[4] == DECLINING) { //case 2-2 slope direction has just changed
    				if (node.val < paramArr[3]) { //current node value is lower than previous lowest point
    					paramArr[3] = node.val;
    				}
    			}//fi do nothing for case 2-1, which means that slope direction remains same
				sameSlopeDiff = paramArr[3] - leftChild.val;
				if (sameSlopeDiff < paramArr[2]) {
					paramArr[2] = sameSlopeDiff;
				}//fi
    			paramArr[4] = INCLINING;
    			findDiffs(paramArr, leftChild);
    		} else { // decline situation
    			/* case 3: Decline situation
    			 *  /\  <- case 3-1
    			 * /  \ <- case 3-2
    			 */
    			paramArr = Arrays.copyOf(prevParamArr, 5);
    			if (prevParamArr[4] == INCLINING) { //case 3-1 slope direction has just changed
    				if (node.val > paramArr[1]) { //current node value is higher than previous highest point
    					paramArr[1] = node.val;
    				}
    			}//fi do nothing for case 3-2, which means that slope direction remains same    
				sameSlopeDiff = paramArr[1] - leftChild.val;
				if (sameSlopeDiff > paramArr[0]) {
					paramArr[0] = sameSlopeDiff;
				}//fi
    			paramArr[4] = DECLINING;
    			findDiffs(paramArr, leftChild);
    		}
    		
    	}//fi left child
    	if (rightChild != null) {
    		diff = node.val - rightChild.val;    		
    		if (diff == 0){
    			/* case 1: Horizontal situation
    			 *  /\
    			 * /  \___ <- here
    			 */
    			findDiffs(prevParamArr, rightChild);
    		} else if(diff < 0) { 
    			/* case 2: Incline situation
    			 *   /\
    			 *  /  \  / <- case 2-1
    			 * /    \/  <- case 2-2
    			 */
    			paramArr = Arrays.copyOf(prevParamArr, 5);
    			if (prevParamArr[4] == DECLINING) { //case 2-2 slope direction has just changed    				
    				if (node.val < paramArr[3]) { //current node value is lower than previous lowest point
    					paramArr[3] = node.val;
    				}
    			}//fi do nothing for case 2-1, which means that slope direction remains same
				sameSlopeDiff = paramArr[3] - rightChild.val;
				if (sameSlopeDiff < paramArr[2]) {
					paramArr[2] = sameSlopeDiff;
				}//fi
    			paramArr[4] = INCLINING;
    			findDiffs(paramArr, rightChild);
    		} else { // decline situation
    			/* case 3: Decline situation
    			 *  /\  <- case 3-1
    			 * /  \ <- case 3-2
    			 */
    			paramArr = Arrays.copyOf(prevParamArr, 5);
    			if (prevParamArr[4] == INCLINING) { //case 3-1 slope direction has just changed
    				if (node.val > paramArr[1]) { //current node value is higher than previous highest point
    					paramArr[1] = node.val;
    				}
    			}//fi do nothing for case 3-2, which means that slope direction remains same    
				sameSlopeDiff = paramArr[1] - rightChild.val;
				if (sameSlopeDiff > paramArr[0]) {
					paramArr[0] = sameSlopeDiff;
				}//fi
    			paramArr[4] = DECLINING;
    			findDiffs(paramArr, rightChild);
    		}
    	}//fi right child
    }//end method
}//end class



 