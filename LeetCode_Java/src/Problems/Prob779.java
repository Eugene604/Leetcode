package Problems;

import java.util.*;


public class Prob779 {

	public static void test() {
		Solution779 solObj = new Solution779();
		
		int n, k;
		

		n = 1;
		k = 1; //0
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kthGrammar(n,k));
		
		n = 2;
		k = 1; //0
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kthGrammar(n,k));
		
		n = 2;
		k = 2; //1
		System.out.println("n:" + n + " k:" + k + " ,sol: " + solObj.kthGrammar(n,k));
	}// end method

	private static void test2() {


	}// end method

	public static void main(String[] args) {
		test();
		// test2();
	}// end method

}

class Solution779 {
	private static Map<Integer, Integer>[] symbolCache;
	static {
		symbolCache = new HashMap[31];
		for (int i=1;i<=30;i++) {
			symbolCache[i] = new HashMap<>();
		}//rof
		symbolCache[1].put(1, 0);
		symbolCache[2].put(1, 0);
		symbolCache[2].put(2, 1);
	}//end static
	
    public int kthGrammar(int n, int k) {
    	//System.out.println("checking " + n + " : " + k);
    	Integer symbol;
    	if ((symbol = symbolCache[n].get(k))!= null) {
    		return symbol;
    	}//fi
    	
    	
    	boolean isKEven = k%2==0;
    	int parentK = isKEven? k/2 : (k+1)/2;
    	int parentSymbol = kthGrammar(n-1, parentK);
    	int currSymbol = isKEven? (1-parentSymbol) : parentSymbol;
    	symbolCache[n].put(k, currSymbol);
    	if (isKEven) {
    		symbolCache[n].put(k, currSymbol);
    		symbolCache[n].put(k-1, parentSymbol);
    	} else {
    		symbolCache[n].put(k, currSymbol);
    		symbolCache[n].put(k+1, 1-parentSymbol);
    	}//fi
    	
    	
        return currSymbol;
    }//end method
	
}// end class

