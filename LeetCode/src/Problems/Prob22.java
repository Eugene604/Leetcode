package Problems;

import java.util.*;



public class Prob22 {
	
	static void test() {
		System.out.println("test starts");
		Solution22 solObj = new Solution22();
		int n;
		/*
		n=8;
		System.out.println("n: " + n + " : " + solObj.generateParenthesis(n));
		n=2;
		System.out.println("n: " + n + " : " + solObj.generateParenthesis(n));
		n=3;
		System.out.println("n: " + n + " : " + solObj.generateParenthesis(n));
		*/
		List<String> res = new ArrayList<>();

        solObj.backtrack(new StringBuilder(), 4, 0, 0, res);
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution22 {
	private static Map<Integer, List<String>> parenthesesMap= new HashMap<>();	
    public List<String> generateParenthesis(int n) {
    	List<String> ansList = parenthesesMap.get(n);
    	if (ansList != null) {
    		return ansList;
    	}//fi
    	//base case
    	if (n == 1) {
    		ansList = new LinkedList<>();
    		ansList.add("()");
        	parenthesesMap.put(n, ansList);
        	return ansList;
    	}//fi
    	//rest of cases
    	ansList = new LinkedList<>();
    	Set<String> ansSet = new HashSet<>();
    	List<String> l1, l2;
    	for (int i = 1; i <= n/2; i++) {
    		l1 = generateParenthesis(i);
    		l2 = generateParenthesis(n-i);
    		ansSet.addAll(combine(l1,l2));
    	}//rof
    	StringBuilder sb = new StringBuilder();
    	sb.append('(');
    	for (String str:generateParenthesis(n-1)) {
    		sb.append(str);
    		sb.append(')');
    		ansList.add(sb.toString());
    		sb.setLength(1);
    	}//rof
    	
    	ansList.addAll(ansSet);
    	parenthesesMap.put(n, ansList);
    	return ansList;
    }//end method
    
    /**
     * Combine two list of strings, both l1-l2 and l2-l1 pairs will be generated
     * @param l1 List<String> type, assumed to be not null
     * @param l2 List<String> type, assumed to be not null
     * @return Set containing the combination of two list
     */
    private Set<String> combine(List<String> l1, List<String> l2) {
    	Set<String> ansSet = new HashSet<>();
    	for (String str1: l1) {
    		for (String str2: l2) {
    			ansSet.add(str1+str2);
    			ansSet.add(str2+str1);
    		}//rof
    	}//rof
    	return ansSet;
    }//end method
    
    public void backtrack(StringBuilder tmpRes, int n, int open, int close, List<String> res) {
    	System.out.println("Open:" + open + " Close:" + close + " res:" + tmpRes.toString());
        if (tmpRes.length() == 2 * n ) {
            res.add(tmpRes.toString());
            return;
        }

        if (open < n) {
            tmpRes.append('(');
            backtrack(tmpRes, n, open + 1, close, res);
            tmpRes.setLength(tmpRes.length() - 1);
        }
        

        if (open > close) {
            tmpRes.append(')');
            backtrack(tmpRes, n, open, close + 1, res);
            tmpRes.setLength(tmpRes.length() - 1);
        }
       

    }
	
}//end class


