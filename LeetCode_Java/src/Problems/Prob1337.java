package Problems;

import java.util.*;

public class Prob1337 {

	
	static int[][] arr1 = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
	static int[][] arr2 = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
	static int[][] arr3 = {{1,1, 1, 1, 1 }, { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 },{1,1,1,0,0}};
	static int[][] arr4 = {{1,0},{1,0},{1,0},{1,1}};

	
	static void test() {
		Solution1337 solObj = new Solution1337();
		int[][] arr;
		int k;
		
		
		arr = arr1; 
		k = 3;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("processed arr: " + Arrays.toString(solObj.kWeakestRows(arr,k)));
		
		arr = arr2; 
		k = 2;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("processed arr: " + Arrays.toString(solObj.kWeakestRows(arr,k)));
		
		arr = arr3; 
		k = 5;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("processed arr: " + Arrays.toString(solObj.kWeakestRows(arr,k)));	
		//*/
		arr = arr4; 
		k = 4;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("processed arr: " + Arrays.toString(solObj.kWeakestRows(arr,k)));
		
		

	}
	
	public static void main(String[] args) {
		test();

	}

}



class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
    	int[] solArr = new int[k];
    	boolean[] excluded = new boolean[mat.length];
    	int currAvalInx = 0;
		for (int j=0; j<mat[0].length; j++) {
	    	for (int i=0; i<mat.length; i++) {
	        	if (excluded[i] || mat[i][j] == 1) {
	        		continue;
	        	} else {
	        		solArr[currAvalInx] = i;
	        		excluded[i] = true;
	        		if (++currAvalInx == k) {
	        			return solArr;
	        		}//fi
	        	}//fi	        	
	    	}//rof
		}//rof
		//have not filled k elements yet, it means there are arrays of all ones
		for (int i=0; i<mat.length; i++) {
        	if (excluded[i]) {
        		continue;
        	} else {
        		solArr[currAvalInx] = i;
        		if (++currAvalInx == k) {
        			return solArr;
        		}//fi
        	}//fi	        	
    	}//rof
    	return solArr;
    }//end method

}//end class
