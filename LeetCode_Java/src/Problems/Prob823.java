package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.*;

import java.util.*;


public class Prob823 {
	static int[] nums0 = {0};
	static int[] nums1 = {2,4};
	static int[] nums2 = {2,4,5,10};	
	static int[] nums3 = {2, 4, 7, 9, 10, 14, 18, 31, 63, 84};

	static int[] nums4 = {2, 4, 7, 9, 10, 14, 18, 31, 63};
	
	static int[] nums10;
	static int[] nums11;
	static int[] nums12;

	private static void test() {
		

		
		int[] testArr;
		Solution823 solObj = new Solution823();
		/*
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numFactoredBinaryTrees(testArr));
		
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numFactoredBinaryTrees(testArr));
		//*/
		
		testArr = nums4;
		
		System.out.println("originalArr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.numFactoredBinaryTrees(testArr));

	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution823 {
	
	private static final long MOD_CONST = 1000000007;
	
	private long[] numOfWaysArr;
	private int[] numArr;
	
	
    public int numFactoredBinaryTrees(int[] arr) {
    	numArr = arr;
    	Arrays.sort(numArr);
    	numOfWaysArr = new long[numArr.length];
    	long totalNumOfWays = 0;
    	for (int i = 0; i < numArr.length; i++) {
    		 populateNumOfWays(i);
    		 totalNumOfWays = (totalNumOfWays + numOfWaysArr[i])%MOD_CONST;
    	}//rof    	
        return (int)totalNumOfWays;
    }//end method
	
    /**
     * populate number of ways to build b-trees for numbers at index inx
     * preconditions: 
     * 1. required reference and data structures are instantiated and set
     * - numOfWaysArr, numArr
     * 2. assumes that # of ways for items at indices less than inx have been populated
     * 3. assumes inx is valid
     * postcondition:
     * number of ways found will be stored in numOfWaysArr[inx]
     *  
     * @param inx - int index number
     */
    private void populateNumOfWays(int inx) {
    	long numOfWays = 1; //there's always itself
    	long tmpNumOfWays;
    	int currNum = numArr[inx];
    	int multiplicand, multiplier;
    	int maxMultiplicand = currNum;
    	int multiplierInx; 	
    	for (int multiplicandInx = 0; multiplicandInx <= inx; multiplicandInx++) {    		
    		multiplicand = numArr[multiplicandInx];    		
    		if (multiplicand > maxMultiplicand) {       	
    			break;
    		} else if (currNum%multiplicand != 0) {
    			continue;
    		}//fi
    		multiplier = currNum/multiplicand;
    		maxMultiplicand = multiplier;
    		multiplierInx = Arrays.binarySearch(this.numArr,multiplicandInx,inx,multiplier);    		
    		if (multiplierInx>=0) {//corresponding multiplier is found    	    	
    			tmpNumOfWays = numOfWaysArr[multiplicandInx]*numOfWaysArr[multiplierInx]%MOD_CONST;
    			tmpNumOfWays += multiplicandInx!=multiplierInx ? tmpNumOfWays : 0;
    			numOfWays = (numOfWays + tmpNumOfWays)%MOD_CONST;
    		}//fi
    	}//rof
    	numOfWaysArr[inx] = numOfWays;    	
    }//end method
}//end class


