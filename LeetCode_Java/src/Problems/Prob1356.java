package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1356 {

	private static int[] arr1 = {1024,512,256,128,64,32,16,8,4,2,1 };
	private static int[] arr2 = { 0,1,2,3,4,5,6,7,8 };
	private static int[] arr3 = { 1, 2 };

	public static void test() {

		Solution1356 solObj = new Solution1356();
		int[] testArr;

		testArr = arr1;
		System.out.println(Arrays.toString(solObj.sortByBits(testArr)) + ":" + Arrays.toString(testArr));

		testArr = arr2;
		System.out.println(Arrays.toString(solObj.sortByBits(testArr)) + ":" + Arrays.toString(testArr));

		// */
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution1356 {
	private static final int PV_SHIFT; //bit shift for priority value
	private static int[] priorityCache;
	private static Comparator<Integer> nobComparator; 
	
	static {
		PV_SHIFT = 15;
		priorityCache = new int[1<<(PV_SHIFT-1)];
		priorityCache[0]=0;
		nobComparator = new NumOfOneBitsComparator(priorityCache);
	}//end static
	
    public int[] sortByBits(int[] arr) {
    	//base case:
    	if (arr.length==1) {
    		return arr;
    	}//fi
    	arr = Arrays.stream(arr).
    		    boxed().
    		    sorted(nobComparator). // sort 
    		    mapToInt(i -> i).
    		    toArray();
        return arr;
    }// end method
    
    
    /**
     * Compare two number based on number of ones
     * if same # of bits, compare their native values
     * Precondition:
     * priorityCache is instantiated and valid
     * 
     * @param a - int , 0~10000
     * @param b - int , 0~10000
     * @return 0 if equal, negative if a<b, positive if a>b
     */
    private static int comp(int a, int b) {
    	if (priorityCache[a]==0) {
    		populatePriority(a);
    	}//fi
    	if (priorityCache[b]==0) {
    		populatePriority(b);
    	}//fi
    	return priorityCache[a] - priorityCache[b];    	
    }//end method
    
    /**
     * populate the priority value for a number
     * precondition:
     * 1. required data structure is instantiated - priorityCache
     * 2. does not check num validity
     * 
     * postcondition:
     * the priority value is populate at index = num
     * 
     * @param num - int, 0 < num <= 10000
     */
    private static void populatePriority(int num) {
    	int numOfOnes = 0;
    	/*
    	for (int i=1<<PV_SHIFT; i>0; i>>=1) {
    		//System.out.println(" i: " + i );
        	if ((num&i) != 0) {
        		numOfOnes++;
        	}//fi
    	}//rof //*/
    	
    	priorityCache[num] = (Integer.bitCount(num)<<PV_SHIFT) + num;    	    	
    }//end method
    
    static class NumOfOneBitsComparator implements Comparator<Integer> {
        private final int[] priorityCache;

        public NumOfOneBitsComparator(int[] priorityCache) {
            this.priorityCache = priorityCache;
        }

        @Override
        public int compare(Integer a, Integer b) {           
            return comp(a,b);
        }
    }//end class
}// end class

class Solution1356_v2 {
	private static final int PV_SHIFT; //bit shift for priority value
	private static int[] priorityCache;
	
	static {
		PV_SHIFT = 15;
		priorityCache = new int[1<<(PV_SHIFT-1)];
		priorityCache[0]=0;
	
	}//end static
	
    public int[] sortByBits(int[] arr) {
    	//base case:
    	if (arr.length==1) {
    		return arr;
    	}//fi
    	sortArr(arr);
        return arr;
    }// end method
    
    /**
     * sort array according to element's priority value
     * precondition: array size > 1
     * @param arr - int[], array elements must be a valid node ID of graph
     */
    private void sortArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
        	int key = arr[i];
            int j = i - 1;
            while (j >= 0 && comp(arr[j],key)>0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }//end while
            arr[j + 1] = key;
        }//rof
    }//end method   
    
    /**
     * Compare two number based on number of ones
     * if same # of bits, compare their native values
     * Precondition:
     * priorityCache is instantiated and valid
     * 
     * @param a - int , 0~10000
     * @param b - int , 0~10000
     * @return 0 if equal, negative if a<b, positive if a>b
     */
    private int comp(int a, int b) {
    	if (priorityCache[a]==0) {
    		populatePriority(a);
    	}//fi
    	if (priorityCache[b]==0) {
    		populatePriority(b);
    	}//fi
    	return priorityCache[a] - priorityCache[b];    	
    }//end method
    
    /**
     * populate the priority value for a number
     * precondition:
     * 1. required data structure is instantiated - priorityCache
     * 2. does not check num validity
     * 
     * postcondition:
     * the priority value is populate at index = num
     * 
     * @param num - int, 0 < num <= 10000
     */
    private static void populatePriority(int num) {
    	int numOfOnes = 0;
    	for (int i=1<<PV_SHIFT; i>0; i>>=1) {
    		//System.out.println(" i: " + i );
        	if ((num&i) != 0) {
        		numOfOnes++;
        	}//fi
    	}//rof
    	priorityCache[num] = (numOfOnes<<PV_SHIFT) + num;    	    	
    }//end method
    
}// end class

