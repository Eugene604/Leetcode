package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob3068 {


	
	private static void test() {
		
		Solution3068 solObj = new Solution3068();
		

		int[] nums;
		int[][] edges;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            nums = mapper.readValue("[1,2,1]", int[].class);
            edges = mapper.readValue("[[0,1],[0,2]]", int[][].class);
            k = 3;
     
       		System.out.println("Ans: " + solObj.maximumValueSum(nums, k,  edges) );

    
       		/*
       		
            
   			// */
            
      
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

/**
 * Explaination:
 * So, my technique is based on the idea that in a tree, you can flip (i.e., XOR with k) any pair of nodes, whether they are directly connected or not. This is due to the XOR property and the fact that there's exactly one path between any two nodes in a tree. That means any two nodes can be flipped together using the edges, and since each operation flips both ends, the number of nodes being flipped must always be even.
 * Next, I try flipping every node individually to see if its value increases. If flipping a node increases its value, that¡¦s very good ¡X I keep it, and I also track the least increment, in case I need to sacrifice one later. If the number of such beneficial flips is even, then we don¡¦t even need to touch the nodes where flipping would decrease their value ¡X we can just ignore them completely.
 * But if the number of nodes flipped is odd, that means I need to either undo one of the beneficial flips or add a new flip from the ¡§bad¡¨ nodes to make the count even. So in my program, I also track the least decrement node ¡X this is the one I¡¦m willing to sacrifice if needed. Then I compare the gain from flipping the least increment node versus the loss from flipping the least decrement node. Whichever costs less ¡X either undoing a weak flip or taking a mild hit ¡X that¡¦s the one I go with to balance the parity.
 */
class Solution3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
    	int xorCnt = 0;
    	int leastIncrementDiffInx = 0, leastDecrementInx = -1;
    	int diff;
    	int leastIncrementDiff = Integer.MAX_VALUE;
    	int leastDecrementDiff = Integer.MAX_VALUE;
    	int xoredVal;
    	for (int i=0; i<nums.length; i++) {
    		xoredVal = nums[i] ^ k;
    		diff = xoredVal - nums[i];
    		if (diff > 0) { //result in higher value if xored with K
    			xorCnt++;
    			nums[i] = xoredVal;
    			if (diff < leastIncrementDiff) {
    				leastIncrementDiffInx = i;
    				leastIncrementDiff = diff;
    			}//fi
    		} else { //result in less value if xored with K			
    			if (-diff < leastDecrementDiff) {
    				leastDecrementDiff = -diff;
    				leastDecrementInx = i;
    			}//fi
    		}//fi
    	}//rof
    	
    	if (xorCnt%2 == 1) {
    		if (leastDecrementInx == -1 || leastDecrementDiff > leastIncrementDiff) {
    			nums[leastIncrementDiffInx] -= leastIncrementDiff;
    		} else {    			
    			nums[leastDecrementInx] -= leastDecrementDiff;
    		}//rof
    		    		
    	}//fi
    	long sum = 0;
    	
    	for (int num:nums) {
    		sum+=num;
    	}//rof
    	
        return sum;
    }//end method
}//end class
