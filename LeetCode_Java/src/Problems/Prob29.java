package Problems;

import java.util.*;

public class Prob29 {
		
	private static void test() {
		int dividend, divisor;

		Solution29 solObj = new Solution29();
		
		
		dividend = Integer.MAX_VALUE;
		divisor = 1;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));

		dividend = Integer.MIN_VALUE;
		divisor = -1;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));
		
		dividend = Integer.MIN_VALUE;
		divisor = 1;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));		

		
		dividend = 10;
		divisor = 3;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));
		
		dividend = 1000;
		divisor = 2;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));
		//*/
		
		dividend = Integer.MAX_VALUE;
		divisor = -1;
		System.out.println("java implementation: " + (dividend/divisor) + " your: " + solObj.divide(dividend,divisor));

	
		
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution29 {
	private static long[] substractCountArr = {0,1,2,4,8,16,32,64,128,256,512,
			1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,
			2097152,4194304, 8388608, 16777216, 33554432, 67108864, 134217728,
			268435456, 536870912, 1073741824, 2147483648l};
	private static long[] substrahendPowerArr = new long[33];
	private static int maxSPArrInx;
	public int divide(int dividend, int divisor) {
		//special case 1, dividend is zero
		if (dividend == 0) {
			return 0;
		}//fi
		
		//special case 2, abs(divisor) is 1				
		if ( divisor == 1) {
			return dividend;
		} else if (divisor == -1) {
			if (dividend == Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			} else {			
			}//fi
		}//fi */
		
		
		boolean sameSign = Integer.signum(dividend) == Integer.signum(divisor);
		long minuend = Math.abs((long)dividend);
		initSubtrahendPwrArr(Math.abs((long)divisor));
		int currSubtrahendPwr = 0;
		
		//special case 3, dividend and divisor are same		
		if (minuend == getSubtrahendPwrVal(1)) {
			return (sameSign)?1:-1;
		}//fi
		
		long subtractCount = 0;
		while (minuend>=getSubtrahendPwrVal(1)) {		
			if (minuend >= getSubtrahendPwrVal(currSubtrahendPwr+1)) {
				currSubtrahendPwr++;
				minuend -= getSubtrahendPwrVal(currSubtrahendPwr);				
			} else {
				currSubtrahendPwr = 1;
				minuend -= getSubtrahendPwrVal(currSubtrahendPwr);
			}//fi

			subtractCount += getSubstractCount(currSubtrahendPwr);
						
		}//end while
		//System.out.println("substrahendPowerArr " + Arrays.toString(substrahendPowerArr));
		return (sameSign)?(int)subtractCount:(int)-subtractCount;
	}//end method
	
	/**
	 * 
	 * @param baseBubtrahend long value type
	 */
	private static void initSubtrahendPwrArr(long baseBubtrahend) {
		substrahendPowerArr[1] = baseBubtrahend;
		maxSPArrInx = 1;
	}//end method
	
	/**
	 * Precondition: power value is only allowed to be at most maxSPArrInx+1
	 * Postcondition: maxSPArrInx will be incremented to = power if power is greater
	 * @param power non-zero positive int value, 0 < power <= 32
	 * @return long value
	 */
	private static long getSubtrahendPwrVal(int power) {
		if (power > maxSPArrInx) {			
			substrahendPowerArr[power]=substrahendPowerArr[maxSPArrInx]+substrahendPowerArr[maxSPArrInx];
			maxSPArrInx++;
		}//fi
		return substrahendPowerArr[power];
	}//end method
	
	/**
	 * 
	 * @param power non-zero int value, 0 < power <= 32
	 * @return
	 */
	private static long getSubstractCount(int power) {
		return substractCountArr[power];
	}//end method
}//end class
