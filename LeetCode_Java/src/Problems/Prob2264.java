package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob2264 {
	

	
	public static void test() {

		Solution2264 solObj = new Solution2264();

		String num;

	
		
		String num1 = "6777133339";
		String num2 = "2300019";
		String num3 = "42352338";
		

		num = num1;
		System.out.println(num + " ans: " + solObj.largestGoodInteger(num1));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution2264 {

    public String largestGoodInteger(String num) {
    	int charRepeat = 0;
    	char lastIntChar = '.';    	
    	char maxGoodIntChar = '.';
    	for (char c:num.toCharArray()) {
    		if (c == lastIntChar) {    			
    			if ((++charRepeat)==2) {
    				maxGoodIntChar = c>maxGoodIntChar? c : maxGoodIntChar;
    			}//fi
    		} else {
    			lastIntChar = c;
    			charRepeat = 0;    			
    		}//fi
    	}//rof
    	if (maxGoodIntChar == '.') {
    		return "";
    	} else {    		
    		return new StringBuilder().append(maxGoodIntChar).append(maxGoodIntChar).append(maxGoodIntChar).toString();
    	}//fi        
    }//end method   
}//end class
