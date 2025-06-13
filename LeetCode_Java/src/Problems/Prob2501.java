package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2501 {


	
	private static void test() {
		
		Solution2501 solObj = new Solution2501();
		int[] nums;

		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            nums =  mapper.readValue("[2,49,3,5,7,2401]", int[].class);

    		System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("Ans: " + solObj.longestSquareStreak(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2501 {
	static final int MAX_NUM = 100_000;
	static final boolean[] IS_ELIGIBLE = new boolean[MAX_NUM+1];
	static {
		long sqNum;
		for (int num=2; num<=Math.floor(Math.sqrt(MAX_NUM)); num++) {
			if (IS_ELIGIBLE[num]) {//already determined
				continue;
			}//fi
			
			sqNum = num;
			while (sqNum <= MAX_NUM) {
				IS_ELIGIBLE[(int)sqNum] = true;
				sqNum *=sqNum;
			}//end while			
		}//rof
	}//end static 
	
    public int longestSquareStreak(int[] nums) {
    	    	
    	boolean[] isPresent = new boolean[MAX_NUM+1];    
    	for (int num:nums) {
    		if (!IS_ELIGIBLE[num]) {
    			continue; // not someone's square, and itself is too large, there's no streak
    		} else {
    			isPresent[num] = true;
    		}//fi    		    		
    	}//rof
    	int maxStreak = 0;
    	int currStreak;
    	long currNum;
		for (int num=2; num<=Math.floor(Math.sqrt(MAX_NUM)); num++) {
			currStreak = 0;
			currNum = num;
			while (currNum <= MAX_NUM && isPresent[(int)currNum]) {
				currNum *= currNum;
				currStreak++;
			}//end while
			maxStreak = Math.max(maxStreak, currStreak);		
		}//rof
        return (maxStreak>1)? maxStreak : -1;
    }//end method
}//end class


class Solution2501_v2 {
	static final int MAX_NUM = 100_000;
	static final boolean[] IS_ELIGIBLE = new boolean[MAX_NUM+1];
	static {
		long sqNum;
		for (int num=2; num<=Math.floor(Math.sqrt(MAX_NUM)); num++) {
			if (IS_ELIGIBLE[num]) {//already determined
				continue;
			}//fi
			
			sqNum = num;
			while (sqNum <= MAX_NUM) {
				IS_ELIGIBLE[(int)sqNum] = true;
				sqNum *=sqNum;
			}//end while			
		}//rof
	}//end static 
	
    public int longestSquareStreak(int[] nums) {
    	    	
    	Set<Integer> candidateSet = new HashSet<>();
    	PriorityQueue<Integer> candidateMinQueue = new PriorityQueue<>();
    	for (int num:nums) {
    		if (!IS_ELIGIBLE[num]) {
    			continue; // not someone's square, and itself is too large, there's no streak
    		} else {
    			candidateSet.add(num);
    			candidateMinQueue.offer(num);
    		}//fi    		    		
    	}//rof
    	int maxStreak = 0;
    	int currStreak;
    	Integer currNum;
    	while (candidateMinQueue.size()>0 && candidateSet.size()>0) {
    		currNum = candidateMinQueue.poll();
    		currStreak = 0;
    		while (candidateSet.remove(currNum)) {
    			currNum *= currNum;
    			currStreak++;
    		}//end while
    		maxStreak = Math.max(maxStreak, currStreak);
    	}//end while
        return (maxStreak>1)? maxStreak : -1;
    }//end method
}//end class