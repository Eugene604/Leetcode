package Problems;

import java.util.*;


public class Prob1611 {
	
	static void test() {
		System.out.println("test starts");
		Solution1611 solObj = new Solution1611();
		int n;
		
		n=277065893;
		System.out.println("n: " + n + " : " + Integer.toBinaryString(n));
		System.out.println("ans: " + solObj.minimumOneBitOperations(n));
		

 
	}//end method
	
	
	public static void main(String args[]) {
		test();
		
	}
	
}//end problem class

class Solution1611	 {
	
	private static final int[] OPS_TO_00;
	private static final int[] OPS_TO_10;
	private static final int[] BIT_MASK;
	private static final int TWOBIT_MASK;
	private static int[] oneZeroToZerosCache = new int[33];
	
	static {
		OPS_TO_00 = new int[4];
		OPS_TO_00[0b00]=0;
		OPS_TO_00[0b01]=1;
		OPS_TO_00[0b10]=3;
		OPS_TO_00[0b11]=2;
		
		OPS_TO_10 = new int[4];
		OPS_TO_10[0b00]=3;
		OPS_TO_10[0b01]=2;
		OPS_TO_10[0b10]=0;
		OPS_TO_10[0b11]=1;
		
		BIT_MASK = new int[]{
				0b00000000000000000000000000000000,
		        0b00000000000000000000000000000001,
		        0b00000000000000000000000000000010,
		        0b00000000000000000000000000000100,
		        0b00000000000000000000000000001000,
		        0b00000000000000000000000000010000,
		        0b00000000000000000000000000100000,
		        0b00000000000000000000000001000000,
		        0b00000000000000000000000010000000,
		        0b00000000000000000000000100000000,
		        0b00000000000000000000001000000000,
		        0b00000000000000000000010000000000,
		        0b00000000000000000000100000000000,
		        0b00000000000000000001000000000000,
		        0b00000000000000000010000000000000,
		        0b00000000000000000100000000000000,
		        0b00000000000000001000000000000000,
		        0b00000000000000010000000000000000,
		        0b00000000000000100000000000000000,
		        0b00000000000001000000000000000000,
		        0b00000000000010000000000000000000,
		        0b00000000000100000000000000000000,
		        0b00000000001000000000000000000000,
		        0b00000000010000000000000000000000,
		        0b00000000100000000000000000000000,
		        0b00000001000000000000000000000000,
		        0b00000010000000000000000000000000,
		        0b00000100000000000000000000000000,
		        0b00001000000000000000000000000000,
		        0b00010000000000000000000000000000,
		        0b00100000000000000000000000000000,
		        0b01000000000000000000000000000000,
		        0b10000000000000000000000000000000        		        
		};
		
		TWOBIT_MASK = 0b11;
		
	}//end static
	
    public int minimumOneBitOperations(int n) {
    	int i = 32;
    	for (; i>2 && (n&BIT_MASK[i])==0; i--) {}//rof
    	
        return opsToAllZeros(n, i);
    }//end method
    
    /**
     * calculate operations needed to make bits from bitsPos (inclusive) to 0 to become zero
     * precondition: 
     * - required data structure is prepared - OPS_TO_00, TWOBIT_MASK
     * 
     * @param n - int, the number in question
     * @param bitPos - int, bit position, 2 <= bitPos <= 32
     * @return int, number of operations
     */
    private int opsToAllZeros(int n, int bitPos) {
    	//System.out.println("opsToAllZeros, n: " + n + " bitPos: " + bitPos);
    	if (bitPos==2) {
    		return OPS_TO_00[n&TWOBIT_MASK];
    	} else if ((n&BIT_MASK[bitPos])==BIT_MASK[bitPos]) { //bit at bitPos is 1
    		int totalOps;
        	totalOps = opsToOneZeros(n, bitPos-1); //steps to make n = 1100...00, which is one and one and bitPos-2 zeros
        	totalOps++; //one more step to reduce n to 100...00, which is an one and bitPos-2 zeros
        	bitPos--;
        	n = BIT_MASK[bitPos]; //make n to be 100...00, which is an one and original bitPos-2 zeros
        	if (oneZeroToZerosCache[bitPos]==0) {
        		oneZeroToZerosCache[bitPos] = opsToAllZeros(n, bitPos);
        	}//fi
        	totalOps += oneZeroToZerosCache[bitPos]; //now leading 1 has been cleared, rest steps are to make rest of bits all zero
        	return totalOps;
    	} else { //bit at bitPos is 0    		
    		return opsToAllZeros(n, bitPos-1);
    	}//fi    	
    }//end method
    
    /**
     * calculate operations needed to make bitsPos = 1 and subsequent bits zero
     * 
     * @param n - int, the number in question
     * @param bitPos
     * @return
     */
    private int opsToOneZeros(int n, int bitPos) {
    	//System.out.println("opsToOneZeros, n: " + n + " bitPos: " + bitPos);
    	if (bitPos==2) {
    		return OPS_TO_10[n&TWOBIT_MASK];
    	} else if ((n&BIT_MASK[bitPos])==BIT_MASK[bitPos]) {// bit at bitPos is already 1
    		return opsToAllZeros(n, bitPos-1);
    	} else {// bit at bitPos is 0
    		int totalOps;
    		totalOps = opsToOneZeros(n, bitPos-1); //steps to make n = 1100...00, which is one and one and bitPos-2 zeros
    		totalOps++; //one more step to reduce n to 100...00, which is an one and bitPos-2 zeros
        	bitPos--;
    		n = BIT_MASK[bitPos]; //make n to be 100...00, which is an one and original bitPos-2 zeros
        	if (oneZeroToZerosCache[bitPos]==0) {
        		oneZeroToZerosCache[bitPos] = opsToAllZeros(n, bitPos);
        	}//fi
    		totalOps += oneZeroToZerosCache[bitPos]; //now leading 1 has been cleared, rest steps are to make rest of bits all zero
        	return totalOps;
    	}//fi
    }//end method
}//end class


