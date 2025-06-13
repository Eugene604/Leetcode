package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1593 {
	

	
	public static void test() {
		Solution1593 sol = new Solution1593();
		
		String s;
		
		s = "ababccc";
		System.out.println("ans: " + sol.maxUniqueSplit(s));
		
		
		/*
		s = "ababccc";
		System.out.println("ans: " + sol.maxUniqueSplit(s));
		
		//*/
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1593 {

	String strCache[][];
	String theString;
	int maxUSLength;
	
    public int maxUniqueSplit(String s) {
    	this.strCache = new String[16][16];
    	this.theString = s;
    	this.maxUSLength = 0;
    	findUniqueSplit(0, new HashSet<>());
    	return maxUSLength;
    }//method
    
    /**
     * This method performs a recursive backtracking search to find the maximum 
     * number of unique substrings that the input string `theString` can be split into.
     * 
     * It uses a set `subStrSet` to track substrings that have already been used 
     * and leverages memoization through `strCache` to avoid recalculating substrings.
     * The recursion explores all possible ways to split the string, 
     * updating `maxUSLength` whenever a new valid unique split is found.
     * 
     * Preconditions:
     * - `strCache` is initialized and valid: a 2D array that stores already created substrings for efficiency.
     * - `theString` is set and valid: the input string on which we are finding unique splits.
     * 
     * @param leftInx - int, the starting index of the current substring being evaluated.
     *                  This index marks where the next possible substring starts from.
     * @param subStrSet - Set<String>, a set containing the substrings that have been used so far in the current split attempt.
     *                    The set ensures that no duplicate substrings are used in the recursive search.
     */
    private void findUniqueSplit(int leftInx, Set<String> subStrSet) {
    	String currSubStr;
    	int rightInx;
    	
    	//base case, can't get any more
    	if (theString.length()-leftInx + subStrSet.size() <= this.maxUSLength) {
    		return;
    	}//fi
    	
    	//base case, whole search range is a single sub string
    	if ((currSubStr = strCache[leftInx][theString.length()-1]) == null) {
    		currSubStr = theString.substring(leftInx);
    		strCache[leftInx][theString.length()-1] = currSubStr;
    	}//fi
    	if (!subStrSet.contains(currSubStr)) {//this sub string is not used yet
    		maxUSLength = Math.max(maxUSLength, subStrSet.size()+1);
    	}//fi
    	
    	//search each possible right index
    	for (rightInx = leftInx; rightInx < theString.length()-1; rightInx++) {
        	if ((currSubStr = strCache[leftInx][rightInx]) == null) {
        		currSubStr = theString.substring(leftInx, rightInx+1);
        		strCache[leftInx][rightInx] = currSubStr;
        	}//fi
        	if (subStrSet.contains(currSubStr)) {//this sub string is already used
        		continue;
        	} else {
        		subStrSet.add(currSubStr);
        		findUniqueSplit(rightInx+1, subStrSet);
        		subStrSet.remove(currSubStr);
        	}//fi
    	}//fi
    }//end method
}//end class
