package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1282 {
	public static int[] arr1 = {3,3,3,3,3,1,3};
	public static int[] arr2 = {2,1,3,3,3,2};

	

	
	public static void main(String[] args) {
		Solution1282 solObj = new Solution1282();
		List<List<Integer>> sol;
		/*

 		//*/
		sol = solObj.groupThePeople(arr1);

		System.out.println("sol: " + sol.toString());		
	}

}


class Solution1282 {
	 	

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
    	
    	Map <Integer, List<Integer>> groupSizePIDMap = new HashMap<>();
 
    	//step 1. populate group size to people ID map
    	List<Integer> pIDList;
    	for (int i = 0; i < groupSizes.length; i++) {
    		if ((pIDList = groupSizePIDMap.get(groupSizes[i]))==null){
    			pIDList = new ArrayList<>(100);
    			groupSizePIDMap.put(groupSizes[i], pIDList);
    		}//fi
    		pIDList.add(i);
    	}//rof
    	
    	//step 2. populate group list based on group size to people ID map 	
    	List<List<Integer>> groupList = new ArrayList<>(500);
    	for (Entry<Integer, List<Integer>> mapEntry:groupSizePIDMap.entrySet()) {
    		for (int g = 0; g < mapEntry.getValue().size()/mapEntry.getKey(); g++) {
    			List<Integer> tmpList = new ArrayList<>(mapEntry.getKey());
        		for (int i = 0; i < mapEntry.getKey(); i++) {
        			tmpList.add(mapEntry.getValue().get(i*g+i));
        		}//rof
        		groupList.add(tmpList);
    		}//rof
    	}//rof
        return groupList;
    }//end method
}//end class