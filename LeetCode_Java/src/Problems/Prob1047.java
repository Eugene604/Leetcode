package Problems;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob1047 {

	

	
	static void test() {
		String mat1Str = "[[0,1,0],[1,1,1],[0,1,0]]";
		String mat2Str = "[[1,-1],[-1,1]]";
		String mat3Str = "[[10,20,30],[5,10,20],[2,4,6]]";
		String mat4Str = "[[0,1,0,1,0,0],[0,0,0,0,1,0],[0,0,1,1,1,1],[1,0,1,1,1,0],[0,1,1,0,0,0]]";
		String mat5Str = "[[0,1,1],[0,1,1],[1,0,1],[0,1,0]]";
		Solution1047 solObj = new Solution1047();
		Solution1047Correct correctSol = new Solution1047Correct();
		int[][] mat;
		int target;
		
        try {
            ObjectMapper mapper = new ObjectMapper();            

            mat = mapper.readValue(mat5Str, new TypeReference<int[][]>() {});
            target = 1;
    		MatrixUtils.displayMatrix(mat);
    		System.out.println();
    		System.out.println("ans: " + solObj.numSubmatrixSumTarget(mat,target));
    		System.out.println("correct ans: " + correctSol.numSubmatrixSumTarget(mat,target));
    		
            /*
            mat = mapper.readValue(mat1Str, new TypeReference<int[][]>() {});
            target = 0;
    		MatrixUtils.displayMatrix(mat);
    		System.out.println("ans: " + solObj.numSubmatrixSumTarget(mat,target));
    		
    		
            
            mat = mapper.readValue(mat2Str, new TypeReference<int[][]>() {});
            target = 4;
    		MatrixUtils.displayMatrix(mat);
    		System.out.println("ans: " + solObj.numSubmatrixSumTarget(mat,target));
    		
            mat = mapper.readValue(mat3Str, new TypeReference<int[][]>() {});
            target = 4;
    		MatrixUtils.displayMatrix(mat);
    		System.out.println("ans: " + solObj.numSubmatrixSumTarget(mat,target));
    		 //*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		
		
		

	}
	
	private static void getNumOfSMDebug() {
		String mat5Str = "[[0,1,1],[0,1,1],[1,0,1],[0,1,0]]";
		int[][] mat;
		int target = 1;
		try {
            ObjectMapper mapper = new ObjectMapper();            

            mat = mapper.readValue(mat5Str, new TypeReference<int[][]>() {});
           
    		MatrixUtils.displayMatrix(mat);
    		
    	    		
    		int smRowLength = 3;    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		

		
	}
	
	public static void main(String[] args) {
		test();
		//getNumOfSMDebug();
	}

}



class Solution1047 {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		//special cases  
		if (target > 10000000 || target < -10000000) { //target exceeds what the largest matrix with largest pos/neg numbers can achieve 
			return 0;
		} else if (matrix.length == 1 && matrix[0].length == 1) { //1x1 matrix
			return (matrix[0][0] == target) ? 1:0;
		}//fi
		
		//step 1, obtain prefix sum matrix
		int[][] psm = buildPSM(matrix);
				
		int numOfSM = 0;
		//step 2, scan through 1 x 1 SMs, which are just individual element, skip if target is larger than ABS(1000)
		if (target <= 1000 && target >= -1000) {
			for (int i=0; i<matrix.length; i++) {
				for (int j=0; j<matrix[0].length; j++) {
					if (matrix[i][j] == target) {
						numOfSM++;
					}//fi
				}//rof		
			}//rof
		}//fi

		//step 3, scan through 1 x k SMs, where k >= 2
		for (int smRowLength = 2; smRowLength <= matrix[0].length; smRowLength++) {
			numOfSM += getNumOfSM(psm, 1, smRowLength,  target);
		}//rof
		
		//step 4, scan through k x 1 SMs, where k >= 2
		for (int smColLength = 2; smColLength <= matrix.length; smColLength++) {			
			numOfSM += getNumOfSM(psm, smColLength, 1, target);
		}//rof
		
		//step 5, scan through q x k SMs, where q and k are less than the dimension of matrix
		for (int smColLength = 2; smColLength <= matrix.length; smColLength++) {
			for (int smRowLength = 2; smRowLength <= matrix[0].length; smRowLength++) {
				numOfSM += getNumOfSM(psm, smColLength, smRowLength, target);
			}//rof
			
		}//rof
		
        return numOfSM;
    }//end method
	
	/**
	 * Builds a prefix sum matrix with one row and column of padding at the top and left.
 	 * Precondition: It is assumed that mat is not null and the sum will not exceed the integer limit
	 * @param mat - int[][], original matrix
	 * @return int[][] , prefix sum matrix
	 */
	public static int[][] buildPSM(int[][] mat) {
		int[][] psm = new int[mat.length+1][mat[0].length+1];
		//step 1, populate row 1 and column 1 , which corresponds to mat row 0 and col 0
		psm[1][1] = mat[0][0];	
		for (int j=1; j<mat[0].length; j++) { // j of original mat
			psm[1][j+1] = psm[1][j] + mat[0][j];
		}//rof
		
		for (int i=1; i<mat.length; i++) { // i of original mat
			psm[i+1][1] = psm[i][1] + mat[i][0];			
		}//rof
		
		//step 2, populate rest of i j 
		for (int i=1; i<mat.length; i++) {
			for (int j=1; j<mat[0].length; j++) {
				psm[i+1][j+1] = psm[i][j+1] + psm[i+1][j] + mat[i][j] - psm[i][j];
			}//rof		
		}//rof
		return psm;
	}//end method
	
	/**
	 * get number of sub matrices with sum = target given row and colume length
	 * precondition:
	 * -row and col lengths are assumed to be within valid range
	 * -psm is assumed to have upper and left padding
	 * @param psm - int[][], the prefix sum matrix WITH ROW and COLUME PADDING
	 * @param smColLength - int
	 * @param smRowLength - int
	 * @param target - int, target sum
	 * @return int, number of ways
	 */
	public static int getNumOfSM(int[][] psm, int smColLength, int smRowLength, int target) {
		int numOfSM = 0;
		int currSum;
		for (int lowerInx = smColLength, upperInx = 0; lowerInx < psm.length; lowerInx++, upperInx++) {
			for (int rightInx = smRowLength, leftInx = 0; rightInx < psm[0].length; rightInx++, leftInx++) {				
				currSum = psm[lowerInx][rightInx] - psm[upperInx][rightInx] - psm[lowerInx][leftInx] + psm[upperInx][leftInx];
				if (currSum == target) {
					numOfSM++;
				}//fi
			}//rof
		}//rof
		return numOfSM;
	}//end method

}//end class



class Solution1047Correct {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int count = 0;

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < m; row++) {
                    sum += matrix[row][c2] - (c1 > 0 ? matrix[row][c1 - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}

