package Problems;

import java.util.*;

public class Prob3163 {
	




	public static void test() {
		Solution3163 solObj;
		String word;
		
		
	
	
		solObj = new Solution3163();
		word = "aaaaaaaaabb";
		System.out.println(" sol: " + solObj.compressedString(word) + " word: " + word);
		
	//*/
	}//end test
	
	public static void main(String[] args) {
		test();

	}

}


class Solution3163 {
	

    public String compressedString(String word) {
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
    	char prevChr = word.charAt(0);
    	char currChr;
    	
    	for (int i=0; i<word.length(); i++) {
    		currChr = word.charAt(i);
    		if (currChr == prevChr && cnt < 9) {
    			cnt++;
    		} else {
    			sb.append(cnt);
    			sb.append(prevChr);
    			prevChr = currChr;
    			cnt = 1;
    		}//fi
    	}//rof
    	
		sb.append(cnt);
		sb.append(prevChr);
        return sb.toString();
    }//end method
      
}//end class