package Problems;

import java.util.*;

public class Prob523 {
	
	
	private static void test() {
		int[] testArr;
		Solution523 solObj = new Solution523();
		int k;
		
		/*
		
		
		

		testArr = new int[] {23,2,4,6,7};
		k = 6;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.checkSubarraySum(testArr,k));
		
		
		testArr = new int[] {1,2,3,13,1};
		k = 13;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.checkSubarraySum(testArr,k));
		//*/

		testArr = new int[] {1,2,3};
		k = 5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.checkSubarraySum(testArr,k));
	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution523 {

    public boolean checkSubarraySum(int[] nums, int k) {
    	int lastInx = nums.length-1;
    	int currSum = nums[0];    
    	int currRemainder = currSum%k;
    	int prevRemainder = currRemainder;
    	Set<Integer> pRemainderSet = new HashSet<>(); 
    	pRemainderSet.add(0);
    	for (int i=1; i<=lastInx; i++ ) {
    		currSum+=nums[i];
    		currRemainder = currSum%k;
    		if (pRemainderSet.contains(currRemainder)) {
    			return true;
    		}//fi    		
    		pRemainderSet.add(prevRemainder);//add the one before previous index to avoid situation where current num = multiple of k
    		prevRemainder = currRemainder;
    	}//rof
    	return false;
    }//end method   
}//end class



class Solution523_v3 {

    public boolean checkSubarraySum(int[] nums, int k) {
 
    	int currSum;
    	int rightInx;
    	for (int leftInx = 0; leftInx<nums.length-1; leftInx++) {
    		rightInx = leftInx+1;
    		currSum = nums[leftInx];
    		while (rightInx < nums.length) {
    			currSum += nums[rightInx];
        		if (currSum%k == 0) {
        			//System.out.println("return true 2");
        			return true;
        		}//fi
        		rightInx++;
    		}//end while
    	}//rof
        return false;
    }//end method   
}//end class


class Solution523_v2 {

    public boolean checkSubarraySum(int[] nums, int k) {
    	int initSum = nums[0];
    	int currSum;
    	int leftInx, rightInx;
    	for (int initEndInx = 1; initEndInx<nums.length; initEndInx++) {
    		initSum += nums[initEndInx];
    		currSum = initSum;
    		if (currSum%k == 0) {
    			//System.out.println("return true 1");
    			return true;
    		}//fi
    		leftInx = 1;
    		rightInx = initEndInx+1;	
    		while (rightInx < nums.length) {
    			currSum -= nums[leftInx-1];
    			currSum += nums[rightInx];
        		if (currSum%k == 0) {
        			//System.out.println("return true 2");
        			return true;
        		}//fi
        		leftInx++;
        		rightInx++;
    		}//end while
    	}//rof
        return false;
    }//end method   
}//end class