package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob2185{

	
	public static void main(String[] args) {
		Solution2185 solObj = new Solution2185();
		String[] words;
		String pref;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            words = mapper.readValue("[\"pay\",\"attention\",\"practice\",\"attend\"]", String[].class);
            pref = "at";
    		System.out.println("words: " + Arrays.toString(words));
    		System.out.println("Ans: " + solObj.prefixCount(words, pref));
    		
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution2185{
	
    public int prefixCount(String[] words, String pref) {
    	int cnt = 0;
    	for (String word:words) {
    		if (isPrefix(pref, word)) {
    			cnt++;
    		}
    	}//rof
    	return cnt;
    }
    
    
    /**
     * Checks if the given prefixStr is a prefix of the given compareeStr.
     * 
     * @param prefixStr - String, the string to check as prefix
     * @param compareeStr - String, the string to compare against
     * @return - boolean, true if prefixStr is a prefix of compareeStr, false otherwise
     */
    private boolean isPrefix(String prefixStr, String compareeStr) {
    	if (prefixStr.length() > compareeStr.length()) {
    		return false;
    	}//fi
    	
    	for (int i=0; i<prefixStr.length(); i++) {
    		if (prefixStr.charAt(i) != compareeStr.charAt(i)) {
    			return false;
    		}//fi
    	}//rof
    	return true;
    }//end method
}//end class

