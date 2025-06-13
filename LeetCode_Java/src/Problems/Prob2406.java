package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2406 {


	static void test() {
		

		Solution2406 solObj = new Solution2406();
		
		int[][] times;
		int targetFriend;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            times = mapper.readValue("[[5,10],[6,8],[1,5],[2,3],[1,10]]", new TypeReference<int[][]>() {});
            targetFriend = 1;

    		MatrixUtils.displayMatrix(times);
    		System.out.println(); 
    		System.out.println("ans: " + solObj.minGroups(times));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution2406 {
    public int minGroups(int[][] intervals) {
    	PriorityQueue<Integer> startTQueue = new PriorityQueue<>((t1, t2) -> t1-t2); 
    	PriorityQueue<Integer> endTQueue = new PriorityQueue<>((t1, t2) -> t1-t2); 
    	
    	for (int[] interval:intervals) {
    		startTQueue.offer(interval[0]);
    		endTQueue.offer(interval[1]);    		
    	}//rof
    	
    	int maxOverlap = 0;
    	int currOverlap = 0;
    	
    	while (startTQueue.size() > 0) {
    		if (startTQueue.peek() <= endTQueue.peek()) {
    			currOverlap++;
    			maxOverlap = Math.max(maxOverlap, currOverlap);
    			startTQueue.poll();
    		} else {    			
    			currOverlap--;
    			endTQueue.poll();
    		}//fi
    	}//end while
    	//System.out.println("start T:" + startTQueue.peek());
    	
    	return maxOverlap;
    }//end method
    
}// end class
