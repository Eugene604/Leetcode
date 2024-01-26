package Problems;

import java.util.*;

public class Prob576 {

	private static void test() {

		Solution576 solObj = new Solution576();

		int m, n, maxMove, startRow, startColumn;

		m = 2;
		n = 2;
		maxMove = 5;
		startRow = 0;
		startColumn = 0;
		System.out.println("Ans: " + solObj.findPaths(m, n, maxMove, startRow, startColumn));

	}

	public static void main(String[] args) {
		test();
	}// end main
}//end class

class Solution576 {
	private static final long MOD_CONST = 1000000007;  
	//[row index][column index][number of moves], value = number of possible path, -1 if impossible, 0 means NOT calculated yet
	private long[][][] moveCache; 
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		//special case: maxMove is 0
		if (maxMove == 0) {
			return 0;
		}//fi
		
		//set up base cases of cache
		moveCache = new long[m][n][maxMove+1];
		moveCache[startRow][startColumn][0]=1;
		moveCache[startRow][startColumn][1]=-1;
		
		long tmpPaths, totalPaths = 0;

		for (int numOfMoves = maxMove-1; numOfMoves >=0; numOfMoves--) {
			//get upper and lower edges
			for (int j = 0; j < n; j++) {
				if ((tmpPaths = getMoves(0, j, numOfMoves)) > 0) {
					totalPaths = (totalPaths + tmpPaths)%MOD_CONST;
				}//fi
				if ((tmpPaths = getMoves(m-1, j, numOfMoves)) > 0) {
					totalPaths = (totalPaths + tmpPaths)%MOD_CONST;
				}//fi
			}//rof
			
			//get left and right edges
			for (int i = 0; i < m; i++) {
				if ((tmpPaths = getMoves(i, 0, numOfMoves)) > 0) {
					totalPaths = (totalPaths + tmpPaths)%MOD_CONST;
				}//fi
				if ((tmpPaths = getMoves(i, n-1, numOfMoves)) > 0) {
					totalPaths = (totalPaths + tmpPaths)%MOD_CONST;
				}//fi
			}//rof


		}//rof
		
		
		return (int) totalPaths;
	}// end method

	/**
	 * get number of possible moves at coordinate i, j and number of move (exact)
	 * @param inxI - int, the row index
	 * @param inxJ - int, the colume index
	 * @param move - int, number of moves. 
	 * @return long, number of possible moves moded to MOD_CONST
	 */
	private long getMoves(int inxI, int inxJ, int move) {
		if (moveCache[inxI][inxJ][move] != 0) {
			return moveCache[inxI][inxJ][move];
		}//fi
		
		//base case
		if (move == 0) {
			moveCache[inxI][inxJ][move] = -1;
			return -1;
		}//fi
		
		long tmpMove, totalMoves = 0;
		
		//up
		if (inxI > 0) {
			tmpMove = getMoves(inxI-1, inxJ, move-1);
			if (tmpMove != -1) {
				totalMoves += tmpMove;
			}//fi
		}//fi
		
		//down
		if (inxI < moveCache.length-1) {
			tmpMove = getMoves(inxI+1, inxJ, move-1);
			if (tmpMove != -1) {
				totalMoves += tmpMove;
			}//fi
		}//fi
		
		//left
		if (inxJ > 0) {
			tmpMove = getMoves(inxI, inxJ-1, move-1);
			if (tmpMove != -1) {
				totalMoves += tmpMove;
			}//fi
		}//fi
		
		//right
		if (inxJ < moveCache[0].length-1) {
			tmpMove = getMoves(inxI, inxJ+1, move-1);
			if (tmpMove != -1) {
				totalMoves += tmpMove;
			}//fi
		}//fi
		
		totalMoves %= MOD_CONST; 
		
		if (totalMoves == 0) {
			totalMoves = -1;
		}//fi
		
		
		moveCache[inxI][inxJ][move] = totalMoves;
		
		return totalMoves;
	}//end method
}// end class
