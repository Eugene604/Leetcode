package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob2147 {
	

	
	public static void test() {
		String corridor1 = "SSPPSPS";
		String corridor2 = "PPSPSP";
		String corridor3 = "PPSPSSSPSPPSSSSSSPSSSPPPPSPSSPSPPPSPSSSSPPSSSPPSSPPPSPSPSSPSPSPSSSPPSSPPPPPPSPSPSSPPSPPPSPPPSPSSSPPS";
		String corridor4 = "SPPPPPPPSPPPSPSSSPPPPPPPPPPPPPPPPPSPPPPPPPPPPPPPPPPSPPPPPSPSPPPPPPSPSPPSPSPPPSPSPPSSPPPPPSPPSSPP";
		Solution2147 sol = new Solution2147();		
		String corridor;
		
		/*
		corridor = corridor1;
		System.out.println("corridor: " + corridor);
		System.out.println("ans: " + sol.numberOfWays(corridor));
		
		corridor = corridor2;
		System.out.println("corridor: " + corridor);
		System.out.println("ans: " + sol.numberOfWays(corridor));
		//*/
		
		corridor = corridor4;//0
		System.out.println("corridor: " + corridor);
		System.out.println("ans: " + sol.numberOfWays(corridor));
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution2147 {

	private static final long MOD_CONST = 1000000007;
	
	public int numberOfWays(String corridor) {
		long numOfWays = 0;
		int seatCount = 0, plantCount = 0;
		int i;
		for (i=0; i<corridor.length(); i++) {
			if (corridor.charAt(i)=='S') {
				if ((++seatCount)==2) {
					numOfWays = 1;					
					break;
				}//fi
			}//fi
		}//rof
		
		for (i=i+1; i<corridor.length(); i++) {
			if (corridor.charAt(i)=='S') {
				if (seatCount == 2) {
					seatCount = 1;
					plantCount++;
					numOfWays = (numOfWays*plantCount) % MOD_CONST;
					plantCount = 0;
				} else {
					seatCount++;
					plantCount = 0;
				}//fi

			} else {
				plantCount++;				
			}//fi
		}//rof
		if (seatCount != 2) {
			return 0;
		}//fi
		return (int)numOfWays;
	}//method
}//end class
