package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob3174 {
	

	
	public static void test() {

		Solution3174 solObj = new Solution3174();

		String s;

	
		
		s = "abc";
		System.out.println(s + " ans: " + solObj.clearDigits(s));


		
		s = "aa66";
		System.out.println(s + " ans: " + solObj.clearDigits(s));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution3174 {

    public String clearDigits(String s) {
    	StringBuilder sb = new StringBuilder();
    	int sbLen = 0;
    	for (int i=0; i<s.length(); i++) {
    		if (s.charAt(i)<64) {
    			sbLen = Math.max(0, sbLen-1);
    			sb.setLength(sbLen);
    		} else {
    			sb.append(s.charAt(i));
    			sbLen++;
    		}//fi
    	}//rof
        return sb.toString();
    }//end method   
}//end class
