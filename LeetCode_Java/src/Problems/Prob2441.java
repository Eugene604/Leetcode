package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob2441 {
	

	
	public static void test() {

		Solution2441 sol = new Solution2441();
		int[] nums1 = {-1,2,-3,3};
		int[] nums2 = {-1,10,6,7,-7,1};
		
		int[] nums; 

		
		nums = nums1;
		System.out.println("arr: " + Arrays.toString(nums ));
		System.out.println("ans: " + sol.findMaxK(nums ));
		
		nums = nums2;
		System.out.println("arr: " + Arrays.toString(nums ));
		System.out.println("ans: " + sol.findMaxK(nums ));
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution2441 {
	/*
	 * index - the number in nums
	 * val - state, here are state values:
	 *  current mark - means positive number has appeared before
	 *  negative of current mark - means negative version of this number has appeared before   
	 */
	static int[] numStatusArr = new int[1001];

	static int stateMark = 0;
	public int findMaxK(int[] nums) {
		stateMark++;
		int maxK = -1;
		int absNum;
		int oppositeSign;
		for (int num:nums) {
			if (num>0) {
				absNum = num;
				oppositeSign = -1;
			} else {
				absNum = -num;
				oppositeSign = 1;
			}//fi

			if (numStatusArr[absNum] == oppositeSign*stateMark) { //negative version of this number has appeared before 
				if (absNum>maxK) {
					maxK = absNum;
				}//fi
			} else { // number has not appeared before or number with same sign has appeared before
				numStatusArr[absNum] = -oppositeSign*stateMark;
			}//fi			
		}//rof
		//System.out.println(Arrays.toString(numStatusArr));
        return maxK;
    }//end method
    
}//end class
