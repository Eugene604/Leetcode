package Problems;

public class Prob6 {
	
	public static String str1 = "PAYPALISHIRING";
	public static String str2 = "bbbbb";
	public static String str3 = "pwwkew";
	public static String str4 = "abcdaefghijlk";
	public static String str5 = "b";
	public static String str6 = "";	
	public static String str7 = "abcdaefghijlkmno";
	public static String str8 = "abcdefghijlkmnopq";
	
	
	public static void test() {
		Solution6 sol = new Solution6();
		int row;
		String str;
		str = str1;
		row = 4;
		System.out.println(str + " : " + row + " : " + sol .convert(str, row));
		str = str5;
		row = 3;
		System.out.println(str + " : " + row + " : " + sol .convert(str, row));
		
	}
	
	public static void main(String[] args) {
		test();
	}

}

class Solution6 {
		
    public String convert(String str, int numRows) {
    	int strL = str.length();
    	if (strL < 2 || numRows == 1 || strL == numRows) {
    		return str;
    	}
    	    	
    	byte[] strArr = str.getBytes();
    	byte[] ansArr = new byte[strL];
    	int hGap = 2*numRows-2; //horizontal index gap
    	int currAnsInx = 0; //current available answer array's index
    	int ocInx = 0, ecInx; //odd column index, even column index
    	
    	//first step - populate first row which lacks even column numbers
    	while (ocInx < strL) {
    		//System.out.print((char)strArr[ocInx] + " ");
    		ansArr[currAnsInx] = strArr[ocInx];
    		currAnsInx++;
    		ocInx += hGap;
    	}
    	//System.out.println();    	
    	//second step, populate rows that contain even column indices
    	for (int r = 1; r < numRows-1; r++) {
        	ocInx = r;
        	ecInx = 2*numRows - r - 2; //numRows - 1 + (numRows - 1 - r)
        	while (ocInx < strL) {
        		//System.out.print((char)strArr[ocInx]);
        		ansArr[currAnsInx] = strArr[ocInx];
        		currAnsInx++;
        		//also check for neighboring even column cell and pre-calculate next even column index
        		if (ecInx < strL) {
        			ansArr[currAnsInx] = strArr[ecInx];
        			//System.out.print((char)strArr[ecInx]);
        			ecInx += hGap;
            		currAnsInx++;
        		} else {
        			break;
        		}
        		ocInx += hGap;
        	}
        	//System.out.println(); 
    	}
    	
    	//third step - populate last row which lacks even column indices
    	ocInx = numRows-1;
    	while (ocInx < strL) {
    		//System.out.print((char)strArr[ocInx] + " ");
    		ansArr[currAnsInx] = strArr[ocInx];
    		currAnsInx++;
    		ocInx += hGap;
    	}
    	//System.out.println(); 
        return new String(ansArr);
    }
}
