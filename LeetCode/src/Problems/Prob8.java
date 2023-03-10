package Problems;



public class Prob8 {
	public static void test() {

		Solution8 sol = new Solution8();
		String testText;
		
		testText = "1234";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "-1234";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "   1234";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "-1234aafewc";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "  123.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "  +248.9fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText)); 
		testText = "  12345978901.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "  -12345978901.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));		
		testText = "  2147483647.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "  2147483648.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  -2147483647.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  -2147483648fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  -2147483649fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  0000000000012345678fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));
		testText = "  -0000000000012345678fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  -0000.0fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = "  0000.0fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));			
		testText = "    ";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));		
		testText = " -";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = " +";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		testText = " fewwef";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	//*/	
		testText = "  -2147483647.4fjewop";
		System.out.println(testText + " is parsed to be " + sol.myAtoi(testText));	
		
	}//end method
	
	public static void main(String[] args) {
		test();
	}
}

class Solution8 {
	
    public int myAtoi(String str) {
    	byte[] strByteArr = str.getBytes();
    	boolean isPositive = true;
    	int currInx = 0;
    	int startInx, endInx;
    	int arrLength = str.length();
    	int val = 0;
    	//special case
    	if (arrLength == 0) {
    		return 0;
    	}
    	//phase 1,  skip white space
    	while (strByteArr[currInx] == 32) {
        	if (++currInx == arrLength) {
        		return 0;
        	}//fi
    	}//end while

    	
    	//phase 2, determine sign, if any
    	if (strByteArr[currInx] == 45) {
    		isPositive = false;
        	if (++currInx == arrLength) {
        		return 0;
        	}//fi
    	} else if (strByteArr[currInx] == 43) {
        	if (++currInx == arrLength) {
        		return 0;
        	}//fi
    	} else if (strByteArr[currInx] < 48 || strByteArr[currInx] > 57) {
    		return val;
    	}
    	
    	//phase 3, skip leading 0s
    	while (strByteArr[currInx] == 48) {
        	if (++currInx == arrLength) {
        		return 0;
        	}//fi
    	}//end while
    	startInx = currInx;
    	
    	//phase 4, parse the number
    	for (; currInx < arrLength && strByteArr[currInx] >=48 && strByteArr[currInx] <= 57; currInx++) {}
    	endInx = currInx-1;
    	int currPwr = endInx - startInx;
    	if (currPwr > 9) {
    		val = 1;
        	if (isPositive) {
        		return Integer.MAX_VALUE;
        	} else {
        		return Integer.MIN_VALUE;
        	}//fi
    	} else if (currPwr == 9) {
    		long longVal = 0;
        	for (currInx = startInx; currInx <= endInx; currInx++) {
        		currPwr = endInx - currInx;
        		longVal += (strByteArr[currInx]-48)*Math.pow(10, currPwr);
        		if (isPositive && longVal > Integer.MAX_VALUE) {
        			return Integer.MAX_VALUE;
        		} else if (!isPositive && longVal-1 > Integer.MAX_VALUE) {
        			return Integer.MIN_VALUE;
        		}//fi
        	}//rof
        	if (isPositive) {
        		return (int)longVal;
        	} else {
        		return (int)longVal * -1;
        	}//fi
    	}//fi
    	
    	/*
    	for (currInx = startInx; currInx <= endInx; currInx++) {
    		currPwr = endInx - currInx;
    		val += (strByteArr[currInx]-48)*Math.pow(10, currPwr);
    	}//rof */
    	
    	for (currInx = startInx; currInx <= endInx; currInx++) {
    		val = val*10+strByteArr[currInx]-48;
    	}//rof
    	
    	//System.out.println( " end");
    	if (isPositive) {
    		return val;
    	} else {
    		return val * -1;
    	}
    }//end method
}//end class