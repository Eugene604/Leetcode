package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2444 {


	
	private static void test() {
		
		Solution2444 solObj = new Solution2444();
		
		CorrectSolution2444 correctSolObj = new CorrectSolution2444();

		int[] testArr;
		int minK, maxK;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            testArr = mapper.readValue("[1,3,5,2,7,5]", int[].class);
            minK = 1;
            maxK = 5;
       		System.out.println("Arr: " + Arrays.toString(testArr));
       		System.out.println("Ans: " + solObj.countSubarrays(testArr, minK, maxK));
       		System.out.println("correct Ans: " + correctSolObj.countSubarrays(testArr, minK, maxK));
    
       		/*
       		
            
   			// */
            
      
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
    	long arrCnt = 0, currCnt;
    	int lastOFBInx = -1;
    	int minKInx = -2, maxKInx = -2;
    	for (int i=0; i<nums.length; i++) {
    		if (nums[i]>maxK || nums[i]<minK) {
    			lastOFBInx = i;
    		}//fi
    		if (nums[i]==maxK) {
    			maxKInx = i;
    		}//fi
    		if (nums[i]==minK) {
    			minKInx = i;
    		}//fi
    		if ((currCnt = Math.min(maxKInx, minKInx) - lastOFBInx)>0) {
    			arrCnt += currCnt;
    		}//fi
    		
    	}//rof
        return arrCnt;
    }//end method
}//end class

class CorrectSolution2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int badIdx = -1, leftIdx = -1, rightIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                badIdx = i;
            }

            if (nums[i] == minK) {
                leftIdx = i;
            }

            if (nums[i] == maxK) {
                rightIdx = i;
            }

            res += Math.max(0, Math.min(leftIdx, rightIdx) - badIdx);
        }

        return res;
    }
}