package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob787 {


	static void test() {
		
		String flights1 = "[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]";
		String flights2 = "[[0,1,1],[0,2,5],[1,2,1],[2,3,1]]";
        
		Solution787 solObj = new Solution787();
		
		int[][] flight;
		int n, src, dest, k;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            /*
            flight = mapper.readValue(flights1, new TypeReference<int[][]>() {});
            n = 4;
            src = 0;
            dest = 3;
            k = 1;
    		MatrixUtils.displayMatrix(flight);
    		System.out.println();
    		System.out.println("ans: " + solObj.findCheapestPrice(n, flight, src, dest, k));

    		//*/
            
            flight = mapper.readValue(flights2, new TypeReference<int[][]>() {});
            n = 4;
            src = 0;
            dest = 3;
            k = 1; //ans is 6
    		MatrixUtils.displayMatrix(flight);
    		System.out.println(); 
    		System.out.println("ans: " + solObj.findCheapestPrice(n, flight, src, dest, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution787 {
	//inx: airport id, value: least fare from src
	static int[] leastFareArr = new int[100];
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    	//step 1, set up data structure for breadth first search
    	Arrays.fill(leastFareArr,0,n,Integer.MAX_VALUE);
    	leastFareArr[src] = 0;    	
    	int[][] priceMat = new int[n][n];
    	for (int[] flight:flights) {
    		priceMat[flight[0]][flight[1]] = flight[2]; 
    	}//rof
    	//MatrixUtils.displayMatrix(priceMat);

    	//step 2, use bfs to find cheapest fare
    	Deque<int[]> airportQueue = new ArrayDeque<>();//int[2], 1st ele is airport id, 2nd ele is the cost to reach this airport
    	airportQueue.offerLast(new int[]{src, 0});
    	int stops = 0;
    	int numOfAirports;
    	int[] currAirportFareArr;
    	int nextAirportTotalFare;
    	while (stops <= k && (numOfAirports=airportQueue.size()) > 0) {    		
    		for (;numOfAirports>0; numOfAirports--) {
    			currAirportFareArr = airportQueue.pollFirst();
    			for (int nextAirport=0; nextAirport<n; nextAirport++) {
    				if (priceMat[currAirportFareArr[0]][nextAirport]>0) {
    					nextAirportTotalFare = currAirportFareArr[1] + priceMat[currAirportFareArr[0]][nextAirport];
    					if (nextAirportTotalFare <  leastFareArr[nextAirport]) {
    						leastFareArr[nextAirport] = nextAirportTotalFare;
    						airportQueue.offerLast(new int[] {nextAirport, nextAirportTotalFare});
    					}//fi
    				}//fi
    				
    			}//fi
    		}//rof
    		stops++;
    	}//end while
    	
    
        return (leastFareArr[dst]==Integer.MAX_VALUE)? -1 : leastFareArr[dst];
    }//end method
}// end class



