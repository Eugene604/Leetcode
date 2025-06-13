package Problems;

import java.util.*;

public class Prob857 {
	static int[] nums0 = {10,20,5};
	static int[] nums1 = {70,50,30};
	static int[] nums2 = {3,5};
	
	static int[] nums3 = {};
	static int[] nums4 = {2,3,4};
	
	static int[] nums5 = {0, 1, 2, 3, 3, 3, 3, 8};
	static int[] nums6 = {0, 3, 5, 17, 18, 22, 33};	
	
	static int[] nums7 = {6};
	static int[] nums8 = {};

	// index .............0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16, 17, 18, 19, 20
	static int[] nums9 = {1, 3, 4, 5, 5, 6, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 12, 15, 16};
	
	static int[] nums10 = {-2, -1};
	
	static int[] nums11 = {0, 9, 11, 15};
	
	static int[] nums12 = {0, 6, 7};
	
	static int[] nums13 = {1,3};
	static int[] nums14 = {2,7};
	
	static int[] nums15 = {10000};
	static int[] nums16 = {10001};
	
	static int[] nums17 = {3};
	static int[] nums18 = {1,2,4};
	
	private static void test() {
		
		Solution857 sol = new Solution857();
		CorrectSolution857 correctSol = new CorrectSolution857();

		int[] quality, wage;
		int k;
		
		quality = nums0;
		wage = nums1;
		k = 2;
		System.out.println("ans: " +  sol.mincostToHireWorkers(quality, wage, k));
		System.out.println("correct ans: " +  correctSol.mincostToHireWorkers(quality, wage, k));

	}
	
	public static void main(String[] args) {

		test();
	}
}

class Solution857 {
	
	class Worker implements Comparable<Worker>{
		
				
		public final int quality;
		public int wage;
		public double wagePerQuality;
		
		/**
		 * 
		 * @param quality - int
		 * @param wage - int
		 */
		public Worker(int quality, int wage) {
			this.quality = quality;
			this.wage = wage;
			this.wagePerQuality = (double)wage/quality;
		}//end constructor

	
		/**
		 * Compare based on quality in descending order
		 * @param other - Worker
		 * @return
		 */
	    public int compareToByQuality(Worker other) {
	    	return Integer.compare(other.quality, this.quality); // Compare in descending order
	    }

	    
	    /**
	     * Compare based on wagePerQuality in ascending order
	     * @param other - Worker
	     * @return
	     */
	    public int compareToByWagePerQuality(Worker other) {
	        return Double.compare(this.wagePerQuality, other.wagePerQuality);
	    }

	    @Override
	    public int compareTo(Worker other) {
	        // By default, compare based on wagePerQuality
	        return compareToByWagePerQuality(other);
	    }

	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append('[');
	        sb.append(quality);
	        sb.append(',');
	        sb.append(wagePerQuality);
	        sb.append("] ");
	        return sb.toString();
	    }//end method
	}//end class
	
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    	PriorityQueue<Worker> workersByWagePerQuality = new PriorityQueue<>(Worker::compareToByWagePerQuality);
    	PriorityQueue<Worker> workersByQuality = new PriorityQueue<>(Worker::compareToByQuality);
    	double totalWages, globalMinTotalWages;
    	double currMaxWagePerQuality;
    	Worker tmpWorker;

    	
    	//step 1, build list workers and then sort them by wage per quality
    	for (int i=0; i<quality.length; i++) {
    		workersByWagePerQuality.offer(new Worker(quality[i], wage[i]));
    	}//rof
    	
    	
    	//step 2, extract first k workers and calculate total wages needed
    	totalWages = 0;
    	int totalQuality = 0;
    	do {    		
    		tmpWorker = workersByWagePerQuality.poll();
    		totalQuality += tmpWorker.quality;    	
    		workersByQuality.offer(tmpWorker);
    		k--;
    		
    		//System.out.println("tmpWorker: " + tmpWorker);
    	} while (k>0);//end do while
    	currMaxWagePerQuality = tmpWorker.wagePerQuality;
    	totalWages = totalQuality*currMaxWagePerQuality;
    	globalMinTotalWages = totalWages;
    	//System.out.println("globalMinTotalWages: " + globalMinTotalWages);
    	//step 3, find min wage by keep dropping out worker with highest quality and add next lowest w/q worker
    	while (workersByWagePerQuality.size()>0) {
    		tmpWorker = workersByWagePerQuality.poll();
    		if (tmpWorker.quality >= workersByQuality.peek().quality) {
    			continue;
    		}//fi
    		totalQuality = totalQuality - workersByQuality.poll().quality + tmpWorker.quality;
    		workersByQuality.offer(tmpWorker);
    		currMaxWagePerQuality = tmpWorker.wagePerQuality;
    		totalWages = totalQuality*currMaxWagePerQuality;
    		globalMinTotalWages = Math.min(totalWages, globalMinTotalWages);
    	}//end while
        return globalMinTotalWages;
    }//end method
}//end class


class CorrectSolution857 {

    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}
