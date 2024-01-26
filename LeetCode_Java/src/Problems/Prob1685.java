package Problems;

import java.util.Arrays;
import java.util.Stack;

public class Prob1685 {

	static int[] arr1 = {1,2,3,4};
	static int[] arr2 = {2,3,5};
	static int[] arr3 = {1,4,6,8,10};

	
	static void test() {
		Solution1685 solObj = new Solution1685();
		int[] testArr;


		
				
		testArr = arr2;
		System.out.println("testArr: " + Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.getSumAbsoluteDifferences(testArr)));

	}//end method

	public static void main(String args[]) {
		test();
	}//end main

}

class Solution1685 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
    	//step 1, prepare auxiliary array. sums[i] = sum of num[0] to num[i]
    	int[] sums = new int[nums.length];
    	
    	int sum = 0;
    	for (int i=0; i<nums.length; i++) {
    		sum += nums[i];
    		sums[i] = sum;
    	}//rof
    	//System.out.println("sums: " + Arrays.toString(sums));
    	//step 2, populate answer by using following formula: nums[i]*(i - (endInx-i)) - sum(nums left of i) + sum(nums right of i)
    	int[] ansArr = new int[nums.length];
    	int sumOfLeftOfI, sumOfRightOfI;
    	int netSumOfI;
    	int endInx = nums.length - 1;    			
    	for (int i=0; i<nums.length; i++) {
    		sumOfLeftOfI = sums[i] - nums[i];
    		sumOfRightOfI = sums[endInx] - sums[i];
    		netSumOfI = nums[i] * (2*i - endInx);
    		ansArr[i] = netSumOfI - sumOfLeftOfI + sumOfRightOfI;
    	}//rof
        return ansArr;
    }// end method
}// end class

