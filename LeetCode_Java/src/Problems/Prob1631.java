package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob1631 {

	static int[][] arr1 = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
	static int[][] arr2 = { { 1, 2, 3 }, { 3, 8, 4 }, { 5, 3, 5 } };
	static int[][] arr3 = { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },{1,1, 1, 2, 1 } };
	static int[][] arr4 = {{1,10,6,7,9,10,4,9}};

	static void test() {
		Solution1631 solObj;
		int[][] arr;
		
		
		/*
		solObj = new Solution1631();
		arr = arr1;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minimumEffortPath(arr));
		
		solObj = new Solution1631();
		arr = arr2;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minimumEffortPath(arr));
		
		
		solObj = new Solution1631();
		arr = arr3;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minimumEffortPath(arr));
		//*/
		
		
		solObj = new Solution1631();
		arr = arr4;
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minimumEffortPath(arr));
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution1631 {
		
	private PriorityQueue<List<Object>> candidateVQueue; 
	 
	public int minimumEffortPath(int[][] heights) {
		//step 1, build vGraph
		Vertex.populateVGraph(heights);
		
		//step 2, prepare candidate queue data structure
		candidateVQueue = new PriorityQueue<>((a, b) -> ((Integer) a.get(0) - (Integer)b.get(0)));

		//step 3, iterate through the graph
		updateNeighbors(Vertex.vGraph[0][0]);
		
		List<Object> vInfo;
		Vertex v;
		
		while (!candidateVQueue.isEmpty()) {			
			vInfo = candidateVQueue.poll();
			v = (Vertex)vInfo.get(1);
			if (!v.isSP) {
				v.isSP = true;
				updateNeighbors(v);
			} else if (v.i == Vertex.maxI && v.j == Vertex.maxJ) {
				return v.dist;
			} else {
				continue;
			}//fi
		}//end while
		return Vertex.vGraph[Vertex.maxI][Vertex.maxJ].dist;
	}// end method

	
	/**
	 * update dist values of neighboring node that are NOT belonging to SPT
	 * Precondition:
	 * - candidate vertex priority queue is initialized
	 * 	PriorityQueue<List<Integer>>, index 0 is distance, index 1 is vertex IDs
	 * Postcondition:
	 * neighboring vertices are put to priority queue 
	 * @param currV - Vertex in consideration
	 */
	private void updateNeighbors(Vertex v) {
				
		Vertex otherV;
		//try update upper neighbor
		if (v.i>0) {
			otherV = Vertex.vGraph[v.i-1][v.j];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update lower neighbor
		if (v.i<Vertex.maxI) {
			otherV = Vertex.vGraph[v.i+1][v.j];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update left neighbor
		if (v.j>0) {
			otherV = Vertex.vGraph[v.i][v.j-1];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update right neighbor
		if (v.j<Vertex.maxJ) {
			otherV = Vertex.vGraph[v.i][v.j+1];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
	}//end method
	

	/**
	 * register info of the Vertex v into PriorityQueue<List<Integer>>, index 0 is distance, index 1 is vertex IDs
	 * @param v Vertex
	 */
	private void insertToPriorityQueue(Vertex v) {
		List<Object> vInfo = new ArrayList<>(2);
		vInfo.add(v.dist);
		vInfo.add(v);
		candidateVQueue.offer(vInfo);		
	}//end method
}// end class


class Solution1631_v2 {
	
	
	private PriorityQueue<List<Integer>> candidateVQueue; 
	 
	public int minimumEffortPath(int[][] heights) {
		//step 1, build vGraph
		Vertex.populateVGraph(heights);
		
		//step 2, prepare candidate queue data structure
		candidateVQueue = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));

		//step 3, iterate through the graph
		updateNeighbors(Vertex.vGraph[0][0]);
		
		List<Integer> vInfo;
		Vertex v;
		
		while (!candidateVQueue.isEmpty()) {			
			vInfo = candidateVQueue.poll();
			v = Vertex.vGraph[vInfo.get(1)][vInfo.get(2)];
			if (!v.isSP) {
				v.isSP = true;
				updateNeighbors(v);
			} else if (v.i == Vertex.maxI && v.j == Vertex.maxJ) {
				return v.dist;
			} else {
				continue;
			}//fi
		}//end while
		return Vertex.vGraph[Vertex.maxI][Vertex.maxJ].dist;
	}// end method

	
	/**
	 * update dist values of neighboring node that are NOT belonging to SPT
	 * Precondition:
	 * - candidate vertex priority queue is initialized
	 * 	PriorityQueue<List<Integer>>, index 0 is distance, index 1 is vertex IDs
	 * Postcondition:
	 * neighboring vertices are put to priority queue 
	 * @param currV - Vertex in consideration
	 */
	private void updateNeighbors(Vertex v) {
				
		Vertex otherV;
		//try update upper neighbor
		if (v.i>0) {
			otherV = Vertex.vGraph[v.i-1][v.j];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update lower neighbor
		if (v.i<Vertex.maxI) {
			otherV = Vertex.vGraph[v.i+1][v.j];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update left neighbor
		if (v.j>0) {
			otherV = Vertex.vGraph[v.i][v.j-1];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
		
		//try update right neighbor
		if (v.j<Vertex.maxJ) {
			otherV = Vertex.vGraph[v.i][v.j+1];
			if (!otherV.isSP && otherV.updateDist(v)) {
				insertToPriorityQueue(otherV);
			}//fi
		}//fi
	}//end method
	

	/**
	 * register info of the Vertex v into PriorityQueue<List<Integer>>, index 0 is distance, index 1 is vertex IDs
	 * @param v Vertex
	 */
	private void insertToPriorityQueue(Vertex v) {
		List<Integer> vInfo = new ArrayList<>(2);
		vInfo.add(v.dist);
		vInfo.add(v.i);
		vInfo.add(v.j);
		candidateVQueue.offer(vInfo);		
	}//end method
}// end class



/**
 * This class record info and state of a Vertex. Also contains some operations that perform partial steps in Dijkstra's Algorithm,
 * i = index i on associated vGraph
 */
class Vertex {
	public static Vertex[][] vGraph = new Vertex[100][100];
	public static int[][] heightArr;
	public static int maxI;
	public static int maxJ;
	
	public int i;
	public int j;
	public int dist; 
	public boolean isSP;

	public Vertex(int i, int j) {
		this.i = i;
		this.j = j;
		this.dist = Integer.MAX_VALUE;
		isSP = false;
		vGraph[i][j] = this;
	}//end constructor
	
	/**
	 * Precondition:
	 * - valid heights array. does not check for null or array length
	 * Postcondition:
	 * - vGraph populated
	 * - maxI and maxJ set; 
	 * @param heights - int[][], size rows x columns, where heights[row][col] represents the height of cell (row, col). 
	 */
	public static void populateVGraph(int[][] heights) {
		heightArr = heights;
		maxI = heights.length-1;
		maxJ = heights[0].length-1;		
		for (int i=0; i<= maxI; i++) {
			for (int j=0; j<=maxJ; j++) {
				new Vertex(i,j);
			}//rof
		}//rof
		vGraph[0][0].dist = 0;
		vGraph[0][0].isSP = true;
	}//end method
	
	
	
	/**
	 * update dist value given a source vertex
	 * @param sourceVertex
	 * @return boolean - true if dist value is updated
	 */
	public boolean updateDist(Vertex sourceV) {
		int dist;
		dist = Math.max(sourceV.dist, Math.abs(heightArr[i][j]-heightArr[sourceV.i][sourceV.j]));
		if (dist<this.dist) {
			this.dist = dist;
			return true;
		}//fi
		return false;
	}//end method

	@Override
	public String toString() {
		return "[("+i+","+j+") "+dist+"]";
	}//end method
}//end class

