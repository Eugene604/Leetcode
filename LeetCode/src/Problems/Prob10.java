package Problems;

import java.util.*;

public class Prob10 {
	

	
	public static void test() {

		Solution10 sol = new Solution10();
		String s, p;
		
	
		
		s = "aa"; p = "a";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		
		
		s = "aa"; p = "a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 	
		s = "ab"; p = ".*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "aa"; p = "."; 
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "a"; p = "."; 
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "bcda"; p = "...."; 
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "bcda"; p = "b..a"; 		
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "bcda"; p = "b...a"; 
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "bcdabbf"; p = "b..f"; 
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s = "abcd"; p = ".*cd";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		s = "abcd"; p = ".*cc";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));	
		 
	
		s = "abcd"; p = "abcde*f*g*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		s = ""; p = "d*f*g*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));		
		 
		s = "abcdefg"; p = "abd*cdg*efg";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		s ="aab"; p ="c*a*b";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));		
		 
	
		
		s =	"aaa"; p ="ab*ac*a";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));

		
		s = "abb"; p = "b*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 		
		s = "aa"; p =	".c*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 	
		s = "ab"; p =	"ac*d*e*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 		
		s = "a"; p = ".*a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 		
		s = "a"; p = "d*a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 

		s = "abbabaaaaaaacaa"; p = "a*.*b.a.*c*b*a*c*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 

		
		s = "abbabaaaaaaacaa"; p = "a*.*b.a.*c*b*a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 

		

		s = "abcaaaaaaabaabcabac"; p = ".*ab.a.*a*a*.*b*b*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		s = "bcbabcaacacbcabac"; p = "a*c*a*b*.*aa*c*a*a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		s = "bcbabcaacacbcabac"; p = "b*c*b*.a.*a*.*.*b*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		

		s = "mississippi"; p = "mis*is*p*.";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 


		
	
		s = "ssissippi"; p = "s*is*p*.";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 

		
		s = "bbbba"; p = ".*a*a";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));	
		 
		
	
		s = "aaaaaaaaaaaaaaaaaaab"; p =	"a*a*a*a*a*a*a*a*a*a*";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 
		
		s = "ab"; p =	".*..";
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));
		 	
		
		
		s = "abb"; p = "b*";
		System.out.println("s=" + s + " p=" + p);
		System.out.println("ans: " + sol.isMatch(s,p) + " should be: " + s.matches(p));	
	
			//*/
		

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution10 {
	
	private boolean[][] isDeadEnd;
	
	class Pattern {
		/*
		 * 0 - exact char match
		 * non-zero - various number of matches, including zero
		 * 
		 */
		private int patternType;
		private char character;
		
		public boolean isStrict() {
			return patternType == 0;
		}//end method
				
		public boolean isMatchChar(char c) {
			if (character == c || character == '.') {
				return true;
			} else {
				return false;
			}//fi
		}//end method
		
		public Pattern (int patternType, char character) {
			this.patternType = patternType;
			this.character = character;
		}//end constructor				
	}//end class

	
	/**
	 * This method parses pattern string and build array of pattern objects
	 * precondition: it is assumed that pattern is valid
	 * @param p Pattern String
	 * @return Array of pattern object
	 */
	public Pattern[] buildPatternArr(String p) {
		Pattern[] patternArr = new Pattern[p.length()];   	    	
    	int currPatternArrInx = 0;
    	for (int pStrInx = 0; pStrInx < p.length(); pStrInx++) {
    		if (p.charAt(pStrInx) == '*') {
    			patternArr[currPatternArrInx-1].patternType=1;
    		} else {
    			patternArr[currPatternArrInx] = new Pattern(0,p.charAt(pStrInx));
    			currPatternArrInx++;
    		}//fi    	
    	}//rof
    	return patternArr;
	}//end method
	

    public boolean isMatch(String s, String p) {
    	
    	//special case, pattern length = 0;
    	if (p.length() == 0) {
    		return s.length() == 0;	
    	}//fi  
    	
    	//step 1: build pattern array
		Pattern[] patternArr = buildPatternArr(p);
    	   	
		//step 2: match recursively 	
		isDeadEnd = new boolean[s.length()+1][patternArr.length+1];
    	return match(s, patternArr, 0, 0);
    }//end method
    

    /**
     * Recursively matches string and given pattern
     * @param str string to be matched 
     * @param patArr Pattern array
     * @param strInx current index of string array
     * @param patInx current index of pattern array
     * @return true if string and pattern match
     */
    private boolean match(String str, Pattern[] patArr, int strInx, int patInx) {
    	//System.out.println("entered Match, " + strInx + " : " + patInx);
    	if (isDeadEnd[strInx][patInx]) {
    		return false;
    	}//fi
    	//base case 1: strInx has surpassed end of string, check rest of pat
    	if (strInx > str.length()-1) {
			for (int tmpPInx = patInx; tmpPInx < patArr.length && patArr[tmpPInx] != null; tmpPInx++) {
				if (patArr[tmpPInx].isStrict()) {
					isDeadEnd[strInx][patInx] = true;
					return false;
				}//fi
			}//rof
			//System.out.println("gone here base 2, " + strInx + " : " + patInx);
			return true;
    	}//fi
    	
    	//base case 2: patInx has surpassed end of pat or curr pat is null 
    	if (patInx > patArr.length-1 || patArr[patInx] == null) {	
    		isDeadEnd[strInx][patInx] = true;
			return false;
    	}//fi
    	
    	//recursive case 1: curr pat is strict
    	if (patArr[patInx].isStrict()) {
    		if (patArr[patInx].isMatchChar(str.charAt(strInx))) {
    			isDeadEnd[strInx][patInx] = !match(str, patArr, strInx+1, patInx+1);  			
    		} else {
    			isDeadEnd[strInx][patInx] = true;
    		}//fi
    		return !isDeadEnd[strInx][patInx];
    	}//fi
    	
    	//recursive case 2: curr pat is not strict
    	/*
    	 * algorithm: 
    	 * 1. try skip current pattern and see if it matches
    	 * 2. then try match characters until match is found OR end of str has reached 
    	 */
    	if (match(str, patArr, strInx, patInx+1)) {
    		/* case 2-1:  pattern not strict and NOT using the pattern 
		     * s = [a,b,c,d],  p = [a,b*,b,c,d]
			 *   stay ^               ^ skip
    		 */	
    		isDeadEnd[strInx][patInx] = false;
    	} else {
       		/* case 2-2:  pattern not strict and using the pattern  
    		 * try match as many character as needed
		     * s = [a,b,b,b,b,b,b,b,b,b,b,c,d],  p = [a,b*,c,d]
			 *   try match all these ^                  ^ stay
    		 */
    		int currStrInx;
    		isDeadEnd[strInx][patInx] = true;
    		for (currStrInx = strInx; 
    				currStrInx < str.length() && 
    				patArr[patInx].isMatchChar(str.charAt(currStrInx))&&
    				isDeadEnd[strInx][patInx]
    				; 
    				currStrInx++) {
    			isDeadEnd[strInx][patInx] &= !match(str, patArr, currStrInx+1, patInx+1); 
    		}//rof    		
    	}//fi
    	return !isDeadEnd[strInx][patInx];	
    }//end method
}//end class

