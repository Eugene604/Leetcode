package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2894 {


	
	private static void test() {
		
		Solution2894 solObj = new Solution2894();
		

		int n,m;
		n = 10;
		m = 3;
		
		     
       	System.out.println("Ans: " + solObj.differenceOfSums(n,m) );		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution2894 {
	public int differenceOfSums(int n, int m) {
		
		
		
		int greatestMultiplier = Math.floorDiv(n, m);
		int total = (1+n)*n/2;
		int num2 = (m+m*greatestMultiplier) * greatestMultiplier / 2;
		//System.out.println(":num2: " + num2);
		return total-num2*2;
   }//end method
}//end class
