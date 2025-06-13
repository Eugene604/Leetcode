package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob1291 {
	

	
	public static void main(String[] args) {
		Solution1291 solObj = new Solution1291();
		List<Integer> solList;
		int high, low;

		low = 1234567;
		high = 2345678;
		solList = solObj.sequentialDigits(low, high);
		System.out.println("sol: " + solList);		


		low = 100;
		high = 500;
		solList = solObj.sequentialDigits(low, high);
		System.out.println("sol: " + solList);	
		

	}

}


class Solution1291 {
	
	private static List<Integer> seqDigList;
	
	static {		
		seqDigList = new ArrayList<>(32);
		
		LENGTH_LOOP:
		for (int length = 1; length <= 9; length++) {
			for (int leadingDigit = 1; leadingDigit <= 9; leadingDigit++) {
				seqDigList.add(generateSDInt(leadingDigit, length));
				if (leadingDigit + length > 9) {					
					continue LENGTH_LOOP;
				}//fi
			}//rof
		}//rof
		//System.out.println(" seqDigList: " + seqDigList);
	}
	
	/**
	 * generate sequential digit integer given leading digit number and length of number
	 * @param leadingDigit - int
	 * @param length - int
	 * @return int, sequential digit with leading digit = leadingDigit 
	 */
	private static int generateSDInt(int leadingDigit, int length) {
		int power = length-1;
		int currDigit = leadingDigit;		
		int sdInt = 0;				
		while (power >= 0) {
			sdInt += (int) (currDigit * Math.pow(10, power));
			power--;
			currDigit++;
		}//rof
		return sdInt;		
	}
	
    public List<Integer> sequentialDigits(int low, int high) {

    	int lowInx = Collections.binarySearch(seqDigList, low);
    	if (lowInx <0) {
    		lowInx = -(lowInx + 1);
    	}
    	int highInx = Collections.binarySearch(seqDigList, high);
    	if (highInx <0) {
    		highInx = -(highInx + 1);
    	} else {
    		highInx++;
    	}
    	//System.out.println( lowInx + " : " + highInx);
    	//System.out.println( seqDigList.get(lowInx) + " : " + seqDigList.get(highInx));
        return seqDigList.subList(lowInx, highInx);
    }//end method
}//end class
