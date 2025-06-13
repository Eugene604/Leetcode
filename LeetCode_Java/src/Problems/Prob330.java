package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob330 {


	
	private static void test() {
		
		Solution330 solObj = new Solution330();
		int[] testArr;
		int n;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            /*
            testArr = mapper.readValue("[1,3]", int[].class);
    		n = 2;
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("n: " + n);
    		System.out.println("Ans: " + solObj.minPatches(testArr, n));
    		
    		            testArr = mapper.readValue("[1,3,5,7,9,11,222,333,4444,5555]", int[].class);
    		n = 552234342;//ans: 22
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("n: " + n);
    		System.out.println("Ans: " + solObj.minPatches(testArr, n));
            
    			//*/
            

    		
            testArr = mapper.readValue("[1,7]", int[].class);
    		n = 2147483647; //30
    		System.out.println("Arr: " + Arrays.toString(testArr));
    		System.out.println("n: " + n);
    		System.out.println("Ans: " + solObj.minPatches(testArr, n));
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution330 {
    public int minPatches(int[] nums, int n) {
    	int patchCnt = 0;
    	int achievedNum = 0;
    	int inx = 0;
    	while (achievedNum < n && inx<nums.length) {
    		//System.out.println("achievedNum: " + achievedNum);
    		if (nums[inx] <= achievedNum+1) {
    			achievedNum += nums[inx];
    			inx++;
    		} else {
    			achievedNum = achievedNum + achievedNum + 1;
    			patchCnt++;
    		}//fi
    	}//end while
    	
    	while (achievedNum < n && achievedNum > 0) {
   			achievedNum = achievedNum + achievedNum + 1;
   			patchCnt++;
    	}//end while
    	
        return patchCnt;
    }//end method
}//end class
