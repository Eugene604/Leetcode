package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2373{

	static String arr1 = "[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]";
	static String arr2 = "[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]";
	
	static void test() throws JsonMappingException, JsonProcessingException {
		Solution2373 solObj = new Solution2373();
		int[][] mat, ansMat;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

     


				
        mat =  objectMapper.readValue(arr1, int[][].class);
		System.out.println("orignal mat: ");
		MatrixUtils.displayMatrix(mat);
		ansMat = solObj.largestLocal(mat);
		System.out.println("resulting mat: ");
		MatrixUtils.displayMatrix(ansMat);
		
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class Solution2373{
    public int[][] largestLocal(int[][] grid) {
    	int lastInx = grid.length-1;
    	int[][] llMat = new int[grid.length-2][grid.length-2];
    	for (int i=0; i<=lastInx-2; i++) {
    		for (int j=0; j<=lastInx-2; j++) {
    			llMat[i][j] = getLocalMax(grid, i, j);
        	}//rof
    	}//rof
        return llMat;
    }//end method
    
    /**
     * get local max of 3x3 sub matrix given the upper left corner
     * precondition:
     * - i and j are assumed to be valid
     * 
     * @param grid - int[][]
     * @param i - int, row index
     * @param j - int, column index
     * @return max of the 3x3 sub matrix
     */
    private int getLocalMax(int[][] grid, int i, int j) {
    	int maxNum = Integer.MIN_VALUE;
    	maxNum = Math.max(grid[i][j], maxNum);
    	maxNum = Math.max(grid[i][j+1], maxNum);
    	maxNum = Math.max(grid[i][j+2], maxNum);
    	maxNum = Math.max(grid[i+1][j], maxNum);
    	maxNum = Math.max(grid[i+1][j+1], maxNum);
    	maxNum = Math.max(grid[i+1][j+2], maxNum);
    	maxNum = Math.max(grid[i+2][j], maxNum);
    	maxNum = Math.max(grid[i+2][j+1], maxNum);
    	maxNum = Math.max(grid[i+2][j+2], maxNum);
    	return maxNum;
    }//fi
}// end class

