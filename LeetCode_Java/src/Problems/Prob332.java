package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob332 {

	public static List<List<String>> tickets1, tickets2, tickets3, tickets4, tickets5, tickets10;
	
	static {
		tickets1 = new ArrayList<>(5);
		tickets1.add(Arrays.asList("MUC","LHR"));
		tickets1.add(Arrays.asList("JFK","MUC"));
		tickets1.add(Arrays.asList("SFO","SJC"));
		tickets1.add(Arrays.asList("LHR","SFO"));

		tickets2 = new ArrayList<>(5);
		tickets2.add(Arrays.asList("JFK","SFO"));
		tickets2.add(Arrays.asList("JFK","ATL"));
		tickets2.add(Arrays.asList("SFO","ATL"));
		tickets2.add(Arrays.asList("ATL","JFK"));
		tickets2.add(Arrays.asList("ATL","SFO"));
		
		tickets3 = new ArrayList<>(1);
		tickets3.add(Arrays.asList("JFK","SFO"));
		
		tickets4 = new ArrayList<>(5);
		tickets4.add(Arrays.asList("JFK","KUL"));
		tickets4.add(Arrays.asList("JFK","NRT"));
		tickets4.add(Arrays.asList("NRT","JFK"));
		
		tickets5 = new ArrayList<>(1);
		tickets5.add(Arrays.asList("EZE","AXA"));
		tickets5.add(Arrays.asList("TIA","ANU"));
		tickets5.add(Arrays.asList("ANU","JFK"));
		tickets5.add(Arrays.asList("JFK","ANU"));
		tickets5.add(Arrays.asList("ANU","EZE"));
		tickets5.add(Arrays.asList("TIA","ANU"));
		tickets5.add(Arrays.asList("AXA","TIA"));
		tickets5.add(Arrays.asList("TIA","JFK"));
		tickets5.add(Arrays.asList("ANU","TIA"));
		tickets5.add(Arrays.asList("JFK","TIA"));
		

        tickets10 = new ArrayList<>(150);
        tickets10.add(Arrays.asList("BIM","VIE"));
        tickets10.add(Arrays.asList("ANU","EZE"));
        tickets10.add(Arrays.asList("PER","CNS"));
        tickets10.add(Arrays.asList("TCB","BIM"));
        tickets10.add(Arrays.asList("MEL","PER"));
        tickets10.add(Arrays.asList("VIE","ANU"));
        tickets10.add(Arrays.asList("ANU","SYD"));
        tickets10.add(Arrays.asList("SYD","PER"));
        tickets10.add(Arrays.asList("DRW","TIA"));
        tickets10.add(Arrays.asList("PER","BAK"));
        tickets10.add(Arrays.asList("EZE","BNE"));
        tickets10.add(Arrays.asList("ANU","ADL"));
        tickets10.add(Arrays.asList("BIM","MEL"));
        tickets10.add(Arrays.asList("EZE","ASD"));
        tickets10.add(Arrays.asList("SYD","JFK"));
        tickets10.add(Arrays.asList("ADL","BIM"));
        tickets10.add(Arrays.asList("AUA","EZE"));
        tickets10.add(Arrays.asList("CNS","TBI"));
        tickets10.add(Arrays.asList("DRW","ANU"));
        tickets10.add(Arrays.asList("OOL","VIE"));
        tickets10.add(Arrays.asList("DRW","TCB"));
        tickets10.add(Arrays.asList("OOL","AXA"));
        tickets10.add(Arrays.asList("TIA","BIM"));
        tickets10.add(Arrays.asList("TIA","ANU"));
        tickets10.add(Arrays.asList("ANU","MEL"));
        tickets10.add(Arrays.asList("TIA","MHH"));
        tickets10.add(Arrays.asList("SYD","AXA"));
        tickets10.add(Arrays.asList("AXA","ADL"));
        tickets10.add(Arrays.asList("SYD","ANU"));
        tickets10.add(Arrays.asList("CBR","ADL"));
        tickets10.add(Arrays.asList("CBR","TIA"));
        tickets10.add(Arrays.asList("ADL","BIM"));
        tickets10.add(Arrays.asList("TBI","DRW"));
        tickets10.add(Arrays.asList("MHH","ADL"));
        tickets10.add(Arrays.asList("MEL","HBA"));
        tickets10.add(Arrays.asList("CNS","JFK"));
        tickets10.add(Arrays.asList("VIE","CBR"));
        tickets10.add(Arrays.asList("ANU","VIE"));
        tickets10.add(Arrays.asList("BNE","HBA"));
        tickets10.add(Arrays.asList("BIM","TCB"));
        tickets10.add(Arrays.asList("JFK","BAK"));
        tickets10.add(Arrays.asList("EZE","SYD"));
        tickets10.add(Arrays.asList("AUA","BIM"));
        tickets10.add(Arrays.asList("TBI","TIA"));
        tickets10.add(Arrays.asList("MEL","JFK"));
        tickets10.add(Arrays.asList("TIA","BAK"));
        tickets10.add(Arrays.asList("BNE","VIE"));
        tickets10.add(Arrays.asList("HBA","PER"));
        tickets10.add(Arrays.asList("ANU","AUA"));
        tickets10.add(Arrays.asList("EZE","BNE"));
        tickets10.add(Arrays.asList("INN","AUA"));
        tickets10.add(Arrays.asList("TIA","ANU"));
        tickets10.add(Arrays.asList("BAK","EZE"));
        tickets10.add(Arrays.asList("INN","JFK"));
        tickets10.add(Arrays.asList("BAK","MEL"));
        tickets10.add(Arrays.asList("AUA","TCB"));
        tickets10.add(Arrays.asList("PER","BAK"));
        tickets10.add(Arrays.asList("SYD","DRW"));
        tickets10.add(Arrays.asList("LST","MEL"));
        tickets10.add(Arrays.asList("INN","BNE"));
        tickets10.add(Arrays.asList("LST","JFK"));
        tickets10.add(Arrays.asList("AXA","MEL"));
        tickets10.add(Arrays.asList("BAK","CNS"));
        tickets10.add(Arrays.asList("BNE","HBA"));
        tickets10.add(Arrays.asList("VIE","TCB"));
        tickets10.add(Arrays.asList("MHH","ASD"));
        tickets10.add(Arrays.asList("OOL","PER"));
        tickets10.add(Arrays.asList("PER","EZE"));
        tickets10.add(Arrays.asList("MEL","AXA"));
        tickets10.add(Arrays.asList("BNE","SYD"));
        tickets10.add(Arrays.asList("MEL","ANU"));
        tickets10.add(Arrays.asList("LST","DRW"));
        tickets10.add(Arrays.asList("EZE","TBI"));
        tickets10.add(Arrays.asList("ASD","AXA"));
        tickets10.add(Arrays.asList("MHH","LST"));
        tickets10.add(Arrays.asList("TIA","EZE"));
        tickets10.add(Arrays.asList("DRW","HBA"));
        tickets10.add(Arrays.asList("SYD","BGI"));
        tickets10.add(Arrays.asList("AUA","MHH"));
        tickets10.add(Arrays.asList("BIM","INN"));
        tickets10.add(Arrays.asList("AXA","VIE"));
        tickets10.add(Arrays.asList("EZE","CNS"));
        tickets10.add(Arrays.asList("JFK","BNE"));
        tickets10.add(Arrays.asList("TCB","CNS"));
        tickets10.add(Arrays.asList("ADL","CBR"));
        tickets10.add(Arrays.asList("BIM","INN"));
        tickets10.add(Arrays.asList("TBI","TCB"));
        tickets10.add(Arrays.asList("BIM","MEL"));
        tickets10.add(Arrays.asList("VIE","BNE"));
        tickets10.add(Arrays.asList("JFK","TIA"));
        tickets10.add(Arrays.asList("ADL","AUA"));
        tickets10.add(Arrays.asList("ANU","OOL"));
        tickets10.add(Arrays.asList("SYD","AUA"));
        tickets10.add(Arrays.asList("JFK","AUA"));
        tickets10.add(Arrays.asList("HBA","BIM"));
        tickets10.add(Arrays.asList("SYD","ADL"));
        tickets10.add(Arrays.asList("TCB","DRW"));
        tickets10.add(Arrays.asList("JFK","BNE"));
        tickets10.add(Arrays.asList("MHH","SYD"));
        tickets10.add(Arrays.asList("CNS","EZE"));
        tickets10.add(Arrays.asList("AXA","TIA"));
        tickets10.add(Arrays.asList("INN","SYD"));
        tickets10.add(Arrays.asList("CBR","INN"));
        tickets10.add(Arrays.asList("ADL","TIA"));
        tickets10.add(Arrays.asList("SYD","LST"));
        tickets10.add(Arrays.asList("BAK","TIA"));
        tickets10.add(Arrays.asList("DRW","INN"));
        tickets10.add(Arrays.asList("CBR","BAK"));
        tickets10.add(Arrays.asList("ASD","SYD"));
        tickets10.add(Arrays.asList("EZE","ADL"));
        tickets10.add(Arrays.asList("JFK","LST"));
        tickets10.add(Arrays.asList("BNE","OOL"));
        tickets10.add(Arrays.asList("SYD","BIM"));
        tickets10.add(Arrays.asList("ADL","EZE"));
        tickets10.add(Arrays.asList("BNE","VIE"));
        tickets10.add(Arrays.asList("BAK","PER"));
        tickets10.add(Arrays.asList("BNE","VIE"));
        tickets10.add(Arrays.asList("EZE","ASD"));
        tickets10.add(Arrays.asList("BAK","EZE"));
        tickets10.add(Arrays.asList("EZE","JFK"));
        tickets10.add(Arrays.asList("LST","BNE"));
        tickets10.add(Arrays.asList("VIE","SYD"));
        tickets10.add(Arrays.asList("BNE","VIE"));
        tickets10.add(Arrays.asList("BAK","AUA"));
        tickets10.add(Arrays.asList("ASD","LST"));
        tickets10.add(Arrays.asList("VIE","SYD"));
        tickets10.add(Arrays.asList("OOL","ADL"));
        tickets10.add(Arrays.asList("EZE","SYD"));
        tickets10.add(Arrays.asList("AUA","EZE"));
        tickets10.add(Arrays.asList("ASD","AXA"));
        tickets10.add(Arrays.asList("AXA","OOL"));
        tickets10.add(Arrays.asList("TCB","EZE"));
        tickets10.add(Arrays.asList("TBI","JFK"));
        tickets10.add(Arrays.asList("HBA","SYD"));
        tickets10.add(Arrays.asList("AXA","CBR"));
        tickets10.add(Arrays.asList("INN","BNE"));
        tickets10.add(Arrays.asList("BIM","TBI"));
        tickets10.add(Arrays.asList("ANU","OOL"));
        tickets10.add(Arrays.asList("DRW","MHH"));
        tickets10.add(Arrays.asList("BNE","ANU"));
        tickets10.add(Arrays.asList("TCB","OOL"));
        tickets10.add(Arrays.asList("TIA","CBR"));
        tickets10.add(Arrays.asList("OOL","MHH"));
        tickets10.add(Arrays.asList("VIE","ASD"));
        tickets10.add(Arrays.asList("VIE","ADL"));
        tickets10.add(Arrays.asList("HBA","DRW"));
        tickets10.add(Arrays.asList("MEL","EZE"));
        tickets10.add(Arrays.asList("PER","AXA"));
        tickets10.add(Arrays.asList("ADL","SYD"));
        tickets10.add(Arrays.asList("CNS","BNE"));
        tickets10.add(Arrays.asList("JFK","TBI"));
        tickets10.add(Arrays.asList("SYD","DRW"));
        tickets10.add(Arrays.asList("MEL","ANU"));
        tickets10.add(Arrays.asList("JFK","BAK"));
        tickets10.add(Arrays.asList("EZE","BAK"));
        tickets10.add(Arrays.asList("AUA","EZE"));
        tickets10.add(Arrays.asList("PER","INN"));
        tickets10.add(Arrays.asList("EZE","MEL"));
        tickets10.add(Arrays.asList("ADL","PER"));


	}//end static block
	
	public static void main(String[] args) {
		Solution332 solObj = new Solution332();
		List<List<String>> tickets;
		
		
		tickets = tickets1;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));

		tickets = tickets2;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));
		
		tickets = tickets3;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));
		
		tickets = tickets4;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));
		
		tickets = tickets5;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));
		//*/
		
		tickets = tickets10;
		System.out.println(tickets);
		System.out.println("ans: " + solObj.findItinerary(tickets));

	}

}


