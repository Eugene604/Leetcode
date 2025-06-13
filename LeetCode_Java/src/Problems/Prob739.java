package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob739 {

	private static int[] arr1 = {73,74,75,71,69,72,76,73};
	private static int[] arr2 = { 0,1,2,3,4,5,6,7,8 };
	private static int[] arr3 = { 1, 2 };

	public static void test() {

		Solution739 solObj = new Solution739();
		int[] testArr;

		testArr = arr1;
		System.out.println(Arrays.toString(testArr));
		System.out.println("ans: " + Arrays.toString(solObj.dailyTemperatures(testArr)));



		// */
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution739 {
	
    private static PriorityQueue<int[]> tmpDayQueue = new PriorityQueue<>(
            Comparator.comparingInt((int[] arr) -> arr[0])
        );
    
    public int[] dailyTemperatures(int[] temperatures) {
    	int[] answer = new int[temperatures.length];
    	tmpDayQueue.clear();
    	int[] topTmpDayArr;
    	for (int i=0; i< temperatures.length; i++) {
    		while ((topTmpDayArr = tmpDayQueue.peek())!=null && topTmpDayArr[0]<temperatures[i]) {
    			answer[topTmpDayArr[1]] = i - topTmpDayArr[1];
    			tmpDayQueue.remove();
    		}//end while
    		int[] tmpDayArr = new int[2];
    		tmpDayArr[0] = temperatures[i];
    		tmpDayArr[1] = i;
    		tmpDayQueue.offer(tmpDayArr);
    	}//rof
        return answer;
    }//end class
}// end class


