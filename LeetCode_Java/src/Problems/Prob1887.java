package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1887 {
	public static int[] arr1 = {5,1,3};
	public static int[] arr2 = {1,1,1};
	public static int[] arr3 = {1,1,2,2,3};
	public static int[] arr4 = {9926,9960,10000,9992,9917,9986,9934,9985,9977,9950,9922,9913,9971,9978,9984,9959,9934,9948,9918,9916,9967,9965,9985,9977,9988,9983,9900,9945,9913,9966,9968,9986,9939,9914,9980,9957,9921,9927,9917,9972,9974,9953,9984,9912,9975,9920,9966,9932,9921,9904,9928,9959,9993,9937,9934,9974,9937,9964,9922,9963,9991,9930,9944,9930,9982,9980,9967,9904,9955,9947,9924,9973,9997,9950,9905,9924,9990,9947,9953,9924,9977,9938,9951,9982,9932,9926,9928,9912,9917,9929,9924,9921,9987,9910,9927,9921,9929,9937,9919,9995,9949,9953};
	public static int[] arr5 = {0,0,0};
	public static int[] arr6 = {13,252,-87,-431,-148,387,-290,572,-311,-721,222,673,538,919,483,-128,-518,7,-36,-840,233,-184,-541,522,-18872,127,-935,-397,761,903,-217,543,906,-503,-826,-342,599,-726,960,-235,436,-91,-511,-793,-658,-143,-524,-609,-728,-734,273,-19,-10,630,-294,-453,149,-581,-405,984,154,-968,623,-631,384,-825,308,779,-7,617,221,394,151,-282,472,332,-5,-509,611,-11887,113,672,-497,-182,307,-592,925,766,-62,237,-8,789,318,-314,-792,-632,-781,375,939,-304,-149,544,-742,663,484,802,61887,501,-269,-458,-763,-950,-390,-81887,683,-219,381,478,-129,602,-931,128,502,508,-565,-243,-695,-943,-987,-692,346,-13,-225,-740,-441,-112,658,855,-531,542,839,795,-664,404,-844,-18874,-709,18877,953,-941,-848,211,-75,792,-208,569,-647,-714,-76,-603,-852,-665,-897,-627,123,-177,-35,-519,-241,-711,-74,420,-2,-101,715,708,256,-307,466,-602,-636,990,857,70,590,-4,610,-151,196,-981,385,-689,-617,827,360,-959,-289,620,933,-522,597,-667,-882,524,181,-854,275,-600,453,-942,134};
	
	public static int[] arr7 = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
	

	
	public static void main(String[] args) {
		Solution1887 solObj;
		int[] arr;
		
		arr = arr2;
		solObj = new Solution1887();
		System.out.println("arr: " + Arrays.toString(arr)); 
		System.out.println("sol: " + solObj.reductionOperations(arr));
		
		arr = arr3;
		solObj = new Solution1887();
		System.out.println("arr: " + Arrays.toString(arr)); 
		System.out.println("sol: " + solObj.reductionOperations(arr));
		
		arr = arr4;
		solObj = new Solution1887();
		System.out.println("arr: " + Arrays.toString(arr)); 
		System.out.println("sol: " + solObj.reductionOperations(arr));
		
	/*
		
		//*/
		
		
		arr = arr1;
		solObj = new Solution1887();
		System.out.println("arr: " + Arrays.toString(arr)); 
		System.out.println("sol: " + solObj.reductionOperations(arr));
	}

}



class Solution1887 {

    public int reductionOperations(int[] nums) {
    	Arrays.sort(nums);
    	
    	int numOfOps = 0;
    	
    	for (int i=1; i<nums.length; i++) {
    		if (nums[i]==nums[i-1]) {
    			//continue;
    		} else {
    			numOfOps += nums.length - i;
    		}//fi
    		
    	}//rof
        return numOfOps;
    }//end method
}//end class