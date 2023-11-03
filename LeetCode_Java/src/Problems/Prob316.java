package Problems;

import java.util.*;

public class Prob316 {
	




	public static void test() {
		Solution316 solObj;
		String str;
		
		/*
		 
		 		str = "abacb";//abc
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));		
		
		str = "bcbdc";
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
 		
		"cdadabcc"
	
		"ecbacba"
		"bccab"
	"cbacbacba"
	"yioccqiorhtoslwlvfgzycahonecugtatbyphpuunwvaalcpndabyldkdtzfjlgwqk"	
		"eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm"		
		"peymrzknlxtrutjiybqemquchgvtmmtpjvunvekszrkatctcirxwuqknrycpdtcuadblzkkleduezgspoxhhssoipbmdgrqggpfdsanolzczpaggwxrlaleaqtnzxclmxwjucnujsptnbmmjzzjhypnlsoxjveywsufegzlfnyvkcnfevkshbckfropoydkdlblppllgefagjgpajsplvxknvtlgtjyhmnwxcpjjzcizihycvsnhnnmqohivekitxzuo"

		
		//*/
		
		/*
		str = "bcabc";//abc
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));	
		str = "cbacdcbc"; //acdb
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		str = "abacb";//abc
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));		
		
		str = "bcbdc";
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
 		
		str = "cdadabcc";//adbc
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
	
		str = "ecbacba";//eacb
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		str = "bccab";//bca
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		str = "cbacbacba";//abc
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		str = "yioccqiorhtoslwlvfgzycahonecugtatbyphpuunwvaalcpndabyldkdtzfjlgwqk";//ciorhsaebpunvdyktzfjlgwq
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		str = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";//chzafipuegjlxdqnbsotwrym
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		str = "peymrzknlxtrutjiybqemquchgvtmmtpjvunvekszrkatctcirxwuqknrycpdtcuadblzkkleduezgspoxhhssoipbmdgrqggpfdsanolzczpaggwxrlaleaqtnzxclmxwjucnujsptnbmmjzzjhypnlsoxjveywsufegzlfnyvkcnfevkshbckfropoydkdlblppllgefagjgpajsplvxknvtlgtjyhmnwxcpjjzcizihycvsnhnnmqohivekitxzuo";//abcefghkrdjlmnwpiysqovtxzu
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
		
		//*/
		
		solObj = new Solution316();
		str = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
		//chzafipuegjlxdqnbsotwrym
		//chzafipuegjlxdqnbsowrtym
		//chzafipuegjlxdqnbsowrtym
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
	
		//*/
		solObj = new Solution316();
		str = "peymrzknlxtrutjiybqemquchgvtmmtpjvunvekszrkatctcirxwuqknrycpdtcuadblzkkleduezgspoxhhssoipbmdgrqggpfdsanolzczpaggwxrlaleaqtnzxclmxwjucnujsptnbmmjzzjhypnlsoxjveywsufegzlfnyvkcnfevkshbckfropoydkdlblppllgefagjgpajsplvxknvtlgtjyhmnwxcpjjzcizihycvsnhnnmqohivekitxzuo";
		//abcefghkrdjlmnwpiysqovtxzu
		//abcjlrdefghmnwpiysqovktxzu
		//abcefghkrdjlmnwpiysqovtxzu
		System.out.println("str: " + str + " sol: " + solObj.removeDuplicateLetters(str));
			
	}

	
	public static void test2() {
		Solution316 solObj = new Solution316();
		
		//solObj.test();		
	}
	
	public static void main(String[] args) {
		test();
		//test2();

	}

}


class Solution316 {
	

	
	private static char[] charStack = new char[27];
	private int currStackEleAddr = -1;
	private int reversePopEleAddr = 0;
	
	private boolean[] charUsedArr = new boolean[123];
	private int[] lastInxArr = new int[123];
		
