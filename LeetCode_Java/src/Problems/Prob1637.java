package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1637{


	static void test() {
		
		int[][] arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[[1,1],[3,4],[-1,0]]", int[][].class);

            arr2 = objectMapper.readValue("[[3,2],[-2,2]]", int[][].class);
            
            arr3 = objectMapper.readValue("[[1,1],[3,4],[-1,0]]", int[][].class);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1637 solObj  = new Solution1637();
		int[][] arr;
		
		
		
		arr = arr1;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.maxWidthOfVerticalArea(arr));
		
		/*
		arr = arr2;		
		System.out.println("orignal arr: " + Arrays.deepToString(arr));
		System.out.println("ans: " + solObj.maxWidthOfVerticalArea(arr));
		//*/
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1637{
    public int maxWidthOfVerticalArea(int[][] points) {
    	int[] xArr = new int[points.length];
    	for (int i=0; i<points.length; i++){
    		xArr[i] = points[i][0];
    	}//rof
    	
    	Arrays.sort(xArr);
    	int currWidth, maxWidth = 0;
    	for (int i=1; i<points.length; i++){
    		currWidth = xArr[i]-xArr[i-1];
    		if (maxWidth < currWidth) {
    			maxWidth = currWidth;
    		}//fi
    	}//rof
        return maxWidth;
    }//end method
}// end class

class Solution1637_v2{
    public int maxWidthOfVerticalArea(int[][] points) {
    	Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
    	int currWidth, maxWidth = 0;
    	for (int i=1; i<points.length; i++){
    		currWidth = points[i][0]-points[i-1][0];
    		if (maxWidth < currWidth) {
    			maxWidth = currWidth;
    		}//fi
    	}//rof
        return maxWidth;
    }//end method
}// end class
