package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Prob1255 {

	private static String[] g1 = {"G","P","GP","GG"};
	private static int[] t1 = {2,4,3};
	
	public static void main(String[] args) {
		Solution1255 solObj = new Solution1255();
		String[] words;
		char[] letters;
		int[] score;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
           
            words = mapper.readValue("[\"xxxz\",\"ax\",\"bx\",\"cx\"]", String[].class);
            letters = mapper.readValue("[\"z\",\"a\",\"b\",\"c\",\"x\",\"x\",\"x\"]", char[].class);
            score = mapper.readValue("[4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10]", int[].class);
    		System.out.println("words: " + Arrays.toString(words));
    		System.out.println("letters: " + Arrays.toString(letters));
    		System.out.println("score: " + Arrays.toString(score));
    		System.out.println("Ans: " + solObj.maxScoreWords(words, letters, score));
    		 /*
    
    			//*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


		
		

	}

}



class Solution1255 {
	
	int[][] wordsReq; //1st index: index in words array, 2nd index: a-z position, value: amount needed
	int[] wordsScore; //index: index in words array, value: score gained for this word
	int[] letterRes; //index: a-z position, value: resource available
	int maxScore;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
    	//step 1: populate and build word requirement array, words score array and letter resource array
    	wordsReq = new int[words.length][26];
    	wordsScore = new int[words.length];
    	int currScore;
    	int letterInx;
    	for (int i=0; i<words.length; i++) {
    		currScore = 0;
    		for (int c=0; c<words[i].length(); c++) {
    			letterInx = words[i].codePointAt(c)-97;
    			wordsReq[i][letterInx]++;
    			currScore += score[letterInx];
    		}//rof
    		wordsScore[i] = currScore;
    	}//rof
    	
    	letterRes = new int[26];
    	for (char c:letters) {
    		letterRes[c-97]++;    		
    	}//rof
    	
    	//step 2: recursively traverse words array and get highest score possible
    	maxScore = 0;
    	traverseWords(0, 0, new int[26]);
        return maxScore;
    }//end method
    
    /**
     * precondition:
     * - wordsReq, wordsScore, letterRes, maxScore are available and instantiated / initialized
     * - index value is a valid index
     * @param inx - int, index of words array to be process
     * @param score - int, total score so far
     * @param usedRes - letter resource used so far
     */
    private void traverseWords(int inx, int score, int[] usedRes) {
    	int[] reqRes = Arrays.copyOf(usedRes, usedRes.length);
    	
    	boolean canIncludeSelf = true;
    	for (int i=0; i<26; i++) {
    		reqRes[i] += wordsReq[inx][i];
    		if (reqRes[i] > letterRes[i]) { //letter resource not enough
    			canIncludeSelf = false;
    			break;
    		}//fi
    	}//rof
    	
    	if (inx == wordsReq.length-1) {//last index
    		if (canIncludeSelf) {
    			maxScore = Math.max(maxScore, score + wordsScore[inx]);
    		} else {
    			maxScore = Math.max(maxScore, score);
    		}//fi
    	} else {
    		if (canIncludeSelf) {
    			traverseWords(inx+1, score + wordsScore[inx], reqRes);
    		}//fi
    		traverseWords(inx+1, score, usedRes);
    	}//fi
    }//end method

}//end class

