package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1980 {
	
	static String[] str1 = {"01","10"};
	static String[] str2 = {"00","01"};
	static String[] str3 = {"111","011","001"};
	public static void test() {
		Solution1980 sol = new Solution1980();
		String[] strs;

		strs = str1;
		System.out.println("strs " + Arrays.toString(strs) + " : " + sol.findDifferentBinaryString(strs));

		
		strs = str2;
		System.out.println("strs " + Arrays.toString(strs) + " : " + sol.findDifferentBinaryString(strs));	
		//*/	
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1980 {
	//model strings that can be returned given index 
	private static final String[] MODEL_STR = { 
			"0000000000000000", "1000000000000000", "0100000000000000", "1100000000000000", "0010000000000000",
			"1010000000000000", "0110000000000000", "1110000000000000", "0001000000000000", "1001000000000000",
			"0101000000000000", "1101000000000000", "0011000000000000", "1011000000000000", "0111000000000000",
			"1111000000000000", "0000100000000000", "1000100000000000", "0100100000000000", "1100100000000000",
			"0010100000000000", "1010100000000000", "0110100000000000", "1110100000000000", "0001100000000000",
			"1001100000000000", "0101100000000000", "1101100000000000", "0011100000000000", "1011100000000000", 
			"0111100000000000", "1111100000000000"	};	
	//binary bit position to decimal value conversion
	private static final int[] B_TO_D = {1,2,4,8,16,32};
	//number of bits to consider given lengh of string / string arr
	private static final int[] LEN_TO_BITS = {0,1,2,2,3,3,3,3,4,4,4,4,4,4,4,4,5};	
	private static int[] countArr = new int[32];

    public String findDifferentBinaryString(String[] nums) {
    	//step 1, populate count according to the left log_2_n bits where n = length of string size
    	int leftCutOff = LEN_TO_BITS[nums.length];
    	for (String numStr:nums) {
    		countArr[getNum(numStr, leftCutOff)]++;
    	}//rof
    	
    	//step 2, scan through count array and return first vacancy
    	String ansStr = "";
    	for (int i=0; i<nums.length*2; i++) {
    		if (countArr[i]==0) {
    			ansStr = MODEL_STR[i].substring(0,nums.length);
    			break;
    		}//fi
    	}//rof
    	//step 3, clean up and return answer
    	Arrays.fill(countArr,0,nums.length*2,0);
        return ansStr;
    }//end method
    
    /**
     * return the value of binary string. The value is only determined by the left most leftCutOff bits
     * @param str - String that contains binary number. length must be > leftCutOff
     * @param leftCutOff - int, number of left bits to consider
     * @return int, value of a binary string's last sigBits bits
     */
    private int getNum(String str, int leftCutOff) {
    	int val = 0;
    	for (int i=0; i<leftCutOff; i++) {
    		switch (str.charAt(i)) {
    		case '0':
    			//do nothing
    			break;
    		case '1':
    			val += B_TO_D[i];
    			break;
    		}//end switch
    	}//rof
    	return val;
    }//end getNum
}//end class
