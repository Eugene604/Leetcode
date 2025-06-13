package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2530 {


	static void test() {
		

		Solution2530 solObj = new Solution2530();
		
		int[] nums;
		int k;
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            nums = mapper.readValue("[1,10,3,3,3]", new TypeReference<int[]>() {});
            k=3;

    		System.out.println(Arrays.toString(nums));
    		System.out.println("ans: " + solObj.maxKelements(nums, k));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution2530 {
    public long maxKelements(int[] nums, int k) {
    	PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    	for (int num:nums) {
    		maxQueue.offer(num);
    	}//rof
    	long score = 0;
    	int maxNum;
    	while (k>0) {
    		//System.out.println(maxQueue);
    		maxNum = maxQueue.poll();
    		score += maxNum;
    		maxQueue.offer((int)Math.ceil((double)maxNum/3));
    		k--;
    	}//end while
    	
    	return score;
    }
        
}// end class
