package Problems;

import java.util.Arrays;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob2849 {
	
	private static int[] testParam1 = {2,4,7,7,6};
	
	static void test() {
		Solution2849 solObj = new Solution2849();
		int[] params;
		
		params = testParam1;
		System.out.println("test param: " + Arrays.toString(params));
		System.out.println("ans: " + solObj.isReachableAtTime(params[0],params[1],params[2],params[3],params[4]));

	}//end method
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    	int longestEdge = Math.max(Math.abs(sx-fx), Math.abs(sy-fy));
    	//special case, same point but t = 1
    	if (longestEdge == 0 && t == 1) {
    		return false;
    	}//fi    	
        return t >= longestEdge;
    }//end method
}//end class


