package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1266{


	static void test() {
		
		int[][] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[[1,1],[3,4],[-1,0]]", int[][].class);

            arr2 = objectMapper.readValue("[[3,2],[-2,2]]", int[][].class);
            
            arr3 = objectMapper.readValue("[[1,1],[3,4],[-1,0]]", int[][].class);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1266 solObj  = new Solution1266();
		int[][] arr;
		
		
		
		arr = arr1;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minTimeToVisitAllPoints(arr));
		
		arr = arr2;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minTimeToVisitAllPoints(arr));
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1266{
	public int minTimeToVisitAllPoints(int[][] points) {
		int totalTime = 0;
		int rise, run;
		for (int i=1; i<points.length; i++) {
			run = Math.abs(points[i][0]-points[i-1][0]);
			rise = Math.abs(points[i][1]-points[i-1][1]);
			totalTime += Math.max(run, rise);
		}//rof
        return totalTime;
    }//end method
}// end class
