package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob1903 {
	

	
	public static void test() {

		Solution1903 solObj = new Solution1903();

		String num;

	
		
		String num1 = "6777133339";
		String num2 = "2300019";
		String num3 = "42352338";
		

		num = num1;
		System.out.println(num + " ans: " + solObj.largestOddNumber(num1));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1903 {

    public String largestOddNumber(String num) {
    	int i;
    	for (i = num.length()-1; i>=0; i--) {
    		if (num.charAt(i)%2==1) {
    			break;
    		}//fi
    	}//rof
    	return num.substring(0, i+1);
    }//end method   
}//end class
