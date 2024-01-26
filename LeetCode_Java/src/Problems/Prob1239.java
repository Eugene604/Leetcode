package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1239{


	static void test() {
		
		List<String> arr1 = null, arr2 = null, arr3 = null;
		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            arr1 = objectMapper.readValue("[\"un\",\"iq\",\"ue\"]", new TypeReference<List<String>>() {});
            
            arr2 = objectMapper.readValue("[\"day\", \"bdq\", \"bko\", \"nxe\"]", new TypeReference<List<String>>() {});
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Solution1239 solObj  = new Solution1239();
		List<String> arr;
		
		
		
		arr = arr2;		
		System.out.println("orignal arr: " + arr);
		System.out.println("ans: " + solObj.maxLength(arr));
		
	}

	public static void main(String[] args) {
		test();

	}

}

class Solution1239{
	//array index: character ascii value. array value: bit position of that character
	static final int[] CHAR_BIT_MAP;
	static final int LONGEST_STR_BITMAP;
	
	static {
		CHAR_BIT_MAP = new int[123];
		CHAR_BIT_MAP[97] = 0b1;
		CHAR_BIT_MAP[98] = 0b10;
		CHAR_BIT_MAP[99] = 0b100;
		CHAR_BIT_MAP[100] = 0b1000; // 'd' is at bit position 4
        CHAR_BIT_MAP[101] = 0b10000; // 'e' is at bit position 5
        CHAR_BIT_MAP[102] = 0b100000; // 'f' is at bit position 6
        CHAR_BIT_MAP[103] = 0b1000000; // 'g' is at bit position 7
        CHAR_BIT_MAP[104] = 0b10000000; // 'h' is at bit position 8
        CHAR_BIT_MAP[105] = 0b100000000; // 'i' is at bit position 9
        CHAR_BIT_MAP[106] = 0b1000000000; // 'j' is at bit position 10
        CHAR_BIT_MAP[107] = 0b10000000000; // 'k' is at bit position 11
        CHAR_BIT_MAP[108] = 0b100000000000; // 'l' is at bit position 12
        CHAR_BIT_MAP[109] = 0b1000000000000; // 'm' is at bit position 13
        CHAR_BIT_MAP[110] = 0b10000000000000; // 'n' is at bit position 14
        CHAR_BIT_MAP[111] = 0b100000000000000; // 'o' is at bit position 15
        CHAR_BIT_MAP[112] = 0b1000000000000000; // 'p' is at bit position 16
        CHAR_BIT_MAP[113] = 0b10000000000000000; // 'q' is at bit position 17
        CHAR_BIT_MAP[114] = 0b100000000000000000; // 'r' is at bit position 18
        CHAR_BIT_MAP[115] = 0b1000000000000000000; // 's' is at bit position 19
        CHAR_BIT_MAP[116] = 0b10000000000000000000; // 't' is at bit position 20
        CHAR_BIT_MAP[117] = 0b100000000000000000000; // 'u' is at bit position 21
        CHAR_BIT_MAP[118] = 0b1000000000000000000000; // 'v' is at bit position 22
        CHAR_BIT_MAP[119] = 0b10000000000000000000000; // 'w' is at bit position 23
        CHAR_BIT_MAP[120] = 0b100000000000000000000000; // 'x' is at bit position 24
        CHAR_BIT_MAP[121] = 0b1000000000000000000000000; // 'y' is at bit position 25
		CHAR_BIT_MAP[122] = 0b10000000000000000000000000; // 'z' is at bit position 25	
							
		LONGEST_STR_BITMAP = 0b11111111111111111111111111;
	}
	
    public int maxLength(List<String> arr) {   
    	//step 1, convert every string to int bit map and meanwhile also check if there's duplicate letter
    	int[] strBMArr = new int[arr.size()];
    	int tmpBitMap;    	
    	STRING_ARR_LOOP:
    	for (int i=0; i<strBMArr.length; i++) {
    		for (char c:arr.get(i).toCharArray()) {
    			tmpBitMap = strBMArr[i] | CHAR_BIT_MAP[c];
    			if (tmpBitMap == strBMArr[i]) { // there's duplicate character
    				strBMArr[i] = 0;
    				continue STRING_ARR_LOOP;
    			}//fi
    			strBMArr[i] = tmpBitMap;    			
    		}//rof  
    	}//rof
    	//System.out.println(Arrays.toString(strBMArr));
    	
    	/* 
    	 * step 2, check every string and see if it conflicts with other
    	 * if not conflicting, add this to current length as it will be included for sure
    	 * if conflicting, add this to conflicting array 
    	 */
    	List<String> conflictStrList = new ArrayList<>(strBMArr.length);
    	List<Integer> conflictStrBMList = new ArrayList<>(strBMArr.length);
    	int currLength = 0; 
    	OUTER_BMARR_LOOP:
    	for (int i=0; i<strBMArr.length; i++) {
    		if (strBMArr[i] == LONGEST_STR_BITMAP) {
    			return 26;
    		} else if (strBMArr[i]==0) {
    			continue OUTER_BMARR_LOOP;
    		}//fi
    		
    		INNER_BMARR_LOOP:
    		for (int j=0; j<strBMArr.length; j++) {
    			if (i==j || strBMArr[j]==0) {
    				continue INNER_BMARR_LOOP;
    			} else if ((strBMArr[i] & strBMArr[j]) != 0) {
    				conflictStrList.add(arr.get(i));
    				conflictStrBMList.add(strBMArr[i]);
    				continue OUTER_BMARR_LOOP;
    			}//fi    			
    		}//rof
    		strBMArr[i] = 0;
    		currLength += arr.get(i).length();
    	}//rof

    	//System.out.println(currLength + "  : " + conflictStrList + " : " + conflictStrBMList);
    	//step 3, recursively find the max length that can be constructed by conflicting string list
        return currLength + maxLength(conflictStrBMList, conflictStrList, 0, 0);
    }//end method
    
    /**
     * recursively find max length
     * 
     * @param bmList - List<Integer>, list of bit map integers
     * @param strList - List<String>, list of strings
     * @param currBM - int, current aggregated bit map value
     * @param currInx - int, the array index value to process
     * @return int, unique character length
     */
    private int maxLength(List<Integer> bmList, List<String> strList, int currBM, int currInx) {    
    	
    	//base case 1, currInx arrived end
    	if (currInx >= bmList.size()) {
    		return 0;
    	}//fi
    	
    	
    	//base case 2, current bit map conflict with the bit map at current index. Don't add self and proceed to next
    	if ((currBM & bmList.get(currInx)) != 0) {    	
    		//System.out.println("itr case 2: " + strList.get(currInx) + " : " + currBM);
    		return maxLength(bmList, strList, currBM, currInx+1); 
    	}//fi
    	//System.out.println("itr case 3: " + strList.get(currInx) + " : " + currBM);
    	return Math.max(
    			strList.get(currInx).length() + maxLength(bmList, strList, currBM | bmList.get(currInx), currInx+1), 
    			maxLength(bmList, strList, currBM, currInx+1));
    	
    }//end method
}// end class
