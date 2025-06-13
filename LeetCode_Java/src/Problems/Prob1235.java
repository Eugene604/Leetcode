package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob1235 {

	static String startTimeStr1, endTimeStr1, profitStr1;
	static String startTimeStr2, endTimeStr2, profitStr2;

	static void test() {
		CorrectSolution1235 correctSolObj = new CorrectSolution1235();
		Solution1235 solObj = new Solution1235();
		int[] startTime, endTime, profit;
		Path filePath = Paths.get("./TestFiles/Prob1235.dat");
		try {
			List<String> lines = Files.readAllLines(filePath);

			for (int i = 0; i < lines.size(); i++) {
				if (!lines.get(i).equalsIgnoreCase("test_str_data_begin")) {
					continue;
				} // fi
				Field field = Prob1235.class.getDeclaredField(lines.get(i + 1));
				field.set(null, lines.get(i + 2));

			} // rof
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end try catch

		try {
			ObjectMapper mapper = new ObjectMapper();
			/*
			startTime = mapper.readValue("[1,2,3,3]", int[].class);
			endTime = mapper.readValue("[3,4,5,6]", int[].class);
			profit = mapper.readValue("[50,10,40,70]", int[].class);
			System.out.println("Ans: " + solObj.jobScheduling(startTime, endTime, profit));
			System.out.println();
			System.out.println("Correct Ans: " + correctSolObj.jobScheduling(startTime, endTime, profit));
			
			
			
			
			startTime = mapper.readValue("[1,1,1]", int[].class);
			endTime = mapper.readValue("[2,3,4]", int[].class);
			profit = mapper.readValue("[5,6,4]", int[].class);
			System.out.println("Ans: " + solObj.jobScheduling(startTime, endTime, profit));
			

			startTime = mapper.readValue("[1,2,3,4,6]", int[].class);
			endTime = mapper.readValue("[3,5,10,6,9]", int[].class);
			profit = mapper.readValue("[20,20,100,70,60]", int[].class);
			System.out.println("Ans: " + solObj.jobScheduling(startTime, endTime, profit));
				
				
			
			
			startTime = mapper.readValue(startTimeStr2, int[].class);
			endTime = mapper.readValue(endTimeStr2, int[].class);
			profit = mapper.readValue(profitStr2, int[].class);
			System.out.println("Ans: " + solObj.jobScheduling(startTime, endTime, profit));
			System.out.println("Correct Ans: " + correctSolObj.jobScheduling(startTime, endTime, profit));
			//*/


			startTime = mapper.readValue(startTimeStr1, int[].class);
			endTime = mapper.readValue(endTimeStr1, int[].class);
			profit = mapper.readValue(profitStr1, int[].class);
			System.out.println("Ans: " + solObj.jobScheduling(startTime, endTime, profit));
			System.out.println();
			System.out.println("Correct Ans: " + correctSolObj.jobScheduling(startTime, endTime, profit));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1235 {

	private int[] maxProfitCache;
	private int[][] scheduleArr; 
	
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		// step 1, merge arrays and sort jobs according to start time
		/*
		 * outer array: list of jobs, each job is an array of 3 
		 * inner array: 0 - start time, 1 - end time, 2 - profit
		 */
		scheduleArr = new int[startTime.length][3];
		for (int i = 0; i < startTime.length; i++) {
			scheduleArr[i][0] = startTime[i];
			scheduleArr[i][1] = endTime[i];
			scheduleArr[i][2] = profit[i];
		} // rof
		Arrays.sort(scheduleArr, (a, b) -> Integer.compare(a[0], b[0]));

		// MatrixUtils.displayMatrix(scheduleArr);
		// step 2, find max profit by using recursive search
		maxProfitCache = new int[scheduleArr.length];
		maxProfitCache[scheduleArr.length-1] = scheduleArr[scheduleArr.length-1][2];



		int maxProfit = findMaxProfit(0);	
		return maxProfit;
	}// end method

	/**
	 * recursively find maximum profit 
	 * precondition: 
	 * - assume maxProfitCache is available and valid
	 * - assume scheduleArr is available and valid 
	 * scheduleArr - int[][], job schedule array
	 * @param currJobInx  - int, current job index
	 * @return int, the max possible profit starting from currJobInx
	 */
	private int findMaxProfit(int currJobInx) {

		if (maxProfitCache[currJobInx] != 0) {
			return maxProfitCache[currJobInx];
		} // fi
		
		/*
		//this shouldn't happen because already added last entry to the cache 	
		if (currJobInx == scheduleArr.length-1) {	//base case 1, this job is the last job
			maxProfitCache[currJobInx] = scheduleArr[currJobInx][2];
			return maxProfitCache[currJobInx];
		} // fi */

		int nextJobInx = searchNextImmediateJob(currJobInx);

		int totalProfitWithSelf;
		if (nextJobInx == -1) {	//base case 1, this job is the last job should u choose doing this job
			totalProfitWithSelf = scheduleArr[currJobInx][2];
		} else {
			totalProfitWithSelf = scheduleArr[currJobInx][2] + findMaxProfit(nextJobInx);
		}// fi
		
		int totalProfitWithoutSelf = findMaxProfit(currJobInx+1);
		//System.out.println("currJobInx: " + currJobInx + " nextJobInx: " + nextJobInx + " withSelf vs withoutSelf: " + totalProfitWithSelf + " : " + totalProfitWithoutSelf);
		maxProfitCache[currJobInx] = Math.max(totalProfitWithoutSelf, totalProfitWithSelf);
		return maxProfitCache[currJobInx];
	}// end method

	/**
	 * search next immediate job that can be performed after current job is done
	 * precondition: 
	 * - assume scheduleArr is available and valid 
	 * scheduleArr - int[][], job schedule array
	 * 
	 * @param currJobInx  - int, current job index
	 * @return int, index of the first doable job after current job is done.
	 *         -1 if arrived end of job arr
	 */
	private int searchNextImmediateJob(int currJobInx) {
		// System.out.println("searchNextImmediateJob: " + currJobInx);
		// base case 1, job index is the last job
		if (currJobInx == scheduleArr.length - 1) {
			return -1;
		} // fi

		// base case 2, no more job can be performed after current job, current job index is the last possible job
		if (scheduleArr[currJobInx][1] > scheduleArr[scheduleArr.length - 1][0]) {
			return -1;
		} // fi

		// base case 3, job at next index has start time equal or later than current job's end time, just return it
		if (scheduleArr[currJobInx][1] <= scheduleArr[currJobInx + 1][0]) {
			return currJobInx + 1;
		} // fi

		int leftInx = currJobInx + 1;
		int rightInx = scheduleArr.length - 1;
		int midInx;
		while (leftInx < rightInx) {
			midInx = (leftInx + rightInx) / 2;
			if (scheduleArr[midInx][0] >= scheduleArr[currJobInx][1]) {
				rightInx = midInx;
			} else if (scheduleArr[midInx][0] < scheduleArr[currJobInx][1]) {
				leftInx = midInx+1;
			} // fi
		} // end while
		/*
		System.out.println("returned right, curr inx " + currJobInx + ":" + Arrays.toString(scheduleArr[currJobInx]));
		System.out.println("leftInx -1 content: "  + (leftInx-1) + ":" +  Arrays.toString(scheduleArr[leftInx-1]));
		System.out.println("leftInx content: "  + leftInx + ":" +  Arrays.toString(scheduleArr[leftInx]));
		System.out.println("right inx content: "  + rightInx + ":" +  Arrays.toString(scheduleArr[rightInx])); //*/
		return leftInx;
	}// end method
	
}// end class


class CorrectSolution1235 {
	class JobItem implements Comparable<JobItem> {
	    int startTime, endTime, profit;

	    JobItem(int startTime, int endTime, int profit) {
	        this.startTime = startTime;
	        this.endTime = endTime;
	        this.profit = profit;
	    }

	    public int compareTo(JobItem next) {
	        return this.startTime - next.startTime;
	    }

	    public String toString() {
	        return this.startTime + " -> " + this.endTime + " | " + this.profit;
	    }
	}


    private Integer dp[];
    private int getMaxProfitCnt;
    private int dpHitCnt;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        dp = new Integer[startTime.length];

        JobItem jobs[] = new JobItem[startTime.length];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new JobItem(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs);
        getMaxProfitCnt = 0;
        dpHitCnt = 0;
        int totalProfit = getMaxProfit(jobs, 0);
        System.out.println("getMaxProfitCnt: " + getMaxProfitCnt);
        System.out.println("dpHitCnt: " + dpHitCnt);
        return totalProfit;
    }

    private int getMaxProfit(JobItem[] jobs, int curIdx) {
        if (curIdx >= jobs.length) {        	
            return 0;
        }
        
        if (dp[curIdx] != null) {
        	dpHitCnt++;
            return dp[curIdx];
        }
        
        int profitIfNotIncluded = getMaxProfit(jobs, curIdx + 1);
        int nextPossibleIndex = findNextPossibleIndex(jobs, curIdx);
        int profitIfIncluded = jobs[curIdx].profit + getMaxProfit(jobs, nextPossibleIndex);
        getMaxProfitCnt++;
        return dp[curIdx] = Math.max(profitIfIncluded, profitIfNotIncluded);
    }

    private int findNextPossibleIndex(JobItem[] jobs, int curIdx) {
        int lastJobEndTime = jobs[curIdx].endTime;

        int start = curIdx + 1, end = jobs.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (jobs[mid].startTime < lastJobEndTime) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }


}


