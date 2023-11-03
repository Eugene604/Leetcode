package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob847 {

	static int[][] arr1 = {{1,2,3},{0},{0},{0}};
	static int[][] arr2 = {{1},{0,2,4},{1,3,4},{2},{1,2}};
	static int[][] arr3 = {{}};
	static int[][] arr4 = {{0}};
	
	static int[][] arr10 = {{1,4},{0,3,4,7,9},{6,10},{1,10},{1,0},{6},{7,2,5},{6,1,8},{7},{1},{2,3}};
	static int[][] arr11 ={{2,5,7},{2,4},{0,1},{5},{5,6,1},{4,10,8,0,3},{4,9},{0},{5},{6},{5}};
	static int[][] arr12 ={{1,2,3,4,5,6,7,8,9},{0,2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},{0,1,2,4,5,6,7,8,9},{0,1,2,3,5,6,7,8,9},{0,1,2,3,4,6,7,8,9},{0,1,2,3,4,5,7,8,9},{0,1,2,3,4,5,6,8,9},{0,1,2,3,4,5,6,7,9,10},{0,1,2,3,4,5,6,7,8,11},{8},{9}};
	static int[][] arr13 ={{2},{2,8},{0,1,3,4},{2},{2},{8,6},{5},{8},{1,5,7}};
	static int[][] arr14 ={{2,3},{7},{0,6},{0,4,7},{3,8},{7},{2},{5,3,1},{4}};
	static int[][] arr15 ={{1},{0,2,4},{1,3},{2},{1,5},{4}};
	static int[][] arr16 ={{1,4},{0,3,10},{3},{1,2,6,7},{0,5},{4},{3},{3},{10},{10},{1,9,8}};
	
	static void test() {
		Solution847 solObj;
		int[][] arr;
		
		
		
		solObj = new Solution847();
		arr = arr1;//4
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr));

		solObj = new Solution847();
		arr = arr2;//4
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr));
		
		solObj = new Solution847();
		arr = arr3;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr4;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr10;//12
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr11;//13
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr12; //11
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 

		solObj = new Solution847();
		arr = arr13; //11
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr14; //11
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr15; //6
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
	
		
		solObj = new Solution847();
		arr = arr15; //6
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		solObj = new Solution847();
		arr = arr16; //15
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		
		//*/
		solObj = new Solution847();
		arr = arr1; 
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.shortestPathLength(arr)); 
		

	}//end method

	public static void main(String[] args) {
		test();

	}

}


class Solution847 {
	
	private static final int[] ID_TO_BITPOS;	
	private static final int[] FINAL_BIT_STATE;
	private static final int ID_SHIFT;
	private static final int RIGHT_MASK;
	int[][] graph;
	boolean[][] visited;
	
