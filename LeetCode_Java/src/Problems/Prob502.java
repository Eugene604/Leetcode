package Problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob502 {
	

	public static void test() throws Exception{
        ObjectMapper mapper = new ObjectMapper();        
		Solution502 solObj = new Solution502();
		
		int k, w;
		int[] profits, capital ;
		
		k = 2;
		w = 0;
		profits = mapper.readValue("[1,2,3]", int[].class);
		capital = mapper.readValue("[0,1,1]", int[].class);
		System.out.println("sol: " + solObj.findMaximizedCapital(k, w, profits, capital));

	}// end method


	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test2();
	}// end method

}

class Solution502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    	//step 1, populate capital queue where each element is a [capital, profit] tuple and also populate initial profit queue
    	PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    	PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
    	for (int i=0; i<capital.length; i++) {
    		if (capital[i] <= w) {
    			profitQueue.offer(profits[i]);
    		} else {
    			capitalQueue.offer(new int[] {capital[i], profits[i]});
    		}//fi
    		
    	}//rof
    	
    
    	/*
    	 *  step 2, loop the following two steps:
    	 *  2-1. push all possible investments with capital requirement < current available capital
    	 *  2-2. retrieve the most profit item and invest it
    	 */    	
    	int currCapital = w;
    	for (; k>0; k--) {
    		while (!capitalQueue.isEmpty() && capitalQueue.peek()[0]<=currCapital) {
    			profitQueue.offer(capitalQueue.poll()[1]);
    		}//end while
    		if (!profitQueue.isEmpty()) {
    			currCapital += profitQueue.poll();
    		}//fi    		
    	}//rof
    	    	
        return currCapital;
    }// end method
}// end class


class Solution502_v2 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    	//step 1, populate capital queue where each element is a [capital, profit] tuple
    	PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));    	    	
    	for (int i=0; i<capital.length; i++) {
    		capitalQueue.offer(new int[] {capital[i], profits[i]});
    	}//rof
    	
    
    	/*
    	 *  step 2, loop the following two steps:
    	 *  2-1. push all possible investments with capital requirement < current available capital
    	 *  2-2. retrieve the most profit item and invest it
    	 */
    	PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
    	int currCapital = w;
    	for (; k>0; k--) {
    		while (!capitalQueue.isEmpty() && capitalQueue.peek()[0]<=currCapital) {
    			profitQueue.offer(capitalQueue.poll()[1]);
    		}//end while
    		if (!profitQueue.isEmpty()) {
    			currCapital += profitQueue.poll();
    		}//fi    		
    	}//rof
    	    	
        return currCapital;
    }// end method
}// end class