class Solution10_2 {
	
	private Boolean[][] matchCache;

	
	class Pattern {
		/*
		 * 0 - exact char match
		 * non-zero - various number of matches, including zero
		 * 
		 */
		private int patternType;
		private char character;
		
		public boolean isStrict() {
			return patternType == 0;
		}//end method
				
		public boolean isMatchChar(char c) {
			if (character == c || character == '.') {
				return true;
			} else {
				return false;
			}//fi
		}//end method
		
		public Pattern (int patternType, char character) {
			this.patternType = patternType;
			this.character = character;
		}//end constructor				
	}//end class

	
	/**
	 * This method parses pattern string and build array of pattern objects
	 * precondition: it is assumed that pattern is valid
	 * @param p Pattern String
	 * @return Array of pattern object
	 */
	public Pattern[] buildPatternArr(String p) {
		Pattern[] patternArr = new Pattern[p.length()];   	    	
    	int currPatternArrInx = 0;
    	for (int pStrInx = 0; pStrInx < p.length(); pStrInx++) {
    		if (p.charAt(pStrInx) == '*') {
    			patternArr[currPatternArrInx-1].patternType=1;
    		} else {
    			patternArr[currPatternArrInx] = new Pattern(0,p.charAt(pStrInx));
    			currPatternArrInx++;
    		}//fi    	
    	}//rof
    	return patternArr;
	}//end method
	
