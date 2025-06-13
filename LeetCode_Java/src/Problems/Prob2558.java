package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2558{


	static void test() {
		

		Solution2558 solObj = new Solution2558();
		
		int[] gifts;
		int k;
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            gifts = mapper.readValue("[25,64,9,4,100]", new TypeReference<int[]>() {});
            k=4;

    		System.out.println(Arrays.toString(gifts));
    		System.out.println("ans: " + solObj.pickGifts(gifts, k));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution2558{
    public long pickGifts(int[] gifts, int k) {
    	
    	PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    	for (int gift:gifts) {
    		maxQueue.offer(gift);
    	}//rof
    	
    	int leftOver;
		for (int i=0; i<k; i++) {
			leftOver =  (int)Math.sqrt(maxQueue.poll());
			maxQueue.offer(leftOver);
		}//rof


    	long numOfGiftsRemaining = 0;
    	
    	for (int gift:maxQueue) {
    		numOfGiftsRemaining += gift;
    	}//rof

    
        return numOfGiftsRemaining;
    }
        
}// end class
