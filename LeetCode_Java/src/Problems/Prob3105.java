package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob3105{

	
	public static void main(String[] args) {
		Solution3105 solObj = new Solution3105();
		int[] nums ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            nums  = mapper.readValue("[1,4,3,3,2]", int[].class);
      		System.out.println("nums : " + Arrays.toString(nums ));
    		System.out.println("Ans: " + solObj.longestMonotonicSubarray(nums));
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution3105{
	
    public int longestMonotonicSubarray(int[] nums) {
    	int longestLen = 1;
    	int currDecLen = 1;
    	int currIncLen = 1;
    	for (int i=1; i< nums.length; i++) {
    		if (nums[i] == nums[i-1]) {
    			currDecLen = 1;
    	    	currIncLen = 1;
    		} else if (nums[i] > nums[i-1]) {
    			currIncLen++;
    			currDecLen = 1;
    			longestLen = Math.max(currIncLen, longestLen);
    		} else if (nums[i] < nums[i-1]) {	
    			currIncLen = 1;
    			currDecLen++;
    			longestLen = Math.max(currDecLen, longestLen);
    		}
    	}
    	return longestLen;
    }//end method
}//end class

