package Problems;

import java.util.*;

public class Prob46 {

	
	static int[] arr1 = {1,2,3};
	static int[] arr2 = {0,1};
	static int[] arr3 = {1};
	static int[] arr4 = {1,3,2};
	static int[] arr5 = {1,5,1};
	static int[] arr6 = {2,1,2,2,2,2,2,1};
	
	static void test() {
		Solution46 solObj = new Solution46();
		int[] arr;
		
	
		arr = arr1;
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("processed list: " + solObj.permute(arr));
		
		//*/
		
		arr = arr2;
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("processed list: " + solObj.permute(arr));
		
		arr = arr3;
		System.out.println("orignal arr: " + Arrays.toString(arr));
		System.out.println("processed list: " + solObj.permute(arr));	
	}
	
	public static void main(String[] args) {
		test();

	}

}

class Solution46 {
	
	private int[] modelArr;
	private int[] unoccupiedArr;
	private LinkedList<List<Integer>> ansList;
	
    public List<List<Integer>> permute(int[] nums) {  
    	ansList = new LinkedList<>();
    	//special case
    	if (nums.length==1) {
    		ansList.add(new ArrayList<>(1));
    		ansList.getFirst().add(nums[0]);
    		return ansList;
    	}//rof
    	
    	modelArr = new int[nums.length];
    	unoccupiedArr = nums;

    	populatePermute(0, modelArr);     
        return ansList;
    }//end method
    
    /**
     * Precondition: data structures are set and/or initialized
     * - numArr
     * - ansList
     * - unoccupiedArr
     * Postcondition:
     *  ansList filled
     * @param level - int value indicating current level
     * @param modelArr - int[] that stores partial list of current iteration
     */
    private void populatePermute(int level, int[] modelArr) {       
    	//base case
    	if (level == unoccupiedArr.length-1) {
    		for (int unoccupiedNum:unoccupiedArr) {
    			if (unoccupiedNum == Integer.MIN_VALUE) {
    				continue;
    			} else {
    				modelArr[level] = unoccupiedNum;
    				break;
    			}//fi
    		}//rof
    		List<Integer> currList = new ArrayList<>(modelArr.length);		
    		ansList.add(currList); 
    		for (int num:modelArr) {
    			currList.add(num);
    		}//rof
    		return;
    	}//fi
    	
    	for (int i=0; i<unoccupiedArr.length; i++) {
			if (unoccupiedArr[i] == Integer.MIN_VALUE) {
				continue;
			}//fi
			modelArr[level] = unoccupiedArr[i];
			unoccupiedArr[i] = Integer.MIN_VALUE;
			populatePermute(level+1, modelArr);       			
			unoccupiedArr[i] = modelArr[level];
    	}//rof
    }//end method
}//end class

class Solution46_v1 {
	private static final int[] FACTORIALS = {0,1,2,6,24,120,720};
    public List<List<Integer>> permute(int[] nums) {  
    	TreeSet<Integer> unoccupiedSet = new TreeSet<>();
    	for(int num:nums) {
    		unoccupiedSet.add(num);
    	}//rof
    	int lastInx = nums.length-1;
    	List<List<Integer>> ansList = new ArrayList<>(FACTORIALS[nums.length]);
    	ansList.add(0, new ArrayList<>(nums.length));
    	Integer setEle;
    	while ((setEle = unoccupiedSet.pollFirst())!=null) {
    		ansList.get(0).add(setEle);
    	}//rof
    	    	

    	int currLevel;   
    	for (int i=1; i<FACTORIALS[nums.length]; i++) {
    		List<Integer> currList = new ArrayList<>(ansList.get(i-1));
    		ansList.add(i,currList);
    		unoccupiedSet.add(currList.get(lastInx));
    		currLevel = lastInx-1;
    		while (currList.get(currLevel) > unoccupiedSet.last()) {
    			unoccupiedSet.add(currList.get(currLevel));
    			currLevel--;
    		}//end while
    		unoccupiedSet.add(currList.get(currLevel));
    		currList.set(currLevel, unoccupiedSet.higher(currList.get(currLevel)));
    		unoccupiedSet.remove(currList.get(currLevel));  	
        	while ((setEle = unoccupiedSet.pollFirst())!=null) {
        		currList.set(++currLevel, setEle);
        	}//rof
    	}//rof
        return ansList;
    }//end method	
}//end class