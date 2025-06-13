package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2958 {


	
	private static void test() {
		
		Solution2958 solObj = new Solution2958();
		
		CorrectSolution2958 correctSolObj = new CorrectSolution2958();

		int[] testArr;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
                                    
            testArr = mapper.readValue("[1,2,3,1,2,3,1,2]", int[].class);        
    		k = 2;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSubarrayLength(testArr, k));
 			System.out.println("correct Ans: " + correctSolObj.maxSubarrayLength(testArr, k));
            
 
            testArr = mapper.readValue("[1,2,1,2,1,2,1,2]", int[].class);
    		k = 1;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.maxSubarrayLength(testArr, k));
			System.out.println("correct Ans: " + correctSolObj.maxSubarrayLength(testArr, k));
            
            
            testArr = mapper.readValue("[1,2,2,1,3]", int[].class);
     		k = 1;
     		System.out.println("Arr: " + Arrays.toString(testArr));
     		System.out.println("Ans: " + solObj.maxSubarrayLength(testArr, k));
			System.out.println("correct Ans: " + correctSolObj.maxSubarrayLength(testArr, k));
            
            // */
            testArr = mapper.readValue("[1,1,1,3]", int[].class);
     		k = 2;
     		System.out.println("Arr: " + Arrays.toString(testArr));
     		System.out.println("Ans: " + solObj.maxSubarrayLength(testArr, k));
     		System.out.println("correct Ans: " + correctSolObj.maxSubarrayLength(testArr, k));
            
  
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
    	//special case: array length is 1
    	if (nums.length == 1) {
    		return 1;
    	}//fi
    	
    	//prepare all variables for sliding window 
    	Map<Integer, Integer> cntMap = new HashMap<>();
    	int maxSubarrayLength = 1;
    	Integer freq = 0;
    	int lInx, rInx;
    	int overflowNum=-1;//dummy
    	cntMap.put(overflowNum, 0);

    	//step 1, find maximum window size (effectively subarray length) at left window index = 0
    	lInx = 0;
    	rInx = 0;
    	while (rInx < nums.length && (freq = cntMap.getOrDefault(nums[rInx], 0)+1)<=k) {
    		cntMap.put(nums[rInx], freq);
			rInx++;			
		}//fi
    	if (rInx != nums.length) {
    		overflowNum = nums[rInx];
    		cntMap.put(overflowNum, freq);
    	}//fi
		maxSubarrayLength = rInx - lInx;
		//System.out.println("lrInxes: " + lInx + ":" + rInx);
		//System.out.println(cntMap);

		//step 2, start sliding window
    	for (lInx = 1; lInx < nums.length-maxSubarrayLength; lInx++){
    		freq = cntMap.get(nums[lInx-1])-1;
    		cntMap.put(nums[lInx-1], freq);
    		//System.out.println("lrInxes: " + lInx + ":" + rInx + " map updated: " + cntMap);
    		if (cntMap.get(overflowNum)>k) {//keep contracting left window index
    			continue;
    		} else {
    			rInx++;
    		}//fi
    		
    		while (rInx < nums.length && (freq = cntMap.getOrDefault(nums[rInx], 0)+1)<=k) {    			
    			cntMap.put(nums[rInx], freq);
    			rInx++;
    		}//fi
        	if (rInx < nums.length) {
        		overflowNum = nums[rInx];
        		cntMap.put(overflowNum, freq);        		
        	}//fi
        	maxSubarrayLength = Math.max(maxSubarrayLength, rInx - lInx);
    		//System.out.println("lrInxes: " + lInx + ":" + rInx);
    		//System.out.println(cntMap);
        	
    	}//rof
    	
        return maxSubarrayLength;
    }//end method
}//end class

class CorrectSolution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.get(nums[r]) > k) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}