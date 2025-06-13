package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob621 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		String tasks1 = "[\"A\",\"A\",\"A\",\"A\",\"A\",\"A\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"B\",\"C\",\"C\",\"C\",\"C\",\"C\",\"C\",\"C\",\"F\",\"F\",\"F\",\"F\",\"F\",\"F\",\"F\",\"F\",\"F\",\"G\",\"G\",\"G\",\"G\",\"G\",\"G\",\"G\",\"G\",\"G\",\"G\",\"H\",\"H\",\"H\",\"H\",\"H\",\"H\",\"J\",\"J\",\"J\",\"J\",\"J\",\"J\",\"J\"]";

				
				
		Solution621 solObj = new Solution621();
		CorrectSolution621 correctSolObj = new CorrectSolution621();
		char[] tasks;
		int n;
		
		ObjectMapper objectMapper = new ObjectMapper();

		tasks = objectMapper.readValue(tasks1, new TypeReference<char[]>() {});
		n=5;
		System.out.println(Arrays.toString(tasks));
		System.out.println("ans: " + solObj.leastInterval(tasks, n));
		System.out.println("correct ans: " + correctSolObj.leastInterval(tasks, n));
		
       
	}//end method

	public static void main(String[] args) {
		try {
			test();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Solution621 {

	public int leastInterval(char[] tasks, int n) {
		//special case, n is 0
		if (n==0) {
			return tasks.length;
		}//fi
		
		//step 1, populate their frequencies 
		int[] cntArr = new int[91];
		for (char task:tasks) {
			cntArr[task]++;
		}//rof
		
		//step 2, sort task frequencies
		Arrays.sort(cntArr);
		//System.out.println(Arrays.toString(cntArr));
		
		//step 3, find count index where frequency is second highest
		int secondMostFreqTaskInx = 90;
		while (cntArr[secondMostFreqTaskInx] == cntArr[90]) {
			secondMostFreqTaskInx--;			
		}//rof
						
		//step 4, the area between second most frequent index and 90-n is the known idle amount
		int idleAmount = (secondMostFreqTaskInx - (90-n) + 1)*(cntArr[90]-1);
		
		for (int i=secondMostFreqTaskInx; cntArr[i] != 0 && i >= 0 && idleAmount >= 0;i--) {
			idleAmount -= cntArr[i];
		}//rof
		
		//step 5, check remaining idle amount, if it's positive then the total time is idle amount + total number of task
		if (idleAmount <= 0) {
			return tasks.length;
		} else {
			return tasks.length + idleAmount;
		}//rof		
    }//end method
}// end class

class CorrectSolution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idle = chunk * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(chunk, freq[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}
