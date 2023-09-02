package Problems;

import java.math.BigInteger;
import java.util.*;

public class Prob43 {
	

	
	public static void test() {

		Solution43 solObj = new Solution43();
		String num1, num2;
		BigInteger num1BigInt, num2BigInt, ansBigInt;
		String msg;
	
		
		num1="0";
		num2="0";
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		msg = "num1=" + num1 + " num2=" + num2 + " ans: " + solObj.multiply(num1, num2);
		System.out.println(msg);
		System.out.println("real ans: " + ansBigInt.toString());
		
		/*
		num1="123";
		num2="456";
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		msg = "num1=" + num1 + " num2=" + num2 + " ans: " + solObj.multiply(num1, num2);
		System.out.println(msg);
		System.out.println("real ans: " + ansBigInt.toString());		

	
		num1="9999";
		num2="2222";
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		msg = "num1=" + num1 + " num2=" + num2 + " ans: " + solObj.multiply(num1, num2);
		System.out.println(msg);
		System.out.println("real ans: " + ansBigInt.toString());
		
		num1="7785327893427963422";
		num2="37483287243789923874";
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		msg = "num1=" + num1 + " num2=" + num2 + " ans: " + solObj.multiply(num1, num2);
		System.out.println(msg);
		System.out.println("real ans: " + ansBigInt.toString());
		
		
		num1="10";
		num2="10";
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		msg = "num1=" + num1 + " num2=" + num2 + " ans: " + solObj.multiply(num1, num2);
		System.out.println(msg);
		System.out.println("real ans: " + ansBigInt.toString());
		//*/
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
    private static String getCorrectAns(String num1, String num2) {
    	String correctAns;
    	BigInteger num1BigInt, num2BigInt, ansBigInt;
		num1BigInt = new BigInteger(num1);
		num2BigInt = new BigInteger(num2);
		ansBigInt = num1BigInt.multiply(num2BigInt);
		correctAns = ansBigInt.toString();
    	return correctAns;
    }//end method
}

class Solution43 {

    public String multiply(String num1, String num2) {
    	
    	//special case
    	if (num1.equals("0") || num2.equals("0")) {
    		return "0";
    	}//fi

		int[] multiplierArr = new int[num1.length()];
		int[] multiplicandArr = new int[num2.length()];
		int[] productArr = new int[num1.length() + num2.length()];
		
		//convert ascii to actual number value
		for (int i=0; i<multiplierArr.length; i++) {
			multiplierArr[multiplierArr.length-i-1] = num1.charAt(i)-'0';
		}//rof
		for (int i=0; i<multiplicandArr.length; i++) {
			multiplicandArr[multiplicandArr.length-i-1] = num2.charAt(i)-'0';
		}//rof
		
		//System.out.println("multiplierArr: " + Arrays.toString(multiplierArr));
		//System.out.println("multiplicandArr: " + Arrays.toString(multiplicandArr));
		
		//do multiplication by ignoring carry-overs
		for (int j=0; j<multiplicandArr.length; j++) {
			for (int i=0; i<multiplierArr.length; i++) {
				productArr[i+j] += multiplierArr[i]*multiplicandArr[j];
			}//rof
		}//rof
		//System.out.println("productArr: " + Arrays.toString(productArr));
		
		//perform carry-overs
		int carryover=0;
		for (int i=0; i<productArr.length; i++) {
			productArr[i] = productArr[i]+carryover;
			carryover = productArr[i]/10;
			productArr[i] %= 10;
		}//rof
		//System.out.println("productArr: " + Arrays.toString(productArr));
		
		//build resulting string
		StringBuilder sb = new StringBuilder();
		int pArrInx;
		for (pArrInx = productArr.length-1;productArr[pArrInx]==0;pArrInx--) {}
		for (;pArrInx>=0;pArrInx--) {
			sb.append((char)(productArr[pArrInx]+48));
		}//rof
		return sb.toString();
    }//end method 
    

}//end class
