package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob40 {
	public static int[] arr1 = {10,1,2,7,6,1,5};
	public static int[] arr2 = {2,5,2,1,2};
	public static int[] arr3 = {2};
	public static int[] arr4 = {-1,-2,-3,-4,-5};

	
	public static void main(String[] args) {
		test();
	}//end main
	
	public static void test() {
		Solution40 solObj = new Solution40();
		int[] arr;
		int target;
		
		arr = arr1;
		target = 8;
		System.out.println("sol: " + solObj.combinationSum2(arr, target));
		//*/
		
		arr = arr2;
		target = 5;
		System.out.println("sol: " + solObj.combinationSum2(arr, target));
		
	}//end method

}//end class

class Solution40 {
	
	private static int[] candidateFreqArr;
	private static int[] candidateMaxFreqArr;
	private List<List<Integer>> ansList = new ArrayList<>(150);	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	buildDataStruct(candidates);
    	//System.out.println("candidateFreqArr: " + Arrays.toString(candidateFreqArr));
    	//System.out.println("candidateMaxFreqArr: " + Arrays.toString(candidateMaxFreqArr));
    	searchCombination(50, target);
        return ansList;
    }//end method
    
    /**
     * build required data structures given int candidates
     * precondition:
     *  - 1 <= candidates[i] <= 50
     * postcondition:
     *  - candidateMaxFreqArr is populated and stores maximum allowed frequencies where index value represents the candidate value
     * @param candidates int array
     */
    private void buildDataStruct(int[] candidates) {
    	candidateFreqArr = new int[51];
    	candidateMaxFreqArr = new int[51];
    	for (int currCand:candidates ) {		
    	    candidateMaxFreqArr[currCand]++;
    	}//rof
    }//end method
    /**
     * recursively search for combinations
     * @param currInx - int value that denotes the candidate index we are working on in current iteration 
     * @param currTarget - int value that represents the target value of current iteration
     */
    private void searchCombination(int currInx, int currTarget) {
    	
    	int maxFrequency =  candidateMaxFreqArr[currInx];
    	
    	//base case
    	if (currInx == 1) {
    		if (maxFrequency >= currTarget) {
    			candidateFreqArr[1] = currTarget;  			
    			addCurrFreqToAnsList();
    			return;
    		} else {
    			return;
    		}//fi    		
    	}//fi
    	
    	if (maxFrequency == 0) {
    		searchCombination(currInx-1, currTarget);
    		return;
    	}//fi
    	
    	candidateFreqArr[currInx] = 0;
    	int tmpTarget = currTarget;
    	while (tmpTarget >= 0 && candidateFreqArr[currInx] <= maxFrequency) {    		
    		searchCombination(currInx-1, tmpTarget);
    		candidateFreqArr[currInx]++;
    		tmpTarget -= currInx;
    	};//end while
    }//end method
    
    /**
     * precondition:
     *  - candidate frequency list is populated and yields correct combination
     *  - Answer list is initialized
     */
    private void addCurrFreqToAnsList() {
    	//List<Integer> currCombin = new LinkedList<>();
    	List<Integer> currCombin = new ArrayList<>(50);
    	int j;
    	for (int i = 1; i <= 50; i++) {    		
    		for (j = candidateFreqArr[i]; j > 0; j--) {
    			currCombin.add(i);
    		};//end while
    	}//rof
    	ansList.add(currCombin);
    }//end method
    
    
}//end class

class Solution40_1 {
	
	private static int[] candidateArr = new int[100];
	private static int[] candidateFreqArr = new int[100];
	private static int[] candidateMaxFreqArr = new int[100];
	private static int candidateArrEndInx;
	private List<List<Integer>> ansList = new ArrayList<>(150);	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	ansList.clear();
    	buildDataStruct(candidates);
    	//System.out.println("candidates: " + Arrays.toString(candidates));
    	//System.out.println("candidateArr: " + Arrays.toString(candidateArr) + " candidateArrEndInx: " + candidateArrEndInx);
    	//System.out.println("candidateMaxFreqArr: " + Arrays.toString(candidateMaxFreqArr));
    	searchCombination(candidateArrEndInx, target);
        return ansList;
    }//end method
    
    /**
     * build required data structures given int candidates
     * precondition:
     *  - 1 <= candidates.length <= 100
     * postcondition:
     *  - candidateArr is populated and stores unique numbers
     *  - candidateMaxFreqArr is populated and stores maximum allowed frequencies
     * @param candidates int array
     */
    private void buildDataStruct(int[] candidates) {
    	Arrays.sort(candidates);
    	int currUniqCandInx = 0;
    	candidateArr[0] = candidates[0];
    	candidateMaxFreqArr[0] = 0;
    	for (int currCand:candidates ) {
    		if (candidateArr[currUniqCandInx] == currCand) {
    			candidateMaxFreqArr[currUniqCandInx]++;
    		} else {
    			currUniqCandInx++;
    			candidateArr[currUniqCandInx] = currCand;
    	    	candidateMaxFreqArr[currUniqCandInx] = 1;
    		}//fi
    	}//rof
    	candidateArrEndInx = currUniqCandInx;
    }//end method
    /**
     * recursively search for combinations
     * @param currInx - int value that denotes the candidate index we are working on in current iteration 
     * @param currTarget - int value that represents the target value of current iteration
     */
    private void searchCombination(int currInx, int currTarget) {
    	
    	int maxFrequency =  candidateMaxFreqArr[currInx];
    	
    	//base case
    	if (currInx == 0) {
    		if (currTarget % candidateArr[0] == 0) {
    			candidateFreqArr[0] = currTarget / candidateArr[0];
    			if (candidateFreqArr[0] <= maxFrequency) {
    				addCurrFreqToAnsList();
    			}//fi
    			return;
    		} else {
    			return;
    		}//fi    		
    	}//fi
    	
    	candidateFreqArr[currInx] = 0;
    	int tmpTarget = currTarget;
    	while (tmpTarget >= 0 && candidateFreqArr[currInx] <= maxFrequency) {    		
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
    	List<Integer> currCombin = new ArrayList<>(50);
    	int j;
    	for (int i = 0; i <= candidateArrEndInx; i++) {    		
    		for (j = candidateFreqArr[i]; j > 0; j--) {
    			currCombin.add(candidateArr[i]);
    		};//end while
    	}//rof
    	ansList.add(currCombin);
    }//end method
    
    
}//end class