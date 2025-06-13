package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2962 {


	
	private static void test() {
		
		Solution2962 solObj = new Solution2962();
		
		CorrectSolution2962 correctSolObj = new CorrectSolution2962();

		int[] testArr;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            testArr = mapper.readValue("[2,9,9,6]", int[].class);
       		k = 1;
       		System.out.println("Arr: " + Arrays.toString(testArr));
       		System.out.println("Ans: " + solObj.countSubarrays(testArr, k));
       		System.out.println("correct Ans: " + correctSolObj.countSubarrays(testArr, k));
    
       		
       		
            testArr = mapper.readValue("[1,3,2,3,3]", int[].class);
     		k = 2;
     		System.out.println("Arr: " + Arrays.toString(testArr));
     		System.out.println("Ans: " + solObj.countSubarrays(testArr, k));
     		System.out.println("correct Ans: " + correctSolObj.countSubarrays(testArr, k));
            
  
  
            
            testArr = mapper.readValue("[3,2,1,3]", int[].class);
       		k = 2;
       		System.out.println("Arr: " + Arrays.toString(testArr));
       		System.out.println("Ans: " + solObj.countSubarrays(testArr, k));
       		System.out.println("correct Ans: " + correctSolObj.countSubarrays(testArr, k));
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

class Solution2962 {
	//index = number of array length, value = number of contiguous sub arrays 
	private static final long[] SUBARR_CNT_MAP;
	static {
		SUBARR_CNT_MAP = new long[100001];		
		for (int i=1; i<=100000; i++) {
			SUBARR_CNT_MAP[i] = SUBARR_CNT_MAP[i-1] + i;
		}//rof
	}//end static
	
	public long countSubarrays(int[] nums, int k) {
		//step 1, find max element:
		int maxVal = -1;
		for (int num:nums) {
			if (num > maxVal) {
				maxVal = num;
			}//fi
		}//rof
       
        
        //step 2, use sliding window to find sub arrays less than k
        long subArrCnt = 0;
        Deque<Integer> inxQueue = new ArrayDeque<>();
        int overlapLength;
        int tmpCnt;

        
        for (int lInx=0, 
        		rInx=0,
        		freqCnt=0,
        		prevWndRInx = -1 
        		; 
        		lInx < nums.length
        		; 
        		freqCnt -= (nums[lInx]==maxVal)?1:0, 
        		lInx++
        				) {
        	
        	if (lInx >= rInx) {//initial case or window has become a line and then left index has shifted
				rInx = lInx;
				freqCnt = (nums[lInx]==maxVal)?1:0; 
			}//fi
        	
        	if (freqCnt>=k) {         		
        		continue;
        	}//fi
        	
        	
        	//System.out.println("\nleft part, lInx:" + lInx + " rInx:" + rInx  + " freqCnt:" + freqCnt);
        	
        	
        	//inner loop try shift right index
        	while (rInx < nums.length-1 && (tmpCnt = freqCnt + ((nums[rInx+1]==maxVal)?1:0))<k) {
        		freqCnt = tmpCnt;
        		rInx++;       	            
        	}//end while
        	
        	

        	subArrCnt += SUBARR_CNT_MAP[rInx - lInx + 1];
        	if ((overlapLength = prevWndRInx - lInx + 1)>0) {
				subArrCnt -= SUBARR_CNT_MAP[overlapLength];
			}//fi	
        	prevWndRInx = rInx;
        	//System.out.println("right part, lInx:" + lInx + " rInx:" + rInx  + " freqCnt:" + freqCnt + " num of sub arr: " + subArrCnt);
        }//rof */
        
    	return SUBARR_CNT_MAP[nums.length]-subArrCnt;
	}//end method
}//end class

class CorrectSolution2962 {
    public long countSubarrays(int[] nums, int k) {
        long maxNum = Long.MIN_VALUE, count = 0;
        long left = 0, right = 0, ans = 0;
        
        // Find the maximum element in the array
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        while (right < nums.length || left > right) {
            if (nums[(int)right] == maxNum) {
                count++;
            }
            // If count is greater than or equal to k, calculate subarrays count
            while (count >= k) {
                if (nums[(int)left] == maxNum) {
                    count--;
                }
                left++;
                ans += nums.length - right;
            }
            right++;
        }
        return ans;
    }
   
}