    public boolean isMatch(String s, String p) {
    	
    	//special case, pattern length = 0;
    	if (p.length() == 0) {
    		return s.length() == 0;	
    	}//fi  
    	
    	//step 1: build pattern array
		Pattern[] patternArr = buildPatternArr(p);
    	   	
		//step 2: match recursively 	
		matchCache = new Boolean[s.length()+1][patternArr.length+1];
    	return match(s, patternArr, 0, 0);
    }//end method
    

    /**
     * Recursively matches string and given pattern
     * @param str string to be matched 
     * @param patArr Pattern array
     * @param strInx current index of string array
     * @param patInx current index of pattern array
     * @return true if string and pattern match
     */
    private boolean match(String str, Pattern[] patArr, int strInx, int patInx) {
    	if (matchCache[strInx][patInx] != null) {
    		return matchCache[strInx][patInx];
    	}//fi
    	//base case 1: strInx has surpassed end of string, check rest of pat
    	if (strInx > str.length()-1) {
			for (int tmpPInx = patInx; tmpPInx < patArr.length && patArr[tmpPInx] != null; tmpPInx++) {
				if (patArr[tmpPInx].isStrict()) {
					matchCache[strInx][patInx] = false;
					return false;
				}//fi
			}//rof
			matchCache[strInx][patInx] = true;
			return true;
    	}//fi
    	
    	//base case 2: patInx has surpassed end of pat or curr pat is null 
    	if (patInx > patArr.length-1 || patArr[patInx] == null) {	
    		matchCache[strInx][patInx] = false;
			return false;
    	}//fi
    	
    	//recursive case 1: curr pat is strict
    	if (patArr[patInx].isStrict()) {
    		if (patArr[patInx].isMatchChar(str.charAt(strInx))) {
    			matchCache[strInx][patInx] = match(str, patArr, strInx+1, patInx+1);  			
    		} else {
    			matchCache[strInx][patInx] = false;
    		}//fi
    		return matchCache[strInx][patInx];
    	}//fi
    	
    	//recursive case 2: curr pat is not strict
    	/*
    	 * algorithm: 
    	 * 1. try skip current pattern and see if it matches
    	 * 2. then try match characters until match is found OR end of str has reached 
    	 */
    	if (match(str, patArr, strInx, patInx+1)) {
    		/* case 2-1:  pattern not strict and NOT using the pattern 
		     * s = [a,b,c,d],  p = [a,b*,b,c,d]
			 *   stay ^               ^ skip
    		 */	
    		matchCache[strInx][patInx] = true;
    	} else {
       		/* case 2-2:  pattern not strict and using the pattern  
    		 * try match as many character as needed
		     * s = [a,b,b,b,b,b,b,b,b,b,b,c,d],  p = [a,b*,c,d]
			 *   try match all these ^                  ^ stay
    		 */
    		int currStrInx;
    		matchCache[strInx][patInx] = false;
    		for (currStrInx = strInx; 
    				currStrInx < str.length() && 
    				patArr[patInx].isMatchChar(str.charAt(currStrInx))&&
    				!matchCache[strInx][patInx]
    				; 
    				currStrInx++) {
    			matchCache[strInx][patInx] |= match(str, patArr, currStrInx+1, patInx+1); 
    		}//rof    		
    	}//fi
    	return matchCache[strInx][patInx];	
    }//end method
}//end class

class Solution10_v1 {
	
	public static LinkedList<String> log  = new LinkedList<String>();	
	private Boolean[][] dp;

	public class Pattern {
		/*
		 * 0 - exact word match
		 * non-zero - various number of matches, including zero
		 * 
		 */
		public int patternType;
		public char character;
		public Pattern (int patternType, char character) {
			this.patternType = patternType;
			this.character = character;
		}//end constructor
		public String toString() {
			if (patternType != 0) {
				return "{"+character + "|*}";
			} else {
				return "{"+character + "|1}";
			}//fi
		}
	}//end class
	
	/**
	 * This method parses pattern string and build array of pattern objects
	 * precondition: it is assumed that pattern is valid
	 * @param p Pattern String
	 * @return ArrayList<Pattern> Array of pattern object
	 */
	public ArrayList<Pattern> buildPatternArr(String p) {
		
		int pLength = p.length();
    	ArrayList<Pattern> patterns = new ArrayList<>(pLength);
    	
    	char[] pCharArr = p.toCharArray();
    	
    	int currPArrInx = -1;
    	for (int pStrInx=0; pStrInx<pLength; pStrInx++) {
    		if (pCharArr[pStrInx] == '*') {
    			patterns.get(currPArrInx).patternType=1;
    		} else {
    			Pattern pattern = this.new Pattern(0,pCharArr[pStrInx]);
    			patterns.add(pattern);
    			currPArrInx++;
    		}//fi    	
    	}//rof
    	return patterns;
	}//end method
	
