package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1438 {


	
	private static void test() {
		
		Solution1438 solObj = new Solution1438();
		int[] nums;
		int limit ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            /*
          
    			//*/
            
            nums = mapper.readValue("[8,2,4,7]", int[].class);
            limit = 4;
    		System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("Ans: " + solObj.longestSubarray(nums, limit ));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
    	int longestSbLength = 1;
    	int sbLength;
    	TreeMap<Integer, Integer> numCntMap = new TreeMap<>();
    	numCntMap.put(nums[0], 1);
    	Integer cnt;
    	int currMax = nums[0];
    	int currMin = nums[0];
    	int leftInx = 0;
    	for (int rightInx=1; rightInx<nums.length; rightInx++) {
    		cnt = numCntMap.get(nums[rightInx]);
    		if (cnt == null) {
    			numCntMap.put(nums[rightInx], 1);
    		} else {
    			numCntMap.put(nums[rightInx], cnt+1);
    		}//fi    	
    		
    		if (currMax < nums[rightInx]) {
    			currMax = nums[rightInx];
    		} else if (currMin > nums[rightInx]){
    			currMin = nums[rightInx];
    		}//fi
    		
    		while (currMax - currMin > limit) {
    			cnt = numCntMap.get(nums[leftInx]);
    			if (cnt > 1) {
    				numCntMap.put(nums[leftInx], cnt-1);    				
    			} else {
    				numCntMap.remove(nums[leftInx]);
    				if (currMin == nums[leftInx]) {
    					currMin = numCntMap.firstKey();
    				} else if (currMax == nums[leftInx]) {
    					currMax = numCntMap.lastKey();
    				}//fi
    			}//fi    			
    			leftInx++;
    		}//end while
    		
    		sbLength = rightInx - leftInx + 1;
			if (longestSbLength < sbLength) {
				longestSbLength = sbLength;
				//System.out.println("longestSbLength updated " + leftInx + ":" + rightInx + " min max: " + currMin + ":" + currMax);
			}//fi
    	}//rof
        return longestSbLength;
    }//end method
}//end class
