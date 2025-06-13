package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2966{

	static String nums1 = "[1,3,4,8,7,9,3,5,1]";
	static String nums2 = "[15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2]";

	static void test() throws JsonMappingException, JsonProcessingException {
		Solution2966 solObj = new Solution2966();
		int[][] ansMat;
		int[] nums;
		int k;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

     
        /*
	
        nums =  objectMapper.readValue(nums1, int[].class);
        k = 2;
		System.out.println("orignal arr: " + Arrays.toString(nums));
		ansMat = solObj.divideArray(nums, k);
		System.out.println("resulting mat: ");
		MatrixUtils.displayMatrix(ansMat);
		//*/
		
        nums =  objectMapper.readValue(nums2, int[].class);
        k = 2;
		System.out.println("orignal arr: " + Arrays.toString(nums));
		ansMat = solObj.divideArray(nums, k);
		System.out.println("resulting mat: ");
		MatrixUtils.displayMatrix(ansMat);
		
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class Solution2966{
    public int[][] divideArray(int[] nums, int k) {    	
    	Arrays.sort(nums);
    	int[][] ansArr = new int[nums.length/3][3];
    	int i=0,j=0;
    	for (int n=0; n<nums.length; n++) {
    		ansArr[i][j] = nums[n];
			if (j!=0 && nums[n] - ansArr[i][0] > k) {
				return new int[0][0];
			}//fi
			
    		if (j!=2) {
    			j++;
    		} else {
        		i++;
    			j = 0;
    		}//fi    		
    	}//rof
    	
        return ansArr;
    }//end method
}// end class

