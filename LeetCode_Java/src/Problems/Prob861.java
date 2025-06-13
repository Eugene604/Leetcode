package Problems;

import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob861{


	static void test() {
		
		int[][] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]", int[][].class);

            arr2 = objectMapper.readValue("[[0]]", int[][].class);
            
            arr3 = objectMapper.readValue("[[1,1],[3,4],[-1,0]]", int[][].class);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution861 solObj  = new Solution861();
		int[][] arr;
		
		
		
		arr = arr1;		
		MatrixUtils.displayMatrix(arr);		
		System.out.println("ans: " + solObj.matrixScore(arr));
		
		arr = arr2;		
		MatrixUtils.displayMatrix(arr);
		System.out.println("ans: " + solObj.matrixScore(arr));
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution861{
    public int matrixScore(int[][] grid) {
    	//step 1, scan MSB of each row
    	for (int i=0; i<grid.length; i++) {
    		if (grid[i][0] == 0) {
    			reverseRow(grid, i);
    		}//fi
    	}//rof
    	
    	//step 2, scan bits that are not MSB, from most significant to least significant. Flit column if 0 counts > 1 counts
    	int oneCnt;
    	int zeroCnt;
    	for (int j=1; j<grid[0].length; j++) {
    		oneCnt = 0;
    		zeroCnt = 0;
        	for (int i=0; i<grid.length; i++) {
        		if (grid[i][j] == 0) {
        			zeroCnt++;
        		} else {
        			oneCnt++;
        		}//fi
        	}//rof
        	if (oneCnt < zeroCnt) {
        		reverseColumn(grid, j);
        	}//fi
    	}//rof
    	
    	//step 3, serialize each row into binary number and then number in base 10, sum them
    	int sum = 0;
    	for (int i=0; i<grid.length; i++) {
    		sum += getNumFromRow(grid, i);
    	}//rof
        return sum;
    }//end method
    
    /**
     * precondition:
     * - assume row index is valid to the grid
     * @param grid - int[][]
     * @param rowInx - int
     */
    private void reverseRow(int[][] grid, int rowInx) {
    	for (int j=0; j<grid[0].length; j++) {
    		grid[rowInx][j] = (grid[rowInx][j] == 0) ? 1 : 0; 
    	}//rof    	
    }//end method
    
    /**
     * precondition:
     * - assume column index is valid to the grid
     * @param grid - int[][]
     * @param colInx - int
     */
    private void reverseColumn(int[][] grid, int colInx) {
    	for (int i=0; i<grid.length; i++) {
    		grid[i][colInx] = (grid[i][colInx] == 0) ? 1 : 0; 
    	}//rof    	
    }//end method
    
    /**
     * 
     * @param grid - int[][]
     * @param rowInx - int
     * @return int - base 10 number of represented by the row 
     */
    private int getNumFromRow(int[][] grid, int rowInx) {
    	int num = 0;
    	for (int j=0; j<grid[0].length; j++) {
    		num *= 2;
    		num += grid[rowInx][j];
    	}//rof
    	return num;
    }//end method
}// end class
