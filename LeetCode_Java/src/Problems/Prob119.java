package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob119 {
	

	
	public static void main(String[] args) {
		Solution119 solObj = new Solution119();
		List<Integer> sol;
	
		sol = solObj.getRow(5);
		System.out.println("sol: " + sol.toString());		
		 //*/
		
		sol = solObj.getRow(6);
		System.out.println("sol: " + sol.toString());		
		
		sol = solObj.getRow(7);
		System.out.println("sol: " + sol.toString());	
	}

}


class Solution119 {
	 	
	private static List<List<Integer>> pTri;
	private static int lastPopulatedPTriRow; 
	static {
		pTri = new ArrayList<>(1);
		ArrayList<Integer> tmpList;
		tmpList = new ArrayList<>(1);
		tmpList.add(1);
		pTri.add(tmpList);
		tmpList = new ArrayList<>(2);
		tmpList.add(1);
		tmpList.add(1);
		pTri.add(tmpList);
		lastPopulatedPTriRow = 2;
	}//end static
	
	/**
	 * Generate Pascal's triangle up to the rowNum
	 * Precondition:
	 * 1. It is assumed that the following data structures are prepared and valid:
	 * - pTri 
	 * - secondPTriRow
	 * - lastPopulatedPTriRow
	 * 2. rowNum < lastPopulatedPTriRow,
	 * Note, this method does NOT check for the validity of rowNum. If rowNum is <  lastPopulatedPTriRow, weird effect will happen.
	 * Postcondition:
	 * - lastPopulatedPTriRow updated
	 * - Pascal triangle with rows up to rowNum generated
	 * @param rowNum int value indicating the row number of pascal's triangle. It is NOT the row/index number of the list.
	 */
	private static void generatePTriRow(int rowNum) {
		List<Integer> tmpList;
		Integer preInt;
		for (int layerInx = lastPopulatedPTriRow; layerInx<rowNum; layerInx++) {
			tmpList = new ArrayList<>(30);
			preInt=0;
			for (Integer currInt:pTri.get(layerInx-1)) {
				tmpList.add(preInt+currInt);
				preInt = currInt;
			}//rof
			tmpList.add(1);
			pTri.add(tmpList);
		}//rof
		lastPopulatedPTriRow = rowNum;
	}//end method
	
    public List<List<Integer>> generate(int numRows) {
    	if (numRows > lastPopulatedPTriRow) {
    		generatePTriRow(numRows);
    	}//fi
    	//System.out.println("pTri: " + pTri);
    	return pTri.subList(0, numRows);
	}//end method
    
    public List<Integer> getRow(int rowIndex) {
    	int numOfRows = rowIndex + 1;
    	if (numOfRows > lastPopulatedPTriRow) {
    		generatePTriRow(numOfRows);
    	}//fi
    	//System.out.println("pTri: " + pTri);
    	return pTri.get(rowIndex);
    }//end method
}//end class
