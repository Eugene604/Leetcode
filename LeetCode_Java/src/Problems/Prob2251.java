package Problems;

import java.util.*;

public class Prob2251 {

	
	static int[][] flowers1 = {{1,6},{3,7},{9,12},{4,13}};
	static int[][] flowers2 = {{1,10},{3,3}};
	static int[][] flowers3 = {{5,12},{5,13},{4,5},{3,5},{5,5},{1,4},{2,4},{3,4},{4,4},{2,4}};
	
	static int[] ppl1 = {2,3,7,11};
	static int[] ppl2 = {3,3,2};
	static int[] ppl3 = {5};

	
	static void test() {
		Solution2251 solObj = new Solution2251();
		int[][] flowers;
		int[] people;
		
		/*
		
		flowers = flowers1; 
		people = ppl1; // [1,2,2,2]
		System.out.println("orignal arr: " + Arrays.deepToString(flowers));
		System.out.println("sol: " + Arrays.toString(solObj.fullBloomFlowers(flowers,people)));
	

		flowers = flowers2; 
		people = ppl2;//[2,2,1]
		System.out.println("orignal arr: " + Arrays.deepToString(flowers));
		System.out.println("sol: " + Arrays.toString(solObj.fullBloomFlowers(flowers,people)));
	//*/
		
		flowers = flowers3; 
		people = ppl3;
		System.out.println("orignal arr: " + Arrays.deepToString(flowers));
		System.out.println("sol: " + Arrays.toString(solObj.fullBloomFlowers(flowers,people)));
		
	}
	
	public static void main(String[] args) {
		test();

	}

}



class Solution2251 {
	
	/*
	 * Key - time window, Value - number of full bloom flowers
	 */
	private Map<Integer, Integer> timeFlowerCache;
	int[] sortedBloomTimes; 
	int[] sortedFallTimes;
	
	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		

		//step 1: build required data structures
		sortedBloomTimes = new int[flowers.length]; 
		sortedFallTimes = new int[flowers.length]; 
		for (int i = 0; i < flowers.length; i++) {
			sortedBloomTimes[i] = flowers[i][0];
			sortedFallTimes[i] = flowers[i][1];
		}//rof
		Arrays.parallelSort(sortedBloomTimes);	
		Arrays.parallelSort(sortedFallTimes);
		timeFlowerCache = new HashMap<>();
		//System.out.println(Arrays.toString(sortedBloomTimes));
		//System.out.println(Arrays.toString(sortedFallTimes));
		
		//step 2: iterate through each person
		int[] solArr = new int[people.length];
		for (int pID = 0; pID < people.length; pID++) {
			solArr[pID] = getFBFlsNum(people[pID]);
		}//rof
		return solArr;
    }//end method
	
	/**
	 * precondition: 
	 * - required data structures are ready: timeFlowerCache , sortedBloomTimes, sortedFallTimes
	 * 
	 * @param timeWnd int
	 * @return int, number of full bloom flowers
	 */
	private int getFBFlsNum(int timeWnd) {
		Integer cachedNumOfFls;
		if ((cachedNumOfFls = timeFlowerCache.get(timeWnd))!=null) {
			return cachedNumOfFls;
		}//fi
		
		int numOfFls, numOfBloomedBeforeOrAtTimeWnd, numOfFallenBeforeTimeWnd;
	
		numOfBloomedBeforeOrAtTimeWnd = Arrays.binarySearch(sortedBloomTimes, timeWnd);
		if (numOfBloomedBeforeOrAtTimeWnd<0) {
			numOfBloomedBeforeOrAtTimeWnd = -(numOfBloomedBeforeOrAtTimeWnd+1);
		} else {
			while (++numOfBloomedBeforeOrAtTimeWnd < sortedBloomTimes.length && sortedBloomTimes[numOfBloomedBeforeOrAtTimeWnd] == timeWnd) {}
		}//fi
		
		numOfFallenBeforeTimeWnd = Arrays.binarySearch(sortedFallTimes, timeWnd);
		if (numOfFallenBeforeTimeWnd<0) {
			numOfFallenBeforeTimeWnd = -(numOfFallenBeforeTimeWnd+1);
		} else {
			while (numOfFallenBeforeTimeWnd > 0 && sortedFallTimes[numOfFallenBeforeTimeWnd-1] == timeWnd) {
				numOfFallenBeforeTimeWnd--;
			}//end while
		}//fi
		
		numOfFls = numOfBloomedBeforeOrAtTimeWnd - numOfFallenBeforeTimeWnd;
		timeFlowerCache.put(timeWnd, numOfFls);
		return numOfFls;		
	}//fi
}//end class



class Solution2251_v2 {
	
	/*
	 * Key - time window, Value - number of full bloom flowers
	 */
	private Map<Integer, Integer> timeFlowerCache;
	int[][] sortedFlowers; 
	
	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		int[] solArr = new int[people.length];

		//step 1: build required data structures				
		sortedFlowers = flowers;
		Arrays.parallelSort(sortedFlowers,(a, b) -> Integer.compare(a[0], b[0]));	
		timeFlowerCache = new HashMap<>();
		
		//step 2: iterate through each person

		for (int pID = 0; pID < people.length; pID++) {
			solArr[pID] = getFBFlsNum(people[pID]);
		}//rof
		return solArr;
    }//end method
	
	/**
	 * precondition: 
	 * - required data structures are ready: timeFlowerCache , sortedFlowers
	 * 
	 * @param timeWnd int
	 * @return int, number of full bloom flowers
	 */
	private int getFBFlsNum(int timeWnd) {
		Integer cachedNumOfFls;
		if ((cachedNumOfFls = timeFlowerCache.get(timeWnd))!=null) {
			return cachedNumOfFls;
		}//fi
		
		int numOfFls = 0;

		for (int[] currFlower:sortedFlowers) {
			//achedNumOfFls..out.println("checking: " + Arrays.toString(currFlower));
			if (currFlower[0] > timeWnd) {
				break;
			} else if (currFlower[0] == timeWnd) {
				numOfFls++;
			} else if (currFlower[1] >= timeWnd) {
				numOfFls++;
			}//fi
		}//end while
		timeFlowerCache.put(timeWnd, numOfFls);
		return numOfFls;		
	}//fi
}//end class