package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob729 {
	
	
	static class MyCalendar {

		//map key = start time, value = end time (inclusive)
		private TreeMap<Integer, Integer> bookedEvent;

	    public MyCalendar() {
	    	bookedEvent = new TreeMap<>();	        
	    }//end constructor
	    
	    public boolean book(int start, int end) {
	    	end--; //make end time to be inclusive 
	    	
	    	//step 1: check latest event that is prior to given start time
	    	Entry<Integer, Integer> latestPriorEventEntry = bookedEvent.floorEntry(start);
	    	if (latestPriorEventEntry == null) {
	    		//do nothing
	    	} else if (latestPriorEventEntry.getKey() == start) {//start time already overlapping
	    		return false;
	    	} else if (latestPriorEventEntry.getValue() >= start){//an overlapping event found
	    		return false;
	    	}//fi 
	    	
	    	//step 2: check earliest event that is after given start time
	    	Entry<Integer, Integer> earliestLaterEventEntry = bookedEvent.higherEntry(start);
	    	if (earliestLaterEventEntry == null) {
	    		//do nothing
	    	} else if (earliestLaterEventEntry.getKey() <= end) {//an overlapping event found
	    		return false;	    	
	    	}//fi 	    	
	    	
	    	bookedEvent.put(start, end);	    	
	        return true;
	    }//end method
	}

	private static void test() throws JsonMappingException, JsonProcessingException {
		
		
		int[][] inputs;
		MyCalendar calObj = new MyCalendar();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		inputs = objectMapper.readValue("[[], [10, 20], [15, 25], [20, 30]]", new TypeReference<int[][]>() {});
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
