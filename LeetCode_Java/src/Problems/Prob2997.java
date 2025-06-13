package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2997 {


	
	private static void test() {
		
		Solution2997 solObj = new Solution2997();
		int[] nums;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
    			//*/
            
            nums = mapper.readValue("[2,1,3,4]", int[].class);
    		k = 1;
    		System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("Ans: " + solObj.minOperations(nums, k));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2997 {
    public int minOperations(int[] nums, int k) {
    	int xorResult = nums[0];
    	for (int i=1; i< nums.length; i++) {
    		xorResult ^= nums[i];
    	}//rof
    	
    	//System.out.println("xorResult: " + xorResult);
    	
    	xorResult ^= k;
    	//System.out.println("xorResult: " + xorResult);
    	
    	int numOfOps = 0;
    	for (int i=0; i<32; i++) {
    		if (xorResult%2 == 1) {
    			numOfOps++;
    		}//fi
    		xorResult>>=1;
    	}//rof
        return numOfOps;
    }//end method
}//end class
