package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob648 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		
				
		Solution648 solObj = new Solution648();
		List<String> dict;
		String sentence;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*
		sentence = "the cattle was rattled by the battery";
		dict = objectMapper.readValue("[\"cat\",\"bat\",\"rat\",\"catt\"]", new TypeReference<List<String>>() {});;
		System.out.println(dict);
		System.out.println("ans: " + solObj.replaceWords(dict, sentence));
		//*/
		sentence = "cfrbiqbqzveiczjn miwz hv uslvci vuhgzbulkiurzxkiqe nqg rccocvwfp sntmlrrdsqwpvem iyrw kbqwjkfichfrejx lhzylxmbptiwmn v nodg xijddmenifxaffhxxx hpltrapstesvkrnjoqdl mygwsjmgzzoixyo xcnyhbmpkpamtzdrjls wtuddincttwfnai cgxlvdww yqhnapyzkv nmrvpd poimszzov epmiddarizx tlhkwz pqq ardwiezm iowkiammwm ewlotixpfsbhkwphaiv ehitgi eczvbyheauzvho";
		dict = objectMapper.readValue("[\"uxbiw\",\"pb\",\"zmeno\",\"bj\",\"tdjn\",\"fcomt\",\"rdd\",\"z\",\"d\",\"i\",\"gxmxj\",\"swga\",\"t\",\"g\",\"bjoz\",\"siyi\",\"fpp\",\"gpied\",\"qjf\",\"h\",\"dorm\",\"zd\",\"gx\",\"viczg\",\"dewq\",\"tz\",\"dwyxy\",\"o\",\"rtcq\",\"j\"]", new TypeReference<List<String>>() {});;
		System.out.println(dict);
		System.out.println("ans: " + solObj.replaceWords(dict, sentence));		


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

class Solution648 {
	static class TrieNode{
		
		static TrieNode[] rootArr;
		
		static {
			rootArr = new TrieNode[123];
		}//end static
		
		char chr;
		Map<Character, TrieNode> childrenMap;
		
		 /**
         * Constructor for TrieNode
         * @param chr The character associated with this TrieNode.
         */
		public TrieNode(char chr) {
			this.chr = chr;
			this.childrenMap = new HashMap<>();
		}//end constructor
		
		/**
		 * Adds a word to the dictionary Trie.
		 * precondition: word must not be null and has size >= 1
		 * @param word - String
		 */
		public static void addDictWord(String word) {
			//step 1, process first character, check if it exists in the root array
			char chr = word.charAt(0);
			TrieNode prevNode, currNode;
			boolean isNewWord = false;
			if (rootArr[chr] == null) {
				rootArr[chr] = new TrieNode(chr);
				isNewWord = true;
			}//fi
			
			//step 2, traverse each character of the word and check against the trie 
			prevNode = rootArr[chr];			
			for (int i=1; i<word.length(); i++) {
				chr = word.charAt(i);
				if ((currNode = prevNode.childrenMap.get(chr))==null) {		
					if (!isNewWord && prevNode.childrenMap.isEmpty()) {
						return; //shorter word exist
					} else {
						isNewWord = true; //this is a new word
					}//fi
					currNode = new TrieNode(chr);
					prevNode.childrenMap.put(chr, currNode);
				}//fi
				prevNode = currNode;
			}//rof
			prevNode.childrenMap.clear();//prune any longer words in the dictionary
		}//end method
		
		/**
		 * return replaced word according to dictionary trie, 
		 * or return original word if dictionary doesn't contain prefixes of the word
		 * precondition:
		 * - word length must be > 0
		 * @param word - String
		 * @return String, word existed in the dictionary trie or original word 
		 */
		public static String getReplacementWord(String word) {
			char chr = word.charAt(0);
			if (rootArr[chr] == null) {
				return word;		
			}//fi
			
			StringBuilder sb = new StringBuilder();
			sb.append(chr);
			TrieNode currNode = rootArr[chr];
			TrieNode nextNode;
			for (int i=1; i<word.length(); i++) {
				chr = word.charAt(i);
				if ((nextNode = currNode.childrenMap.get(chr))==null) {
					if (currNode.childrenMap.isEmpty()) {
						return sb.toString();
					} else {
						return word;
					}//fi									
				} else {
					sb.append(chr);
					currNode = nextNode;
				}//fi				
			}//rof
			
			
			return sb.toString();
		}//end method
		
		/**
         * Flushes the Trie, removing all entries.
         */
		public static void flush() {
			Arrays.fill(rootArr, 97,123, null);
		}
	}//end class
	
    public String replaceWords(List<String> dictionary, String sentence) {
    	TrieNode.flush();
    	for (String dicWord:dictionary) {
    		//System.out.println("add dic word: " + dicWord);
    		TrieNode.addDictWord(dicWord);
    	}//rof
    	
    	StringBuilder sb = new StringBuilder();
    	for (String sentenceWord:sentence.split("\\s+")) {
    		sb.append(TrieNode.getReplacementWord(sentenceWord));
    		sb.append(" ");
    	}//rof
    	sb.setLength(sb.length() - 1);
        return sb.toString();
    }// end method

}// end class
