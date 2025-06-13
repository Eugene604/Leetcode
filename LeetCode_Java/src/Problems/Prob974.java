package Problems;

import java.util.*;

public class Prob974 {
	
	
	private static void test() {
		int[] testArr;
		Solution974 solObj = new Solution974();
		int k;
		
		/*
		
		testArr = new int[] {4,5,0,-2,-3,1};
		k = 5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.subarraysDivByK(testArr,k));		
		
		testArr = new int[] {-1,2,9};
		k = 2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.subarraysDivByK(testArr,k));

		testArr = new int[] {2,-2,2,-4};
		k = 6;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.subarraysDivByK(testArr,k));
	
		testArr = new int[] {-1,2,9};
		k = 2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.subarraysDivByK(testArr,k));
		//*/
		
		testArr = new int[] {-5,8};
		k = 3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.subarraysDivByK(testArr,k));
	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution974 {

	public int subarraysDivByK(int[] nums, int k) {
    	int saCnt;    	
    	Map<Integer, Integer> remainderCntMap = new HashMap<>();
    	int prevRemainder = nums[0]%k;
    	prevRemainder += (prevRemainder<0)? k : 0;
    	remainderCntMap.put(prevRemainder, 1);
    	saCnt = (prevRemainder==0)?1:0;
    	int currRemainder;
    	Integer remainderCnt;
    	for (int i=1; i<nums.length; i++ ) {
    		currRemainder = nums[i]%k;
    		currRemainder += (currRemainder<0)? k : 0;
    		currRemainder = (currRemainder+prevRemainder)%k;
    		if (currRemainder == 0) {
    			saCnt++;
    		}//rof
    		if ((remainderCnt=remainderCntMap.get(currRemainder))==null) {
    			remainderCntMap.put(currRemainder, 1);    			
    		} else {
    			saCnt += remainderCnt;
    			remainderCntMap.put(currRemainder, remainderCnt+1);
    		}//fi
    		prevRemainder = currRemainder;
    	}//rof
    	//System.out.println("pRemainderArr: " + Arrays.toString(pRemainderArr));
    	
    	
    	return saCnt;
    }//end method   
	
}//end class


class Solution974_v2 {

	public int subarraysDivByK(int[] nums, int k) {
    	int saCnt;    	
    	int[] pRemainderArr = new int[nums.length];    	
    	pRemainderArr[0] = nums[0]%k;
    	pRemainderArr[0] += (pRemainderArr[0]<0)? k : 0;
    	saCnt = (pRemainderArr[0]==0)?1:0;
    	for (int i=1; i<nums.length; i++ ) {
    		pRemainderArr[i] = nums[i]%k;
    		pRemainderArr[i] += (pRemainderArr[i]<0)? k : 0;
    		pRemainderArr[i] = (pRemainderArr[i]+pRemainderArr[i-1])%k;
    		if (pRemainderArr[i] == 0) {
    			saCnt++;
    		}//rof
    	}//rof
    	//System.out.println("pRemainderArr: " + Arrays.toString(pRemainderArr));
    	
    	for (int leftInx=0; leftInx<nums.length-1; leftInx++ ) {
    		for (int rightInx=leftInx+1; rightInx<nums.length; rightInx++ ) {
        		if (pRemainderArr[leftInx]==pRemainderArr[rightInx]) {
        			saCnt++;
        		}//fi 
    		}//rof
    	}//rof
    	
    	return saCnt;
    }//end method   
	
}//end class


