package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1404 {
	

	
	public static void test() {
		Solution1404 sol = new Solution1404();
		String s;
		s = "1101";
		System.out.println(s + " ans: " + sol.numSteps(s));
	}//end method
	
	
	
	public static void main(String[] args) {
		
		test();
	}//end method
	
}

class Solution1404 {

    public int numSteps(String s) {
    	int numOfSteps = 0;
    	boolean hasOverflow = false;
    	int lenMinusOne = s.length()-1;
    	
    	//step 1, calculate number of steps due to addition
    	for (int i=lenMinusOne; i>0; i--) {
    		if (s.charAt(i) == '1' && !hasOverflow) {
    			numOfSteps++;
    			hasOverflow = true;
    		} else if (s.charAt(i) == '1' && hasOverflow) {
    			//do nothing
    		} else if (s.charAt(i) == '0' && !hasOverflow) {
    			//do nothing
    		} else if (s.charAt(i) == '0' && hasOverflow) {
    			numOfSteps++;
    		}//fi
    	}//rof
    	
    	if (hasOverflow) {
    		numOfSteps++;
    	}//fi
    	
    	//step 2, calculate number of division steps
    	numOfSteps += lenMinusOne;
    	
        return numOfSteps;
    }//method
}//end class
