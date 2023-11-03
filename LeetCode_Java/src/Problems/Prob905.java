package Problems;

import java.util.Arrays;
import java.util.Stack;

public class Prob905 {

	static int[] arr1 = {3,1,2,4};
	static int[] arr2 = {0};
	static int[] arr3 = {3,3,3,3,3,3,3,3};
	static int[] arr4 = {4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	
	static void test() {
		Solution905 solObj = new Solution905();
		int[] testArr;


		
		/*
				testArr = arr1;
		System.out.println("testArr: " + Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.sortArrayByParity(testArr)));
		
		testArr = arr2;
		System.out.println("testArr: " + Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.sortArrayByParity(testArr)));
		//*/
		
		testArr = arr3;
		System.out.println("testArr: " + Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.sortArrayByParity(testArr)));
		
		testArr = arr4;
		System.out.println("testArr: " + Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.sortArrayByParity(testArr)));

	}//end method

	public static void main(String args[]) {
		test();
	}//end main

}

class Solution905 {

	private static int[] stackArr = new int[5000];
	private int nextStackEleAddr = 0;


	public int[] sortArrayByParity(int[] nums) {
		//base case, nums size < 2;
		if (nums.length<2) {
			return nums;
		}//fi
		
		int availSpotInx = 0;
		for (int i=0; i<nums.length; i++) {
			if (nums[i]%2==0) { //even
				if (i>availSpotInx) {
					nums[availSpotInx]=nums[i];
				}//fi
				availSpotInx++;
			} else { //odd
				push(nums[i]);
			}//fi
						
		}//fi
		
		while (availSpotInx<nums.length) {
			nums[availSpotInx] = pop();
			availSpotInx++;
		}//end while
        return nums;
    }// end method

	/**
	 * Precondition: - stackArray is not null
	 * 
	 * @param inx - int value denoting the index value to be stored
	 */
	private void push(int inx) {	
		stackArr[nextStackEleAddr] = inx;	
		nextStackEleAddr++;
	}// end method

	/**
	 * Precondition: - stackArray is not null
	 * 
	 * return int which is the top element, -1 if stack is empty
	 */
	private int pop() {
		if (nextStackEleAddr > 0) {
			nextStackEleAddr--;
			return stackArr[nextStackEleAddr];
		} // fi
		return -1;
	}// end method
}// end class

