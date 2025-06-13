package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob713 {


	
	private static void test() {
		
		Solution713 solObj = new Solution713();
		int[] testArr;
		int k;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            
            testArr = mapper.readValue("[10,5,2,6]", int[].class);
    		k = 100;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("Ans: " + solObj.numSubarrayProductLessThanK(testArr, k));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution713 {
	//index = number of array length, value = number of contiguous sub arrays 
	private static final int[] SUBARR_CNT_MAP;
	static {
		SUBARR_CNT_MAP = new int[30001];		
		for (int i=1; i<=30000; i++) {
			SUBARR_CNT_MAP[i] = SUBARR_CNT_MAP[i-1] + i;
		}//rof
	}
		
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		//special case, number array length 1
		if (nums.length == 1) {
			if (nums[0]<k) {
				return 1;
			} else {
				return 0;
			}//fi
		}//fi */
		
		int subArrCnt = 0;
		//int lInx = -1, rInx = 0; //sliding window's left index and right index
		int prevRInx = -1; //previous window's right index
		int winProd = 1, tmpProd; // product of current window				 
		int overlapLength;
		
		/*
		 * algorithm: 
		 * - always try find max contiguous sub array length before jumping into sub array counting
		 * - outer loop shift left index and see if window product < k, keep shift left index if window product is >= k
		 * - inner loop try shift right index
		 */
		
		for (int lInx = 0, rInx = 0;
				lInx < nums.length && rInx < nums.length-1; lInx++) {
			
			if (lInx >= rInx) {//initial case or window has become a line and then left index has shifted
				rInx = lInx;
				winProd = nums[lInx];
			} else {
				winProd /= nums[lInx-1]; //impossible to get here when lInx == 0
			}//fi
			
			if (winProd >= k) {//current window still too big, need to further contract from left 
				continue;
			}//fi
			
			//inner loop try shift right index
			tmpProd = winProd;
			while (rInx < nums.length-1 && (tmpProd = winProd * nums[rInx+1])<k) {
				rInx += 1;
				winProd = tmpProd;
			}//end while
			//System.out.println("counting, lInx:" + lInx + " rInx:" + rInx );
			subArrCnt += SUBARR_CNT_MAP[rInx - lInx + 1];					
			if ((overlapLength = prevRInx - lInx + 1)>0) {
				subArrCnt -= SUBARR_CNT_MAP[overlapLength];
			}//fi	
			prevRInx = rInx;
		}//rof
						

        return subArrCnt;
    }//end method
}//end class
