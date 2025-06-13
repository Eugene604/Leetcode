package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob85{

	static String arr1 = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";

	static void test() throws JsonMappingException, JsonProcessingException {
		Solution85 solObj = new Solution85();
		char[][] arr;

		// Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();


		
		/*
		
		//*/
		
		arr =  objectMapper.readValue(arr1, char[][].class);
		MatrixUtils.displayMatrix(arr);
		System.out.println("ans: " + solObj.maximalRectangle(arr));
		//solObj.test();
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Solution85{
	
	static final int MAX_HISTOGRAM_WIDTH = 200;
	//inner array: [bar height, bar inx]
	int[][] barStackArr = new int[MAX_HISTOGRAM_WIDTH+1][2];
	int lastEleInx = -1;
	
	void clearStack() {
		lastEleInx = -1;
	}//end method
	
	/**
	 * 
	 * Pushes a bar into the stack while ensuring that the stack remains in non-decreasing order of bar heights.
	 * Any bars that are taller than the current bar height are popped off the stack, and the maximum rectangular
	 * area that can be formed using those discarded bars is calculated.
	 *
	 * precondition: 
	 * - barInx must not exceed nor be equal to MAX_HISTOGRAM_WIDTH 
	 * - barInx is assumed to be greater than all current bar indices in the stack
	 * - barHeight must be positive
	 * 
	 * @param barHeight - int, height of the bar
	 * @param barInx - int, index of this bar in histogram
	 * @return int - the maximum rectangular area formed by bars that are discarded from the stack.
	 *               This area is calculated using the height of the discarded bars and the difference
	 *               between the current bar index and the index at which the discarded bar was added.
	 */
	private int push(int barHeight, int barInx) {
		//System.out.println("try:push " + barHeight + ":" + barInx);
		int prevLEQBarInx = this.lastEleInx; 
		int maxRecAreaDiscarded = 0;
		int recAreaDiscarded;
		boolean hasEncounteredLEqHeight = false;
		while (prevLEQBarInx>=0 && barStackArr[prevLEQBarInx][0] >= barHeight) {
			if (barStackArr[prevLEQBarInx][0] > barHeight) {
				//only calculate rec area when current bar height is smaller than prior bar
				recAreaDiscarded = barStackArr[prevLEQBarInx][0]*(barInx-barStackArr[prevLEQBarInx][1]);
				maxRecAreaDiscarded = Math.max(maxRecAreaDiscarded, recAreaDiscarded);
			}//fi
			hasEncounteredLEqHeight = true;
			prevLEQBarInx--;			
		}//end while
		this.lastEleInx = prevLEQBarInx + 1;
		barStackArr[this.lastEleInx][0]=barHeight;
		if (hasEncounteredLEqHeight) {			
			//bar height equal to some prior bar, no need to push current index to stack			
		} else {						
			barStackArr[this.lastEleInx][1]=barInx;
		}//fi
		return maxRecAreaDiscarded;
	}//end method
	
	public int maximalRectangle(char[][] matrix) {
    	int[] currHistogram = new int[matrix[0].length];
    	int maxRedArea = 0;
    	for (char[] charRow:matrix) {
    		for (int i=0; i<charRow.length; i++) {
    			if (charRow[i] == '0') {
    				currHistogram[i] = 0;
    			} else {
    				currHistogram[i]++;
    			}//fi
    		}//rof
    		//System.out.println("process: " + Arrays.toString(currHistogram));
    		maxRedArea = Math.max(maxRedArea, maxRect(currHistogram));
    	}//rof    	
        return maxRedArea;
    }//end method
    
    public void test() {
    	int[] currHistogram = new int[] {3, 1, 3, 2, 2};
    	System.out.println("process: " + Arrays.toString(currHistogram));
    	System.out.println("rec: " + maxRect(currHistogram));
    }
    
    /**
     * Computes the maximum rectangular area in a histogram, represented as an array of bar heights.
     * The function uses a stack to efficiently calculate the largest rectangle that can be formed under
     * the histogram's bars.
     *
     * @param histogram - int[], an array where each element represents the height of a bar in the histogram.
     * @return int - the maximum rectangular area that can be formed in the histogram.
     */
    private int maxRect(int[] histogram) {
    	int maxRecArea = 0;
    	int inx;
    	clearStack();
    	for (inx=0; inx < histogram.length; inx++) {
    		maxRecArea = Math.max(maxRecArea, push(histogram[inx], inx));
    		//System.out.println(Arrays.deepToString(barStackArr));
    		//System.out.println(lastEleInx);
    	}//rof
		maxRecArea = Math.max(maxRecArea, push(0, inx));
		//System.out.println(Arrays.deepToString(barStackArr));
		//System.out.println(lastEleInx);
    	return maxRecArea;
    }//end method
}// end class

