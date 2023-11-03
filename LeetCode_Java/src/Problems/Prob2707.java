package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob2707 {

	public static void test() {

		Solution2707 solObj = new Solution2707();		
		String s;
		String[] words;
		int ans;
		
		
		s = "sheateateseatea";
		words = new String[] {"sea","tea","ate"};
		ans = solObj.minExtraChar(s, words);
		System.out.println(s + " ans=" + ans);
		
	
		
		s = "sayhelloworld";
		words = new String[] {"hello","world"};
		ans = solObj.minExtraChar(s, words);
		System.out.println(s + " ans=" + ans);			

		//*/
		
		s = "leetscode";
		words = new String[] {"leetcode", "leet","code"};
		ans = solObj.minExtraChar(s, words);
		System.out.println(s + " ans=" + ans);	
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution2707 {
	private static Integer[] minExtraArr;
	private static String str;
	private static String[] sortedDict;
	
    public int minExtraChar(String s, String[] dictionary) {
    	str = s;
    	minExtraArr = new Integer[str.length()];
    	Arrays.parallelSort(dictionary, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
    	sortedDict = dictionary;     
    	//int ans = minExtraChar(0);
    	//System.out.println("minExtraArr " + Arrays.toString(minExtraArr));
    	return minExtraChar(0);
    }//end method
    
    /**
     * precondition:
     * required data structures are instantiated / set
     * - minExtraArr
     * - str
     * - sortedDict
     * @param startInx - int number denoting the starting index of the array
     * @return int denoting number of minimum extra characters possible from this index
     */
    private int minExtraChar(int startInx) {
    	//System.out.println("minExtraChar " + startInx);
    	int gap = str.length()-startInx;
    	
    	//base case 1: this position has been evaluated
    	//base case 2: startInx >= str length
    	if (gap <= 0) {
    		return 0;
    	} else if (minExtraArr[startInx] != null) {
    		return minExtraArr[startInx]; 
    	} else if ((minExtraArr[startInx] = gap) < sortedDict[0].length()) {
    		return minExtraArr[startInx];
    	}//fi
    	
    	int prevWordLength = 0;
    	int currExtraChar;
    	//cycle through dictionaries
    	for (String word:sortedDict) {
    		if (gap<word.length()) {
    			break;
    		} else if (word.length() == prevWordLength) {
    			continue;
    		}//fi
    		if (str.startsWith(word,startInx)){
    			currExtraChar = minExtraChar(startInx+word.length());
    			if (currExtraChar==0) {//minimum has been found
    				return minExtraArr[startInx]=0;
    			} else if (minExtraArr[startInx]>currExtraChar) {
    				minExtraArr[startInx]=currExtraChar;
    				prevWordLength = word.length();
    			}//fi 			
    		}//fi
    	}//rof
    	/*
    	//cycle through the cases where no word from dictionary is used
    	for (int g=1; g<sortedDict[0].length(); g++) {
    		currExtraChar = g + minExtraChar(startInx+g);
    		if (minExtraArr[startInx]>currExtraChar) {
				minExtraArr[startInx]=currExtraChar;
			}//fi
    	}//rof */
    	//also check the case where current char is not used
    	currExtraChar = 1 + minExtraChar(startInx+1);
		if (minExtraArr[startInx]>currExtraChar) {
			minExtraArr[startInx]=currExtraChar;
		}//fi
    	return minExtraArr[startInx]; 
    }//end method
}// end class



