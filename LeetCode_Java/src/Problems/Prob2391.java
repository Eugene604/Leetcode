package Problems;

import java.util.*;
import java.util.Map.Entry;


public class Prob2391 {

	private static String[] g1 = {"G","P","GP","GG"};
	private static int[] t1 = {2,4,3};
	
	public static void main(String[] args) {
		Solution2391 solObj;
		String[] garbage;
		int[] travel;
		int sol;
		

		garbage = g1;
		travel = t1;
		solObj = new Solution2391();
		sol = solObj.garbageCollection(garbage,travel);
		System.out.println("sol: " + sol);
		
		
		//*/
		
		

	}

}



class Solution2391 {

	public int garbageCollection(String[] garbage, int[] travel) {
		//step 1, determine last house of each garbage		
		int lastMetalInx = -1, lastPaperInx = -1, lastGlassInx = -1;
		String gStr;
		for (int i=travel.length; i>=0 && (lastMetalInx==-1 || lastPaperInx==-1 || lastGlassInx==-1); i--) {
			gStr = garbage[i];
			if (lastMetalInx == -1 && gStr.indexOf('M')!=-1) {
				lastMetalInx = i;
			}//fi
			if (lastPaperInx == -1 && gStr.indexOf('P')!=-1) {
				lastPaperInx = i;
			}//fi			
			if (lastGlassInx == -1 && gStr.indexOf('G')!=-1) {
				lastGlassInx = i;
			}//fi		
		}//rof
		
		int pickupTime = 0;
		for (int i=0; i<lastMetalInx; i++) {
			pickupTime += travel[i];
		}//rof
		for (int i=0; i<lastPaperInx; i++) {
			pickupTime += travel[i];
		}//rof
		for (int i=0; i<lastGlassInx; i++) {
			pickupTime += travel[i];
		}//rof
		
		for (String g:garbage) {
			pickupTime += g.length();
		}//rof

        return pickupTime;    
    }//end method
    
}//end class

class Solution2391_v2 {

	public int garbageCollection(String[] garbage, int[] travel) {
		//step 1, populate truck time arrays 
		int[] metalGTTArr = new int[garbage.length]; //GTT = garbage truck time 
		int[] paperGTTArr = new int[garbage.length];
		int[] glassGTTArr = new int[garbage.length];
		
		int lastMetalInx = -1, lastPaperInx = -1, lastGlassInx = -1;
		for (int i=0; i<garbage.length; i++) {
			for (char g:garbage[i].toCharArray()) {
				switch (g) {
				case 'M':
					metalGTTArr[i]++;
					lastMetalInx = i;
					break;
				case 'P':
					paperGTTArr[i]++;
					lastPaperInx = i;
					break;
				case 'G':
					glassGTTArr[i]++;
					lastGlassInx = i;
					break;
				}//end switch
			}//rof			
		}//rof
		
		//step 2, add them up
		int pickupTime = metalGTTArr[0];
		for (int i=1; i<=lastMetalInx; i++) {
			pickupTime += metalGTTArr[i];
			pickupTime += travel[i-1];
		}//rof
		
		pickupTime += paperGTTArr[0];
		for (int i=1; i<=lastPaperInx; i++) {
			pickupTime += paperGTTArr[i];
			pickupTime += travel[i-1];
		}//rof
		
		pickupTime += glassGTTArr[0];
		for (int i=1; i<=lastGlassInx; i++) {
			pickupTime += glassGTTArr[i];
			pickupTime += travel[i-1];
		}//rof
		


        return pickupTime;    
    }//end method
    

}//end class

