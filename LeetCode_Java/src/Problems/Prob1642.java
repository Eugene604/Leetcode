package Problems;

import java.util.*;

public class Prob1642 {
	static int[] nums0 = {4,2,7,6,9,14,12};
	static int[] nums1 = {4,12,2,7,3,18,20,3,19};
	static int[] nums2 = {20000,1,15724,1,191155,1,762365,353751,1000000,143555,163904,1,401025,1,177639,1,16935,1,540054,109986,297374};
	static int[] nums3 = {57222,978730,16175627,205592,221896,444108,979369,44001,790354,353917,72772,330118,360651,635275,849492,966042,843108,158554,406317,995111,147752,121006,486157,678653,217657,4288,573547,820817,164534,921608,308037,373838,385901,813472,58859,346176,68090,5395961};
	
	
	
	private static void test() {
		int[] height;
		Solution1642 solObj = new Solution1642();
		CorrectSolution1642 correctSolObj = new CorrectSolution1642();
		int bricks, ladders;
		

		

		//*/
		
		height = nums3;
		bricks = 334543;
		ladders = 18;
		System.out.println("height: " + Arrays.toString(height) + " ladders: " + ladders + " bricks: " + bricks);
		System.out.println("Ans: " + solObj.furthestBuilding(height,bricks,ladders));
		System.out.println("Ans: " + correctSolObj.furthestBuilding(height,bricks,ladders));
		
		
		/*
		height = nums1;
		bricks = 10;
		ladders = 2;
		System.out.println("height: " + Arrays.toString(height) + " ladders: " + ladders + " bricks: " + bricks);
		System.out.println("Ans: " + solObj.furthestBuilding(height,bricks,ladders));
		
		height = nums0;
		bricks = 5;
		ladders = 1;
		System.out.println("height: " + Arrays.toString(height) + " ladders: " + ladders + " bricks: " + bricks);
		System.out.println("Ans: " + solObj.furthestBuilding(height,bricks,ladders));
				
		height = nums2;
		bricks = 2312627;
		ladders = 1;
		System.out.println("height: " + Arrays.toString(height) + " ladders: " + ladders + " bricks: " + bricks);
		System.out.println("Ans: " + solObj.furthestBuilding(height,bricks,ladders));
		System.out.println("Ans: " + correctSolObj.furthestBuilding(height,bricks,ladders));

		//*/
	}//end method
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    	int bInx = 0;

    	int heightDiff;
    	
    	//special cases:
    	if (ladders == 0 && bricks == 0) {//case 1: neither ladder nor bricks are available    		
    		while (bInx < heights.length-1 && heights[bInx+1]-heights[bInx]<=0) {
    			bInx++;
    		}//end while
    		return bInx;
    	} else if (ladders >= heights.length-1) {//case 2: ladders is enough to cover all buildings
    		return heights.length-1;
    	} else if (bricks == 0) {//case 3: only ladder is available
    		while (bInx < heights.length-1) {
    			if (heights[bInx+1]-heights[bInx] <= 0) {    				
    				continue;
    			} else if (ladders > 0) {
    				ladders--;
    			} else {
    				return bInx;
    			}//fi
    			bInx++;
    		}//end while
    		return bInx;
    	} else if (ladders == 0) {//case 4: only brick is available
    		while (bInx < heights.length-1 && bricks >= 0) {
    			heightDiff = heights[bInx+1]-heights[bInx];
    			if (heightDiff<=0) {
    				//do nothing
    			} else if ((bricks -= heightDiff) < 0) {
    				return bInx;
    			}//fi
    			bInx++;
    		}//end while
    		return bInx;
    	}//fi
    	
    
    	
    	PriorityQueue<Integer> brickQueue = new PriorityQueue<>((a, b) -> b.compareTo(a));
    	Integer largestBricksUsed; 
    	int laddersLeft = ladders;
    	int bricksLeft = bricks;
    	//algorithm, try use bricks if possible, then ladder, then check if switch is possible
    	for (bInx = 0; bInx<heights.length-1; bInx++) {
    		//System.out.println("jsut enter loop bInx: " + bInx + " avail src: " + laddersLeft + " : " + bricksLeft);

    		heightDiff = heights[bInx+1]-heights[bInx];
    		//System.out.println(heights[bInx] + ":" + heights[bInx+1] + " heightDiff: " + heightDiff);
    		if (heightDiff <= 0) {
    			continue;
    		}//fi
    		    	
    		
			if (bricksLeft >= heightDiff) { //has sufficient bricks, always use it first 
				bricksLeft -= heightDiff;
				brickQueue.offer(heightDiff);
				continue;
			} else if (laddersLeft > 0 &&
					(largestBricksUsed = brickQueue.peek()) != null && 
					largestBricksUsed > heightDiff) {			
				/*	
				 * try switching largest bricks to a ladder in hope of extracting more resources
				 */
				//System.out.println("shortestLadderUsed: " + shortestLadderUsed + " largestBricksUsed: " + largestBricksUsed);
				//switch for more resources
				bricksLeft += largestBricksUsed;
				bricksLeft -= heightDiff;
				laddersLeft--;
				
				//update resource registrations
				brickQueue.poll();		
				brickQueue.offer(heightDiff);
				continue;
			} else if (laddersLeft > 0) { //only got ladder available, then use ladder 
				laddersLeft--;
				continue;
			} else { //too bad, after extracting all savable resources, there are still insufficient resources to jump 
				//System.out.println("bInx: " + bInx + " return pt 3");
				return bInx;		
			}//fi			
			
						
    	}//rof
    	//System.out.println("bInx: " + bInx +  " return pt 4");
    	return bInx;
    }//end method   
}//end class


