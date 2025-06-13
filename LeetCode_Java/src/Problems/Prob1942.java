package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1942 {


	static void test() {
		

		Solution1942 solObj = new Solution1942();
		
		int[][] times;
		int targetFriend;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            times = mapper.readValue(" [[1,4],[2,3],[4,6]]", new TypeReference<int[][]>() {});
            targetFriend = 1;

    		MatrixUtils.displayMatrix(times);
    		System.out.println(); 
    		System.out.println("ans: " + solObj.smallestChair(times, targetFriend));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
    	
    	int targetFriendArrivalTime = times[targetFriend][0];
    	
    	//step 1, sort coming time according to its start time
    	Arrays.sort(times,(a,b)->(a[0]-b[0]));

    	//step 2, setup variables, queues and all other data structs
    	//arr size 2, arr[0] = chair ID, arr[1] = chair finish time 
    	PriorityQueue<int[]> occupiedQueue = new PriorityQueue<>(
    			(arr1, arr2) -> {
    	            if (arr1[1] != arr2[1]) {
    	                return Integer.compare(arr1[1], arr2[1]);
    	            } else {
    	                return Integer.compare(arr1[0], arr2[0]);
    	            }
    	        }
    		); 
    	
    	PriorityQueue<int[]> vacantQueue = new PriorityQueue<>(
    			(chairID1, chairID2) -> Integer.compare(chairID1[0], chairID2[0])  	        
    		); 
    	
    	//step 3, iterate though each friend
    	int nextAvailChairID = 0;
    	int[] availChair;
    	for (int[] time:times) {
    		while (!occupiedQueue.isEmpty() && (availChair = occupiedQueue.peek())[1] <= time[0]) { //scan through occupied queue and see if there are vacant rooms
    			availChair = occupiedQueue.poll();
    			vacantQueue.offer(availChair);   		 
    		};
    		
    		if (!vacantQueue.isEmpty()) {//always get chair from vacant queue first
    			availChair = vacantQueue.poll();
    		} else {//no more chair
    			availChair = new int[] {nextAvailChairID, 0}; 
    			nextAvailChairID++;
    		}//fi
    		
    		if (time[0] == targetFriendArrivalTime) {
    			return availChair[0];
    		} else {
    			availChair[1] = time[1];
        		occupiedQueue.offer(availChair);    			
    		}//fi
    		 
   		
    	}//rof

    	
    	return 0;
    }//end method

}// end class
