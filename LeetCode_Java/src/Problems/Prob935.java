package Problems;

import java.util.*;


public class Prob935 {

	
	static void test() {
		System.out.println("test starts");
		Solution935 solObj = new Solution935();
		int n;
		
		n=3131;
		System.out.println("n: " + n + " : " + solObj.knightDialer(n));
		
		/*
		System.out.println(" ");
		n=2;
		System.out.println("n: " + n + " : " + solObj.knightDialer(n));
		//*/
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution935	 {
	
	private static final long MOD_CONST = 1000000007;
	private static final int[][] POSSIBLE_MOVE;
	private static final long[][] ENDNUM_CNT_CACHE;
	
	static {
		POSSIBLE_MOVE = new int[10][];
		POSSIBLE_MOVE[0] = new int[]{4,6};
		POSSIBLE_MOVE[1] = new int[]{6,8};
		POSSIBLE_MOVE[2] = new int[]{7,9};
		POSSIBLE_MOVE[3] = new int[]{4,8};
		POSSIBLE_MOVE[4] = new int[]{0,3,9};
		POSSIBLE_MOVE[5] = new int[0];
		POSSIBLE_MOVE[6] = new int[]{0,1,7};
		POSSIBLE_MOVE[7] = new int[]{2,6};
		POSSIBLE_MOVE[8] = new int[]{1,3};
		POSSIBLE_MOVE[9] = new int[]{2,4};
		
		ENDNUM_CNT_CACHE = new long [5001][10];
		Arrays.fill(ENDNUM_CNT_CACHE[1],1);
	}//end static
	
    public int knightDialer(int n) {
    	long numOfDials = 0;
    	
    	//step 1, build end number counts up to n
    	populateNumCounts(n);

    	//step 2, sum all numbers
		for (long count:ENDNUM_CNT_CACHE[n]) {
			numOfDials += count % MOD_CONST;
		}//rof
		return (int)(numOfDials % MOD_CONST);    		
    }//end method
 
    /**
     * populate dial number count for dial sequence up to length n
     * preconditon:
     * - required data structure is available and has base case set- ENDNUM_CNT_CACHE
     * - 0 < n <= 5000
     * postcondition:
     * number counts from 1~n will be populated
     * @param n - int, length of dial sequence
     */
    private void populateNumCounts(int n) {
    	if (ENDNUM_CNT_CACHE[n][0]!=0) { //it is already populated
    		return;
    	} else if (ENDNUM_CNT_CACHE[n-1][0]==0) { 
    		populateNumCounts(n-1);
    	}//fi
    	
    	long countAtPrevN;
    	for (int num=0; num<=9; num++) {
    		countAtPrevN = ENDNUM_CNT_CACHE[n-1][num];
    		for (int nextPossibleNum:POSSIBLE_MOVE[num]) {
    			ENDNUM_CNT_CACHE[n][nextPossibleNum]+=countAtPrevN % MOD_CONST;
    		}//rof
    	}//rof    	
    }//end method
}//end class


