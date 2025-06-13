package Problems;

import java.util.*;

public class Prob2490 {
	

	
	public static void test() {

		Solution2490 sol = new Solution2490();
		String s;
		
	
		
		s = "leetcode exercises sound delightful";
		System.out.println("s=" + s);
		System.out.println("ans: " + sol.isCircularSentence(s));	
	
			//*/
		

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution2490 {
	
    public boolean isCircularSentence(String sentence) {
    	//check sentence head and tail first
    	if (sentence.charAt(0) != sentence.charAt(sentence.length()-1)) {
    		return false;
    	}//fi
    	
    	//check intermediate words
    	for (int i=1; i<sentence.length()-1; i++) {
    		if (sentence.charAt(i) != ' ') {
    			//do nothing
    		} else if (sentence.charAt(i-1) != sentence.charAt(i+1)) {
    			return false;
    		}//fi
    	}//rof
        return true;
    }//end method 
}//end class