class Solution332 {

	
	private Map<String, PriorityQueue<String>> ticketMap;
	private LinkedList<String> itinerary;
	
	public List<String> findItinerary(List<List<String>> tickets) {

		//step 1, populate ticket map. this is essentially airport relations
		ticketMap = new HashMap<>();
		for (List<String> aTicket:tickets) {
			String departureAirport = aTicket.get(0);
			String arrivalAirport = aTicket.get(1);
			PriorityQueue<String> arrivalQueue;
			if ((arrivalQueue = ticketMap.get(departureAirport))==null){
				arrivalQueue = new PriorityQueue<>();
				ticketMap.put(departureAirport, arrivalQueue);
			}//fi
			arrivalQueue.add(arrivalAirport);
		}//rof

		//System.out.println(ticketMap);
		
		//step 2, recursively find itinerary
		itinerary = new LinkedList<>();
		searchItinerary("JFK");
		
		return itinerary;
	}// end method
	

	/**
	 * recursively search for itinerary
	 * Precondition:
	 * - assumes ticketsLeft is positive
	 * - needed data structures are instantiated and/or populated correctly:
	 * 	ticketMap, itinerary
	 * @param currAirport String - current airport 
	 */
	private void searchItinerary(String currAirport) {
		//System.out.println("currAirport: " + currAirport);
		PriorityQueue<String> arrivalQueue;
		
		//base case: dead end
		if ((arrivalQueue = ticketMap.get(currAirport))==null) {
			itinerary.add(currAirport);
			return;
		}//fi
		
		String currArrivalAirport;
		while (arrivalQueue.size()>0) {
			currArrivalAirport = arrivalQueue.poll();
			searchItinerary(currArrivalAirport);
		}//end rof 
		itinerary.addFirst(currAirport);
	}//fi

}// end class


