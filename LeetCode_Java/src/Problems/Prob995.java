package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob995 {


	
	private static void test() {
		
		Solution995 solObj = new Solution995();
		int[] nums;
		int k ;
		
		try {
            ObjectMapper mapper = new ObjectMapper();
            
            /*
          
    			//*/
            
            nums = mapper.readValue("[0,0,0,1,0,1,1,0]", int[].class);
            k = 3;
    		System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("Ans: " + solObj.minKBitFlips(nums, k ));
        } catch (Exception e) {
            e.printStackTrace();
        }

		
		
		
		//*/


	}
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution995 {
	
    public int minKBitFlips(int[] nums, int k) {
    	int cnt = 0;
    	//special case, k == 1
    	if (k==1) {
    		for (int num:nums) {
    			if (num==0) {
    				cnt++;
    			}//fi
    		}//rof
    		return cnt;
    	}//fi
    	
    	Deque<Integer> flipQueue = new ArrayDeque<>();
    	
    	for (int i=0; i<=nums.length-k; i++) {
    		while (flipQueue.size()>0 && flipQueue.peek()<i) {
    			flipQueue.pop();
    		}//end while
    		if (nums[i]==1) {
    			if (flipQueue.size()%2 == 1) {
    				flipQueue.addLast(i+k-1);    
    				cnt++;
    			}//fi
    		} else {
    			if (flipQueue.size()%2 == 0) {
    				flipQueue.addLast(i+k-1);
    				cnt++;
    			}//fi    			
    		}//fi
    	}//rof
    	
    	for (int i=nums.length-k+1; i<nums.length; i++) {
    		while (flipQueue.size()>0 && flipQueue.peek()<i) {
    			flipQueue.pop();
    		}//end while
    		if (nums[i]==1) {
    			if (flipQueue.size()%2 == 1) {
    				return -1;
    			}//fi
    		} else {
    			if (flipQueue.size()%2 == 0) {
    				return -1;
    			}//fi    			
    		}//fi
    	}//rof
    	return cnt;
    }//end method
    
    
}//end class
