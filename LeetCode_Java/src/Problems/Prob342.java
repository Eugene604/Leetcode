package Problems;

import java.util.*;



public class Prob342 {
	
	static void test() {
		System.out.println("test starts");
		Solution342 solObj = new Solution342();
		int n;

		n=1;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
		n=12;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
		n=3;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
		n=13;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
		n=-1;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
		n=-2;
		System.out.println("n: " + n + " : " + solObj.isPowerOfFour(n));
 
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
		test2();
	}
	
}//end problem class

class Solution342 {
	private static final Set<Integer> PWR_OF_4_SET;
	
	static {
		PWR_OF_4_SET = new HashSet<>();
		PWR_OF_4_SET.add(1);
		PWR_OF_4_SET.add(4);
		PWR_OF_4_SET.add(16);
		PWR_OF_4_SET.add(64);
		PWR_OF_4_SET.add(256);
		PWR_OF_4_SET.add(1024);
		PWR_OF_4_SET.add(4096);
		PWR_OF_4_SET.add(16384);
		PWR_OF_4_SET.add(65536);
		PWR_OF_4_SET.add(262144);
		PWR_OF_4_SET.add(1048576);
		for (int shift=22; shift <= 30; shift+=2) {
			PWR_OF_4_SET.add(1<<shift);
		}//rof
	}//end static block
	
    public boolean isPowerOfFour(int n) {
    	if (n<1) {
    		return false;
    	} else if (n==1){
    		return true;
    	} else if (n<<30 != 0) {
    		return false;
    	}//fi
        return PWR_OF_4_SET.contains(n);
    }//end method
}//end class


