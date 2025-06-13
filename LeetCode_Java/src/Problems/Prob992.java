package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob992 {


	
	private static void test() {
		
		Solution992 solObj = new Solution992();
		
		CorrectSolution992 correctSolObj = new CorrectSolution992();

		int[] testArr;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            testArr = mapper.readValue("[1,2,1,2,3]", int[].class);
       		k = 2;
       		System.out.println("Arr: " + Arrays.toString(testArr));
       		System.out.println("Ans: " + solObj.subarraysWithKDistinct(testArr, k));
       		System.out.println("correct Ans: " + correctSolObj.subarraysWithKDistinct(testArr, k));
    
       		/*
       		
            testArr = mapper.readValue("[1,3,2,3,3]", int[].class);
     		k = 2;
     		System.out.println("Arr: " + Arrays.toString(testArr));
     		System.out.println("Ans: " + solObj.subarraysWithKDistinct(testArr, k));
     		System.out.println("correct Ans: " + correctSolObj.subarraysWithKDistinct(testArr, k));
            
  
  
            
            testArr = mapper.readValue("[3,2,1,3]", int[].class);
       		k = 2;
       		System.out.println("Arr: " + Arrays.toString(testArr));
       		System.out.println("Ans: " + solObj.subarraysWithKDistinct(testArr, k));
       		System.out.println("correct Ans: " + correctSolObj.subarraysWithKDistinct(testArr, k));
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

class Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
    	int cntWithAtMostKDE = numOfSArrWithAtMostKDE(nums,k);
    	int cntWithAtMostKMinusOneDE = numOfSArrWithAtMostKDE(nums,k-1);
        return cntWithAtMostKDE - cntWithAtMostKMinusOneDE;
    }//end method
    
    /**
     * this method calculate number of good sub arrays that contains at most k distinct elements 
     * @param nums - int[], the number array
     * @param k - int, the threshold
     * @return int number of sub arrays
     */
    private int numOfSArrWithAtMostKDE(int[] nums, int k) {
    	//special case: k=0
    	if (k==0) {
    		return 0;
    	}//fi
    	int arrCnt = 0;
    	//map< number, frequency count>
    	Map<Integer, Integer> numCntMap = new HashMap<>();
    	Integer cntVal;
    	for (int lInx = 0, rInx = 0;
    			rInx < nums.length;
    			rInx++
    			) {
    		numCntMap.put(nums[rInx], numCntMap.getOrDefault(nums[rInx], 0)+1);
    		
    		while (numCntMap.size()>k) {//process lInx
        		if ((cntVal = numCntMap.get(nums[lInx]))==1) {
        			numCntMap.remove(nums[lInx]);
        		} else {
        			numCntMap.put(nums[lInx], cntVal-1);
        		}//f        		
        		lInx++;
        	}//end while
    		
    		arrCnt += rInx - lInx + 1;  		
    	}//rof
    	
    	
    	return arrCnt;
    }//end method
}//end class

class CorrectSolution992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }
    
    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1; // Size of subarray
            right++;
        }
        
        return ans;
    }
}