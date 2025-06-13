package Problems;

import java.util.*;



public class Prob231 {
	
	static void test() {
		System.out.println("test starts");
		Solution231 solObj = new Solution231();
		int n;

		n=1;
		System.out.println("n: " + n + " : " + solObj.isPowerOfTwo(n));

 
	}//end method
	
	static void test2() {
		System.out.println("test starts");
		
		int n;

		n=1;
		System.out.println("n: " + n + " : " + Integer.toBinaryString(n));
 
		n <<=16;
		System.out.println("n: " + n + " : " + Integer.toBinaryString(n));
		
		n <<= 2;		
		System.out.println("n: " + n + " : " + Integer.toBinaryString(n));
		
		n <<= 2;		
		System.out.println("n: " + n + " : " + Integer.toBinaryString(n));
	}//end method
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution231 {
	private static final int[] PWR_OF_2_ARR;
	
	static {
		PWR_OF_2_ARR = new int[31];
		PWR_OF_2_ARR[0]=1;
		PWR_OF_2_ARR[1]=2;
		PWR_OF_2_ARR[2]=4;
		PWR_OF_2_ARR[3]=8;
		PWR_OF_2_ARR[4]=16;
		PWR_OF_2_ARR[5]=32;
		PWR_OF_2_ARR[6]=64;
		PWR_OF_2_ARR[7]=128;
		PWR_OF_2_ARR[8]=256;
		PWR_OF_2_ARR[9]=512;
		PWR_OF_2_ARR[10]=1024;
		PWR_OF_2_ARR[11]=2048;
		PWR_OF_2_ARR[12]=4096;
		PWR_OF_2_ARR[13]=8192;
		PWR_OF_2_ARR[14]=16384;
		PWR_OF_2_ARR[15]=32768;
		PWR_OF_2_ARR[16]=65536;
		PWR_OF_2_ARR[17]=131072;
		PWR_OF_2_ARR[18]=262144;
		PWR_OF_2_ARR[19]=524288;
		PWR_OF_2_ARR[20]=1048576;
		PWR_OF_2_ARR[21]=0b1000000000000000000000;
		PWR_OF_2_ARR[22]=0b10000000000000000000000;
		PWR_OF_2_ARR[23]=0b100000000000000000000000;
		PWR_OF_2_ARR[24]=0b1000000000000000000000000;
		PWR_OF_2_ARR[25]=0b10000000000000000000000000;
		PWR_OF_2_ARR[26]=0b100000000000000000000000000;
		PWR_OF_2_ARR[27]=0b1000000000000000000000000000;
		PWR_OF_2_ARR[28]=0b10000000000000000000000000000;
		PWR_OF_2_ARR[29]=0b100000000000000000000000000000;
		PWR_OF_2_ARR[30]=0b1000000000000000000000000000000;
	
		
		
	}//end static block
	
    public boolean isPowerOfTwo(int n) {
    	if (n % 2 == 1) {
            return false;
        }
    	return Arrays.binarySearch(PWR_OF_2_ARR, n)>=0;        
    }//end method
}//end class


