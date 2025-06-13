package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob1800{

	
	public static void main(String[] args) {
		Solution1800 solObj = new Solution1800();
		int[] nums ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            nums  = mapper.readValue("[10,20,30,5,10,50]", int[].class);
      		System.out.println("nums : " + Arrays.toString(nums ));
    		System.out.println("Ans: " + solObj.maxAscendingSum(nums));
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution1800{
	
    public int maxAscendingSum(int[] nums) {
    	int maxSum = 0;
    	int currSum = nums[0];
    	for (int i=1; i<nums.length; i++) {
    		if (nums[i] > nums[i-1]) {
    			currSum += nums[i];
    		} else {
    			maxSum = Math.max(maxSum, currSum);
    			currSum = nums[i];
    		}//fi
    	}//rof
        return maxSum = Math.max(maxSum, currSum);
    }//end method
}//end class

