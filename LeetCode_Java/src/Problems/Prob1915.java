package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
//review
public class Prob1915 {


	
	private static void test() {
		
		Solution1915 solObj = new Solution1915();
		
		CorrectSolution1915 correctSolObj = new CorrectSolution1915();

		String word;

		/*
		word = "aba";
      	System.out.println("Arr: " + word);
       	System.out.println("Ans: " + solObj.wonderfulSubstrings(word));

		word = "aabb";
      	System.out.println("Arr: " + word);
       	System.out.println("Ans: " + solObj.wonderfulSubstrings(word));
		
		word = "he";
      	System.out.println("Arr: " + word);
       	System.out.println("Ans: " + solObj.wonderfulSubstrings(word));		
		//*/

		word = "aab";
      	System.out.println("Arr: " + word);
       	System.out.println("Ans: " + solObj.wonderfulSubstrings(word));
     	System.out.println("Correct Ans: " + correctSolObj.wonderfulSubstrings(word));		

	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1915 {
	static long[] wsCount = new long[1024];
	static final int[] CHAR_MASK; 
	static {
		CHAR_MASK = new int[123];		
		CHAR_MASK[97]=0b0000000001;
		CHAR_MASK[98]=0b0000000010;
		CHAR_MASK[99]=0b0000000100;
		CHAR_MASK[100]=0b0000001000;
		CHAR_MASK[101]=0b0000010000;
		CHAR_MASK[102]=0b0000100000;
		CHAR_MASK[103]=0b0001000000;
		CHAR_MASK[104]=0b0010000000;
		CHAR_MASK[105]=0b0100000000;
		CHAR_MASK[106]=0b1000000000;
	}//end static	
    public long wonderfulSubstrings(String word) {    	
    	Arrays.fill(wsCount, 0);
    	wsCount[0] = 1;
    	long numOfWS = 0;
    	int prefixXor = 0;
    	for (int i=0; i<word.length(); i++) {
    		prefixXor ^= CHAR_MASK[word.charAt(i)];
    		numOfWS += wsCount[prefixXor];
    		for (int maskInx = 97; maskInx <= 106; maskInx++) {
    			numOfWS += wsCount[prefixXor ^ CHAR_MASK[maskInx]];
    		}//rof
    		wsCount[prefixXor]++;
    	}//rof
    	//System.out.println(Arrays.toString(wsCount));
        return numOfWS;
    }//end method
    
 
}//end class


class CorrectSolution1915 {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024]; // 2^10 to store XOR values
        long result = 0;
        int prefixXor = 0;
        count[prefixXor] = 1;

        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            prefixXor ^= 1 << charIndex;
            //System.out.println("prefixXor: " + Integer.toBinaryString(prefixXor));
            result += count[prefixXor];
            for (int i = 0; i < 10; i++) {
                result += count[prefixXor ^ (1 << i)];
            }
            count[prefixXor]++;
        }
    	System.out.println(Arrays.toString(count));
        return result;
    }
    
    public long wonderfulSubstrings_v2(String word) {
        long[] count = new long[1024]; // count[state] stores how many times the state occurs
        count[0] = 1; // empty string gives case where all characters occur even number of times
        int mask = 0; // current state
        long ans = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            mask ^= 1 << idx; // update state
            ans += count[mask]; // add count of same previous states
            for (int i = 0; i < 10; i++) {
                int lookFor = mask ^ (1 << i); // try flick each switch
                ans += count[lookFor];
            }
            count[mask]++; // add 1 to count of times we've seen current state
        }
        return ans;
    }
}


class Solution1915_v2 {
	static int[] baseCharCnt = new int[123];
	static int[] sWndCharCnt = new int[123];
	static final int MIN_CHAR_INX = 97;
	static final int MAX_CHAR_INX = 106;
    public long wonderfulSubstrings(String word) {    	
    	Arrays.fill(baseCharCnt, MIN_CHAR_INX, MAX_CHAR_INX+1, 0);
    	long numOfWS = word.length(); //individual characters are guaranteed to be wonderful substring
    	baseCharCnt[word.charAt(0)]++;
    	for (int len=2; len<=word.length(); len++) {
    		baseCharCnt[word.charAt(len-1)]++;
    		sWndCharCnt = Arrays.copyOf(baseCharCnt, 123);
    		//System.out.println("outer charCnt WS? " + isWS(charCnt));
    		numOfWS += isWS(sWndCharCnt) ? 1 : 0;
    		for (int beginInx=1; beginInx<=word.length()-len; beginInx++) {
    			sWndCharCnt[word.charAt(beginInx-1)]--;
    			sWndCharCnt[word.charAt(beginInx+len-1)]++;
    	    	//System.out.println("charCnt WS? " + isWS(charCnt));
    			numOfWS += isWS(sWndCharCnt) ? 1 : 0;
    		}//rof    		
    	}//rof
        return numOfWS;
    }//end method
    
    /**
     * precondition:
     * MIN_CHAR_INX and MAX_CHAR_INX boundary flags are set
     * @param charCnt - int[]
     * @return true if character counts satisfy wonderful substring
     */
    private boolean isWS(int[] charCnt) {

    	int numOfOdds=0;
    	for (int i = MIN_CHAR_INX; i<= MAX_CHAR_INX; i++) {
    		numOfOdds += (charCnt[i]%2==0)?0:1;
    	}//fi
    	return numOfOdds < 2;
    }//end method
}//end class


