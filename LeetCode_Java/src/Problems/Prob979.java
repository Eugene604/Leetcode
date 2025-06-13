package Problems;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob979 {
	
	private static Integer[] treeArr1 = {3,0,0};
	private static Integer[] treeArr2 = {1,null,2,null,0,3};
	private static Integer[] treeArr3 = {2,null,0,null,4,null,3,null,1};
	
	

	
	public static void test() {
		Solution979 sol = new Solution979();
		TreeNode root;
		
		root = TreeUtils.buildTree(treeArr1);
		TreeUtils.displayTree(root);
		System.out.println("ans: " + sol.distributeCoins(root));
		
		//*/	
	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution979 {
	
	int moveCount;
	
    public int distributeCoins(TreeNode root) {
    	moveCount = 0;
    	populateCoinDist(root);
        return moveCount;
    }//end method
    
    /**
	 * Traverses the tree and calculates the coin distribution.
	 * This method recursively processes each node, computes the surplus or deficit of coins, and
	 * accumulates the total movements required to balance the coins across the entire tree.
	 *
     * preconditions:
     * -global variable moveCount is available and initialized
     * 
     * @param node - TreeNode, the tree node in question
     * @return int, indicates amount of coins this branch can give out (positive number) or require (negative number)
     */
    private int populateCoinDist(TreeNode node) {
    	
    	if (node == null) {
    		return 0;
    	}//fi
    	
    	int currCoinSurplus = node.val - 1;
    	int leftCoinSurplus = populateCoinDist(node.left);
    	int rightCoinSurplus = populateCoinDist(node.right);
    	
    	int netCoinSurplus = currCoinSurplus + leftCoinSurplus + rightCoinSurplus;
    	
    	moveCount += Math.abs(leftCoinSurplus);
    	moveCount += Math.abs(rightCoinSurplus);
    	
    	
    	return netCoinSurplus;
    }//end method
}//end class



 