	public String removeDuplicateLetters(String s) {

    	int i;
    	//step 1, populate last index array    	
    	for (i=0; i<s.length(); i++) {
    		lastInxArr[s.charAt(i)]=i;
    	}//rof
    	    	
    	char currChar, topStackChar;
    	for ( i=0; i<s.length(); i++) {
    		currChar = s.charAt(i);
    		if (charUsedArr[currChar]) {
    			continue;
    		}//fi
    		
    		while ((topStackChar = pop())>currChar&&lastInxArr[topStackChar]>i){
    			charUsedArr[topStackChar]=false;
    		}//end while
    		if (topStackChar != ' ') {
    			push(topStackChar);
    		}//fi
    		push(currChar);
    		
    		charUsedArr[currChar] = true;
    	}//rof
    	
    	
    
  
    	
		//System.out.println("curr sb: " + sb.toString());
    	//step 4, build resulting string from stack
    	StringBuilder sb = new StringBuilder();
    	while ((topStackChar = reversePop())!=' ') {
    		sb.append(topStackChar);
    	}//end while
        return sb.toString();
    }//end method

	/**
	 * 
	 * @return return and remove top char in the stack, ' ' if stack is empty
	 */
	private char pop() {
		if (currStackEleAddr<0) {
			return ' ';
		}//fi
		return charStack[currStackEleAddr--];		
	}//end method
	
	/**
	 * 
	 * @return return element from bottom up to the top element, ' ' if exceeds top element
	 */
	private char reversePop() {
		if (reversePopEleAddr>currStackEleAddr) {
			return ' ';
		}//fi
		return charStack[reversePopEleAddr++];		
	}//end method
	
	/**
	 * precondition:
	 * - does not check for stack bound
	 * @param c - char to be pushed in
	 */
	private void push(char c) {
		currStackEleAddr++;		
		charStack[currStackEleAddr] = c;		
	}//end method
}//end class

class Solution316_v2 {
	
	private StringBuilder sb;
	private int duplicateCharCnt;
	private static List<LinkedList<Integer>> charOccurList; 	
	static {
		charOccurList = new ArrayList<>(123);
    	for (int i=0; i<123; i++) {
    		charOccurList.add(null);
    	}//rof 
	}//end static block
	
	public void test() {
    	
		
		sb = new StringBuilder();
		
		sb.append('q');
		sb.append('g');
		sb.append('~');
	    System.out.println("result: " + getLexicoScore('a',2, sb));
	    System.out.println("result: " + getLexicoScore('z',2, sb));
	    //*/
	    
	    /*
		sb.append('~');//0 b
		sb.append('~');//1 c
		sb.append('a');//2 a
		sb.append('~');//3 b
		sb.append('c');//4 c
		//System.out.println("result: " + getLexicoScore('c',1));
		//System.out.println("result: " + getLexicoScore('c',4));
		System.out.println("result 0: " + getLexicoScore('b',0));
		System.out.println("result 3: " + getLexicoScore('b',3));		
		 //*/
	}
	
	public String removeDuplicateLetters(String s) {

    	int i;
    	//step 1, populate char occurrence list
    	for (i=97; i<123; i++) {
    		charOccurList.set(i,new LinkedList<Integer>());
    	}//rof    	
    	for (i=0; i<s.length(); i++) {
    		charOccurList.get(s.charAt(i)).add(i);
    	}//rof
    	
    	
    	//printCharOccurList();
    	
    	//step 2, replace duplicate chars with white space also record duplicate char count
    	sb = new StringBuilder(s);   	
    	LinkedList<Integer> occurList;
    	duplicateCharCnt = 0;
    	for (i=97; i<123; i++) {
    		if ((occurList = charOccurList.get(i)).size()<=1) {
    			continue;
    		}//fi
    		for (Integer inx:occurList){
    			sb.setCharAt(inx,'~');
    		}//rof
    		duplicateCharCnt++;
    	}//eof
    	
    	
    	StringBuilder sbOne = searchMethodOne();
    	StringBuilder sbTwo = searchMethodTwo();
    	

    	if (sbOne.compareTo(sbTwo)<=0) {
    		sb = sbOne;
    	} else {
    		sb = sbTwo;
    	}//fi
    	
		//System.out.println("curr sb: " + sb.toString());
    	//step 4, build resulting string according to occurrence list
    	i=0;
    	while (i<sb.length()) {
    		if (sb.charAt(i)=='~') {
    			sb.deleteCharAt(i);
    		} else {
    			i++;
    		}//fi
    	}//end while
        return sb.toString();
    }//end method
	
