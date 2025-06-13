package Problems;

import java.util.*;

import Utils.MatrixUtils;

public class Prob629 {

	public static void test() {
		Solution629 solObj = new Solution629();
		Solution629_v2 correctSol = new Solution629_v2();
		int n, k;
		
				
		n = 14;
		k = 51; 
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kInversePairs(n,k));
		System.out.println("correct sol: " + correctSol.kInversePairs(n,k));

		n = 13;
		k = 52; 
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kInversePairs(n,k));
		System.out.println("correct sol: " + correctSol.kInversePairs(n,k));

		
		n = 14;
		k = 52; //0
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kInversePairs(n,k));
		System.out.println("correct sol: " + correctSol.kInversePairs(n,k));

		//*/
	}// end method

	private static void test2() {


	}// end method

	public static void main(String[] args) {
		test();
		// test2();
	}// end method

}



class Solution629 {
	private static final long MOD_CONST = 1000000007; 
	//1st index: n, 2nd index: k
	private static long[][] mNumCache;
	static {
		mNumCache = new long[1001][1001];
		mNumCache[0][0] = 1;
		for (int n=1; n<=1000; n++) {
			mNumCache[n][0] = 1;
			mNumCache[n][1] = n-1;
		}//rof
		int substractInx;

		for (int n=3; n<=1000; n++) {
			for (int k=2; k<=1000; k++) {
				substractInx = k-n;
				mNumCache[n][k] = mNumCache[n-1][k] + mNumCache[n][k-1];
				if (substractInx>=0) {
					mNumCache[n][k] -= mNumCache[n-1][substractInx];
				}//fi
				mNumCache[n][k] %= MOD_CONST;
				//mNumCache[n][k] %= MOD_CONST;
				if (mNumCache[n][k] == 0){
					break;
				} else if (mNumCache[n][k] < 0) {
					mNumCache[n][k] += MOD_CONST;
					/*
					System.out.println("n:" + n + " k:" + k + " substractInx: " + substractInx);
					System.out.println("mNumCache[n-1][k]:" + mNumCache[n-1][k]);
					System.out.println("mNumCache[n][k-1]:" + mNumCache[n][k-1]);
					System.out.println("mNumCache[n-1][substractInx]:" + mNumCache[n-1][substractInx]);
					//*/
					//break N_LOOP;
				}//fi
			}//rof
			//System.out.println("left part finished ");			
		}//rof		
	}//end static
	
    public int kInversePairs(int n, int k) {

    	//MatrixUtils.displayMatrix(mNumCache, 110, 110);
    	return (int)mNumCache[n][k];
    }//end method
	
}// end class

class Solution629_v2 {
	private static final long MOD_CONST = 1000000007; 
	//1st index: n, 2nd index: k
	private static long[][] mNumCache;
	static {
		mNumCache = new long [1001][1001];
		mNumCache[0][0] = 1;
		for (int n=1; n<=1000; n++) {
			mNumCache[n][0] = 1;
			mNumCache[n][1] = n-1;
		}//rof
		long tmpSum;
		for (int n=3; n<=1000; n++) {


			for (int k=2; k<=1000; k++) {
				tmpSum = 0;
				for (int currK = Math.max(0, k-n+1); currK <= k; currK++) {
					tmpSum = (tmpSum + mNumCache[n-1][currK])%MOD_CONST;
				}//rof				
				mNumCache[n][k] = tmpSum;
				if (tmpSum == 0) {
					break;
				}//fi
			}//rof
	

			
		}//rof		
	}//end static
	
    public int kInversePairs(int n, int k) {

		//MatrixUtils.displayMatrix(mNumCache, 110, 110);
    	return (int)mNumCache[n][k];
    }//end method
	
}// end class

