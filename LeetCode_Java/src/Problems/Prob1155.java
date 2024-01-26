package Problems;

import java.math.BigInteger;
import java.util.Arrays;


public class Prob1155 {

	public static void test() {
		Solution1155 solObj = new Solution1155();

		int n, k, target;
		
		n = 2;
		k = 6;
		target = 7;
		System.out.println(n + ":" + k + ":" + target + " ,sol: " + solObj.numRollsToTarget(n, k, target));
		
	
		n = 30;
		k = 30;
		target = 500;
		System.out.println(n + ":" + k + ":" + target + " ,sol: " + solObj.numRollsToTarget(n, k, target));
		//*/
	}// end method



	public static void main(String[] args) {
		test();

	}// end method

}

class Solution1155 {
	
	private static final long MOD_CONST = 1000000007;  
	private static long[][][] countCache = new long[31][31][1001];

	public int numRollsToTarget(int n, int k, int target) {
		

		
		if (countCache[n][k][target]!=0) {
			return (int)countCache[n][k][target];
		}//fi
		
		
		return (int)numOfRolls(n, k, target);
	}// end method

	/**
	 * precondition:
	 * -required variables are present and valid - countCache, MOD_CONST
	 * -original target, n, k form valid combination. In particular, there should NOT be cases where target > k*n
	 * @param n - int, number of dices
	 * @param k - int, max number of dice faces
	 * @param target - int, target value
	 * @return long, num of rolls moded to MOD_CONST
	 */
	private long numOfRolls(int n, int k, int target) {
		if (countCache[n][k][target]!=0) {
			return countCache[n][k][target];
		}//fi
		//System.out.println("n k target " + n + " : " + k + " : " + target);
		//special cases
		if (target > k*n) {
			return 0;
		} else if (target < n) {
			return 0;
		} else if (n==1 || n==target) {
			countCache[n][k][target] = 1;
			return 1;
		}//fi

		long numOfWays = 0;
		int newTarget;
		int termsLeft = n-1;
		for (int currK = 1; currK <= k && ((newTarget = target-currK)>=termsLeft); currK++) {
			numOfWays = (numOfWays + numOfRolls(termsLeft, k, newTarget))%MOD_CONST;
		}//rof
		countCache[n][k][target] = numOfWays;
		//System.out.println("return: " + numOfWays);
		return numOfWays;
	}//end method
	
}// end class
