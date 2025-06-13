package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob552 {

	
	private static void test() {
		Solution552 solObj = new Solution552();
		
		int n;
		
		n=1;
		System.out.println("n= " + n + " Ans: " + solObj.checkRecord(n));
		

		n=10101;
		System.out.println("n= " + n + " Ans: " + solObj.checkRecord(n));
		

	}
	
	public static void main(String[] args) {
		test();
		


	}//end main
}


class Solution552 {
	
	private static final long MOD_CONST = 1000000007;
	
	private static long[] cntCache;
	
	/*
	 * 1st index - number of absence
	 * 2nd index - tail situation - 0 = present, 1 = 1 late, 2 = 2 consecutive lates, 3 = absent
	 *  
	 * value - number of possible combinations
	 */

	
	static {
		cntCache = new long[100_001];
		cntCache[1] = 3;
		cntCache[2] = 8;
		
		long[][] prevDayState = new long[2][4];
		long[][] currDayState;
		
	
		
		//setup base cases:

		prevDayState[0][0] = 2; //late present, present present
		prevDayState[0][1] = 1; //present late
		prevDayState[0][2] = 1; //late late
		prevDayState[1][0] = 1; //absent present
		prevDayState[1][1] = 1; //absent late
		prevDayState[1][3] = 2; //present absent, late absent
		
		//compute rest of days
		for (int day = 3; day <= 100_000; day++) {
			currDayState =  new long[2][4];
			currDayState[0][0] = prevDayState[0][0] + prevDayState[0][1] + prevDayState[0][2];
			currDayState[0][1] = prevDayState[0][0];
			currDayState[0][2] = prevDayState[0][1];
			currDayState[1][0] = prevDayState[1][0] + prevDayState[1][1] + prevDayState[1][2] + prevDayState[1][3];
			currDayState[1][1] = prevDayState[1][0] + prevDayState[1][3];
			currDayState[1][2] = prevDayState[1][1];
			currDayState[1][3] = prevDayState[0][0] + prevDayState[0][1] + prevDayState[0][2];
			
			currDayState[0][0] %= MOD_CONST; 			
			currDayState[0][1] %= MOD_CONST;
			currDayState[0][2] %= MOD_CONST; 			
			currDayState[1][0] %= MOD_CONST;
			currDayState[1][1] %= MOD_CONST;
			currDayState[1][2] %= MOD_CONST;
			currDayState[1][3] %= MOD_CONST;
			
	    	for (int tailSituation = 0; tailSituation < 4; tailSituation++) {
	    		for (int numOfAbsence = 0; numOfAbsence < 2; numOfAbsence++) {
	    			cntCache[day] += currDayState[numOfAbsence][tailSituation];
	    		}//rof
	    	}//rof
	    	cntCache[day] %= MOD_CONST;
	    	prevDayState = currDayState;
		}//rof
	}//end static block
	
	
    public int checkRecord(int n) {

    	return (int)cntCache[n];
    }//end method
}//end class

class Solution552_v2 {
	
	private static final long MOD_CONST = 1000000007;
	
	/*
	 * 1st index - number of days
	 * 2nd index - number of absence
	 * 3rd index - tail situation - 0 = present, 1 = 1 late, 2 = 2 consecutive lates, 3 = absent
	 *  
	 * value - number of possible combinations
	 */
	private static long[][][] rCache; 
	
	static {
		rCache = new long[100_001][2][4];
		
		//setup base cases:
		rCache[1][0][0] = 1;
		rCache[1][0][1] = 1;
		rCache[1][1][3] = 1;

		rCache[2][0][0] = 2; //late present, present present
		rCache[2][0][1] = 1; //present late
		rCache[2][0][2] = 1; //late late
		rCache[2][1][0] = 1; //absent present
		rCache[2][1][1] = 1; //absent late
		rCache[2][1][3] = 2; //present absent, late absent
		
		//compute rest of days
		for (int day = 3; day <= 100_000; day++) {
			rCache[day][0][0] = rCache[day-1][0][0] + rCache[day-1][0][1] + rCache[day-1][0][2];
			rCache[day][0][1] = rCache[day-1][0][0];
			rCache[day][0][2] = rCache[day-1][0][1];
			rCache[day][1][0] = rCache[day-1][1][0] + rCache[day-1][1][1] + rCache[day-1][1][2] + rCache[day-1][1][3];
			rCache[day][1][1] = rCache[day-1][1][0] + rCache[day-1][1][3];
			rCache[day][1][2] = rCache[day-1][1][1];
			rCache[day][1][3] = rCache[day-1][0][0] + rCache[day-1][0][1] + rCache[day-1][0][2];
			
			rCache[day][0][0] %= MOD_CONST; 			
			rCache[day][0][1] %= MOD_CONST;
			rCache[day][0][2] %= MOD_CONST; 			
			rCache[day][1][0] %= MOD_CONST;
			rCache[day][1][1] %= MOD_CONST;
			rCache[day][1][2] %= MOD_CONST;
			rCache[day][1][3] %= MOD_CONST;
		}//rof
	}//end static block
	
	
    public int checkRecord(int n) {
    	long numOfComb = 0;
    	for (int tailSituation = 0; tailSituation < 4; tailSituation++) {
    		for (int numOfAbsence = 0; numOfAbsence < 2; numOfAbsence++) {
    			numOfComb += rCache[n][numOfAbsence][tailSituation];
    		}//rof
    	}//rof
    	return (int) (numOfComb % MOD_CONST);
    }//end method
}//end class