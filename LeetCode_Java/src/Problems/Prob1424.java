package Problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Prob1424 {

	private static String nums1Str = "[[1,2,3],[4,5,6],[7,8,9]]";
	private static String nums2Str = "[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]";
	private static String nums3Str = "[[14,12,19,16,9],[13,14,15,8,11],[11,13,1]]";
	private static List<List<Integer>> nums1List, nums2List, nums3List;

	
	private static void test() {
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            nums1List = objectMapper.readValue(nums1Str, new TypeReference<List<List<Integer>>>(){});
            nums2List = objectMapper.readValue(nums2Str, new TypeReference<List<List<Integer>>>(){});
            nums3List = objectMapper.readValue(nums3Str, new TypeReference<List<List<Integer>>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		Solution1424 solObj = new Solution1424();
		List<List<Integer>> arr;
		int[] ans;
		
		/*
		
		arr = nums1List;
		System.out.println(arr);
		ans = solObj.findDiagonalOrder(arr);
		System.out.println("ans: " + Arrays.toString(ans));
		
		
		arr = nums2List;
		System.out.println(arr);
		ans = solObj.findDiagonalOrder(arr);
		System.out.println("ans: " + Arrays.toString(ans));
		//*/
		
		arr = nums3List;
		System.out.println(arr);
		ans = solObj.findDiagonalOrder(arr);
		System.out.println("ans: " + Arrays.toString(ans));

	}
	public static void main(String[] args) {
		test();
		
	}

}


class Solution1424 {

	private static int[] diagOrderArr = new int[100000];
	private static int[] rowLengthArr = new int[100000];
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    	//step 1, initialize variables
    	int arrInx = 0;
    	int maxRowLength = 0;    	
    	int row, i, j;
    	int iLowerBound = 0, iUpperBound;
    	int consecutiveMiss = 1;
    	boolean completeMiss = false;
    	//step 2, scan through the part that cover first indices (in square array it is the upper half triangle)
    	for (row=0; row<nums.size() && !completeMiss; row++) {
    		rowLengthArr[row] = nums.get(row).size();
    		maxRowLength = Math.max(maxRowLength, rowLengthArr[row]);
    		i=row;
    		j=0;
    		completeMiss = true;
    		while (i>=iLowerBound && j<maxRowLength) {
    			if (j<rowLengthArr[i]) {
        			diagOrderArr[arrInx]=nums.get(i).get(j);
        			arrInx++;
        			consecutiveMiss = 0;
        			completeMiss = false;
    			} else if (i==iLowerBound) {
    				iLowerBound += consecutiveMiss + 1;
    			} else {
    				consecutiveMiss++;
    			}//fi
    			i--;
    			j++;
    		}//end while    			
    	}//rof
    	
    	//step 3, scan through the part that starts from last row (in square array it is the lower half triangle)
    	row = nums.size()-1;
    	iUpperBound = row;
    	completeMiss = false;
    	for (int col=1; col<maxRowLength && !completeMiss; col++) {
    		i=iUpperBound;
    		j=col + row - iUpperBound;
    		completeMiss = true;
    		while (i>=iLowerBound && j<maxRowLength) {
    			if (j<rowLengthArr[i]) {
    				//System.out.println("put: " + i + " : " + j + " iUpperBound " + iUpperBound);
        			diagOrderArr[arrInx]=nums.get(i).get(j);
        			arrInx++;
        			consecutiveMiss = 0;
        			completeMiss = false;
    			} else if (i==iLowerBound) {
    				iLowerBound += consecutiveMiss + 1;
    			} else if (i==iUpperBound) {
    				iUpperBound--;
    			} else {
    				consecutiveMiss++;
    			}//fi
    			i--;
    			j++;
    		}//end while    			
    	}//rof
    	
        return Arrays.copyOf(diagOrderArr, arrInx);
    }// end method
	


}// end class
