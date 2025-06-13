package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1442{


	static void test() {
		
		int[] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[2,3,1,6,7]", int[].class);
            
            arr2 = objectMapper.readValue("[2]", int[].class);
            
            arr3 = objectMapper.readValue("[2,2]", int[].class);


            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1442 solObj  = new Solution1442();
		int[] arr;
		
		
		/*
		arr = arr1;		
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("ans: " + solObj.countTriplets(arr));
		System.out.println();
		
		arr = arr2;		
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("ans: " + solObj.countTriplets(arr));
		System.out.println();
		//*/
		
		arr = arr3;		
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("ans: " + solObj.countTriplets(arr));
		System.out.println();

	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1442{
    public int countTriplets(int[] arr) {
    	int[] prefixXORArr = new int[arr.length];
    	
    	//step 1, prepare prefix xor array
    	prefixXORArr[0] = arr[0];
    	for (int i=1; i<arr.length; i++) {
    		prefixXORArr[i] = arr[i]^prefixXORArr[i-1];
    	}//rof
    	//System.out.println("prefixXORArr: " + Arrays.toString(prefixXORArr));
    	
    	//step 2, try all left and right bound combinations and then for each combination get # of equal pairs
    	
    	int tripletsCnt = 0;
    	for (int leftInx = 0; leftInx < arr.length-1; leftInx++) {
    		int preLeftCumXOR = (leftInx==0)? 0:prefixXORArr[leftInx-1];
    		for (int rightInx = leftInx+1; rightInx < arr.length; rightInx++) {
    			if ((prefixXORArr[rightInx] ^ preLeftCumXOR) == 0) {
    				//System.out.println("L:" + leftInx + " R:" + rightInx);
    				tripletsCnt += countEqlPairs(prefixXORArr, leftInx, rightInx);
    			}//fi
    		}//rof
    	}//rof
        return tripletsCnt;
    }//end method
    
    /**
     * Calculates the number of possible equal pairs within a specified range of a prefix XOR array.
     * 
     * Precondition:
     * - It is assumed that prefix xor array is valid
     * - It is assumed that left and right indices are valid w.r.t to prefix xor array
     * 
     * @param prefixXORArr - int[], The prefix XOR array containing cumulative XOR values.
     * @param leftInx - int, The left boundary index (inclusive) of the range.
     * @param rightInx - int, The right boundary index (inclusive) of the range.
     * @return int, number of possible equal pairs
     */
    private int countEqlPairs(int[] prefixXORArr, int leftInx, int rightInx) {
    	int pairCnt = 0;
    	int leftCumXOR, rightCumXOR;
    	int preLeftCumXOR = (leftInx==0)? 0:prefixXORArr[leftInx-1];
    	for (int separatorInx = leftInx; separatorInx < rightInx; separatorInx++) {
    		leftCumXOR = prefixXORArr[separatorInx] ^ preLeftCumXOR;
    		rightCumXOR = prefixXORArr[rightInx] ^ prefixXORArr[separatorInx];
    		//System.out.println("leftCumXOR:" + leftCumXOR + " rightCumXOR:" + rightCumXOR);
    		if (leftCumXOR == rightCumXOR) {
    			pairCnt++;
    		}//fi
    	}//rof
    	return pairCnt;
    }//end method 
}// end class
