package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob451 {
	

	
	public static void test() {

		Solution451 solObj = new Solution451();

		String num;

	
		
		String num1 = "tree";
		String num2 = "cccaaa";
		String num3 = "RILmT0oZF8";
		

		num = num3;
		System.out.println(num + " ans: " + solObj.frequencySort(num));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution451 {

	public static int[] charCnt = new int[123];
    public String frequencySort(String s) {
    	//step 1, count characters
    	Arrays.fill(charCnt, 48, 123, 0);
    	for (int i=0; i<s.length(); i++) {
    		charCnt[s.codePointAt(i)]++;
    	}//rof
    	
    	//step 2, build count to character list tree map
    	TreeMap<Integer, List<Character>> freqCharMap = new TreeMap<>();
    	List<Character> charList;
    	for (int i=48; i<123; i++) {
    		if (charCnt[i] == 0) {
    			continue;
    		} else if ((charList = freqCharMap.get(charCnt[i])) == null) {
    			charList = new ArrayList<>(10);
    			freqCharMap.put(charCnt[i], charList);
    		}//fi
    		charList.add((char)i);
    	}//rof
    	//System.out.println(freqCharMap);
    	
    	//step 3, reverse iterate over tree map to obtain answer
    	StringBuilder sb = new StringBuilder();
    	for (Entry<Integer, List<Character>> entry : freqCharMap.descendingMap().entrySet()) {
    		for (Character c:entry.getValue()) {
    			for (int i=0; i<entry.getKey(); i++) {
    				sb.append(c);
    			}//fi
    		}//rof
    	}//rof
        return sb.toString();
    }//end method   
}//end class
