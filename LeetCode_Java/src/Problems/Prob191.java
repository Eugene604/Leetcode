package Problems;

import java.util.*;



public class Prob191 {
	
	static void test() {
		System.out.println("test starts");
		Solution191 solObj = new Solution191();
		int n;
		
		n=0b11111111111111111111111111111101;
		System.out.println("n: " + n + " : " + solObj.hammingWeight(n));
		
 
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution191 {
private static final int NEG_MASK= 0b01111111111111111111111111111111;
    public int hammingWeight(int n) {
    	int numOfBits = 0;
    	int maskedN = n & NEG_MASK;
    	if (maskedN != n) {
    		numOfBits++;
    	}//fi
    	while (maskedN != 0) {
        	if (maskedN%2==1) {
        		numOfBits++;
        	}//fi
        	maskedN >>= 1;
        	System.out.println(Integer.toBinaryString(maskedN));
    	}//end while

        return numOfBits;
    }//end method
}//end class


