package Problems;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob140 {


	
	public static void main(String[] args) {
		Solution140 solObj = new Solution140();
		String s;
		List<String> wordDict;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
       
            wordDict = mapper.readValue("[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]", mapper.getTypeFactory().constructCollectionType(ArrayList.class, String.class));
            s = "catsanddog";
    		System.out.println("s: " + s);
    		System.out.println("wordDict: " + wordDict);
    		System.out.println("Ans: " + solObj.wordBreak(s, wordDict));
    		
    
    	    /*
    		wordDict = mapper.readValue("[\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]", mapper.getTypeFactory().constructCollectionType(ArrayList.class, String.class));
            s = "catsandog";
    		System.out.println("s: " + s);
    		System.out.println("wordDict: " + wordDict);
    		System.out.println("Ans: " + solObj.wordBreak(s, wordDict));
            //*/
        } catch (Exception e) {
            e.printStackTrace();
        }


	}

}



class Solution140 {
			
	List<List<String>> sentenceCache;
	String theMainString;
	List<List<Integer>> charWordInxList; //stores word indices for all words that start with this character
	List<String> wordDict;
	
    public List<String> wordBreak(String s, List<String> wordDict) {
    	this.theMainString = s;
    	this.wordDict = wordDict;
    	
    	//step 1, populate character to word index list also prepare dp array
    	this.charWordInxList = new ArrayList<>(s.length());
    	sentenceCache = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
        	this.charWordInxList.add(new ArrayList<>());
        	this.sentenceCache.add(null);
        }//rof 
        
    	boolean[] isCoveredArr = new boolean[s.length()];    	
    	for (int dictInx = 0; dictInx < wordDict.size(); dictInx++) {
    		for (Integer charInx:findAllOccurrences(s, wordDict.get(dictInx))) {
    			charWordInxList.get(charInx).add(dictInx);
    			for (int isCoveredInx = charInx; isCoveredInx < charInx + wordDict.get(dictInx).length(); isCoveredInx++) {
    				isCoveredArr[isCoveredInx] = true;
    				//System.out.println(isCoveredInx);
    			}//rof
    		}//rof      	
    	}//rof
    	//System.out.println(Arrays.toString(isCoveredArr));
    	//System.out.println(sentenceCache);
    	
    	//step 2, check if all characters are covered, if not we can simply return empty list
    	for (boolean isCovered:isCoveredArr) {
    		if (!isCovered) {
    			return new ArrayList<>();
    		}//fi
    	}//rof 

    	//step 3, recursively traverse charWordInxList and populate list of sentence combinations
    	List<String> sentenceList = populateSentence(0);
        return sentenceList;
    }//end method
    

    /**
     * 
     * use dfs to search for possible combinations
     * precondition: 
     * - currCharInx is assumed to be valid which is within the bound of string length
     * - charWordInxList, wordDict, theMainString are assumed to be correctly set and/or populated
     * 
     * 
     * @return List<String> if this list is empty, that means sub string after current char inx cannot be segmented
     */
    private List<String> populateSentence(int currCharInx) {
    	if (sentenceCache.get(currCharInx) != null) {
    		return sentenceCache.get(currCharInx);
    	}//fi
    	
    	List<String> currSentenceList = new ArrayList<>();    	
    	String word;
    	int nextCharInx;
    	for (int wordInx : charWordInxList.get(currCharInx)) {
    		word = wordDict.get(wordInx);
    		nextCharInx = currCharInx + word.length();
    		if (nextCharInx == theMainString.length()) {//has reached end of the main string
    			currSentenceList.add(word);
    			continue;
    		} else if (nextCharInx > theMainString.length()) {//has exceeded length of the string if include this word
    			continue; //do nothing    			
    		} else {//still more characters to go
        		for (String nextSentence : populateSentence(nextCharInx)) {
        			currSentenceList.add(word + " " + nextSentence);
        		}//rof
    		}//fi     		
    	}//rof
    	sentenceCache.set(currCharInx, currSentenceList);
    	return currSentenceList;
    }//end method
    
    /**
     * Finds all occurrences of a word within a given string.
     * 
     * @param str - String, The input string to search within.
     * @param wrd - String, The word to find occurrences of within the input string.
     * @return List<Integer> A list containing the indices of all occurrences of the word within the input string.
     */
    private static List<Integer> findAllOccurrences(String str, String wrd) {
    	//System.out.println("find word: " + wrd + " in string: " + str);
        List<Integer> inxList = new ArrayList<>();
        int index = str.indexOf(wrd);
        
        while (index >= 0) {
            inxList.add(index);
            index = str.indexOf(wrd, index + 1);
        }//end while
        //System.out.println("inxList: " + inxList);
        return inxList;
    }//end method
    
    
}//end class

