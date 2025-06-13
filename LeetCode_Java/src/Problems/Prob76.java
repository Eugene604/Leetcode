package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob76 {
	

	
	public static void test() {

		Solution76 solObj = new Solution76();
		String s, t;

		String ans;
	
		
		s = "ADOBECODEBANC";
		t = "ABC"; //BANC
		System.out.println(s + " : " + t);
		System.out.println("ans: " + solObj.minWindow(s, t));
		
		/*
		s = "aaaaaaaaaaaabbbbbcdd";
		t = "abcdd"; //abbbbbcdd
		System.out.println(s + " : " + t);
		System.out.println("ans: " + solObj.minWindow(s, t));
		//*/
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
   
}

class Solution76 {
	static final int CNT_BEGIN_INX = 65;
	static final int CNT_END_INX = 122;
	
	static int[] sCntArr = new int[123];
	static int[] tCntArr = new int[123];
	private boolean isSContainsT = false;
    public String minWindow(String s, String t) {
    	//special case, length of t > length of s
    	if (t.length() > s.length()) {
    		return "";
    	}//fi
    	
    	//step 1, initialize s and t count arrays
    	Arrays.fill(tCntArr, CNT_BEGIN_INX, tCntArr.length, 0);
    	Arrays.fill(sCntArr, CNT_BEGIN_INX, sCntArr.length, 0);
    	
    	//step 2, populate count array for string t    	
    	for (char c:t.toCharArray()) {
    		tCntArr[c]++;
    	}//rof
    	
    	//step 3, prepare variables for two pointer search and partial count array for string s
    	int currLength, maxLength = Integer.MAX_VALUE, maxLLeftInx = 0, maxLRightInx = 0;    	
    	for (int i=0; i < t.length() ; i++) {
    		quickAddToS(s.charAt(i));
    	}//rof
    	checkSContainsT();
    	int leftInx = 0, rightInx = t.length()-1;
    	
    	//step 4, use two pointer method to obtain shortest substring containing t    
    	while (rightInx < s.length()) {
    		if (isSContainsT) {
    			currLength = rightInx - leftInx;
    			if (currLength < maxLength) {
    				maxLength = currLength;
    				maxLLeftInx = leftInx;
    				maxLRightInx = rightInx;
    			}//fi
    			removeFromS(s.charAt(leftInx));
    			leftInx++;
    		} else if (rightInx < s.length()-1){
    			rightInx++;
    			
    			addToS(s.charAt(rightInx));
    		} else {
    			break;
    		}//fi
    	}//end while
    	
    	if (maxLength == Integer.MAX_VALUE) {
    		return "";
    	} else {
    		return s.substring(maxLLeftInx, maxLRightInx+1);
    	}//fi
    }//end method 
    
    /**
     * add character to s count array
     * Precondition: 
     * - assume s and t character count array are instantiated and initialized.
     * - assume t  character count array is populated
     * @param c - char, the character to be added
     * @return true if s array now contains everything from t
     */
    private boolean addToS(char c) {
    	if (tCntArr[c] == 0) {
    		return isSContainsT;
    	} else {
    		sCntArr[c]++;
    		if (sCntArr[c] < tCntArr[c]) {    			
    			return false;
    		}//fi    	    		
    		return checkSContainsT();
    	}//fi    	
    }//end method
    
    /**
     * add character to s count array
     * This method differs from addToS as it does not check or report whether the new contents contain all characters from string t
     * Precondition: 
     * - assume s and t character count array are instantiated and initialized.
     * - assume t  character count array is populated
     * @param c - char, the character to be added
     */
    private void quickAddToS(char c) {
    	if (tCntArr[c] != 0) {
    		sCntArr[c]++;    		
    	}//fi    	
    }//end method
    
    /**
     * remove character from s count array
     * Precondition: 
     * - assume s and t character count array are instantiated and initialized.
     * - assume t  character count array is populated
     * @param c - char, the character to be removed
     * @return true if s array now contains everything from t
     */
    private boolean removeFromS(char c) {
    	if (tCntArr[c] == 0 || sCntArr[c] == 0) {
    		return isSContainsT;
    	} else {
    		sCntArr[c]--;
    		if (sCntArr[c] < tCntArr[c]) {  
    			isSContainsT = false;
    			return false;
    		} else {
    			return isSContainsT;
    		}//fi
    	}//fi    	
    }//end method
    
    /**
     * check if s character array contains all characters from t
     * global variable sContainsT also updated
     * @return  true if s array now contains everything from t
     */
    private boolean checkSContainsT() {
		for (int i=CNT_BEGIN_INX; i<=CNT_END_INX; i++) {
    		if (sCntArr[i] < tCntArr[i]) {      			
    			isSContainsT = false;
    			return isSContainsT;
    		}//fi
		}//rof
		isSContainsT = true;
		return isSContainsT;
    }//end method
}//end class
