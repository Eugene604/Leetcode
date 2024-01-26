package Problems;

import java.util.*;

public class Prob2785 {
	




	public static void test() {
		Solution2785 solObj;
		String str;
		
		
	
	
		solObj = new Solution2785();
		str = "lEetcOde";
		System.out.println(" sol: " + solObj.sortVowels(str) + " str: " + str);
		
		str = "lYmpH";
		System.out.println(" sol: " + solObj.sortVowels(str) + " str: " + str);
		
		str = "peymrzknlxtrutjiybqemquchgvtmmtpjvunvekszrkatctcirxwuqknrycpdtcuadblzkkleduezgspoxhhssoipbmdgrqggpfdsanolzczpaggwxrlaleaqtnzxclmxwjucnujsptnbmmjzzjhypnlsoxjveywsufegzlfnyvkcnfevkshbckfropoydkdlblppllgefagjgpajsplvxknvtlgtjyhmnwxcpjjzcizihycvsnhnnmqohivekitxzuo";
		System.out.println(" sol: " + solObj.sortVowels(str) + "str: " + str);
	//*/
	}//end test
	
	public static void main(String[] args) {
		test();

	}

}


class Solution2785 {
	
	private static int[] vCount = new int[10]; 
	
    public String sortVowels(String s) {
    	//step 1, created or reset necessary data structures
    	Arrays.fill(vCount, 0);
    	List<Integer> vList = new ArrayList<>(10000);
    	StringBuilder sb = new StringBuilder(s);
    	
    	//step 2, populate vowel count and position
    	for (int i=0; i<sb.length(); i++) {
    		switch (sb.charAt(i)) {
    		case 'A':
    			vCount[0]++;
    			vList.add(i);
    			break;
    		case 'E':
    			vCount[1]++;
    			vList.add(i);
    			break;
    		case 'I':
    			vCount[2]++;
    			vList.add(i);
    			break;
    		case 'O':
    			vCount[3]++;
    			vList.add(i);
    			break;
    		case 'U':
    			vCount[4]++;
    			vList.add(i);
    			break;
    		case 'a':
    			vCount[5]++;
    			vList.add(i);
    			break;
    		case 'e':
    			vCount[6]++;
    			vList.add(i);
    			break;
    		case 'i':
    			vCount[7]++;
    			vList.add(i);
    			break;
    		case 'o':
    			vCount[8]++;
    			vList.add(i);
    			break;
    		case 'u':
    			vCount[9]++;
    			vList.add(i);
    			break;
    		}//switch
    	}//rof
    	
    	//step 3, redistribute vowels
    	int vCountInx = 0;
    	char replacementChar = ' ';
    	for (int vInx:vList) {
    		while (vCount[vCountInx]==0) {
    			vCountInx++;
    		}//fi
    		vCount[vCountInx]--;
    		switch (vCountInx) {
    		case 0:
    			replacementChar = 'A';
    			break;
    		case 1:
    			replacementChar = 'E';
    			break;
    		case 2:
    			replacementChar = 'I';
    			break;
    		case 3:
    			replacementChar = 'O';
    			break;
    		case 4:
    			replacementChar = 'U';
    			break;
    		case 5:
    			replacementChar = 'a';
    			break;
    		case 6:
    			replacementChar = 'e';
    			break;
    		case 7:
    			replacementChar = 'i';
    			break;
    		case 8:
    			replacementChar = 'o';
    			break;
    		case 9:
    			replacementChar = 'u';
    			break;
    		}//switch
    		sb.setCharAt(vInx, replacementChar);
    	}//rof
    	
        return sb.toString();
    }//end method
      
}//end class