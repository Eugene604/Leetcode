package Problems;

import java.util.*;

public class Prob4 {
	static int[] nums0 = {0};
	static int[] nums1 = {1,2};
	static int[] nums2 = {3,5};
	
	static int[] nums3 = {};
	static int[] nums4 = {2,3,4};
	
	static int[] nums5 = {0, 1, 2, 3, 3, 3, 3, 8};
	static int[] nums6 = {0, 3, 5, 17, 18, 22, 33};	
	
	static int[] nums7 = {6};
	static int[] nums8 = {};

	// index .............0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16, 17, 18, 19, 20
	static int[] nums9 = {1, 3, 4, 5, 5, 6, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 12, 15, 16};
	
	static int[] nums10 = {-2, -1};
	
	static int[] nums11 = {0, 9, 11, 15};
	
	static int[] nums12 = {0, 6, 7};
	
	static int[] nums13 = {1,3};
	static int[] nums14 = {2,7};
	
	static int[] nums15 = {10000};
	static int[] nums16 = {10001};
	
	static int[] nums17 = {3};
	static int[] nums18 = {1,2,4};
	
	private static void test(int[] testArr1, int[] testArr2) {
		double m;
		//Solution4 sol = new Solution4();
		
		Solution4_EXP sol = new Solution4_EXP();

		System.err.println("mark: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16, 17, 18, 19, 20]");		
		System.err.println("arr1: " + Arrays.toString(testArr1));
		System.err.println("arr2: " + Arrays.toString(testArr2));
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m = sol.findMedianSortedArrays(testArr1, testArr2);
		System.out.println("Median: " + m);
		System.out.println("======================================");

	}
	
	public static void main(String[] args) {
		test(nums1, nums2);
		test(nums7, nums8);
		test(nums3, nums4);
		test(nums4, nums6);
		test(nums9, nums5);
		test(nums1, nums5);
		test(nums11, nums5);
		test(nums12, nums6); 
		test(nums13, nums14); 
		test(nums7, nums10); 
		test(nums15, nums16);
		test(nums17, nums18);
		test(nums0, nums1);
	}
}

class Solution4 {

