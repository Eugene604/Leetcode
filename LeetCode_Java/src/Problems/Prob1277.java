package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1277{


	static void test() throws JsonMappingException, JsonProcessingException {
		Solution1277 solObj = new Solution1277();
		int[][] mat;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

       mat = objectMapper.readValue("[[1,1,1,1],[1,0,0,1],[1,1,0,0],[1,0,0,0]]", int[][].class);

        
        MatrixUtils.displayMatrix(mat);
		System.out.println("ans: " + solObj.countSquares(mat));

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

class Solution1277{
	
	int[][] theMatrix;
	int[][] lSqDimCache; //largest square dimension whose UPPER LEFT corner is at rowInx, colInx
	
    public int countSquares(int[][] matrix) {
    	this.theMatrix = matrix;
    	
    	//step 1, build largest square dimension cache
    	lSqDimCache = new int[matrix.length+1][matrix[0].length+1];
    	for (int rowInx = matrix.length-1; rowInx >= 0; rowInx--) {
    		for (int colInx = matrix[0].length-1; colInx >= 0; colInx--) {    		
    			buildLSDCache(rowInx, colInx);
        	}//rof
    	}//rof

        //MatrixUtils.displayMatrix(lSqDimCache);
        
    	//step 2, sum everything in the square dimension cache
    	int cnt = 0;
    	for (int rowInx = matrix.length-1; rowInx >= 0; rowInx--) {
    		for (int colInx = matrix[0].length-1; colInx >= 0; colInx--) {    		
    			cnt += lSqDimCache[rowInx][colInx];
        	}//rof
    	}//rof
        return cnt;
    }//end method
    
    /**
     * Builds the largest square dimension cache for the square 
     * sub-matrices whose upper-left corner is at the specified 
     * row and column indices.
     *
     * This method updates the lSqDimCache at (rowInx, colInx) based on 
     * the values in theMatrix and previously computed values in the 
     * lSqDimCache. If the value at theMatrix[rowInx][colInx] is 1, it 
     * computes the size of the largest square that can be formed with 
     * the upper-left corner at (rowInx, colInx). The size is determined 
     * by checking the dimensions of squares that can be formed by 
     * extending right and down from the current cell.
     *
     * Preconditions:
     * - theMatrix is set and contains the original binary matrix.
     * - lSqDimCache is initialized and has dimensions at least one 
     *   larger than the original matrix.
     * - It is assumed that the cache values up to the current indices 
     *   are populated.
     * - It is assumed that rowInx and colInx are valid indices within 
     *   the bounds of the original matrix.
     *
     * @param rowInx - int, The row index 
     * @param colInx - int, The column index
     */
    private void buildLSDCache(int rowInx, int colInx) {
    	int minLR;
    	if (theMatrix[rowInx][colInx] == 0) {
    		lSqDimCache[rowInx][colInx] = 0;
    	} else {
    		minLR = Math.min(lSqDimCache[rowInx+1][colInx], lSqDimCache[rowInx][colInx+1]);
    		minLR = Math.min(lSqDimCache[rowInx+1][colInx+1], minLR);
    		lSqDimCache[rowInx][colInx] = 1 + minLR;
    	}//rof
    }//end method
        
}// end class


