package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2699 {

	
	static int n, source, destination, target;
	static int[][] edges;
	

	static void test() {
		Solution2699 solObj;
		
		


				
		try {
			solObj = new Solution2699();
            ObjectMapper mapper = new ObjectMapper();



    		n = 100;
    		source = 0;
    		destination = 99;
    		target = 990000000;
            
            edges = mapper.readValue("[[0,1,10000000],[1,2,10000000],[2,3,10000000],[3,4,10000000],[4,5,10000000],[5,6,10000000],[6,7,10000000],[7,8,10000000],[8,9,10000000],[9,10,10000000],[10,11,10000000],[11,12,10000000],[12,13,10000000],[13,14,10000000],[14,15,10000000],[15,16,10000000],[16,17,10000000],[17,18,10000000],[18,19,10000000],[19,20,10000000],[20,21,10000000],[21,22,10000000],[22,23,10000000],[23,24,10000000],[24,25,10000000],[25,26,10000000],[26,27,10000000],[27,28,10000000],[28,29,10000000],[29,30,10000000],[30,31,10000000],[31,32,10000000],[32,33,10000000],[33,34,10000000],[34,35,10000000],[35,36,10000000],[36,37,10000000],[37,38,10000000],[38,39,10000000],[39,40,10000000],[40,41,10000000],[41,42,10000000],[42,43,10000000],[43,44,10000000],[44,45,10000000],[45,46,10000000],[46,47,10000000],[47,48,10000000],[48,49,10000000],[49,50,10000000],[50,51,10000000],[51,52,10000000],[52,53,10000000],[53,54,10000000],[54,55,10000000],[55,56,10000000],[56,57,10000000],[57,58,10000000],[58,59,10000000],[59,60,10000000],[60,61,10000000],[61,62,10000000],[62,63,10000000],[63,64,10000000],[64,65,10000000],[65,66,10000000],[66,67,10000000],[67,68,10000000],[68,69,10000000],[69,70,10000000],[70,71,10000000],[71,72,10000000],[72,73,10000000],[73,74,10000000],[74,75,10000000],[75,76,10000000],[76,77,10000000],[77,78,10000000],[78,79,10000000],[79,80,10000000],[80,81,10000000],[81,82,10000000],[82,83,10000000],[83,84,10000000],[84,85,10000000],[85,86,10000000],[86,87,10000000],[87,88,10000000],[88,89,10000000],[89,90,10000000],[90,91,10000000],[91,92,10000000],[92,93,10000000],[93,94,10000000],[94,95,10000000],[95,96,10000000],[96,97,10000000],[97,98,10000000],[98,99,10000000],[0,99,-1]]", int[][].class);
    		System.out.println("Edges:" + Arrays.deepToString(edges));		
    		System.out.println("ans: " +  Arrays.deepToString(solObj.modifiedGraphEdges(n, edges, source, destination, target)));
    		
            /*
    		
    		    		n = 4;
    		source = 2;
    		destination = 3;
    		target = 8;
            
            edges = mapper.readValue("[[0,1,-1],[1,2,-1],[3,1,-1],[3,0,2],[0,2,5]]", int[][].class);
    		System.out.println("Edges:" + Arrays.deepToString(edges));		
    		System.out.println("ans: " +  Arrays.deepToString(solObj.modifiedGraphEdges(n, edges, source, destination, target)));
    		
    		
    		
    		n = 5;
    		source = 0;
    		destination = 1;
    		target = 5;
            
            edges = mapper.readValue(" [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]", int[][].class);
    		System.out.println("Edges:" + Arrays.deepToString(edges));		
    		System.out.println("ans: " +  Arrays.deepToString(solObj.modifiedGraphEdges(n, edges, source, destination, target)));
    		
    		//*/
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
	}//end method


	
	public static void main(String[] args) {
		test();
	}

}


class Solution2699 {
		
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

    	//Array inx: node id, array value: map of its neighbors. Map key: neighbor node id, map val: edge id (inx of edges)
    	List<Map<Integer,Integer>> graph;
    	Set<Integer> negativeCostEdgeIDSet = new HashSet<>();
    	
    	//step 1, build graph, meanwhile populate negative cost edge IDs
    	graph = new ArrayList<>(n);
    	for (int i=0; i<n; i++) {
    		graph.add(new HashMap<>());
    	}//rof
    	for (int i=0; i<edges.length; i++) {
    		graph.get(edges[i][0]).put(edges[i][1],i);
    		graph.get(edges[i][1]).put(edges[i][0],i);
    		if (edges[i][2]<0) {
    			negativeCostEdgeIDSet.add(i);
    			edges[i][2] = 1;
    		}//fi
    	}//rof
    	
    	//System.out.println(graph);
    	
    	//Step 2: Use the modified Dijkstra's algorithm. First pass we ignore negative edges.
        //Array to store the least traversal cost. Index: node ID, value: least cost to travel from the start (source) node.
    	int[] traverseCostArr = new int[n];
    	//queue content: [path cost from source node, arrival node id]
    	PriorityQueue<int[]> costQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    	//place holder for current shortest path: [path cost from source node, arrival node id]
    	int[] currSPath;
    	int neighborNodeID, costToNeighborNode, edgeIDToNeighborNode;
    	
    	Arrays.fill(traverseCostArr, Integer.MAX_VALUE);
    	traverseCostArr[source] = 0;   
    	costQueue.offer(new int[] {0,source});
    	while (costQueue.size()>0) {
    		currSPath = costQueue.poll();    		
    		for (Entry<Integer, Integer> entry:graph.get(currSPath[1]).entrySet()) {
    			neighborNodeID = entry.getKey();
    			edgeIDToNeighborNode = entry.getValue();
    			costToNeighborNode = currSPath[0] + edges[edgeIDToNeighborNode][2];
    			if (!negativeCostEdgeIDSet.contains(edgeIDToNeighborNode) && costToNeighborNode < traverseCostArr[neighborNodeID]) {
    				//edge cost not negative and less cost path has been found
    				traverseCostArr[neighborNodeID] = costToNeighborNode;
    				costQueue.offer(new int[] {costToNeighborNode,neighborNodeID});
    			}//fi
    		}//rof
    	}//end while
    	
    	//step 3: check if shortest path found is less than target.
    	if (traverseCostArr[destination] < target) {
    		//impossible to have shortest path cost == target
    		return new int[0][0];
    	} else if (traverseCostArr[destination] == target) {
    		//exact cost path found, just make all negative edges to have max cost
        	for (int edgeID:negativeCostEdgeIDSet) {
        		edges[edgeID][2] = 2_000_000_000;
        	}//rof
    		return edges;
    	} else if (negativeCostEdgeIDSet.size()==0) {
    		//no negative edge and cost is not equal to target, impossible to alter path cost
    		return new int[0][0];
    	}//fi
    	

	
    	//step 4, use modified Dijkstra again and this time accounts for negative edges 
    	costQueue.offer(new int[] {0,source});
    	//Array to record the immediate previous edge used to reach this node. Index: node ID, value: edge ID of the route taken to arrive at this node.
    	int[] prevEdgeArr = new int[n];
    	//Array to record the immediate previous node when coming from source. Index: node ID, value: immediate previous node's ID    	
    	int[] prevNodeArr = new int[n];
    	while (costQueue.size()>0) {
    		currSPath = costQueue.poll();    		
    		for (Entry<Integer, Integer> entry:graph.get(currSPath[1]).entrySet()) {
    			neighborNodeID = entry.getKey();
    			edgeIDToNeighborNode = entry.getValue();
    			costToNeighborNode = currSPath[0] + edges[edgeIDToNeighborNode][2];
    			if (costToNeighborNode < traverseCostArr[neighborNodeID]) {//less cost path has been found
    				traverseCostArr[neighborNodeID] = costToNeighborNode;
    				prevEdgeArr[neighborNodeID] = edgeIDToNeighborNode;
    				prevNodeArr[neighborNodeID] = currSPath[1];
    				costQueue.offer(new int[] {costToNeighborNode,neighborNodeID});
    			}//fi
    		}//rof
    	}//end while
    	//System.out.println("traverseCostArr:" + Arrays.toString(traverseCostArr));
    	//System.out.println("prevNodeArr:" + Arrays.toString(prevNodeArr));
    	//System.out.println("prevEdgeArr:" + Arrays.toString(prevEdgeArr));
    	
    	//step 5: check if least cost is still greater than target or exactly equal to target
    	if (traverseCostArr[destination] > target) {
        	//shortest path found is greater than target, impossible to have shortest path cost == target
    		return new int[0][0];
    	} else if (traverseCostArr[destination] == target) {
    		//exact cost path found, just return current edges
    		return edges;
    	}//fi
    	
    	//now shortest path found is less than target, need to modify edges. 
    	//Step 6: Trace back the route and make first negative edge to fill the diff
    	Set<Integer> lcpNegativeEdgeIDSet = new HashSet<>(); //least cost path negative edge id set
    	int currNodeID = destination;
    	int firstNegativeEdgeID = -1;
    	do {
    		if (negativeCostEdgeIDSet.remove(prevEdgeArr[currNodeID])) {    			
    			firstNegativeEdgeID = prevEdgeArr[currNodeID];
    			lcpNegativeEdgeIDSet.add(firstNegativeEdgeID);
    		}//fi
    		currNodeID = prevNodeArr[currNodeID];
    	} while (currNodeID != source); //end do while    	
    	    	
  
    	if (firstNegativeEdgeID == -1) {//there's no negative edge, can't reach destination with target cost
    		return new int[0][0];
    	} else {
    		edges[firstNegativeEdgeID][2] = target - traverseCostArr[destination] + 1;    		
    		lcpNegativeEdgeIDSet.remove(firstNegativeEdgeID);
    	}//fi
    	
    	//finally, make rest of negative edges' cost to be large
    	for (int edgeID:negativeCostEdgeIDSet) {
    		edges[edgeID][2] = 2_000_000_000;
    		graph.get(edges[edgeID][0]).remove(edges[edgeID][1]);
    		graph.get(edges[edgeID][1]).remove(edges[edgeID][0]);
    	}//rof
    	//System.out.println("lcpNegativeEdgeIDSet: " + lcpNegativeEdgeIDSet);
    	//System.out.println("edges: " + Arrays.deepToString(edges));
    	
    	//step 7: check for other possible shorter path, if found abandon current found one 
    	Arrays.fill(traverseCostArr, Integer.MAX_VALUE);
    	traverseCostArr[source] = 0;   
    	costQueue.offer(new int[] {0,source});
    	while (traverseCostArr[destination] != target) {
        	prevEdgeArr = new int[n];        	    	
        	prevNodeArr = new int[n];
        	COSTQUEUE_WHILE_LOOP:
        	while (costQueue.size()>0) {
        		currSPath = costQueue.poll();    		
        		for (Entry<Integer, Integer> entry:graph.get(currSPath[1]).entrySet()) {
        			neighborNodeID = entry.getKey();
        			edgeIDToNeighborNode = entry.getValue();
        			costToNeighborNode = currSPath[0] + edges[edgeIDToNeighborNode][2];
        			if (costToNeighborNode < traverseCostArr[neighborNodeID]) {//less cost path has been found
        				traverseCostArr[neighborNodeID] = costToNeighborNode;
        				prevEdgeArr[neighborNodeID] = edgeIDToNeighborNode;
        				prevNodeArr[neighborNodeID] = currSPath[1];
        				costQueue.offer(new int[] {costToNeighborNode,neighborNodeID});
        				if (neighborNodeID == source && costToNeighborNode < target) {//another shorter path has been found
        					break COSTQUEUE_WHILE_LOOP;
        				}//fi
        			}//fi
        		}//rof
        	}//end while
        	if (traverseCostArr[destination] < target) {//another shorter path has been found
            	currNodeID = destination;
            	firstNegativeEdgeID = -1;
            	do {
            		if (lcpNegativeEdgeIDSet.contains(prevEdgeArr[currNodeID])) {  
                		edges[prevEdgeArr[currNodeID]][2] = target - traverseCostArr[destination] + 1;    		
                		lcpNegativeEdgeIDSet.remove(firstNegativeEdgeID);                		
            			break;
            		}//fi
            		currNodeID = prevNodeArr[currNodeID];
            	} while (currNodeID != source); //end do while    	
            	Arrays.fill(traverseCostArr, Integer.MAX_VALUE);
            	traverseCostArr[source] = 0;   
            	costQueue.offer(new int[] {0,source});            	
			}//fi
    	}//end while
        return edges;
    }//end method
}// end class



