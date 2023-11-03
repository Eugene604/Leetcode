package Problems;

import java.util.*;

public class Prob389 {
	

	
	public static void test() {

		Solution389 sol = new Solution389();
		String s, t;
		
	
		
		s = "axc"; 
		t = "ahbgdc";
		System.out.println("ans: " + sol.isSubsequence(s,t));
		
		s = "abc"; 
		t = "ahbgdc";
		System.out.println("ans: " + sol.isSubsequence(s,t));

		s = ""; 
		t = "";
		System.out.println("ans: " + sol.isSubsequence(s,t));
			//*/
		

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution389 {
	
    public boolean isSubsequence(String s, String t) {
    	//special case, s is empty
    	if (s.length()==0) {
    		return true;
    	}//fi
    	char[] scCharArr = s.toCharArray();
    	int scLastInx = s.length()-1;
    	int currSCInx = 0;
    	for (char currTChar:t.toCharArray()) {
    		if (scCharArr[currSCInx]!=currTChar) {
    			continue;   			
    		} else if (currSCInx==scLastInx) {    			
    			return true;
    		} else {
    			currSCInx++;
    		}//fi
    	}//rof
        return false;
    }//end method
    
}//end class
