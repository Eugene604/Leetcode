package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1582{

	static String arr1 = "[[0,0,1],[1,1,1],[1,0,1]]";
	static String arr2 = "[[0,0,0,0,0,0,0,0,0,0],[0,1,0,0,0,0,1,0,0,0],[1,0,0,1,0,0,0,1,0,0],[0,0,0,0,0,1,0,0,0,1]]";
	static String arr3 = "[[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,1],[0,0,0,0,1,0,0,0],[1,0,0,0,1,0,0,0],[0,0,1,1,0,0,0,0]]";
	static String arr4 = "[[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,1],[0,0,0,0,1,0,0,0],[1,0,0,0,1,0,0,0],[0,0,1,1,0,0,0,0]]";
	
	static void test() throws JsonMappingException, JsonProcessingException {
		Solution1582 solObj = new Solution1582();
		int[][] mat;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Use the readValue method to deserialize the raw text into a 2D array
        int[][] result = objectMapper.readValue("[[]]", int[][].class);

        


		
	
		
        mat =  objectMapper.readValue(arr2, int[][].class);
        MatrixUtils.displayMatrix(mat);
		System.out.println("ans: " + solObj.numSpecial(mat));

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

class Solution1582{
	static int[] onePosForRow; 
	static int[] onePosForCol; 
	static {
		onePosForRow = new int[102];
		onePosForCol = new int[102];
		Arrays.fill(onePosForRow, 100);
		Arrays.fill(onePosForCol, 100);
	}//end static
	
    public int numSpecial(int[][] mat) {
    	/*
    	 * step 1, populate sole "one's position" array
    	 * if there are multiple ones, the value is reverted back to -1
    	 */

    	for (int i=0; i<mat.length; i++) {
    		for (int j=0; j<mat[0].length; j++) {
    			if (mat[i][j]==1) {
    				onePosForRow[i]=(onePosForRow[i]==100)?j:101;
    				onePosForCol[j]=(onePosForCol[j]==100)?i:101;
    			}//fi    			
    		}//rof
    	}//rof
    	//System.out.println("onePosForRow: " + Arrays.toString(onePosForRow));
    	//System.out.println("onePosForCol: " + Arrays.toString(onePosForCol));
    	
    	//step 2, cross check, see if i == onePosForCol[onePosForRow[i]]
    	int spcialCnt = 0;
    	for (int i=0; i<mat.length; i++) {
    		if (i==onePosForCol[onePosForRow[i]]) {
    			spcialCnt++;
    		}//fi
    	}//rof
    	
    	//step 3, clean up
		Arrays.fill(onePosForRow, 0, mat.length, 100);
		Arrays.fill(onePosForCol, 0, mat[0].length,100);
    	return spcialCnt;
        
    }//end method
    
}// end class


