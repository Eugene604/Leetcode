package Problems;

import java.util.Arrays;

public class Prob12 {
	

	
	public static void test() {
		Solution12 sol = new Solution12();
		int n;
		n = 0;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));
		
		n = 1;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));

		n = 3;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));
	
		n = 58;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));
		
		n = 1994;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));
		
		n = 3999;
		System.out.println("converting " + n + " : " + sol.intToRoman(n));
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution12 {
	

	static int[] intKeys = new int[4];
	static String[] inToRomanConvArr = new String[3001];
	static {
		inToRomanConvArr[0]="";
		inToRomanConvArr[1]="I";
		inToRomanConvArr[2]="II";
		inToRomanConvArr[3]="III";
		inToRomanConvArr[4]="IV";
		inToRomanConvArr[5]="V";
		inToRomanConvArr[6]="VI";
		inToRomanConvArr[7]="VII";
		inToRomanConvArr[8]="VIII";
		inToRomanConvArr[9]="IX";
		inToRomanConvArr[10]="X";
		inToRomanConvArr[20]="XX";
		inToRomanConvArr[30]="XXX";
		inToRomanConvArr[40]="XL";
		inToRomanConvArr[50]="L";
		inToRomanConvArr[60]="LX";
		inToRomanConvArr[70]="LXX";
		inToRomanConvArr[80]="LXXX";
		inToRomanConvArr[90]="XC";
		inToRomanConvArr[100]="C";
		inToRomanConvArr[200]="CC";
		inToRomanConvArr[300]="CCC";
		inToRomanConvArr[400]="CD";
		inToRomanConvArr[500]="D";
		inToRomanConvArr[600]="DC";
		inToRomanConvArr[700]="DCC";
		inToRomanConvArr[800]="DCCC";
		inToRomanConvArr[900]="CM";
		inToRomanConvArr[1000]="M";
		inToRomanConvArr[2000]="MM";
		inToRomanConvArr[3000]="MMM";
	}
	
    public String intToRoman(int num) {
    	int remainder, modulus = 10;
    	for (int i = 0; i < 4; i ++) {
    		remainder = num % modulus;
    		intKeys[i] = remainder;
    		num -= remainder;
    		modulus *= 10;
    	}//rof
    	StringBuilder sb = new StringBuilder(11);
    	sb.append(inToRomanConvArr[intKeys[3]]);
    	sb.append(inToRomanConvArr[intKeys[2]]);
    	sb.append(inToRomanConvArr[intKeys[1]]);
    	sb.append(inToRomanConvArr[intKeys[0]]);
        //the line below is in fact slower, compiler does not optimize to use string builder
    	//return inToRomanConvArr[intKeys[3]]+inToRomanConvArr[intKeys[2]]+inToRomanConvArr[intKeys[1]]+inToRomanConvArr[intKeys[0]];    	
    	return sb.toString();
    }//end method
    
}//end class
