package Problems;

import java.util.*;

public class Prob670 {


	static void test() {
		

		Solution670 solObj = new Solution670();
		
		int num;
		
    	num = 98005; 
		System.out.println("ans: " + solObj.maximumSwap(num));
    	
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution670 {
	
	public int maximumSwap(int num) {
		char[] digArr = Integer.toString(num).toCharArray();
		PriorityQueue<int[]> maxDigQueue = new PriorityQueue<>((a, b) -> {
		    if (a[0] != b[0]) {
		        return b[0] - a[0];  // Decreasing order by a[0]
		    } else {
		        return b[1] - a[1];  // Decreasing order by a[1] if a[0] is the same
		    }//fi
		});
		
		//step 1: populate max digit queue
		for (int i=1; i<digArr.length; i++) {
			maxDigQueue.offer(new int[]{(int)digArr[i],i});
		}//rof
		
		/*
		while (maxDigQueue.size()>0) {
			System.out.println(Arrays.toString(maxDigQueue.poll()));
		}//rof */
		
		int[] currDigInfo;		
		int digArrInx = 0;
		while (digArrInx<digArr.length && maxDigQueue.size() > 0) {			
			currDigInfo = maxDigQueue.peek();
			//System.out.println("processing " + digArrInx + " digInfo: " + Arrays.toString(currDigInfo));
			if (digArr[digArrInx] >= currDigInfo[0]) {//curr dig is no less than other digits in queue, skip
				//do nothing
				digArrInx++;
			} else if (digArrInx >= currDigInfo[1]) {//curr dig is less, but other digits in queue has less index value, skip and discard queue item
				maxDigQueue.poll(); 
			} else {
				char tmpChrVal = (char) digArr[digArrInx];
				digArr[digArrInx] = (char) currDigInfo[0];
				digArr[currDigInfo[1]] = tmpChrVal;
				
				return Integer.parseInt(new String(digArr));
			}//fi
		}//rof
		
		return num;
    }//end method
}// end class
