package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob1658 {
	public static int[] arr1 = {1,1,4,2,3}; //2
	public static int[] arr2 = {5,6,7,8,9};
	public static int[] arr3 = {3,2,20,1,1,3};
	public static int[] arr4 = {2,20};
	public static int[] arr10 = {1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136};
	public static int[] arr11 = {6285,2511,3617,8040,6970,8187,5617,7665,5069,875,3570,378,6556,1147,8616,3140,561,2875,5087,1372,2617,756,9076,1381,5428,498,1386,6984,5624,7908,5724,9921,4368,7036,92,4584,2654,2942,9947,9832,9969,9965,9991,9999,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,9992,10000,9985,8145,8244,4960,7560,7757,3981,8841,3482,2188,3475,1594,5101,4404,9679,3500,6984,5108,7258,9696,702,9031,2502,2326,5099,4767,7164,9432,2084,5294,7382,7564,809};
	public static int[] arr12 = {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639};
	public static int[] arr20;
	
	private static void test() {


		Path filePath = Paths.get("./TestFiles/Prob1658.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob1658.class.getDeclaredField(lines.get(i+1));
            	String[] tmpStrArr = lines.get(i+2).split(",");
                int[] tmpIntArr = new int[tmpStrArr.length];
                for (int j = 0; j < tmpStrArr.length; j++) {
                	tmpIntArr[j] = Integer.parseInt(tmpStrArr[j]);
                }//rof
				field.set(null, tmpIntArr);
            }//rof
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();       
        } catch (IOException e) {
            e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try catch
        
		Solution1658 solObj;
		int[] arr;
		int x;
		int sol;
		
		
		
		solObj = new Solution1658();
		x = 5;
		arr = arr1; //2
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));	
		
		solObj = new Solution1658();
		x = 4;
		arr = arr2; //-1
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));		
		
		solObj = new Solution1658();
		x = 10;
		arr = arr3; //5
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));	
		
		solObj = new Solution1658();
		x = 29;
		arr = arr4;
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));		
	
		
		solObj = new Solution1658();
		x = 894887480;
		arr = arr10; //-1
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));	
		 
		
		
		solObj = new Solution1658();
		x = 842910;
		arr = arr11; //120
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));	
		
	
		solObj = new Solution1658();
		x = 565610;
		arr = arr12; //113
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));		
		
			

	
		
		solObj = new Solution1658();
		x = 14621427;
		arr = arr20; //2944
		sol = solObj.minOperations(arr,x);
		System.out.println("Sol: " + sol + " arr:" + Arrays.toString(arr));	
		
		//*/
	}//end method
	
	public static void main(String[] args) {
		test();
	}//end method

}//end class




class Solution1658 {
	
	int globalOpCount;
	public int minOperations(int[] nums, int x) {
		globalOpCount = Integer.MAX_VALUE;
		
		//step 1, get longest chain possible given that no left element is taken
		int leftInx, rightInx;
		int currSum=0;
		for (rightInx=nums.length-1; rightInx>=0 && currSum<x; rightInx--) {
			currSum+=nums[rightInx];
		}//rof
		
		if (currSum==x) {
			globalOpCount = nums.length-rightInx-1;
		} else if (currSum<x) { //sum of all elements < x
			return -1;
		}//rof
		
		//step 2, start sliding window to the right
		int currOpCount;
		for (leftInx=1; leftInx<nums.length; leftInx++) {
			currSum+=nums[leftInx-1];
			
			while (rightInx<nums.length-1 && currSum>x) {
				rightInx++;
				currSum-=nums[rightInx];
			}//end while
			
			
			while (rightInx>leftInx && currSum<x) {
				currSum+=nums[rightInx];
				rightInx--;
			}//end while */						
			
			if (currSum<x) { //sum of all elements < x
				break;
			}//rof
			
			if (currSum==x) {
				currOpCount = leftInx + nums.length-rightInx-1;
				if (globalOpCount > currOpCount) {
					globalOpCount = currOpCount;
				}//fi
			}//fi
		}//rof
		return globalOpCount==Integer.MAX_VALUE?-1:globalOpCount;
    }//end method
	
}//end class


class Solution1658_2 {
	
	private int[] nums;
	private int operationCount;
	private boolean minOpCountFound;
	private int[] trimArr;

	public int minOperations(int[] nums, int x) {
		this.nums = nums;
		//this.isVisited = new boolean[nums.length][nums.length];
		trimArr = new int[nums.length];
		this.operationCount = Integer.MAX_VALUE;
		tryReduce(0, nums.length-1, x, 1);		
		return (operationCount == Integer.MAX_VALUE)?-1:operationCount;
    }//end method
	
	/**
	 * recursively reduce target value
	 * Precondition: it is assumed that required data structures and references are instantiated / initialized / set properly
	 * nums, trimArr
	 * 
	 * @param leftInx int - left bound index
	 * @param rightInx int - right bound index
	 * @param currTarget int - current target number to reduce
	 * @param opCount int - operation count
	 */
	private void tryReduce(int leftInx, int rightInx, int currTarget, int opCount) {
		//System.out.println(leftInx +"," + rightInx + " target: " + currTarget + " opCount: " + opCount + " globalCount: " + operationCount);

		if (minOpCountFound || opCount >= operationCount) {
			return;
		}//fi	

		if (trimArr[leftInx]!=0&&rightInx<=leftInx+trimArr[leftInx]) {	
			return;
		}//fi

		
		//base case:
		if (leftInx==rightInx) {
			if (nums[leftInx]<currTarget){ // all elements subtracted but still not enough
				operationCount = -1; 
			} else if (nums[leftInx]>currTarget) { //subtracted too much element
				//do nothing
			} else {
				operationCount = opCount;  
				minOpCountFound = true;
			}//fi
			return;
		}//fi
		
		int diff;		
		//try left most element
		diff = currTarget - nums[leftInx];
		if (diff < 0) {
			//System.out.println("gone here 2");
			trimArr[leftInx+1]= rightInx-leftInx+1;
			//do nothing
		} else if (diff > 0) {
			tryReduce(leftInx+1, rightInx, diff, opCount+1);
		} else { // left diff == 0
			if (opCount < operationCount) {
				operationCount = opCount; 
			}//fi
			return;
		}//fi
		
		//try right most element
		diff = currTarget - nums[rightInx];
		if (diff < 0) {
			//System.out.println("gone here 3");
			trimArr[leftInx]= rightInx-leftInx+1;
			//do nothing
		} else if (diff > 0) {
			tryReduce(leftInx, rightInx-1, diff, opCount+1);
		} else { // right diff == 0
			if (opCount < operationCount) {
				operationCount = opCount; 
			}//fi
			return;
		}//fi				
		
		
	}//end method
	
	
}//end class
