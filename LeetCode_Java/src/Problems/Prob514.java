package Problems;

import java.util.*;

import Utils.MatrixUtils;


public class Prob514{
	

	
	public static void test() {

		Solution514 sol = new Solution514();
		CorrectSolution514 correctSol = new CorrectSolution514();
		String ring , key;
		
		ring  = "godding"; 
		key = "gd";
		System.out.println("ans: " + sol.findRotateSteps(ring ,key));
		System.out.println("correct ans: " + correctSol.findRotateSteps(ring ,key));

		

		
		ring  = "godding"; 
		key = "godding";
		System.out.println("ans: " + sol.findRotateSteps(ring ,key));
		System.out.println("correct ans: " + correctSol.findRotateSteps(ring ,key));
		
		ring  = "cimrihxbkmotdfudkkrovdydtyamiqdsogsaffnvdqucwfdrtrppmsjsmbekuxzltpktpzcuayjtowoyemlzggktxzkqzosenqgb"; 
		key = "dnkvlggcpqslgsbmnyiukfcglsgglvbqvoosetoktrtgezvbukxqsmiefoffbsgdoomhgfmqumsmmdspqckblzcawzupwagsmwii";
		//System.out.println("ring size: " + ring.length());
		System.out.println("ans: " + sol.findRotateSteps(ring ,key));
		System.out.println("correct ans: " + correctSol.findRotateSteps(ring ,key));
			



		ring  = "bicligfijg"; 		
		key = "cgijcjlgiggigigijiiciicjilicjflccgilcflijgigbiifiggigiggibbjbijlbcifjlblfggiibjgblgfiiifgbiiciffgbfl";
		//System.out.println("ring size: " + ring.length());
		System.out.println("ans: " + sol.findRotateSteps(ring ,key));
		System.out.println("correct ans: " + correctSol.findRotateSteps(ring ,key));
	//*/
		
		ring  = "sqlfcudiojjzmdmvbqgtkudggbazwtqgzrbxlooxcfnvzkvyvrroakdhnwcfyzyefiuatefegiragiqdrggictalanfupkuvjyid"; 
		key = "jogduakfgovnolkbjwelatfgfunqgvajvwtrzguyydiqaucqrzzcuhxcpkilfebqyytaxikigemzatzgmcdbodriddnrvgffsriv";
		//key = "jogd";
		System.out.println("ans: " + sol.findRotateSteps(ring ,key));
		System.out.println("correct ans: " + correctSol.findRotateSteps(ring ,key));
	

	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution514{	

	enum ROTATE {
		LEFT, RIGHT
	}
	
	private final int POS_BITS = 10;
	private final int STEP_MASK = 0b1111111111;
	
	String lockRing;
	String key;
	
	//0 = not cached, -1 = 0 rotation step, any positive number = rotation steps
	int[][] leftRotationCache;
	int[][] rightRotationCache;
	
	//key char to lock char cache. records min steps needed to rotate from current ring pos to designated key pos. outer array -lock ring position,  inner array -  key word position.
	int[][] keyLockStepCache;
	
	int globalMinSteps;
	
    public int findRotateSteps(String ring, String key) {
    	this.leftRotationCache = new int[ring.length()][26];
    	this.rightRotationCache = new int[ring.length()][26];
    	this.keyLockStepCache = new int[ring.length()][key.length()];
    	
    	this.lockRing = ring;
    	this.key = key;
    	this.globalMinSteps = Integer.MAX_VALUE;
    	
    	
    	
    	int ans = findMinSteps(0,0);
        return ans; //*/
    }//end method
    
    /**
     * Recursively calculates the minimum number of rotation steps needed to align the ring to place the key character at the specified position.
     * 
     * Starting from the current position of the key character on the ring, this method recursively computes the minimum number of steps required to align the ring
     * such that the next key character can be reached. It considers both left and right rotations and returns the minimum of the two.
     * 
     * 
     * @param keyPos - int, The position of the current key character in the key string.
     * @param ringPos - int, The current position of the ring.
     * @return The minimum number of rotation steps needed to align the ring for the current key character, considering both left and right rotations.
     */
    private int findMinSteps(int keyPos, int ringPos) {
    	
    	if (keyLockStepCache[ringPos][keyPos]>0) {
    		return keyLockStepCache[ringPos][keyPos];
    	}//fi
    	
    	int rightPosStepRes = getPosAndSteps(key.charAt(keyPos), ringPos, ROTATE.RIGHT);
    	int rightNextRingPos = rightPosStepRes>>POS_BITS;
    	int rightSteps = 1+rightPosStepRes&STEP_MASK;
    	
    	
    	int leftPosStepRes = getPosAndSteps(key.charAt(keyPos), ringPos, ROTATE.LEFT);
    	int leftNextRingPos = leftPosStepRes>>POS_BITS;
    	int leftSteps = 1+leftPosStepRes&STEP_MASK;
    	
    	if (keyPos == key.length()-1) {
    		keyLockStepCache[ringPos][keyPos] = Math.min(rightSteps, leftSteps);
    		return keyLockStepCache[ringPos][keyPos];
    	}//fi    	    
    	
    	int rightTotalSteps =  rightSteps + findMinSteps(keyPos+1,rightNextRingPos);
    	int leftTotalSteps =  leftSteps + findMinSteps(keyPos+1,leftNextRingPos);
    	
    	int minTotalSteps = Math.min(rightTotalSteps, leftTotalSteps);
    	keyLockStepCache[ringPos][keyPos] = minTotalSteps;
    	return minTotalSteps;
    }//end method
    
    
    /**
	 * Calculates the minimum number of rotation steps needed to align the ring to place the key character at the specified position.
	 * Additionally, it determines next lock ring position.
     * Preconditions:
     * - left and right rotation caches are instantiated and valid (its content must match lockRing)
     * 
     * @param keyChar - char, The character to align.
     * @param ringPos - int, The current position of the ring.
     * @param rotation - ROTATE, The direction of rotation (LEFT or RIGHT).
     * @return int - The minimum number of rotation steps needed is stored in the last POS_BITS bits of the int. Lock position is stored in the first 32-POS_BITS bits
     * 
     */
    private int getPosAndSteps(char keyChar, int ringPos, ROTATE roation) {
    	int[][] rotationCache = (roation == ROTATE.LEFT) ? leftRotationCache : rightRotationCache;
    	int keyCharInx = keyChar - 97;
    	if (rotationCache[ringPos][keyCharInx] == 0) {
    		//rotation steps not cached, do nothing 
    	} else if (rotationCache[ringPos][keyCharInx] == -1) {
    		return 0;
    	} else {
    		return rotationCache[ringPos][keyCharInx];
    	}//fi
    	
    	int rotationStep = 0;
    	int tmpRingPos = ringPos;
    	while (keyChar != lockRing.charAt(tmpRingPos)) {
    		rotationStep++;
    		if (roation == ROTATE.LEFT) {
    			tmpRingPos = (tmpRingPos == 0) ? lockRing.length()-1 : tmpRingPos-1;
    		} else {
    			tmpRingPos = (tmpRingPos == lockRing.length()-1) ? 0 : tmpRingPos+1;
    		}//fi
    	}//fi
    	
    	int posAndStepsResult = (tmpRingPos<<POS_BITS) + rotationStep;    	
    	if (posAndStepsResult == 0){
        	rotationCache[ringPos][keyCharInx] = -1;
    	} else {
    		rotationCache[ringPos][keyCharInx] = posAndStepsResult;        	
    	}//fi
    	return posAndStepsResult;
    }//end method
    

}//end class



class CorrectSolution514 {
    public int findRotateSteps(String ring, String key) {
          char[] r=ring.toCharArray();
        List<Integer>[] lockRingCharList=new List[26];
        for(int i=0;i<r.length;i++) {
            int c=r[i]-'a';            
            if(lockRingCharList[c]==null) {
            	lockRingCharList[c]=new ArrayList<>();
            }//fi
            lockRingCharList[c].add(i);
        }//rof
        for (char c = 97; c<123; c++) {
        	List<Integer> l = lockRingCharList[c-97];        
        	//System.out.println(c + " : " + l.size());
        }
        //System.out.println(Arrays.toString(lockRingCharList));
        int res = helper(0,0,lockRingCharList,key.toCharArray(),ring,new int[key.length()][r.length]);
        //System.out.println("helperCnt: " + helperCnt + " memoUseCnt: "+memoUseCnt + " helperPreCallCnt: " + helperPreCallCnt);
        //System.out.println(" helperCntArr: " + Arrays.toString(helperCntArr));
        //System.out.println(" helperCallCnt: " + Arrays.toString(helperCallCntArr));
        return res;
    }
    
    int helperCnt = 0;
    int[] helperCntArr = new int[101];
    int[] helperCallCntArr = new int[101];
    int helperPreCallCnt = 0;
    int memoUseCnt = 0;
    /**
     *  
     * @param keyInx - int, index in the key
     * @param currLockRingInx - int, the current position of the ring
     * @param lockRingCharList - List<Integer>[], the lock ring character index list
     * @param k - char[], key's char array
     * @param r - String, lock ring string
     * @param memo - int[][]
     * @return
     */
    int helper(int keyInx, int currLockRingInx, List<Integer>[] lockRingCharList, char[] k, String r, int[][] memo) {
        helperCntArr[keyInx]++;    	
    	if(keyInx==k.length) {
        	return 0;
        }//fi
    	
        //System.out.println("processing key char + " + (k[keyInx]) + " keyInx: " + keyInx + " currLockRingInx: " + currLockRingInx);
        helperCnt++;
    	
        if(memo[keyInx][currLockRingInx]>0) {
        	memoUseCnt++;
        	return memo[keyInx][currLockRingInx]-1;
        }//fi
        

        
        int min=Integer.MAX_VALUE;
        for(int lockRingCharInx: lockRingCharList[k[keyInx]-'a']) {
            int m;
            if(lockRingCharInx>=currLockRingInx) {
            	m=Math.min(lockRingCharInx-currLockRingInx, currLockRingInx+r.length()-lockRingCharInx);
            }else {
            	m=Math.min(currLockRingInx-lockRingCharInx, lockRingCharInx+r.length()-currLockRingInx);
            }//fi
            helperPreCallCnt++;
            helperCallCntArr[keyInx+1]++; 
            min=Math.min(min,m+helper(keyInx+1,lockRingCharInx,lockRingCharList,k,r,memo));
        }
        return (memo[keyInx][currLockRingInx]=min+2)-1;
    }
}




