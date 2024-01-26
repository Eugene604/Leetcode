package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1561 {
	

	
	public static void test() {

		Solution1561 sol = new Solution1561();
		
		int[] piles0  = {2,4,1,2,7,8};
		int[] piles1  = {1,8,6,2,5,4,8,3,7};
		int[] piles2  = {9,8,7,6,5,1,2,3,4};
		
		int[] piles;
		int ans;
		
		piles = piles0;
		ans = sol.maxCoins(piles);
		System.out.println("piles: " + Arrays.toString(piles));
		System.out.println("ans: " + ans);
		
		piles = piles1;
		ans = sol.maxCoins(piles);
		System.out.println("piles: " + Arrays.toString(piles));
		System.out.println("ans: " + ans);
		
		piles = piles2;
		ans = sol.maxCoins(piles);
		System.out.println("piles: " + Arrays.toString(piles));
		System.out.println("ans: " + ans);
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1561 {
	
    public int maxCoins(int[] piles) {
    	Arrays.sort(piles);
    	int numOfCoins = 0;
    	boolean skip = true;
    	for (int i=piles.length-1; i>=piles.length/3; i--) {
    		if (skip == true) {
    			skip = false;
    		} else {
    			numOfCoins += piles[i];
    			skip = true;
    		}//fi
    	}//rof
        return numOfCoins; 	 
    }//end method
    
}//end class