class CorrectSolution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    	int bInx = 0;

    	int heightDiff;
    	
    	//special cases:
    	if (ladders == 0 && bricks == 0) {//case 1: neither ladder nor bricks are available    		
    		while (bInx < heights.length-1 && heights[bInx+1]-heights[bInx]<=0) {
    			bInx++;
    		}//end while
    		return bInx;
    	} else if (ladders >= heights.length-1) {//case 2: ladders is enough to cover all buildings
    		return heights.length-1;
    	} else if (bricks == 0) {//case 3: only ladder is available
    		while (bInx < heights.length-1) {
    			if (heights[bInx+1]-heights[bInx] <= 0) {    				
    				continue;
    			} else if (ladders > 0) {
    				ladders--;
    			} else {
    				return bInx;
    			}//fi
    			bInx++;
    		}//end while
    		return bInx;
    	} else if (ladders == 0) {//case 4: only brick is available
    		while (bInx < heights.length-1 && bricks >= 0) {
    			heightDiff = heights[bInx+1]-heights[bInx];
    			if (heightDiff<=0) {
    				//do nothing
    			} else if ((bricks -= heightDiff) < 0) {
    				return bInx;
    			}//fi
    			bInx++;
    		}//end while
    		return bInx;
    	}//fi
    	
    
    	PriorityQueue<Integer> ladderQueue = new PriorityQueue<>();
    	PriorityQueue<Integer> brickQueue = new PriorityQueue<>((a, b) -> b.compareTo(a));
    	Integer shortestLadderUsed, largestBricksUsed; 
		shortestLadderUsed = ladderQueue.peek();
		largestBricksUsed = brickQueue.peek();
    	int laddersLeft = ladders;
    	int bricksLeft = bricks;
    	//algorithm, try use bricks if possible, then ladder, then check if switch is possible
    	for (bInx = 0; bInx<heights.length-1; bInx++) {
    		//System.out.println("jsut enter loop bInx: " + bInx + " shortestLadderUsed: " + shortestLadderUsed + " largestBricksUsed: " + largestBricksUsed + " avail src: " + laddersLeft + " : " + bricksLeft);

    		heightDiff = heights[bInx+1]-heights[bInx];
    		//System.out.println(heights[bInx] + ":" + heights[bInx+1] + " heightDiff: " + heightDiff);
    		if (heightDiff <= 0) {
    			continue;
    		}//fi
    		
    		

			
			/*	
			 * try switching largest bricks & shortest ladder to extract more resources	
			 * or
			 * try switching shortest ladder with available brick reserve to extract more resources
			 * But whether there is sufficient resources to support next jump is still a question
			 */
			while ((shortestLadderUsed = ladderQueue.peek()) != null && 
					(largestBricksUsed = brickQueue.peek()) != null && 
					shortestLadderUsed < largestBricksUsed) {
				//System.out.println("shortestLadderUsed: " + shortestLadderUsed + " largestBricksUsed: " + largestBricksUsed);
				//switch for more resources
				bricksLeft += largestBricksUsed;
				bricksLeft -= shortestLadderUsed;
				
				//update resource registrations
				ladderQueue.poll();
				brickQueue.poll();				
				ladderQueue.offer(largestBricksUsed);		
				brickQueue.offer(shortestLadderUsed);		
			}//end while
			
			
			while ((shortestLadderUsed = ladderQueue.peek()) != null && 
					bricksLeft > shortestLadderUsed) {
				//System.out.println("shortestLadderUsed: " + shortestLadderUsed + " largestBricksUsed: " + largestBricksUsed);
				//switch for more resources
				laddersLeft++;
				bricksLeft -= shortestLadderUsed;
				//update resource registrations
				ladderQueue.poll();			
				brickQueue.offer(shortestLadderUsed);				
			}//end while
			
    		//System.out.println("after src saving bInx: " + bInx + " shortestLadderUsed: " + shortestLadderUsed + " largestBricksUsed: " + largestBricksUsed + " avail src: " + laddersLeft + " : " + bricksLeft);
			if (bricksLeft >= heightDiff) { //has sufficient bricks, always use it first 
				bricksLeft -= heightDiff;
				brickQueue.offer(heightDiff);
				continue;
			} else if (laddersLeft > 0) { //has ladder available, always use it second 
				laddersLeft--;
				ladderQueue.offer(heightDiff);
				continue;
			} else { //too bad, after extracting all savable resources, there are still insufficient resources to jump 
				//System.out.println("bInx: " + bInx + " return pt 3");
				return bInx;		
			}//fi			
			
						
    	}//rof
    	//System.out.println("bInx: " + bInx +  " return pt 4");
    	return bInx;
    }//end method   
}//end class


