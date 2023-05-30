package Problems;

import java.util.*;

public class Prob10 {
	

	
	public static void test() {

		Solution10 sol = new Solution10();
		String s, p;
		String c;
		
		
		
		s = "aa"; p = "a";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "aa"; p = "a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "ab"; p = ".*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "aa"; p = "."; 
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "a"; p = "."; 
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "bcda"; p = "...."; 
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "bcda"; p = "b..a"; 		
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "bcda"; p = "b...a"; 
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "bcdabbf"; p = "b..f"; 
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "abcd"; p = ".*cd";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		s = "abcd"; p = ".*cc";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");	
		System.out.print(c);
	
		s = "abcd"; p = "abcde*f*g*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		s = ""; p = "d*f*g*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");		
		System.out.print(c);
		s = "abcdefg"; p = "abd*cdg*efg";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s ="aab"; p ="c*a*b";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");		
		System.out.print(c);
		
		s =	"aaa"; p ="ab*ac*a";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "abb"; p = "b*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);		
		s = "aa"; p =	".c*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);	
		s = "ab"; p =	"ac*d*e*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);		
		s = "a"; p = ".*a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);		
		s = "a"; p = "d*a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		s = "012345678901234"; p = "0 1 2345 6 7 8 9 ";
		s = "abbabaaaaaaacaa"; p = "a*.*b.a.*c*b*a*c*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);

		
		s = "abbabaaaaaaacaa"; p = "a*.*b.a.*c*b*a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);

		

		s = "0123456789012345678"; p = "0 12345 6 7 8 9 0";
		s = "abcaaaaaaabaabcabac"; p = ".*ab.a.*a*a*.*b*b*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		s = "bcbabcaacacbcabac"; p = "a*c*a*b*.*aa*c*a*a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		s = "bcbabcaacacbcabac"; p = "b*c*b*.a.*a*.*.*b*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		
		s = "01234567890"; p = "012 34 5 6";	
		s = "mississippi"; p = "mis*is*p*.";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		System.out.println("s=01234567890 p=012 34 5 6");

		
		s = "012345678"; p = "0 12 3 4";	
		s = "ssissippi"; p = "s*is*p*.";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		System.out.println("s=012345678 p=0 12 3 4");		
		
		s = "bbbba"; p = ".*a*a";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");	
		System.out.print(c);
		
	
		s = "aaaaaaaaaaaaaaaaaaab"; p =	"a*a*a*a*a*a*a*a*a*a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		
		s = "ab"; p =	".*..";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		//*/
		
		
		s = "aa"; p = "a*";
		c = (s.matches(p) == sol.isMatch(s,p)) ? "" : ("s=" + s + " p=" + p + " should be: " + s.matches(p) + " ans: " + sol.isMatch(s,p) + "\n");
		System.out.print(c);
		System.out.println("s=01 p=0");				
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution10 {
	
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
}
