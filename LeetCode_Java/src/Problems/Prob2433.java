package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob2433 {

	private static int[] arr1 = {5,2,0,3,1};
	private static int[] arr2 = {13};
	private static int[] arr10;

	public static void test() {
		Path filePath = Paths.get("./TestFiles/Prob2433.dat");
		
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob2433.class.getDeclaredField(lines.get(i+1));
            	String[] tmpStrArr = lines.get(i+2).split(",");
                int[] tmpIntArr = new int[tmpStrArr.length];
                for (int j = 0; j < tmpStrArr.length; j++) {
                	tmpIntArr[j] = Integer.parseInt(tmpStrArr[j]);
                }//rof
				field.set(null, tmpIntArr);
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
        

		Solution2433 solObj = new Solution2433();
		int[] testArr;

		testArr = arr1;
		System.out.println(Arrays.toString(solObj.findArray(testArr)) + ":" + Arrays.toString(testArr));

		testArr = arr10;
		System.out.println(Arrays.toString(solObj.findArray(testArr)) + ":" + Arrays.toString(testArr));

		// */
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}


class Solution2433 {

	
    public int[] findArray(int[] pref) {
    	if (pref.length<2) {
    		return pref;
    	}//fi
    	int[] ansArr = new int[pref.length];
    	ansArr[0]=pref[0];
    	int cumulativeXORResult = 0;
    	for (int i=1; i<pref.length; i++) {    		
    		cumulativeXORResult = cumulativeXORResult ^ ansArr[i-1];
    		ansArr[i]=pref[i]^cumulativeXORResult;	
    	}//rof
        return ansArr;
    }//end method
    
   
}// end class