class Solution332_v1 {

	private static Map<String, Integer> airportToIDMap;
	private static Map<Integer, String> idToAirportMap;
	static {
		airportToIDMap = new HashMap<>();
		airportToIDMap.put("JFK", 10443);
		idToAirportMap = new HashMap<>();
		idToAirportMap.put(10443, "JFK");
	}//end static block
	
	private Map<Integer, List<Integer>> ticketMap;
	private LinkedList<Integer> itineraryInt;
	
	public List<String> findItinerary(List<List<String>> tickets) {

		
		//step 1, populate ticket map. this is essentially airport relations
		ticketMap = new HashMap<>();
		for (List<String> aTicket:tickets) {
			int departureAirportCode = getAirportCode(aTicket.get(0));
			int arrivalAirportCode = getAirportCode(aTicket.get(1));
			List<Integer> arrivalList;
			if ((arrivalList = ticketMap.get(departureAirportCode))==null){
				arrivalList = new ArrayList<>(3);
				ticketMap.put(departureAirportCode, arrivalList);
			}//fi
			arrivalList.add(arrivalAirportCode);
		}//rof
		for (List<Integer> val:ticketMap.values()) {
			val.sort(null);
		}//rof
		//System.out.println(ticketMap);
		
		//step 2, recursively find itinerary
		itineraryInt = new LinkedList<>();
		searchItinerary(10443);
		
		List<String> itineraryStr = new ArrayList<>(itineraryInt.size());
		for (Integer airportCode:itineraryInt) {
			itineraryStr.add(idToAirportMap.get(airportCode));
		}//rof
		return itineraryStr;
	}// end method
	

