package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;

public class Prob273{

	
	

	public static void main(String[] args) {
		int num;
		Solution273 solObj = new Solution273();

		
		num = 100;
		System.out.println("ans: " + solObj.numberToWords(num));
		
		/*

				
		num = 113000000; //"One Hundred Thirteen Million"
		System.out.println("ans: " + solObj.numberToWords(num) + "Stop"); 
		
		num = 546384;
		System.out.println("ans: " + solObj.numberToWords(num));
		
		num = 11126384;
		System.out.println("ans: " + solObj.numberToWords(num));
		
		num = Integer.MAX_VALUE-50;
		System.out.println("ans: " + solObj.numberToWords(num));
		//*/
	}

}

class Solution273{
	private static final Map<Integer, String> NUM_STR_MAP;
	static {
		NUM_STR_MAP = new HashMap<>();
		NUM_STR_MAP.put(0,"");
		NUM_STR_MAP.put(1,"One");
		NUM_STR_MAP.put(2,"Two");
        NUM_STR_MAP.put(3,"Three");
        NUM_STR_MAP.put(4,"Four");
        NUM_STR_MAP.put(5,"Five");
        NUM_STR_MAP.put(6,"Six");
        NUM_STR_MAP.put(7,"Seven");
        NUM_STR_MAP.put(8,"Eight");
        NUM_STR_MAP.put(9,"Nine");
        NUM_STR_MAP.put(10,"Ten");
        NUM_STR_MAP.put(11,"Eleven");
        NUM_STR_MAP.put(12,"Twelve");
        NUM_STR_MAP.put(13,"Thirteen");
        NUM_STR_MAP.put(14,"Fourteen");
        NUM_STR_MAP.put(15,"Fifteen");
        NUM_STR_MAP.put(16,"Sixteen");
        NUM_STR_MAP.put(17,"Seventeen");
        NUM_STR_MAP.put(18,"Eighteen");
        NUM_STR_MAP.put(19,"Nineteen");
        NUM_STR_MAP.put(20,"Twenty");
        NUM_STR_MAP.put(21,"Twenty One");
        NUM_STR_MAP.put(22,"Twenty Two");
        NUM_STR_MAP.put(23,"Twenty Three");
        NUM_STR_MAP.put(24,"Twenty Four");
        NUM_STR_MAP.put(25,"Twenty Five");
        NUM_STR_MAP.put(26,"Twenty Six");
        NUM_STR_MAP.put(27,"Twenty Seven");
        NUM_STR_MAP.put(28,"Twenty Eight");
        NUM_STR_MAP.put(29,"Twenty Nine");
        NUM_STR_MAP.put(30,"Thirty");
        NUM_STR_MAP.put(31,"Thirty One");
        NUM_STR_MAP.put(32,"Thirty Two");
        NUM_STR_MAP.put(33,"Thirty Three");
        NUM_STR_MAP.put(34,"Thirty Four");
        NUM_STR_MAP.put(35,"Thirty Five");
        NUM_STR_MAP.put(36,"Thirty Six");
        NUM_STR_MAP.put(37,"Thirty Seven");
        NUM_STR_MAP.put(38,"Thirty Eight");
        NUM_STR_MAP.put(39,"Thirty Nine");
        NUM_STR_MAP.put(40,"Forty");
        NUM_STR_MAP.put(41,"Forty One");
        NUM_STR_MAP.put(42,"Forty Two");
        NUM_STR_MAP.put(43,"Forty Three");
        NUM_STR_MAP.put(44,"Forty Four");
        NUM_STR_MAP.put(45,"Forty Five");
        NUM_STR_MAP.put(46,"Forty Six");
        NUM_STR_MAP.put(47,"Forty Seven");
        NUM_STR_MAP.put(48,"Forty Eight");
        NUM_STR_MAP.put(49,"Forty Nine");
        NUM_STR_MAP.put(50,"Fifty");
        NUM_STR_MAP.put(51,"Fifty One");
        NUM_STR_MAP.put(52,"Fifty Two");
        NUM_STR_MAP.put(53,"Fifty Three");
        NUM_STR_MAP.put(54,"Fifty Four");
        NUM_STR_MAP.put(55,"Fifty Five");
        NUM_STR_MAP.put(56,"Fifty Six");
        NUM_STR_MAP.put(57,"Fifty Seven");
        NUM_STR_MAP.put(58,"Fifty Eight");
        NUM_STR_MAP.put(59,"Fifty Nine");
        NUM_STR_MAP.put(60,"Sixty");
        NUM_STR_MAP.put(61,"Sixty One");
        NUM_STR_MAP.put(62,"Sixty Two");
        NUM_STR_MAP.put(63,"Sixty Three");
        NUM_STR_MAP.put(64,"Sixty Four");
        NUM_STR_MAP.put(65,"Sixty Five");
        NUM_STR_MAP.put(66,"Sixty Six");
        NUM_STR_MAP.put(67,"Sixty Seven");
        NUM_STR_MAP.put(68,"Sixty Eight");
        NUM_STR_MAP.put(69,"Sixty Nine");
        NUM_STR_MAP.put(70,"Seventy");
        NUM_STR_MAP.put(71,"Seventy One");
        NUM_STR_MAP.put(72,"Seventy Two");
        NUM_STR_MAP.put(73,"Seventy Three");
        NUM_STR_MAP.put(74,"Seventy Four");
        NUM_STR_MAP.put(75,"Seventy Five");
        NUM_STR_MAP.put(76,"Seventy Six");
        NUM_STR_MAP.put(77,"Seventy Seven");
        NUM_STR_MAP.put(78,"Seventy Eight");
        NUM_STR_MAP.put(79,"Seventy Nine");
        NUM_STR_MAP.put(80,"Eighty");
        NUM_STR_MAP.put(81,"Eighty One");
        NUM_STR_MAP.put(82,"Eighty Two");
        NUM_STR_MAP.put(83,"Eighty Three");
        NUM_STR_MAP.put(84,"Eighty Four");
        NUM_STR_MAP.put(85,"Eighty Five");
        NUM_STR_MAP.put(86,"Eighty Six");
        NUM_STR_MAP.put(87,"Eighty Seven");
        NUM_STR_MAP.put(88,"Eighty Eight");
        NUM_STR_MAP.put(89,"Eighty Nine");
        NUM_STR_MAP.put(90,"Ninety");
        NUM_STR_MAP.put(91,"Ninety One");
        NUM_STR_MAP.put(92,"Ninety Two");
        NUM_STR_MAP.put(93,"Ninety Three");
        NUM_STR_MAP.put(94,"Ninety Four");
        NUM_STR_MAP.put(95,"Ninety Five");
        NUM_STR_MAP.put(96,"Ninety Six");
        NUM_STR_MAP.put(97,"Ninety Seven");
        NUM_STR_MAP.put(98,"Ninety Eight");
        NUM_STR_MAP.put(99,"Ninety Nine");
        NUM_STR_MAP.put(100,"Hundred");
        NUM_STR_MAP.put(1000,"Thousand");
        NUM_STR_MAP.put(1000000,"Million");
        NUM_STR_MAP.put(1000000000,"Billion");		
	}//end static block
	
