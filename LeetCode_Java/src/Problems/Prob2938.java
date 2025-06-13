package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob2938 {


	static void test() {
		

		Solution2938 solObj = new Solution2938();
		
		String s;
    	
		s = "1100";
		System.out.println("ans: " + solObj.minimumSteps(s));
    	
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution2938 {
	
    public long minimumSteps(String s) {
    	long steps = 0;
    	
    	int misplacedZeroInx = s.length()-1;
    	int misplacedOneInx = 0;
    	
    	//step 1: find first misplaced one and zero
    	while (misplacedZeroInx >= 0 && s.charAt(misplacedZeroInx) != '0') {
			misplacedZeroInx--;
		}//end while
		//special case, no zero
    	if (misplacedZeroInx < 0) {
    		return 0;
    	}//fi
		
    	while (misplacedOneInx < s.length() && s.charAt(misplacedOneInx) != '1') {
			misplacedOneInx++;
		}//end while
		//special case, no one
    	if (misplacedOneInx == s.length()) {
    		return 0;
    	}//fi
    	
    	//System.out.println("misplacedZeroInx: " + misplacedZeroInx);
    	//System.out.println("misplacedOneInx: " + misplacedOneInx);		
		
    	//step 2: find subsequent misplaced ones and zeros
		while (misplacedZeroInx > misplacedOneInx) {
			steps += misplacedZeroInx - misplacedOneInx;	
			do {
				misplacedZeroInx--;
			} while (misplacedZeroInx > misplacedOneInx && s.charAt(misplacedZeroInx) == '1');
			
			do {
				misplacedOneInx++;
			} while (misplacedZeroInx > misplacedOneInx && s.charAt(misplacedOneInx) == '0');
		}//end while
		
        return steps;
    }//end method    

    public long minimumSteps_v2(String s) {
    	int halfLength = s.length()/2 + 1;
    	int[] misplacedZeroInxArr = new int[halfLength];
    	int[] misplacedOneInxArr = new int[halfLength];
    	int misplacedCnt;
    	
    	//step 1: populate misplaced zero indices array
    	misplacedCnt = 0;
    	for (int inx=s.length()-1; inx>0 && misplacedCnt<halfLength; inx--) {
    		if (s.charAt(inx) == '0') {
    			misplacedZeroInxArr[misplacedCnt] = inx;
    			misplacedCnt++;
    		}//fi
    	}//rof
    	
    	//step 2: populate misplaced one indices array
    	misplacedCnt = 0;
    	for (int inx=1; inx<s.length() && misplacedCnt<halfLength; inx++) {
    		if (s.charAt(inx) == '1') {
    			misplacedOneInxArr[misplacedCnt] = inx;
    			misplacedCnt++;
    		}//fi
    	}//rof

    	//System.out.println(Arrays.toString(misplacedZeroInxArr));
    	//System.out.println(Arrays.toString(misplacedOneInxArr));
    	//step 3: calculate the number of steps required to fix the misplaced characters
    	long steps = 0;
    	//special case, s.charAt(0) is also misplaced
    	int misplacedZeroInx = 0;
    	int misplacedOneInx = 0;
		if (s.charAt(0) == '1') {
			steps += misplacedZeroInxArr[misplacedZeroInx];
			misplacedZeroInx++;
		}//fi
		
		while (misplacedZeroInx < halfLength &&
				misplacedOneInx < halfLength &&
				misplacedOneInxArr[misplacedOneInx] != 0 &&
				misplacedZeroInxArr[misplacedZeroInx] > misplacedOneInxArr[misplacedOneInx]
				) {
			steps += misplacedZeroInxArr[misplacedZeroInx] - misplacedOneInxArr[misplacedOneInx];
			misplacedZeroInx++;
			misplacedOneInx++;
		}
        return steps;
    }//end method    
        
}// end class
