package Problems;

import java.util.*;

public class Prob287 {
	static int[] nums0 = {0};
	static int[] nums1 = {1,2};
	static int[] nums2 = {3,5};
	
	static int[] nums3 = {};
	static int[] nums4 = {2,3,4};
	
	static int[] nums5 = {0, 1, 2, 3, 3, 3, 3, 8};
	static int[] nums6 = {0, 3, 5, 17, 18, 22, 33};	
	
	static int[] nums7 = {6};
	static int[] nums8 = {};

	// index .............0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16, 17, 18, 19, 20
	static int[] nums10 = {1,3,4,2,2};
	
		
	static int[] nums11 = {3,1,3,4,2};
	private static void test() {
		int[] testArr;
		Solution287 solObj = new Solution287();
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums6;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		
		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
		testArr = nums11;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.findDuplicate(testArr));
		
	


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution287 {
	private boolean[] hasAppeared;
    public int findDuplicate(int[] nums) {
    	hasAppeared = new boolean[100001];
    	for (int num:nums) {
    		if (hasAppeared[num]) {
    			return num;
    		}//fi
    		hasAppeared[num] = true;
    	}//rof
        return 0;
    }//end method
    
	
}//end class
