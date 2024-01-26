package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1743 {

	static int[][] arr1 = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
	static int[][] arr2 = { { 4, -2 }, { 1, 4 }, { -3, 1 } };
	static int[][] arr3 = { { 100000, -100000 } };

	static void test() {
		Solution1743 solObj = new Solution1743();
		int[][] arr;


		arr = arr1;

		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("processed arr: " + Arrays.toString(solObj.restoreArray(arr)));

	}

	public static void main(String[] args) {
		test();

	}//end method

}//end class

class Solution1743 {

	public int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> adjRelationMap = populateAdjacencyRelations(adjacentPairs);
		List<Integer> adjList = populateAdjList(adjRelationMap);
		int[] ansArr = new int[adjList.size()];
		int i = 0;
		for (Integer num : adjList) {
			ansArr[i] = num;
			i++;
		} // rof
		return ansArr;
	}// end method

	/**
	 * Try populate a list of adjacent numbers by taking the first element of adjacent relation map as the initial number of the list. 
	 * Postcondition:
	 * adjacency relation of a number will be removed if that number and its neighbors have been recorded in the list
	 * 
	 * @param adjRelationMap - Map<Integer, List<Integer>>, Map<number element, List of neighbors>
	 * @return List<Integer>, list of numbers that are neighbors one by one
	 */
	private List<Integer> populateAdjList(Map<Integer, List<Integer>> adjRelationMap) {
		LinkedList<Integer> adjList = new LinkedList<>();
		if (adjRelationMap.size() == 0) {
			return adjList;
		} // fi


		adjList.add(adjRelationMap.keySet().iterator().next());

		Integer edgeNum, newNeighbor;
		List<Integer> neighborList;
		// add neighbor in forward direction		
		do {
			edgeNum = adjList.getFirst();
			neighborList = adjRelationMap.get(edgeNum);
			if (neighborList.size()>0) {
				newNeighbor = neighborList.remove(0);
				adjList.addFirst(newNeighbor);
				adjRelationMap.get(newNeighbor).remove(edgeNum);
			} else {
				break;
			} // fi
		} while (true);
		
		// add neighbor in backward direction
		do {
			edgeNum = adjList.getLast();
			neighborList = adjRelationMap.get(edgeNum);
			if (neighborList.size()>0) {
				newNeighbor = neighborList.remove(0);
				adjList.addLast(newNeighbor);
				adjRelationMap.get(newNeighbor).remove(edgeNum);
			} else {
				break;
			} // fi
		} while (true);
		return adjList;
	}// end method

	/**
	 * 
	 * @param adjacentPairs - int[][],
	 * @return Map<Integer, List<Integer>> - key is a number in the array, value is
	 *         set of neighbors in the array
	 */
	private Map<Integer, List<Integer>> populateAdjacencyRelations(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> adjRelationMap = new HashMap<>();
		List<Integer> neighborList;
		for (int[] adjPair : adjacentPairs) {
			if ((neighborList = adjRelationMap.get(adjPair[0])) == null) {
				neighborList = new ArrayList<>(2);
				adjRelationMap.put(adjPair[0], neighborList);
			} // fi
			neighborList.add(adjPair[1]);

			if ((neighborList = adjRelationMap.get(adjPair[1])) == null) {
				neighborList = new ArrayList<>(2);
				adjRelationMap.put(adjPair[1], neighborList);
			} // fi
			neighborList.add(adjPair[0]);
		} // rof
		return adjRelationMap;
	}// end method
}// end class


class Solution1743_v2 {

	public int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, TreeSet<Integer>> adjRelationMap = populateAdjacencyRelations(adjacentPairs);
		List<Integer> adjList = populateAdjList(adjRelationMap);
		int[] ansArr = new int[adjList.size()];
		int i = 0;
		for (Integer num : adjList) {
			ansArr[i] = num;
			i++;
		} // rof
		return ansArr;
	}// end method

	/**
	 * Try populate a list of adjacent numbers by taking the first element of
	 * adjacent relation map as the initial number of the list. Postcondition:
	 * adjacency relation of a number will be removed if that number and its
	 * neighbors have been recorded in the list
	 * 
	 * @param adjRelationMap - Map<Integer, TreeSet<Integer>>, Map<number element,
	 *                       Set of neighbors>
	 * @return List<Integer>, list of numbers that are neighbors one by one
	 */
	private List<Integer> populateAdjList(Map<Integer, TreeSet<Integer>> adjRelationMap) {
		LinkedList<Integer> adjList = new LinkedList<>();
		if (adjRelationMap.size() == 0) {
			return adjList;
		} // fi

		adjList.add(adjRelationMap.keySet().iterator().next());

		Integer edgeNum, newNeighbor;
		// add neighbor in forward direction
		do {
			edgeNum = adjList.getFirst();
			if ((newNeighbor = adjRelationMap.get(edgeNum).pollFirst()) != null) {
				adjList.addFirst(newNeighbor);
				adjRelationMap.get(newNeighbor).remove(edgeNum);
			} else {
				break;
			} // fi
		} while (true);
		// add neighbor in backward direction
		do {
			edgeNum = adjList.getLast();
			if ((newNeighbor = adjRelationMap.get(edgeNum).pollLast()) != null) {
				adjList.addLast(newNeighbor);
				adjRelationMap.get(newNeighbor).remove(edgeNum);
			} else {
				break;
			} // fi
		} while (true);
		return adjList;
	}// end method

	/**
	 * 
	 * @param adjacentPairs - int[][],
	 * @return Map<Integer, Set<Integer>> - key is a number in the array, value is
	 *         set of neighbors in the array
	 */
	private Map<Integer, TreeSet<Integer>> populateAdjacencyRelations(int[][] adjacentPairs) {
		Map<Integer, TreeSet<Integer>> adjRelationMap = new HashMap<>();
		TreeSet<Integer> neighborSet;
		for (int[] adjPair : adjacentPairs) {
			if ((neighborSet = adjRelationMap.get(adjPair[0])) == null) {
				neighborSet = new TreeSet<>();
				adjRelationMap.put(adjPair[0], neighborSet);
			} // fi
			neighborSet.add(adjPair[1]);

			if ((neighborSet = adjRelationMap.get(adjPair[1])) == null) {
				neighborSet = new TreeSet<>();
				adjRelationMap.put(adjPair[1], neighborSet);
			} // fi
			neighborSet.add(adjPair[0]);
		} // rof
		return adjRelationMap;
	}// end method
}// end class
