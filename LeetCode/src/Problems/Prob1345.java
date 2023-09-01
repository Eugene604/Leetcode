package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.*;

import java.util.*;


public class Prob1345 {
	static int[] nums0 = {0};
	static int[] nums1 = {100,-23,-23,404,100,23,23,23,3,404};
	static int[] nums2 = {7};	
	static int[] nums3 = {7,6,9,6,9,6,9,7};

	static int[] nums4 = {6,1,9};
	
	static int[] nums10;
	static int[] nums11;
	static int[] nums12;

	private static void test() {
		

		Path filePath = Paths.get("./TestFiles/Prob1345.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob1345.class.getDeclaredField(lines.get(i+1));
            	String[] tmpStrArr = lines.get(i+2).split(",");
                int[] tmpIntArr = new int[tmpStrArr.length];
                for (int j = 0; j < tmpStrArr.length; j++) {
                	tmpIntArr[j] = Integer.parseInt(tmpStrArr[j]);
                }//rof
				field.set(null, tmpIntArr);
            }//rof
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();       
        } catch (IOException e) {
            e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try catch
		
		int[] testArr;
		Solution1345 solObj = new Solution1345();
		
		/*
		
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
		
		
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
		
		
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
		
		
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
	
		
		
		

		testArr = nums11;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
		
		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));		
		
		
		
		testArr = nums12;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));	
			//*/
		
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.minJumps(testArr));
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}

class Solution1345 {

	private Map<Integer, Deque<Integer>> valToInxMap;
	int[] numArr;
	boolean[] visitedArr;
	
    public int minJumps(int[] arr) {
    	//special cases: array length 1 or 2
    	if (arr.length <= 2) {
    		return arr.length-1;
    	}//fi
    		
    	populateDataStruct(arr);

    	Deque<Integer> inxQueue = new LinkedList<>();
    	Deque<Integer> tmpQueue = valToInxMap.get(numArr[0]);
    	Integer tmpInx;
    	while ((tmpInx = tmpQueue.pollLast())!=null) {
    		if (tmpInx == numArr.length-1) {
    			return 1;
    		}//fi
    		inxQueue.add(tmpInx);
    		visitedArr[tmpInx]= true;	
    	}//fi 	
    	inxQueue.add(1);  
        return search(inxQueue, 1);
    }//end method
    
    /**
     * 
     * @param inxQueue LinkedList based deque that stores indices to be processed
     * @param currStep int value denoting current number of steps used
     * @return number of steps
     */
    private int search(Deque<Integer> inxQueue, int currStep) {    	
    	Integer tmpInx;
    	Deque<Integer> tmpQueue;
    	for (int i=inxQueue.size(); i>0; i--) {
    		int inx = inxQueue.pop();

    		tmpQueue = valToInxMap.get(numArr[inx]);    		

        	while ((tmpInx = tmpQueue.pollLast())!=null) {
        		if (visitedArr[tmpInx]) {
         			continue;
         		} else if (tmpInx == numArr.length-1) {
        			return currStep+1;
        		}//fi
        		inxQueue.add(tmpInx);
        		visitedArr[tmpInx]= true;		
        	}//fi
    		if (visitedArr[inx+1]) {
    			//do nothing
    		} else if (inx == numArr.length-2) {
    			return currStep+1;
    		} else {
    			inxQueue.add(inx+1);
    			visitedArr[inx+1] = true;
     		}//fi 
    		if (!visitedArr[inx-1]) {
    			inxQueue.add(inx-1);
    			visitedArr[inx+1] = true;
     		}//fi     	
    	}//rof
    	return search(inxQueue, currStep+1);
    }//end method
    
    
    /**
     * Post condition:
     * - number array is set
     * - valToInxMap is populated
     * - minNumOfJumps is initialized
     * - visitedArr is initialized
     * @param numArr int array that stores numbers
     */
    private void populateDataStruct(int[] numArr) {
    	this.numArr = numArr;
    	this.visitedArr = new boolean[numArr.length];
    	this.valToInxMap = new HashMap<>();
    	
    	int lastInx = numArr.length-1;
    	valToInxMap.put(numArr[0], new LinkedList<>());
    	valToInxMap.put(numArr[lastInx], new LinkedList<>());
    	valToInxMap.get(numArr[lastInx]).add(lastInx);
    	
    	Deque<Integer> inxList;
    	for (int i=1; i<lastInx; i++) {
            if (numArr[i] == numArr[i - 1] && numArr[i] == numArr[i + 1]) {
            	visitedArr[i] = true;
                continue;
            }//fi
            
    		if ((inxList=valToInxMap.get(numArr[i]))==null) {
    			inxList = new LinkedList<>();
    			valToInxMap.put(numArr[i], inxList);
    		}//fi
    		inxList.add(i);
    	}//rof    
    	this.visitedArr[0] = true;
    }//end method	
}//end class


