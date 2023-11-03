package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob62 {
	
	
	
	public static void test() {
			      
		Solution62 solObj = new Solution62();
		int m,n;
		
		/*
		m=2;
		n=2;
		System.out.println("m=" + m + " n=" + n + " ans: " + solObj.uniquePaths(m, n));
		
		m=3;
		n=2; //3
		System.out.println("m=" + m + " n=" + n + " ans: " + solObj.uniquePaths(m, n));	
		
		m=3;
		n=7; //28
		System.out.println("m=" + m + " n=" + n + " ans: " + solObj.uniquePaths(m, n));	
		//*/
		
		m=51;
		n=9; //28
		System.out.println("m=" + m + " n=" + n + " ans: " + solObj.uniquePaths(m, n));	
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution62 {
	
	private static int[][] uPathCountArr;
	
	static {
		uPathCountArr = new int[101][101];
		uPathCountArr[1][1]=1;
		uPathCountArr[2][1]=1;
		uPathCountArr[1][2]=1;
		uPathCountArr[2][2]=2;
	}//end static block
	
	/**
	 * precondition: 
	 * - 1 <= m, n <= 100
	 * - uPathCountArr has been instantiated
	 * @param m int num, <=100
	 * @param n int num, <=100
	 * @return number of possible unique paths
	 */
    public int uniquePaths(int m, int n) {
        if (uPathCountArr[m][n]!=0) {
        	return uPathCountArr[m][n];
        }//fi
        uPathCountArr[m][n]=0;
        if (m>1) {
        	uPathCountArr[m][n] = uniquePaths(m-1,n);
        }//fi
        if (n>1) {
        	uPathCountArr[m][n] += uniquePaths(m,n-1);
        }//fi    
    	return uPathCountArr[m][n];
    }//method        
}//end class