    public String numberToWords(int num) {
    	LinkedList<String> numberStrList = new LinkedList<>();
    	int dividend = num;
    	String currLeastThreeSigDigStr;
    	
    	//step 1: Check for the case where num == 0
    	if (dividend == 0) {
    		return "Zero";
    	}//fi
    	
    	//step 2: Check for tens and hundreds    	
    	//System.out.println("dividend: " + dividend);
    	numberStrList.addFirst(leastThreeSigDigToStr(dividend));
    	dividend /= 1000;
    	if (dividend == 0) {
    		return flattenList(numberStrList);
    	} else if (numberStrList.getFirst().length() > 1) {
    		numberStrList.addFirst(" ");
    	}//fi
    	    	    
    	//step 3: Check for thousands
    	//System.out.println("dividend: " + dividend);
    	currLeastThreeSigDigStr = leastThreeSigDigToStr(dividend);
    	if (currLeastThreeSigDigStr.length() > 1) {
        	numberStrList.addFirst(" Thousand");
        	numberStrList.addFirst(currLeastThreeSigDigStr);
    	}
    	dividend /= 1000;
    	if (dividend == 0) {
    		return flattenList(numberStrList);
    	} else if (numberStrList.getFirst().length() > 1) {
    		numberStrList.addFirst(" ");
    	}//fi
    	
    	//step 4: Check for million
    	//System.out.println("dividend: " + dividend);
    	currLeastThreeSigDigStr = leastThreeSigDigToStr(dividend);
    	if (currLeastThreeSigDigStr.length() > 1) {
        	numberStrList.addFirst(" Million");
        	numberStrList.addFirst(currLeastThreeSigDigStr);
    	}
    	dividend /= 1000;
    	if (dividend == 0) {
    		return flattenList(numberStrList);
    	} else if (numberStrList.getFirst().length() > 1) {
    		numberStrList.addFirst(" ");
    	}//fi
    	
    	//step 4: Check for billion
    	numberStrList.addFirst(" Billion");
    	numberStrList.addFirst(leastThreeSigDigToStr(dividend));
    	return flattenList(numberStrList);

    }//end method
    
    /**
     * This method extract the last 3 digits of num and convert it to string 
     * precondition:
     * - num > 0	 
     * @param num - int, must be > 0
     * @return String
     */
    private String leastThreeSigDigToStr(int num){    	

    	int leastTwoSigDigVal = num%100;
    	num /= 100;
    	int thirdSigDigVal = num%10;

    	if (thirdSigDigVal == 0) {
    		return NUM_STR_MAP.get(leastTwoSigDigVal);
    	} else if (leastTwoSigDigVal == 0){
    		return NUM_STR_MAP.get(thirdSigDigVal) + " Hundred";
    	} else {
    		return NUM_STR_MAP.get(thirdSigDigVal) + " Hundred " + NUM_STR_MAP.get(leastTwoSigDigVal);
    	}//fi
    	
    }//end method
    
    /**
     * precondition:
     * strList is not null
     * 
     * @param strList - List<String>
     * @return String
     */
    private String flattenList(List<String> strList) {
    	StringBuilder sb = new StringBuilder();
    	for (String numStr:strList) {
    		sb.append(numStr);
    		//sb.append(" ");
    	}//rof
    	//sb.delete(sb.length()-1,sb.length());
    	return sb.toString();
    }//end method
}// end class

