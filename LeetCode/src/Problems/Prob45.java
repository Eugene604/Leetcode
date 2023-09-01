package Problems;

import java.util.*;

public class Prob45 {
	static int[] nums0 = {0};
	static int[] nums1 = {2,3,1,1,4};
	static int[] nums2 = {2,3,0,1,4};
	
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
		Solution45 solObj = new Solution45();
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		/*

		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		testArr = nums5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.jump(testArr));
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution45 {

    public int jump(int[] nums) {
    	int lastInx = nums.length - 1;
    	//special case
    	if (lastInx == 0) {
    		return 0;
    	}//fi
    	
    	int numOfJumps = 1;
    	int currLongestJumpPt = nums[0];
    	int prevLongestJumpPt = 0;
    	int tmpInx, tmpJumpPt, nextLongestJumpPt = 0;
    	while (currLongestJumpPt < lastInx) {
    		for (tmpInx = prevLongestJumpPt + 1; tmpInx <= currLongestJumpPt; tmpInx++) {
    			tmpJumpPt = nums[tmpInx]+tmpInx;
    			if (tmpJumpPt >= lastInx) {
    				return ++numOfJumps;
    			} else if (tmpJumpPt > nextLongestJumpPt) {
    				nextLongestJumpPt = tmpJumpPt;
    			}//fi
    		}//rof
    		prevLongestJumpPt = currLongestJumpPt;
    		currLongestJumpPt = nextLongestJumpPt;
    		numOfJumps++;
    	}//end while
    	
        return numOfJumps;
    }//end method
}//end class
