package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1043 {


	
	private static void test() {
		
		Solution1043 solObj = new Solution1043();
		int[] testArr;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            /*
            testArr = mapper.readValue("[1,15,7,9,2,5,10]", int[].class);
    		k = 3;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSumAfterPartitioning(testArr, k));
    		
            testArr = mapper.readValue("[1,4,1,5,7,3,6,1,9,9,3]", int[].class);
    		k = 4;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSumAfterPartitioning(testArr, k));
    	
    		
            testArr = mapper.readValue("[65,0,0,118,230,0,0,58,157,0,0,1,201,0,0,383,59,0,0,302,278,0,0,156,162,0,0,279,334,0,0,172,197,0,0,341,147,0,0,484,226,0,0,496,405,0,0,322,228,0,0,156,280,0,0,305,402,0,0,141,81,0,0,331,355,0,0,323,379,0,0,176,271,0,0,175,38,0,0,499,366,0,0,494,392,0,0,75,300,0,0,22,376,0,0,126,442,0,0,384]", int[].class);
    		k = 2;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSumAfterPartitioning(testArr, k));
    			//*/
            
            testArr = mapper.readValue("[65,0]", int[].class);
    		k = 2;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSumAfterPartitioning(testArr, k));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1043 {
	int[] maxSumCache;
    public int maxSumAfterPartitioning(int[] arr, int k) {
    	//step 1, check for edge case, arr.length = 1
    	if (arr.length == 1) {
    		return arr[0];
    	}//fi
    	
    	//step 2, initialize cache 
    	maxSumCache = new int[arr.length];
    	maxSumCache[0] = arr[0];
    	
    	//step 3, calculate answer
    	maxSum(arr, arr.length-1, k);
 
    	//System.out.println("cache: " + Arrays.toString(maxSumCache));
    	return maxSumCache[arr.length-1];
    }//end method
    
    /**
     * recursively get max sum from index o to index lastIndex
     * precondition:
     * - it is assumed that maxSumCache is properly instantiated and valid
     * @param arr - int[], the number array in question
     * @param lastInx - int, the last index to consider
     * @param k - int, length of sub array
     * @return int, the largest sum of the sub array after partitioning
     */
    private int maxSum(int[] arr, int lastInx, int k) {
    	
    	if (maxSumCache[lastInx] != 0) {
    		return maxSumCache[lastInx];
    	}//end    	 
    	
    	int maxSum = 0, currSum;
    	int currMax = 0;
    	int i, currInx;
    	for (i=1, currInx=lastInx; i <= k && currInx > 0; i++, currInx--) {
			currMax = Math.max(currMax, arr[currInx]);
			currSum = maxSum(arr, currInx - 1, k) + currMax*i;
			//System.out.println(currInx + " i: " + i + " currSum: " + currSum + " currMax: " + currMax);
			maxSum = Math.max(maxSum, currSum);    		  		    		 
    	}//rof
		if (i <= k) { // i has not reached k yet, meaning currInx has arrived 0
			currMax = Math.max(currMax, arr[0]);
			currSum = currMax*i;
			maxSum = Math.max(maxSum, currSum);			
		}//fi
    	maxSumCache[lastInx] = maxSum;
    	return maxSum;
    }//end method
}//end class
