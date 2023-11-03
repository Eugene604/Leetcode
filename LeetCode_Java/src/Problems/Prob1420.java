package Problems;

import java.math.BigInteger;
import java.util.Arrays;


public class Prob1420 {

	public static void test() {
		Solution1420 solObj = new Solution1420();
		Solution1420_v2 truSolObj = new Solution1420_v2();
		int n, m, k;
		
		/*
		n = 2;
		m = 3;
		k = 1; //6
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));
		
		n = 2;
		m = 3;
		k = 2;//12
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));
		
		
		n = 10;
		m = 3;
		k = 3;//9330
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		n = 9;
		m = 3;
		k = 3;//3025
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		n = 49;
		m = 73;
		k = 1; // 390949615
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		n = 50;
		m = 100;
		k = 50; // 538992043
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		n = 50;
		m = 100;
		k = 25; // 34549172
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k)); //

		n = 50;
		m = 100;
		k = 3; // 388975804
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));
		//*/
		
		n = 4;
		m = 2;
		k = 1;
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		
		n = 4;
		m = 3;
		k = 1;
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

		n = 4 ;
		m = 4;
		k = 1;
		System.out.println(n + ":" + m + ":" + k + " ,sol: " + solObj.numOfArrays(n, m, k) + " , tru sol: " + truSolObj.numOfArrays(n, m, k));

	}// end method

	private static void test2() {
		long ans, ans2;
		int base, pow;

		base = 10;
		pow = 19;
		ans = Solution1420.powMod(base, pow);
		ans2 = (long) Math.pow(base, pow);
		System.out.println(ans);
		System.out.println(ans2);

	}// end method

	public static void main(String[] args) {
		test();
		// test2();
	}// end method

}

class Solution1420 {

	private static final long MOD_CONST = 1000000007;
	private static long[][][] ansCache = new long[51][101][51];
	private static long[][] powModCache = new long[101][51];

	static {
		// populate the cases where m = 1
		for (int n = 0; n <= 50; n++) {
			ansCache[n][1][1]=1;			
		} // rof
		// populate the cases where m>2, k = 1
		for (int currKRightBound = 1; currKRightBound <= 50; currKRightBound++) {
			for (int currMaxVal = 2; currMaxVal <= 100; currMaxVal++) {
				ansCache[currKRightBound][currMaxVal][1] = (powMod(currMaxVal, currKRightBound - 1) % MOD_CONST + ansCache[currKRightBound][currMaxVal - 1][1])% MOD_CONST;
			} // rof
		} // rof
	}// end static

	public int numOfArrays(int n, int m, int k) {
		// special case: k > m
		if (k > m || k == 0) {
			return 0;	
		} // fi
		searchNumOfWays(n, m, k);
		return (int) (ansCache[n][m][k]);
	}// end method

	/**
	 * preconditon:
	 * ansCache - instantiated
	 * @param n int, length of array
	 * @param m int, max value 
	 * @param k int, number of peaks allowed
	 * @return long, number of ways moded to MOD_CONST
	 */
	private long searchNumOfWays(int n, int m, int k) {
		if (ansCache[n][m][k] != 0) {
			return ansCache[n][m][k];
		} // fi */

		/*
		 * say k = 5, currK = 2, and array is 1-based indexing
		 *                            currKRightmostBound v v next K
		 * [1,1,1,1,1,3,3,3,3,3,3,3,3,3,3,3,3,?,?,?,?,?,?,?,5,7,9]
		 *  currMaxInx^                     ^currKRightBound 
		 *              [< maxToRBoundGap  ->]
		 */           				 
		long waysForCurrMaxVal;
		int currKRightmostBound, currKMaxVal, maxToRBoundGap;
		
		for (int currK = 2; currK <= k; currK++) {
			currKRightmostBound = n - (k-currK);
			currKMaxVal = m - (k-currK);			
			for (int currKRightBound = currK; currKRightBound <= currKRightmostBound; currKRightBound++) {				
				for (int currMaxVal = currK; currMaxVal <= currKMaxVal; currMaxVal++) {			
					if (ansCache[currKRightBound][currMaxVal][currK]==0) {
						waysForCurrMaxVal = 0; 
					} else {
						continue;
					}//fi							
					for (int currMaxInx = currK; currMaxInx <= currKRightBound; currMaxInx++) {
						maxToRBoundGap = currKRightBound - currMaxInx;
						waysForCurrMaxVal = (waysForCurrMaxVal + powMod(currMaxVal, maxToRBoundGap) * ansCache[currMaxInx-1][currMaxVal-1][currK-1])%MOD_CONST;																		
					}//rof
					ansCache[currKRightBound][currMaxVal][currK] = (waysForCurrMaxVal + ansCache[currKRightBound][currMaxVal-1][currK])%MOD_CONST;								
				} // rof				
			} // rof
		} // rof



		return ansCache[n][m][k];
	}// end method

