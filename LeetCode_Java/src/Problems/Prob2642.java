package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob2642 {

	static int[][] arr1 = {{0,2,5},{0,1,2},{1,2,1},{3,0,3}};
	static int[][] arr2 = {{11,6,84715},{7,9,764823},{6,0,315591},{1,4,909432},{6,5,514907},{9,6,105610},{3,10,471042},{7,10,348752},{5,11,715628},{6,1,973999},{8,7,593929},{7,6,64688},{6,4,741734},{10,1,894247},{9,7,81181},{2,11,75418},{12,2,85431},{7,2,260306},{11,9,640614},{2,3,648804},{4,12,568023},{0,8,730096},{9,11,633474},{3,6,390214},{1,10,117955},{9,8,222602},{10,7,689294},{1,2,36450},{8,0,709628},{2,4,30185},{12,1,21696},{1,8,2553},{4,6,2182},{7,5,206},{5,7,140},{12,6,365184},{3,2,5},{0,11,5},{1,7,5},{3,9,858944},{0,9,4}};

	
	static int[] arr10 = {1,3,4};


	static void test() {
		Graph graphObj;
		int[][] arr;
		int n,s,d;
		
		/*
		arr = arr1;
		n = 4;
		s = 3; d = 2;
		graphObj = new Graph(n,arr);
		System.out.println("graph built: " + graphObj);
		System.out.println("cost from " + s + " to " + d + " : " + graphObj.shortestPath(s, d));
		
		
		s = 0; d = 3;	
		System.out.println("cost from " + s + " to " + d + " : " + graphObj.shortestPath(s, d));
		//*/

		arr = arr2;
		n = 13;
		s = 3; d = 5; //429354
		graphObj = new Graph(n,arr);
		System.out.println("graph built: " + graphObj);
		System.out.println("cost from " + s + " to " + d + " : " + graphObj.shortestPath(s, d));
	
		
		s = 4; d = 5; //399164
		System.out.println("cost from " + s + " to " + d + " : " + graphObj.shortestPath(s, d));
	
		s = 12; d = 9; //401984
		System.out.println("cost from " + s + " to " + d + " : " + graphObj.shortestPath(s, d));
		//*/
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Graph {
	
	/*
	 * Stores graph info.
	 * Map<node id of the source node, edge>
	 */
	private Map<Integer, List<int[]>> graph;
	
    public Graph(int n, int[][] edges) {
        graph = new HashMap<>();
        for (--n;n>=0;n--) {
        	graph.put(n, new LinkedList<>());
        }//rof
        for (int[] edge:edges) {
        	graph.get(edge[0]).add(edge);
        }//rof
    }//end constructor
    
    /**
     * precondition: 
     * does NOT check validity of edge array
     * @param edge - int[], edge array content = [from, to, edgeCost]
     */
    public void addEdge(int[] edge) {
    	graph.get(edge[0]).add(edge);
    }//end addEdge
    
    public int shortestPath(int node1, int node2) {
    	//step 1, prepare required data structures for dijkstra search
    	PriorityQueue<int[]> costQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));    	
    	int[] nodeCost = new int[2];//index 0 is cost, index 1 is node id
    	nodeCost[0] = 0;
    	nodeCost[1] = node1;
    	costQueue.offer(nodeCost);

    	int[] spArr = new int[graph.size()];
    	Arrays.fill(spArr, Integer.MAX_VALUE);    	
    	spArr[node1]=0;
    	
    	//step 2, loops through priority queue
    	while (costQueue.size()>0) {
    		//System.out.println("spArr: " + Arrays.toString(spArr));
    		int[] currShortestNode = costQueue.poll();
    		if (currShortestNode[0]>=spArr[node2]) {
    			System.out.println("return from here");
    			return spArr[node2];
    		}//fi
    		List<int[]> edgeList = graph.get(currShortestNode[1]);
    		for (int[] edge:edgeList) {
    			nodeCost = new int[2]; //index 0 is cost, index 1 is node id
    	    	nodeCost[0] = currShortestNode[0] + edge[2];
    	    	nodeCost[1] = edge[1];    	    	
    	    	if (nodeCost[0] < spArr[edge[1]]) {
    	    		spArr[edge[1]] = nodeCost[0];
    	    		costQueue.offer(nodeCost);
    	    	}//fi
    		}//rof
    	}//end while
    	    	
        return spArr[node2]==Integer.MAX_VALUE ? -1 : spArr[node2];
    }//end shortestPath
    
    
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("G={");
    	for (Entry<Integer,List<int[]>> entry:graph.entrySet()) {
    		sb.append(entry.getKey()+"=<");
    		for (int[] edge:entry.getValue()) {
    			sb.append(Arrays.toString(edge));
    		}//rof
    		sb.append(">,\n");
    	}//rof
    	sb.append("}");
    	return sb.toString();
    }//end toString
}//end class

