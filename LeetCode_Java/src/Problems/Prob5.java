package Problems;

import java.util.*;

public class Prob5 {
	
	public static String str0 = "ac";
	public static String str1 = "abcabcbb";
	public static String str2 = "bbbbb";
	public static String str3 = "pwwkew";
	public static String str4 = "cbbd";
	public static String str5 = "b";
	public static String str6 = "";	
	public static String str7 = "a";
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
	}//end method
	
	
	public static void main(String[] args) {
		test();
	}//end method

}

class Solution5 {

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
	};
}
