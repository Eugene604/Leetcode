package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1441 {

	private static int[] arr1 = {1,3};
	private static int[] arr2 = {1,2,3};
	private static int[] arr3 = {1,2};
	
	public static void main(String[] args) {
		Solution1441 solObj = new Solution1441();
		int[] target;
		int n;

		target = arr1;
		n=3;
		System.out.println(Arrays.toString(target));
		System.out.println("ans: " + solObj.buildArray(target, n));

		target = arr2;
		n=3;
		System.out.println(Arrays.toString(target));
		System.out.println("ans: " + solObj.buildArray(target, n));
		
		target = arr3;
		n=3;
		System.out.println(Arrays.toString(target));
		System.out.println("ans: " + solObj.buildArray(target, n));
	}

}//end class

class Solution1441 {

	private List<String> ansList;
	private int intStreamTopVal;
	
	public List<String> buildArray(int[] target, int n) {
		ansList = new ArrayList<>(100);
		intStreamTopVal = 1;
		for (int currVal : target) {
			for (int pushPopCount = currVal-intStreamTopVal; pushPopCount>0; pushPopCount--) {
				push();
				pop();
			}//rof
			push();
		}//rof
		return ansList;
	}//end method
	
	/**
	 * simulate a push operation
	 * precondition:
	 * required data structure and variable are instantiated and set - ansList, intStreamTopVal
	 * 
	 * postcondition:
	 * - intStreamTopVal increment by one
	 * - operation is recorded in answer list
	 */
	private void push() {
		intStreamTopVal++;
		ansList.add("Push");
	}//end method

	/**
	 * simulate a pop operation
	 * precondition:
	 * required data structure is instantiated - ansList
	 * 
	 * postcondition:
	 * - operation is recorded in answer list
	 */
	private void pop() {
		ansList.add("Pop");
	}//end method
}// end class