	static {
		ID_TO_BITPOS = new int[12];
		ID_TO_BITPOS[0]=1;
		ID_TO_BITPOS[1]=2;
		ID_TO_BITPOS[2]=4;
		ID_TO_BITPOS[3]=8;
		ID_TO_BITPOS[4]=16;
		ID_TO_BITPOS[5]=32;
		ID_TO_BITPOS[6]=64;
		ID_TO_BITPOS[7]=128;
		ID_TO_BITPOS[8]=256;
		ID_TO_BITPOS[9]=512;
		ID_TO_BITPOS[10]=1024;
		ID_TO_BITPOS[11]=2048;
						
		FINAL_BIT_STATE = new int[13];
		FINAL_BIT_STATE[1]=1;
		FINAL_BIT_STATE[2]=3;
		FINAL_BIT_STATE[3]=7;
		FINAL_BIT_STATE[4]=15;
		FINAL_BIT_STATE[5]=31;
		FINAL_BIT_STATE[6]=63;
		FINAL_BIT_STATE[7]=127;
		FINAL_BIT_STATE[8]=255;
		FINAL_BIT_STATE[9]=511;
		FINAL_BIT_STATE[10]=1023;
		FINAL_BIT_STATE[11]=2047;
		FINAL_BIT_STATE[12]=4095;
		
		ID_SHIFT = 16;
		
		RIGHT_MASK = 0b1111111111111111;
	}//end static block
	

	
    public int shortestPathLength(int[][] graph) {
    	//special case, the graph contains one node
    	if (graph.length==1) {
    		return 0;
    	}//fi    		
    	
    	//step 1, sort inner arrays by node degree
    	this.graph = graph;
    	for (int i=graph.length-1; i>=0; i--) {
    		sortArr(graph[i]);
    	}//rof    	
    	
    	//step 2, initialize the least degree nodes to deque and also visited array
    	visited = new boolean[13][4096];
    	Deque<Integer> nodeQueue = new LinkedList<>();
    	int nodeState;
    	for (int deg = 1; deg<=graph.length&&nodeQueue.size()==0; deg++) {
    		for (int i=0; i<graph.length; i++) {
    			if (graph[i].length==deg) {
    				nodeState = (i << ID_SHIFT) | ID_TO_BITPOS[i];
    				visited[i][ID_TO_BITPOS[i]]=true;;
    				nodeQueue.offer(nodeState);
    			}//fi
    		}//fi    		
    	}//rof*/
    	
    	//step 3, start traverse the graph by using BFS
    	int numOfNodesLeft;
    	int step = 0;
    	int currNodeState;    	
    	while ((numOfNodesLeft = nodeQueue.size())!=0) {
    		step++;
    		do {
    			currNodeState = nodeQueue.pollFirst();
    			if (tryAddNeighbors(currNodeState, nodeQueue)) {
    				return step;
    			}//fi
    		} while (--numOfNodesLeft>0);//end do while    		
    	}//end while
    	return step;
    }//end method
    
    
    /**
     * Try to add adjacent nodes into queue by check it's traversal bitmap
     * @param currNodeState - int, recordings node ID and traversal state
     * @param nodeQueue - Deque<Integer> , the queue to insert neighbor nodes to
     * @return true if a path found
     */
    private boolean tryAddNeighbors(int currNodeState, Deque<Integer> nodeQueue) {
    	int nextTraverseState;
    	for (int nextNodeID:graph[currNodeState>>ID_SHIFT]) {
    		nextTraverseState = currNodeState & RIGHT_MASK | ID_TO_BITPOS[nextNodeID];
    		if (visited[nextNodeID][nextTraverseState]) {
    			continue; 
    		} else if (nextTraverseState == FINAL_BIT_STATE[graph.length]) {
    			return true;
    		}//fi
    		visited[nextNodeID][nextTraverseState] = true;
    		nodeQueue.offerLast((nextNodeID<<ID_SHIFT) |  nextTraverseState);
    	}//rof
    	return false;
    }//end method
    
    /**
     * sort nodes according to its degree in the graph using insertion sort
     * Precondition:
     * this.graph is set and valid
     * 
     * @param arr - int[], array elements must be a valid node ID of graph
     */
    private void sortArr(int[] arr) {
    	if (arr.length==1) {
    		return;
    	}//fi
        for (int i = 1; i < arr.length; i++) {
        	int key = arr[i];
            int j = i - 1;
            while (j >= 0 && graph[arr[j]].length > graph[key].length) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }//end while
            arr[j + 1] = key;
        }//rof
    }//end method   
}//end class

/**
 * DFS, 0ms, beats 100% time, 99.99% memory
 * has been published on leetcode solution section
 */
class Solution847_v2 {
	
	private static final int[] ID_TO_BITPOS;	
	private static final int[] FINAL_BIT_STATE;
	private int globalSPRepeat;
	private int globalSPLength;
	private int[][] graph;
	
