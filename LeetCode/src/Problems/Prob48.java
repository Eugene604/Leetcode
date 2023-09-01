package Problems;

import java.util.*;

public class Prob48 {

	
	static int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
	static int[][] arr2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

	
	static void test() {
		Solution48 solObj = new Solution48();
		int[][] arr;
		
		/*
		arr = arr1;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		arr = arr2;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		
		arr = arr3;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		
		arr = arr4; //[2,1,3]
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		
		arr = arr5; //[5,1,1]
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		
		arr = arr6; //[2,2,1,1,2,2,2,2]
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
		
		//*/
		
		arr = arr2; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		solObj.rotate(arr);
		System.out.println("processed arr: " + Arrays.deepToString(arr));
	}
	
	public static void main(String[] args) {
		test();

	}

}



class Solution48 {
	private int[][] matrix;
	private int lastInx;
	
    public void rotate(int[][] matrix) {
    	this.matrix = matrix;
        this.lastInx = matrix[0].length-1;
        int stopRotationInx =  matrix[0].length/2-1;
        for (int i=0; i<=stopRotationInx; i++) {
        	for (int j=i; j<=lastInx-i-1; j++) {
        		//System.out.println("try rotate: " + i + "," + j + " : " + matrix[i][j]);
        		circulate(i,j);
        	}//rof
        }//rof
        
    }//end method
    
    /**
     * Precondition: following variables are set/initialized:
     * - int[][] matrix
     * - int lastInx - last index of an arbitrary array
     * Postcondition: given element and corresponding elements in four corners are rotated
     * @param i int value indicating first layer index
     * @param j int value indicating first layer index
     */
    private void circulate(int i, int j) {
    	int originalI = i, originalJ = j;
    	int newI, newJ;
    	int prevVal, tmpVal;
    	
    	//first corner to second corner
    	newI = j;
    	newJ = lastInx-i;
    	prevVal = matrix[newI][newJ];
    	matrix[newI][newJ] = matrix[i][j];
    	i = newI;
    	j = newJ;
    	
    	//second corner to third corner
    	newI = j;
    	newJ = lastInx-i;    
    	tmpVal = matrix[newI][newJ];
    	matrix[newI][newJ] = prevVal;    	
    	prevVal = tmpVal;
    	i = newI;
    	j = newJ;
    	
    	//third corner to fourth corner
    	newI = j;
    	newJ = lastInx-i; 
    	tmpVal = matrix[newI][newJ];
    	matrix[newI][newJ] = prevVal;  
    	
    	//finally stores forth to first
    	matrix[originalI][originalJ] = tmpVal;
    }//end method
}//end class
