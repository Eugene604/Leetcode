package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob16 {
	public static int[] arr1 = {-1,2,1,-4};
	public static int[] arr2 = {-4,-1,1,2};
	public static int[] arr3 = {2,3,8,9,10};
	public static int[] arr4 = {4,0,5,-5,3,3,0,-4,-5};
	public static int[] arr5 = {0,0,0};
	public static int[] arr6 = {13,252,-87,-431,-148,387,-290,572,-311,-721,222,673,538,919,483,-128,-518,7,-36,-840,233,-184,-541,522,-162,127,-935,-397,761,903,-217,543,906,-503,-826,-342,599,-726,960,-235,436,-91,-511,-793,-658,-143,-524,-609,-728,-734,273,-19,-10,630,-294,-453,149,-581,-405,984,154,-968,623,-631,384,-825,308,779,-7,617,221,394,151,-282,472,332,-5,-509,611,-116,113,672,-497,-182,307,-592,925,766,-62,237,-8,789,318,-314,-792,-632,-781,375,939,-304,-149,544,-742,663,484,802,616,501,-269,-458,-763,-950,-390,-816,683,-219,381,478,-129,602,-931,128,502,508,-565,-243,-695,-943,-987,-692,346,-13,-225,-740,-441,-112,658,855,-531,542,839,795,-664,404,-844,-164,-709,167,953,-941,-848,211,-75,792,-208,569,-647,-714,-76,-603,-852,-665,-897,-627,123,-177,-35,-519,-241,-711,-74,420,-2,-101,715,708,256,-307,466,-602,-636,990,857,70,590,-4,610,-151,196,-981,385,-689,-617,827,360,-959,-289,620,933,-522,597,-667,-882,524,181,-854,275,-600,453,-942,134};
	
	public static int[] arr7 = {-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
	

	
	public static void main(String[] args) {
		Solution16 solObj = new Solution16();
		int target;
		int sol;
		
		/*
		target = 1;
		sol = solObj.threeSumClosest(arr1,target);
		System.out.println("1 sol: " + sol);
		
		target = 1;
		sol = solObj.threeSumClosest(arr2,target);
		System.out.println("2 sol: " + sol); 
		
		target = 16;
		sol = solObj.threeSumClosest(arr3,target);
		System.out.println("3 sol: " + sol);
		
		target = -2;
		sol = solObj.threeSumClosest(arr4,target);
		System.out.println("4 sol: " + sol);
		
		target = 1;
		sol = solObj.threeSumClosest(arr5,target);
		System.out.println("5 sol: " + sol); 
		
		target = -2805;
		sol = solObj.threeSumClosest(arr6,target);
		
		System.out.println("6 sol: " + sol); //*/
		
		target = -14;
		sol = solObj.threeSumClosest(arr7,target);
		System.out.println("7 sol: " + sol);		
	}

}


class Solution16 {
	 	
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	//System.out.println("processing: " + Arrays.toString(nums));
    	int i,j,k;
    	int tMinusI, currDist, globalDist = Integer.MAX_VALUE; 
    	int absCurrDist, absGlobalDist = Integer.MAX_VALUE;
    	for (i = 0; i < nums.length-2; i++) {
    		/*// actually makes program slower
    		if(i>0 && nums[i]==nums[i-1]) {
    			continue;
    		}//fi */
    		tMinusI = target-nums[i];
    		j=i+1;
    		k=nums.length-1;

    		do {  
    			/*//this actually makes program slower
    			while (k-j>1 && nums[j]==nums[j+2]) {
    				j++;
    			}//end while
    			while (k-j>1 && nums[k]==nums[k-2]) {
    				k--;
    			}//end while */
    			currDist = tMinusI - nums[j] - nums[k];
    			absCurrDist = Math.abs(currDist);
    			if (absCurrDist <= absGlobalDist) {
    				absGlobalDist = absCurrDist;
    				globalDist = currDist;
    			}//fi
    			//System.out.println("currDist: " + currDist + ", ijk:" + i + ", " + j + " , " + k);
    			if (currDist < 0) {
    				k--;
    			} else if (currDist > 0) {
    				j++;
    			} else {
    				return target;
    			}//fi			
    		}while (j<k);//end while
    	}//rof
        return target-globalDist;
    }//end method
}//end class