package Problems;

import java.util.Arrays;

public class Prob42 {
	public static int[] arr1 = {1,2,3,4};
	public static int[] arr2 = {4,4,3,2};
	public static int[] arr3 = {1,2,9,9,9,9,7,2,1};	
	public static int[] arr4 = {2,2,2,2};	
	public static int[] arr5 = {3,1,12,12,5,6,4,2,1,2,3,14,10,6,2,7,7,6};
	public static int[] arr6 = {0,1,0,2,1,0,1,3,2,1,2,1};	
	public static int[] arr7 = {4,2,0,3,2,5};	
	public static int[] arr8 = {3,0,2,0,2,0,2,0,2,0,3};
	public static int[] arr9 = {5,4,1,2};
	public static void main(String[] args) {
		test();
	}//end main
	
	public static void test() {
		Solution42 solObj = new Solution42();
		CorrectSolution42 correctSolObj = new CorrectSolution42();
		int[] arr;
		
		
	
		arr = arr1;
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct correct sol: " + correctSolObj.trap(arr));	
	
	
	
		arr = arr2;
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
		
		
		arr = arr3;
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
			
		
	
		arr = arr4;
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
		
		//*/
		
	
		arr = arr5;
		System.out.println(Arrays.toString(arr));
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
	
		
		
		arr = arr6;
		System.out.println("sol: " + solObj.trap(arr));	
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
		
	
		arr = arr7;
		System.out.println("sol: " + solObj.trap(arr));	
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
	
		arr = arr8;
		System.out.println("sol: " + solObj.trap(arr));	
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
		//*/
		
			
		arr = arr9;
		System.out.println("sol: " + solObj.trap(arr));
		System.out.println("correct sol: " + correctSolObj.trap(arr));	
	}//end method

}//end class

class Solution42 {
	

    public int trap(int[] height) {
    	//special case: height map length < 3
    	if (height.length < 3) {
    		return 0;
    	}//fi
    	int singleVol;
    	int totalVol = 0;
    	int tmpLocalVol = 0;    	
    	int summitHeight = height[0];
    	//step 1, scan from left to right
    	for (int i=1; i<height.length; i++) {
    		singleVol = summitHeight - height[i];
    		if (singleVol <= 0) {
    			if (tmpLocalVol > 0) {
    				totalVol += tmpLocalVol;
    			}//fi
    			summitHeight = height[i];
    			tmpLocalVol = 0;
    		} else {
    			tmpLocalVol += singleVol;
    		}//fi
    	}//rof
    	
    	if (tmpLocalVol == 0) {
    		return totalVol;
    	}//fi
    	
    	//step 2, scan from right to left if necessary
    	tmpLocalVol = 0;  
    	summitHeight = height[height.length-1];
    	for (int i=height.length-2; i>=0; i--) {
    		singleVol = summitHeight - height[i];
    		if (singleVol < 0) { //notice that singleVol == 0 case has been taken care of during left to right scan
    			if (tmpLocalVol > 0) {
    				totalVol += tmpLocalVol;   				
    			}//fi
    			summitHeight = height[i];
    			tmpLocalVol = 0;    			
    		} else {
    			tmpLocalVol += singleVol;
    		}//fi
    	}//rof
    	
    	return totalVol;
    }//end method
 
}//end class

class Solution42_v2 {
	
	enum Trend {
		UP_SLOPE,DOWN_SLOPE, 
		UP_THEN_PLATEAU,DOWN_THEN_PLATEAU 		
	}//end enum
	
    public int trap(int[] height) {
    	//special cases, height length < 3
    	if (height.length < 3) {
    		return 0;
    	}//fi
    	int[][] summits = populateSummits(height);
    	//System.out.println("terrain: " + Arrays.toString(height));
    	//System.out.println("summits: " + Arrays.deepToString(summits));    	
    	if (summits[1][0] == -1) {    		
    		return 0;
    	}//fi
    	int vol = 0;
    	int minHeight, currHeight;
    	for (int sInx = 1; sInx < summits.length-1 && summits[sInx][0] < summits[sInx+1][0]; sInx++) {
    		minHeight = Math.min(summits[sInx][1], summits[sInx+1][1]);
    		for (int hInx = summits[sInx][0]+1; hInx < summits[sInx+1][0]; hInx++ ) {
    			currHeight = minHeight - height[hInx];
    			if (currHeight > 0) {
    				vol += currHeight;
    			}//fi
    			//System.out.println("vol: " + vol + " hInx: " + hInx + " currHeight: " + currHeight);
    		}//rof    		
    	}//rof
    	return vol;
    }//end method
    
