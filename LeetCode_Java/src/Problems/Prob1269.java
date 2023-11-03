package Problems;


public class Prob1269 {



	static void test() {
		Solution1269 solObj = new Solution1269();
		int steps, arrLen;

	
		steps = 3;
		arrLen = 2;
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen)); 
		
		steps = 2;
		arrLen = 4;
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
		//*/
		steps = 4;
		arrLen = 2; //8
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
	
		steps = 37;
		arrLen = 706767; //700270879
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
		
		steps = 500;
		arrLen = 1000000; //374847123
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
		
		steps = 500;
		arrLen = 10; //152061063
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
		
		steps = 500;
		arrLen = 3; //937512805
		System.out.println("steps: " + steps + " arrLen: " + arrLen);
		System.out.println("ans: " + solObj.numWays(steps, arrLen));
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1269 {
	
	private static final long MOD_CONST = 1000000007;
	/*
	 * step index cache
	 * long[step][array index]
	 */
	private static long[][] siCache;
	private int maxArrInx;
	
	private long[][] siTmpCache;
	
	static {
		siCache = new long[501][252];
		siCache[0][1]=1;
		siCache[1][0]=1;
		siCache[0][0]=1;
		for (int i=1; i<=251; i++) {
			siCache[i][i]=1;
		}//rof
	}//end static
	
    public int numWays(int steps, int arrLen) {
    	this.maxArrInx = arrLen-1;
    	if (steps > maxArrInx) {
    		siTmpCache = new long[steps+1][arrLen];
    	}//fi
    	long numOfWays = searchNumOfWays(steps, 0);
        return (int) numOfWays;
    }//end method
    
    /**
     * recursively find for number of ways
     * precondition: 
     * required data structures are available and valid, global variables are set
     *  - siCache, siTmpCache, maxArrInx
     * @param stepsLeft - int, available steps left
     * @param arrInx - int, index at current iteration
     * @return long, number of ways applied to modulus MOD_CONST 
     */
    private long searchNumOfWays(int stepsLeft, int arrInx) {
    	//base case, steps < arrInx
    	if (arrInx > stepsLeft) {
    		return 0;
    	}//fi
    	
    	boolean rightRestrictSearch = maxArrInx < arrInx + stepsLeft;
    	//System.out.println("arrInx: " + arrInx + " stepsLeft: " + stepsLeft);
    	if (rightRestrictSearch && siTmpCache[stepsLeft][arrInx]!=0) {
    		return siTmpCache[stepsLeft][arrInx];
    	} else if (!rightRestrictSearch && siCache[stepsLeft][arrInx]!=0) {
    		return siCache[stepsLeft][arrInx];
    	}//fi
    	

    	
    	long numOfWays = 0;
    	
    	if (maxArrInx>arrInx) {
    		numOfWays = (numOfWays + searchNumOfWays(stepsLeft-1, arrInx+1))%MOD_CONST;
    	}//fi
    	numOfWays = (numOfWays + searchNumOfWays(stepsLeft-1, arrInx))%MOD_CONST;
    	if (0<arrInx) {
    		numOfWays = (numOfWays + searchNumOfWays(stepsLeft-1, arrInx-1))%MOD_CONST;
    	}//fi
    	
    	if (rightRestrictSearch ) {
    		siTmpCache[stepsLeft][arrInx] = numOfWays;
    	} else {
    		siCache[stepsLeft][arrInx] = numOfWays;
    	}//fi
    	return numOfWays;
    }//end method
}// end class
