package Problems;

import java.util.*;


public class Prob1464 {
	static int[] nums0 = {3,4,5,2};
	static int[] nums1 = {1,2,2,6,6,6,6,7,10};
	static int[] nums2 = {7};	
	static int[] nums3 = {7,6,9,6,9,6,9,7};

	static int[] nums4 = {6,1,9};
	
	static int[] nums10;
	static int[] nums11;
	static int[] nums12;

	private static void test() {
		

		int[] testArr;
		Solution1464 solObj = new Solution1464();
		
		/*
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
		
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
		
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
		
		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
	
		
		
		

		testArr = nums11;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
		
		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));		
		
		
		
		testArr = nums12;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));	
			//*/
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProduct(testArr));
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1464 {

	 public int maxProduct(int[] nums) {
		 //step 1: find max and second max
		 int max = 0, secMax = 0;
		 for (int num:nums) {
			 if (num < secMax) {
				 continue;		 
			 } else if (num > max) {
				 secMax = max;
				 max = num;				 
			 } else {
				secMax = num; 
			 }//fi			 
		 }//rof
		 System.out.println("max: " + max + " secMax: " + secMax);
		 return (max-1)*(secMax-1);
	 }//end method
	
}//end class
