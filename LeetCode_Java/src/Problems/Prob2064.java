package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;



public class Prob2064 {


	static void test() {
		
		Solution2064 solObj = new Solution2064();
		int[] quantities;
		int n;
		
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
    		

            quantities = mapper.readValue("[10,10,15]", new TypeReference<int[]>() {});
            n = 7;
            Arrays.sort(quantities);
            System.out.println(Arrays.toString(quantities));
    		System.out.println("ans: " + solObj.minimizedMaximum(n, quantities));

    		/*
            
                        quantities = mapper.readValue("[477,48731,581,898,368,313,15915,219,340,50012,42545,16310,134,19,347,349,261,407,288,517,95915,26793,43946,494,76984,63,435,57078,316,58685,53900,564,36,339,20,868,888,56646,858,120,482,291,793,347,878,26948,939,439,694,772,79444,359,304,503,745,55,70130,782,464,236,777,252,530,511,22635,13,36102,36,221,513,96,82354,710,19782,13694,80334,791,70513,317,873,395,186,89355,20,240,130,34347,254,11540,65222,454]", new TypeReference<int[]>() {});
            n = 99992;
            Arrays.sort(quantities);
            System.out.println(Arrays.toString(quantities));
    		System.out.println("ans: " + solObj.minimizedMaximum(n, quantities));
 		
            quantities = mapper.readValue("[18, 21, 22, 24, 26, 26]", new TypeReference<int[]>() {});
            n = 15;
            Arrays.sort(quantities);
            System.out.println(Arrays.toString(quantities));
    		System.out.println("ans: " + solObj.minimizedMaximum(n, quantities));
         
        	//*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}


class Solution2064 {
    public int minimizedMaximum(int n, int[] quantities) {
  
    	int storeCnt;
    	int lowerX = 1;
    	int higherX = 100000;
    	int midX = -1;
    	while (lowerX < higherX) {
    		midX = (lowerX + higherX)/2;
    		storeCnt = getReqStores(quantities, midX);
    		if (storeCnt > n) {
    			lowerX = midX+1;    			    			
    		} else if (storeCnt <= n) {
    			higherX = midX;
    		}//fi

    		//System.out.println("storeCnt: " + storeCnt + " lowerX: " + lowerX + " higherX:" + higherX);    		    				
    	}//end while  	
    	return lowerX; 
    }
    
    /**
     * Calculates the required number of stores to distribute the given quantities of products
     * such that no store holds more than the specified maximum quantity.
     *
     * @param quantityArr - int[], array of product quantities to be distributed
     * @param maxX - int, the maximum quantity a single store can hold
     * @return the number of stores required to distribute the products under the given constraint
     */
    private int getReqStores(int[] quantityArr, int maxX) {
    	int storeCnt = 0;
    	for (int quantity:quantityArr) {
    		storeCnt += (quantity + maxX - 1)/maxX;
    	}//rof
    	return storeCnt;
    }//fi
 
}// end class


class Solution2064_v2 {
    public int minimizedMaximum(int n, int[] quantities) {
    	PriorityQueue<Integer> minProdQueue;
    	int prodTypeCnt = quantities.length;
    	int totalProdCnt, singleProdCnt;
    	int numOfStores = n;
    	int baseX, maxX;
    	
    	
    	//step 1: process edge cases
    	if (prodTypeCnt == 1) {//case 1: only one product type
    		return (int)Math.ceil((double)quantities[0]/numOfStores);
    	} else if (prodTypeCnt == numOfStores) {//case 2, prodTypeCnt is eq to num of stores 
    		int maxQ = 0;
        	for (int quantity:quantities) {
        		maxQ = Math.max(maxQ, quantity);
        	}//rof
    		return maxQ;
    	}//fi

    	//step 2: create min queue and also find total quantity
    	minProdQueue = new PriorityQueue<>();
    	totalProdCnt = 0;
    	for (int quantity:quantities) {
    		totalProdCnt += quantity;
    		minProdQueue.offer(quantity);
    	}//rof
    	
    	//step 3: process those that are lower or equal to baseX
    	baseX = (int)Math.ceil((double)totalProdCnt/numOfStores);
    	while (minProdQueue.peek() <= baseX) {
    		singleProdCnt = minProdQueue.poll();
    		//System.out.println("case 3, singleProdCnt: " + singleProdCnt + " storeUsed: " + 1 + " baseX:" + baseX + " totalProdCnt:" + totalProdCnt);
    		totalProdCnt -= singleProdCnt;
    		numOfStores--;
    		baseX = (int)Math.ceil((double)totalProdCnt/numOfStores);
    	}//end while
    	
    	//step 4: create new quantity array
    	int[] filteredQuantityArr = new int[minProdQueue.size()];
    	for (int i=0; i<filteredQuantityArr.length; i++) {
    		filteredQuantityArr[i] = minProdQueue.poll();
    	}//rof
    	
    	//System.out.println("numOfStores new: " + numOfStores);
    	//System.out.println(Arrays.toString(filteredQuantityArr));
    	
    	//step 5: 
    	int storeCnt;
    	/*
    	for (; ;baseX++) {
    		storeCnt = getReqStores(filteredQuantityArr, baseX);
    		//System.out.println("storeCnt: " + storeCnt);
    		if (storeCnt <= numOfStores) {
    			return baseX;
    		}//fi
    		
    	}//*/
    	
    	int lowerX = baseX;
    	int higherX = filteredQuantityArr[filteredQuantityArr.length-1];
    	int midX = -1;
    	while (lowerX < higherX) {
    		midX = (lowerX + higherX)/2;
    		storeCnt = getReqStores(filteredQuantityArr, midX);
    		if (storeCnt > numOfStores) {
    			lowerX = midX+1;    			    			
    		} else if (storeCnt <= numOfStores) {
    			higherX = midX;
    		}//fi

    		//System.out.println("storeCnt: " + storeCnt + " lowerX: " + lowerX + " higherX:" + higherX);    		    				
    	}//end while  	
    	return lowerX; 
    }
    
    /**
     * Calculates the required number of stores to distribute the given quantities of products
     * such that no store holds more than the specified maximum quantity.
     *
     * @param quantityArr - int[], array of product quantities to be distributed
     * @param maxX - int, the maximum quantity a single store can hold
     * @return the number of stores required to distribute the products under the given constraint
     */
    private int getReqStores(int[] quantityArr, int maxX) {
    	int storeCnt = 0;
    	for (int quantity:quantityArr) {
    		storeCnt += (quantity + maxX - 1)/maxX;
    	}//rof
    	return storeCnt;
    }//fi
 
}// end class
