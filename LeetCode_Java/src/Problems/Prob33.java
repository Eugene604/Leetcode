package Problems;

import java.util.*;

public class Prob33 {

	
	static int[] arr1 = {4,5,6,7,0,1,2};
	static int[] arr2 = {4,5,6,7,0,1,2};
	static int[] arr3 = {1};
	static int[] arr4 = {1,3,2};
	static int[] arr5 = {1,5,1};
	static int[] arr6 = {2,1,2,2,2,2,2,1};
	
	static void test() {
		Solution33 solObj = new Solution33();
		int[] arr;
		int target;
		
		arr = arr1;
		target = 0;
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("target: " + target + " ans: " + solObj.search(arr, target));
		
		/*
		arr = arr1;
		target = 3;
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("target: " + target + " ans: " + solObj.search(arr, target));
		
		arr = arr3;
		target = 0;
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("target: " + target + " ans: " + solObj.search(arr, target));
		//*/
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution33 {
	
    public int search(int[] nums, int target) {      
    	boolean isTargetRightOfPivot = nums[0] > target; 
    	int ans = search(nums, target, isTargetRightOfPivot, 0, nums.length-1); 
        return (ans == -2) ? -1 : ans;
    }//end method	
    
    /**
     * recursively search for target
     * @param nums int array
     * @param target int 
     * @param isTargetRightOfPivot int
     * @param leftInx int 
     * @param rightInx int
     * @return int 
     * 			if found, will return index value, which is >= 0
     * 			if not found, and search range is strictly increasing, then return -2
     * 			if not found, and search range contains pivot (and not at edge index), then return -1
     */
    private int search(int[] nums,  int target, boolean isTargetRightOfPivot, int leftInx, int rightInx) {
    	//System.out.println("left: " + leftInx + " right:" + rightInx);
    	//base case
    	if (leftInx == rightInx) {
    		return (nums[leftInx] == target) ? leftInx : -2;
    	}//fi
    	
    	//current search range is strictly increasing, that is, pivot is not here or at left index
    	if (nums[leftInx]<nums[rightInx]) {    		
    		if (nums[leftInx] > target || nums[rightInx] < target) {
    			return -2;
    		}//fi
			int res = Arrays.binarySearch(nums, leftInx, rightInx+1, target);
			if (res < 0) {
				return -2;
			} else {
				return res;
			}//fi    	
    	}//fi
		
    	int midInx = (rightInx+leftInx)/2;
    	int res;
    	if (isTargetRightOfPivot) {
    		res = search(nums, target, isTargetRightOfPivot, midInx+1, rightInx);
    		if (res >= -1) { //found, or not found at range that contains pivot 
    			return res;   			
    		} else if (res == -2){ //not found at range that is strictly increasing, doesn't mean other side don't have ans
    			return search(nums, target, isTargetRightOfPivot, leftInx, midInx);    			
    		}//fi    		
    	} else { //target on left side
    		res = search(nums, target, isTargetRightOfPivot, leftInx, midInx);
    		if (res >= -1) { //found, or not found at range that contains pivot 
    			return res;   			
    		} else if (res == -2){ //not found at range that is strictly increasing, doesn't mean other side don't have ans
    			return search(nums, target, isTargetRightOfPivot, midInx+1, rightInx);    			
    		}//fi   	
    	}//end switch
    	
    	return -3;
    }//end method
}//end class