	private StringBuilder searchMethodOne() {
		StringBuilder localSb = new StringBuilder(sb); 
		int localDuplicateCharCnt = duplicateCharCnt;
		LinkedList<Integer> occurList;
		int i;
		/*
    	 * step 3, alternately scan through char occur list
    	 */
    	do {
    		/*
	    	 * 
	    	 * try backward search from z to a, stops immediately if lexicographically smaller is possible
	    	 * 
	    	 */
	    	SEARCH_I_BAKWARD:
	    	for (i=122; i>96; i--) {
	    		if ((occurList = charOccurList.get(i)).size()<=1||occurList.peek()==-1) {
	    			continue;
	    		}//fi
	    		//find those that lexicographically smaller is impossible, and add to the tail    		
	    		for (Integer inx:occurList) {
	    			if (getLexicoScore((char)i,inx, localSb)<0) {  
	    				break SEARCH_I_BAKWARD;
	    			}//fi    			
	    		}//rof
	
	    		localSb.setCharAt(occurList.peekLast(), (char)i);	    		
	    		occurList.addFirst(-1);
	    		localDuplicateCharCnt--;
	    		//System.out.println("bak search, set char " + (char)i + " localSb: " + localSb.toString() + " inx: " +  occurList.peekLast());
	    		//break SEARCH_I_BAKWARD;
	    	}//rof
	    	
	    	    	
    		/*
	    	 * try fwd search , try one fwd search
	    	 * 
	    	 */
	    	SEARCH_I_FORWARD:
	    	for (i=97; i<123; i++) {
	    		if ((occurList = charOccurList.get(i)).size()<=1||occurList.peek()==-1) {
	    			continue;
	    		}//fi
	    		//find those that lexicographically smaller is impossible, and add to the front  
	    		for (Integer inx:occurList) {
	    			if (getLexicoScore((char)i,inx, localSb)<0) {	    				
	    				localSb.setCharAt(inx, (char) i);
	    				occurList.addFirst(-1);
	    				localDuplicateCharCnt--;
	    				//System.out.println("fwd search, set char " + (char)i + " localSb: " + localSb.toString() + " at " +  inx);
	    				break SEARCH_I_FORWARD;
	    			}//fi    			
	    			//break SEARCH_I_FORWARD;
	    		}//rof	    		
	    	}//rof
	    
    	} while (localDuplicateCharCnt>0);
		return localSb;
	}//end method
	
