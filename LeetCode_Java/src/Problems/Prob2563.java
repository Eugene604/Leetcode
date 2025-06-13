package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2563{


	
	private static void test() {
		
		Solution2563 solObj = new Solution2563();
		
		int[] nums;
		int lower, upper;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            nums = mapper.readValue("[0,1,7,4,4,5]", int[].class);
            lower = 3;
            upper = 6;
            Arrays.sort(nums);
       		System.out.println("Arr: " + Arrays.toString(nums));
       		System.out.println("Ans: " + solObj.countFairPairs(nums, lower, upper));
      
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

class Solution2563{
	
    public long countFairPairs(int[] nums, int lower, int upper) {
    	Arrays.sort(nums);
    	long pairCnt = 0;
    	int rightLowerBnd, rightUpperBnd;
    	int rightLowerInx, rightUpperInx;
    	for (int leftInx = 0; leftInx < nums.length-1; leftInx++) {
    		//get lower bound of right index
    		rightLowerBnd = lower - nums[leftInx];
    		rightLowerInx = Arrays.binarySearch(nums, leftInx + 1, nums.length, rightLowerBnd);
    		if (rightLowerInx < -nums.length) {//everything is less than lower bound
    			continue;
    		} else if (rightLowerInx < 0) {
    			rightLowerInx = -(rightLowerInx+1);
    		} else {
    			for (;rightLowerInx-1 > leftInx && nums[rightLowerInx-1] == rightLowerBnd; rightLowerInx--) {};
    		}//fi
    		//System.out.println("rightLowerInx: " + rightLowerInx);
    		
    		//get upper bound of right index
    		rightUpperBnd = upper - nums[leftInx];
    		rightUpperInx = Arrays.binarySearch(nums, leftInx + 1, nums.length, rightUpperBnd);
    		if (rightUpperInx == -(leftInx + 1)) {//everything is greater than upper bound
    			continue;
    		} else if (rightUpperInx < 0) {
    			rightUpperInx = -(rightUpperInx+1)-1;
    		} else {
    			for (;rightUpperInx+1 < nums.length && nums[rightUpperInx+1] == rightUpperBnd; rightUpperInx++) {};
    		}//fi
    		    
    		pairCnt += rightUpperInx - rightLowerInx + 1;
    	}//rof
        return pairCnt;
    }//end method
    
    
}//end class
