package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob2483 {
	
	private static String customer1 = "YYNY";
	private static String customer2 = "NNNNN";
	private static String customer3 = "YYYY";
	
	private static String customer4 = "YNNNN";
	
	private static String customer5 = "YNYNYNYN";
	//161
	private static String customer6 = "YYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNYNYNYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN";
	
	private static String customer7 = "YNYY";
	
	private static String customer10;
	
	public static void test() {

		Path filePath = Paths.get("./TestFiles/Prob2483.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_str_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob2483.class.getDeclaredField(lines.get(i+1));
            	field.set(null, lines.get(i+2));
				
            }//rof
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();       
        } catch (IOException e) {
            e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try catch
		
        
		Solution2483 solObj = new Solution2483();
		String str;
		
		/*
		str = customer5;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));

		str = customer2;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		
		str = customer3;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		
		str = customer4;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		
		str = customer5;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		
		str = customer6;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		
		str = customer10;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
		//*/
		
		str = customer7;
		System.out.println("c: " + str);
		System.out.println("ans: " + solObj.bestClosingTime(str));
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution2483 {
	
	private String customerStr;
	private int[] noClientHrArr;
	private int noClientHrArrLength;
	


    public int bestClosingTime(String customers) {
    	this.customerStr = customers;
    	populateData();
    	//System.out.println("arr: " + Arrays.toString(noClientHrArr));  	
        return searchMinPaneltyClosingHr();
    }//method
    
    private int searchMinPaneltyClosingHr() {
    	//special case 1, no client came at all
    	if (noClientHrArrLength == customerStr.length()) {
    		return 0;
    	}//fi
    	//special case 2, every hour got client coming
    	if (noClientHrArrLength == 0) {
    		return customerStr.length();
    	}//fi
    	
    	int globalMinPaneltyClosingHour = 0;
    	int globalMinPanelty = customerStr.length()-noClientHrArrLength;
    	int currPanelty;

    	for (int i = 0; i < noClientHrArrLength; i++) {
    		if (i>0 && noClientHrArr[i]==noClientHrArr[i-1]) {
    			continue;
    		}//fi
			currPanelty = getPenalty(i);
			if (currPanelty < globalMinPanelty) {
				globalMinPanelty = currPanelty;
				globalMinPaneltyClosingHour = noClientHrArr[i];
			}//fi
    	}//fi
    	
    	//also check for the possibility of closing at very end
		if (noClientHrArrLength < globalMinPanelty) {
			return customerStr.length();
		}//fi
    	return globalMinPaneltyClosingHour;
    }//end method
    /**
     * precondition:
     * - String customerStr is set
     * postcondition:
     * - coming hour array populated
     * - coming hour array length set
     */
    private void populateData(){
    	noClientHrArr = new int[customerStr.length()];    	
    	noClientHrArrLength = 0;
    	for (int i=0; i < customerStr.length(); i++) {
    		if (customerStr.charAt(i)=='N') {
    			noClientHrArr[noClientHrArrLength]=i;
    			noClientHrArrLength++;
    		}//fi
    	}//rof	
    }//end method
    
    /**
     * precondition:
     * data structures are prepared
     * - coming hour array populated
     * - coming hour array length set
     * noClientHrArrRefInx assumes to be a valid input
     * @param noClientHrArrRefInx - int, reference index number of no client  hour array. 
     * @return - int indicating penalty
     */
    private int getPenalty(int noClientHrArrRefInx) {
    	int closingHour = noClientHrArr[noClientHrArrRefInx];
    	int penalty = noClientHrArrRefInx;
    	penalty += customerStr.length()- closingHour - (noClientHrArrLength - noClientHrArrRefInx);
    	return penalty;
    }//end method
}//end class
