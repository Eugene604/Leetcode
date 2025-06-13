package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob1752{

	
	public static void main(String[] args) {
		Solution1752 solObj = new Solution1752();
		int[] nums ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            nums  = mapper.readValue("[3,4,5,1,2]", int[].class);
      		System.out.println("nums : " + Arrays.toString(nums ));
    		System.out.println("Ans: " + solObj.check(nums));
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution1752{
	
    public boolean check(int[] nums) {
    	boolean hasBrokenOnce = false;
    	for (int i=1; i< nums.length; i++) {
    		if (nums[i] < nums[i-1]) {
    			if (hasBrokenOnce) {
    				return false;
    			} else if (nums[0] < nums[nums.length-1]) {
    				return false;
    			}//fi
    			hasBrokenOnce = true;
    		}//end method
    	}
    	return true;
    }//end method
}//end class

