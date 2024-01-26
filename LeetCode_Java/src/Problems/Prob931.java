package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob931{

	static String arr1 = "[[2,1,3],[6,5,4],[7,8,9]]";
	static String arr2 = "[[0,0,0,0,0,0,0,0,0,0],[0,1,0,0,0,0,1,0,0,0],[1,0,0,1,0,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,1]]";
	static String arr3 = "[[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,1],[0,0,0,0,1,0,0,0],[1,0,0,0,1,0,0,0],[0,0,1,1,0,0,0,0]]";
	static String arr4 = "[[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,1],[0,0,0,0,1,0,0,0],[1,0,0,0,1,0,0,0],[0,0,1,1,0,0,0,0]]";
	
	static void test() throws JsonMappingException, JsonProcessingException {
		Solution931 solObj = new Solution931();
		int[][] mat;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Use the readValue method to deserialize the raw text into a 2D array
        int[][] result = objectMapper.readValue("[[]]", int[][].class);

        

		
	
		
        mat =  objectMapper.readValue(arr1, int[][].class);
        MatrixUtils.displayMatrix(mat);
		System.out.println("ans: " + solObj.minFallingPathSum(mat));

	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}//end class

class Solution931{
	static int[][] costCache = new int[100][100];
	
    public int minFallingPathSum(int[][] matrix) {
    	int mSize = matrix.length;
    	
    	//step 1, populate minimum cost values row by row from bottom up
    	int row = mSize-1;
    	int col;
    	for (col=0; col< mSize; col++) {
    		costCache[row][col] = matrix[row][col];
    	}//rof
    	
    	int currCellCost;
    	for (row = mSize-2; row >= 0; row--) {
    		col=0;
    		currCellCost = matrix[row][col];
    		costCache[row][col] = Math.min(currCellCost + costCache[row+1][col], currCellCost + costCache[row+1][col+1]);
    		
        	for (col=1; col <= mSize-2; col++) {
        		currCellCost = matrix[row][col];
        		costCache[row][col] = Math.min(currCellCost + costCache[row+1][col-1], currCellCost + costCache[row+1][col]);
        		costCache[row][col] = Math.min(currCellCost + costCache[row+1][col+1], costCache[row][col]);
        	}//rof
        	
        	col=mSize-1;
    		currCellCost = matrix[row][col];
    		costCache[row][col] = Math.min(currCellCost + costCache[row+1][col-1], currCellCost + costCache[row+1][col]);
    	}//rof
    	
    	 
    	//step 2, obtain min cost from row 0
    	int minCost = Integer.MAX_VALUE;
    	for (col=0; col<mSize; col++) {
    		if (costCache[0][col] < minCost) {
    			minCost = costCache[0][col];
    		}//fi
    	}//rof
        return minCost;
    }//end method
    
}// end class