    public boolean isMatch(String s, String p) {
    	
    	//special case, pattern length = 0;
    	int sLength = s.length();
    	int pLength = p.length();
    	if (pLength == 0) {
    		return sLength == 0;	
    	}//fi  	
    	//step 1: build pattern array
		ArrayList<Pattern> patterns = buildPatternArr(p);
    	
		//special case, string length = 0;
    	if (sLength == 0) {
			for (Pattern pat:patterns) {
				if (pat.patternType == 0) {
					return false;
				}//fi
			}//rof
			return true;
    	}//fi
    	
		//step 2: recursively match	
    	dp = new Boolean[sLength][pLength];
		char[] sCharArr = s.toCharArray();
    	boolean matched = match(sCharArr, 0, s.length()-1, patterns, 0, patterns.size()-1);
    	
    	/*
    	for (String l:log) {
    		System.out.println(l);
    	}//*/
    	
    	//System.out.println(Arrays.deepToString(dp));
    	//System.out.println(dp[0][0]);
    	return matched;

    }//end method
    

    /**
     * Recursively matches string and given pattern
     * @param sCharArr string character array
     * @param currSInx current index of string character array that is to be matched
     * @param maxSInx max index of string array
     * @param patterns pattern array
     * @param currPInx current index of pattern array
     * @param maxPInx max index of pattern array
     * @return boolean showing matching result
     */
    private boolean match(char[] sCharArr, int currSInx, int maxSInx, ArrayList<Pattern> patterns, int currPInx, int maxPInx) {
    	
    	if (dp[currSInx][currPInx] != null) {
    		//log.add("dped, match " + currSInx + ":" + currPInx+ " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
    		return dp[currSInx][currPInx];
    	}//fi
    	int oldPInx;
    	//log.add("match " + currSInx + ":" + currPInx+ " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
    	if (currSInx==maxSInx && currPInx==maxPInx) {
    		/*
    		 * case 1:  has reached end of both string and patterns
    		 * s = [a,b],  p = [a,?] 
    		 *        ^           ^
    		 */
    		//log.add("case 1, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
			if (patterns.get(currPInx).character == '.') {
				dp[currSInx][currPInx] = true;
				return true;
			} else {
				dp[currSInx][currPInx] = (sCharArr[currSInx] == patterns.get(currPInx).character); 
				return dp[currSInx][currPInx];
			}//fi
    	} else if (currSInx<maxSInx && currPInx==maxPInx) {
    		/*
    		 * case 2:  still has some string characters but reached end of patterns
    		 * s = [a,b,....],  p = [a,?]
    		 *        ^                ^  
    		 */
			if (patterns.get(currPInx).patternType == 0) {
	    		/*
	    		 * case 2-1: last pattern is strict
	    		 * s = [a,b,....],  p = [a,b]
	    		 *        ^                ^  
	    		 */	
	    		//log.add("case 2-1 end of pat, pat is strict, still has some chars, will return false, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = false;
				return false;
			} else if (patterns.get(currPInx).character == '.') {
	    		/*
	    		 * case 2-2:  pattern not strict and is wild card
	    		 * s = [a,b,....],  p = [a,.*]
	    		 *        ^                ^  
	    		 */		
	    		//log.add("case 2-2, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = true;
				return true;
			} else if (sCharArr[currSInx] == patterns.get(currPInx).character) {
	    		/*
	    		 * case 2-3:  pattern not strict and current string character matches pattern
	    		 * s = [a,b,....],  p = [a,b*]
	    		 *        ^                ^  
	    		 */	
	    		//log.add("case 2-3, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = match(sCharArr, currSInx+1, maxSInx, patterns, currPInx, maxPInx);
	    		return dp[currSInx][currPInx];
			} else {
	    		/*
	    		 * case 2-4:  current string character has used up the pattern
	    		 * s = [a,b,....],  p = [a,c*]
	    		 *        ^                ^  
	    		 */	
	    		//log.add("case 2-4, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = false;
				return false;
			}//fi
    	} else if (currSInx==maxSInx && currPInx<maxPInx) {
    		/*
    		 * case 3:  has reached end of string but still has some patterns
    		 * s = [a,b],  p = [a,?,...] 
    		 *        ^           ^
    		 */
			if (patterns.get(currPInx).patternType != 0) {
	    		/*
	    		 * case 3-1:  current pattern is not strict
	    		 * s = [a,b],  p = [a,b*,...]
	    		 *        ^           ^  
	    		 */	
	    		//log.add("case 3-1 curr pat is not strict, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		if (match(sCharArr, currSInx, maxSInx, patterns, currPInx+1, maxPInx)) {
		    		/*
		    		 * case 3-1-1:  current pattern is not strict and subsequent pattern also matches
		    		 * s = [a,b],  p = [a,?*,b,...]
		    		 *        ^           ^  ^ match
		    		 */	
	    			//log.add("case 3-1-1 subsequent pat matches, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    			dp[currSInx][currPInx] = true;
	    			return true;
	    		} else {
		    		/*
		    		 * case 3-1-2:  current pattern is not strict, 
		    		 * subsequent pattern not match
		    		 * s = [a,b],  p = [a,?*,.....]
		    		 *        ^           ^  ^ not match
		    		 */	
	    			//log.add("case 3-1-2 subsequent pat not match, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    			if (patterns.get(currPInx).character!='.' &&
	    				patterns.get(currPInx).character!=sCharArr[currSInx]) {
			    		/*
			    		 * case 3-1-2-1:  current pattern is not strict, 
			    		 * subsequent pattern not match
			    		 * and current pattern not match too
			    		 * s = [a,b],  p = [a,c*,.....]
			    		 *        ^           ^  ^ not match
			    		 */	
	    				//log.add("case 3-1-2-1 curr pat not match too, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    				dp[currSInx][currPInx] = false;
	    				return false;
	    			} else {
			    		/*
			    		 * case 3-1-2-2:  current pattern is not strict, 
			    		 * subsequent pattern not match
			    		 * but current pattern does match 
			    		 * s = [a,b],  p = [a,b, c*,.....]
			    		 *        ^           ^  ^ not match
			    		 */	
	    				//log.add("case 3-1-2-2 curr pat match, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    				oldPInx = currPInx;
		    			for (currPInx++; currPInx <= maxPInx; currPInx++) {
		    				if (patterns.get(currPInx).patternType == 0) {
		    		    		/*
		    		    		 * case 3-1-2-2-1:  current pattern is not strict, 
		    		    		 * subsequent pattern not match 
		    		    		 * current pattern does match 
		    		    		 * but subsequent patterns contain strict pattern
		    		    		 * s = [a,b],  p = [a,b, d*, f,...]
		    		    		 *        ^           ^      ^ strict pattern
		    		    		 */	
		    	    			//log.add("case 3-1-2-2-1 subsequent pat contains strict one, return false, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
		    	    			dp[currSInx][oldPInx] = false;
		    	    			return false;
		    				}//fi
		    			}//rof
			    		/*
			    		 * case 3-1-2-2-2:  current pattern is not strict, 
			    		 * subsequent pattern not match 
			    		 * current pattern does match 
			    		 * and subsequent patterns are all non-strict pattern
			    		 * s = [a,b],  p = [a,b, d*, f*]
			    		 *        ^           ^      ^ all non-strict pattern
			    		 */	
	    	    		//log.add("case 3-1-2-2-2 subsequent pat all non-strict, return true");
	    	    		dp[currSInx][currPInx] = true;
	    	    		return true;
	    			}//fi
	    		}//fi
			} else if (patterns.get(currPInx).character != '.' && sCharArr[currSInx] != patterns.get(currPInx).character) {
				/*
	    		 * case 3-2:  current pattern is strict and does not match end of string, forget the rest
	    		 * s = [a,b],  p = [a,c,...]
	    		 *        ^           ^  
	    		 */	
	    		//log.add("case 3-2 curr pat is strict and not match end of string, forget the rest, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = false;
	    		return false;
			} else {
				/*
	    		 * case 3-3:  current pattern is strict and matches end of string, check if rest are all not strict
	    		 * s = [a,b],  p = [a,b,...]
	    		 *        ^           ^  
	    		 */	
	    		//log.add("case 3-3 case 3-2 curr pat is strict and matches end of string, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
				oldPInx = currPInx;
    			for (currPInx++; currPInx <= maxPInx; currPInx++) {
    				if (patterns.get(currPInx).patternType == 0) {
    					dp[currSInx][oldPInx] = false;
    					return false;
    				}//fi
    			}//rof
    			dp[currSInx][oldPInx] = true;
    			return true;
			}
    	} else {
    		/*
    		 * case 4:  there are patterns and string characters left
    		 * s = [a,b,...],  p = [a,c*...] 
    		 *        ^               ^
    		 */
			if (patterns.get(currPInx).patternType != 0) {
	    		/*
	    		 * case 4-1:  current pattern is not strict
	    		 * s = [a,b,...],  p = [a,?*,...]
	    		 *        ^               ^  
	    		 */			
				if (patterns.get(currPInx).character != '.' && sCharArr[currSInx] != patterns.get(currPInx).character){
					/*
		    		 * case 4-1-1:  current pattern does not match current string char, try next pattern
		    		 * s = [a,b,...],  p = [a,c*,...]
		    		 *        ^               ^  
		    		 */	
					//log.add("case 4-1-1 curr pat doesn't match curr str char, try next pat, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
					dp[currSInx][currPInx] =  match(sCharArr, currSInx, maxSInx, patterns, currPInx+1, maxPInx);
					return dp[currSInx][currPInx];
				} else { 
					/*
		    		 * case 4-1-2:  current pattern does match current string char 
		    		 * however, try various combination of string chars and subsequent patterns and see how it goes
		    		 * return true if match found
		    		 * s = [a,b,...],  p = [a,b*,...]
		    		 *        ^ ^try          ^  ^try
		    		 */	
					//log.add("case 4-1-2 curr pat matches curr str char, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString()); 
					/*
		    		 * case 4-1-2-1:  try subsequent chars with current pattern
		    		 * let recursion do the job
		    		 * s = [a,b,...],  p = [a,b*,...]
		    		 *        ^ ^try          ^ curr pat 
		    		 */	
					//log.add("case 4-1-2-1 try subsequent chars with curr pat, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
					if (match(sCharArr, currSInx+1, maxSInx, patterns, currPInx, maxPInx)) {
						dp[currSInx][currPInx] = Boolean.TRUE;
						return true;
					} 
					/*
		    		 * case 4-1-2-2:  try next chars with next pattern
		    		 * 
		    		 * s = [a,b,...],  p = [a,b*,...]
		    		 *        ^ ^try          ^  ^ try 
		    		 */	
					//log.add("case 4-1-2-2 try next chars with next pat, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
					if (match(sCharArr, currSInx+1, maxSInx, patterns, currPInx+1, maxPInx)) {
						dp[currSInx][currPInx] = true;
						return true;
					} 
					/*
		    		 * case 4-1-2-2:  try next pattern with curr char
		    		 * 
		    		 * s = [a,b,...],  p = [a,b*,...]
		    		 *        ^               ^  ^ try 
		    		 */	
					//log.add("case 4-1-2-3 try next pat with curr char, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
					if (match(sCharArr, currSInx, maxSInx, patterns, currPInx+1, maxPInx)){
						dp[currSInx][currPInx] = true;
						return true;
					} else {
						dp[currSInx][currPInx] = false;
						return false;
					}
		
				}//fi
			} else if (patterns.get(currPInx).character != '.' && sCharArr[currSInx] != patterns.get(currPInx).character) {
				/*
	    		 * case 4-2:  current pattern is strict and does not match current character of string, forget the rest
	    		 * s = [a,b,...],  p = [a,c,...]
	    		 *        ^               ^  
	    		 */	
	    		//log.add("case 4-2 curr pat is strict & doesn't match curr char, forget the rest, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = false;
	    		return false;
			} else {
				/*
	    		 * case 4-3:  current pattern is strict and matches current char of string, check rest
	    		 * s = [a,b,...],  p = [a,b,...]
	    		 *        ^               ^  
	    		 */	
	    		//log.add("case 4-3  curr pat is strict and matches curr char, check rest, " + currSInx + ":" + currPInx + " / " + sCharArr[currSInx] + ":" + patterns.get(currPInx).toString());
	    		dp[currSInx][currPInx] = match(sCharArr, currSInx+1, maxSInx, patterns, currPInx+1, maxPInx);
	    		return dp[currSInx][currPInx];    		
			}//fi   		
    	}//fi
    }//end method 
}//end class
