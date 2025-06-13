package Problems;

import java.util.*;

import Utils.MatrixUtils;


public class Prob1335 {
	static int[] nums0 = {6,5,4,3,2,1};
	static int[] nums1 = {9,9,9};
	static int[] nums2 = {1,1,1};	
	static int[] nums3 = {1,2,3};
	static int[] nums4 = {4,1,9,2};
	static int[] nums5 = {0,0,0,0};	

	

	
	private static void test() {
		int[] testArr;
		Solution1335 solObj = new Solution1335();
		Solution1335_v2 correctSol = new Solution1335_v2();
		int d;
		
		testArr = nums0;
		d = 2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minDifficulty(testArr, d));
		System.out.println("Ans: " + solObj.minDifficulty(testArr, d));	
		
		testArr = nums1;
		d = 4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minDifficulty(testArr, d));		
		System.out.println("Ans: " + solObj.minDifficulty(testArr, d));	
	//*/
		
		testArr = nums5;
		d = 3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minDifficulty(testArr, d));	
		System.out.println("Correct Ans: " + correctSol.minDifficulty(testArr, d));
		
	


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1335 {

	private int[] jobDiffArr;
	private int[][] diffCache;
	
    public int minDifficulty(int[] jobDifficulty, int d) {
    	jobDiffArr = jobDifficulty;
    	diffCache = new int[jobDiffArr.length][d+1];    	
    	int mostDiffJob = Integer.MIN_VALUE;
    	

    	for (int jobInx=0; jobInx < jobDiffArr.length; jobInx++) {
    		mostDiffJob = Math.max(mostDiffJob, jobDiffArr[jobInx]);
    		diffCache[jobInx][1] = mostDiffJob;  
    	}//rof
    	if (mostDiffJob == 0) {
    		return 0;
    	}//fi
    	
        getMinDiff(jobDiffArr.length-1, d);
        //MatrixUtils.displayMatrix(diffCache);
        return getMinDiff(jobDiffArr.length-1, d);
    }//end method
    
    /**
     * get minimum difficulty job given job index and days left
     * precondition:
     * job index and days left are valid numbers
     * @param jobInx - int, job index
     * @param d - int, days left
     * @return minimum difficulty, -1 if impossible
     */
    private int getMinDiff(int jobInx, int d) {
    	//System.out.println("getMinDiff: " + jobInx + " : " + d);
    	if (diffCache[jobInx][d] != 0) {
    		return diffCache[jobInx][d];
    	}//fi
    	
    	//base case: d > jobInx + 1 
    	if (d > jobInx+1 ) {
    		diffCache[jobInx][d] = -1;
    		return diffCache[jobInx][d];
    	}//rif
    	
    	int currDiff, minDiff = Integer.MAX_VALUE;
    	int mostDiffJob = Integer.MIN_VALUE;
    	for (int prevDayJobInx=jobInx-1; prevDayJobInx >= d-2; prevDayJobInx-- ) {
    		currDiff = getMinDiff(prevDayJobInx, d-1);
    		//System.out.println("jobInx: " + jobInx + " prevDayJobInx: " + prevDayJobInx + " d: " + d + " currDiff: " + currDiff);
    		if (currDiff == -1) {
    			break;
    		}//fi    		
    		mostDiffJob = Math.max(mostDiffJob, jobDiffArr[prevDayJobInx+1]);
    		currDiff += mostDiffJob; 
    		minDiff = Math.min(currDiff, minDiff);
    		//System.out.println("jobInx: " + jobInx + " prevDayJobInx: " + prevDayJobInx + " d: " + d + " currDiff: " + currDiff);
    	}//rof
    	
    	diffCache[jobInx][d] = minDiff;
    	return minDiff;
    }//end method
    
 
}//end class


class Solution1335_v2 {
	
	private static final int JOB_INX_SHIFT = 9; 
	
	private Map<Integer, Integer> maxDiffMap;
	private int[] jobDiffArr;
	private Integer[][] diffCache;
	
    public int minDifficulty(int[] jobDifficulty, int d) {
    	jobDiffArr = jobDifficulty;
    	diffCache = new Integer[jobDiffArr.length][d+1];
    	maxDiffMap = new HashMap<>(jobDiffArr.length*2);
    	
    	for (int jobInx=0; jobInx < jobDiffArr.length; jobInx++) {
    		diffCache[jobInx][1] = getMostDiffJob(0,jobInx);    		
    	}//rof
    	
        getMinDiff(jobDiffArr.length-1, d);
        //MatrixUtils.displayMatrix(diffCache);
        return getMinDiff(jobDiffArr.length-1, d);
    }//end method
    
    private int getMinDiff(int jobInx, int d) {
    	//System.out.println("getMinDiff: " + jobInx + " : " + d);
    	if (diffCache[jobInx][d] != null) {
    		return diffCache[jobInx][d];
    	}//fi
    	
    	//base case: d > jobInx + 1 
    	if (d > jobInx+1 ) {
    		diffCache[jobInx][d] = -1;
    		return diffCache[jobInx][d];
    	}//rif
    	
    	int currDiff, minDiff = Integer.MAX_VALUE;
    	for (int prevDayJobInx=d-2; prevDayJobInx < jobInx; prevDayJobInx++ ) {
    		currDiff = getMinDiff(prevDayJobInx, d-1);
    		//System.out.println("jobInx: " + jobInx + " prevDayJobInx: " + prevDayJobInx + " d: " + d + " currDiff: " + currDiff);
    		if (currDiff == -1) {
    			continue;
    		}//fi    		
    		currDiff += getMostDiffJob(prevDayJobInx+1, jobInx); 
    		minDiff = Math.min(currDiff, minDiff);
    		//System.out.println("jobInx: " + jobInx + " prevDayJobInx: " + prevDayJobInx + " d: " + d + " currDiff: " + currDiff);
    	}//rof
    	
    	diffCache[jobInx][d] = minDiff;
    	return minDiff;
    }//end method
    
    /**
     * get the most difficult job given job index range
     * precondition:
     * - It is assumed that range indices are valid. This method does NOT check for index validity
     * @param startJobInx - int
     * @param endJobInx - int
     * @return int, the highest job difficulty within specified range
     */
    private int getMostDiffJob(int startJobInx, int endJobInx) {
    	
    	Integer jobRangeKey = (endJobInx << JOB_INX_SHIFT) + startJobInx;    	
    	Integer diff;		
    	if ((diff=maxDiffMap.get(jobRangeKey)) != null) {
    		return diff;
    	}//fi
    	
    	int maxDiff;
    	//base case
    	if (startJobInx == endJobInx) {
    		maxDiff = jobDiffArr[endJobInx];
    	} else {
    		maxDiff = Math.max(jobDiffArr[endJobInx], getMostDiffJob(startJobInx, endJobInx-1));
    	}//fi

    	maxDiffMap.put(jobRangeKey, maxDiff);
    	return maxDiff;
    }//end method
}//end class