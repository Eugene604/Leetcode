package Problems;

import java.util.Arrays;

public class Prob7 {
	
	public static int int1 = 10;
	public static int int2 = 11111;
	public static int int3 = -2147483647;
	public static int int4 = 123;
	public static int int5 = -123;
	public static int int6 = 120;
	public static int int7 = 2147483642;
	public static void test() {
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		Solution7 sol = new Solution7();
		int arg;
		
		
		arg = int1;
		System.out.println(arg + " : " + sol.reverse(arg));
		arg = int2;
		System.out.println(arg + " : " + sol.reverse(arg)); 
		arg = int3;
		System.out.println(arg + " : " + sol.reverse(arg));	 
		arg = int4;
		System.out.println(arg + " : " + sol.reverse(arg));	
		arg = int5;
		System.out.println(arg + " : " + sol.reverse(arg));	
		arg = int6;
		System.out.println(arg + " : " + sol.reverse(arg));	
		arg = int7;
		System.out.println(arg + " : " + sol.reverse(arg));	//*/	
	}//end method
	
	public static void main(String[] args) {
		test();
	}
}

class Solution7 {
	
	private static int MAX_INT_WOUT_LEADING_DIG = 214748364;
	private static int MAX_N_INT_WOUT_LEADING_DIG = -214748364;
	private int[] digits = new int[10];
	int currDigit, nextAvlInx, maxInx, ans;
	
    public int reverse(int x) {
    	
    	//special case
    	if (x > -10 && x < 10) {
    		return x;
    	}
    	
    	nextAvlInx = 0;
    	while (x != 0) {
    		currDigit = x % 10;
    		x /= 10;
    		if (nextAvlInx == 0 && currDigit == 0) {
    			continue;
    		}
    		digits[nextAvlInx] = currDigit;	
    		nextAvlInx++;
    	}//end while	
    	maxInx = nextAvlInx - 1;
    	ans = 0;
    	for (nextAvlInx = 0; nextAvlInx < maxInx; nextAvlInx++) {
    		ans *= 10;
    		ans += digits[nextAvlInx];
    	}//rof
    	
    	    	
    	//check if the number exceeds int limits
    	if ((ans > MAX_INT_WOUT_LEADING_DIG || ans < MAX_N_INT_WOUT_LEADING_DIG) || 
    	(ans == MAX_INT_WOUT_LEADING_DIG && digits[maxInx] > 7) ||    
    	(ans == MAX_N_INT_WOUT_LEADING_DIG && digits[maxInx] > 8)) {
    		return 0;
    	}//fi
    	
    	ans *= 10;
    	ans += digits[maxInx];

    	
        return ans;
    }  
}
