package Problems;

import java.util.Arrays;

public class Prob458 {
	

	
	public static void test() {
		Solution458 solObj = new Solution458();
		int buckets, minutesToDie, minutesToTest;
		
		buckets = 8;
		minutesToDie = 1;
		minutesToTest = 2;//2
		System.out.println("sol: " + solObj.poorPigs(buckets, minutesToDie, minutesToTest) );
		
		buckets = 125;
		minutesToDie = 1;
		minutesToTest = 4;//3
		System.out.println("sol: " + solObj.poorPigs(buckets, minutesToDie, minutesToTest) );
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution458 {
	
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int round = minutesToTest/minutesToDie + 1;
		
        return (int) Math.ceil(Math.log10(buckets)/Math.log10(round));
    }//end method
    
}//end class
