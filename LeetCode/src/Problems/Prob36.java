package Problems;

import java.util.*;


import Utils.SudokuUtils;

public class Prob36 {

	
	static char[][] arr1 = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	static char[][] arr2 = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	static char[][] arr3 = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
	//[[".",".","4",".",".",".","6","3","."],[".",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".","9","."],[".",".",".","5","6",".",".",".","."],["4",".","3",".",".",".",".",".","1"],[".",".",".","7",".",".",".",".","."],[".",".",".","5",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."]]
	
	static char[][] arr4 = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
	//[[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]
	
	static char[][] arr5 = {{'.','4','6','.','.','.','6','.','.'},{'.','.','.','6','.','.','.','.','4'},{'.','.','.','.','.','1','.','.','.'},{'.','.','.','.','.','7','.','.','.'},{'5','.','7','.','.','.','4','.','.'},{'.','.','.','.','.','.','.','.','3'},{'.','.','.','7','.','.','1','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','1','2','.','.','.','.','.'}};
	//[[".","4","6",".",".",".","6",".","."],[".",".",".","6",".",".",".",".","4"],[".",".",".",".",".","1",".",".","."],[".",".",".",".",".","7",".",".","."],["5",".","7",".",".",".","4",".","."],[".",".",".",".",".",".",".",".","3"],[".",".",".","7",".",".","1",".","."],[".",".",".",".",".",".",".",".","."],[".",".","1","2",".",".",".",".","."]]
	
	static void test() {
		Solution36 solObj = new Solution36();
		char[][] arr;
	
		
		arr = arr1;
		//SudokuUtils.displaySudoku(arr);
		System.out.println("ans: " + solObj.isValidSudoku(arr));

		/*
		arr = arr2;
		//SudokuUtils.displaySudoku(arr);
		System.out.println("ans: " + solObj.isValidSudoku(arr));
		
		arr = arr3;
		//SudokuUtils.displaySudoku(arr);
		System.out.println("ans: " + solObj.isValidSudoku(arr));
		
		arr = arr4;
		//SudokuUtils.displaySudoku(arr);
		System.out.println("ans: " + solObj.isValidSudoku(arr));
	
		
		arr = arr5;
		//SudokuUtils.displaySudoku(arr);
		System.out.println("ans: " + solObj.isValidSudoku(arr));	
		//*/
	
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution36 {
	
	private static boolean[][] rowSet;
	private static boolean[][] columnSet;
	private static boolean[][] gridSet;	
	

    
    public boolean isValidSudoku(char[][] board) {
    	init();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!pushRow(i, board[i][j])) {
					//System.out.println("failed row: " + i + " : " + j);
					return false;
				} else if (!pushColumn(j, board[i][j])) {
					//System.out.println("failed column: " + i + " : " + j);
					return false;
				} else if (!pushGrid((i/3)*3 + j/3, board[i][j])) {
					//System.out.println("failed grid: " + i + " : " + j);
        			return false;  
        		}//fi   
			}//rof
		}//rof
        return true;
    }//end method
    
    /**
     * Push element to row, return true if it exists
     * @param rowNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushRow(int rowNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (rowSet[rowNum][inx]) {
    		return false;
    	} else {
    		rowSet[rowNum][inx] = true;
    		return true; 		
    	}//fi    	
    }//end method

    /**
     * Push element to column, return true if it exists
     * @param colNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushColumn(int colNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (columnSet[colNum][inx]) {
    		return false;
    	} else {
    		columnSet[colNum][inx] = true;
    		return true; 		
    	}//fi     	
    }//end method
    
    /**
     * Push element to grid, return true if it exists
     * @param gridNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushGrid(int gridNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (gridSet[gridNum][inx]) {
    		return false;
    	} else {
    		gridSet[gridNum][inx] = true;
    		return true; 		
    	}//fi  	
    }//end method
    
    public void init() {
    	
    	rowSet = new boolean[9][9];
   		columnSet = new boolean[9][9];
   		gridSet = new boolean[9][9];		
    	
    }//end method
}//end class


class Solution36_v2 {
	
	private static BitSet rowSet[] = new BitSet[9];
	private static BitSet columnSet[] = new BitSet[9];
	private static BitSet gridSet[] = new BitSet[9];
	private static final BitSet ALL_NEGATIVE = new BitSet(9);
	
    public boolean isValidSudoku(char[][] board) {
    	init();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!pushRow(i, board[i][j])) {
					//System.out.println("failed row: " + i + " : " + j);
					return false;
				} else if (!pushColumn(j, board[i][j])) {
					//System.out.println("failed column: " + i + " : " + j);
					return false;
				} else if (!pushGrid((i/3)*3 + j/3, board[i][j])) {
					//System.out.println("failed grid: " + i + " : " + j);
        			return false;  
        		}//fi   
			}//rof
		}//rof
        return true;
    }//end method
    
    /**
     * Push element to row, return true if it exists
     * @param rowNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushRow(int rowNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (rowSet[rowNum].get(inx)) {
    		return false;
    	} else {
    		rowSet[rowNum].set(inx, true);
    		return true; 		
    	}//fi    	
    }//end method

    /**
     * Push element to column, return true if it exists
     * @param colNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushColumn(int colNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (columnSet[colNum].get(inx)) {
    		return false;
    	} else {
    		columnSet[colNum].set(inx, true);
    		return true; 		
    	}//fi    	
    }//end method
    
    /**
     * Push element to grid, return true if it exists
     * @param gridNum - int
     * @param ele - char element
     * @return true if the element pushed is not in the set
     */
    private boolean pushGrid(int gridNum, char ele) {
    	int inx = ele - '1';
    	if (inx < 0) {
    		return true;
    	} if (gridSet[gridNum].get(inx)) {
    		return false;
    	} else {
    		gridSet[gridNum].set(inx, true);
    		return true; 		
    	}//fi  	
    }//end method
    
    public void init() {
    	
    	for (int i=0; i<9; i++) {
    		rowSet[i] = new BitSet(9);
    		columnSet[i] = new BitSet(9);
    		gridSet[i] = new BitSet(9);    		
    	}//rof
    	
    	/*
    	for (BitSet bs : rowSet) {
    		bs.and(ALL_NEGATIVE);
    	}//rof
       	for (BitSet bs : columnSet) {
    		bs.and(ALL_NEGATIVE);
    	}//rof
       	for (BitSet bs : gridSet) {
    		bs.and(ALL_NEGATIVE);
    	}//rof //*/
    }//end method
}//end class

class Solution36_v1 {
	
    public boolean isValidSudoku(char[][] board) {
    	Set<Character> rowSet = new HashSet<>();
		Set<Character>[] columnSet = new Set[9];
		Set<Character>[][] gridSet = new Set[3][3];
		
    	for (int j = 0; j < 9; j++) {
    		columnSet[j] = new HashSet<>();
    		gridSet[j/3][j%3] = new HashSet<>();
    		
    		if (board[0][j] == '.') {
				//do nothing
			} else if (!rowSet.add(board[0][j])) {
				return false;
    		} else {
        		columnSet[j].add(board[0][j]);        		
        		if (!gridSet[0][j/3].add(board[0][j])) {
        			return false;        			
        		}//fi        		
    		}//fi
    		
    	}//rof
		for (int i = 1; i < 9; i++) {
			rowSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					//do nothing
				} else if (!rowSet.add(board[i][j])) {
					return false;
				} else if (!columnSet[j].add(board[i][j])){
					return false;
				} else if (!gridSet[i/3][j/3].add(board[i][j])) {
        			return false;        			
        		}//fi   
			}//rof
		}//rof
        return true;
    }//end method
}//end class 