class Solution2699_v2{
		
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

    	//Array inx: node id, array value: map of its neighbors. Map key: neighbor node id, map val: edge id (inx of edges)
    	List<Map<Integer,Integer>> graph;
    	Set<Integer> negativeCostEdgeIDSet = new HashSet<>();
    	
    	//step 1, build graph, meanwhile populate negative cost edge IDs
    	graph = new ArrayList<>(n);
    	for (int i=0; i<n; i++) {
    		graph.add(new HashMap<>());
    	}//rof
    	for (int i=0; i<edges.length; i++) {
    		graph.get(edges[i][0]).put(edges[i][1],i);
    		graph.get(edges[i][1]).put(edges[i][0],i);
    		if (edges[i][2]<0) {
    			negativeCostEdgeIDSet.add(i);
    			edges[i][2] = 1;
    		}//fi
    	}//rof
    	
    	//System.out.println(graph);
    	
    	//Step 2: Use the modified Dijkstra's algorithm. First pass we ignore negative edges.
        //Array to store the least traversal cost. Index: node ID, value: least cost to travel from the start (source) node.
    	int[] traverseCostArr = new int[n];
    	//queue content: [path cost from source node, arrival node id]
    	PriorityQueue<int[]> costQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    	//place holder for current shortest path: [path cost from source node, arrival node id]
    	int[] currSPath;
    	int neighborNodeID, costToNeighborNode, edgeIDToNeighborNode;
    	
