package Problems;

import java.util.*;

public class Prob242{
	

	
	public static void test() {

		Solution242 sol = new Solution242();
		String s, t;
		
	
		
		s = "axc"; 
		t = "ahbgdc";
		System.out.println("ans: " + sol.isAnagram(s,t));
		
		s = "abc"; 
		t = "ahbgdc";
		System.out.println("ans: " + sol.isAnagram(s,t));

		s = ""; 
		t = "";
		System.out.println("ans: " + sol.isAnagram(s,t));
			//*/
		

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution242{
	int[] sCharCnt = new int[123];

	
    public boolean isAnagram(String s, String t) {
    	//special case, s t have different length
    	if (s.length() != t.length()) {
    		return false;
    	}//fi
    	
    	//step 1, populate char count for s    	
    	for (char sc:s.toCharArray()) {
    		sCharCnt[sc]++;
    	}//rof
    	
    	
    	//step 2, check chars from t
    	int ans = 0; //0 = need to be determined, 2 = false
    	for (char tc:t.toCharArray()) {
    		sCharCnt[tc]--;
    		if (sCharCnt[tc]<0) {
    			ans = 2;    			
    			break;
    		}//fi
    	}//rof
    	
    	//step 3, scan the character count array and also clean up
    	if (ans == 2) {
    		Arrays.fill(sCharCnt, 97, 123, 0);
    		return false;
    	} else {
    		int i;
    		for (i=97; i<123; i++) {
    			if (sCharCnt[i]!=0) {
    				Arrays.fill(sCharCnt, i, 123, 0);
    		        return false;
    			}//fi
    		}//rof
    		return true;
    	}//fi

    }//end method
    
}//end class
