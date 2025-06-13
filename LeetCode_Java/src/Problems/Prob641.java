package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob641 {
	
	static class MyCircularDeque {
		
		Deque<Integer> deque;
		int maxSize;

	    public MyCircularDeque(int k) {
	        this.deque = new ArrayDeque<>(k);
	        this.maxSize = k;
	    }//end method
	    
	    public boolean insertFront(int value) {
	    	if (this.deque.size() == this.maxSize) {
	    		return false;
	    	}//fi
	    	this.deque.addFirst(value);
	    	return true;
	    }//end method
	    
	    public boolean insertLast(int value) {
	    	if (this.deque.size() == this.maxSize) {
	    		return false;
	    	}//fi
	    	this.deque.addLast(value);
	    	return true;	        
	    }//end method
	    
	    public boolean deleteFront() {
	    	if (this.deque.size() == 0) {
	    		return false;
	    	}//fi
	    	this.deque.removeFirst();
	    	return true;	        
	    }//end method
	    
	    public boolean deleteLast() {
	    	if (this.deque.size() == 0) {
	    		return false;
	    	}//fi
	    	this.deque.removeLast();
	    	return true;	        
	    }//end method
	    
	    public int getFront() {
	    	if (this.deque.size() == 0) {
	    		return -1;
	    	}//fi
	    	
	    	return this.deque.peekFirst();	        
	    }//end method
	    
	    public int getRear() {
	    	if (this.deque.size() == 0) {
	    		return -1;
	    	}//fi
	    	
	    	return this.deque.peekLast();	        
	    }//end method
	    
	    public boolean isEmpty() {	    		    	
	    	return this.deque.size() == 0;  
	    }//end method
	    
	    public boolean isFull() {
	    	return this.deque.size() == this.maxSize;  
	    }//end method
	}//end class

	
	

	private static void test() throws JsonMappingException, JsonProcessingException {
		
		
		int[][] inputs;
		MyCircularDeque solObj;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		inputs = objectMapper.readValue("[[3], [1], [2], [3], [4], [], [], [], [4], []]", new TypeReference<int[][]>() {});
		
		
		solObj = new MyCircularDeque(inputs[0][0]);
		System.out.println("ans: " + solObj.insertLast(inputs[1][0]));
		
		
		
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