    	Arrays.fill(traverseCostArr, Integer.MAX_VALUE);
    	traverseCostArr[source] = 0;   
    	costQueue.offer(new int[] {0,source});
    	while (costQueue.size()>0) {
    		currSPath = costQueue.poll();    		
    		for (Entry<Integer, Integer> entry:graph.get(currSPath[1]).entrySet()) {
    			neighborNodeID = entry.getKey();
    			edgeIDToNeighborNode = entry.getValue();
    			costToNeighborNode = currSPath[0] + edges[edgeIDToNeighborNode][2];
    			if (!negativeCostEdgeIDSet.contains(edgeIDToNeighborNode) && costToNeighborNode < traverseCostArr[neighborNodeID]) {
    				//edge cost not negative and less cost path has been found
    				traverseCostArr[neighborNodeID] = costToNeighborNode;
    				costQueue.offer(new int[] {costToNeighborNode,neighborNodeID});
    			}//fi
    		}//rof
    	}//end while
    	
    	//step 3: check if shortest path found is less than target.
    	if (traverseCostArr[destination] < target) {//impossible to have shortest path cost == target
    		System.out.println("return from here 1");
    		return new int[0][0];
    	} else if (traverseCostArr[destination] == target) {//exact cost path found, just make all negative edges to have max cost
        	for (int edgeID:negativeCostEdgeIDSet) {
        		edges[edgeID][2] = 2_000_000_000;
        	}//rof
    		return edges;
    	}//fi

	
    	//step 4, use modified Dijkstra again and this time accounts for negative edges
    	traverseCostArr[source] = 0;   
    	costQueue.offer(new int[] {0,source});
    	//Array to record the immediate previous edge used to reach this node. Index: node ID, value: edge ID of the route taken to arrive at this node.
    	int[] prevEdgeArr = new int[n];
    	//Array to record the immediate previous node when coming from source. Index: node ID, value: immediate previous node's ID    	
    	int[] prevNodeArr = new int[n];
    	while (costQueue.size()>0) {
    		currSPath = costQueue.poll();    		
    		for (Entry<Integer, Integer> entry:graph.get(currSPath[1]).entrySet()) {
    			neighborNodeID = entry.getKey();
    			edgeIDToNeighborNode = entry.getValue();
    			costToNeighborNode = currSPath[0] + edges[edgeIDToNeighborNode][2];
    			if (costToNeighborNode < traverseCostArr[neighborNodeID]) {//less cost path has been found
    				traverseCostArr[neighborNodeID] = costToNeighborNode;
    				prevEdgeArr[neighborNodeID] = edgeIDToNeighborNode;
    				prevNodeArr[neighborNodeID] = currSPath[1];
    				costQueue.offer(new int[] {costToNeighborNode,neighborNodeID});
    			}//fi
    		}//rof
    	}//end while
    	//System.out.println("traverseCostArr:" + Arrays.toString(traverseCostArr));
    	//System.out.println("prevNodeArr:" + Arrays.toString(prevNodeArr));
    	//System.out.println("prevEdgeArr:" + Arrays.toString(prevEdgeArr));
    	