	static {
		ID_TO_BITPOS = new int[12];
		ID_TO_BITPOS[0]=1;
		ID_TO_BITPOS[1]=2;
		ID_TO_BITPOS[2]=4;
		ID_TO_BITPOS[3]=8;
		ID_TO_BITPOS[4]=16;
		ID_TO_BITPOS[5]=32;
		ID_TO_BITPOS[6]=64;
		ID_TO_BITPOS[7]=128;
		ID_TO_BITPOS[8]=256;
		ID_TO_BITPOS[9]=512;
		ID_TO_BITPOS[10]=1024;
		ID_TO_BITPOS[11]=2048;
						
		FINAL_BIT_STATE = new int[13];
		FINAL_BIT_STATE[1]=1;
		FINAL_BIT_STATE[2]=3;
		FINAL_BIT_STATE[3]=7;
		FINAL_BIT_STATE[4]=15;
		FINAL_BIT_STATE[5]=31;
		FINAL_BIT_STATE[6]=63;
		FINAL_BIT_STATE[7]=127;
		FINAL_BIT_STATE[8]=255;
		FINAL_BIT_STATE[9]=511;
		FINAL_BIT_STATE[10]=1023;
		FINAL_BIT_STATE[11]=2047;
		FINAL_BIT_STATE[12]=4095;
	}//end static block
	

	
    public int shortestPathLength(int[][] graph) {
    	//special case, the graph contains one node
    	if (graph.length==1) {
    		return 0;
    	}//fi
    	
    	this.globalSPLength = graph.length<<1;
    	this.graph = graph;    	
    	
    	//step 1, sort inner arrays by node degree
    	for (int i=graph.length-1; i>=0; i--) {
    		sortArr(graph[i]);
    	}//rof    	
    	
    	//step 2, for each of the least degree nodes, recursively (DFS) search for possible complete paths 
    	for (int deg = 1; deg<=graph.length && globalSPLength == graph.length<<1; deg++) {
    		for (int i=0; i<graph.length; i++) {
    			if (graph[i].length!=deg) {
    				continue;
    			}//fi
    			System.out.println("search node " + i);
        	  	this.globalSPRepeat = 0;
        		searchPath(0,-1,i,0);
    		}//fi    		
    	}//rof*/
    	return globalSPLength;
    }//end method
    
    /**
     * Precondition: required global variables and references are properly set
     * - graph, globalSPLength, ID_TO_BITPOS, FINAL_BIT_STATE
     * @param nodeAdded - int, each bit position records node that has been traveled 
     * @param currNode - int, index of the current node
     * @param step - int, records the current step size
     * @return true if a complete path has been found
     */
    private boolean searchPath(int nodeAdded,int prevNode, int currNode, int step) {
	
    	//base case 1, non optimal route or equally optimal encountered
    	if (step > globalSPLength || globalSPRepeat>0) {
    		return false;    
    	}//fi
 	
    	//base case 2, last node arrived 
    	if ((nodeAdded |= ID_TO_BITPOS[currNode])== FINAL_BIT_STATE[graph.length]) {
    		if (globalSPLength>step) {
    			globalSPRepeat=0;
    			globalSPLength=step;
    		} else {    
    			globalSPRepeat++;
    		}//fi
    		return true;
    	}//fi

    			
    	//traverse through each of its adjacent nodes    
    	boolean foundPath = false;
    	for (int nextNode:graph[currNode]) {
    		if ((nodeAdded & ID_TO_BITPOS[nextNode])!=0) {
    			continue;//traverse unvisited nodes first
    		}//fi
    		foundPath |= searchPath(nodeAdded,currNode,nextNode,step+1);
    	}//rof
    	
    	if (foundPath) {
    		return true;
    	}//fi 
    		
    	System.out.println("enter visited node phase");
    	for (int nextNode:graph[currNode]) {
    		if (((nodeAdded & ID_TO_BITPOS[nextNode])==0) ||prevNode==nextNode) {
    			continue; //then traverse visited nodes but not the prevNode
    		}//fi		
    		searchPath(nodeAdded,currNode, nextNode,step+1);
    	}//rof 
    	
    	if (prevNode != -1) { //finally traverse back to prevNode
    		searchPath(nodeAdded,currNode, prevNode,step+1);
    	}//fi*/
    	return true;	
    }//end method

    /**
     * sort nodes according to its degree in the graph using insertion sort
     * Precondition:
     * this.graph is set and valid
     * 
     * @param arr - int[], array elements must be a valid node ID of graph
     */
    private void sortArr(int[] arr) {
    	if (arr.length==1) {
    		return;
    	}//fi
        for (int i = 1; i < arr.length; i++) {
        	int key = arr[i];
            int j = i - 1;
            while (j >= 0 && graph[arr[j]].length > graph[key].length) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }//end while
            arr[j + 1] = key;
        }//rof
    }//end method   
}//end class
