package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob3042 {

	
	public static void main(String[] args) {
		Solution3042 solObj = new Solution3042();
		String[] words;

		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            words = mapper.readValue("[\"a\",\"aba\",\"ababa\",\"aa\"]", String[].class);
    		System.out.println("words: " + Arrays.toString(words));
    		System.out.println("Ans: " + solObj.countPrefixSuffixPairs(words));
    		 /*
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution3042 {
	
    public int countPrefixSuffixPairs(String[] words) {
    	int cnt = 0;
    	for (int i=0; i<words.length-1; i++) {
    		for (int j=i+1; j<words.length; j++) {
    			if (isPrefixAndSuffix(words[i], words[j])) {
    				cnt++;
    			}
    		}
    	}
    	return cnt;
    }
    
    /**
     * Checks if the given borderStr is both a prefix and a suffix of the given compareeStr.
     * 
     * @param borderStr - String, the string to check as both prefix and suffix
     * @param compareeStr - String, the string to compare against
     * @return - boolean, true if borderStr is both a prefix and a suffix of compareeStr, false otherwise
     */
    private boolean isPrefixAndSuffix(String borderStr, String compareeStr) {
    	int borderStrLastInx = borderStr.length()-1;
    	int compareeStrLastInx = compareeStr.length()-1;
    	if (borderStrLastInx > compareeStrLastInx) {
    		return false;
    	}//fi
    	
    	for (int i=0; i<=borderStrLastInx; i++) {
    		if (borderStr.charAt(i) != compareeStr.charAt(i)) {
    			return false;
    		}//fi
    		
    		if (borderStr.charAt(borderStrLastInx-i) != compareeStr.charAt(compareeStrLastInx-i)) {
    			return false;
    		}//fi
    	}//rof
    	return true;
    }//end method
}//end class