    	//step 5: check result

    	if (traverseCostArr[destination] > target) {
        	//shortest path found is greater than target, impossible to have shortest path cost == target
    		System.out.println("return from here 2");
    		return new int[0][0];
    	} else if (traverseCostArr[destination] == target) {
    		//exact cost path found, just return current edges
    		return edges;
    	}//fi
    	
    	//now shortest path found is less than target, need to modify edges. Trace back the route
    	int currNodeID = destination;
    	boolean hasBoostedANegativeEdge = false;
    	do {
    		if (negativeCostEdgeIDSet.remove(prevEdgeArr[currNodeID])) {
    			edges[prevEdgeArr[currNodeID]][2] = target - traverseCostArr[destination] + 1;
    			hasBoostedANegativeEdge = true;
    		}//fi
    		currNodeID = prevNodeArr[currNodeID];
    	} while (currNodeID != source && !hasBoostedANegativeEdge); //end do while    	
    	
    	while (currNodeID != source) {
    		negativeCostEdgeIDSet.remove(prevEdgeArr[currNodeID]);
    		currNodeID = prevNodeArr[currNodeID];
    	}//end while  
    	
    	if (!hasBoostedANegativeEdge) {//there's no negative edge, can't reach destination with target cost
    		return new int[0][0];
    	}//fi
    	
    	//finally, make rest of negative edges' cost to be large
    	for (int edgeID:negativeCostEdgeIDSet) {
    		edges[edgeID][2] = 2_000_000_000;
    	}//rof
        return edges;
    }//end method
}// end class

