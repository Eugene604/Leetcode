package Problems;

import java.util.*;

public class Prob27 {
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
	static int[] nums9 = {1, 3, 4, 5, 5, 6, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 12, 15, 16};
	
	static int[] nums10 = {-2, -1};
	
	static int[] nums11 = {0, 9, 11, 15};
	
	static int[] nums12 = {0, 6, 7};
	
	static int[] nums13 = {1,3};
	static int[] nums14 = {2,7};
	
	static int[] nums15 = {10000};
	static int[] nums16 = {10001};
	
	static int[] nums17 = {3};
	static int[] nums18 = {1,2,4};
	
	private static void test() {
		int[] testArr;
		int val;
		Solution27 solObj = new Solution27();
		
		testArr = nums0;
		val = 0;
		System.out.println("Arr: " + Arrays.toString(testArr) + " val: " + val);
		System.out.println("Ans: " + solObj.removeElement(testArr,val) + " new Arr: " + Arrays.toString(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr) + " val: " + val);
		System.out.println("Ans: " + solObj.removeElement(testArr,val) + " new Arr: " + Arrays.toString(testArr));
		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr) + " val: " + val);
		System.out.println("Ans: " + solObj.removeElement(testArr, val) + " new Arr: " + Arrays.toString(testArr));
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr) + " val: " + val);
		System.out.println("Ans: " + solObj.removeElement(testArr,val) + " new Arr: " + Arrays.toString(testArr));
		
		testArr = nums5;
		val = 3;
		System.out.println("Arr: " + Arrays.toString(testArr) + " val: " + val);
		System.out.println("Ans: " + solObj.removeElement(testArr,val) + " new Arr: " + Arrays.toString(testArr));
		
		


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution27 {

	 public int removeElement(int[] nums, int val) {
		//special case, nums is null
		if (nums == null || nums.length == 0) {
			return 0;
		}//fi
		
		int currInx=0;
		int currNVInx=-1; // current non-val index
		do {
			if (nums[currInx]!=val) {
				currNVInx++;
				nums[currNVInx] = nums[currInx];
			} else {
				//do nothing
			}//fi			
			currInx++;
		} while (currInx < nums.length);//end while
		return currNVInx+1;        
	}//end method
}//end class
