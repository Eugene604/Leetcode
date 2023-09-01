package Problems;

import java.util.*;

public class Prob646 {

	
	static int[][] arr1 = {{1,2},{2,3},{3,4}};
	static int[][] arr2 = {{1,2},{7,8},{4,5}};
	static int[][] arr3 = {{1,2}};
	static int[][] arr4 = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
	static int[][] arr5 = {{5,7},{-8,2},{-3,7},{-8,9},{-2,1},{-8,-5},{-2,-1},{2,4},{2,6}};
	
	static void test() {
		Solution646 solObj;
		int[][] arr;
		
		/*
		
		solObj = new Solution646();
		arr = arr1; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));	
		System.out.println("ans: " +solObj.findLongestChain(arr));
		
	
		
		solObj = new Solution646();
		arr = arr2; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));	
		System.out.println("ans: " +solObj.findLongestChain(arr));
		
		solObj = new Solution646();
		arr = arr3; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));	
		System.out.println("ans: " +solObj.findLongestChain(arr));
		
	
		
		solObj = new Solution646();
		arr = arr4; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));	
		System.out.println("ans: " +solObj.findLongestChain(arr));
		
		//*/
		
		solObj = new Solution646();
		arr = arr5; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));	
		System.out.println("ans: " +solObj.findLongestChain(arr));
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution646 {
	
	private static final Comparator<int[]> INT_PAIR_COMPARATOR = new Comparator<int[]>() {
		/**
		 * preconditions:
		 * Array lengths of both array must > 2
		 */
        @Override
        public int compare(int[] arr1, int[] arr2) {

        	return Integer.compare(arr1[1], arr2[1]);

        }//end method
    };
    
    private int[][] pairArr;
        
    private int globalLongestChain;
    
    public int findLongestChain(int[][] pairs) {
    	this.pairArr = pairs;
    	Arrays.parallelSort(pairArr, INT_PAIR_COMPARATOR);	
    	searchLongestChain();	
        return globalLongestChain;    
    }//end method
    
    /**
     * Recursively search for longest chain
     * Precondition: data structures are set / instantiated
     * - longestChain array
     * - global longest chain value
     * - pair array, must be sorted
     * 
     */
    private void searchLongestChain() {

    	int prevHi = Integer.MIN_VALUE;
    	for (int currInx=0; currInx<pairArr.length; currInx++) {
    		if (pairArr[currInx][0] > prevHi) {//new chain block successfully added
    			globalLongestChain++;
    			prevHi = pairArr[currInx][1];
    		}//fi
    	}//rof
    }//fi
}//end class

class Solution646_v2 {
	
	private static final Comparator<int[]> INT_PAIR_COMPARATOR = new Comparator<int[]>() {
		/**
		 * preconditions:
		 * Array lengths of both array must > 2
		 */
        @Override
        public int compare(int[] arr1, int[] arr2) {
        	int result;
        	
           	/*
        	if ((result=Integer.compare(arr1[0], arr2[0]))!=0){
        		return result;
        	} else {
        		return Integer.compare(arr1[1], arr2[1]);
        	}//fi  */
        	if ((result=Integer.compare(arr1[1], arr2[1]))!=0){
        		return result;
        	} else {
        		return Integer.compare(arr1[0], arr2[0]);
        	}//fi  */  
        }//end method
    };
    
    private int[][] pairArr;
    
    private int[] longestChain;
    
    private int globalLongestChain = 1;
    
    public int findLongestChain(int[][] pairs) {
    	this.pairArr = pairs;
    	Arrays.parallelSort(pairArr, INT_PAIR_COMPARATOR);
    	this.longestChain = new int[pairArr.length];
    	this.longestChain[pairArr.length-1]=1;
    	for (int inx = pairArr.length-2; inx >= 0; inx--) {
    		searchLongestChain(inx);
    	}//rof 	
        return globalLongestChain;    
    }//end method
    
    /**
     * Recursively search for longest chain
     * Precondition: data structures are set / instantiated
     * - longestChain array
     * - global longest chain value
     * - pair array, must be sorted
     * 
     * @param inx - int 
     * @return int value denoting longest chain possible from index inx
     */
    private int searchLongestChain(int inx) {
    	//System.out.println("engered, inx: " + inx);
    	if (longestChain[inx] != 0) {
    		return longestChain[inx];
    	}//fi
    	int tmpChainLength, localLongestChain = 1;
    	for (int currInx=inx+1; currInx<pairArr.length; currInx++) {
    		if (pairArr[inx][1] < pairArr[currInx][0]) {//new chain block successfully added
    			if ((tmpChainLength = searchLongestChain(currInx)+1)>localLongestChain) {
    				localLongestChain = tmpChainLength;
    		    	if (localLongestChain > globalLongestChain) {
    		    		globalLongestChain = localLongestChain;
    		    		break;
    		    	}//fi
    			}//fi
    		}//fi
    	}//fi
    	longestChain[inx] = localLongestChain;
    	return localLongestChain;
    }//fi
}//end class
