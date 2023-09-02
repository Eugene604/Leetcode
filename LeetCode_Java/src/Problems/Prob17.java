package Problems;

import java.util.*;

public class Prob17 {

	

	
	public static void main(String[] args) {
		Solution17 solObj = new Solution17();
		String digits;
	
		
		digits = "2";
		System.out.println("Digits: " + digits + " : " + solObj.letterCombinations(digits));
		
		digits = "";
		System.out.println("Digits: " + digits + " : " + solObj.letterCombinations(digits));
		//*/

		digits = "23";
		System.out.println("Digits: " + digits + " : " + solObj.letterCombinations(digits));

	}

}


class Solution17 {
	
	private static final List<List<Character>> PHONE_PAD_LIST;
	private List<String> ansList = new LinkedList<>();
	
	static {
		PHONE_PAD_LIST = new ArrayList<>(58);
		for (int i=1; i<=50; i++) {
			PHONE_PAD_LIST.add(null);
		}//rof
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('a','b','c')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('d','e','f')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('g','h','i')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('j','k','l')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('m','n','o')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('p','q','r','s')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('t','u','v')));
		PHONE_PAD_LIST.add(new LinkedList<Character>(Arrays.asList('w','x','y','z')));
	}//end static
	 	
    public List<String> letterCombinations(String digits) {
    	ansList.clear();
    	if (digits.length() == 0) {
    		return ansList;
    	}//fi
    	StringBuilder sb = new StringBuilder();
    	buildLetterCombin(0, digits, sb);
        return ansList;
    }//end method
    
    /**
     * Recursive method that builds letter combinations
     * @param level - the array index it is to process, it is assumed that this value is valid
     * @param digits - assumed to be none zero length
     * @param sb - stringBuilder object
     */
    private void buildLetterCombin(int level, String digits, StringBuilder sb) {
    	List<Character> charList = PHONE_PAD_LIST.get(digits.charAt(level));    	
    	int nextLevel = level + 1;
    	sb.append(' ');
		
		if (nextLevel == digits.length()) {
	    	for (Character c:charList) {
	    		sb.setCharAt(level, c);
	    		ansList.add(sb.toString());
	    	}//rof
	    	sb.deleteCharAt(level);
	    	return;
		}//fi  
		

    	for (Character c:charList) {
    		sb.setCharAt(level, c);
    		buildLetterCombin(nextLevel, digits, sb);	
    	}//rof	
    	sb.deleteCharAt(level);
    }//end method
    
}//end class