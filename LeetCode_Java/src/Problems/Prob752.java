package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob752 {

	public static void test() {

		Solution752 solObj = new Solution752();		
		
		String target;
		String[] deadends ;
		int ans;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            /*
            deadends = mapper.readValue("[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]", String[].class);
            target = "0202";
    		System.out.println("Arr: " + Arrays.toString(deadends));
    		System.out.println("Ans: " + solObj.openLock(deadends, target));
    		//*/
    		
            deadends = mapper.readValue("[\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"]", String[].class);
            target = "8888";
    		System.out.println("Arr: " + Arrays.toString(deadends));
    		System.out.println("Ans: " + solObj.openLock(deadends, target));
    		
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution752 {
	/*
	 * outer index : node ID, 0000~9999
	 * inner index (inner array): list of neighbor nodes' IDs
	 */
	private static final int[][] GRAPH;
	static {
		GRAPH = new int[10000][8];
		int tmp, remainder;
		for (int id = 0; id<10000; id++) {
			tmp = id;
			//check ones
			if ((remainder = tmp%10) == 0) {
				GRAPH[id][0] = id+1;
				GRAPH[id][4] = id+9;
			} else if (remainder == 9) {
				GRAPH[id][0] = id-9;
				GRAPH[id][4] = id-1;				
			} else {
				GRAPH[id][0] = id+1;
				GRAPH[id][4] = id-1;
			}//fi
			
			//check tens
			tmp = tmp-remainder;
			if ((remainder = tmp%100) == 0) {
				GRAPH[id][1] = id+10;
				GRAPH[id][5] = id+90;
			} else if (remainder == 90) {
				GRAPH[id][1] = id-90;
				GRAPH[id][5] = id-10;				
			} else {
				GRAPH[id][1] = id+10;
				GRAPH[id][5] = id-10;
			}//fi		
			
			//check hundreds
			tmp = tmp-remainder;
			if ((remainder = tmp%1000) == 0) {
				GRAPH[id][2] = id+100;
				GRAPH[id][6] = id+900;
			} else if (remainder == 900) {
				GRAPH[id][2] = id-900;
				GRAPH[id][6] = id-100;				
			} else {
				GRAPH[id][2] = id+100;
				GRAPH[id][6] = id-100;
			}//fi	
			
			//check thousands
			remainder = tmp-remainder;
			if (remainder == 0) {
				GRAPH[id][3] = id+1000;
				GRAPH[id][7] = id+9000;
			} else if (remainder == 9000) {
				GRAPH[id][3] = id-9000;
				GRAPH[id][7] = id-1000;				
			} else {
				GRAPH[id][3] = id+1000;
				GRAPH[id][7] = id-1000;
			}//fi	
		}//rof		
	}//end static
	
    public int openLock(String[] deadends, String target) {
    	//special case 1, target is 0000
    	if (target.contains("0000")) {
    		return 0;
    	}//fi
 
        //step 1, prepare variables and data structs for breadth first search
    	Deque<Integer> nodeQueue = new ArrayDeque<>(500);
    	boolean[] isTravelled = new boolean[10000];
    	int numOfSteps = 0;
    	int targetNode = Integer.parseInt(target);
    	
    	//step 2, parse dead ends and mark them as traveled so BFS will avoid them
    	for (String deadend:deadends) {
    		isTravelled[Integer.parseInt(deadend)] = true;
    	}//rof
    	//special case 2, source itself is a deadend
    	if (isTravelled[0]) {
    		return -1;
    	}//fi
    	
    	//step 3, start BFS and find the number of steps
    	nodeQueue.offer(0);
    	int prevQueueSize;
    	int currNode;
    	while ((prevQueueSize = nodeQueue.size())>0) {
    		numOfSteps++;    		
    		for (;prevQueueSize>0; prevQueueSize--) {
    			currNode = nodeQueue.poll();
    			for (int neighborNode:GRAPH[currNode]) {
    				if (neighborNode == targetNode) {
    					return numOfSteps;
    				} else if (!isTravelled[neighborNode]) {
    					nodeQueue.offer(neighborNode);
    					isTravelled[neighborNode] = true;
    				}//fi
    			}//rof
    		}//rof
    	}//end while
    	return -1;
    }//end method
}// end class



