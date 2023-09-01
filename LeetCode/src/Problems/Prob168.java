package Problems;

import java.util.*;

public class Prob168 {
	
	
	private static void test() {
		
		Solution168 solObj = new Solution168();
		int colNum;
		
		/*
		colNum = 1;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		
		
		colNum = 2;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		//*/
		

		
		/*
		

				colNum = 53;
System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		
		colNum = 52;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));

		colNum = 51;
System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));


		
		colNum = 676;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		//*/
		
		colNum = 28;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));

		colNum = 27;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		
		colNum = 26;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		
		colNum = 676;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));
		
		colNum = Integer.MAX_VALUE;
		System.out.println("colNum: " + colNum + " : " + solObj.convertToTitle(colNum));		
	}//fi
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution168 {
	
	private static final char[] LETTERS = {' ', 'A','B','C','D','E','F','G','H',
			'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String convertToTitle(int columnNumber) {
    	StringBuilder sb = new StringBuilder();
    	for (; columnNumber > 0; columnNumber /= 26) {
    		int remainder =  columnNumber%26;    	
    		if (remainder == 0) {
    			remainder = 26;
    		}//fi    	
			sb.append(LETTERS[remainder]);
			columnNumber-=remainder;
    	}//rof
    	
        return sb.reverse().toString();
    }//end method
}//end class
