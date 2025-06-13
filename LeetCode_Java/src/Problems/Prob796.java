package Problems;

public class Prob796 {
	

	
	public static void test() {

		Solution796 sol = new Solution796();
		String s, goal;
		
		s = "abcde";
		goal = "abced";
		System.out.println("ans: " + sol.rotateString(s, goal));		

		s = "abcde";
		goal = "cdeab";
		System.out.println("ans: " + sol.rotateString(s, goal));
	}//end method
	
	
	public static void main(String[] args) {
		test();
	}//end method
	
}

class Solution796{
	
    public boolean rotateString(String s, String goal) {
    	//edge case:
    	if (s.length() != goal.length()) {
    		return false;
    	}//fi
    	
    	char sHeadChar = s.charAt(0);
    	int goalStInx = -1;
    	while ((goalStInx = goal.indexOf(sHeadChar, goalStInx+1)) != -1) {
    		if (isMatch(s, goal, goalStInx)) {
    			return true;
    		}//fi
    		//System.out.println(goalStInx);
    	}//end while
    	
        return false;
    }//end method 
    
    /**
     * Checks if sStr can match goalStr when goalStr is rotated to start from goalStInx.
     * 
     * Precondition: sStr length is assumed to be the same as goalStr length.
     *
     * @param sStr - String, the original string to match against
     * @param goalStr - String, the rotated target string
     * @param goalStInx - int, the starting index in goalStr where the comparison begins
     * @return true if sStr matches goalStr starting from goalStInx with wrap-around; false otherwise
     */
    private boolean isMatch(String sStr, String goalStr, int goalStInx) {
    	int goalInx;
    	int sInx;;
    	for (goalInx = goalStInx, sInx = 0; goalInx < goalStr.length(); goalInx++, sInx++) {
    		if (sStr.charAt(sInx) != goalStr.charAt(goalInx)) {
    			return false;
    		}//fi
    	}//rof
    	for (goalInx = 0; goalInx < goalStInx; goalInx++, sInx++) {
    		if (sStr.charAt(sInx) != goalStr.charAt(goalInx)) {
    			return false;
    		}//fi
    	}//rof
    	return true;
    }//end method
}//end class
