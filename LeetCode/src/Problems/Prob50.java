package Problems;

import java.util.*;

public class Prob50 {
	
	
	private static void test() {
	
		double x;
		int n;
		
		x = 2.0;
		n = 10;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		x = 2.1;
		n = 3;
		System.out.println("x: " + x + " n: " + n + " ans:" +  new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	
		
		x = 2.0;
		n = -2;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		x = 0.00001;
		n = 2147483647;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		x = 0.00001;
		n = 2147483646;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
				x = 2.00000;
		n = -2147483648;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));

		
		x = 2.00000;
		n = -2147483648;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		x = 1.0000000000001;
		n = -2147483648;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		x = -1.00000;
		n = -2147483647;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		x = -1.00000;
		n = -2147483648;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
		
		
		
		x = 34.00515;
		n = -3;
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));
			//*/

		
		x = 2.0;
		n = 12;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		
		x = 2.0;
		n = 11;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		x = 2.0;
		n = 10;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		
		x = 2.0;
		n = 9;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		

		x = 2.0;
		n = 5;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		
		x = 2.0;
		n = 4;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

	
		
		x = 2.0;
		n = 3;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	
       //*/
		x = 2.0;
		n = 7;		
		System.out.println("x: " + x + " n: " + n + " ans:" + new Solution50().myPow(x, n) + " true ans: " + Math.pow(x,n));	

		
	}
	
	public static void main(String[] args) {
		test();
	}
}

class Solution50 {
	
	
    public double myPow(double x, int n) {

    	//special cases
    	if (x == 1d || n == 0) {
    		return 1d;
    	} else if (x == -1d) {
    		return (n%2)==0?1d:-1d;
    	} else if (x == 0d) {
    		return 0d;
    	} else if (n == Integer.MIN_VALUE) {
    		n /= 2;
    		x *= x;
    	}//fi
    	
    	if (n<0) {
        	x = 1/x;
        	n = -n;
    	}//fi  
    	
    	return simplePow(x,n);

        
    }//end method
    
    /**
     * simple power function that accepts only positive power and doesn't care special or edges cases
     * precondition:
     * - n >= 1
     * 
     * @param x - double, the base number
     * @param n - int, the power
     * @return x^n
     */
    private double simplePow(double x, int n) {    	
    	if (n==1) {
    		return x;
    	}//fi
    	double tmp = simplePow(x, n/2);
    	if (n%2==1) {    		
    		return x*tmp*tmp;
    	} else {
    		return tmp*tmp;
    	}//fi
    }//end method
   
}//end class

class Solution50_v1 {
	
	private static double[][] stackArr = new double[35][2];
	private int lastStackElementInx = -1;

    public double myPow(double x, int n) {

    	//special cases
    	if (x == 1d || n == 0) {
    		return 1d;
    	} else if (x == -1d) {
    		return (n%2)==0?1d:-1d;
    	} else if (x == 0d) {
    		return 0d;
    	} else if (n == Integer.MIN_VALUE) {
    		n /= 2;
    		x *= x;
    	}//fi
    	
    	if (n<0) {
        	x = 1/x;
        	n = -n;
    	}//fi  
    	
    	double[] tmpStackElement = new double[2];
    	tmpStackElement[0] = 1d;
    	tmpStackElement[1] = x;
    	push(tmpStackElement);
    	
    	double ans = x;   
    	int currPow = 1;

    	
    	while (currPow<=n/2) {
    		ans *= ans;
    		currPow *= 2;
        	tmpStackElement[0] = currPow;
        	tmpStackElement[1] = ans;
        	push(tmpStackElement);
    	}//fi
    	
    	n -= currPow;
    	while (n > 0) {
    		if ((tmpStackElement=pop())==null) {
    			break;
    		} else if (tmpStackElement[0]>n) {
    			continue;
    		}//fi
    		n -= tmpStackElement[0];
    		ans *= tmpStackElement[1];
    	}//end while

   		return ans;

        
    }//end method
    
    /**
     * Precondition: it is assumed that stack size is not greater than 32
     * @param element byte type
     */
    private void push(double[] element) {
    	++lastStackElementInx;
    	stackArr[lastStackElementInx][0] = element[0];
    	stackArr[lastStackElementInx][1] = element[1];
    }//end method
    
    
    /**
     * 
     * @return null if stack is empty
     */
    private double[] pop() {
    	if (lastStackElementInx < 0) {
    		return null;
    	} else {
    		return stackArr[lastStackElementInx--];
    	}//fi
    }//end method
}//end class

