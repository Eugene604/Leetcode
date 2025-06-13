package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob3043 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		
				
		Solution3043 solObj = new Solution3043();
		int[] arr1, arr2;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		arr1 = objectMapper.readValue("[1,10,100]", new TypeReference<int[]>() {});
		arr2 = objectMapper.readValue("[1000]", new TypeReference<int[]>() {});
		System.out.println("ans: " + solObj.longestCommonPrefix(arr1, arr2));
		
		/*
		
		arr1 = objectMapper.readValue("[31,40]", new TypeReference<int[]>() {});
		arr2 = objectMapper.readValue("[22,41]", new TypeReference<int[]>() {});
		System.out.println("ans: " + solObj.longestCommonPrefix(arr1, arr2));
		
		arr1 = objectMapper.readValue("[1,10,100]", new TypeReference<int[]>() {});
		arr2 = objectMapper.readValue("[1000]", new TypeReference<int[]>() {});
		System.out.println("ans: " + solObj.longestCommonPrefix(arr1, arr2));
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

class Solution3043 {
	
	static class Trie{
		
		static int[] intParsingArr = new int[10];
		
		static Trie[] rootNumTrieArr;
		
		Trie[] childrenArr;
		
		/**
		 * Flushes the root of the Trie, initializing a new root array.
		 * 
		 * This method clears the current Trie by reinitializing `rootNumTrieArr`
		 * to a new array. It resets the data structure, so subsequent operations
		 * start with an empty Trie.
		 */
		static public void flushNumTrie() {
			rootNumTrieArr = new Trie[10];
		}//end method
		
		public Trie() {
			childrenArr = new Trie[10];
		}//end constructor
		
		/**
		 * Inserts a number into the Trie structure.
		 * 
		 * Precondition:
		 * - num must be > 0.
		 * 
		 * Postcondition:
		 * - The Trie is updated with the digits of the number.
		 * 
		 * This method parses the given integer `num` and stores its digits in
		 * the temporary array `intParsingArr`. It then updates the Trie by
		 * traversing down the trie structure based on the digits of the number,
		 * creating new Trie nodes if necessary.
		 * 
		 * @param num - int, an integer to be pushed into the Trie.
		 */
		static public void pushNumToTrie(int num) {
			//System.out.println("pushing num: " + num);
			int leadingDigInx = -1;
			int remainder;
			
			//step 1: parse int and store to temporary array
			do {
				leadingDigInx++;
				remainder = num%10;
				intParsingArr[leadingDigInx] = remainder;
				num /= 10;			
			} while (num>0); //end do while
			
			
			//step 2: push individual digit into trie structure
			Trie currTrieNode;
			if ((currTrieNode = rootNumTrieArr[intParsingArr[leadingDigInx]]) == null) {
				currTrieNode = new Trie();
				rootNumTrieArr[intParsingArr[leadingDigInx]] = currTrieNode;
			}//fi
			leadingDigInx--;
			
			while (leadingDigInx >=0) {
				//System.out.println("try traverse down trie");
				if (currTrieNode.childrenArr[intParsingArr[leadingDigInx]] == null) {
					currTrieNode.childrenArr[intParsingArr[leadingDigInx]] = new Trie();									
					//System.out.println("created trie");
				}//fi		
				currTrieNode = currTrieNode.childrenArr[intParsingArr[leadingDigInx]];
				leadingDigInx--;
			}//rof						
		}//end method
		
		/**
		 * Finds the common prefix length between the given number and the numbers in the Trie.
		 * 
		 * This method parses the digits of the integer `num`, stores them in the temporary
		 * array `intParsingArr`, and then traverses the Trie to count how many digits
		 * match between `num` and the numbers already stored in the Trie.
		 * 
		 * @param num - int, an integer for which the common prefix length needs to be found.
		 * @return the length of the common prefix.
		 */
		static public int getCommonPrefix(int num) {
			int leadingDigInx = -1;
			int remainder;
			
			//step 1: parse int and store to temporary array
			do {
				leadingDigInx++;
				remainder = num%10;
				intParsingArr[leadingDigInx] = remainder;
				num /= 10;			
			} while (num>0); //end do while
			
			
			//step 2: traverse trie structure
			int commonPrefix = 0;
			
			Trie currTrieNode;
			if ((currTrieNode = rootNumTrieArr[intParsingArr[leadingDigInx]]) == null) {
				return commonPrefix;
			} else {
				commonPrefix++;
				leadingDigInx--;
			}//fi
									
			while (leadingDigInx >=0) {
				if ((currTrieNode = currTrieNode.childrenArr[intParsingArr[leadingDigInx]]) == null) {
					return commonPrefix;
				}//fi				
				leadingDigInx--;
				commonPrefix++;
			}//rof
			return commonPrefix;
		}//end method
	}//end class
	

	
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
    	Trie.flushNumTrie();
    	int[] longerNumArr, shorterNumArr;
    	
    	//step 1: determine which array is shorter, use this array to populate trie
    	if (arr1.length>arr2.length) {
    		longerNumArr = arr1;
    		shorterNumArr = arr2;
    	} else {
    		longerNumArr = arr2;
    		shorterNumArr = arr1;
    	}//fi
    	
    	//step 2: populate trie
    	for (int num:shorterNumArr) {
    		Trie.pushNumToTrie(num);
    	}//rof
    	
    	//step 3: iterate through each number in longer array and find longest prefix
    	int longestCP = 0;
    	int currCP;
    	for (int num:longerNumArr) {
    		currCP = Trie.getCommonPrefix(num);
    		longestCP = Math.max(longestCP, currCP);
    	}//rof
    	
    	return longestCP;
    }//end method
    

}// end class
