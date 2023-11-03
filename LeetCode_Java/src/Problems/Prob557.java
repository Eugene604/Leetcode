package Problems;

import java.util.*;

public class Prob557 {
	




	public static void test() {
		Solution557 solObj;
		String str;
		
	

		solObj = new Solution557();
		str = "Let's take LeetCode contest";
		System.out.println("str: " + str + " sol: " + solObj.reverseWords(str));	
		
		
		//*/

			
	}

	
	public static void test2() {
		Solution557 solObj = new Solution557();
		
		//solObj.test();		
	}
	
	public static void main(String[] args) {
		test();
		//test2();

	}

}


class Solution557 {
	
	
    public String reverseWords(String s) {
    	String[] words = s.split(" ");
    	StringBuilder primarySb = new StringBuilder();
    	char[] wordArr;
    	for (String word:words) {
    		wordArr = word.toCharArray();
    		for (int i=wordArr.length-1; i>=0; i--) {
    			primarySb.append(word.charAt(i));
    		}//rof
    		primarySb.append(' ');
    	}//rof
    	primarySb.deleteCharAt(s.length());
        return primarySb.toString();
    }//end method
}//end class

