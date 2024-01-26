package Problems;


public class Prob1716 {
	
	static void test() {
		System.out.println("test starts");
		Solution1716 solObj = new Solution1716();
		int n;
		
		n=4;
		System.out.println("n: " + n + " : " + solObj.totalMoney(n));
		
		n=10;
		System.out.println("n: " + n + " : " + solObj.totalMoney(n));

		
	}//end method
	
	
	public static void main(String args[]) {
		test();
	}
	
}//end problem class

class Solution1716	 {
	private static final int[] totalMoneyCache;
	private static final int MAX_N = 1000;
	static {
		totalMoneyCache = new int[MAX_N+1];
		totalMoneyCache[1] = 1;
		int baseDeposit = 1, dailyDeposit = 1;
		for (int i = 2; i<=MAX_N; i++) {
			if (i%7==1) {
				baseDeposit++;
				dailyDeposit = baseDeposit;
			} else {
				dailyDeposit++;
			}//fi
			totalMoneyCache[i] = totalMoneyCache[i-1]+dailyDeposit;			
		}//rof
	}//end static
	
    public int totalMoney(int n) {
        return totalMoneyCache[n];
    }//end method
      
}//end class


