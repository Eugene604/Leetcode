package Problems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob1877 {
	static int[] nums0 = {3,5,2,3};
	static int[] nums1 = {3,5,4,2,4,6};
	static int[] nums2 = {16278,44089,36075,22063,51446,58226,85734,26675,73668,81561};	
	static int[] nums3 = {1,2,3};
	static int[] nums4 = {2,3,3,1,4};
	

	

	
	private static void test() {
		int[] testArr;
		Solution1877 solObj = new Solution1877();
		
		/*
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minPairSum(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minPairSum(testArr));
	

		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minPairSum(testArr));
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minPairSum(testArr));

		
		//*/

		
		testArr = nums2; //103624
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minPairSum(testArr));
		

	}
	
	public static void main(String[] args) {
		test();
		


	}//end main
}


class Solution1877 {

    public int minPairSum(int[] nums) {
    	//special case:
    	if (nums.length == 2) {
    		return nums[0]+nums[1];
    	}//fi
    	
    	Arrays.parallelSort(nums);


    	int maxPairSum = nums[0]+nums[nums.length-1];
    	int leftInx = 1, rightInx = nums.length-2;
    	while (rightInx>leftInx) {
    		maxPairSum = Math.max(maxPairSum, nums[leftInx]+nums[rightInx]);
    		rightInx--;
    		leftInx++;
    	}//end while
        return maxPairSum;
    }//end method
}//end class