class Solution1345_v2 {

	private Map<Integer, LinkedList<Integer>> valToInxMap;
	int[] numArr;
	boolean[] visitedArr;
	int[] minJumpArr;

	
    public int minJumps(int[] arr) {
    	//special cases: array length 1 or 2
    	if (arr.length <= 2) {
    		return arr.length-1;
    	}//fi
    		
    	populateDataStruct(arr);
    	//System.out.println("VTIMap: " + valToInxMap);
    	visitedArr[0] = true;
    	
    	for (Integer inx:valToInxMap.get(numArr[0])) {
    		if (inx == 0) {
    			continue;
    		}//fi
    		search(inx,1);
    	}//fi
    	search(1,1);
        return this.minJumpArr[arr.length-1];
    }//end method
    
    /**
     * Preconditions: required data structures are populated or instantiated
     * 
     * @param currInx int  
     * @param currStep int
     */
    private void search(int currInx, int currStep) {
    	//System.out.println("enter, currInx: " + currInx + " currStep: " + currStep + " currMin:" + minNumOfJumps);
    	//base cases
    	//if (currStep >= minNumOfJumps || visitedArr[currInx]) {
    	if (currStep >  minJumpArr[numArr.length-1] || currStep >  minJumpArr[currInx] || visitedArr[currInx]) {
    		//System.out.println("p1, visited: " + visitedArr[currInx]);
    		return;
    	} else if (currInx == numArr.length-1) {
    		//System.out.println("gone here2, number of steps: " + currStep);    		
    		if (currStep <  minJumpArr[currInx]) {
    			 minJumpArr[currInx] = currStep;
    		}//fi   		
    		return;
    	}//fi
    	
		if (currStep <  minJumpArr[currInx]) {
			 minJumpArr[currInx] = currStep;
		}//fi  
		
    	visitedArr[currInx] = true;
    	
    	Iterator<Integer> reverseItr = valToInxMap.get(numArr[currInx]).descendingIterator();
    	int tmpInx;
    	while (reverseItr.hasNext()) {
    		if ((tmpInx = reverseItr.next())==currInx) { //itself
    			//continue;
    			break;
    		} else {    			
    			search(tmpInx, currStep+1);
    		}//fi    		
    	}//end while
    	search(currInx+1, currStep+1);    	
    	search(currInx-1, currStep+1);
    	
    	Iterator<Integer> fwdItr = valToInxMap.get(numArr[currInx]).iterator();
    	while (fwdItr.hasNext()) {
    		if ((tmpInx = fwdItr.next())==currInx) { //itself
    			break;
    		} else {    			
    			search(tmpInx, currStep+1);
    		}//fi    		
    	}//end while//*/
    	visitedArr[currInx] = false;
    	
    }//end method
    
    
    /**
     * Post condition:
     * - number array is set
     * - valToInxMap is populated
     * - minNumOfJumps is initialized
     * - visitedArr is initialized
     * @param numArr int array that stores numbers
     */
    private void populateDataStruct(int[] numArr) {
    	this.numArr = numArr;
    	this.visitedArr = new boolean[numArr.length];
    	this.minJumpArr = new int[numArr.length];
    	this.valToInxMap = new HashMap<>();
    	
    	LinkedList<Integer> inxList;
    	for (int i=0; i<numArr.length; i++) {
    		if ((inxList=valToInxMap.get(numArr[i]))==null) {
    			inxList = new LinkedList<>();
    			valToInxMap.put(numArr[i], inxList);
    		}//fi
    		inxList.add(i);
    		minJumpArr[i]=i;
    	}//rof  
    	
    }//end method
	
}//end class
