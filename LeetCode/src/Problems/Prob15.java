package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob15 {
	public static int[] arr1 = {-1,0,1,2,-1,-4};
	public static int[] arr2 = {1,2,-2,-1};
	public static int[] arr3 = {0,1,1};
	public static int[] arr4 = {-1,-2,-3,-4,-5};
	public static int[] arr5 = {0,0,0};
	public static int[] arr6 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
	public static int[] arr7 = {-2,0,1,1,2};
	

	
	public static void main(String[] args) {
		Solution15 solObj = new Solution15();
		List<List<Integer>> sol;
		/*
		sol = solObj.threeSum(arr1);
		System.out.println("sol: " + sol.toString());
		sol = solObj.threeSum(arr2);
		System.out.println("sol: " + sol.toString());
		sol = solObj.threeSum(arr3);
		System.out.println("sol: " + sol.toString());
		sol = solObj.threeSum(arr4);
		System.out.println("sol: " + sol.toString());
		sol = solObj.threeSum(arr5);
		System.out.println("sol: " + sol.toString());
		sol = solObj.threeSum(arr6);
		//[[-1, -1, 2], [-2, -1, 3], [-3, -1, 4], [-3, 1, 2], [-4, 1, 3], [-1, 0, 1], [-2, 0, 2], [-3, 0, 3], [-4, 0, 4]]
		System.out.println("sol: " + sol.toString()); //*/
		sol = solObj.threeSum(arr7);
		//[[-2,0,2],[-2,1,1]]
		System.out.println("sol: " + sol.toString());		
	}

}


class Solution15 {
	 	
	private Set<List<Integer>> ansSet = new HashSet<>();
	
	public List<List<Integer>> threeSum(int[] nums) {
		ansSet.clear();
		//first phase, initialize array
		Arrays.sort(nums);
		
		int currSearchVal, rightSearchRange;
		loopj:
		for (int j=nums.length-2; j>0; j--) {
			if (j < nums.length-2 && nums[j]==nums[j+1] && nums[j]==nums[j+2]) {
				continue loopj;
			}//fi
			rightSearchRange = j;
			for (int k=j+1; k<nums.length;k++) {
				if (k-j>1 && nums[k]==nums[k-1]) {
					continue;
				}//fi
				int numsi = 0-nums[j]-nums[k];
				if (numsi > nums[j] ) {
					continue;
				} else if (numsi < nums[0] ) {
					continue loopj;
				}//fi
				currSearchVal = Arrays.binarySearch(nums, 0, rightSearchRange, numsi);
				if (currSearchVal < 0) {
					continue;
				} else {
					rightSearchRange = currSearchVal+1;
				}//fi
				List<Integer> tmpTupleList = new ArrayList<>(3);
				tmpTupleList.add(numsi);
				tmpTupleList.add(nums[j]);
				tmpTupleList.add(nums[k]);
				ansSet.add(tmpTupleList);
			}//rof k
		}//rof j
		
		List<List<Integer>> ansList = new LinkedList<>(ansSet);   	
		return ansList;
	}//end method
}//end class