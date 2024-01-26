package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob815 {

	static int[][] arr1 = {{1,2,7},{3,6,7}};

	static int[][] arr2 = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};


	static void test() {
		Solution815 solObj;
		int[][] arr;
		int s, t;
		

		solObj = new Solution815();
		
		
		arr = arr1;		
		s = 1;
		t = 6;
			
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.numBusesToDestination(arr, s, t));
	
		/*
		arr = arr2;		
		s = 15;
		t = 12;
			
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.numBusesToDestination(arr, s, t));
		//*/
	}//end method

	public static void main(String[] args) {
		test();

	}

}

class Solution815 {
	 public int numBusesToDestination(int[][] routes, int source, int target) {
		 //special case, source = target
		 if (source == target) {
			 return 0;
		 }//fi
		 
		 //step 1, build bus maps - Map<stop, Set buses (which is routes[i]>
		 Map<Integer, Set<Integer>> stopMap = new HashMap<>();
		 Set<Integer> busSet;
		 for (int i=0; i<routes.length; i++) {
			 for (int stopID:routes[i]) {
				 if ((busSet=stopMap.get(stopID))==null) {
					 busSet = new HashSet<>();
					 stopMap.put(stopID, busSet);
				 }//fi
				 busSet.add(i);
			 }//rof			 
		 }//rof
		 //System.out.println("stopMap: "+stopMap);
		 
		 //step 2, use BFS search to find
		 Set<Integer> traversedBuses = new HashSet<>();
		 Set<Integer> traversedStops = new HashSet<>();
		 Set<Integer> currCandidateStops = new HashSet<>();
		 Set<Integer> nextCandidateStops;
		 currCandidateStops.add(source);
		 traversedStops.add(source);		 
		 int numOfBuses = 1;
		 while (currCandidateStops.size()>0) {			 
			 //System.out.println("currCandidateStops " + currCandidateStops);
			 nextCandidateStops = new HashSet<>();
			 for (Integer currStop:currCandidateStops) {
				 if ((busSet=stopMap.remove(currStop))==null) {
					 continue;				 
				 } else {
					 busSet.removeAll(traversedBuses);
					 traversedBuses.addAll(busSet);
					 for (int busID:busSet) {
						 for (int stopID:routes[busID]) {

							 if (!traversedStops.contains(stopID)) {
								 nextCandidateStops.add(stopID);
							 }//fi
							 /*
							 if (stopID == target) {
								 return numOfBuses;
							 }//fi */
						 }//rof
					 }//rof
				 }//fi
			 }//rof
			 if (nextCandidateStops.contains(target)) {
				 return numOfBuses;
			 }//fi */
			 currCandidateStops = nextCandidateStops;
			 numOfBuses++;
		 }//end while
	     return -1;
	 }//end method
}// end class


class Solution815_v2 {
	 public int numBusesToDestination(int[][] routes, int source, int target) {
		 //special case, source = target
		 if (source == target) {
			 return 0;
		 }//fi
		 
		 //step 1, build stop maps - Map<stop, Set of other stops that can be reached without switching bus>
		 Map<Integer, Set<Integer>> stopMap = new HashMap<>();
		 Set<Integer> stopsOfRoute;
		 Set<Integer> reachableStops;
		 for (int[] route:routes) {
			 stopsOfRoute = new HashSet<>();
			 for (int stopID:route) {
				 stopsOfRoute.add(stopID);
			 }//rof
			 for (int stopID:route) {
				 if ((reachableStops=stopMap.get(stopID))==null) {
					 reachableStops = new HashSet<>();
					 stopMap.put(stopID, reachableStops);
				 }//fi
				 reachableStops.addAll(stopsOfRoute);
				 reachableStops.remove(stopID);
			 }//rof			 
		 }//rof
		 System.out.println("stopMap: "+stopMap);
		 
		 //step 2, use BFS search to find
		 Set<Integer> traversedStops = new HashSet<>();
		 Set<Integer> currCandidateStops = new HashSet<>();
		 Set<Integer> nextCandidateStops;
		 currCandidateStops.add(source);
		 int numOfBuses = 1;
		 while (currCandidateStops.size()>0) {
			 //System.out.println("currCandidateStops " + currCandidateStops);
			 traversedStops.addAll(currCandidateStops);
			 nextCandidateStops = new HashSet<>();
			 for (Integer currStop:currCandidateStops) {
				 if ((reachableStops=stopMap.remove(currStop))==null) {
					 continue;
				 } else if (reachableStops.contains(target)) {
					 return numOfBuses;
				 } else {
					 
					 reachableStops.removeAll(traversedStops);
					 nextCandidateStops.addAll(reachableStops);
				 }//fi
			 }//rof
			 currCandidateStops = nextCandidateStops;
			 numOfBuses++;
		 }//end while
	     return -1;
	 }//end method
}// end class