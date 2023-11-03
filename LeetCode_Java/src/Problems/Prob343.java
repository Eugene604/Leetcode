package Problems;

import java.util.*;



public class Prob343 {
	
	static void test() {
		System.out.println("test starts");
		Solution343 solObj = new Solution343();
		int n;

		n=12;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=11;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=10;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=9;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=8;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=7;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=6;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		n=5;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		
		n=4;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		
		n=3;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
		

		n=2;
		System.out.println("n: " + n + " : " + solObj.integerBreak(n));
 
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution343 {
	static int[] ansCache;
	
	static {
		ansCache = new int[59];
		ansCache[2] = 1;
		ansCache[3] = 2;		
		ansCache[4] = 4;		
		ansCache[5] = 6;
		ansCache[6] = 9;
		ansCache[7] = 12;
		ansCache[8] = 18;
		ansCache[9] = 27;
		ansCache[10] = 36;
		ansCache[11] = 54;
		ansCache[12] = 81;
		ansCache[13] = 108;
		ansCache[14] = 162;
		ansCache[15] = 243;
		ansCache[16] = 324;
		ansCache[17] = 486;
		ansCache[18] = 729;
		ansCache[19] = 972;		
		//*/
	}//end static
    
	
	
	public int integerBreak(int n) {
	   	if (ansCache[n]!=0) {
    		return ansCache[n];
    	}//fi
	   	searchMaxProduct(n);
        return ansCache[n];
    }//end method
	
	/**
	 * precondition:
	 * does not check for ansCache array index validity
	 * 
	 * @param remains int - 2~58
	 * @return int, indicates the max product of this number
	 */
	private int searchMaxProduct(int remains) {
		//base case 1: remains = 2~4
	   	if (remains<5) {
	   		return remains;
	   	}//fi
	   	//base case 2: remains already recorded
	   	if (ansCache[remains]!=0) {
    		return ansCache[remains];
    	}//fi
	   	
	   	int globalMaxProduct = 0;
	   	int tmpProduct;
	   	

	   	for (int multiplicant=remains-2; multiplicant>1; multiplicant--) {
	   		tmpProduct = multiplicant*searchMaxProduct(remains-multiplicant);
	   		if (tmpProduct>globalMaxProduct) {
	   			globalMaxProduct = tmpProduct;
	   		}//fi
	   	}//rof
	   	ansCache[remains] = globalMaxProduct;
		return ansCache[remains];
	}//end method
}//end class


