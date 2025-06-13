package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob1531 {
	static String str1 = "aaabcccd";
	static String str2 = "aabbaa";
	static String str3 = "011010";
	static String str4 = "aaaaaaaaagjawjpajfejpjjjjjjjjjjglwlwelewlaaaaaaaaaalfewjjklwejklwekjlmvowhjfwheahwuehuwwaa";
	static String str5 = "aaaaaaaaaabcaaaaaaaaaaefxxxxxyxxxx";
	static String str6 = "abcdeeeeeeeeee";
	private static void test() {
		Solution1531 solObj = new Solution1531();
		Solution1531_v3 correctSol = new Solution1531_v3();
		String testStr;
		int k;
		
		testStr = str6; 
		k = 5;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		testStr = str4; //ans: 9
		k = 50;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		/*
		
		testStr = str1;
		k = 2;				
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		
		testStr = str1;
		k = 2;				
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));		
		
		
		testStr = str4;
		k = 2;				
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));		
	

		
		testStr = str5; 
		k = 3;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		testStr = str5; 
		k = 2;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		testStr = str5; 
		k = 1;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
		
		testStr = str5; 
		k = 0;			
		System.out.println("Str: " + testStr + " ans: " + solObj.getLengthOfOptimalCompression(testStr,k));
		System.out.println("correct ans: " + correctSol.getLengthOfOptimalCompression(testStr,k));
	  	//*/
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1531 {
	Integer[][] lengthCache; //[seg id][k]
	int[][] segArr; //[seg id][info], inner info array: 0 = character code, 1 = seg char count, 2 = compressed char cnt so far
	int maxSegInx;
	
    public int getLengthOfOptimalCompression(String s, int k) {    	
    	//step 1, populate segment info
    	segArr = new int[s.length()][2];
    	int currSegInx = 0;
    	segArr[currSegInx][0] = s.codePointAt(0);
    	segArr[currSegInx][1] = 1;
    	for (int i=1; i<s.length(); i++) {
    		if (segArr[currSegInx][0] != s.codePointAt(i)) {
    			currSegInx++;
    			segArr[currSegInx][0] = s.codePointAt(i);
    		}//fi
    		segArr[currSegInx][1]++;
    	}//rof
    	maxSegInx = currSegInx;
    	//System.out.println("segArr: " + Arrays.deepToString(segArr));
    	
    	//step 2, recursively find optimal compression
    	lengthCache = new Integer[101][101];
    	
    	return getOptimalLength(maxSegInx, k);
    }//end method
    
    private int getOptimalLength(int segInx, int k) { 
    	if (lengthCache[segInx][k] != null) {
    		return lengthCache[segInx][k];
    	}//fi
    	
    	//base cases
    	if (segInx == 0) {
    		lengthCache[segInx][k] = getCompressedLength(Math.max(0, segArr[segInx][1]-k));
    		return lengthCache[segInx][k];
    	} else if (k==0) {
    		lengthCache[segInx][k] = getOptimalLength(segInx-1, k) + getCompressedLength(segArr[segInx][1]);
    		return lengthCache[segInx][k];
    	}//fi
    	
    	int currLength, minLength = Integer.MAX_VALUE;

    	//case 1, delete all if possible    
    	if (segArr[segInx][1] <= k) {//in this case, try to reduce to 0
    		currLength = getOptimalLength(segInx-1, k-segArr[segInx][1]);    				
			minLength = Math.min(currLength, minLength);
		}//fi
    	
    	//case 2, keep all if possible
    	int kLeft = k;
    	int currInx = segInx;
    	int combinedCharCnt = 0;    	
    	while (currInx >= 0) {
    		if (segArr[currInx][0] == segArr[segInx][0]) {
    			currLength = (currInx == 0) ? 0 : getOptimalLength(currInx-1, kLeft);
    			combinedCharCnt += segArr[currInx][1];
    			currLength += getCompressedLength(combinedCharCnt);
    			minLength = Math.min(currLength, minLength);
    		} else if (kLeft >= segArr[currInx][1]) {    	
    			kLeft -= segArr[currInx][1];    			
    		} else {
    			break;
    		}//fi
			currInx--;
    	}//end while */

    	//case 3, keep single digit if possible
    	kLeft = k;
    	currInx = segInx;
    	combinedCharCnt = 0;
    	int tensVal;    	
    	while (currInx >= 0) {
    		if (segArr[currInx][0] == segArr[segInx][0]) {     
	    		combinedCharCnt += segArr[currInx][1];
    	    	if ((tensVal = combinedCharCnt - 9) > 0) {    	
	    	    	if (kLeft >= tensVal) {//in this case, try reduce to single digit	    	    		
	    	    		kLeft -= tensVal;
	    	    		currLength = (currInx == 0) ? 0 : getOptimalLength(currInx-1, kLeft);
	    	    		combinedCharCnt = 9;
	    	    		currLength += getCompressedLength(combinedCharCnt);
	    	    		minLength = Math.min(currLength, minLength);
	    	    		currInx--;
	        			continue;
	    	    	} else {
	    	    		break;
	    	    	}//fi
    	    		
    	    	} else { //in this case, combined char count is less than 10
    	    		
    	    		currLength = (currInx == 0) ? 0 : getOptimalLength(currInx-1, kLeft);    	   
    	    		currLength += getCompressedLength(combinedCharCnt);
        			minLength = Math.min(currLength, minLength);
        			currInx--;    			        			
        			continue;
    	    	}//fi
    	    	
    			
    		} else if (kLeft >= segArr[currInx][1]) {    	
    			kLeft -= segArr[currInx][1];
    		} else {
    			break;
    		}//fi
		
    	}//end while */

    	lengthCache[segInx][k] = minLength;
    	return lengthCache[segInx][k];
    }//end method
    
    /**
     * this method return compressed length given character length
     * @param charLen - int
     * @return int
     */
    private int getCompressedLength(int charLen) {

    	if (charLen == 0) {
    		return 0;
    	} else if (charLen == 1) {
			return 1;
		} else if (charLen < 10) {
			return 2;
		} else if (charLen < 100) {
			return 3;
		} else if (charLen == 100) {
			return 4;
		} else {
			return 0;
		}//fi
		
    }//end method;
}//end class


class Solution1531_v3 {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 9999;
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0, del = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) 
                        cnt++;
                    else 
                        del++;
                    
                    if (j - del >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                    }
                }
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }
}

