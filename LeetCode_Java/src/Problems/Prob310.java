package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob310 {

	public static void test() {

		Solution310 solObj = new Solution310();		
		Solution310_v2 correctSolObj = new Solution310_v2();		
		
		int[][] edges;
		int n;

		try {
            ObjectMapper mapper = new ObjectMapper();

  
    		
            edges = mapper.readValue("[[0,1],[0,2],[1,3],[1,4],[1,5],[1,6],[1,7],[2,8],[5,9],[6,10],[7,11],[8,12]]", int[][].class);
            n = 13;
    		System.out.println("Arr: " + Arrays.deepToString(edges));
    		System.out.println("Correct Ans: " + correctSolObj.findMinHeightTrees(n , edges));
    		System.out.println("Ans: " + solObj.findMinHeightTrees(n , edges));    		 
    		
            edges = mapper.readValue("[[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[1,7],[1,8],[1,9]]", int[][].class);
            n = 10;
    		System.out.println("Arr: " + Arrays.deepToString(edges));
    		System.out.println("Correct Ans: " + correctSolObj.findMinHeightTrees(n , edges));
    		System.out.println("Ans: " + solObj.findMinHeightTrees(n , edges));

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution310{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	
    	//step 0, initialize variables and data structs for BFS
    	List<Integer> mhtRootList =  new ArrayList<>();
    	List<Set<Integer>> graph = new ArrayList<>(n);
    	    	
    	if (n == 1) { //special case, n=1 or 2
    		mhtRootList.add(0);
    		return mhtRootList;
    	} else if (n == 2) {
    		mhtRootList.add(0);
    		mhtRootList.add(1);    		
    		return mhtRootList;
    	}//fi
    	 	    	
    	//step 1, build graph and node queue   
    	for (int i=0; i<n; i++) {
    		graph.add(new HashSet<>());
    	}//rof
    	for (int[] edge:edges) {
    		graph.get(edge[0]).add(edge[1]);
    		graph.get(edge[1]).add(edge[0]);
    	}//rof
    	
    	//step 2, use BFS to delete single edge nodes    	    
    	Deque<Integer> leafQueue = new ArrayDeque<>(); 	  
    	for (int i=0; i<n; i++) {
    		if (graph.get(i).size()==1) {
    			leafQueue.offer(i);
    		}//fi
    	}//rof
    	int prevDequeSize;
    	int currNode, neighborNode;
    	int neighborDegree;
    	while ((prevDequeSize=leafQueue.size())>1) {
        	if (leafQueue.size()==2) {
        		int leaf1 = leafQueue.peekFirst();
        		int leaf2 = leafQueue.peekLast();
        		if (graph.get(leaf1).iterator().next() == leaf2) { //only two leaf connected together
        			mhtRootList.add(leaf1);
        			mhtRootList.add(leaf2);
        			return mhtRootList;
        		}//fi        		
        	}//fi
        	
    		for (; prevDequeSize>0; prevDequeSize--) { // find leaf nodes
    			currNode = leafQueue.poll();
    			neighborNode = graph.get(currNode).iterator().next();
    			graph.get(neighborNode).remove(currNode);     			
    			if ((neighborDegree = graph.get(neighborNode).size()) == 1) {
    				leafQueue.offer(neighborNode);   
	    		} else if (neighborDegree == 0) {
	        		mhtRootList.add(neighborNode);
	        		return mhtRootList;
	    		}//fi
    		}//fof    	
    		
    	}//end while		
    	
		return mhtRootList;    	
    }//end method
}// end class

class Solution310_v2{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	List<List<Integer>> graph;
    	List<Integer> mhtRootList =  new ArrayList<>();
    	
    	//special case, n=1 or 2
    	if (n <= 2) {
    		mhtRootList.add(0);
    		if (n == 2) {  
    			mhtRootList.add(1);
    		}//fi
    		return mhtRootList;
    	}//fi
    	

    	
    	//step 1, build graph
    	graph = new ArrayList<>(n);
    	for (int i=0; i<n; i++) {
    		graph.add(new ArrayList<>());
    	}//rof
    	for (int[] edge:edges) {
    		graph.get(edge[0]).add(edge[1]);
    		graph.get(edge[1]).add(edge[0]);
    	}//rof
    	
    	//step 2, use BFS to find tree height at each node
    	
    	int[] knownMTHArr = new int[n];//index = root id, value = known min tree height when this node is root
    	boolean[] isTravelled;
    	Deque<Integer> nodeQueue;
    	int currNode;
    	int prevDequeSize;
    	int currHeight, minHeight = Integer.MAX_VALUE;
    	
      	
    	for (int i=0; i<n; i++) {
    		if (graph.get(i).size()<2) {//anser list size cannot exceeds 3
    			continue;
    		}//fi
    		nodeQueue = new ArrayDeque<>();
    		nodeQueue.offer(i);
    		currHeight = 0;    		
    		isTravelled = new boolean[n];    		
    		while ((prevDequeSize=nodeQueue.size())>0 && currHeight<=minHeight) {
    			//System.out.println("queue size: " + prevDequeSize);
    			currHeight++;
    			for (; prevDequeSize>0; prevDequeSize--) {
    				currNode = nodeQueue.poll();
    				isTravelled[currNode] = true;
    				for (int neighborNode:graph.get(currNode)) {
        	    		if (isTravelled[neighborNode]) {
        	    			continue;
        	    		}//fi
        	    		isTravelled[neighborNode] = true;
        	    		nodeQueue.offer(neighborNode);
        	    		knownMTHArr[i] = Math.max(knownMTHArr[i], currHeight);
        			}//rof
    			}//rof    			    			    			
    		}//end while
    		if (currHeight < minHeight) {
    			minHeight = currHeight;
    			mhtRootList.clear();
    			mhtRootList.add(i);
    		} else if (currHeight == minHeight) {
    			mhtRootList.add(i);
    		}//fi
    		
    		if (mhtRootList.size()==2) {
    			return mhtRootList;
    		}
    	}//rof
    	
    	return mhtRootList;
    }//end method
}// end class


