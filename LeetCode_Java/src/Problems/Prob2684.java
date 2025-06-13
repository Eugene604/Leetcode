package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob2684{


	static void test() {
		
		int[][] grid;
		Solution2684 solObj  = new Solution2684();
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            grid = objectMapper.readValue("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]", int[][].class);

    		MatrixUtils.displayMatrix(grid);
    		System.out.println("ans: " + solObj.maxMoves(grid));
       
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		


		

	}

	public static void main(String[] args) {
		test();

	}

}



class Solution2684{
	int[][] moveCache;
    public int maxMoves(int[][] grid) {
    	moveCache = new int[grid.length][grid[0].length];
    	int colInx, rowInx, nextColInx;
    	for (colInx = grid[0].length-2, nextColInx = grid[0].length-1; colInx>=0; colInx--, nextColInx--) {
    		//edge case: rolInx = 0
    		rowInx = 0;
    		if (grid[rowInx][nextColInx] > grid[rowInx][colInx]) {
    			moveCache[rowInx][colInx] = moveCache[rowInx][nextColInx]+1;
    		}//fi
    		if (grid[rowInx+1][nextColInx] > grid[rowInx][colInx]) {
    			moveCache[rowInx][colInx] = Math.max(moveCache[rowInx][colInx], moveCache[rowInx+1][nextColInx]+1);
    		}//fi
    		
    		//edge case: rolInx = grid.length-1
    		rowInx = grid.length-1;
    		if (grid[rowInx][nextColInx] > grid[rowInx][colInx]) {
    			moveCache[rowInx][colInx] = moveCache[rowInx][nextColInx]+1;
    		}//fi
    		if (grid[rowInx-1][nextColInx] > grid[rowInx][colInx]) {
    			moveCache[rowInx][colInx] = Math.max(moveCache[rowInx][colInx], moveCache[rowInx-1][nextColInx]+1);
    		}//fi
    		
        	for (rowInx = 1; rowInx<grid.length-1; rowInx++) {
        		if (grid[rowInx][nextColInx] > grid[rowInx][colInx]) {
        			moveCache[rowInx][colInx] = moveCache[rowInx][nextColInx]+1;
        		}//fi
        		if (grid[rowInx-1][nextColInx] > grid[rowInx][colInx]) {
        			moveCache[rowInx][colInx] = Math.max(moveCache[rowInx][colInx], moveCache[rowInx-1][nextColInx]+1);
        		}//fi	
        		if (grid[rowInx+1][nextColInx] > grid[rowInx][colInx]) {
        			moveCache[rowInx][colInx] = Math.max(moveCache[rowInx][colInx], moveCache[rowInx+1][nextColInx]+1);
        		}//fi
        	}//rof
    	}//rof
    	
    	//MatrixUtils.displayMatrix(moveCache);
    	int maxMove = 0;
    	for (rowInx = 0; rowInx < grid.length; rowInx++) {
    		maxMove = Math.max(maxMove, moveCache[rowInx][0]);
    	}//rof
        return maxMove;
    }//end method
    
}// end class
