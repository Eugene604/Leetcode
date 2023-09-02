package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob1 {
	public static int[] arr1 = {255,1,2,3,7,11,15};
	public static int[] arr2 = {1,3,3,2};
	public static int[] arr3 = {3,3};
	public static int[] arr4 = {-1,-2,-3,-4,-5};
	public static int target = 9;
	
	public static void main(String[] args) {
		Solution1 solObj = new Solution1();
		int[] sol = solObj.twoSum(arr1, target);
		System.out.println("sol: " + Arrays.toString(sol));
	}

}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        
        for(int i = 1; i < nums.length; i++){
             for(int j = i; j < nums.length; j++){
                 System.out.println("Checking: " + j + " , " + (j-i) );
                 if(nums[j] + nums[j-i] == target){
                     return new int[]{j-i,j};
                 }
             }
            
         }
         return null;
     }
    
    public int[] twoSumDavid(int[] nums, int target) {
    	int currPos;
    	int[] sol = new int[2];
    	Map<Integer, Integer> valPosMap = new HashMap<>(); //map < int value, array position>
    	
    	//first iteration: check first item by linear search rest of array and meanwhile store them in the hash map
		for (currPos = 1; currPos < nums.length; currPos++) {
			if (nums[0] + nums[currPos] == target) {
				sol[0] = 0;
				sol[1] = currPos;
				return sol;
			} else {
				valPosMap.put(nums[currPos], currPos);
			}//fi
		}//rof
 		
    	    	  	
    	//map phase: do hashmap lookup for value - position pair
		//System.out.println("map built: " + valPosMap.toString());
    	Integer pos;
    	for (currPos=1; currPos < nums.length; currPos++) {
    		pos = valPosMap.get(target - nums[currPos]);
    		if (pos == null) {
    			continue;
    		} else if (pos == currPos) {
    			valPosMap.remove(pos);
    		} else {
				sol[0] = currPos;
				sol[1] = pos;
				return sol;
			}//fi   		
    	}
		return sol;
    }
}