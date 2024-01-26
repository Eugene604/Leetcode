package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob198 {
	

	
	public static void test() {

		Solution198 sol = new Solution198();
		
		int[] hs1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] hs2 = {1,2,3,1};
		int[] hs3 = {2,7,9,3,1};
		
		System.out.println("ans: " + sol.rob(hs1));
		/*
		System.out.println("ans: " + sol.rob(hs2));
		System.out.println("ans: " + sol.rob(hs3));
		*/
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution198 {
	//maximum amount of illicit money you can get if you rob from there
	static int[] maxBoodleCache = new int[101];
    public int rob(int[] nums) {
    	Arrays.fill(maxBoodleCache, 0, nums.length, -1);
    	int totalIllicitMoney = tryRob(nums, 0);
    	if (nums.length>1) {
    	  	totalIllicitMoney = Math.max(totalIllicitMoney, tryRob(nums, 1));
    	}//fi
        return totalIllicitMoney;
    }//end method
    
    /**
     * recursively find boodle money
     * 
     * @param nums - int[], the bank amount array
     * @param inx - int, the bank in index that is decided to be robbed 
     * @return - amount of max illicit money if rob current bank and then the max possible combination of subsequent banks
     */
    private int tryRob(int[] nums, int inx) {
    	//base case 1, found in cache
    	if (maxBoodleCache[inx] != -1) {
    		return maxBoodleCache[inx];
    	}//fi
    	
    	//base case 2, inx is last or second last index
    	if (inx > nums.length-3) {
    		maxBoodleCache[inx] = nums[inx];
    		return maxBoodleCache[inx];
    	}//fi
    	
    	//base case 3, inx is third last index
    	if (inx == nums.length-3) {
    		maxBoodleCache[inx] = nums[inx] + nums[inx+2];
    		return maxBoodleCache[inx];
    	}//fi
    	
    	maxBoodleCache[inx] = nums[inx];    	
    	maxBoodleCache[inx] += Math.max(tryRob(nums, inx+2),tryRob(nums, inx+3));
    	return maxBoodleCache[inx];
    }//end method
    
}//end class
