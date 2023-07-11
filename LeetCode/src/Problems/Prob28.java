package Problems;

import java.util.*;

public class Prob28 {
		
	private static void test() {
		String haystack, needle;

		Solution28 solObj = new Solution28();
		
		/*
		haystack = "sadbutsad";
		needle = "sad";
		System.out.println("java implementation: " + haystack.indexOf(needle) + " your: " + solObj.strStr(haystack, needle));
		
		haystack = "ababcabcabababd";
		needle = "ababd";
		System.out.println("java implementation: " + haystack.indexOf(needle) + " your: " + solObj.strStr(haystack, needle));
		//*/
		haystack = "aabaaabaaac";
		needle = "aabaaac";
		System.out.println("pat: " + needle);
		System.out.println("java implementation: " + haystack.indexOf(needle) + " your: " + solObj.strStr(haystack, needle));
	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution28 {

	public int strStr(String haystack, String needle) {
		byte[] str = haystack.getBytes();
		byte[] pat = needle.getBytes();
		int[] lps = new int[pat.length];
		
		//step 1, build lps
		int currLPSInx = 0;
		int currPatInx = 1;
		lps[0] = 0;
		while (currPatInx < pat.length) {
			if (pat[currPatInx] == pat[currLPSInx]) {
				currLPSInx++;
				lps[currPatInx] = currLPSInx;
				currPatInx++;
			} else if (currLPSInx > 0){
				currLPSInx = lps[currLPSInx-1];
			} else {
				lps[currPatInx] = 0;
				currPatInx++;
			}//fi
		}//rof
		
		//step 2, do partial pattern matching using lps
		int strInx = 0;
		currPatInx = 0;
		do {
			if (str[strInx] == pat[currPatInx]) {
				currPatInx++;
				if (currPatInx == pat.length) {
					return strInx-currPatInx+1;
				}//fi
				strInx++;
			} else if (currPatInx > 0){
				currPatInx = lps[currPatInx-1];				
			} else {
				currPatInx = 0;
				strInx++;
			}//fi
		} while (strInx < str.length);//end do while
		//System.out.println("lps: " + Arrays.toString(lps));
		return -1;
	}//end method
}//end class
