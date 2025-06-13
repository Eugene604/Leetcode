package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob260 {

	private static int[] arr1 = {1,2,1,3,2,5};
	private static int[] arr2 = { 0,1,2,3,4,5,6,7,8 };
	private static int[] arr3 = { 1, 2 };

	public static void test() {

		Solution260 solObj = new Solution260();
		int[] testArr;

		testArr = arr1;
		System.out.println("Arr:" + Arrays.toString(testArr));
		System.out.println(Arrays.toString(solObj.singleNumber(testArr)));


		// */
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution260 {
    public int[] singleNumber(int[] nums) {
    	
    	Set<Integer> numSet = new HashSet<>();
    	for (int num:nums) {
    		if (!numSet.add(num)) {
    			numSet.remove(num);
    		}//fi
    	}//rof
    	int[] ansArr = new int[2];
    	Iterator<Integer> iterator = numSet.iterator();
    	ansArr[0] = iterator.next();
    	ansArr[1] = iterator.next();
        return ansArr;
    }//end method
}// end class

