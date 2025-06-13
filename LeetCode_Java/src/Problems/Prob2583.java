package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob2583 {
	
	

	
	public static void test() {
		Solution2583 sol = new Solution2583();
		
		Integer[] treeArr;
		TreeNode root;
		int k;

		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[5,8,9,2,1,3,7,4,6]", Integer[].class);
            k = 2;
            
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            System.out.println("ans: " + sol.kthLargestLevelSum(root, k));
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution2583 {
	static final int MAX_LEVEL = 100_000;
	long[] lvSumArr;
    public long kthLargestLevelSum(TreeNode root, int k) {
    	
    	//step 1: populate level sum    	
    	lvSumArr = new long[MAX_LEVEL+1];    	
    	populateSum(root, 1);
    	//System.out.println("lvsumarr: " + Arrays.toString(lvSumArr));
    	//special case: not enough level
    	if (lvSumArr[k] == 0) {
    		return -1;
    	}//fi

    	
    	//step 2: push every level sum into priority queue
    	PriorityQueue<Long> maxSumQueue = new PriorityQueue<>((a,b) -> Long.compare(b, a));
    	for (int i=1; i<=MAX_LEVEL && lvSumArr[i] > 0; i++) {
    		maxSumQueue.offer(lvSumArr[i]);
    	}//rof
    	
    	
    	//step 3: get kth largest sum
    	while (k > 1) {
    		maxSumQueue.poll();
    		k--;
    	}//end while
    	    	
    	
    	return maxSumQueue.peek();
    }//end method
    
    /**
     * preconditions:
     * -lvSumArr is initialized
     * 
     * @param currNode - TreeNode, 
     * @param currLv - int,
     */
    private void populateSum(TreeNode currNode, int currLv) {
    	//base case: node is null
    	if (currNode == null) {
    		return;
    	}//fi
    	lvSumArr[currLv] += currNode.val;
    	
    	populateSum(currNode.left, currLv+1);
    	populateSum(currNode.right, currLv+1);
    }//end method
    
    
}//end class



 