package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob13 {
	

	
	public static void test() {
		Solution13 sol = new Solution13();
		Solution12 sol12 = new Solution12();
		for (int n = 1; n < 4000; n++) {
			String numStr = sol12.intToRoman(n);
			if (sol.romanToInt(numStr) != n) {
				System.out.println("error converting " + n + ", output: " + sol.romanToInt(numStr));
			}			
		};
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution13 {

	static Map<String, Integer> unitsRomanToIntMap;
	static Map<String, Integer> tensRomanToIntMap;
	static Map<String, Integer> hundredsRomanToIntMap;
	static Map<String, Integer> thousandsRomanToIntMap;
	static {
		thousandsRomanToIntMap = new LinkedHashMap<>(); //has to be linked map
		thousandsRomanToIntMap.put("MMM",3000); //has to be put in this order
		thousandsRomanToIntMap.put("MM",2000);
		thousandsRomanToIntMap.put("M",1000);
		
		hundredsRomanToIntMap = new LinkedHashMap<>();	
		hundredsRomanToIntMap.put("CM",900);
		hundredsRomanToIntMap.put("DCCC",800);
		hundredsRomanToIntMap.put("DCC",700);
		hundredsRomanToIntMap.put("DC",600);
		hundredsRomanToIntMap.put("D",500);
		hundredsRomanToIntMap.put("CD",400);
		hundredsRomanToIntMap.put("CCC",300);
		hundredsRomanToIntMap.put("CC",200);		
		hundredsRomanToIntMap.put("C",100);
	
		tensRomanToIntMap = new LinkedHashMap<>();	
		tensRomanToIntMap.put("XC",90);
		tensRomanToIntMap.put("LXXX",80);
		tensRomanToIntMap.put("LXX",70);
		tensRomanToIntMap.put("LX",60);
		tensRomanToIntMap.put("L",50);
		tensRomanToIntMap.put("XL",40);
		tensRomanToIntMap.put("XXX",30);
		tensRomanToIntMap.put("XX",20);
		tensRomanToIntMap.put("X",10);
			
		unitsRomanToIntMap = new LinkedHashMap<>();	
		unitsRomanToIntMap.put("IX",9);
		unitsRomanToIntMap.put("VIII",8);
		unitsRomanToIntMap.put("VII",7);
		unitsRomanToIntMap.put("VI",6);
		unitsRomanToIntMap.put("V",5);				
		unitsRomanToIntMap.put("IV",4);
		unitsRomanToIntMap.put("III",3);
		unitsRomanToIntMap.put("II",2);
		unitsRomanToIntMap.put("I",1);
		

	}
    public int romanToInt(String s) {
    	Integer n = Integer.valueOf(0);
    	int searchInx, frontInx = 0;
    	//check thousands numerals
    	for (Entry<String, Integer> e:thousandsRomanToIntMap.entrySet()) {
    		searchInx = s.indexOf(e.getKey(), frontInx);
    		if (searchInx == frontInx) {
    			n += e.getValue();
    			frontInx += e.getKey().length();
    			break;
    		}//fi
    	}//rof
    	
    	//check hundreds numerals
    	for (Entry<String, Integer> e:hundredsRomanToIntMap.entrySet()) {
    		searchInx = s.indexOf(e.getKey(), frontInx);
    		if (searchInx == frontInx) {
    			n += e.getValue();
    			frontInx += e.getKey().length();
    			break;
    		}//fi
    	}//rof

    	//check tens numerals
    	for (Entry<String, Integer> e:tensRomanToIntMap.entrySet()) {
    		searchInx = s.indexOf(e.getKey(), frontInx);
    		if (searchInx == frontInx) {
    			n += e.getValue();
    			frontInx += e.getKey().length();
    			break;
    		}//fi
    	}//rof
 
    	//check units numerals
    	for (Entry<String, Integer> e:unitsRomanToIntMap.entrySet()) {
    		searchInx = s.indexOf(e.getKey(), frontInx);
    		if (searchInx == frontInx) {
    			n += e.getValue();
    			frontInx += e.getKey().length();
    			break;
    		}//fi
    	}//rof
   	
        return n;
    }//method
}//end class
