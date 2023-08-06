package Problems;

import java.util.*;

public class Prob34 {

	
	static int[] arr1 = {5,7,7,8,8,10};
	static int[] arr2 = {5,7,7,8,8,10};
	static int[] arr3 = {1};
	static int[] arr4 = {3,3};
	static int[] arr5 = {3,3,3};
	static int[] arr6 = {1,1,2};
	
	static void test() {
		Solution34 solObj = new Solution34();
		int[] arr, ansArr;
		int target;
		
		
		arr = arr1;
		target = 8;
		ansArr = solObj.searchRange(arr, target);
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + Arrays.toString(ansArr));
		
		/*
		arr = arr1;
		target = 6;
		ansArr = solObj.searchRange(arr, target);
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + Arrays.toString(ansArr));	
			
		
		arr = arr4;
		target = 3;
		ansArr = solObj.searchRange(arr, target);
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + Arrays.toString(ansArr));	
		
		arr = arr5;
		target = 3;
		ansArr = solObj.searchRange(arr, target);
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + Arrays.toString(ansArr));	
	
		
		arr = arr6;
		target = 1;
		ansArr = solObj.searchRange(arr, target);
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + Arrays.toString(ansArr));
		//*/
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution34 {
	
	
	/**
	 * auxInxes[0] - left most target index known so far, only valid if target is found
	 * auxInxes[1] - right most target index known so far, only valid if target is found
	 */
	private int[] auxInxes = new int[2];
	
    public int[] searchRange(int[] nums, int target) {
    	int lastInx = nums.length-1;
    	//special cases, length = 0
    	if (lastInx==-1) {
    		return new int[] {-1,-1};
    	} //fi
    	
    	auxInxes[0] = Integer.MAX_VALUE;
    	auxInxes[1] = -1;
    	
    	int ansInx = searchTarget(nums, target, 0, lastInx, auxInxes);
    	//System.out.println("ansInx: " + ansInx + " : " + Arrays.toString(auxInxes)); 
    	
    	if (ansInx < 0) {
    		return new int[] {-1,-1};
    	} else {
    		return auxInxes;
    	}//fi
    }//end method
    
    /**
     * Binary search target, also update auxiliary indices
     * preconditions: 
     * - input arrays are initialized
     * @param numArr - int[]
     * @param target - int
     * @param leftSearchInx - int
     * @param rightSearchInx - int
     * @param auxInxes - int[]
	 * 			auxInxes[0] - left most target index known so far, only valid if target is found
	 *		 	auxInxes[1] - right most target index known so far, only valid if target is found		
     * @return index of the target. if not found, return -1
     */ 
    private int searchTarget(int[] numArr, int target, int leftSearchInx, int rightSearchInx, int[] auxInxes) {
    	int mid = (leftSearchInx + rightSearchInx)/2;
    	if (numArr[mid] > target) {
    		if (mid == leftSearchInx) {
    			return -1;
    		} else {
    			return searchTarget(numArr, target, leftSearchInx, mid, auxInxes);
    		}//fi
    	} else if (numArr[mid] < target) {
    		if (mid == rightSearchInx) {
    			return -1;
    		} else {
    			return searchTarget(numArr, target, mid+1, rightSearchInx, auxInxes);
    		}//fi
    	} else {
			auxInxes[0] = (mid < auxInxes[0])? mid : auxInxes[0];
			auxInxes[1] = (mid > auxInxes[1])? mid : auxInxes[1];
			if (leftSearchInx == rightSearchInx) {
				return mid;
			}//fi
	    	//algorithm does not end until search range is 1 or both search bound also = target
			if (numArr[leftSearchInx]==target) {
				auxInxes[0] = (leftSearchInx < auxInxes[0])? leftSearchInx : auxInxes[0];
			} else {
				searchTarget(numArr, target, leftSearchInx, mid-1, auxInxes);
			}//fi
			if (numArr[rightSearchInx]==target) {
				auxInxes[1] = (rightSearchInx > auxInxes[1])? rightSearchInx : auxInxes[1];
			} else {
				searchTarget(numArr, target, mid+1, rightSearchInx, auxInxes);
			}//fi
    		return mid;
    	}//fi
    }//end method   
}//end class