	/**
	 * positive long number power function with result moded
	 * 
	 * @param num - int, positive long number, num <= 50
	 * @param pow - int, non-negative power
	 * @return long, number that has been applied to modulus MOD_CONST
	 */
	public static long powMod(int num, int pow) {

		if (powModCache[num][pow] != 0) {
			return powModCache[num][pow];
		} // fi */


		if (num == 1 || pow == 1) {
			powModCache[num][pow] = num;
			return num;
		} else if (pow == 0) {
			powModCache[num][pow] = 1;
			return 1;
		} // fi
		powModCache[num][pow] = num*powModCache[num][pow-1]%MOD_CONST;		
		return powModCache[num][pow];
	}// end method
}// end class

class Solution1420_v2 {

	private static final long MOD_CONST = 1000000007;
	private static long[][][] ansCache = new long[51][101][51];
	private static long[][] powModCache = new long[101][51];

	public int numOfArrays(int n, int m, int k) {
		// special case: k > m
		if (k > m || k == 0) {
			return 0;
		} else if (ansCache[n][m][k] != 0) {
			return (int) (ansCache[n][m][k]);
		} // fi
		searchNumOfWays(n, m, m, k);
		return (int) (ansCache[n][m][k]);
	}// end method

	private long searchNumOfWays(int n, int currLocalMax, int globalMax, int k) {

		if (ansCache[n][currLocalMax][k] != 0) {

			return ansCache[n][currLocalMax][k];
		} // fi */

		// base case: first index is always one of the k local maxes
		long numOfWays = 0;
		int gapBtwLocalMaxes;
		if (k == 1) {
			gapBtwLocalMaxes = n - 1;
			for (int currMaxVal = currLocalMax; currMaxVal > 0; currMaxVal--) {
				numOfWays = (numOfWays + powMod(currMaxVal, gapBtwLocalMaxes)) % MOD_CONST;
			} // rof
			ansCache[n][currLocalMax][k] = numOfWays % MOD_CONST;

			return ansCache[n][currLocalMax][k];
		} // fi

		// rest of cases: location of local maxes varies
		for (int currMaxInx = k; currMaxInx <= n; currMaxInx++) {
			gapBtwLocalMaxes = n - currMaxInx;
			for (int currMaxVal = currLocalMax; currMaxVal >= k; currMaxVal--) {
				numOfWays = numOfWays % MOD_CONST + (powMod(currMaxVal, gapBtwLocalMaxes)
						* searchNumOfWays(currMaxInx - 1, currMaxVal - 1, globalMax, k - 1)) % MOD_CONST;
			} // rof
		} // rof

		ansCache[n][currLocalMax][k] = numOfWays % MOD_CONST;

		return numOfWays;
	}// end method

	/**
	 * positive long number power function with result moded
	 * 
	 * @param num - int, positive long number, num <= 50
	 * @param pow - int, non-negative power
	 * @return long, number that has been applied to modulus MOD_CONST
	 */
	public static long powMod(int num, int pow) {

		if (powModCache[num][pow] != 0) {
			return powModCache[num][pow];
		} // fi */

		long tmpAns;
		if (num == 1 || pow == 1) {
			powModCache[num][pow] = num;
			return num;
		} else if (pow == 0) {
			powModCache[num][pow] = 1;
			return 1;
		} // fi
		long tmp = powMod(num, pow / 2);
		if (pow % 2 == 1) {
			tmpAns = (num * tmp) % MOD_CONST;
			powModCache[num][pow] = (tmp * tmpAns) % MOD_CONST;
		} else {
			powModCache[num][pow] = (tmp * tmp) % MOD_CONST;
		} // fi
		return powModCache[num][pow];
	}// end method
}// end class
