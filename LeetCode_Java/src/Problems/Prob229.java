package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob229 {

	private static int[] arr1 = { 3, 2, 3 };
	private static int[] arr2 = { 1 };
	private static int[] arr3 = { 1, 2 };

	public static void test() {

		Solution229 solObj = new Solution229();
		int[] testArr;

		testArr = arr1;
		System.out.println(solObj.majorityElement(testArr) + ":" + Arrays.toString(testArr));


		// */
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution229 {
	public List<Integer> majorityElement(int[] nums) {
		

		Map<Integer, Integer> countMap = new HashMap<>(nums.length);		
		int countCutOff = nums.length / 3;
		int twoThirdCutOff = nums.length-countCutOff;
		Integer val;
		int i;
		for (i=0; i<twoThirdCutOff;i++) {
			if ((val=countMap.get(nums[i]))==null) {
				countMap.put(nums[i], 1);
			} else {
				countMap.put(nums[i], val+1);
			}//fi
		}//rof
		
		for (; i<nums.length;i++) {
			if ((val=countMap.get(nums[i]))==null) {
				continue;
			} else {
				countMap.put(nums[i], val+1);
			}//fi
		}//rof
		
		/*
		for (int i:nums) {
			if ((val=countMap.get(i))==null) {
				countMap.put(i, 1);
			} else {
				countMap.put(i, val+1);
			}//fi
		}//rof */
		//System.out.println("count map " + countMap);
		
		
		List<Integer> ansList = new ArrayList<>(2);
		for (Entry<Integer,Integer> entry:countMap.entrySet()) {
			if (entry.getValue()>countCutOff) {
				ansList.add(entry.getKey());
			}//fi
		}//rof
		return ansList;
	}// end method
}// end class

