package Problems;

import java.util.*;

public class Prob1306 {
	static int[] nums0 = {0};
	static int[] nums1 = {2,3,1,1,4};
	static int[] nums2 = {2,3,0,1,4};
	
	static int[] nums3 = {3,2,1,0,4};
	
	static int[] nums4 = {4,2,3,0,3,1,2};	
	static int[] nums5 = {3,0,2,1,2};
	
	static int[] nums6 = {47,26,216,78,179,101,42,233,185,56,303,310,169,338,51,104,308,162,81,82,169,41,106,150,285,298,33,251,289,236,256,227,197,186,267,326,268,243,89,347,72,0,89,157,90,333,327,76,106,68,355,124,234,70,43,248,259,280,199,201,312,327,217,278,330,258,348,351,223,240,143,244,64,343,339,101,193,18,140,312,71,225,111,79,199,226,321,344,31,177,362,115,341,79,146,303,348,291,250,169,78,307,325,33,338,316,201,343,37,37,0,15,341,38,44,67,280,128,31,106,220,172,349,142,339,181,102,351,81,209,41,181,59,216,230,170,257,52,5,338,28,75,208,307,108,103,34,342,82,233,263,12,167,358,316,150,337,158,78,231,26,22,147,81,12,319,161,12,75,129,54,119,131,334,292,253,255,98,39,67,146,15,329,120,80,347,89,124,303,315,235,55,1,100,290,187,333,326,87,138,48,41,153,118,192,152,279,69,154,71,152,273,61,153,267,51,106,225,204,327,50,15,202,244,328,3,150,355,240,240,188,92,107,244,280,102,265,273,328,115,70,221,357,101,186,251,116,24,125,58,185,34,356,21,108,221,169,208,230,226,235,336,304,315,334,329,229,190,20,104,348,132,66,265,55,212,102,167,52,2,328,114,101,196,99,155,158,337,191,119,14,347,127,305,142,156,92,340,358,58,7,178,79,355,289,199,251,233,351,57,115,306,179,31,42,123,87,101,218,71,193,205,300,180,42,19,280,233,293,181,147,359,190,168,191,5,58,198,154,139,29,342,261,245,141,26,251,162,360,219,233,297,287,262,112,87,261,21,205,131,98,161,103,57};	
	
	static int[] nums7 = {6};
	static int[] nums8 = {};

	// index .............0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16, 17, 18, 19, 20
	static int[] nums9 = {1, 3, 4, 5, 5, 6, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 12, 15, 16};
	
	static int[] nums10 = {-2, -1};
	
	static int[] nums11 = {0, 9, 11, 15};
	
	static int[] nums12 = {0, 6, 7};
	
	static int[] nums13 = {1,3};
	static int[] nums14 = {2,7};
	
	static int[] nums15 = {10000};
	static int[] nums16 = {10001};
	
	static int[] nums17 = {3};
	static int[] nums18 = {1,2,4};
	
	private static void test() {
		int[] testArr;
		Solution1306 solObj = new Solution1306();
		int startInx;
		
		/*
		testArr = nums0;
		startInx = 0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.canReach(testArr,startInx));
		
		testArr = nums4;
		startInx = 5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.canReach(testArr,startInx));
		
		testArr = nums4;
		startInx = 0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.canReach(testArr,startInx));
		
		testArr = nums5;
		startInx = 2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.canReach(testArr,startInx));
		
		//*/

		testArr = nums6;
		startInx = 313;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.canReach(testArr,startInx));

	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1306 {

	static final int CHECKED_RIGHT = 0b01;
	static final int CHECKED_LEFT = 0b10;
	static final int CHECKED_BOTH = 0b11;
	
    public boolean canReach(int[] arr, int start) {
    	//special case
    	if (arr.length == 1) {
    		return true;
    	}//fi
    	
    	int[] traverseStatusArr = new int[arr.length];
    	return search(arr, traverseStatusArr, start);
    }//end method
    
    /**
     * Precondition:
     *  - it is assumed that currInx is within valid range of arr
     * @param arr in array that holds numbers
     * @param traverseStatusArr int array recording traverse status
     * 		0 - has never been traveled
	 * 		CHECKED_LEFT- has traveled once and from there the search tried to jump left
	 * 		CHECKED_RIGHT - has traveled once and next there the search tried to jump right
	 * 		CHECKED_BOTH - has traveled twice and searched both directions
     * @param currInx int index to be checked
     * @return boolean indicating whether current position leads to a position with 0
     */
    private boolean search(int[] arr, int[] traverseStatusArr, int currInx) {

    	//base cases
    	if (arr[currInx] == 0) {
    		return true;
    	} else if (traverseStatusArr[currInx] == CHECKED_BOTH) { 
    		return false;
    	}//fi
    	
    	int nextInx;
    	if ((traverseStatusArr[currInx] & CHECKED_RIGHT) == 0) {
			traverseStatusArr[currInx] |= CHECKED_RIGHT;
    		if ((nextInx = currInx + arr[currInx]) < arr.length && search(arr, traverseStatusArr, nextInx)) {    			
    			return true;
    		}//fi
    	}//fi
    	
    	if ((traverseStatusArr[currInx] & CHECKED_LEFT) == 0) {
			traverseStatusArr[currInx] |= CHECKED_LEFT;
    		if ((nextInx = currInx - arr[currInx]) >= 0 && search(arr, traverseStatusArr, nextInx)) {
    			return true;
    		}//fi
    	}//fi
    	return false;
    }//end method   
}//end class
