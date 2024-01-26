package Problems;

import java.util.*;

public class Prob1921 {
	static int[] nums0 = {1,3,4};
	static int[] nums1 = {1,1,1};
	
	static int[] nums2 = {1,1,2,3};	
	static int[] nums3 = {1,1,1,1};
	
	static int[] nums4 = {3,2,4};	
	static int[] nums5 = {5,3,2};
	
	static int[] nums6 = {3,5,7,4,5};		
	static int[] nums7 = {2,3,6,3,2};
	
	static int[] nums8 = {4,3,3,3,4};
	static int[] nums9 = {1,1,1,1,4};
	
	static int[] nums10 = {-2, -1};
	
	static int[] nums11 = {0, 9, 11, 15};
	
	static int[] nums12 = {0, 6, 7};
	
	static int[] nums13 = {1,3};
	static int[] nums14 = {2,7};
	
	static int[] nums15 = {10000};
	static int[] nums16 = {10001};
	
	static int[] nums17 = {3};
	static int[] nums18 = {1,2,4};
	
	private static void test(int[] testArr1, int[] testArr2) {
		int m;
		Solution1921 sol = new Solution1921();
		



		System.out.println("arr1: " + Arrays.toString(testArr1));
		System.out.println("arr2: " + Arrays.toString(testArr2));
		m = sol.eliminateMaximum(testArr1, testArr2);
		System.out.println("Asn: " + m);
		System.out.println("======================================");

	}//end method
	
	public static void main(String[] args) {
		/*
		test(nums0, nums1);
		test(nums2, nums3);
		test(nums4, nums5);
		test(nums6, nums7);
		//*/
		test(nums8, nums9);
	}//end method
}//end class

class Solution1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
    	int[] deadlineCountArr = new int[dist.length];
    	int destroyDeadline;
    	for (int i=0; i<dist.length; i++) {
    		destroyDeadline = (dist[i]-1)/speed[i];
    		if (destroyDeadline<dist.length) {
    			deadlineCountArr[destroyDeadline]++;
    		}//fi
    	}//rof
    	int roundAvailable=0;
    	int monKilled = 0;
    	for(int incomingMon:deadlineCountArr) {
    		roundAvailable++;
    		if (incomingMon>0) {
    			monKilled+=Math.min(roundAvailable, incomingMon);
    			roundAvailable -= incomingMon;
    		}//fi
    		if (roundAvailable<0) {
    			return monKilled;
    		}//fi
    	}//rof
    	return dist.length;
    }//end method
}//end class


class Solution1921_v1 {

    public int eliminateMaximum(int[] dist, int[] speed) {
    	int[] arrivalTimeArr = new int[dist.length];
    	for (int i=0; i<dist.length; i++) {
    		arrivalTimeArr[i]=dist[i]/speed[i];
    		if (dist[i]%speed[i]==0) {
    			arrivalTimeArr[i] -= 1;
    		}//fi
    	}//rof    	
    	Arrays.sort(arrivalTimeArr);
		System.err.println("arrivalTimeArr: " + Arrays.toString(arrivalTimeArr));
    	int numOfMonKilled;
    	for (numOfMonKilled=1; 
    			numOfMonKilled<arrivalTimeArr.length && arrivalTimeArr[numOfMonKilled]>=numOfMonKilled; 
    			numOfMonKilled++) {    		
    		System.err.println("numOfMonKilled: " + numOfMonKilled);
    	}//rof  
        return numOfMonKilled;
    }//end method
}//end class
