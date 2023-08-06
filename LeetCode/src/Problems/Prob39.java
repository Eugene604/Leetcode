package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob39 {
	public static int[] arr1 = {2,3,6,7};
	public static int[] arr2 = {2,3,5};
	public static int[] arr3 = {2};
	public static int[] arr4 = {-1,-2,-3,-4,-5};

	
	public static void main(String[] args) {
		test();
	}//end main
	
	public static void test() {
		Solution39 solObj = new Solution39();
		int[] arr;
		int target;
		
		arr = arr1;
		target = 7;
		System.out.println("sol: " + solObj.combinationSum(arr, target));
		
		arr = arr2;
		target = 8;
		System.out.println("sol: " + solObj.combinationSum(arr, target));
		
		arr = arr3;
		target = 1;
		System.out.println("sol: " + solObj.combinationSum(arr, target));
	}//end method

}//end class

class Solution39 {
	
	private static int[] candidateArr;
	private static int[] candidateFreqArr = new int[30];	
	private List<List<Integer>> ansList = new ArrayList<>(150);	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	//ansList.clear();
    	candidateArr = candidates;
    	Arrays.sort(candidateArr);
    	searchCombination(candidateArr.length-1, target);
        return ansList;
    }//end method
    
    /**
     * recursively search for combinations
     * @param currInx - int value that denotes the candidate index we are working on in current iteration 
     * @param currTarget - int value that represents the target value of current iteration
     */
    private void searchCombination(int currInx, int currTarget) {
    	
    	//base case
    	if (currInx == 0) {
    		if (currTarget % candidateArr[0] == 0) {
    			candidateFreqArr[0] = currTarget / candidateArr[0];
    			addCurrFreqToAnsList();
    			return;
    		} else {
    			return;
    		}//fi    		
    	}//fi
    	
    	candidateFreqArr[currInx] = 0;
    	int tmpTarget = currTarget;
    	while (tmpTarget >= 0) {    		
    		searchCombination(currInx-1, tmpTarget);
    		candidateFreqArr[currInx]++;
    		tmpTarget -= candidateArr[currInx];
    	};//end while
    }//end method
    
    /**
     * precondition:
     *  - candidate frequency list is populated and yields correct combination
     *  - Answer list is initialized
     */
    private void addCurrFreqToAnsList() {
    	//List<Integer> currCombin = new LinkedList<>();
    	List<Integer> currCombin = new ArrayList<>(20);
    	int j;
    	for (int i = 0; i < candidateArr.length; i++) {    		
    		for (j = candidateFreqArr[i]; j > 0; j--) {
    			currCombin.add(candidateArr[i]);
    		};//end while
    	}//rof
    	ansList.add(currCombin);
    }//end method
    
    
}//end class