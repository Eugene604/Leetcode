package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob1289{


	static void test() {
		
		int[][] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[[1,2,3],[4,5,6],[7,8,9]]", int[][].class);

            arr2 = objectMapper.readValue("[[-7, 1, -3], [-5, 0, 4], [-6, -8, 8]]", int[][].class);
            
            arr3 = objectMapper.readValue("[[0, -4, 3, 7, -8], [2, 5, 6, -6, 3], [-6, -3, 0, -4, 8], [3, -8, -3, -6, -2], [-1, 2, -3, 2, 5]]", int[][].class);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1289 solObj  = new Solution1289();
		int[][] arr;
		
		
		
		arr = arr3;		
		MatrixUtils.displayMatrix(arr);
		System.out.println("\nans: " + solObj.minFallingPathSum(arr));
		

	}

	public static void main(String[] args) {
		test();

	}

}



class Solution1289{
	
    public int minFallingPathSum(int[][] grid) {
    	int n = grid.length;
    	
    	//special case, n is 1
    	if (n==1) {
    		return grid[0][0];
    	}//fi
    	int[][] sumCacheArr = new int[n][n];
    	for (int j=0; j<n; j++) {
    		sumCacheArr[0][j] = grid[0][j];
    	}//rof
    	
    	for (int i=1; i<n; i++) {

        	for (int j=0; j<n; j++) {
        		sumCacheArr[i][j] = grid[i][j] + findSmallestElement(sumCacheArr[i-1],j);
        	}//rof       	
    	}//rof
    	
    	//MatrixUtils.displayMatrix(sumCacheArr);
    	
    	int minSum = Integer.MAX_VALUE;
    	for (int sum:sumCacheArr[n-1]) {
    		minSum = Math.min(sum, minSum);
    	}//rof
        return minSum;
    }//fi
    

    /**
	 * Finds the smallest element in the given array, excluding the element at the specified index.
	 *
	 * @param arr - int[], the array in which to find the smallest element
	 * @param exception - int, the index of the element to exclude from consideration
	 * @return int, the smallest element in the array, excluding the element at the specified index
	 */
    int findSmallestElement(int[] arr, int exception) {

    	int smallestVal = Integer.MAX_VALUE;
    	for (int i=0; i<arr.length; i++) {
    		if (i==exception) {
    			continue;
    		}//fi
    		if (arr[i]<smallestVal) {
    			smallestVal = arr[i];    			
    		}//fi
    	}//rof

    	return smallestVal;
    }//end method
}// end class
