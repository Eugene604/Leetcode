package Problems;

import java.util.*;


public class Prob1287 {
	static int[] nums0 = {0};
	static int[] nums1 = {1,2,2,6,6,6,6,7,10};
	static int[] nums2 = {7};	
	static int[] nums3 = {7,6,9,6,9,6,9,7};

	static int[] nums4 = {6,1,9};
	
	static int[] nums10;
	static int[] nums11;
	static int[] nums12;

	private static void test() {
		

		int[] testArr;
		Solution1287 solObj = new Solution1287();
		
		/*
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
		
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
		
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
		
		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
	
		
		
		

		testArr = nums11;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
		
		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));		
		
		
		
		testArr = nums12;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));	
			//*/
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findSpecialInteger(testArr));
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1287 {

	public int findSpecialInteger(int[] arr) {
		int quarterCount = arr.length >> 2;
		//System.out.println(quarterCount);
		for (int i=0; i<arr.length-quarterCount; i++) {
			if (arr[i]==arr[i+quarterCount]) {
				return arr[i];
			}//fi
		}//rof
        return -1;
    }//end method
	
}//end class
