package Problems;

import java.util.Arrays;

public class Prob214 {

	private static void test() {
		String s;

		Solution214 solObj = new Solution214();
		
		
		s = "abxab";
		System.out.println("s: " + s);
		System.out.println("ans: " + solObj.shortestPalindrome(s));
	}
	
	
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution214 {
	
    public String shortestPalindrome(String s) {
    	
    	//edge case:
    	if (s.length()<2) {
    		return s;
    	}//fi 
    	
    	byte[] patArr = s.getBytes();
    	byte[] revStrArr = new byte[s.length()];
    	int firstMatchInx;
    	
    	//step 1, build reverse string code array, pattern = original string
    	for (int inx=s.length()-1, revInx = 0; inx>=0; inx--, revInx++) {
    		revStrArr[revInx] = patArr[inx];
    	}//rof
    	
    	
    	
    	//step 2, use reverse string code array as the text array to be matched and original code array as pattern
    	firstMatchInx = getFirstPrefixMatchingInx(revStrArr, patArr);
    	
    	//step 3, build shortest palindrome based on the calculated info
    	StringBuilder palSB = new StringBuilder();
    	
    	for (int i=0; i<firstMatchInx; i++) {
    		palSB.append((char)revStrArr[i]);
    	}//rof
    	
    	for (int i=0; i<patArr.length; i++) {
    		palSB.append((char)patArr[i]);
    	}//rof   	
    	

		//System.out.println("firstMatchInx:" + firstMatchInx + " palSB:" + palSB.toString());
    	
    	return palSB.toString();
    }//end method

    /**
     * This method finds the first index in the `strArr` (which is the reversed string)
     * where the prefix of `patArr` (the original string) matches. It uses the KMP algorithm
     * for partial pattern matching to find the index efficiently.
     *
     * Precondition:
     * - It is assumed that `strArr` length == `patArr` length in this particular system.
     *
     * @param strArr - byte[], The byte array representing the reversed string (text to search in).
     * @param patArr - byte[], The byte array representing the original string (pattern to search for).
     * @return The starting index in `strArr` where the longest prefix of `patArr` matches.
     *         If no match is found, the method will return the index where the pattern search stops.
     */
	public int getFirstPrefixMatchingInx(byte[] strArr, byte[] patArr) {
		//System.out.println("rev Str:" + Arrays.toString(strArr) + " pat:" + Arrays.toString(patArr));
		
		int[] lpsArr = new int[patArr.length];
		
		//step 1, build LPS
    	int lpsLength = 0;
		int patInx = 1;
		lpsArr[0] = 0;
		while (patInx < patArr.length) {			
			if (patArr[patInx] == patArr[lpsLength]) {				
				lpsLength++;
				lpsArr[patInx] = lpsLength;
				patInx++;
			} else if (lpsLength > 0){
				lpsLength = lpsArr[lpsLength-1];
			} else {
				lpsArr[patInx] = 0;
				patInx++;
			}//fi
		}//rof
		
		//step 2, do partial pattern matching using lps
		int strInx = 0;
		patInx = 0;
		do {
			//System.out.println("iteration: strInx=" + strInx + " patInx="+patInx);
			if (strArr[strInx] == patArr[patInx]) {
				patInx++;
				strInx++;
				if (strInx == strArr.length) {
					//System.out.println("return from here 1, strInx:" + strInx + " patInx:" + patInx);
					return strInx-patInx;
				}//fi				
			} else if (patInx > 0){
				patInx = lpsArr[patInx-1];				
			} else {
				patInx = 0;
				strInx++;
			}//fi
		} while (strInx < strArr.length);//end do while
		//System.out.println("return from here 2");
		return strInx;
	}//end method
}//end class
