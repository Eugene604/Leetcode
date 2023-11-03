package Problems;

import java.util.*;

public class Prob5 {
	
	public static String str0 = "cdbbfc";
	public static String str1 = "abcabcbb";
	public static String str2 = "bbbbb";
	public static String str3 = "pwwkew";
	public static String str4 = "cbbd";
	public static String str5 = "b";
	public static String str6 = "";	
	public static String str7 = "ccd";
	public static String str8 = "babad"; 
	
	
	public static void test() {

		Solution5 sol = new Solution5();


		
		System.out.println(sol.longestPalindrome(str0));
		System.out.println(sol.longestPalindrome(str1));	
		System.out.println(sol.longestPalindrome(str2));	
		System.out.println(sol.longestPalindrome(str3));	
		System.out.println(sol.longestPalindrome(str4)); 		
		System.out.println(sol.longestPalindrome(str5));	
		System.out.println(sol.longestPalindrome(str6));
		System.out.println(sol.longestPalindrome(str7));	
		System.out.println(sol.longestPalindrome(str8));	//*/
		System.out.println(sol.longestPalindrome(str0));
	}//end method
	
	
	public static void main(String[] args) {
		test();
	}//end method

}

class Solution5 {
	private int[][] palindromCache;
	
    public String longestPalindrome(String str) {
    	
    	//base case, str length is 1
    	if (str.length() < 2) {
    		return str;
    	}//fi
    	palindromCache = new int[str.length()][str.length()];
    	int currLInx = 0, currRInx = 1, currMaxGap = 1;
    	int currLPInx = 0, currRPInx = 0;
    	boolean isPrevPalidromic = false;    	
    	while (currLInx + currMaxGap < str.length()) {
    		if (isPalindromic(str, currLInx, currRInx)) {
				currLPInx = currLInx;
				currRPInx = currRInx;
				currMaxGap = currRInx - currLInx;
    		}//fi
			if (currRInx == str.length()-1) {		
				currLInx++;
				currRInx = currLInx + currMaxGap;						
			} else {
				currRInx++;	
			}//fi
    	}//end while    	
    	//System.out.println("currLPInx: " + currLPInx + " currRPInx: " + currRPInx + " charCompCache: " + Arrays.deepToString(palindromCache));
    	return str.substring(currLPInx, currRPInx+1);
    }//end method
    
	/**
	 * Check if given string section is palindromic
	 * Precondition:
	 * - assume start index and end inx are valid
	 * - required data structure is instantiated
	 * @param str - String, the underlying string
	 * @param startInx - int value that represents starting index, must be > 0
	 * @param endInx - int that represents right most inx
	 * @return true if section is palindromic
	 */
	private boolean isPalindromic(String str, int startInx, int endInx) {
		
		int lInx = startInx;
		int rInx = endInx;
		while (lInx <= rInx) {
			//System.out.println("checking: " + lInx + " : " + rInx);		
			if (palindromCache[lInx][rInx]!=0) {
				if (palindromCache[lInx][rInx]==1) {
					//System.out.println("used 1");
					palindromCache[startInx][endInx] = 1;
					return true;
				} else {
					//System.out.println("used 2");
					return false;
				}//fi
			} else if (str.charAt(lInx) != str.charAt(rInx)) {
				palindromCache[lInx][rInx] = 2;
				return false;
			}//fi 
			lInx++;
			rInx--;
		}//end while
		palindromCache[startInx][endInx] = 1;
		return true;
	}//end method
}//end class

class Solution5_v2 {

    public String longestPalindrome(String str) {
    	if (str.length() < 2) {
    		return str;
    	}
    	byte[] charArr = str.getBytes();
    	int currLPInx = 0, currLPLength = 0;
    	for (int currInx = 0; currInx < charArr.length && currLPLength < charArr.length - currInx; currInx++) {    		
    		//System.out.println("one: " + (charArr.length - currInx) + " : " + (currLPLength+1));
    		for (int l = charArr.length - currInx;  l > currLPLength; l--) {
    			if (isPalindromic(charArr, currInx, l)) {
    				currLPInx = currInx;
    				currLPLength = l;
    				break;
    			}//fi
    		}//rof
    	}//rof
    	
        return new String(charArr, currLPInx, currLPLength);
    	//return str.substring(currLPInx, currLPInx+currLPLength);
    }
    
	/**
	 * Check if given array section is palindromic
	 * @param charArr byte array that represents underlying string
	 * @param startInx starting index, must be > 0
	 * @param length length of the section
	 * @return true if section is palindromic
	 */
	private boolean isPalindromic(byte[] charArr, int startInx, int length) {
		
		int reverseStartInx = startInx + length - 1;
		for (int i = 0; i < length; i++) {
			if (charArr[startInx + i] != charArr[reverseStartInx - i]) {
				return false;
			}//fi
		}//rof
		return true;
	}//end method
}//end class
