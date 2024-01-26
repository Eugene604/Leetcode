package Utils;

import java.util.Arrays;

import DataStructs.*;


public class MatrixUtils {
	
		
	
	static {
		
	}
	
	
	/**
	 * display 2D matrix
	 * @param mat - int[][] 2D int array
	 */
	public static void displayMatrix(int[][] mat) {
		if (mat==null) {
			System.out.println("[]");
			return;
		}//fi
		for (int[] row:mat) {
			System.out.println(Arrays.toString(row));
		}//rof
		
	}//end method

}//end class