	private static final boolean LOOP_DEBUG = false;

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {    
    	int numOfElem = nums1.length + nums2.length;
    	int numOfElemBMedian = numOfElem/2; // number of elements Before median
    	boolean isNumOfElemOdd = (numOfElem & 1) == 1;
    	int[] oArr, iArr; //Outer search array & inner search array. 
       	/* 
    	 * Four special outer loop cases: 
    	 * 1. two empty arrs
    	 * 2. one empty, one with elems    
    	 * Initial outer array is the larger array
    	 */
    	if (numOfElem == 0) { //outer case 1
    		return 0;
    	} else if (nums1.length == 0) { //outer case 2
    		if (isNumOfElemOdd) {
    			return (nums2[numOfElemBMedian]);
    		} else {
    			return (double)(nums2[numOfElemBMedian-1] + nums2[numOfElemBMedian])/2;
    		}//fi
    	} else if (nums2.length == 0) { //outer case 2
    		if (isNumOfElemOdd) {
    			return (nums1[numOfElemBMedian]);
    		} else {
    			return (double)(nums1[numOfElemBMedian-1] + nums1[numOfElemBMedian])/2;
    		}//fi
    	} else if (numOfElem == 2) { //outer case 3
    		return (double)(nums1[0] + nums2[0])/2; 		
    	} else if (nums1.length >= nums2.length) {
    		oArr = nums1;
    		iArr = nums2;
    	} else {
    		oArr = nums2;
    		iArr = nums1;
    	} //fi   	

    	int oInx = -1, iInx = -1, currNum = Integer.MIN_VALUE, lastNum;
    	int numOfAvalInx = numOfElemBMedian + 1;
 
    	
		do {
			if (iInx == iArr.length - 1) {
				if (LOOP_DEBUG) {System.err.println("loop iInx if: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
				oInx += numOfAvalInx;	
				currNum = oArr[oInx];
				lastNum = Math.max((oInx==0)?Integer.MIN_VALUE:oArr[oInx-1] , iArr[iInx]);
				numOfAvalInx=0;
				break;
			} else if (oInx == oArr.length -1) {
				iInx += numOfAvalInx;	
				currNum = iArr[iInx];
				lastNum = Math.max((iInx==0)?Integer.MIN_VALUE:iArr[iInx-1] , oArr[oInx]);
				numOfAvalInx=0;
				break;				
			}
			lastNum = currNum;
			if (oArr[oInx+1] >= iArr[iInx+1]) {
				iInx++;
				currNum = iArr[iInx];
			} else {
				oInx++;
				currNum = oArr[oInx];
			}
			numOfAvalInx--;

		} while (numOfAvalInx > 0); //end while
		if (LOOP_DEBUG) {System.err.println(" loop exited: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
    		
		if (isNumOfElemOdd) { 
			return currNum;
		} else { 
			return (double) (currNum + lastNum)/2;
		}//fi
	}//end method
}//end class

class Solution4_OLD {
	
	private static final boolean OUTER_SEARCH_DEBUG = true;
	private static final boolean INNER_SEARCH_DEBUG = false;
	private static final boolean END_CASE_DEBUG = true;
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {    	
    	int numOfElem = nums1.length + nums2.length;
    	int numOfElemBMedian = numOfElem/2; // number of elements Before median
    	boolean isNumOfElemOdd = (numOfElem & 1) == 1;
    	int[] oArr, iArr; //Outer search array & inner search array. 
       	/* 
    	 * Four special outer loop cases: 
    	 * 1. two empty arrs
    	 * 2. one empty, one with elems  
    	 * 3. both have one elem
    	 * 4. same length but one is strictly greater than another  
    	 * Initial outer array is the larger array
    	 */
    	if (numOfElem == 0) { //outer case 1
    		return 0;
    	} else if (nums1.length == 0) { //outer case 2
    		if (isNumOfElemOdd) {
    			return (nums2[numOfElemBMedian]);
    		} else {
    			return (double)(nums2[numOfElemBMedian-1] + nums2[numOfElemBMedian])/2;
    		}//fi
    	} else if (nums2.length == 0) { //outer case 2
    		if (isNumOfElemOdd) {
    			return (nums1[numOfElemBMedian]);
    		} else {
    			return (double)(nums1[numOfElemBMedian-1] + nums1[numOfElemBMedian])/2;
    		}//fi
    	} else if (numOfElem == 2) { //outer case 3
    		return (double)(nums1[0] + nums2[0])/2; 		
    	} else if (nums1.length > nums2.length) {
    		oArr = nums1;
    		iArr = nums2;
    	} else if (nums1.length < nums2.length) {
    		oArr = nums2;
    		iArr = nums1;
    	} else if (nums1[nums1.length-1] <= nums2[0]) { //outer case 4, equal and nums2 is strictly greater than or equal to nums1
    		return (double)(nums1[nums1.length-1] + nums2[0])/2;
    	} else if (nums1[0] >= nums2[nums2.length-1]) { //outer case 4, equal and nums1 is strictly greater than or equal to nums2
    		return (double)(nums1[0] + nums2[nums2.length-1])/2;
    	} else { 
    		oArr = nums1;
    		iArr = nums2;	
    	} //fi   	
    	
    	
    	

    	int oInx = 0, iInx = -1, lastGoodIInx = 0, halfNumOfAvalInx;
    	int numOfAvalInx = numOfElemBMedian;
 
    	
    	//if (OUTER_SEARCH_DEBUG) {System.err.println("before entering outer loop: " + oInx + " : " + iInx + " : " + numOfElemBMedian);}
		do {
			/* outer case 5, current index position at outer search array and corresponding index of inner search array have not yet covered first half elements 
			 * outer array: [...., 55, 65, 73, .....] length 100
			 *                          ^ current trial position, index = 49
			 * inner array: [...., 32, 43, 70.... ] length 100
			 *                          ^ searched position, index = 19
			 * 
			 * In this case, there are still 30 index positions available. 
			 * Distribute half of these available indices for fixed array and search again 
			 */
			/* outer case 6, current index position at outer search array and corresponding index of inner search array covered more than the first half of all elements
			 * outer array: [...., 55, 65, 73, .....] length 100
			 *                          ^ current trial position, index = 49
			 * inner array: [...., 32, 43, 70.... ] length 100
			 *                          ^ searched position, index = 79
			 * 
			 * In this case, we used 20 more indices. 
			 * Full back half of this available indices for fixed array and search again 
			 */
			halfNumOfAvalInx = numOfAvalInx/2;
			oInx = oInx + halfNumOfAvalInx;
			//if (OUTER_SEARCH_DEBUG) {System.err.println("outer loop mid: " + oInx + " : " + iInx + " : " + halfNumOfAvalInx);}
			iInx = ceilInxOfTarget(oArr[oInx], iArr, lastGoodIInx, iArr.length-1, iInx + halfNumOfAvalInx);
			numOfAvalInx = numOfElemBMedian - (oInx + iInx + 2);	
			if (iInx > 0 || numOfAvalInx > 0 ) {
				lastGoodIInx = iInx;
			}
			//if (OUTER_SEARCH_DEBUG) {System.err.println("outer loop end: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
		} while (Math.abs(numOfAvalInx) > 1); //end while
		//if (OUTER_SEARCH_DEBUG) {System.err.println("outer loop exited: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
		
		if (numOfAvalInx == 1) {
			/* outer case 7, current index position at outer search array and corresponding index of inner search array have almost covered the first half of all elements
			 * outer array: [...., 55, 65, 73,.....] length 100
			 *                          ^ current trial position, index = 49
			 * inner array: [....., 32, 43, 70.... ] length 100
			 *                           ^ searched position, index = 48
			 * no recursive step is needed
			 */
			if (iInx == iArr.length-1) {
				/* outer case 7-1, inner index is the right most index 
				 * outer array: [30, 43, 55, 65, 73..] length 5 or 6 
				 *                    ^ current trial position, index = 1
				 * inner array: [ 35 ] length 1
				 *                 ^ searched position, index = 0
				 *                          
				 * outer array: [...., 55, 65, 73....] length 100 /length 101
				 *                          ^ current trial position, index = 49
				 * inner array: [...., 32, 43, 70/74?...] length 100
				 *                          ^ searched position, index = 48
				 */
				oInx++;
			} else if (oArr[oInx+1] > iArr[iInx+1]) {
				//if (OUTER_SEARCH_DEBUG) {System.err.println("outer case 7-2: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
				/* outer case 7-2, next element of outer array is greater the next element of inner array
				 * outer array: [...., 55, 65, 73....] length 100 /length 101
				 *                          ^ current trial position, index = 49
				 * inner array: [...., 32, 43, 70...] length 100
				 *                          ^ searched position, index = 48
				 */
				iInx++;
			} else {
				//if (OUTER_SEARCH_DEBUG) {System.err.println("outer case 7-3: " + oInx + " : " + iInx + " : " + numOfAvalInx);}
				/* outer case 7-3, next element of outer array is less the next element of inner array
				 * outer array: [...., 55, 65, 73....] length 100 /length 101
				 *                          ^ current trial position, index = 49
				 * inner array: [...., 32, 43, 74...] length 100
				 *                          ^ searched position, index = 48
				 */
				oInx++;
			}//fi			
		} else if (numOfAvalInx == -1) {
			/* outer case 8, current index position at outer search array and corresponding index of inner search array have over-covered the first half by 1
			 * outer array: [...., 32, 55, 53,.....] length 100
			 *                          ^ current trial position, index = 49 (50 elements)
			 * inner array: [....., 35, 45, 63.... ] length 100
			 *                           ^ searched position, index = 50 (51 elements)
			 * no recursive step is needed
			 */
			oInx--;			
		}//fi
		
		/*
		 * end cases:
		 * 1 odd number of elements
		 * 	1-1 index of inner search array is at tail, just return next outer index element  
		 *  1-2 both search arrays have more elements, return the smaller of  next elements
		 * 2 even number of elements
		 * 	2-1 even number of elements and inner contains largest two of lower half
		 * 	2-2 even number of elements and outer contains largest two of lower half
		 * 	2-3 even number of elements and one array holds the largest and another holds the second largest 
		 * 
		 */
		
		if (isNumOfElemOdd) { // end case 1
			//if (END_CASE_DEBUG) {System.err.println("end case 1");}
			if (iInx == iArr.length-1) { // end case 1-1
				return oArr[oInx+1];
			} else { // end case 1-2
				return (oArr[oInx+1] < iArr[iInx+1]) ?  oArr[oInx+1] : iArr[iInx+1];
			}
		} else if (iInx == -1) { //end case 2
			int smallerOfNextElem = (oArr[oInx+1] < iArr[iInx+1]) ?  oArr[oInx+1] : iArr[iInx+1];
			return (double)(oArr[oInx] + smallerOfNextElem)/2;
		} else { 
			int largerOfEndElem = (oArr[oInx] > iArr[iInx]) ?  oArr[oInx] : iArr[iInx];
			int smallerOfNextElem;
			if (iInx == iArr.length-1) {
				return (double)(largerOfEndElem + oArr[oInx+1])/2;
			} else {
				smallerOfNextElem = (oArr[oInx+1] < iArr[iInx+1]) ?  oArr[oInx+1] : iArr[iInx+1];
				return (double)(largerOfEndElem + smallerOfNextElem)/2;
			}//fi		
		}//if
		   
    }
    
    /**
     * Recursively search for the ceiling index of target number 		<br>
     * preconditions:   -array is sorted and is in ascending order 		<br>
     * 					- array.length > 0						 		<br>
     * 				 	- baseInx >= 0							 		<br>
     * 					- maxInx < array.length 						<br>
     * 					- maxInx >= baseInx							 	<br>
     * 					- eqValInx > 0								 	<br>
     * 					- This method does NOT verify above preconditions. Failing to adhere will result in exception or infinite loop.	 		<br>
     * Upon convergence, this method finds index of the largest number that is less than target number or equal to target number. 			 	<br>
     * In case of multiple consecutive equal values in the array, return the index that is closest to equal value index. 						<br>
     * Example:																																	<br> 
     * [0, 1, 2, 3, 3, 3, 3, 8], target 3, baseInx 0 maxInx 7, eqValInx 1, return 3		 				<br>
     * [0, 1, 2, 3, 3, 3, 3, 8], target 3, baseInx 0 maxInx 7, eqValInx 3, return 3			 			<br>
     * [0, 1, 2, 3, 3, 3, 3, 8], target 3, baseInx 0 maxInx 7, eqValInx 5, return 5 		 			<br>
     * [0, 1, 2, 3, 3, 3, 3, 8], target 3, baseInx 0 maxInx 7, eqValInx 999, return 6 			 		<br>
     * [0, 3, 5, 7, 8], target 6, baseInx 0, maxInx 4, eqValInx 1, return 2 					 		<br>
     * [0, 3, 5, 7, 8], target 6, baseInx 3, maxInx 4, eqValInx 1, return -1						 	<br>
     * [0, 3, 5, 7, 8], target 0, baseInx 0, maxInx 4, eqValInx -1, return -1						 	<br> 
     * [0, 3, 5, 7, 8], target 6, baseInx 0, maxInx 4, eqValInx -1, return 2						 	<br> 
     * [8, 9, 10], target 6, return -1																 	<br>
     * [0, 0, 10], target 0, eqValInx 1, return 1													 	<br> 
     * @param target target number
     * @param nums the number array
     * @param baseInx base index. It is the starting index for the search
     * @param maxInx max index. The highest index value for the search 
     * @param eqValInx this value dictates the desired index value when equal value(s) occurs, hence "equal value index". If negative, return -1 if 0th element is equal to target
     * @return non-negative index value if ceiling index value is found, -1 if all values are greater than target number
     */
    public int ceilInxOfTarget(int target, int[] nums, int baseInx, int maxInx, int eqValInx) {
    	int tmpInx;
    	int midInx = (maxInx + baseInx)/2;
    	//if (INNER_SEARCH_DEBUG) {System.err.println("Entering method, base, mid, max: " + baseInx + " : " + midInx + " : " + maxInx);}  	    	
    	if (nums[midInx] < target) { 
			/* case 1, mid number is  smaller than target
			 * example: [...., 3, 4, 5, 6...], target 8
			 *                midInx ^ 
			 */
    		//if (INNER_SEARCH_DEBUG) {System.err.println("Gone to case 1...");}
    		if (midInx == maxInx) { 
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 1-1, return:" + midInx);}
    			/* case 1-1, left side all smaller and midInx is already at max index
    			 * example: [...., 3, 4, 5, 6...], target 8
    			 *             midInx ^ maxInx
    			 */
    			return midInx;    			
    		} else if ((tmpInx = ceilInxOfTarget(target, nums, midInx+1, maxInx, eqValInx)) > 0){
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 1-2, return:" + tmpInx);}
    			/* case 1-3, left side all smaller and right side exists a valid ceiling index
    			 * example: [...., 3, 4, 5, 7, 9...], target 8
    			 *             midInx ^     ^ tmpInx
    			 */ 			
    			return tmpInx;
    		} else {
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 1-3, return:" + midInx);}
    			/* case 1-3, left side all smaller and right side numbers are all greater
    			 * example: [...., 3, 4, 9, 17, 19...], target 8
    			 *             midInx ^  
    			 */     			
    			return midInx;
    		}
    		
    	} else if (nums[midInx] > target) { 
        	//if (INNER_SEARCH_DEBUG) {System.err.println("Gone to case 2...");}
    		/* case 2, right side and mid number all greater than target
			 * example: [...., 3, 9, 10, 12], target 8
			 *             midInx ^ 
			 */    		
    		if (midInx == baseInx) { 
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 2-1, return: -1");}
        		/* case 2-1, right side and mid number are all greater than target and midInx already at most left
    			 * example: [...., 3, 9, 10, 12], target 8
    			 *             midInx ^ also baseInx
    			 */
    			return -1; 
    		} else if ((tmpInx = ceilInxOfTarget(target, nums, baseInx, midInx-1, eqValInx)) >= 0){
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 2-2, return:" + tmpInx);}
        		/* case 2-2, right side and mid number are all greater than target and left side exists a valid ceiling index
    			 * example: [...., 3, 4, 5, 7, 9, 10, 12...], target 8
    			 *                    tmpInx^      ^ midInx
    			 */ 			
    			return tmpInx;
    		} else {
    	    	//if (INNER_SEARCH_DEBUG) {System.err.println("case 2-3, return: -1");}
        		/* case 2-3, right side, mid number and left side are all greater than target 
    			 * example: [...., 13, 14, 19, 27, 29...], target 8
    			 *          baseInx^    midInx ^  
    			 */     			
    			return -1;
    		}//fi
    	} else { 
    		//if (INNER_SEARCH_DEBUG) {System.err.print("Gone to case 3...");}
    		/* case 3, mid number is equal to the target
    		 * 
    		 */
			if (midInx == eqValInx) { 
      			//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-1, return:" + midInx);}
    			/* case 3-1, midInx happens to equal to eqValInx
    			 * example: [.., 4, 6, 8, 10, 12...], target 8
    			 *              midInx ^ eqValInx
    			 */
    			return midInx;		
    		} else if (midInx < eqValInx) { 
        		//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-2...");}
    			/* case 3-2, mid index is less than equal value index, check to see if right side has more
        	     * example: [.., 4, 8, 8, ?, ?, ?, ?, ?, ?, ?, ?...], target 8
        		 *              midInx ^                 ^ eqValInx
    			 */
    			if (midInx == maxInx) {
          			//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-2-1, return:" + midInx);}
    				/* case 3-2-1, midInx is less than eqValInx but already at most right side ((tail recursion)
        			 * example: [.., 4, 8, 8, 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *                             midInx ^ maxInx
        			 */
    				return midInx;
    			} else if ((tmpInx = ceilInxOfTarget(target, nums, midInx+1, maxInx, eqValInx)) > 0){
          			//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-2-2, return:" + tmpInx);}
        			/* case 3-2-2, midInx is less than eqValInx & maxInx and right side exists one that is closer to eqValInx
        			 * example: [.., 4, 8, 8, 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *              midInx ^                 ^ eqValInx
        			 *                              tmpInx^ 
        			 */
    				return tmpInx;
    			} else {
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-2-3, return:" + midInx);}
        			/* case 3-2-3, midInx is less than eqValInx and right side are all greater
        			 * example: [.., 4, 8, 8, 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *                             midInx ^       ^ maxInx, eqValInx
        			 */
    				return midInx;
    			}//fi
    		} else {
        		//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3...");}
    			/* case 3-3, mid index is greater than eqValInx, check to see if left side has more equal values
        	     * example: [.., ?, ?, ?, ?, ?, ?, ?, 8, 8, 8, 9, 10, 12,...], target 8
        		 *            eqValInx ^              ^ midInx
    			 */
    			if (midInx == 0 && eqValInx < 0) {
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3-1, return: -1");}
    				/* case 3-3-1, special case
    				 * midInx happens to be 0 and eqValInx is dictated to be negative
    				 * example: [4, 6, 8, 10, 12...], target 4, eqValInx -1
    				 */
    				return -1;
    			} else if (midInx == baseInx) {
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3-2, return:" + midInx);}
    				/* case 3-3-2, midInx is greater than eqValInx but already at most left side ((tail recursion)
        			 * example: [.., 4, 6, ?, ?, ?, ?, 8, 8, 10, 12...], target 8
        			 *       eqValInx^         baseInx ^  midInx 
        			 */
    				return midInx;
    			} else if ((tmpInx = ceilInxOfTarget(target, nums, baseInx, midInx-1, eqValInx)) < midInx-1){
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3-3, return:" + tmpInx);}
        			/* case 3-3-3 , midInx is greater than eqValInx and left side exists one that is closer to eqValInx 
        			 * 				also, tmpInx and midInx are not neighbors
        			 * example: [.., 4, 5, 5, 6, 6, 8,..., 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *       baseInx ^  ^eqValInx                ^ midInx
        			 *                              ^ tmpInx should be this
        			 */
    				return tmpInx;
    			} else if (nums[tmpInx] < nums[midInx]){
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3-4, return:" + midInx);}
        			/* case 3-3-4 , midInx is greater than eqValInx and tmpInx & midInx are neighbors
        			 *              also, nums[tmpInx] < nums[midInx] which makes midInx the left most value equal to target
        			 * example: [.., 4, 5, 5, 6, 6, ....., 7, 7, 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *       baseInx ^   eqValInx^               ^ midInx
        			 *                                        ^ tmpInx
        			 */
    				return midInx;
    			} else {
    				//if (INNER_SEARCH_DEBUG) {System.err.println("case 3-3-5, return:" + tmpInx);}
        			/* case 3-3-5 , midInx is greater than eqValInx and tmpInx & midInx are neighbors
        			 *              also, nums[tmpInx] == nums[midInx] which makes tmpInx the left most value equal to target
        			 * example: [.., 4, 5, 5, 6, 6, ....., 7, 8, 8, 8, 8, 8, 8, 10, 12...], target 8
        			 *       baseInx ^   eqValInx^               ^ midInx
        			 *                                        ^ tmpInx
        			 */    				
    				return tmpInx;
    			}//fi
    		}//fi	
    	}//fi
    }//end ceilInxOfTarget
}//end class

class Solution4_EXP {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int nums1Length, nums2Length;
    	if (nums1 == null) {
    		nums1Length = 0;
    	} else {
    		nums1Length = nums1.length;
    	}//fi
    	if (nums2 == null) {
    		nums2Length = 0;
    	} else {
    		nums2Length = nums2.length;
    	}//fi
    	
    	int totalLength = nums1Length + nums2Length;
    	int stopInx = (totalLength-1)/2;
    	boolean isEven = (totalLength%2 == 0);
    	int inx1 = 0,inx2 = 0;
    	int currNum = 0, nextNum = 0;
    	
    	while (inx1 + inx2 <= stopInx) {
    		if (inx1 >= nums1Length) { //nums1 used up
    			currNum = nums2[inx2];
    			inx2++;
    			continue;
    		} else if (inx2 >= nums2Length) {  //nums2 used up
    			currNum = nums1[inx1];
    			inx1++;
    			continue;    		
    		}//fi
    		
    		if (nums1[inx1] > nums2[inx2]) {
    			currNum = nums2[inx2];
    			inx2++;
    		} else {
    			currNum = nums1[inx1];
    			inx1++;
    		}//fi
    	}//end while
    	if (!isEven) {
    		return (double)currNum;
    	}//fi
    	
    	
		if (inx1 >= nums1Length) { //nums1 used up
			nextNum = nums2[inx2];
		} else if (inx2 >= nums2Length) {  //nums2 used up
			nextNum = nums1[inx1];  		
		} else {
			if (nums1[inx1] > nums2[inx2]) {
				nextNum = nums2[inx2];
			} else {
				nextNum = nums1[inx1];
			}//fi    
		}//fi */
    	
        return (double)(currNum + nextNum)/2;
    }//end method
}//end class
