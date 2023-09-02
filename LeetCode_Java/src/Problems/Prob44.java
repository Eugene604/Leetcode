package Problems;


public class Prob44 {
	

	
	public static void test() {

		Solution44 sol = new Solution44();
		Solution44_v1 correctSol = new Solution44_v1();
		String s, p;		
		
	
		s = "aa"; p = "a";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));

		 
		s = "aa"; p = "?"; 
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "a"; p = "?"; 
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "bcda"; p = "?????"; 
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		
			
		s = "ab"; p = "?*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
			
		s = "aa"; p = "a*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "bcda"; p = "b??a"; 		
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "bcda"; p = "b???a"; 
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "bcdabbf"; p = "b??f"; 
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s = "abcd"; p = "?*cd";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		
		s = "abcd"; p = "?*cc";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));	
		 
	
		s = "abcd"; p = "abcde*f*g*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		
		s = ""; p = "d*f*g*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));		
		 
		s = "abcdefg"; p = "abd*cdg*efg";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 
		s ="aab"; p ="c*a*b";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));		
		 
	
		
		s =	"aaa"; p ="ab*ac*a";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));

		
		s = "abb"; p = "b*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 		
		s = "aa"; p =	"?*?";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 	
		s = "ab"; p =	"ac*d*e*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 		
		s = "a"; p = "*a*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 		
		s = "a"; p = "d*a*";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		 


	
		s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"; p = "a*******b";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));	
			
		s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));	

		
		s = "aaaa"; p = "***a";
		System.out.println("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		
				s = "aaaa"; p = "***a";
		System.out.println("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));
		


			//*/	
		

		s = "abb"; p = "**??";
		System.out.print("s=" + s + " p=" + p + " ");
		System.out.println("ans correct?: " + (sol.isMatch(s,p) == correctSol.isMatch(s,p)));

		 

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}


class Solution44 {
	
    public boolean isMatch(String s, String p) {
    	
    	//special case, pattern length = 0;
    	if (p.length() == 0) {
    		return s.length() == 0;	
    	}//fi  
    	
		/* general algorithm:
		 * - prepare variables to store backtrack point
		 * - try match character first, 
		 * - if encountered *, establish backtrack point and keep going (ignore the pattern)
		 * - if not match, go back to backtrack point and advance an index
		 *   
		 */
    	int sInx = 0, pInx = 0, btSInx = -1, btPInx = -1;
    	while (sInx < s.length()) {
    		//System.out.println("enter loop sInx:" + sInx + " pInx:" + pInx + " btSInx:" + btSInx + " btPInx:" + btPInx);
    		
    		if (pInx == p.length()) { 	
    			//pInx has reached end of pat but still has string left
    			 if (btSInx == -1) {
    				 //there is no backtrack point 
    				 return false;
    			 } else if (p.charAt(pInx-1) == '*') {
    				 //there is backtrack point and last pattern is *
    				 return true;
    			 } else {
    				//there is backtrack point
	    			btSInx++;
	    			sInx = btSInx;
	    			pInx = btPInx;     				 
    			 }//fi
    		}//fi */
    		
    		
    		if (p.charAt(pInx) == '?' || p.charAt(pInx) == s.charAt(sInx)) {    	 		
    			sInx++;
    			pInx++;
    		} else if (p.charAt(pInx) == '*' ) { //backtrack point encountered
    			btSInx = sInx; //establish backtract pt using current string index
    			pInx++;
    			btPInx = pInx; //backtract pattern index is the pattern following *    			
    		} else if (btSInx > -1) { //backtrack point has been established	
    			btSInx++;
    			sInx = btSInx;
    			pInx = btPInx;
    		} else {
    			return false;
    		}//fi
    		//System.out.println("gone end sInx:" + sInx + " pInx:" + pInx);
    	}//end while
    	
   		//end case : sInx has reached end of string, check rest of pat
		for (int tmpPInx = pInx; tmpPInx < p.length(); tmpPInx++) {
			if (p.charAt(tmpPInx) != '*') {
				return false;
			}//fi
		}//rof    	
		return true; 
    }//end method   
}//end class

class Solution44_v2 {
	
	
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
			if (character == c || character == '?' || character == '*') {
				return true;
			} else {
				return false;
			}//fi
		}//end method
		
		public Pattern (char character) {
			this.character = character;
			if (this.character == '*') {
				this.patternType = 1;
			} else {
				this.patternType = 0;
			}//fi			
		}//end constructor		
		
	}//end class

	
	private Boolean[][] matchCache;

	/**
	 * This method parses pattern string and build array of pattern objects
	 * precondition: it is assumed that pattern is valid
	 * @param p Pattern String
	 * @return Array of pattern object
	 */
	public Pattern[] buildPatternArr(String p) {
		Pattern[] patternArr = new Pattern[p.length()];
		patternArr[0] = new Pattern(p.charAt(0)); 	
		int currPatInx = 1;
    	for (int pStrInx = 1; pStrInx < p.length(); pStrInx++) {
    		if (p.charAt(pStrInx) == '*' && patternArr[currPatInx-1].character == '*') {
    			continue;
    		} else {
    			patternArr[currPatInx] = new Pattern(p.charAt(pStrInx));
    			currPatInx++;
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
     * @return
     */
    private boolean match(String str, Pattern[] patArr, int strInx, int patInx) {
    	//System.out.println("strInx: " + strInx + " patInx:" + patInx);
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
    		 * can skip as many characters as needed
		     * s = [a,b,c,d],  p = [a,*,b,c,d]
			 *   stay ^               ^ skip 
    		 */	
    		matchCache[strInx][patInx] = true;
    	} else {
       		/* case 2-2:  pattern not strict and using the pattern  
    		 * try match as many character as needed
		     * s = [a,b,b,e,f,g,g,b,b,b,b,c,d],  p = [a,*,c,d]
			 *   try match all these ^                  ^ stay
    		 */
    		int currStrInx;
    		matchCache[strInx][patInx] = false;
    		for (currStrInx = strInx; 
    				currStrInx < str.length() && 
    				!matchCache[strInx][patInx]
    				; 
    				currStrInx++) {
    			matchCache[strInx][patInx] |= match(str, patArr, currStrInx+1, patInx+1); 
    		}//rof    		
    	}//fi
    	return matchCache[strInx][patInx];	
    }//end method
 
}//end class

class Solution44_v1 {

	private Boolean[][] matchCache;
	
    public boolean isMatch(String s, String p) {
    	
    	//special case, pattern length = 0;
    	if (p.length() == 0) {
    		return s.length() == 0;	
    	}//fi  
    	
    	   	
		//match recursively 	
		matchCache = new Boolean[s.length()+1][p.length()+1];
    	return match(s, p, 0, 0);
    }//end method
    

    /**
     * Recursively matches string and given pattern
     * @param str string to be matched 
     * @param patStr pattern string
     * @param strInx current index of string array
     * @param patInx current index of pattern array
     * @return
     */
    private boolean match(String str, String patStr, int strInx, int patInx) {
    	//System.out.println("strInx: " + strInx + " patInx:" + patInx);
    	if (matchCache[strInx][patInx] != null) {
    		return matchCache[strInx][patInx];
    	}//fi
    	//base case 1: strInx has surpassed end of string, check rest of pat
    	if (strInx > str.length()-1) {
			for (int tmpPInx = patInx; tmpPInx < patStr.length(); tmpPInx++) {
				if (patStr.charAt(tmpPInx) != '*') {
					matchCache[strInx][patInx] = false;
					return false;
				}//fi
			}//rof
			matchCache[strInx][patInx] = true;
			return true;
    	}//fi
    	
    	//base case 2: patInx has surpassed end of pat 
    	if (patInx > patStr.length()-1) {	
    		matchCache[strInx][patInx] = false;
			return false;
    	}//fi
    	
    	//recursive case 1: curr pat is strict
    	if (patStr.charAt(patInx) != '*') {
    		if (patStr.charAt(patInx) == '?' || patStr.charAt(patInx) == str.charAt(strInx)) {
    			matchCache[strInx][patInx] = match(str, patStr, strInx+1, patInx+1);  			
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
    	if (match(str, patStr, strInx, patInx+1)) {
    		/* case 2-1:  pattern not strict and NOT using the pattern  
    		 * can skip as many characters as needed
		     * s = [a,b,c,d],  p = [a,*,b,c,d]
			 *   stay ^               ^ skip 
    		 */	
    		matchCache[strInx][patInx] = true;
    	} else {
       		/* case 2-2:  pattern not strict and using the pattern  
    		 * try match as many character as needed
		     * s = [a,b,b,e,f,g,g,b,b,b,b,c,d],  p = [a,*,c,d]
			 *   try match all these ^                  ^ stay
    		 */
    		int currStrInx;
    		matchCache[strInx][patInx] = false;
    		for (currStrInx = strInx; 
    				currStrInx < str.length() && 
    				!matchCache[strInx][patInx]; 
    				currStrInx++) {
    			matchCache[strInx][patInx] |= match(str, patStr, currStrInx+1, patInx+1); 
    		}//rof    		
    	}//fi
    	return matchCache[strInx][patInx];	
    }//end method
 
}//end class
