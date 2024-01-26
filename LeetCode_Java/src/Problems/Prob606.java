package Problems;

import java.util.*;


import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob606 {
	
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
		Solution606 sol = new Solution606();
		
		TreeNode tree1 = buildTree(treeArr1);
		TreeUtils.displayTree(tree1);
		System.out.println("ans: " + sol.tree2str(tree1)); 

	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution606 {
	
	private static StringBuilder gSB; //global string builder
	private enum State{ROOT, LEFT, RIGHT};
	
    public String tree2str(TreeNode root) {
    	gSB =  new StringBuilder();
    	inOrderPrint(root, State.ROOT);
        return gSB.toString();
    }//end method
    
    /**
     * print tree content to global string builder
     * precondition:
     * - required printer is instantiated and valid - gSB
     * postcondition:
     * - node content is appended to the string builder
     * @param root - TreeNode
     * @param state - State, ROOT = root, LEFT = left child, RIGHT = right child
     */
    private void inOrderPrint(TreeNode node, State state) {
    	//special case, node is null
    	if (node == null) {
    		if (state == State.LEFT) {
    			gSB.append("()");
    		}//fi
    		return;
    	}//fi
    	
		if (state != State.ROOT) {
			gSB.append('(');
		}//fi
    	gSB.append(node.val);
    	
    	if (node.left != null || node.right != null) {		    		
    		inOrderPrint(node.left, State.LEFT);
    		inOrderPrint(node.right, State.RIGHT);
    	}//fi
    	
		if (state != State.ROOT) {
			gSB.append(')');
		}//fi
		
    }//end method
}//end class



 