    /**
     * 
     * @param height int array
     * @return int[][], 
     * 		first layer records the index of the summit
     * 		second layer records summit height
     * 		valid summit index starts from 
     */
    private int[][] populateSummits(int[] height) {
    	int[][] summits = new int[height.length/2+2][2];
    	int rightSummitInx;
    	int currSummitInx, currHeightInx;

    	//step 1 - find left most summit
    	summits[1][0] = -1;
    	for (currHeightInx = 0; currHeightInx < height.length-1; currHeightInx++) {
    		if (height[currHeightInx+1]>=height[currHeightInx]) {
    			continue;
    		} else {
    			summits[1][0] = currHeightInx;
    			summits[1][1] = height[currHeightInx];
    			break;
    		}//fi
    	}//rof
    	
    	if (summits[1][0] == -1) {
    		//increasing slope, no summit, no water will be trapped
    		return summits;
    	}//fi
    	
    	//step 2 - find right most summit
    	rightSummitInx = -1;
    	for (currHeightInx = height.length-1; currHeightInx > summits[0][0]; currHeightInx--) {
    		if (height[currHeightInx-1]>=height[currHeightInx]) {
    			continue;
    		} else {
    			rightSummitInx = currHeightInx;
    			break;
    		}//fi
    	}//rof
    	
    	if (summits[1][0] >= rightSummitInx) {
    		//decreasing slope (no summit) or only one summit / plateau, no water will be trapped
    		summits[1][0] = -1;
    		return summits;
    	}//fi
    	
    	//step 3, find rest of summits by scanning from left to right
    	Trend prevSegTrend = Trend.DOWN_SLOPE;
    	currSummitInx = 2;
    	for (currHeightInx = summits[1][0]+1; currHeightInx < rightSummitInx-1; currHeightInx++) {
    		if (height[currHeightInx+1]<height[currHeightInx]) {
    			if (prevSegTrend == Trend.DOWN_SLOPE) {
    				continue;
    			} else if (prevSegTrend == Trend.DOWN_THEN_PLATEAU) {
    				prevSegTrend = Trend.UP_SLOPE;
    				continue;
    			} else {
    				//currHeightInx is a summit, will be recorded
    				prevSegTrend = Trend.DOWN_SLOPE;
    			}//fi
    		} else if (height[currHeightInx+1]>height[currHeightInx]) {
    			if (prevSegTrend == Trend.UP_SLOPE) {
    				continue;
    			} else if (prevSegTrend == Trend.DOWN_SLOPE || prevSegTrend == Trend.UP_THEN_PLATEAU) {
    				prevSegTrend = Trend.UP_SLOPE;
    				continue;
    			} else {
    				//currHeightInx is a summit, will be recorded
    				prevSegTrend = Trend.UP_SLOPE;
    			}//fi
    		} else { //equal, reaches a plateau
    			if (prevSegTrend == Trend.DOWN_SLOPE) {
    				prevSegTrend = Trend.DOWN_THEN_PLATEAU;
    			} else if (prevSegTrend == Trend.UP_SLOPE) {
    				prevSegTrend = Trend.UP_THEN_PLATEAU;
    			}//fi
    			continue;
    		}//fi
    		//System.out.println("try to add summit: " + currHeightInx + " : " + height[currHeightInx]);
    		for (;summits[currSummitInx-1][1]<height[currHeightInx]&&summits[currSummitInx-2][1]>=summits[currSummitInx-1][1];currSummitInx--) {}//rof
    		summits[currSummitInx][0] = currHeightInx;
    		summits[currSummitInx][1] = height[currHeightInx];
    		currSummitInx++;
    	}//rof
    	
    	//adds right most summit 
		for (;summits[currSummitInx-1][1]<height[rightSummitInx]&&summits[currSummitInx-2][1]>=summits[currSummitInx-1][1];currSummitInx--) {}//rof
    	summits[currSummitInx][0] = rightSummitInx;
		summits[currSummitInx][1] = height[rightSummitInx];
    	return summits;
    }//end method
     
}//end class


class CorrectSolution42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;
        
        // Fill left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        
        // Fill right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }
        
        return storedWater;
    }
}
