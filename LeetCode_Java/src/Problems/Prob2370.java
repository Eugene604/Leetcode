package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob2370 {
	static String str1 = "acfgbd";
	static String str2 = "abcd";
	static String str3 = "edukt";
	static String str4 = "aaaaaaaaagjawjpajfejpjjjjjjjjjjglwlwelewlaaaaaaaaaalfewjjklwejklwekjlmvowhjfwheahwuehuwwaa";
	static String str5 = "aaaaaaaaaabcaaaaaaaaaaefxxxxxyxxxx";
	static String str6 = "hphs";
	private static void test() {
		Solution2370 solObj = new Solution2370();
		CorrectSolution2370 correctSol = new CorrectSolution2370();
		String testStr;
		int k;
		
		testStr = str6; 
		k = 15;
		System.out.println("Str: " + testStr);
		System.out.println("ans: " + solObj.longestIdealString(testStr,k));
		System.out.println("correct ans: " + correctSol.longestIdealString(testStr,k));
		
		/*
		testStr = str1; 
		k = 2;			
		System.out.println("Str: " + testStr);
		System.out.println("ans: " + solObj.longestIdealString(testStr,k));
		System.out.println("correct ans: " + correctSol.longestIdealString(testStr,k));
		
	  	//*/
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2370 {

    public int longestIdealString(String s, int k) {
    	//index - index of char code, value - longest ideal ending with this under constraint k 
    	int[] charLISArr = new int[123];
    	int globalMaxLength = 1; 
    	int localMaxLength, tmpLength;
    	int minArrInx, maxArrInx;
    	for (int i=0; i<s.length(); i++) {
    		localMaxLength = -1;    	    	
    		minArrInx = Math.max(97, s.codePointAt(i)-k);
    		maxArrInx = Math.min(122, s.codePointAt(i)+k);    		
    		for (int arrInx=minArrInx; arrInx<=maxArrInx; arrInx++) {
    			tmpLength = charLISArr[arrInx]+1;
    			localMaxLength = Math.max(localMaxLength, tmpLength);
    		}//rof
    		charLISArr[s.codePointAt(i)] = localMaxLength;
    		globalMaxLength = Math.max(localMaxLength, globalMaxLength);    		
    	}//rof
        return globalMaxLength;
    }//end method
}//end class

class Solution2370_v2 {

    public int longestIdealString(String s, int k) {
    	//index - index of string, value - longest ideal at this index with constraint k and the character at this index must be included
    	int[] lisArr = new int[s.length()];
    	lisArr[0] = 1;
    	int globalMaxLength = 1; 
    	int localMaxLength, tmpLength;
    	for (int i=1; i<s.length(); i++) {
    		localMaxLength = -1;
    		//for (int j=i-1; j>=0 && j>=localMaxLength; j--) {
    		for (int j=i-1; j>=0 && j+1>=localMaxLength; j--) {
    			if (Math.abs(s.codePointAt(i)-s.codePointAt(j))<=k) {
    				tmpLength = lisArr[j]+1;
    				localMaxLength = Math.max(localMaxLength, tmpLength);
    			}//fi
    		}//rof
    		if (localMaxLength == -1) {
    			localMaxLength = 1;
    		}//fi
    		lisArr[i] = localMaxLength;
    		globalMaxLength = Math.max(localMaxLength, globalMaxLength);
    	}//rof
        return globalMaxLength;
    }//end method
}//end class



class CorrectSolution2370 {
    
    public int longestIdealString(String s, int k) {
        
        int[] dp = new int[27];
        int n = s.length();
        
        for(int i = n-1; i >= 0 ;i--){
            char cc = s.charAt(i);
            int idx = cc - 'a';
            int max  = Integer.MIN_VALUE;
            
            int left = Math.max((idx-k), 0);
            int right = Math.min((idx + k), 26);
            
            for(int j = left; j <= right ; j++){
                max = Math.max(max, dp[j]);
            }
            
            dp[idx] = max+1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int ele : dp){
            max = Math.max(ele, max);
        }
        
        return max;
    }
}