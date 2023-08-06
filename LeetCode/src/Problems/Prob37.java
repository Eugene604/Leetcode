package Problems;

import java.util.*;


import Utils.SudokuUtils;

public class Prob37 {

	
	static char[][] arr1 = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	static char[][] arr2 = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
	static char[][] arr3 = {
		    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
		    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

	
	static char[][] arr4 = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
	//[[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]
	
	static char[][] arr5 = {{'.','4','6','.','.','.','6','.','.'},{'.','.','.','6','.','.','.','.','4'},{'.','.','.','.','.','1','.','.','.'},{'.','.','.','.','.','7','.','.','.'},{'5','.','7','.','.','.','4','.','.'},{'.','.','.','.','.','.','.','.','3'},{'.','.','.','7','.','.','1','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','1','2','.','.','.','.','.'}};
	//[[".","4","6",".",".",".","6",".","."],[".",".",".","6",".",".",".",".","4"],[".",".",".",".",".","1",".",".","."],[".",".",".",".",".","7",".",".","."],["5",".","7",".",".",".","4",".","."],[".",".",".",".",".",".",".",".","3"],[".",".",".","7",".",".","1",".","."],[".",".",".",".",".",".",".",".","."],[".",".","1","2",".",".",".",".","."]]
	
	static void test() {
		Solution37 solObj = new Solution37();
		char[][] arr;
		
		arr = arr3;
		solObj.solveSudoku(arr);
		SudokuUtils.displaySudoku(arr);		
		System.out.println("================");
		
		/*
		arr = arr2;
		solObj.solveSudoku(arr);
		SudokuUtils.displaySudoku(arr);	
		//*/
		
	

	}
	
	public static void main(String[] args) {
		test();

	}

}

class Solution37 {
	
	
    public void solveSudoku(char[][] board) {
    	buildDataStruct(board);
        return;
    }//end method
    
    private void buildDataStruct(char[][] board) {
    	Sudoku.init();
    	Sudoku.buildInitBoard(board);
		Sudoku.populateAvailDigSets();
		Sudoku.solveBoard();
		Sudoku.writeToCharArr(board);
		//Sudoku.debug();
    }//end method
}//end class

class Sudoku implements Comparable<Sudoku> {
	
	private static Sudoku[][] board;
	private static boolean[][] rowDigs;
	private static boolean[][] colDigs;
	private static boolean[][] gridDigs;
	private static Set<Sudoku> nonConstBlkSet;
	
	private List<Integer> availDigList;
	private boolean isConst;
	private Integer digit;
	private int[] posArr = new int[3];
	

	/**
	 * Precondition: 
	 *  - board built, available digit set populated
	 */
	public static void solveBoard() {
		if (nonConstBlkSet.size() == 0) {
			return;
		}//fi
		Sudoku[] nonConstBlkArr = nonConstBlkSet.toArray(new Sudoku[nonConstBlkSet.size()]);
		Arrays.sort(nonConstBlkArr);		
		Sudoku.solve(nonConstBlkArr, 0);
	}//end method

