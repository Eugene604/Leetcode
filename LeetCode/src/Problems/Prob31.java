package Problems;

import java.util.*;

public class Prob31 {

	
	static int[] arr1 = {1,2,3};
	static int[] arr2 = {2,3,1};
	static int[] arr3 = {1,1,5};
	static int[] arr4 = {1,3,2};
	static int[] arr5 = {1,5,1};
	static int[] arr6 = {2,1,2,2,2,2,2,1};
	
	static void test() {
		Solution31 solObj = new Solution31();
		int[] arr;
		
		/*
		arr = arr1;
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
		
		arr = arr2;
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
		//*/
		
		arr = arr3;
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
		
		
		arr = arr4; //[2,1,3]
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
		
		
		arr = arr5; //[5,1,1]
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
		
		
		arr = arr6; //[2,2,1,1,2,2,2,2]
		System.out.print("orignal arr: " + Arrays.toString(arr));
		solObj.nextPermutation(arr);
		System.out.println(" processed arr: " + Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution31 {
    public void nextPermutation(int[] nums) {
    	int lastInx = nums.length-1;
    	//special case: nums contains only one element
    	if (lastInx == 0) {
    		return;
    	}//fi
    	int tmpInt;
    	int replacementInx;
    	for (int currInx=lastInx-1; currInx>=0 ;currInx--) {    		
    		if (nums[lastInx] > nums[currInx]) {
    			replacementInx = Arrays.binarySearch(nums, currInx+1, nums.length,nums[currInx]+1);
    			if (replacementInx < 0) {
    				replacementInx = -replacementInx-1;
    			} else {
    				while (nums[replacementInx] == nums[--replacementInx]) {
    					
    				}//end while
    				replacementInx++;
    			}//fi
    			tmpInt = nums[currInx];
    			nums[currInx] = nums[replacementInx];
    			nums[replacementInx] = tmpInt;
    			return;
    		} else {
    			Arrays.sort(nums,currInx,nums.length);		
    		}//fi    		
    	}//end for
    }//end method	
}//end class