	private StringBuilder searchMethodTwo() {
		StringBuilder localSb = new StringBuilder(sb);
		int localDuplicateCharCnt = duplicateCharCnt;
		LinkedList<Integer> occurList;
		int i;
		/*
    	 * step 3, alternately scan through char occur list
    	 */
    	do {    		
    		/*
	    	 * 
	    	 * try backward search from z to a, try as much as possible
	    	 * 
	    	 */
	    	SEARCH_I_BAKWARD:
	    	for (i=122; i>96; i--) {
	    		if ((occurList = charOccurList.get(i)).size()<=1) {
	    			continue;
	    		} else if (occurList.peek()==-1) {
	    			occurList.removeFirst();
	    		}//fi
	    		//find those that lexicographically smaller is impossible, and add to the tail    		
	    		for (Integer inx:occurList) {
	    			if (getLexicoScore((char)i,inx, localSb)<0) {  
	    				continue SEARCH_I_BAKWARD;
	    			}//fi    			
	    		}//rof
	
	    		localSb.setCharAt(occurList.peekLast(), (char)i);	    		
	    		occurList.clear();
	    		localDuplicateCharCnt--;
	    		//System.out.println("bak search, set char " + (char)i + " localSb: " + localSb.toString() + " inx: " +  occurList.peekLast());
	    		//break SEARCH_I_BAKWARD;
	    	}//rof

	    	    	
    		/*
	    	 * try fwd search , try one fwd search
	    	 * 
	    	 */
	    	SEARCH_I_FORWARD:
	    	for (i=97; i<123; i++) {
	    		if ((occurList = charOccurList.get(i)).size()<=1) {
	    			continue;
	    		}//fi
	    		//System.out.println("checking " + (char)i + " curr sb: " + sb.toString());
	    		//find those that lexicographically smaller is impossible, and add to the front  
	    		for (Integer inx:occurList) {
	    			if (getLexicoScore((char)i,inx, localSb)<0) {	    				
	    				localSb.setCharAt(inx, (char) i);
	    				occurList.clear();
	    				localDuplicateCharCnt--;
	    				//System.out.println("fwd search, set char " + (char)i + " localSb: " + localSb.toString() + " at " +  inx);
	    				break SEARCH_I_FORWARD;
	    			}//fi    			
	    			//break SEARCH_I_FORWARD;
	    		}//rof	    		
	    	}//rof
	    
    	} while (localDuplicateCharCnt>0);
		return localSb;
	}//end method
	
    /**
     * get lexicographic score 
     * rules:
     * - if insertion of character causes overall higher lexicographic order, then return +1, otherwise -1
     * - when dealing with left boundary cases, insert imaginary character '_' which has an ASCII val lower than a
     * - when dealing with right boundary cases, insert imaginary character '_' which has an ASCII val lower than a, this has the effect of making lexico score always -1
     * @param charToInsert - char  
     * @param inx - int, index to insert the character to
     * @return lexicographic score
     * [a, ,z]->[a, s, z] , lexico score -1
     * [a, ,b]->[a, s, b] , lexico score +1
     * [z, ,a]->[z, s, a] , lexico score +1
     * [z, ,w]->[z, s, w] , lexico score -1
     * [ ,z] becomes [_, ,z],[_, ,z]->[_,s,z] , lexico score -1
     * [ ,a] becomes [_, ,a],[_, ,a]->[_,s,a] , lexico score +1
     * [?, ] becomes [?, ,_]->[?,s,_] , lexico score always +1
     */
    private int getLexicoScore(char charToInsert, int inx, StringBuilder localSb) {
    
    	char leftChar = '_', rightChar = '_';
    	int neighborInx;
    	
    	//calculate left char
    	neighborInx = inx-1;  
		while (neighborInx >= 0) {
			if (localSb.charAt(neighborInx)!='~'){
				leftChar = localSb.charAt(neighborInx);
				break;
			}//fi
			neighborInx--;
		}//end while
			
    	//calculate right char
    	neighborInx = inx+1;  
		while (neighborInx < localSb.length()) {
			if (localSb.charAt(neighborInx)!='~'){
				rightChar = localSb.charAt(neighborInx);
				break;
			}//fi
			neighborInx++;
		}//end while
    	
		int rawScore = (leftChar-rightChar) - (leftChar-charToInsert);
		if (rawScore>0) {
			return 1;
		} else if (rawScore<0) {
			return -1;
		} else {
			return 0;
		}//fi
    }//end method

    static void printCharOccurList() {       
    	System.out.print("[");
    	for (LinkedList<Integer> ll:charOccurList) {
    		if (ll!=null) {
    			System.out.print(ll+",");
    		}//fi 
    	}//rof
    	System.out.println("]");
    }//end method
      
}//end class