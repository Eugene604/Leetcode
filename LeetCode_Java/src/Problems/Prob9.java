package Problems;



public class Prob9 {
	public static void test() {

		Solution9 sol = new Solution9();
		int testInt;
		
		testInt = 1234;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));
		testInt = -1;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));
		testInt = 5;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));
		testInt = 0;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));	
		testInt = 550;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));		
		testInt = 555;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));		
		testInt = 154737451;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));		
		testInt = 424232;
		System.out.println(testInt + " is isPalindrome? " + sol.isPalindrome(testInt));		
	}//end method
	
	public static void main(String[] args) {
		test();
	}
}

class Solution9 {
	
    public boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	} else if (x < 10) {
    		return true;
    	} else if (x % 10 == 0) {
    		return false;
    	}//fi
    	
    	int remainder = x;
    	int mirrorVal = 0;

    	while (remainder > 0) {  		
    		mirrorVal = mirrorVal*10 +  remainder % 10;
    		remainder = remainder/10;
    	}//end while
    	
    	//System.out.println(x + " : " + mirrorVal);
    	
        return x == mirrorVal;
    }//end method
}//end class