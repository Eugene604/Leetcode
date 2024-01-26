package Problems;

import java.util.*;

import Utils.MatrixUtils;

public class Prob1143{
	

	
	public static void test() {

		Solution1143 sol = new Solution1143();
		Solution1143_v2 correctSol = new Solution1143_v2();
		String text1, text2;
		
	
		/*
		text1 = "abcde"; 
		text2 = "ace";
		System.out.println("ans: " + sol.longestCommonSubsequence(text1,text2));
		
		
		text1 = "abcde"; 
		text2 = "abcde";
		System.out.println("ans: " + sol.longestCommonSubsequence(text1,text2));
		

		text1 = "abc"; 
		text2 = "def";
		System.out.println("ans: " + sol.longestCommonSubsequence(text1,text2));
		
		//*/
		

		text1 = "xtx"; 
		text2 = "tqq";
		System.out.println("ans: " + sol.longestCommonSubsequence(text1,text2));
		System.out.println("correct ans: " + correctSol.longestCommonSubsequence(text1,text2));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1143{	


	
    public int longestCommonSubsequence(String text1, String text2) {
    	//step 1, set up cache and txt reference also setup base cases
    	String lTxt, sTxt;
    	if (text1.length() > text2.length()) {
    		lTxt = text1;
    		sTxt = text2;
    	} else {
    		lTxt = text2;
    		sTxt = text1;
    	}//fi
    	
    	int[] lcsCache = new int[lTxt.length()];
    	
    	//step 2, populate cache at sTxt at index 0
    	for (int j=0; j<lTxt.length(); j++) {
        	if (sTxt.charAt(0) == lTxt.charAt(j)) {     		
        		Arrays.fill(lcsCache, j, lTxt.length(), 1);
        		break; 		
        	}//fi
		}//rof
    	
    	
    	//step 3, populate cache at rest of sTxt, deal with lTxt at 0 first
    	int upperLeftElement, nextCandidateUpperLeftElement;
    	for (int i=1; i<sTxt.length(); i++) {
    		upperLeftElement = lcsCache[0];
    		if (lcsCache[0] == 1 || sTxt.charAt(i) == lTxt.charAt(0)) {
    			lcsCache[0] = 1;
    		}//fi
    		
    		for (int j=1; j<lTxt.length(); j++) {
    			nextCandidateUpperLeftElement = lcsCache[j];
            	if (sTxt.charAt(i) == lTxt.charAt(j)) {                 		
            		lcsCache[j] = 1+upperLeftElement;
            	} else {
            		lcsCache[j] = Math.max(lcsCache[j-1], lcsCache[j]);    		
            	}//fi    
            	upperLeftElement = nextCandidateUpperLeftElement;
    		}//rof

    	}//rof
    	
    	
    	return lcsCache[lTxt.length()-1];
    }//end method
    


}//end class




class Solution1143_v2{	


	
    public int longestCommonSubsequence(String text1, String text2) {
    	//step 1, set up cache and txt reference also setup base cases
    	String lTxt, sTxt;
    	if (text1.length() >= text2.length()) {
    		lTxt = text1;
    		sTxt = text2;
    	} else {
    		lTxt = text2;
    		sTxt = text1;
    	}//fi
    	
    	int[][] lcsCache = new int[sTxt.length()][lTxt.length()];
    	
    	//step 2, populate cache at sTxt at index 0
    	for (int j=0; j<lTxt.length(); j++) {
        	if (sTxt.charAt(0) == lTxt.charAt(j)) {     		
        		Arrays.fill(lcsCache[0], j, lTxt.length(), 1);
        		break; 		
        	}//fi
		}//rof
    	
    	//step 3, populate cache at rest of sTxt, deal with lTxt at 0 first
    	for (int i=1; i<sTxt.length(); i++) {
    		if (lcsCache[i-1][0] == 1 || sTxt.charAt(i) == lTxt.charAt(0)) {
    			lcsCache[i][0] = 1;
    		}//fi

    		for (int j=1; j<lTxt.length(); j++) {
    			
            	if (sTxt.charAt(i) == lTxt.charAt(j)) {                 		
            		lcsCache[i][j] = 1+lcsCache[i-1][j-1];
            	} else {
            		lcsCache[i][j] = Math.max(lcsCache[i][j-1], lcsCache[i-1][j]);    		
            	}//fi            
    		}//rof

    	}//rof
    	
    	
    	//MatrixUtils.displayMatrix(lcsCache);
    	return lcsCache[sTxt.length()-1][lTxt.length()-1];
    }//end method
    


}//end class

