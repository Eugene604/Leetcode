package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1630 {
	public static int[] nums1 = {4,6,5,9,3,7};
	public static int[] nums2 = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
	public static int[] range1 = {0,0,2};
	public static int[] range2 = {2,3,5};
	public static int[] range3 = {0,1,6,4,8,7};
	public static int[] range4 = {4,4,9,7,9,10};

	
	public static void main(String[] args) {
		
		Solution1630 solObj = new Solution1630();
		int[] nums, l, r;
		nums = nums1;
		l = range1;
		r = range2;
		System.out.println("nums: " + Arrays.toString(nums));
		System.out.println("sol: " + solObj.checkArithmeticSubarrays(nums, l, r));
	}

}

class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    	List<Boolean> ansList = new ArrayList<>(l.length);
    	int[] tmpArr;
    	int i, diff;
    	RANGE_LOOP:
    	for (int rangeInx=0; rangeInx<l.length; rangeInx++) {
    		tmpArr = Arrays.copyOfRange(nums, l[rangeInx],r[rangeInx]+1);
    		Arrays.sort(tmpArr);    		
    		diff = tmpArr[1]-tmpArr[0];
    		for (i=2; i<tmpArr.length; i++) {
    			if (tmpArr[i]-tmpArr[i-1] != diff) {
    				ansList.add(false);
    				continue RANGE_LOOP;
    			}//fi
    		}//rof
    		ansList.add(true);
    	}//rof
        return ansList;
    }//end method
}//end class