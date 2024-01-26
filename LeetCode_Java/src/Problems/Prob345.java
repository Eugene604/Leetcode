package Problems;

import java.util.*;

public class Prob345 {
	




	public static void test() {
		Solution345 solObj;
		String str;
		
		
	
	
		solObj = new Solution345();
		str = "hello";
		System.out.println(" sol: " + solObj.reverseVowels(str) + " str: " + str);
		
		str = "leetcode";
		System.out.println(" sol: " + solObj.reverseVowels(str) + " str: " + str);
		
		str = "peymrzknlxtrutjiybqemquchgvtmmtpjvunvekszrkatctcirxwuqknrycpdtcuadblzkkleduezgspoxhhssoipbmdgrqggpfdsanolzczpaggwxrlaleaqtnzxclmxwjucnujsptnbmmjzzjhypnlsoxjveywsufegzlfnyvkcnfevkshbckfropoydkdlblppllgefagjgpajsplvxknvtlgtjyhmnwxcpjjzcizihycvsnhnnmqohivekitxzuo";
		System.out.println(" sol: " + solObj.reverseVowels(str) + "str: " + str);
	//*/
	}//end test
	
	public static void main(String[] args) {
		test();

	}

}


class Solution345 {
	
    public String reverseVowels(String s) {

    	List<Integer> vList = new ArrayList<>(64);
    	StringBuilder sb = new StringBuilder(s);
    	
    	//step 2, populate vowel position
    	for (int i=0; i<sb.length(); i++) {
    		switch (sb.charAt(i)) {
    		case 'A':
    		case 'E':
    		case 'I':
    		case 'O':
    		case 'U':
    		case 'a':
    		case 'e':
    		case 'i':
    		case 'o':
    		case 'u':
    			vList.add(i);
    		}//switch
    	}//rof
    	
    	//step 3, redistribute vowels
    	int leftInx = 0;
    	int rightInx = vList.size()-1;
    	char tmpChar;
    	while (leftInx<rightInx) {
    		tmpChar = sb.charAt(vList.get(leftInx));
    		sb.setCharAt(vList.get(leftInx), sb.charAt(vList.get(rightInx)));
    		sb.setCharAt(vList.get(rightInx), tmpChar);
    		leftInx++;
    		rightInx--;
    	}//end while
    	
    	
        return sb.toString();
    }//end method
      
}//end class