package Problems;

import java.util.*;


public class Prob1688 {
	
	static void test() {
		System.out.println("test starts");
		Solution1688 solObj = new Solution1688();
		int n;
		
		n=7;
		System.out.println("n: " + n + " : " + solObj.numberOfMatches(n));
		
 
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution1688	 {
	
	private static final int[] numOfMatchesCache;
	static {
		numOfMatchesCache = new int[201];
		numOfMatchesCache[1] = 0;
		numOfMatchesCache[2] = 1;
		
	}//end static
	
    public int numberOfMatches(int n) {

    	populateCache(n);
        return numOfMatchesCache[n];
    }//end method
    
    /**
     * populate number of matches cache
     * precondition:
     * required data structure numOfMatchesCache is created and base case set
     * @param n - int, number of matches
     */
    private void populateCache(int n) {
    	if (numOfMatchesCache[n]!=0 || n<2) {
    		return;
    	}//fi
    	int remainder = n%2;
    	int numOfFirstRounds = n/2;
    	int numOfCandidatesInNextRound = numOfFirstRounds+remainder;
    	populateCache(numOfCandidatesInNextRound);
    	numOfMatchesCache[n] = numOfFirstRounds + numOfMatchesCache[numOfCandidatesInNextRound];
    }//end method
}//end class


