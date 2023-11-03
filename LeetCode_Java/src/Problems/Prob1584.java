package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1584 {

	static int[][] arr1 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	static int[][] arr2 = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
	static int[][] arr3 = { { 1, 2 } };
	static int[][] arr4 = { { -6, 9 }, { 1, 6 }, { 8, 10 }, { -1, 4 }, { -6, -2 }, { -9, 8 }, { -5, 3 }, { 0, 3 } };
	static int[][] arr5 = { { 5, 7 }, { -8, 2 }, { -3, 7 }, { -8, 9 }, { -2, 1 }, { -8, -5 }, { -2, -1 }, { 2, 4 },
			{ 2, 6 } };
	
	static int[][] arr10 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
	static int[][] arr11 = {{3, 12}, {-2, 5}, {-4, 1}};

	static void test() {
		Solution1584 solObj;
		int[][] arr;

		/*
		 * 
		 * solObj = new Solution1584(); arr = arr1; System.out.println("orignal arr: " +
		 * Arrays.deepToString(arr)); System.out.println("ans: "
		 * +solObj.findLongestChain(arr));
		 * 
		 * 
		 * 
		 * solObj = new Solution1584(); arr = arr2; System.out.println("orignal arr: " +
		 * Arrays.deepToString(arr)); System.out.println("ans: "
		 * +solObj.findLongestChain(arr));
		 * 
		 * solObj = new Solution1584(); arr = arr3; System.out.println("orignal arr: " +
		 * Arrays.deepToString(arr)); System.out.println("ans: "
		 * +solObj.findLongestChain(arr));
		 * 
		 * 
		 * 
		 * solObj = new Solution1584(); arr = arr4; System.out.println("orignal arr: " +
		 * Arrays.deepToString(arr)); System.out.println("ans: "
		 * +solObj.findLongestChain(arr));
		 * 
		 * //
		 */

		solObj = new Solution1584();		
		arr = arr10;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minCostConnectPoints(arr));
		
		solObj = new Solution1584();
		arr = arr11;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.minCostConnectPoints(arr));
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1584 {
	/*
	 * Key - weight
	 * Value - List of integers, each edge occupies two elements. So element 0,1 forms one edge, element 2,3 forms another
	 */
	private Map<Integer,List<Integer>> weightEdgeMap = new TreeMap<>();	
	/*
	 * index - point id
	 * value - island id
	 */
	private int[] islandIDArr;
	/*
	 * index - island id 
	 * value - rank
	 */
	private int[] rankArr;
	
	public int minCostConnectPoints(int[][] points) {
		//special cases: only one point
		if (points.length==1) {
			return 0;
		}//fi
		
		//step 1, prepare data structures for Kruskal algorithm which includes populating weight to edge map and island array
		islandIDArr = new int[points.length];
		rankArr = new int[points.length];
		int mDistance;
		List<Integer> edgeList;
		for (int i=0; i<points.length-1; i++) {
			for (int j=i+1; j<points.length; j++) {
				mDistance = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
				if ((edgeList = weightEdgeMap.get(32))==null) {
					edgeList = new ArrayList<>(points.length);
					weightEdgeMap.put(mDistance, edgeList);
				}//fi
				edgeList.add(i);
				edgeList.add(j);
			}//rof
			islandIDArr[i]=i;
		}//rof
		islandIDArr[points.length-1]=points.length-1;
		
		//step 2, construct minimum spanning tree using Kruskal Algorithm
		int totalCost = 0;
		int edgesLeft = points.length-1;
		for (Entry<Integer,List<Integer>> weightEdgeEntry:weightEdgeMap.entrySet()) {
			for (int i=0; i<weightEdgeEntry.getValue().size(); i+=2) {
				if (tryAddEdge(weightEdgeEntry.getValue().get(i),weightEdgeEntry.getValue().get(i+1))) {
					totalCost += weightEdgeEntry.getKey();
					if (--edgesLeft == 0) {
						return totalCost;
					}//fi
				}//fi
			}//rof

		}//rof
		//System.out.println(weightEdgeMap);
		
		return totalCost;
	}//end method
	
	/**
	 * This methods try to add edge to existing graphs. 
	 * If loop is found, it will return false and will not add edge
	 * 
	 * @param nodeOneID - int, id of node one
	 * @param nodeTwoID - int, id of node two
	 * @return true if the newly added edge doesn't form loop and false if new edge will create loop
	 */
	private boolean tryAddEdge(int nodeOneID, int nodeTwoID) {	
		return union(findIslandID(nodeOneID), findIslandID(nodeTwoID));
	}//end method
	
	/**
	 * Precondition: data structures are assumed to be correctly instantiated and populated
	 * - islandArr
	 * @param nodeID
	 * @return the island id belong to the node
	 */
	private int findIslandID(int nodeID) {
		if (nodeID != islandIDArr[nodeID]) {
			islandIDArr[nodeID] = findIslandID(islandIDArr[nodeID]);
		}//fi
		return islandIDArr[nodeID];
	}//fi
	
	/**
	 * Precondition: 
	 * - data structures are assumed to be correctly instantiated and populated : islandArr, rankArr
	 * - island id is assumed to be valid
	 * @param islandOneID - int
	 * @param islandTwoID - int
	 * @return true if the union work has been done, false if the two islands are already united
	 */
	private boolean union(int islandOneID, int islandTwoID) {
		if (islandOneID!=islandTwoID) {
			if (rankArr[islandOneID]<rankArr[islandTwoID]) {
				islandIDArr[islandOneID] = islandTwoID;
			} else if (rankArr[islandOneID]>rankArr[islandTwoID]) {
				islandIDArr[islandTwoID] = islandOneID;
			} else {
				islandIDArr[islandTwoID] = islandOneID;
				rankArr[islandOneID]++;
			}//fi
			return true;
		} else {
			return false;
		}//fi
	}//end method
}// end class
