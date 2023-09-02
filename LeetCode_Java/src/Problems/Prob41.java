package Problems;

import java.util.Arrays;

public class Prob41 {
	public static int[] arr1 = {1,2,0};
	public static int[] arr2 = {3,4,-1,1};
	public static int[] arr3 = {7,8,9,11,12};	
	public static int[] arr4 = {1,1};	
	public static int[] arr5 = {2,2};
	public static int[] arr6 = {0,-1,3,1};	
	public static int[] arr7 = {2147483647,100000,1,3,2,4,5,6,7,100001};	
	
	public static void main(String[] args) {
		test();
	}//end main
	
	public static void test() {
		Solution41 solObj;
		int[] arr;
		
		
		solObj = new Solution41();		
		arr = arr1;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));
		
		
	
		solObj = new Solution41();
		arr = arr2;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));
		


		solObj = new Solution41();		
		arr = arr3;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));
		
		
		solObj = new Solution41();		
		arr = arr4;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));
		
		
		solObj = new Solution41();		
		arr = arr5;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));
		
		solObj = new Solution41();		
		arr = arr6;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));	
		
		//*/
		solObj = new Solution41();		
		arr = arr7;
		System.out.println("sol: " + solObj.firstMissingPositive(arr));	
		
	}//end method

}//end class

class Solution41 {
	

	
    public int firstMissingPositive(int[] nums) {
    	int largestPossibleSP = nums.length+1; //largest possible smallest positive value
    	
    	int i = 0, correctVal;
    	while (i < nums.length) {
    		correctVal = nums[i];
    		if (correctVal < 1 || correctVal >= largestPossibleSP) {
    			//System.out.println(Arrays.toString(nums)  + ":" + largestPossibleSP  + ":" + i);
    			nums[i] = -1;
    			largestPossibleSP--;
    			i++;
    		} else if (correctVal == nums.length) {
    			if (nums[0] == nums.length) {
    				i++;
    				continue;
    			}//fi
    			nums[i] = nums[0];
    			nums[0] = nums.length;
    			//System.out.println("processing1 " + i  + ":" + correctVal);    			
    		} else if (correctVal == i || nums[i] == nums[correctVal]) {
    			i++;  			
    		} else {    			 
    			if (nums[correctVal] < 1 || nums[correctVal] >= largestPossibleSP) {
    				//System.out.println("processing2 " + i  + ":" + correctVal);
    				nums[i] = -1;
    				i++;
    			} else {
    				nums[i] = nums[correctVal];		
    			}//fi    						
    			nums[correctVal] = correctVal;   			
    		}//fi
    	}//end while
    	System.out.println(Arrays.toString(nums)  + ":" + largestPossibleSP);
    	for (i=1; i < nums.length; i++) {  		
    		if (nums[i] != i) {
    			return i;
    		}//fi
    	}//rof
    	if (i == nums.length && nums[0]!=nums.length) {
    		return i;
    	}//fi
        return largestPossibleSP;
    }//end method
     
}//end class


class Solution41_v1 {
	
	//private BitSet occurrSet;
	private boolean[] occurrArr;
	
    public int firstMissingPositive(int[] nums) {
    	int largestPossibleSP = nums.length+1; //largest possible smallest positive value
    	//occurrSet = new BitSet(largestPossibleSP+1);
    	occurrArr = new boolean[largestPossibleSP+1];
    	for (int currVal:nums) {
    		if (currVal < 1 || currVal > largestPossibleSP || occurrArr[currVal]) {
    			largestPossibleSP--;
    		} else {
    			//occurrSet.set(currVal);
    			occurrArr[currVal] = true;
    		}//fi    		
    	}//rof
    	for (int i=1; i <= largestPossibleSP; i++) {
    		if (!occurrArr[i]) {
    			return i;
    		}//fi
    	}//rof
        return largestPossibleSP;
    }//end method
     
}//end class
