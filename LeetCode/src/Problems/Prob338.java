package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob338 {

	public static void test() {

		Solution338 solObj = new Solution338();


		System.out.println("ans: " + Arrays.toString(solObj.countBits(1)));

	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution338 {

	private static int[] bitCountArr = new int[100001];
	private static int populatedInx;
	static {
		bitCountArr[0] = 0;
		bitCountArr[1] = 1;
		bitCountArr[2] = 1;
		bitCountArr[3] = 2;
		bitCountArr[4] = 1;
		bitCountArr[5] = 2;
		bitCountArr[6] = 2;
		bitCountArr[7] = 3;
		bitCountArr[8] = 1;
		populatedInx = 8;
	}// end static

	public int[] countBits(int n) {
		if (n<=populatedInx) {
			return Arrays.copyOf(bitCountArr, n + 1);
		}//fi
		for (int i = populatedInx+1; i <=n; i++) {
			bitCountArr[i]=bitCountArr[i/2]+i%2;
		} // rof//*/
        populatedInx = n;
        int[] ansArr = new int[n+1];
        System.arraycopy(bitCountArr, 0, ansArr, 0, n+1);
		return ansArr;
	}// end method

}// end class

class Solution338_v2 {

	private static int[] bitCountArr = new int[100005];
	private static int populatedInx;
	private static int currBaseRefInx;
	static {
		bitCountArr[0] = 0;
		bitCountArr[1] = 1;
		bitCountArr[2] = 1;
		bitCountArr[3] = 2;
		bitCountArr[4] = 1;
		bitCountArr[5] = 2;
		bitCountArr[6] = 2;
		bitCountArr[7] = 3;
		bitCountArr[8] = 1;
		bitCountArr[16] = 1;
		bitCountArr[32] = 1;
		bitCountArr[64] = 1;
		bitCountArr[128] = 1;
		bitCountArr[256] = 1;
		bitCountArr[512] = 1;
		bitCountArr[1024] = 1;
		bitCountArr[2048] = 1;
		bitCountArr[4096] = 1;
		bitCountArr[8192] = 1;
		bitCountArr[16384] = 1;
		bitCountArr[32768] = 1;
		bitCountArr[65536] = 1;
		populatedInx = 8;
		currBaseRefInx = 8;
		/*
		int currRefInx = 8;
		for (int i = 9; i < 100005; i++) {
			if (bitCountArr[i] == 1) {
				currRefInx = i;
				continue;
			}//fi
			bitCountArr[i]=bitCountArr[currRefInx]+bitCountArr[i-currRefInx];
		} // rof//*/
	}// end static

	public int[] countBits(int n) {
		if (n<=populatedInx) {
			return Arrays.copyOf(bitCountArr, n + 1);
		}//fi
		int tmpRefInx = currBaseRefInx;
		for (int i = populatedInx+1; i <=n; i++) {
			if (bitCountArr[i] == 1) {
				tmpRefInx = i;
				continue;
			} //fi
			bitCountArr[i]=bitCountArr[tmpRefInx]+bitCountArr[i-tmpRefInx];
		} // rof//*/
		currBaseRefInx = tmpRefInx;
        populatedInx = n;
		return Arrays.copyOf(bitCountArr, n + 1);
	}// end method

}// end class
