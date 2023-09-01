package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob49 {
	public static String[] arr1 = {"eat","tea","tan","ate","nat","bat"};
	public static String[] arr2 = {"a"};
	public static String[] arr3 = {""};

	
	public static void main(String[] args) {
		Solution49 solObj;
		List<List<String>> sol;
		String[] arr;
		
		/*
		
		 //*/
		arr = arr1;
		solObj = new Solution49();
		sol = solObj.groupAnagrams(arr);		
		System.out.println("sol: " + sol.toString());		
		
		arr = arr2;
		solObj = new Solution49();
		sol = solObj.groupAnagrams(arr);		
		System.out.println("sol: " + sol.toString());		
		
		arr = arr3;
		solObj = new Solution49();
		sol = solObj.groupAnagrams(arr);		
		System.out.println("sol: " + sol.toString());		
	}

}

class Solution49 {
 	
	private List<List<String>> ansList = new LinkedList<>();
	
	private Map<String, List<String>> anagramMap = new HashMap<>();
	
    public List<List<String>> groupAnagrams(String[] strs) {    	
    	//1. populate anagramMap
    	List<String> currStrList;
    	String key;
    	char[] tmpCArr;
    	for (String str:strs) {
    		tmpCArr = str.toCharArray();
    		Arrays.sort(tmpCArr);
    		key = new String(tmpCArr); 		
    		if ((currStrList = anagramMap.get(key))==null) {
    			currStrList = new LinkedList<>();
    			anagramMap.put(key, currStrList);
    		}//fi
    		currStrList.add(str);	
    	}//rof
    	//2. put map values into answer list    	
    	for (List<String> strList:anagramMap.values()) {
    		ansList.add(strList);
    	}//rof */
        return ansList;
    }//end method
}//end class

class Solution49_v2{
	 	
	private List<List<String>> ansList = new LinkedList<>();
	
	private Map<List<Character>, List<String>> anagramMap = new HashMap<>();
	
    public List<List<String>> groupAnagrams(String[] strs) {    	
    	//1. populate anagramMap
    	List<String> currStrList;
    	ArrayList<Character> key;
    	for (String str:strs) {
    		key = new ArrayList<>(str.length());
    		for(int i=0;i<str.length();i++) {
    			key.add(str.charAt(i));
    		}//rof
    		key.sort(null);
    		//System.out.println("sorted: " + key);
    		
    		if ((currStrList = anagramMap.get(key))==null) {
    			currStrList = new LinkedList<>();
    			anagramMap.put(key, currStrList);
    		}//fi
    		currStrList.add(str);	
    	}//rof
    	//2. put map values into answer list
    	for (List<String> strList:anagramMap.values()) {
    		ansList.add(strList);
    	}//rof
        return ansList;
    }//end method
}//end class