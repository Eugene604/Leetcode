package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob14 {
	

	
	public static void test() {
		Solution14 sol = new Solution14();
		String[] strs;
		String[] str1 = {"flower","flow","flight"};
		strs = str1;
		System.out.println("lcp of " + Arrays.toString(strs) + " : " + sol.longestCommonPrefix(strs));
		String[] str2 = {"dog","racecar","car"};
		strs = str2;
		System.out.println("lcp of " + Arrays.toString(strs) + " : " + sol.longestCommonPrefix(strs));		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution14 {
    public String longestCommonPrefix(String[] strArr) {
    	StringBuilder lcpSB = new StringBuilder();
    	int strArrLength = strArr.length;
    	char currChar;
    	for (int c = 0; c < 200; c++ ) {
			if (c >= strArr[0].length()) {
				return lcpSB.toString();
			}//fi
			currChar = strArr[0].charAt(c);
    		for (int i = 1; i < strArrLength; i++) {
    			if (c >= strArr[i].length()) {
    				return lcpSB.toString();
    			} else if (currChar != strArr[i].charAt(c)) {
    				return lcpSB.toString();
    			}//fi
    		}//end array index loop
    		lcpSB.append(currChar);
    	}//end string character loop
    	return lcpSB.toString();
    }//end method
}//end class
