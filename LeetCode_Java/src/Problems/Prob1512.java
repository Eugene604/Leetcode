package Problems;

import java.util.*;

public class Prob1512 {
	static int[] nums0 = {0};
	static int[] nums1 = {1,2,3,1,1,3};
	static int[] nums2 = {1,1,1,1};	
	static int[] nums3 = {1,2,3};
	static int[] nums4 = {2,3,3,1,4};
	

	

	
	private static void test() {
		int[] testArr;
		Solution1512 solObj = new Solution1512();
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numIdenticalPairs(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numIdenticalPairs(testArr));
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numIdenticalPairs(testArr));
		
		

		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numIdenticalPairs(testArr));
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numIdenticalPairs(testArr));

		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1512 {

	private static final int[] COMBIN_LOOKUP = {
			0,0,1,3,6,10,15,21,28,36,45,55,66,78,91,105,120,136,153,171,190,210,231,253,276,300,325,351,378,406,435,465,496,528,561,595,630,666,703,741,780,820,861,903,946,990,1035,1081,1128,1176,1225,1275,1326,1378,1431,1485,1540,1596,1653,1711,1770,1830,1891,1953,2016,2080,2145,2211,2278,2346,2415,2485,2556,2628,2701,2775,2850,2926,3003,3081,3160,3240,3321,3403,3486,3570,3655,3741,3828,3916,4005,4095,4186,4278,4371,4465,4560,4656,4753,4851,4950	
	};
	
	private int[] numCounter;
	
    public int numIdenticalPairs(int[] nums) {       	
    	//special case, nums array size less than 2
    	if (nums.length<2) {
    		return 0;
    	}//fi
    	
    	numCounter = new int[101];
    	//step 1, populate number counts
    	for (int num:nums) {
    		numCounter[num]++;
    	}//rof
    	
    	//step 2, sum up all combinations
    	int totalPairs = 0;
    	for (int count:numCounter) {
    		totalPairs += COMBIN_LOOKUP[count];
    	}//rof
        return totalPairs;
    }//end method
}//end class
