package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob3151{

	
	public static void main(String[] args) {
		Solution3151 solObj = new Solution3151();
		int[] nums ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            nums  = mapper.readValue("[1]", int[].class);
      		System.out.println("nums : " + Arrays.toString(nums ));
    		System.out.println("Ans: " + solObj.isArraySpecial(nums));
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution3151{
	
    public boolean isArraySpecial(int[] nums) {
    	int prevParity = 2;
    	int currParity;
    	for (int num:nums) {
    		currParity = num%2;
    		if (prevParity == currParity) {
    			return false;
    		} else {
    			prevParity = currParity;
    		}//fi
    	}//rof
    	return true;
    }//end method
}//end class

