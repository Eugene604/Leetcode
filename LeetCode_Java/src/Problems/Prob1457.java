package Problems;

import java.util.Arrays;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1457 {
	
	private static Integer[] treeArr1 = {2,3,1,3,1,null,1};
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
		Solution1457 sol = new Solution1457();
		
		TreeNode tree;
		
		tree = buildTree(treeArr1);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.pseudoPalindromicPaths(tree)); 
	
		
		tree = buildTree(treeArr2);
		TreeUtils.displayTree(tree);
		System.out.println("ans: " + sol.pseudoPalindromicPaths(tree)); 
	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1457 {
	
	static final int[] VAL_BIT_MAP;
	
	static {
		VAL_BIT_MAP = new int[10];
		VAL_BIT_MAP[1] = 0b1;
		VAL_BIT_MAP[2] = 0b10;
		VAL_BIT_MAP[3] = 0b100;
		VAL_BIT_MAP[4] = 0b1000; 
        VAL_BIT_MAP[5] = 0b10000; 
        VAL_BIT_MAP[6] = 0b100000;
        VAL_BIT_MAP[7] = 0b1000000; 
        VAL_BIT_MAP[8] = 0b10000000;
        VAL_BIT_MAP[9] = 0b100000000; 
	}//end static 
	
    public int pseudoPalindromicPaths (TreeNode root) {
        return getPseudoPalinPaths(root, 0);
    }//end method
    
    /**
     * traverse the tree and populate count map
     * @param node - TreeNode, node at current iteration
     * @param cntMap - int, count bit map
     * @return int, number of palindrome paths under this node
     */
    private int getPseudoPalinPaths(TreeNode node, int cntMap) {
    	int valBM = VAL_BIT_MAP[node.val];
    	if ((valBM & cntMap)==0) {//previously even 
    		cntMap += valBM;
    	} else {
    		cntMap -= valBM;
    	}//fi
    	
    	//base case, no children, hence leaf has been reached.
    	if (node.left == null && node.right == null) {
    		if (cntMap == 0) {
    			return 1;
    		} else if (
    			cntMap == VAL_BIT_MAP[1] ||
    			cntMap == VAL_BIT_MAP[2] ||
    			cntMap == VAL_BIT_MAP[3] ||
    			cntMap == VAL_BIT_MAP[4] ||
    			cntMap == VAL_BIT_MAP[5] ||
    			cntMap == VAL_BIT_MAP[6] ||
    			cntMap == VAL_BIT_MAP[7] ||
    			cntMap == VAL_BIT_MAP[8] ||
    			cntMap == VAL_BIT_MAP[9] 
    				) {
    			return 1;
    		} else {
    			return 0;
    		}//fi
    	}//fi
    	
    	int cnt = 0;
    	if (node.left != null) {
    		cnt += getPseudoPalinPaths(node.left, cntMap);
    	}//fi
    	
    	if (node.right != null) {
    		cnt += getPseudoPalinPaths(node.right, cntMap);
    	}//fi
    	return cnt;
    }//end method
    
    

}//end class



 