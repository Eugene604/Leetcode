package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob726{
	

	
	public static void test() {

		Solution726 solObj = new Solution726();

		String formula;

	
		
		formula = "H2O";
		System.out.println(" ans: " + solObj.countOfAtoms(formula));
		
		//String test = "123ABC";

		//System.out.println(Integer.parseInt(test,0,3, 10));

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution726{
	
	String formula;

    public String countOfAtoms(String formula) {
    	this.formula = formula;
    	TreeMap<String, Integer> atomMap = parseFormula(0, this.formula.length()-1);
    	StringBuilder sb = new StringBuilder();
    	for (Entry<String, Integer> entry : atomMap.entrySet()) {
    		sb.append(entry.getKey());
    		if (entry.getValue() > 1) {
    			sb.append(entry.getValue());
    		}
    		
    	}//rof
        return sb.toString();
    }//end method   
    
    /**
     * precondition:
     * -global valuable formula string is set
     * -assumes that formula is valid
     * -indices are valid
     * @param leftInx - int, inclusive
     * @param rightInx - int, inclusive
     * @return TreeMap< element string, count>
     */
    private TreeMap<String, Integer> parseFormula(int leftInx, int rightInx){
    	TreeMap<String, Integer> atomMap = new TreeMap<>();
    	int i=leftInx; 
    	while (i<=rightInx) {
    		//System.out.println("enter while, i:" + i + " of left/right:" + leftInx + "/" + rightInx + " processing:" + formula.substring(leftInx, rightInx+1));
    		if (formula.charAt(i) == 40) { //case 1, left bracket encountered
    			
    			int leftBracketInx = i;
    			int leftBracketCnt = 1;
    			do {
    				i++;
    				if (formula.charAt(i) == 40) {
        				leftBracketCnt++;
        			} else if (formula.charAt(i) == 41) {
            			leftBracketCnt--;
        			}//fi    				
    			} while (leftBracketCnt > 0);//end do while
    			TreeMap<String, Integer> subMap = parseFormula(leftBracketInx+1, i-1);    			
    			int subscript;
    			i++;
    			int leftSSInx = i;
    			int rightSSInx = i-1;    			
    			while (i<=rightInx && (formula.charAt(i) >= 48 && formula.charAt(i) <= 57)) {
    				rightSSInx = i;
    				i++;
    			}//end while
    			if (rightSSInx - leftSSInx >= 0) {
    				//System.out.println( leftSSInx + ":" + rightSSInx);
    				subscript = Integer.parseInt(formula, leftSSInx, rightSSInx+1,10);
    			} else {
    				subscript = 1;
    			}//fi
    			
    			mergeMap(atomMap, subMap,subscript);
    			    			
    		} else if (formula.charAt(i) >= 65 && formula.charAt(i) <= 90) {//case 2, element symbol encountered    			
    			int leftAtomSymbolInx = i;
    			int rightAtomSymbolInx = i;
    			i++;
    			while (i<=rightInx && formula.charAt(i) >= 97 &&  formula.charAt(i) <= 122) {    				
    				rightAtomSymbolInx = i;		
    				i++;
    			}//end while
    			
    			int subscript;
    			int leftSSInx = i;
    			int rightSSInx = i-1;    			
    			while (i<=rightInx && (formula.charAt(i) >= 48 && formula.charAt(i) <= 57)) {
    				rightSSInx = i;
    				i++;
    			}//end while
    			if (rightSSInx - leftSSInx >= 0) {    				
    				subscript = Integer.parseInt(formula, leftSSInx, rightSSInx+1,10);
    			} else {
    				subscript = 1;
    			}//fi
    			
    			String symbol = formula.substring(leftAtomSymbolInx, rightAtomSymbolInx+1);
    			Integer cnt = atomMap.get(symbol); 
    			if (cnt == null) {
    				atomMap.put(symbol, subscript);
    			} else {
    				atomMap.put(symbol, cnt + subscript);
    			}//fi
    		} else {//a valid formula will not reach here
    			System.out.println("invalid formula");
    			i++;
    		}//fi
    		//System.out.println("exit loop with inx:" + atomMap);
    	}//rof
    	return atomMap;
    }//end method
    
    /**
     * Merges the secondary map into the primary map, multiplying the counts in the secondary map by the given multiplier.
     * 
     * @param primaryMap -  Map<String, Integer>, the map into which the secondary map will be merged.
     * @param secondaryMap -  Map<String, Integer>, the map to be merged into the primary map.
     * @param multiplier - int, the value by which to multiply the counts in the secondary map.
     */
    void mergeMap(Map<String, Integer> primaryMap, Map<String, Integer> secondaryMap, int multiplier) {
    	Integer cnt;
    	for (Entry<String, Integer> entry : secondaryMap.entrySet()) {
    		cnt = primaryMap.get(entry.getKey()); 
    		if (cnt == null) {
    			primaryMap.put(entry.getKey(), entry.getValue()*multiplier);
    		} else {
    			primaryMap.put(entry.getKey(), entry.getValue()*multiplier + cnt);
    		}//fi
    	}//rof
    			
    }//end method
   
}//end class
