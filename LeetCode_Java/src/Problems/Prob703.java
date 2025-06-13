package Problems;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob703 {
	

	static void test() {
		
		
		int[] nums;
		int k;
		int[] argArr;
		KthLargest solObj;
		
		try {
            ObjectMapper mapper = new ObjectMapper();

            nums = mapper.readValue("[4, 2]", int[].class);
            k = 3;
            solObj = new KthLargest(k, nums);
            argArr = mapper.readValue("[1,1,-1,3,4]", int[].class);
            
            for (int arg:argArr) {
            	System.out.println(solObj.add(arg));
            }//rof */
            
          
            /*
            nums = mapper.readValue("[4, 5, 8, 2]", int[].class);
            k = 3;
            solObj = new KthLargest(k, nums);
            argArr = mapper.readValue("[3,5,10,9,4]", int[].class);
            
            for (int arg:argArr) {
            	System.out.println(solObj.add(arg));
            }//rof */

           
        } catch (Exception e) {
            e.printStackTrace();
        }



	}
	
	static void test1() {
		
		
		int[] pArr = {1,2,4};
		int val = 2;
		int insertionInx = Arrays.binarySearch(pArr, val);
		if (insertionInx < 0) {
			insertionInx = -(insertionInx+1);
		}//fi
		
		System.out.println("insertionInx: " + insertionInx);

		if (insertionInx < 0) {
			insertionInx = -(insertionInx+1);
		}//fi
		
		insertionInx--;
		
		System.arraycopy(pArr, 1, pArr, 0, insertionInx);
		pArr[insertionInx] = val;
		
		System.out.println(Arrays.toString(pArr));


	}

	public static void main(String args[]) {
		//test();
		test1();
	}

}

class KthLargest {

	int[] pArr;
	
    public KthLargest(int k, int[] nums) {
        pArr = new int[k];
        
        int i;
        if (nums.length < k) {
            for (i=0; i<nums.length; i++) {
            	pArr[i] = nums[i];
            }//rof
            pArr[i] = Integer.MIN_VALUE;           
        } else {
            for (i=0; i<k; i++) {
            	pArr[i] = nums[i];
            }//rof
        }

        
        Arrays.sort(pArr);
        
        for (i=k; i<nums.length; i++) {
        	add(nums[i]);
        }//rof
        
       //System.out.println(Arrays.toString(pArr));
    }//end constructor
    
    public int add(int val) {
    	if (val <= pArr[0]) {
    		//do nothing
    	} else {
    		int insertionInx = Arrays.binarySearch(pArr, val);

    		if (insertionInx < 0) {
    			insertionInx = -(insertionInx+1);
    		}//fi
    		
    		insertionInx--;
    		
    		System.arraycopy(pArr, 1, pArr, 0, insertionInx);
    		pArr[insertionInx] = val;

    		
    	}//fi
    	//System.out.println("added: " + val + " pArr: " + Arrays.toString(pArr));
    	return pArr[0];
    }//end method
}//end class

