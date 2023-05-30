package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob11 {
	

	
	public static void test() {

		Solution11 sol = new Solution11();
		
		int[] hs1 = {1,8,6,2,5,4,8,3,7};
		int[] hs2 = {1,1};
		
		System.out.println("ans: " + sol.maxArea(hs1));
		System.out.println("ans: " + sol.maxArea(hs2));
		
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution11 {
	
    public int maxArea(int[] height) {
    	int arrLength = height.length;
    	int leftSide, rightSide;
    	int maxHeight;
    	int minWidth = 1;
    	int currVol, maxVol = 0;
    	for (int width = arrLength-1; width >= minWidth; width--) {
    		leftSide = 0; 
    		rightSide = leftSide + width;
    		maxHeight = (height[leftSide] < height[rightSide]) ? height[leftSide] : height[rightSide];
    		for (leftSide = 1, rightSide = leftSide + width; rightSide < arrLength; leftSide++, rightSide++) {
    			if (maxHeight >= height[leftSide] || maxHeight >= height[rightSide]) {
    				continue;
    			} else {
    				maxHeight = (height[leftSide] < height[rightSide]) ? height[leftSide] : height[rightSide];
    			}//fi			
    		}//rof
    		currVol = maxHeight * width;
    		if (maxVol < currVol) {
    			maxVol = currVol;   			
    		}//fi
    		minWidth = maxVol/10000 + 1;
    	}//rof    	
        return maxVol;    	 
    }//end method
    
}//end class
