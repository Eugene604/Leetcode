package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob731 {
	
	
	static class MyCalendarTwo {

		//map key = start time, value = end time (inclusive)
		private TreeMap<Integer, Integer> singleBookedEvent;
		private TreeMap<Integer, Integer> dblBookedEvent;

	    public MyCalendarTwo() {
	    	singleBookedEvent = new TreeMap<>();	
	    	dblBookedEvent = new TreeMap<>();
	    }//end constructor
	    
	    public boolean book(int start, int end) {
	    	end--; //make end time to be inclusive 
	    	
	    	//step 1: check if there's double booked event that is same as given start time
	    	if (dblBookedEvent.containsKey(start)) {
	    		return false;
	    	}//fi
	    	
	    	//step 2: check two closest events that are neighboring to given start time
	    	Entry<Integer, Integer> lowerPriorDBEventEntry = dblBookedEvent.lowerEntry(start);
	    	if (lowerPriorDBEventEntry != null && lowerPriorDBEventEntry.getValue() >= start){
	    		//a triple overlapping time slot found
	    		return false;
	    	}//fi 
	    		    	
	    	Entry<Integer, Integer> higherDBEventEntry = dblBookedEvent.higherEntry(start);
	    	if (higherDBEventEntry != null && higherDBEventEntry.getKey() <= end) {
	    		//a triple overlapping time slot found
	    		return false;	    	
	    	}//fi 	    	
	    	
    		/* 
    		 * step 3: at this point, we know that no double booked event crossed with new event
    		 * At this step we check for strict prior (lower) event. 
    		 * time line:
    		 * [existing event]
    		 *  <- gap ->   [new event]
    		 * 
    		 */	    	
	    	Entry<Integer, Integer> lowerSingleEventEntry = singleBookedEvent.lowerEntry(start);
	    	if (lowerSingleEventEntry != null && lowerSingleEventEntry.getValue() >= start) {
	    		/*
	    		 * there is overlap
	    		 * time line:
	    		 * [--existing event--?
	    		 *     [--new event ------?
	    		 * 
	    		 * this case means existing event starts prior to new event hence there's gap in front
	    		 * break this existing events into two and get ready for step 4
	    		 */
    			singleBookedEvent.put(lowerSingleEventEntry.getKey(),start-1);
    			singleBookedEvent.put(start, lowerSingleEventEntry.getValue());
    		}//fi
	    			    		
	    			    		
	    	
	    	/*
	    	 * step 4: now, if overlaps, existing event is either starting at same or later than new event
	    	 * 
    		 * time line:
    		 * [--new event--?
    		 *     [--existing event ------?
    		 *     
	    	 */
	    	Entry<Integer, Integer> ceilingSingleEventEntry;
	    	while (true) {
	    		ceilingSingleEventEntry = singleBookedEvent.ceilingEntry(start);
	    		if (ceilingSingleEventEntry == null || ceilingSingleEventEntry.getKey() > end) {
	    			singleBookedEvent.put(start, end);
	    			return true;
	    		} else if (ceilingSingleEventEntry.getKey() != start) {
		    		/*
		    		 * step 4-1: handle gap in the front, this gap should be stored in single event
		    		 * time line:
		    		 * [--new event--?
		    		 *  <-gap->    [-- existing event ------?
		    		 * 
		    		 * this case means new event starts prior to existing event hence there's gap in front
		    		 * 
		    		 */
	    			singleBookedEvent.put(start, ceilingSingleEventEntry.getKey()-1);
	    			start = ceilingSingleEventEntry.getKey();	    			
	    		}//fi
	    		
	    		

    			/*
	    		 * step 4-2: at this point, both new and existing events start at same time
	    		 * 
	    		 * time line:
	    		 * [--new event ------?
	    		 * [--existing event--?	   
	    		 * 
	    		 */
		    	singleBookedEvent.remove(ceilingSingleEventEntry.getKey());
	    		if (ceilingSingleEventEntry.getValue() == end) {
		    		/*
		    		 * time line:
		    		 * [----new event-----]
		    		 * [--existing event--]
		    		 * 
		    		 * this means both start times and end times are all equal
		    		 */
	    			dblBookedEvent.put(start, end);	    			
	    			return true;	    			
	    		} else if (ceilingSingleEventEntry.getValue() > end) {
		    		/*
		    		 * time line:
		    		 * [--new event ----]
		    		 * [--existing event-----]
		    		 * 
		    		 * this means existing event ends later. 
		    		 * The gap will be recorded as single booked event
		    		 */
	    			dblBookedEvent.put(start, end);
	    			singleBookedEvent.put(end+1, ceilingSingleEventEntry.getValue());
	    			return true;		    			
	    		} else {
		    		/*
		    		 * time line:
		    		 * [--new event ----------]
		    		 * [--existing event--]
		    		 * 
		    		 * 
		    		 * this means new event ends later. 
		    		 * The gap will be further evaluated
		    		 */
	    			dblBookedEvent.put(start, ceilingSingleEventEntry.getValue());
	    			start = ceilingSingleEventEntry.getValue()+1;
	    		}//fi
    		
    		}//end while
	    	    	    	
	    }//end method
	    
	    
	}//end class
	
	

	private static void test() throws JsonMappingException, JsonProcessingException {
		
		
		int[][] inputs;
		MyCalendarTwo calObj = new MyCalendarTwo();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		inputs = objectMapper.readValue("[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]", new TypeReference<int[][]>() {});
		for (int i=1; i<inputs.length; i++) {
			System.out.println("insert: " + Arrays.toString(inputs[i]));
			System.out.println("ans: " + calObj.book(inputs[i][0],  inputs[i][1]));
		}//rof
		
		
		/*
		
		//*/


	}//end method

	public static void main(String[] args) {
		try {
			test();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
