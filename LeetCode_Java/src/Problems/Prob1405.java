package Problems;

import java.util.*;

public class Prob1405 {


	static void test() {
		

		Solution1405 solObj = new Solution1405();
		
		int a,b,c;
		
		a = 2;
		b = 2;
		c = 2;
    	
		System.out.println("ans: " + solObj.longestDiverseString(a,b,c));
    	
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution1405 {
	
    public String longestDiverseString(int a, int b, int c) {
    	
    	PriorityQueue<int[]> charQueue = new PriorityQueue<>((arr1,arr2)->arr2[0]-arr1[0]);
    	
    	//step 1: push a b c into priority queue
    	if (a>0) {
    		charQueue.offer(new int[] {a,'a'});//[count, char value in int]
    	}//fi
    	if (b>0) {
    		charQueue.offer(new int[] {b,'b'});
    	}//fi
    	if (c>0) {
    		charQueue.offer(new int[] {c,'c'});
    	}//fi
    	
    	//special cases:
    	if (charQueue.size() == 0) {
    		return "";
    	} else if (charQueue.size() == 1) {
    		StringBuilder sb = new StringBuilder(); 
    		processSingleCharInfo(charQueue.peek(), sb);
    		return sb.toString();
    	} else if (charQueue.size() == 2) {
    		StringBuilder sb = new StringBuilder(); 
    		processTwoCharInfo(charQueue.poll(), charQueue.poll(),  sb);
    		return sb.toString();
    	}//fi
    	
    	
    	//step 2: cycle through greatest char counts
    	StringBuilder sb = new StringBuilder(); 
    	int[] largestCharInfo;
    	int[] secLargestCharInfo;
    	int[] prevCharInfo = null;

    	
    	while (charQueue.size()>2) {
    		largestCharInfo = charQueue.poll();
    		secLargestCharInfo = charQueue.poll();
    		
    		if (prevCharInfo == largestCharInfo) {
        		sb.append((char)secLargestCharInfo[1]);
        		secLargestCharInfo[0]--;
    		}//fi
    		 		
    		if (largestCharInfo[0] > secLargestCharInfo[0] + 1) {
    			sb.append((char)largestCharInfo[1]);
    			sb.append((char)largestCharInfo[1]);
    			largestCharInfo[0] -= 2;
    		} else {
    			sb.append((char)largestCharInfo[1]);
    			largestCharInfo[0]--;
    		}//fi
    		
    		if (prevCharInfo != largestCharInfo) {
        		sb.append((char)secLargestCharInfo[1]);
        		secLargestCharInfo[0]--;
        		prevCharInfo = secLargestCharInfo;
    		}//fi
    		
    		charQueue.offer(largestCharInfo);
    		
    		if (secLargestCharInfo[0] > 0) {
    			charQueue.offer(secLargestCharInfo);
    		}//fi
    		
    		//System.out.println("q size: " + charQueue.size());
    	}//end while
    	
    	//two char left
		processTwoCharInfo(charQueue.poll(), charQueue.poll(),  sb);

    	
    	return sb.toString();
    }//end method

    /**
     * preconditions: 
     * - largerCharInfo[0] must be >= smallerCharInfo[0]
     * - sb is initialized
     * 
     * @param charInfo - int[]
     * @param sb - StringBuilder
     */
    private void processTwoCharInfo(int[] largerCharInfo, int[] smallerCharInfo, StringBuilder sb) {
    	while (smallerCharInfo[0]>0) {
			if (largerCharInfo[0] > smallerCharInfo[0] + 1) {
				sb.append((char)largerCharInfo[1]);
				sb.append((char)largerCharInfo[1]);
				largerCharInfo[0] -= 2;
			} else {
				sb.append((char)largerCharInfo[1]);
				largerCharInfo[0]--;
			}//fi
			
			sb.append((char)smallerCharInfo[1]);
			smallerCharInfo[0]--;
    	}//end method
    	
    	//one char left
    	processSingleCharInfo(largerCharInfo, sb);
    }//end method
    
    /**
     * preconditions: 
     * 
     * - sb is initialized
     * 
     * @param charInfo - int[]
     * @param sb - StringBuilder
     */
    private void processSingleCharInfo(int[] charInfo, StringBuilder sb) {
    	//System.out.println("processSingleCharInfo " + Arrays.toString(charInfo));
		if (charInfo[0] > 1) {
			sb.append((char)charInfo[1]);
			sb.append((char)charInfo[1]);
		} else if (charInfo[0] == 1) {
			sb.append((char)charInfo[1]);
		}//fi
    }//end method
}// end class
