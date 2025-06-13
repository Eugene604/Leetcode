package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2402 {


	static void test() {
		
		String meetings1 = "[[0,10],[1,2],[12,14],[13,15]]";
		String meetings2 = "[[19,20],[14,15],[13,14],[11,20]]";
        
		Solution2402 solObj = new Solution2402();
		CorrectSolution2402 correctSolObj = new CorrectSolution2402();
		
		int[][] meetings;
		int n;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            meetings = mapper.readValue(meetings2, new TypeReference<int[][]>() {});
            n = 4;

    		MatrixUtils.displayMatrix(meetings);
    		System.out.println(); 
    		System.out.println("ans: " + solObj.mostBooked(n, meetings));
    		System.out.println("correct ans: " + correctSolObj.mostBooked(n, meetings));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
    	//special case: only 1 room
    	if (n==1) {
    		return 0;
    	}//fi
    	
    	//step 1, sort meetings according to its start time
    	Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
    	//MatrixUtils.displayMatrix(meetings);
    	//System.out.println();
    	
    	//step 2, setup variables, queues and all other data structs
    	int[] roomUsgCnt = new int[n];
    	//arr size 2, arr[0] = room ID, arr[1] = finish time of last meeting 
    	PriorityQueue<long[]> occupiedQueue = new PriorityQueue<>(
    			(arr1, arr2) -> {
    	            if (arr1[1] != arr2[1]) {
    	                return Long.compare(arr1[1], arr2[1]);
    	            } else {
    	                return Long.compare(arr1[0], arr2[0]);
    	            }
    	        }
    		); 
    	PriorityQueue<long[]> vacantQueue = new PriorityQueue<>(
    			(arr1, arr2) -> Long.compare(arr1[0], arr2[0])    	        
    		); 
    	for (int i=0; i<n; i++) {
    		vacantQueue.offer(new long[]{i, 0});   		                   
    	}//rof
    	
    	//step 3, iterate though each meeting
    	long[] availRoom;
    	for (int i=0; i<meetings.length; i++) {
    		while (!occupiedQueue.isEmpty() && (availRoom = occupiedQueue.peek())[1] <= meetings[i][0]) { //scan through occupied queue and see if there are vacant rooms
    			availRoom = occupiedQueue.poll();
    			vacantQueue.offer(availRoom);   		 
    		};
    		
    		if (!vacantQueue.isEmpty()) {//always get room from vacant queue first
    			availRoom = vacantQueue.poll();
        		availRoom[1] = meetings[i][1];
        		occupiedQueue.offer(availRoom);   
        		//System.out.println("get from vacant queue: " + Arrays.toString(availRoom));
        		roomUsgCnt[(int) availRoom[0]]++;    	
    		} else {//the room that will finish earliest is still busy
    			availRoom = occupiedQueue.poll();
    			availRoom[1] = availRoom[1] + meetings[i][1]-meetings[i][0];
    			occupiedQueue.offer(availRoom);   
        		//System.out.println("get from occupied queue: " + Arrays.toString(availRoom));
        		roomUsgCnt[(int) availRoom[0]]++; 
    		}//fi
   		
    	}//rof
    	
    	int busiestRoomID = 0;
    	for (int i=0; i<n; i++) {
    		if (roomUsgCnt[i] > roomUsgCnt[busiestRoomID]) {
    			busiestRoomID = i;
    		}//fi
    	}//rof
    	//System.out.println("roomUsgCnt: " + Arrays.toString(roomUsgCnt));
    	return busiestRoomID;
    }//end method
}// end class

class CorrectSolution2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));
        // {endTime, room}

        int[] roomCount = new int[n]; // number of meeting of the room
        int result = 0;

        for (int i = 0; i < n; i++)
            queue.add(new long[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0]; // new meeting start time

            while (queue.peek()[0] < time) // order all available room by room index
                queue.add(new long[] { time, queue.poll()[1] });

            long[] current = queue.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]); // current room endTime + this meeting time
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) // update result
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            queue.add(new long[] { meetingEndTime, curRoom });
        }
        System.out.println("roomCount: " + Arrays.toString(roomCount));
        return result;
    }
}


