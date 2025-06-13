package Problems;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1652 {


	static void test() {
		Solution1652 solObj = new Solution1652();
		int[] code;
		int k;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
   
            code = mapper.readValue("[5,7,1,4]", new TypeReference<int[]>() {});
            k = 3;
            
            System.out.println(Arrays.toString(code));
    		System.out.println("ans: " + Arrays.toString(solObj.decrypt(code, k)));
    		//*/
    
    		/*
         
        	//*/
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution1652 {
	
    public int[] decrypt(int[] code, int k) {
    	int arrLen = code.length;
    	int[] expandedCode;
    	int[] deCodedArr = new int[arrLen];
    	
    	//step 1: handle special case where k=0
    	if (k==0) {
    		return deCodedArr;
    	}//fi
    	
    	//step 2: create expanded code
    	expandedCode = new int[arrLen*3];
    	for (int i=0; i<arrLen; i++)  {
    		expandedCode[i] = code[i];
    		expandedCode[i+arrLen] = code[i];
    		expandedCode[i+arrLen*2] = code[i];
    	}//rof
    	//System.out.println(Arrays.toString(expandedCode));
    	
    	//step 2: produce decrypt code arr
    	int leftInx, rightInx;
    	int sum = 0;
    	if (k>0) {
    		leftInx = arrLen+1;
    		rightInx = arrLen + k;
    	} else {
    		leftInx = arrLen + k;
    		rightInx = arrLen - 1;
    	}//fi
    	for (int i=leftInx; i<=rightInx; i++) {
    		sum += expandedCode[i];
    	}//rof
    	deCodedArr[0] = sum;
    	for (int i=1; i<arrLen; i++)  {
    		sum = sum - expandedCode[leftInx] + expandedCode[rightInx+1];
    		deCodedArr[i] = sum;
    		leftInx++;
    		rightInx++;
    	}//rof
        return deCodedArr;
    }	
	
}//end class
