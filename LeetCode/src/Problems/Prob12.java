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
	static String[] inToRoamConvArr = new String[3001];
	static {
		inToRoamConvArr[0]="";
		inToRoamConvArr[1]="I";
		inToRoamConvArr[2]="II";
		inToRoamConvArr[3]="III";
		inToRoamConvArr[4]="IV";
		inToRoamConvArr[5]="V";
		inToRoamConvArr[6]="VI";
		inToRoamConvArr[7]="VII";
		inToRoamConvArr[8]="VIII";
		inToRoamConvArr[9]="IX";
		inToRoamConvArr[10]="X";
		inToRoamConvArr[20]="XX";
		inToRoamConvArr[30]="XXX";
		inToRoamConvArr[40]="XL";
		inToRoamConvArr[50]="L";
		inToRoamConvArr[60]="LX";
		inToRoamConvArr[70]="LXX";
		inToRoamConvArr[80]="LXXX";
		inToRoamConvArr[90]="XC";
		inToRoamConvArr[100]="C";
		inToRoamConvArr[200]="CC";
		inToRoamConvArr[300]="CCC";
		inToRoamConvArr[400]="CD";
		inToRoamConvArr[500]="D";
		inToRoamConvArr[600]="DC";
		inToRoamConvArr[700]="DCC";
		inToRoamConvArr[800]="DCCC";
		inToRoamConvArr[900]="CM";
		inToRoamConvArr[1000]="M";
		inToRoamConvArr[2000]="MM";
		inToRoamConvArr[3000]="MMM";
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
    	sb.append(inToRoamConvArr[intKeys[3]]);
    	sb.append(inToRoamConvArr[intKeys[2]]);
    	sb.append(inToRoamConvArr[intKeys[1]]);
    	sb.append(inToRoamConvArr[intKeys[0]]);
        //the line below is in fact slower, compiler does not optimize to using string builder
    	//return inToRoamConvArr[intKeys[3]]+inToRoamConvArr[intKeys[2]]+inToRoamConvArr[intKeys[1]]+inToRoamConvArr[intKeys[0]];
    	
    	return sb.toString();
    }//end method
    
}//end class
