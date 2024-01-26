package Problems;

import java.math.BigInteger;
import java.util.Arrays;


public class Prob1503 {
	
	private static int[] arr1 = {4,3};
	private static int[] arr2 = {0,1};
	public static void test() {
		Solution1503 solObj = new Solution1503();
		
		int n;
		int[] leftArr, rightArr;
		
		
		n = 4 ;
		leftArr = arr1;
		rightArr = arr2;
		System.out.println("n: " + n + " Arrays: " + Arrays.toString(leftArr) + ":" + Arrays.toString(rightArr));
		System.out.println("sol: " + solObj.getLastMoment(n, leftArr, rightArr));

	}// end method

	private static void test2() {


	}// end method

	public static void main(String[] args) {
		test();
		// test2();
	}// end method

}

class Solution1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
    	int farthest = 0;
    	for (int pos:left) {
    		if (pos > farthest) {
    			farthest = pos;
    		}//fi
    	}//rof
    	
    	int dist;
       	for (int pos:right) {
       		dist = n - pos;
    		if (dist > farthest) {
    			farthest = dist;
    		}//fi
    	}//rof
    	
        return farthest;
    }// end method
}// end class
