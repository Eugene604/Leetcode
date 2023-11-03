package Problems;

import java.util.*;

public class Prob799 {

	private static void test() {

		Solution799 solObj = new Solution799();
		Solution799_v2 solObjV2 = new Solution799_v2();
		int poured, queryRow, queryGlass;

		poured = 25;
		queryRow = 6;
		queryGlass = 1;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass));
		// System.out.println("ans from v2: " + solObjV2.champagneTower(poured,
		// queryRow, queryGlass));

		poured = 6;
		queryRow = 2;
		queryGlass = 0;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass));
		// System.out.println("ans from v2: " + solObjV2.champagneTower(poured,
		// queryRow, queryGlass));

		poured = 100000009;
		queryRow = 33;
		queryGlass = 17;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass));
		/*
		poured = 1000000000;
		queryRow = 99;
		queryGlass = 99;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass));

		poured = 1000000000;
		queryRow = 99;
		queryGlass = 78;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass));

		poured = 1000000000;
		queryRow = 99;
		queryGlass = 99;
		System.out.println("ans: " + solObj.champagneTower(poured, queryRow, queryGlass)); 
		//*/

	}// end method

	public static void main(String[] args) {
		test();

	}
}


class Solution799 {

	private static final int TOWER_SIZE = 100;

	private static double[][] tower = new double[TOWER_SIZE+1][TOWER_SIZE+1];
	
	private static int prevQueryRow=0;


	public double champagneTower(int poured, int query_row, int query_glass) {		
		tower[0][0] = (double)poured;
		clearRows(1,prevQueryRow);
		double overflowAmount;
		POUR_TO_TOWER:
		for (int rowID = 0; rowID <= query_row; rowID++) {
			//System.out.println("next row: " + Arrays.toString(tower[rowID+1]));
			for (int glassID=0; glassID <= rowID; glassID++) {
				overflowAmount = (tower[rowID][glassID]-1)/2;
				if (overflowAmount<0) {
					if (glassID == rowID/2) {
						//System.out.println("exit from here " + rowID + ":" + glassID);
						break POUR_TO_TOWER;
					} else {
						continue;
					}//fi
				}//fi
				//overflow to left child
				tower[rowID+1][glassID] += overflowAmount;
				//overflow to right child
				tower[rowID+1][glassID+1] += overflowAmount;
			}//rof
			prevQueryRow = rowID;
		}//rof
		
		return tower[query_row][query_glass] > 1 ? 1 : tower[query_row][query_glass];
		
	}// end method

	/**
	 * precondition: 
	 * - does not check for the validity of indices
	 * - required data structure is available - tower
	 * 
	 * @param fromInx - int from index, inclusive
	 * @param toInx - int to index, inclusive
	 */
	private void clearRows(int fromInx, int toInx) {
		for (;fromInx<=toInx; fromInx++) {
			tower[fromInx] = new double[TOWER_SIZE+1];
		}//rof
	}//end method
}// end class

class Solution799_v2 {

	private static final int TOWER_SIZE = 100;
	/*
	 * a 101 x 101 (TOWER_SIZE+1) array that stores two kinds of thresholds lower
	 * left triangle stores known amount of champagne that the glass will still be
	 * empty for each glass Example: cutOffs[i][j] = 300, it means any amount less
	 * than or equal to 300 bottles of champagne poured will make glass[i][j] empty
	 * upper right triangle stores known amount of champagne that will make glass
	 * full for each glass Example: cutOffs[TOWER_SIZE-i][TOWER_SIZE-j] = 300, it
	 * means any amount greater than or equal to 300 bottles of champagne poured
	 * will make glass[i][j] full
	 * 
	 */
	private static int[][] cutOffs;

	static {
		cutOffs = new int[TOWER_SIZE + 1][TOWER_SIZE + 1];
		cutOffs[TOWER_SIZE][TOWER_SIZE] = 1;
	}// end static block

	public double champagneTower(int poured, int queryRow, int queryGlass) {
		int emptyThreshold, fullThreshold;
		if ((fullThreshold = cutOffs[TOWER_SIZE - queryRow][TOWER_SIZE - queryGlass]) != 0 && fullThreshold <= poured) {
			return 1;
		} // fi
			// including a special case: first glass
		if (queryRow == 0 || (emptyThreshold = cutOffs[queryRow][queryGlass]) != 0 && emptyThreshold >= poured) {
			return 0;
		} // fi

		double amountFromParents = 0;
		if (queryGlass == 0) { // only has right parent
			amountFromParents += queryGlassOverflow(queryRow - 1, queryGlass, poured);
		} else if (queryGlass == queryRow) { // only has left parent
			amountFromParents += queryGlassOverflow(queryRow - 1, queryGlass - 1, poured);
		} else { // has both parents
			amountFromParents += queryGlassOverflow(queryRow - 1, queryGlass - 1, poured);
			amountFromParents += queryGlassOverflow(queryRow - 1, queryGlass, poured);
		} // fi
		return amountFromParents > 1 ? 1 : amountFromParents;

	}// end method

	/**
	 * Preconditions: - assume row and glass ids are valid, does NOT check for
	 * validity - required data structure is instantiated: cutOffs
	 * 
	 * @param rowID   - int
	 * @param glassID - int
	 * @param poured  - int
	 * @return double - amount of overflow of ONE SIDE
	 */
	private double queryGlassOverflow(int rowID, int glassID, int poured) {
		int emptyThreshold;
		if ((emptyThreshold = cutOffs[rowID][glassID]) != 0 && emptyThreshold >= poured) {
			return 0;
		} // fi

		// base case: top
		if (rowID == 0) {
			return (double) (poured - 1) / 2;
		} // fi

		double amountFromParents = 0;
		if (glassID == 0) { // only has right parent
			amountFromParents += queryGlassOverflow(rowID - 1, glassID, poured);
		} else if (glassID == rowID) { // only has left parent
			amountFromParents += queryGlassOverflow(rowID - 1, glassID - 1, poured);
		} else { // has both parents
			amountFromParents += queryGlassOverflow(rowID - 1, glassID - 1, poured);
			amountFromParents += queryGlassOverflow(rowID - 1, glassID, poured);
		} // fi
		if (amountFromParents == 0 && cutOffs[rowID][glassID] < poured) {
			cutOffs[rowID][glassID] = poured;
		} else if (amountFromParents > 1 && cutOffs[TOWER_SIZE - rowID][TOWER_SIZE - glassID] > poured) {
			cutOffs[TOWER_SIZE - rowID][TOWER_SIZE - glassID] = poured;
		} // fi
		if (amountFromParents < 1) {
			// System.out.println("return from here " + rowID + " : " + glassID);
			return 0;
		} else {
			return (amountFromParents - 1) / 2;
		} // fi
	}// end method
}// end class
