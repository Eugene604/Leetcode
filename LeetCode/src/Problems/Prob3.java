package Problems;

import java.util.*;

public class Prob3 {
	
	public static String str1 = "abcabcbb";
	public static String str2 = "bbbbb";
	public static String str3 = "pwwkew";
	public static String str4 = "abcdaefghijlk";
	public static String str5 = "b";
	public static String str6 = "";	
	public static String str7 = "abcdaefghijlkmno";
	public static String str8 = "abcdefghijlkmnopq";
	
	
	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int count;
		/*//*/
		count = sol.lengthOfLongestSubstring(str1);
		System.out.println("Solution: " + count);
		count = sol.lengthOfLongestSubstring(str2);
		System.out.println("Solution: " + count);
		count = sol.lengthOfLongestSubstring(str3);
		System.out.println("Solution: " + count); 
		count = sol.lengthOfLongestSubstring(str4); 
		System.out.println("Solution: " + count);		
		count = sol.lengthOfLongestSubstring(str5);
		System.out.println("Solution: " + count);
		count = sol.lengthOfLongestSubstring(str6);
		System.out.println("Solution: " + count);		
		count = sol.lengthOfLongestSubstring(str7);
		System.out.println("Solution: " + count);		
		count = sol.lengthOfLongestSubstring(str8);
		System.out.println("Solution: " + count);
	}

}

class Solution3 {
		
    public int lengthOfLongestSubstring(String s) {
		//System.out.println("processing: " + s);
    	int tmpLength, currMaxLangth = 0 ;
    	int currLowerPos, currUpperPos;
    	Integer charInx;
    	Map<Character, Integer> charPosMap = new HashMap<>();
    	for (currLowerPos = currUpperPos = 0; currUpperPos < s.length(); currUpperPos++) {
    		charInx = charPosMap.get(s.charAt(currUpperPos));
    		if (charInx == null || charInx < currLowerPos) {//no such char encountered or such char encountered before but outside of index lower bound
    			charPosMap.put(s.charAt(currUpperPos), currUpperPos); //update index 
    		} else {//such char encountered before and is within index lower bound
    			tmpLength = currUpperPos-currLowerPos;
    			if (tmpLength > currMaxLangth) {
    				currMaxLangth = tmpLength;
    			}//fi
    			currLowerPos = charInx+1;
    			charPosMap.put(s.charAt(currUpperPos), currUpperPos);    			
    		}
    	}
    	
    	
    	if(currUpperPos == 0 || currLowerPos == 0) { //special cases : 0 length string or entire string's characters are all unique
    		return s.length();
    	} else {//special case: the final iteration 
			tmpLength = currUpperPos-currLowerPos;
			if (tmpLength > currMaxLangth) {
				currMaxLangth = tmpLength;
			}//fi		
    	}//fi
		return currMaxLangth;
        
    }
}
