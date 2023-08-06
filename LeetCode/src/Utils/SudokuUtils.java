package Utils;

import java.util.Collections;

import DataStructs.TreeNode;

public class SudokuUtils {
	
	static char[][] testArr = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	

	
	public static void main(String args[]) {
		displaySudoku(testArr);
	}//end method
	
	
	

	/**
	 * Display sudoku board
	 * precondition:
	 *  - table is assumed to be 9x9 char array
	 *  - array is initialized
	 * @param table char[][] 
	 */
	public static void displaySudoku(char[][] table) {	
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (table[i][j]=='.') {
					System.out.print('-');
				} else {
					System.out.print(table[i][j]);
				}//fi
				
				if ((j+1)%9 == 0) {
										
				} else if ((j+1)%3 == 0) {
					System.out.print("   ");
				} else {
					System.out.print(",");
				}//fi
			}//rof
			System.out.println();
			if ((i+1)%3 == 0) {
				System.out.println();
			}//fi
		}//*/
		
	}//end method
		
	

}//end class
