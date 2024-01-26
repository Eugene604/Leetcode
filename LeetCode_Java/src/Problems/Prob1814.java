package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob1814 {
	static int[] nums0 = {42,11,1,97};
	static int[] nums1 = {3,5,4,2,4,6};
	static int[] nums2 = {13,10,35,24,76};	
	static int[] nums3 = {1,2,3};
	static int[] nums4 = {2,3,3,1,4};
	

	

	
	private static void test() {
		int[] testArr;
		Solution1814 solObj = new Solution1814();
		
		/*
	
		
		//*/

		
		testArr = nums2; 
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.countNicePairs(testArr));
		

	}
	
	public static void main(String[] args) {
		test();
		


	}//end main
}


class Solution1814 {
	
	private static final long MOD_CONST = 1000000007;

	
	public int countNicePairs(int[] nums) {
		//step 1, populate diff map 
		Map<Integer, int[]> diffMap = new HashMap<>(); //map< difference, amount of indices having such diff>
		int[] inxCount;
		int diff;
		for (int i=0; i< nums.length; i++) {
			diff = nums[i] - reverse(nums[i]);
			if ((inxCount=diffMap.get(diff))==null) {
				inxCount = new int[1];
				diffMap.put(diff, inxCount);
			}//fi
			inxCount[0]++;
		}//rof
		
		//step 2, count number of pairs based on diff map
		long count = 0;
		for (Entry<Integer, int[]> entry:diffMap.entrySet()) {
			count += getComb(entry.getValue()[0]);
		}//rof	
		return (int)(count%MOD_CONST);
    }//end method
	
	/**
	 * get combination of n choose 2
	 * @param n - int, number of items to choose from
	 * @return C(n,2) 
	 */
	private long getComb(int n) {
		return ((long)n*(n-1)/2);	
	}//end getComb
	
	/**
	 * reverse an int
	 * @param i, int - the number to be reversed, 0 <= i <= 10^9
	 * @return reversed int
	 */
	private int reverse(int i) {
		int revI = 0;
		int remainder;
		while (i>0) {
			remainder = i%10;
			revI = revI*10 + remainder;
			i /= 10;
		}//end while
		return revI;
	}//end method
}//end class
