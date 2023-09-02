package Problems;

public class Prob97 {
	
	private static String testStr1 = "aabcc";
	private static String testStr2 = "dbbca";
	private static String testStr3 = "aadbbcbcac";
	private static String testStr4 = "dbbca";
	private static String testStr5 = "";
	
	private static String testStr6 = "aabaac";
	private static String testStr7 = "aadaaeaaf";
	private static String testStr8 = "aadaaeaabaafaac";
	static void test() {
		Solution97 solObj = new Solution97();
		String str1, str2, str3;

		/*
		str1 = testStr1;
		str2 = testStr2;
		str3 = testStr3;
		System.out.println(" : " + "" + " result: " + solObj.isInterleave(str1, str2, str3));
		//*/
		
		str1 = testStr6;
		str2 = testStr7;
		str3 = testStr8;
		System.out.println(" : " + "" + " result: " + solObj.isInterleave(str1, str2, str3));
		
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution97 {
	boolean isDeadEnd[][];
	private String str1;
	private String str2;
	private String str3;
	
    public boolean isInterleave(String s1, String s2, String s3) {
    	//basic check
    	if (s3.length()-s2.length()-s1.length()!=0) {
    		return false;
    	} else if (s3.length()==0) {
    		return true;
    	} //fi
    	
    	this.str1 = s1;
    	this.str2 = s2;
    	this.str3 = s3;
    	isDeadEnd = new boolean[s1.length()+1][s2.length()+1];
        return isInterleave(0,0,0);
    }//end method
    
    /**
     * Preconditions: all required global variables are set / instantiated
     * - str1
     * - str2
     * - str3
     * - isDeadEnd
     * Recursively try interleave two strings and see if it can be done
     * @param str1Inx current index of string 1
     * @param str2Inx current index of string 2
     * @param str2Inx current index of string 3
     * @return true if two strings indeed can interleave and produce third string
     *
     */
    private boolean isInterleave(int str1Inx, int str2Inx, int str3Inx) {
    	if (isDeadEnd[str1Inx][str2Inx]) {
    		return false;
    	}//fi
    	
    	//base case
    	if (str1Inx == str1.length()) {
    		isDeadEnd[str1Inx][str2Inx] = !str3.regionMatches(str3Inx, str2, str2Inx, str3.length()-str3Inx);
    		return !isDeadEnd[str1Inx][str2Inx];
    	} else if (str2Inx == str2.length()){
    		isDeadEnd[str1Inx][str2Inx] = !str3.regionMatches(str3Inx, str1, str1Inx, str3.length()-str3Inx);
    		return !isDeadEnd[str1Inx][str2Inx];
    	}//fi
    	
    	if (str3.charAt(str3Inx) == str1.charAt(str1Inx) &&
    			isInterleave(str1Inx+1, str2Inx, str3Inx+1)
    			||
    			str3.charAt(str3Inx) == str2.charAt(str2Inx) &&
    			isInterleave(str1Inx, str2Inx+1, str3Inx+1)) {
    		return true;
    	}//fi
    	
    	isDeadEnd[str1Inx][str2Inx] = true;
    	return !isDeadEnd[str1Inx][str2Inx];
    }//end method
}//end class


