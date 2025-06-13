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
	public static void displayMatrix(char[][] mat) {
		if (mat==null) {
			System.out.println("[]");
			return;
		}//fi
		for (char[] row:mat) {
			System.out.println(Arrays.toString(row));
		}//rof
		
	}//end method
	
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


	/**
	 * display 2D matrix
	 * @param mat - int[][] 2D int array
	 */
	public static void displayMatrix(Integer[][] mat) {
		if (mat==null) {
			System.out.println("[]");
			return;
		}//fi
		for (Integer[] row:mat) {
			System.out.println(Arrays.toString(row));
		}//rof
		
	}//end method
	
	/**
	 * display 2D matrix
	 * @param mat - long[][] 2D long array
	 */
	public static void displayMatrix(long[][] mat) {
		if (mat==null) {
			System.out.println("[]");
			return;
		}//fi
		for (long[] row:mat) {
			System.out.println(Arrays.toString(row));
		}//rof
		
	}//end method

	/**
	 * display 2D matrix up to row m column n
	 * @param mat - long[][] 2D long array
	 * @param m - int, max row inclusive
	 * @param n - int, max column inclusive
	 */
	public static void displayMatrix(long[][] mat, int m, int n) {
		StringBuilder sb = new StringBuilder();
		if (mat==null) {
			System.out.println("[]");
			return;
		}//fi
		for (int i=0; i<m; i++) {
			sb.append('[');
			for (int j=0; j<n; j++) {
				sb.append(mat[i][j]);
				sb.append(',');
			}//rof
			sb.append(']');
			sb.append('\n');
		}//rof		
		
		System.out.println(sb.toString());
	}//end method
	
}//end class
