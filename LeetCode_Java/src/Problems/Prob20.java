package Problems;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob20 {
	
	
	
	static void test() {
		Solution20 solObj = new Solution20();
		String testStr;
		testStr = "()";
		System.out.println("test: " + testStr + " : " + solObj.isValid(testStr));
		
		testStr = "()[]{}";
		System.out.println("test: " + testStr + " : " + solObj.isValid(testStr));
		
		testStr = "(]";
		System.out.println("test: " + testStr + " : " + solObj.isValid(testStr));
		
		testStr = "((((((({{{{[][][]}}}})))))))";
		System.out.println("test: " + testStr + " : " + solObj.isValid(testStr));
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution20 {
	private static byte[] stackArr = new byte[5000];
	private int lastStackElementInx = -1;
	
    public boolean isValid(String s) {
    	for(byte b:s.getBytes()) {
    		switch (b) {
    		case 40:
    			push((byte) 41);
    			break;
    		case 91:
    			push((byte) 93);
    			break;
    		case 123:
    			push((byte) 125);
    			break;
    		case 41, 93, 125:
    			if (b != pop()) {
    				return false;
    			}//fi
    			break;
    		default:
    			return false;
    		}//end switch
    	}//rof
    	if (pop() != -1) {
    		return false;
    	} else {
    		return true;
    	}//fi
    }//end method  
    
    /**
     * Precondition: it is assumed that stack size is not greater than 5000
     * @param element byte type
     */
    private void push(byte element) {
    	stackArr[++lastStackElementInx] = element;
    }//end method
    
    
    /**
     * 
     * @return -1 if stack is empty
     */
    private byte pop() {
    	if (lastStackElementInx < 0) {
    		return -1;
    	} else {
    		return stackArr[lastStackElementInx--];
    	}//fi
    }//end method
}//end class


