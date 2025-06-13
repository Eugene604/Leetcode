package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob1463{


	static void test() {
		
		int[][] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]", int[][].class);

            arr2 = objectMapper.readValue("[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]", int[][].class);
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1463 solObj  = new Solution1463();
		int[][] arr;
		
		
		
		arr = arr2;		
		MatrixUtils.displayMatrix(arr);
		System.out.println("ans: " + solObj.cherryPickup(arr));
		

	}

	public static void main(String[] args) {
		test();

	}

}



class Solution1463{
	Integer[][][] hvstCache;
	int[][] farmArr;
    public int cherryPickup(int[][] grid) {
    	farmArr = grid;
    	hvstCache = new Integer[grid.length][grid[0].length][grid[0].length];
    	
    	return hvstMaxCherry(0, 0, grid[0].length-1);
    }//end method
    
    /**
     * recursively try to harvest max amount of cherry  
     * Precondition:
     * - all indices are assumed to be valid
     * - harvest cache is instantiated properly
     * - farm grid reference is set
     * @param rowInx - int, row index
     * @param r1ColInx - int, column index of robot 1
     * @param r2ColInx - int, column index of robot 2
     * @return int, maximum amount of cherry can be harvest given column and row indices
     */
    private int hvstMaxCherry(int rowInx, int r1ColInx, int r2ColInx) {
    	if (hvstCache[rowInx][r1ColInx][r2ColInx] != null) {
    		return hvstCache[rowInx][r1ColInx][r2ColInx];
    	}//fi
    	
    	int hvstAmntAtCurrPos;
		if (r1ColInx == r2ColInx) {
			hvstAmntAtCurrPos = farmArr[rowInx][r1ColInx];
		} else {
			hvstAmntAtCurrPos = farmArr[rowInx][r1ColInx] + farmArr[rowInx][r2ColInx];
		}//fi
		
    	//base case: reached lowest row
    	if (rowInx == farmArr.length-1) {
   			hvstCache[rowInx][r1ColInx][r2ColInx] = hvstAmntAtCurrPos;
    		return hvstCache[rowInx][r1ColInx][r2ColInx];
    	}//fi
    	
    	int currHvstAmount, maxHvstAmount = Integer.MIN_VALUE;
    	for (int nextR1ColInx = Math.max(0, r1ColInx-1); nextR1ColInx <= Math.min(r1ColInx+1, farmArr[0].length-1); nextR1ColInx++) {
        	for (int nextR2ColInx = Math.max(0, r2ColInx-1); nextR2ColInx <= Math.min(r2ColInx+1, farmArr[0].length-1); nextR2ColInx++) {
        		currHvstAmount = hvstAmntAtCurrPos + hvstMaxCherry(rowInx+1, nextR1ColInx, nextR2ColInx);
        		maxHvstAmount = Math.max(maxHvstAmount, currHvstAmount);
        	}//rof
    	}//rof
    	
    	hvstCache[rowInx][r1ColInx][r2ColInx] = maxHvstAmount;
    	return hvstCache[rowInx][r1ColInx][r2ColInx];
    }//fi
}// end class
