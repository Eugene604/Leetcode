package Problems;

import java.util.*;

public class Prob35 {

	
	static int[] arr1 = {1,3,5,6};
	static int[] arr2 = {5,7,8,10};
	static int[] arr3 = {1};
	static int[] arr4 = {2,3,4};
	static int[] arr5 = {3,3,3};
	static int[] arr6 = {1,1,2};
	
	static void test() {
		Solution35 solObj = new Solution35();
		int[] arr;
		int target;
		
		arr = arr4;
		target = 5;
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + solObj.searchInsert(arr, target));

		
		
		arr = arr1;
		target = 5;
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + solObj.searchInsert(arr, target));

		arr = arr1;
		target = 6;
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + solObj.searchInsert(arr, target));
		
		arr = arr1;
		target = 7;
		System.out.print("arr: " + Arrays.toString(arr));
		System.out.println(" target: " + target + " ans: " + solObj.searchInsert(arr, target));
		
		//*/
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution35 {
	
    public int searchInsert(int[] nums, int target) {
    	int ansInx = searchTarget(nums, target, 0, nums.length-1);
    	ansInx = (ansInx < 0) ? -ansInx-1 : ansInx;
        return ansInx;
    }//end method
	

    
    /**
     * Binary search target, also update auxiliary indices
     * preconditions: 
     * - input arrays are initialized
     * @param numArr - int[]
     * @param target - int
     * @param leftSearchInx - int
     * @param rightSearchInx - int		
     * @return index of the target. if not found, return negative if the index to be inserted - 1
     */ 
    private int searchTarget(int[] numArr, int target, int leftSearchInx, int rightSearchInx) {
    	int mid = (leftSearchInx + rightSearchInx)/2;
    	if (numArr[mid] > target) {
    		if (mid == leftSearchInx) {
    			return -leftSearchInx-1;
    		} else {
    			return searchTarget(numArr, target, leftSearchInx, mid);
    		}//fi
    	} else if (numArr[mid] < target) {
    		if (mid == rightSearchInx) {
    			return -rightSearchInx-2;
    		} else {
    			return searchTarget(numArr, target, mid+1, rightSearchInx);
    		}//fi
    	} else {
    		return mid;
    	}//fi
    }//end method   
}//end class
