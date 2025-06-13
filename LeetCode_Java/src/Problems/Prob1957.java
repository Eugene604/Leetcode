package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob1957 {
	

	
	public static void test() {

		Solution1957 solObj = new Solution1957();

		String s;
		

		s = "leeetcode";
		System.out.println(" ans: " + solObj.makeFancyString(s));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1957 {
    public String makeFancyString(String s) {
    	StringBuilder sb = new StringBuilder();
    	char prevChr = ' ';
    	char currChr;
    	boolean shouldIgnore = false;
    	for (int i=0; i<s.length(); i++) {    		
    		currChr = s.charAt(i);
    		if (currChr != prevChr) {
    			sb.append(currChr);
    			prevChr = currChr;
    			shouldIgnore = false;
    		} else if (shouldIgnore){
    			//do nothing
    		} else {
    			sb.append(currChr);
    			shouldIgnore = true;
    		}//fi
    	}//rof
        return sb.toString();
    }//end method   
}//end class
