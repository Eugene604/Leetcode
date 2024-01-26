package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1930 {
	

	
	public static void test() {
		int a=1;
		int b=2;

		Solution1930 sol = new Solution1930();
		String str;
		
		str = "aabca";
		System.out.println("ans: " + sol.countPalindromicSubsequence(str) + " str: " + str);
			

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1930 {
	/*
	 * last occurrence index arrays
	 * array index - ASCII code value of the character
	 * array element value - index of the character's first appearance in the string 
	 */
	static int[] lastOccurInxArr;
	
	/*
	 * Set that records current active side character
	 * for a 3-char palindrome 'aba', 'a' is side character  , b is center character
	 */
	static Set<Character> sideCharSet;
	
	/*
	 * first (outer array) index - side character value
	 * second (inner array) index - center character value
	 * example, an occurrence of 'aba', palindromeCount['a']['b'] will be incremented
	 */
	static int[][] palindromeCount;// = new int[123][123];
	
    public int countPalindromicSubsequence(String s) {
    	//step 1, initialize and prepare required data structures    	    	
    	lastOccurInxArr = new int[123];
    	char[] strCharArr = s.toCharArray();
    	Set<Character> occurSet = new HashSet<>();
    	for (int i=strCharArr.length-1; i>0 && occurSet.size()<26; i--) {
    		if (lastOccurInxArr[strCharArr[i]] == 0) {
    			lastOccurInxArr[strCharArr[i]]=i;
    			occurSet.add(strCharArr[i]);
    		}//fi    		
    	}//rof
    	sideCharSet = new HashSet<>();
		if (0!=lastOccurInxArr[strCharArr[0]]) {
			sideCharSet.add(strCharArr[0]);
		}//fi
    	palindromeCount = new int[123][123];
    	int count = 0;
    	
    	//step 2, traverse through string again and populate 3-char palindrome occurrence count
    	for (int i=1; i<strCharArr.length; i++) {
    		if (i==lastOccurInxArr[strCharArr[i]]) {
    			sideCharSet.remove(strCharArr[i]);
    		}//fi
    		for (Character sideChar:sideCharSet) {
    			if (palindromeCount[sideChar][strCharArr[i]]==0) {
    				palindromeCount[sideChar][strCharArr[i]]=1;
    				count++;
    			}//fi
    		}//rof    
    		if (i!=lastOccurInxArr[strCharArr[i]]) {
    			sideCharSet.add(strCharArr[i]);
    		}//fi
    	}//rof
    	
    	//step 3, sum all occurrence

    	/*
    	for (int i=97; i<123; i++) {
    		for (int j=97; j<123; j++) {
    			count += palindromeCount[i][j];
    		}//rof
    	}//rof */

        return count;
    }//end method
	
}//end class
