package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1662 {
	public static String[] arr11 = {"eat","tea","tan","ate","nat","bat"};
	public static String[] arr12 = {"a"};
	public static String[] arr13 = {""};

	
	public static void main(String[] args) {
		Solution1662 solObj;
		boolean sol;
		String[] arr1, arr2;
		
		/*
		
		 //*/
		arr1 = arr11;
		arr2 = arr12;
		solObj = new Solution1662();
		sol = solObj.arrayStringsAreEqual(arr1, arr2);		
		System.out.println("sol: " + sol);		
		
	}

}

class Solution1662 {
 	
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    	int word1Inx = word1.length-1;
    	int word2Inx = word2.length-1;
    	char[] wd1CharArr = word1[word1Inx].toCharArray(); 
    	char[] wd2CharArr = word2[word2Inx].toCharArray(); 
    	int wd1CAInx = wd1CharArr.length-1;
    	int wd2CAInx = wd2CharArr.length-1;
    	while ((word1Inx>=0 || wd1CAInx>=0) && (word2Inx>=0 || wd2CAInx>=0)) {
    		if (wd1CharArr[wd1CAInx] != wd2CharArr[wd2CAInx]) {
    			return false;
    		}//fi
    		if (wd1CAInx==0) {
    			if (--word1Inx == -1) {
    				break;
    			}//fi  			
    			wd1CharArr = word1[word1Inx].toCharArray(); 
    			wd1CAInx = wd1CharArr.length-1;
    		} else {
    			wd1CAInx--;
    		}//fi
    		if (wd2CAInx==0) {
    			if (--word2Inx == -1) {
    				break;
    			}//fi 
    			wd2CharArr = word2[word2Inx].toCharArray(); 
    			wd2CAInx = wd2CharArr.length-1;
    		} else {
    			wd2CAInx--;
    		}//fi    		   		
    	}//end while
    	if (word1Inx != wd2CAInx+word2Inx-1) {
    		return false;
    	} else {
    		return true;
    	}//fi
        
    }//end method
}//end class