	/**
	 * recursively search for itinerary
	 * Precondition:
	 * - assumes ticketsLeft is positive
	 * - needed data structures are instantiated and/or populated correctly:
	 * 	ticketMap, itineraryInt
	 * @param currAirport Integer - current airport code
	 */
	private void searchItinerary(Integer currAirport) {
		//System.out.println("currAirport: " + currAirport);
		List<Integer> arrivalList;
		
		//base case: dead end
		if ((arrivalList = ticketMap.get(currAirport))==null || arrivalList.size()==0) {
			itineraryInt.add(currAirport);
			return;
		}//fi

		
		Integer currArrivalID;
		for (int i = 0; i < arrivalList.size(); i++) {
			currArrivalID = arrivalList.get(i);
			if (currArrivalID==null || (i>0 && arrivalList.get(i)==arrivalList.get(i-1))) {
				continue;
			}//fi
			arrivalList.set(i,null);
			searchItinerary(currArrivalID);
		}//end rof */
		itineraryInt.addFirst(currAirport);
	}//fi

	/**
	 * Precondition:
	 * - it is assumed that airport abbreviation string consists exactly 3 abbreviation letter
	 * - airportToIDMap is instantiated
	 * - JFK is having ID code 0
	 * Postcondition:
	 * - a reverse ID to airport map is also prepared
	 * @param abbr String - airport abbreviation 
	 * @return int - non-negative int that can be used as ID code for airport and preserves lexical order 
	 */
	private static int getAirportCode(String abbr) {
		Integer storedCode = airportToIDMap.get(abbr);
		if (storedCode != null) {
			return storedCode;
		}//fi		
		int code;
		code = (abbr.charAt(0)-'@')<<10;
		code += (abbr.charAt(1)-'@')<<5;
		code += (abbr.charAt(2)-'@');
		airportToIDMap.put(abbr, code);
		idToAirportMap.put(code,abbr);
		return code;
	}//end method
}// end class

