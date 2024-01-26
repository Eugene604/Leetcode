package Problems;

import java.util.*;

public class Prob1845 {

	private static void test() {
		SeatManager sManager;
		int n;

		n = 5;
		sManager = new SeatManager(n);
		

		System.out.println("seat reserved: " + sManager.reserve());
		System.out.println("seat reserved: " + sManager.reserve());
		sManager.unreserve(2);
		System.out.println("seat reserved: " + sManager.reserve());
		System.out.println("seat reserved: " + sManager.reserve());
		System.out.println("seat reserved: " + sManager.reserve());
		System.out.println("seat reserved: " + sManager.reserve());
		sManager.unreserve(5);
		// */
	}// end method

	public static void main(String[] args) {
		test();
	}// end main
}

/*
 * tree set - 30 ms
 * priority queue - 28 ms
 */
class SeatManager {
	private int nextBrandNewSeat;
	//private PriorityQueue<Integer> returnedSeat; 
	private TreeSet<Integer> returnedSeat;
	
	public SeatManager(int n) {
		nextBrandNewSeat = 1;
		//returnedSeat = new PriorityQueue<>();
		returnedSeat = new TreeSet<>();
	}//end constructor

	public int reserve() {
		if (returnedSeat.size()==0) {
			return nextBrandNewSeat++;
		} else {
			//return returnedSeat.poll();
			return returnedSeat.pollFirst();
		}//fi		
	}//end method

	public void unreserve(int seatNumber) {
		//returnedSeat.offer(seatNumber);
		returnedSeat.add(seatNumber);
	}//end method
}// end class
