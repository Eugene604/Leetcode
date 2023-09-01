package Problems;

import java.util.*;

public class Prob2806 {

	
	
	
	static void test() {
		Solution2806 solObj = new Solution2806();
		int purchaseAmt;
		
		purchaseAmt = 15;
		System.out.println("purchaseAmt: " + purchaseAmt + " balance: " + solObj.accountBalanceAfterPurchase(purchaseAmt));
		
		
	}
	
	public static void main(String[] args) {
		test();

	}

}


class Solution2806 {
	private static final int INITIAL_BALANCE = 100;
    public int accountBalanceAfterPurchase(int purchaseAmount) {
    	int quotient = purchaseAmount / 10;
    	int remainder = purchaseAmount%10;
    	int lastPayment;
    	if (remainder >= 5) {
    		lastPayment = 10;
    	} else {
    		lastPayment = 0;
    	}//fi
    	System.out.println("remainder: " + remainder);
    	return INITIAL_BALANCE - (quotient*10 + lastPayment);
    }//end method	
}//end class