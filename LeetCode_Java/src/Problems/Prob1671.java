package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1671{

	private static void test() {
		

	
		Solution1671 solObj = new Solution1671();
	
		int[] nums;

		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            nums = objectMapper.readValue("[4,5,13,17,1,7,6,11,2,8,10,15,3,9,12,14,16]", int[].class);
            System.out.println("Arr: " + Arrays.toString(nums));//10
    		System.out.println("ans: " + solObj.minimumMountainRemovals(nums));

    		
    		/*
            nums = objectMapper.readValue("[100,92,89,77,74,66,64,66,64]", int[].class);
            System.out.println("Arr: " + Arrays.toString(nums));//6
    		System.out.println("ans: " + solObj.minimumMountainRemovals(nums));
		             
		             
            nums = objectMapper.readValue("[2,1,1,5,6,2,3,1]", int[].class);
            System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("ans: " + solObj.minimumMountainRemovals(nums));
    		//*/
       
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		

		
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}


class Solution1671{
	

    public int minimumMountainRemovals(int[] nums) {
    	int[] iscArr;
    	int[] bakDscArr;
    	//step 1: build increasing sequence count array
    	iscArr = buildISCntArr(nums);
    	//System.out.println("iscArr" + Arrays.toString(iscArr));
    	
    	//step 2: build backward decreasing sequence count array
    	bakDscArr = buildBakDSCntArr(nums);
    	//System.out.println("bakDscArr" + Arrays.toString(bakDscArr));
    	
    	//step 3: search longest mountain
    	int maxMtLength = 1;
    	for (int summit = 1; summit<nums.length; summit++) {    		
    		
    			if (iscArr[summit] > 1 && bakDscArr[summit] > 1) {
    				maxMtLength = Math.max(maxMtLength, iscArr[summit] + bakDscArr[summit]);
    			}//fi
    			//System.out.println("mt length: " + maxMtLength);

    		
    	}//rof
    	//System.out.println("mt length: " + maxMtLength);	
        return nums.length - maxMtLength + 1;
    }//end method
    
    /**
     * Builds an array where each element at index i contains the length of the longest increasing subsequence 
     * ending at position i in the input array.
     *
     * @param nums - int[], The input array of integers.
     * @return int[] where each element at index i represents the length of the longest increasing 
     * subsequence that includes the element at index i in the input array.
     */
    private int[] buildISCntArr(int[] nums) {
    	//array index = index of number array, array value = longest sequence length possible if to include # at this position
		int[] cntArr = new int[nums.length];     	
    	cntArr[0]=1;
    	int currCnt;
    	for (int numInx=1; numInx<nums.length; numInx++) {
    		currCnt = 1;
    		for (int i=numInx-1; i>=currCnt-1; i--) {
        		if (nums[i] < nums[numInx]) {
        			currCnt = Math.max(currCnt,  cntArr[i]+1);
        		}//fi
        	}//rof */
    		cntArr[numInx] = currCnt;
    	}//rof
    	
    	return cntArr;
    }//end method

    /**
     * Builds an array where each element at index i contains the length of the longest decreasing subsequence 
     * starting from position i in the input array, effectively working backward from the end of the array.
     *
     * @param nums - int[], The input array of integers.
     * @return int[] where each element at index i represents the length of the longest decreasing 
     * subsequence starting at index i in the input array.
     */
    private int[] buildBakDSCntArr(int[] nums) {
    	//array index = index of number array, array value = longest backward sequence length possible if to include # at this position
		int[] cntArr = new int[nums.length];     	
    	cntArr[nums.length-1]=1;
    	int currCnt;
    	for (int numInx=nums.length-2; numInx>=0; numInx--) {
    		currCnt = 1;
    		for (int i=numInx+1; i<=nums.length-currCnt; i++) {
        		if (nums[i] < nums[numInx]) {
        			currCnt = Math.max(currCnt,  cntArr[i]+1);
        		}//fi        		
        	}//rof */
    		cntArr[numInx] = currCnt;    	
    	}//rof    	
    	return cntArr;
    }//end method
    

    public int minimumMountainRemovals_v1(int[] nums) {
    	int[] iscArr;
    	int[] bakDscArr;
    	//step 1: build increasing sequence count array
    	iscArr = buildISCntArr(nums);
    	//System.out.println("iscArr" + Arrays.toString(iscArr));
    	
    	//step 2: build backward decreasing sequence count array
    	bakDscArr = buildBakDSCntArr(nums);
    	//System.out.println("bakDscArr" + Arrays.toString(bakDscArr));
    	
    	//step 3: search longest mountain
    	int maxMtLength = 1;
    	int leftInx, rightInx;
    	for (leftInx = 0; leftInx<nums.length-1; leftInx++) {    		
    		for (rightInx = leftInx+1; rightInx<nums.length; rightInx++) {  
    			if (nums[leftInx] < nums[rightInx] && bakDscArr[rightInx] > 1) {
    				maxMtLength = Math.max(maxMtLength, iscArr[leftInx] + bakDscArr[rightInx]);
    			}//fi
    			//System.out.println("mt length: " + maxMtLength);
    		}//rof
    		
    	}//rof
    	//System.out.println("mt length: " + maxMtLength);	
        return nums.length - maxMtLength;
    }//end method
    
}//end class


