package Problems;

import java.util.*;

public class Prob896 {
	static int[] nums0 = {0};
	static int[] nums1 = {1,2,2,3};
	static int[] nums2 = {6,5,4,4};
	
	static int[] nums3 = {1,3,2};
	
	
	private static void test() {
		int[] testArr;
		Solution896 solObj = new Solution896();
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.isMonotonic(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.isMonotonic(testArr));
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.isMonotonic(testArr));


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution896 {

	public boolean isMonotonic(int[] nums) {
		//special case
		if (nums.length==1) {
			return true;
		}//fi
		
		int trend = nums[0]-nums[nums.length-1];
		if (trend>=0) {
			for (int i=1;i<nums.length;i++) {
				if (nums[i-1]-nums[i]<0) {
					return false;
				}//fi
			}//rof
		} else {
			for (int i=1;i<nums.length;i++) {
				if (nums[i-1]-nums[i]>0) {
					return false;
				}//fi
			}//rof
		}//fi

        return true;
    }//end method
}//end class
