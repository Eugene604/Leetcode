package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

public class Prob3264 {

	
	
	static void test() {
		Solution3264 solObj = new Solution3264();
		int[] nums;
		int k, multiplier;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            nums = mapper.readValue("[2,1,3,5,6]", int[].class);
            k=5;
            multiplier=2;
            System.out.println("nums: " + Arrays.toString(nums));
    		System.out.println(" ans: " + Arrays.toString(solObj.getFinalState(nums, k, multiplier)));
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		/*		
		 
		 
		  //*/
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution3264 {
	
    public int[] getFinalState(int[] nums, int k, int multiplier) {
    	
    	PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> 
		{
    	    if (a[0] == b[0]) {
    	        return a[1] - b[1];
    	    } else {
    	    	return a[0] - b[0];
    	    }
		});
    	
    	for (int i=0; i<nums.length; i++) {
    		minQueue.offer(new int[] {nums[i], i});
    	}//rof
    	
    	int[] infoTuple;
    	for (; k>0; k--) {
    		infoTuple = minQueue.poll();
    		infoTuple[0] *= multiplier;
    		nums[infoTuple[1]] = infoTuple[0];
    		minQueue.offer(infoTuple);
    	}
    	
        return nums;
    }//end method   
}//end class
