package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob135 {
	

	
	public static void test() {

		Solution135 sol = new Solution135();
		
		int[] rating1 = {1,8,6,2,5,4,8,3,7}; //15
		int[] rating2 = {1,0,2}; //5
		int[] rating3 = {1,2,2}; //4
		int[] rating4 = {2, 2, 2, 2, 2}; //5
		int[] rating5 = {100, 50, 70, 60, 80, 90, 95, 40}; //16
		int[] rating6 = {1,2,1,2}; //6
		int[] rating7 = {5, 4, 3, 2, 1}; //15
		int[] rating8 = {1, 3, 2, 4, 1}; //7
		
		int[] rating10 = {1,5,5,5}; //5
		int[] rating11 = {1,5,5,5,4}; //7
		
		int[] rating12 = {1,2,3,4,500,50}; //16
		int[] rating13 = {1,2,3,4,500,50,49}; //18
		int[] currRating;
		
		
		currRating = rating1;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		currRating = rating2;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		
		currRating = rating3;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));

		currRating = rating4;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		currRating = rating5;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		currRating = rating6;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		
		currRating = rating7;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		currRating = rating8;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));

		currRating = rating10;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		currRating = rating11;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		
		currRating = rating12;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
		currRating = rating13;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
				//*/
		
		
		currRating = rating7;
		System.out.println(Arrays.toString(currRating) + " ans: " + sol.candy(currRating));
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution135 {
	
    public int candy(int[] ratings) {
    	//special case, ratings.length is 1
    	if (ratings.length==1) {
    		return 1;
    	}//fi
    	int totalCandies = ratings.length;
    	int lastChildWithNonIncRatingInx = 0, heightOfLastChildWithNonIncRating = 0;
    	int currExtraCandies = 0;
    	int inxGap;
    	for (int currInx = 1; currInx < ratings.length; currInx++) {
    		//System.out.println("will process inx " + currInx + " curr candies " +  totalCandies);
    		if (ratings[currInx]>ratings[currInx-1]) {
    			lastChildWithNonIncRatingInx = currInx;
    			currExtraCandies++;
    			totalCandies += currExtraCandies;
    		} else if (ratings[currInx]==ratings[currInx-1]) {
    			lastChildWithNonIncRatingInx = currInx;
    			currExtraCandies = 0;
    			heightOfLastChildWithNonIncRating = 0; 
    		} else { //ratings[currInx]<ratings[currInx-1]
    			inxGap = currInx-lastChildWithNonIncRatingInx;
    			if (inxGap == 1) {
    				heightOfLastChildWithNonIncRating = currExtraCandies;
    				currExtraCandies = 0;
    			}//fi
    			
    			totalCandies += currInx-lastChildWithNonIncRatingInx-1;
    			if (inxGap > heightOfLastChildWithNonIncRating) {
    				totalCandies++;
    			}//fi
    		} //fi
    	}//rof
        return totalCandies;
    }//end method
    
}//end class
