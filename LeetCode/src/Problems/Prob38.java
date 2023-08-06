package Problems;

import java.util.*;



public class Prob38 {
	
	static void test() {
		System.out.println("test starts");
		Solution38 solObj = new Solution38();
		int n;

		
		n=8;
		System.out.println("n: " + n + " : " + solObj.countAndSay(n));
		
		n=3;
		System.out.println("n: " + n + " : " + solObj.countAndSay(n));
		

		n=2;
		System.out.println("n: " + n + " : " + solObj.countAndSay(n));
 
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution38 {
	public static String[] dpArr = new String[31];
	static {
		dpArr[1] = "1";
		dpArr[2] = "11";
		dpArr[3] = "21";
		dpArr[4] = "1211";
		dpArr[5] = "111221";
		dpArr[6] = "312211";
	}//end static block
	
	/**
	 * Precondition:
	 *  - dynamic programming array has value at least at position 1
	 *  - assumes 1 <= n <= 30
	 * @param n int , only accepts input 1 <= n <= 30
	 * @return String that is the count-and-say sequence at n
	 */
    public String countAndSay(int n) {
    	if (dpArr[n] != null) {
    		return dpArr[n]; 
    	}//fi
    	StringBuilder sb = new StringBuilder();
    	String prevStr = countAndSay(n-1);
    	char currChar = 0, prevChar = prevStr.charAt(0);
    	int count = 1;
    	for (int i = 1; i < prevStr.length(); i++) {    		
    		currChar = prevStr.charAt(i);
    		if (currChar == prevChar) {
    			count++;
    			continue;
    		} else {
    			sb.append(count);
    			sb.append(prevChar);
    			count = 1;
    			prevChar = currChar;
    		}//fi
    	}//rof
		sb.append(count);
		sb.append(currChar);	
    	String ansStr = sb.toString();
    	dpArr[n] = ansStr;
    	return ansStr;
    }//end method
}//end class