class Solution332_v2 {

	private static Map<String, Integer> airportToIDMap;
	private static Map<Integer, String> idToAirportMap;
	static {
		airportToIDMap = new HashMap<>();
		airportToIDMap.put("JFK", 10443);
		idToAirportMap = new HashMap<>();
		idToAirportMap.put(10443, "JFK");
	}//end static block
	
	private Map<Integer, List<Integer>> ticketMap;
	private LinkedList<Integer> itineraryInt;
	
	public List<String> findItinerary(List<List<String>> tickets) {

		
		//step 1, populate ticket map. this is essentially airport relations
		ticketMap = new HashMap<>();
		for (List<String> aTicket:tickets) {
			int departureAirportCode = getAirportCode(aTicket.get(0));
			int arrivalAirportCode = getAirportCode(aTicket.get(1));
			List<Integer> arrivalList;
			if ((arrivalList = ticketMap.get(departureAirportCode))==null){
				arrivalList = new ArrayList<>(3);
				ticketMap.put(departureAirportCode, arrivalList);
			}//fi
			arrivalList.add(arrivalAirportCode);
		}//rof
		for (List<Integer> val:ticketMap.values()) {
			val.sort(null);
		}//rof
		//System.out.println(ticketMap);
		
		//step 2, recursively find itinerary
		itineraryInt = new LinkedList<>();
		searchItinerary(10443, tickets.size());
		
		List<String> itineraryStr = new ArrayList<>(itineraryInt.size());
		for (Integer airportCode:itineraryInt) {
			itineraryStr.add(idToAirportMap.get(airportCode));
		}//rof
		return itineraryStr;
	}// end method
	

	/**
	 * recursively search for itinerary
	 * Precondition:
	 * - assumes ticketsLeft is positive
	 * - needed data structures are instantiated and/or populated correctly:
	 * 	ticketMap, itineraryInt
	 * @param currAirport Integer - current airport code
	 * @param ticketsLeft int 
	 * @return true if all tickets have been used up
	 */
	private boolean searchItinerary(Integer currAirport, int ticketsLeft) {
		//System.out.println("currAirport: " + currAirport + " : " + ticketsLeft);
		List<Integer> arrivalList;
		
		//base case 1: dead end
		if ((arrivalList = ticketMap.get(currAirport))==null || arrivalList.size()==0) {
			return false;
		}//fi
		
		//base case 2: 1 ticket left, itinerary is completed
		if (ticketsLeft == 1) {
			itineraryInt.add(currAirport);
			for (Integer airportID:arrivalList) {
				if (airportID==null) {
					continue;
				} else {
					itineraryInt.add(airportID);
					return true;
				}//fi
			}//rof						
		}//fi
		
		Integer currArrivalID;
		for (int i = 0; i < arrivalList.size(); i++) {
			currArrivalID = arrivalList.get(i);
			if (currArrivalID==null || (i>0 && arrivalList.get(i)==arrivalList.get(i-1))) {
				continue;
			}//fi
			arrivalList.set(i,null);
			if (searchItinerary(currArrivalID, ticketsLeft-1)) {
				itineraryInt.addFirst(currAirport);
				return true;
			}//fi
			arrivalList.set(i,currArrivalID);
		}//end rof */
		
		return false;
	}//fi

	/**
	 * Precondition:
	 * - it is assumed that airport abbreviation string consists exactly 3 abbreviation letter
	 * - airportToIDMap is instantiated
	 * - JFK is having ID code 0
	 * Postcondition:
	 * - a reverse ID to airport map is also prepared
	 * @param abbr String - airport abbreviation 
	 * @return int - non-negative int that can be used as ID code for airport and preserves lexical order 
	 */
	private static int getAirportCode(String abbr) {
		Integer storedCode = airportToIDMap.get(abbr);
		if (storedCode != null) {
			return storedCode;
		}//fi		
		int code;
		code = (abbr.charAt(0)-'@')<<10;
		code += (abbr.charAt(1)-'@')<<5;
		code += (abbr.charAt(2)-'@');
		airportToIDMap.put(abbr, code);
		idToAirportMap.put(code,abbr);
		return code;
	}//end method
}// end class