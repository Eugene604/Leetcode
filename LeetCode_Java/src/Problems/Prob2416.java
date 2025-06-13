package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2416 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		
				
		Solution2416 solObj = new Solution2416();
		String[] words;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		words = objectMapper.readValue("[\"abc\",\"ab\",\"bc\",\"b\"]", new TypeReference<String[]>() {});
		System.out.println("ans: " + Arrays.toString(solObj.sumPrefixScores(words)));
		
		/*
		
		//*/


	}//end method

	public static void main(String[] args) {
		try {
			test();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Solution2416 {
	
	static class Trie{
		
		static final int CHAR_CODE_OFFSET = 97;
		
		static Trie rootTrie;
		
		static int[] scoreCntArr;
		
		static List<Trie>[] associatedTrieArr;
		
		Trie[] childrenArr; //a=0, b=1...z=25
		
		int matchCnt;
				
        /**
         * Initializes the Trie structure for a new set of words.
         * 
         * Precondition:
         * - scoreArr must be initialized with the length equal to the number of words.
         * 
         * Postcondition:
         * - A new rootTrie is created.
         * - scoreCntArr is assigned to track the score for each word.
         * - associatedTrieArr is initialized with empty lists for each word to store Trie nodes.
         * 
         * @param scoreArr An array to store the score counts for each word.
         */
		@SuppressWarnings("unchecked")
		static public void flushNumTrie(int[] scoreArr) {
			Trie.rootTrie = new Trie();
			Trie.scoreCntArr = scoreArr;
			associatedTrieArr = new List[scoreArr.length];
			for (int i=0; i<scoreArr.length; i++) {
				associatedTrieArr[i] = new ArrayList<>(10);
			}//rof
		}//end method
		
        /**
         * Default constructor for the Trie class.
         * 
         * Initializes a new Trie node with an empty array of children and a match count of 0.
         */
		public Trie() {
			childrenArr = new Trie[26];
			matchCnt = 0;
		}//end constructor
		

        /**
         * Adds a child node for the given character and associates it with a word index.
         * 
         * Precondition:
         * - chr must be a lowercase English letter.
         * 
         * Postcondition:
         * - A new Trie node is created if no child node exists for the character.
         * - The match count for the child node is incremented.
         * - The child node is associated with the provided word index.
         * 
         * @param chr - char, The character to be added as a child node.
         * @param associatedWordInx - int, The index of the word that is associated with this character.
         * @return Trie, The child Trie node corresponding to the character.
         */
		private Trie addChildChar(char chr, int associatedWordInx) {
			int childInx = chr - CHAR_CODE_OFFSET;
			if (this.childrenArr[childInx] == null) {
				this.childrenArr[childInx] = new Trie();
			}//fi	
			this.childrenArr[childInx].matchCnt++;
			associatedTrieArr[associatedWordInx].add(this.childrenArr[childInx]);			
			//System.out.println("child trie node created, its associated word inx arr: " + this.childrenArr[childInx].associatedWordInxList);
			return this.childrenArr[childInx];
		}//end method
		
		

        /**
         * Inserts a word into the Trie structure.
         * 
         * Precondition:
         * - word must not be null.
         * 
         * Postcondition:
         * - The Trie is updated with the characters of the word.
         * - Each character of the word creates or navigates through a Trie node.
         * 
         * @param word - String, The word to be inserted into the Trie.
         * @param associatedWordInx - int, The index of the word being inserted.
         */
		static public void pushWordToTrie(String word, int associatedWordInx) {

			Trie currTrieNode = Trie.rootTrie;
			
			for (int wordCharInx = 0; wordCharInx < word.length(); wordCharInx++) {				
				currTrieNode = currTrieNode.addChildChar(word.charAt(wordCharInx), associatedWordInx);				
			}//rof								
		}//end method
		
        /**
         * Updates the score counts for each word based on the match count of the associated Trie nodes.
         * 
         * Postcondition:
         * - For each word, the score count is updated by summing the match counts of the Trie nodes associated with that word.
         */
		static public void updateScoreCount() {
			for (int i=0; i<associatedTrieArr.length; i++) {				
				for (Trie node:associatedTrieArr[i]) {
					scoreCntArr[i] += node.matchCnt;
				}//rof
			}//rof	
		}//end method
		
	}//end class
	
    public int[] sumPrefixScores(String[] words) {
    	int[] scoreCntArr = new int[words.length];
    	Trie.flushNumTrie(scoreCntArr);
    	
    	//step 1: build trie
    	for (int i=0; i<words.length; i++) {
    		Trie.pushWordToTrie(words[i], i);
    	}//fi
    	
    	//step 2: update match cnt to score count array
    	Trie.updateScoreCount();
    	
        return scoreCntArr;
    }//end method
	
        

}// end class
