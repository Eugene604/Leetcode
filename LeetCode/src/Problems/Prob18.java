package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob18 {
	public static int[] arr1 = { 1, 0, -1, 0, -2, 2 };
	public static int[] arr2 = { 2, 2, 2, 2, 2 };
	public static int[] arr3 = { 1000000000, 1000000000, 1000000000, 1000000000 };
	public static int[] arr4 = { -1, 2, 2, -5, 0, -1, 4 };
	public static int[] arr5 = { 1000000000, 1000000000, 1000000000, 1000000000, -1000000000, -1000000000, -1000000000,
			-1000000000 };
	public static int[] arr6 = { -2, -1, -1, 1, 1, 2, 2 };
	public static int[] arr7 = { 0, 1, 5, 0, 1, 5, 5, -4 };

	public static void main(String[] args) {
		Solution18 solObj = new Solution18();
		List<List<Integer>> sol;

		
		sol = solObj.fourSum(arr1, 0);
		System.out.println("sol: " + sol.toString());

		sol = solObj.fourSum(arr2, 8);
		System.out.println("sol: " + sol.toString());

		sol = solObj.fourSum(arr3, -294967296);
		System.out.println("sol: " + sol.toString());

		sol = solObj.fourSum(arr4, 3);
		System.out.println("sol: " + sol.toString());

		sol = solObj.fourSum(arr5, 0);
		System.out.println("sol: " + sol.toString());

		sol = solObj.fourSum(arr6, 0);
		System.out.println("sol: " + sol.toString());
		//*/

		sol = solObj.fourSum(arr7, 11); //[[-4,5,5,5],[0,1,5,5]]
		System.out.println("sol: " + sol.toString());
	}

}

class Solution18 {
	static private List<List<Integer>> ansList = new ArrayList<>(200);
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ansList.clear();
		if (nums.length < 4) {
			return ansList;
		} // fi
		Arrays.sort(nums);
		int i, j, k, l;
		long jklTarget, klTarget, currResult;
		for (i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			} else if ((jklTarget = (long) target - nums[i]) - nums[i + 1] - nums[i + 2] - nums[i + 3] < 0) {
				break;
			} // fi
			for (j = i + 1; j < nums.length-2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				} else if ((klTarget = jklTarget - nums[j]) - nums[j + 1] - nums[j + 2] < 0) {
					break;
				} // fi
				k = j + 1;
				l = nums.length - 1;
				while (k < l) {
					currResult = klTarget - nums[k] - nums[l];
					if (currResult == 0) {
						List<Integer> quadruplet = new ArrayList<>(4);
						quadruplet.add(0, nums[i]);
						quadruplet.add(1, nums[j]);
						quadruplet.add(2, nums[k]);
						quadruplet.add(3, nums[l]);
						ansList.add(quadruplet);
					} // fi

					if (currResult > 0) {
						k++;
						while (k < l && nums[k] == nums[k - 1]) {
							k++;
						} // end while
					} else {
						l--;
						while (k < l && nums[l] == nums[l + 1]) {
							l--;
						} // end while
					} // fi

				} // end while
			} // rof
		} // rof
		return ansList;
	}// end method

}// end class