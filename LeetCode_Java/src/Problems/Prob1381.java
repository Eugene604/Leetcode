package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1381 {
	
	static class CustomStack {
		
		int maxSize;
		int[] stkArr;
		int currAvailInx;
		
	    public CustomStack(int maxSize) {
	        this.maxSize = maxSize;
	        stkArr = new int[maxSize];
	        currAvailInx = 0;
	    }//end constructor
	    
	    public void push(int x) {
	        if (currAvailInx < maxSize) {
	        	stkArr[currAvailInx] = x;
	        	currAvailInx++;
	        }//fi	        
	    }//end method
	    
	    public int pop() {
	        if (currAvailInx > 0) {	        	
	        	currAvailInx--;
	        	return stkArr[currAvailInx];
	        } else {
	        	return -1;
	        }//fi
	    }//end method
	    
	    public void increment(int k, int val) {
	        int inxUpperBound = Math.min(currAvailInx-1, k-1);
	        for (int i=0; i<=inxUpperBound; i++) {
	        	stkArr[i] += val;
	        }//rof
	    }//end method
	    
	    public void printContent() {
	    	//System.out.println(Arrays.toString(null));
	    }
	}//end class

	
	

	private static void test() throws JsonMappingException, JsonProcessingException {
		
		
		String[][] inputs;
		CustomStack solObj;
		
		
		solObj = new CustomStack(3);
		
		
		
		
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