	private static boolean solve(Sudoku[] blkArr, int inx) {		
		//base case
		if (inx == blkArr.length-1) {
			for (Integer digit:blkArr[inx].availDigList) {
				if (blkArr[inx].trySetDigit(digit)) {
					return true;
				}//fi
			}//rof
			return false;
		}//fi
		 
		for (Integer digit:blkArr[inx].availDigList) {
			if (blkArr[inx].trySetDigit(digit)) {		
				if (Sudoku.solve(blkArr, inx+1)) {
					return true;
				} else {
					blkArr[inx].revertDigit(digit);
				}//fi
			}//fi
		}//rof */
		return false;
	}//end method
	
	
	/**
	 * This method receives a char array game board and build sudoku board based on it
	 * @param board char[][]
	 */
	public static void buildInitBoard(char[][] charArrBoard) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				new Sudoku(i, j, charArrBoard[i][j]);
			}//rof
		}//rof
	}//end method
	
	/**
	 * Set available digit set 
	 * Precondition:
	 * 	- board initialized
	 * @return true if it is found that this block contains only one possible digit to set
	 */
	public boolean populateAvailDigSet() {
		if (this.availDigList == null) {
			this.availDigList = new LinkedList<>();
			for (int i = 1; i < 10; i++) {
				if (rowDigs[posArr[0]][i] || colDigs[posArr[1]][i] || gridDigs[posArr[2]][i]) {			
				} else {
					availDigList.add(i);
				}//fi
			}//rof
		} else {
			Iterator<Integer> availDigListItr = this.availDigList.iterator();
			Integer currDigit;
			while(availDigListItr.hasNext()) {
				currDigit = availDigListItr.next();
				if (rowDigs[posArr[0]][currDigit] || colDigs[posArr[1]][currDigit] || gridDigs[posArr[2]][currDigit]) {			
					availDigListItr.remove();
				}//fi
			}//end while
		}//fi

		if (availDigList.size()==1) {
			this.isConst = true;
			this.digit = this.availDigList.remove(0);
			rowDigs[posArr[0]][this.digit] = true;	
			colDigs[posArr[1]][this.digit] = true;
			gridDigs[posArr[2]][this.digit] = true;
			nonConstBlkSet.remove(this);
			return true;
		}//fi
		return false;
	}//end method
	
	
	/**
	 * Populate available digit sets for every non constant block
	 * Precondition:
	 * 	- all data structures initialized
	 *  - blocks, including predefined ones, are all set
	 * Postcondition:
	 * 	- available set on every non constant block object is populated
	 */
	public static void populateAvailDigSets() {	
		boolean needsPopulate = true;
		while (needsPopulate) {
			needsPopulate = false;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j].isConst == false) {
						needsPopulate |= board[i][j].populateAvailDigSet();						
					}//fi
				}//rof
			}//rof */
			needsPopulate &= (nonConstBlkSet.size()>0);
		}//end while	
	}//end method
	
    
	/**
	 * This method create a block at row i column j on the game board
	 * Precondition:
	 *  - row and column numbers are valid
	 *  - The value being set follows Sudoku rules. This method does not check for validity 
	 * Postcondition:
	 *  - an Sudoku object is created and put into the board
	 * @param i - int , indicating row number
	 * @param j - int , indicating column number
	 * @param digChar - char, the digit character being set
	 */
	public Sudoku(int i, int j, char digChar) {
		this.posArr[0] = i;
		this.posArr[1] = j;
		this.posArr[2] = (i/3)*3+j/3;
		Integer digit = digChar - '0';
		if (digit < 0) {
			this.isConst = false;
			nonConstBlkSet.add(this);
		} else {
			this.isConst = true;
			this.availDigList = new LinkedList<>();
			rowDigs[posArr[0]][digit] = true;	
			colDigs[posArr[1]][digit] = true;
			gridDigs[posArr[2]][digit] = true;
		}//fi
		this.digit = digit;	
		board[posArr[0]][posArr[1]] = this;
	}//end method
	
	/**
	 * precondition:
	 *  - digit is within valid range
	 *  - assume digit set is from available set. this method does NOT check for this fact
	 * @param digit - Integer type
	 * @return true if digit being set does follow sudoku rules for now
	 */
	public boolean trySetDigit(Integer digit) {
		if ((rowDigs[posArr[0]][digit] || colDigs[posArr[1]][digit] || gridDigs[posArr[2]][digit])) {
			return false;
		} else {
			this.digit = digit;
			rowDigs[posArr[0]][digit] = true;	
			colDigs[posArr[1]][digit] = true;
			gridDigs[posArr[2]][digit] = true;			
		}//fi		
		return true;					
	}//end method

	public void revertDigit(Integer digit) {
		this.digit = null;
		rowDigs[posArr[0]][digit] = false;	
		colDigs[posArr[1]][digit] = false;
		gridDigs[posArr[2]][digit] = false;					
	}//end method
	
	/**
	 * Precondition:
	 *  - digit of every block is set
	 * @param charArrBoard char[][]
	 */
	public static void writeToCharArr(char[][] charArrBoard) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				charArrBoard[i][j] = (char) (board[i][j].digit + 48);
			}//rof
		}//rof
	}//end method
	
    public static void init() {   	
    	board = new Sudoku[9][9];
    	rowDigs = new boolean[9][10];
   		colDigs = new boolean[9][10];
   		gridDigs = new boolean[9][10];  	
   		nonConstBlkSet = new HashSet<>();
    }//end method
    
	@Override
	public int compareTo(Sudoku otherBlk) {	
		return this.availDigList.size() - otherBlk.availDigList.size();
	}//fi

    public static void debug() {   	
    	//System.out.println(board[0][8].availDigSet);
    	
    	for (Sudoku blk : nonConstBlkSet) {
    	
    		System.out.println(blk.availDigList + " : " + blk.posArr[0] + "," + blk.posArr[1]);
    	}//rof
    }//end method
}//end class
