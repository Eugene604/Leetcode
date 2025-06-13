package Problems;

import java.util.*;

public class Prob2000 {
	




	public static void test() {
		Solution2000 solObj = new Solution2000();
		String word;
		char ch;
		
		
		
		word = "abcdefd";
		ch = 'd';
		System.out.println("str: " + solObj.reversePrefix(word, ch));
			
	}

	
	public static void test2() {
		Solution2000 solObj = new Solution2000();
		
		//solObj.test();		
	}
	
	public static void main(String[] args) {
		test();
		//test2();

	}

}


class Solution2000 {
	

    public String reversePrefix(String word, char ch) {
    	StringBuilder sb = new StringBuilder();
    	int i;
    	for (i=0; i<word.length(); i++) {
    		sb.append(word.charAt(i));
    		if (word.charAt(i) == ch) {
    			sb.reverse();
    			break;
    		}//fi    		
    	}//rof
    	
    	for (i++; i<word.length(); i++) {
    		sb.append(word.charAt(i));    		
    	}//rof
        return sb.toString();
    }//end method
}//end class
