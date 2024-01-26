package Problems;

import java.util.*;

public class Prob1913 {
	static int[] nums0 = { 5,6,2,7,4 };
	static int[] nums1 = { 4,2,5,9,7,4,8 };
	static int[] nums2 = { 7 };
	static int[] nums3 = { 7, 6, 9, 6, 9, 6, 9, 7 };

	static int[] nums4 = { 6, 1, 9 };

	static int[] nums10;
	static int[] nums11;
	static int[] nums12;

	private static void test() {

		int[] testArr;
		Solution1913 solObj = new Solution1913();

		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProductDifference(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.maxProductDifference(testArr));
	}// end test

	public static void main(String[] args) {
		test();
	}// end main
}

class Solution1913 {

	public int maxProductDifference(int[] nums) {
		Arrays.sort(nums, 0, 4);
		int max = nums[3], secMax = nums[2];
		int min = nums[0], secMin = nums[1];
		for (int i=4; i<nums.length; i++) {
			if (nums[i] > max) {
				secMax = max;
				max = nums[i];
			} else if (nums[i] > secMax) {
				secMax = nums[i];
			} else if (nums[i] < min) {
				secMin = min;
				min = nums[i];
			} else if (nums[i] < secMin) {
				secMin = nums[i];
			} // fi
		} // rof
		System.out.println("max: " + max + " secMax: " + secMax + " min: " + min + " secMin: " + secMin);
		return max*secMax - min*secMin;
	}// end method

}// end class
