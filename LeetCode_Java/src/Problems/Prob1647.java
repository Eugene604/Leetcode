package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1647 {
	public static String str1 = "aab";
	public static String str2 = "aaabbbcc";
	public static String str3 = "ceabaacb";
	public static String str4 = "fewwefwaefwfwe";
	

	

	
	public static void main(String[] args) {
		Solution1647 solObj = new Solution1647();
		String str;
		/*

 		//*/
		str = str1;
		System.out.println("sol: " + solObj.minDeletions(str));		
		str = str2;
		System.out.println("sol: " + solObj.minDeletions(str));		
		str = str3;
		System.out.println("sol: " + solObj.minDeletions(str));		
		str = str4;
		System.out.println("sol: " + solObj.minDeletions(str));		
	}

}


class Solution1647 {
	 	
    public int minDeletions(String s) {
    	//step 1, survey frequencies of each character and stores in an array of 26
    	int currCharInx;
    	int maxFreq = 0;
    	int[] charFreqArr = new int[26];
    	for (char c:s.toCharArray()) {
    		currCharInx=c-'a';
    		charFreqArr[currCharInx]++;
    		if (charFreqArr[currCharInx]>maxFreq) {
    			maxFreq=charFreqArr[currCharInx];
    		}//ri
    	}//rof
    	//System.out.println("char freq arr " + Arrays.toString(charFreqArr) + " maxFreq:" + maxFreq);
    	
    	//step 2, populate frequency to number of character array (essentially frequency count). Array index is the frequency
    	int[] freqCountArr = new int[maxFreq+1]; 
    	for (int f:charFreqArr) {
    		freqCountArr[f]++;
    	}//rof
    	//System.out.println("freq count arr " + Arrays.toString(freqCountArr));
    	
    	//step 3, try to get frequency count array to have either 1s or 0s
    	int deletionCount = 0;
    	int currDeletion;
    	for (int i = maxFreq; i > 0; i--) {
    		if (freqCountArr[i]>1) {
    			currDeletion = freqCountArr[i]-1;
    			deletionCount += currDeletion;
    			freqCountArr[i-1] += currDeletion;    			
    		}//fi
    	}//fi
        return deletionCount;
    }//end method

    
}//end class