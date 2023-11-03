package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Prob456 {
	static int[] nums0 = {1,4,0,-1,-2,-3,-1,-2};
	static int[] nums1 = {1,2,3,4};
	static int[] nums2 = {3,1,4,2};
	
	static int[] nums3 = {-1,3,2,0};	
	
	static int[] nums4 = {1,2,3,3,3,4,5,3};
	static int[] nums5 = {49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
	static int[] nums6 = {0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0};
	static int[] nums7 = {-2,1,1,-2,1,1};
	static int[] nums8 = {42,43,10,12,10,11,12,20,8};
	static int[] nums9 = {2,4,3,1};
	static int[] nums10, nums11, nums12;
	
	private static void test() {

		Path filePath = Paths.get("./TestFiles/Prob456.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob456.class.getDeclaredField(lines.get(i+1));
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
		Solution456 solObj = new Solution456();
		
		/*
		testArr = nums0;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		testArr = nums1;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		testArr = nums2;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		testArr = nums3;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		testArr = nums4;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
			testArr = nums5;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		testArr = nums6;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
				testArr = nums7;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
				testArr = nums8;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
		testArr = nums11;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
	

		
		testArr = nums12;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		
		
		//*/


		testArr = nums10;
		System.out.println("Arr: " + Arrays.toString(testArr));
		System.out.println("Ans: " + solObj.find132pattern(testArr));
		

		
		
		
	}
	
	public static void main(String[] args) {
		test();
	}//end main
}


class Solution456 {
	
	private TreeSet<Integer> numSet = new TreeSet<>();


	
	private int currElementThree;
	private int currElementTwo;

	
    public boolean find132pattern(int[] nums) {
    	//special case, array length is insufficient
    	if (nums.length<3) {
    		return false;
    	}//fi
    	
    	//step 1, search for initial three two pattern
    	currElementThree = Integer.MIN_VALUE;
    	currElementTwo = Integer.MIN_VALUE;
    	push(nums[nums.length-1]);
    	int currInx;
    	for (currInx=nums.length-2; currInx >=0; currInx--) {
			push(nums[currInx]);
    		if (nums[currInx]>nums[currInx+1]) {
    			currElementThree=nums[currInx];
    			break;
    		}//fi
    	}//rof    	
    	if (currElementThree == Integer.MIN_VALUE) {
    		return false;
    	}else {		
    		currElementTwo = popElementTwo();
    	}//fi
    	System.out.println("currInx inx " + currInx + " patt : "+ currElementThree+ " : " + currElementTwo );
    	//step 2, search for element ONE while updating element THREE and TWO
    	for (currInx=currInx-1; currInx >=0; currInx--) {
    		//System.out.println("currInx inx " + currInx + " patt : "+ currElementThree+ " : " + currElementTwo );
    		System.out.println("currInx inx " + currInx +  " : " + currElementTwo + " set : "+ numSet );
    		if (nums[currInx]<currElementTwo) {//element One found
    			//System.out.println(nums[currInx]+":"+currElementThree+":"+currElementTwo);
    			return true;
    		} else if (nums[currInx]>currElementTwo) {//a new element three is possible
    			currElementThree = nums[currInx];
    			currElementTwo = popElementTwo();
    			push(nums[currInx]);//for future use    
    		}//fi
    	}//rof      	
        return false;
    }//end method
    

	/**
	 * 
	 * @return return and remove top int in the set, Integer.MAX_VALUE if set is empty
	 */
	private int pop() {
		if (numSet.isEmpty()) {
			return Integer.MAX_VALUE;
		}//fi
		return numSet.pollFirst();		
	}//end method
		
	
	/**
	 * precondition:
	 * - numSet has been instantiated, currElementTwo also initialized
	 * any number that is smaller than or equal to currElementTwo will not be pushed
	 * @param i - int to be pushed in
	 */
	private void push(int i) {
		if (i>currElementTwo) {
			System.out.println("add " + i);
			numSet.add(i);
		}//fi
	}//end method
	
	/**
	 * try pop an element two candidate
	 * this number should be as close as element three 
	 * precondition: 
	 * - numSet has been instantiated, currElementThree is set
	 * @return int
	 */
	private int popElementTwo() {
		int currNum;
		while (!numSet.isEmpty()) {
			currNum = numSet.pollFirst();
			if (currNum<currElementTwo) {
				//do nothing
			} else if (currNum<currElementThree) {
				currElementTwo = currNum;
			} else if (currNum>=currElementThree) {
				numSet.add(currNum);
				return currElementTwo;
			}//fi
		}//fi		
		return currElementTwo;
	}//end method
}//end class


class Solution456_v2 {
	
	//one three pattern list, each element hold {pattern one value, pattern three value}
	Deque<int[]> patList; 

	
    public boolean find132pattern(int[] nums) {
    	//special case, array length is insufficient
    	if (nums.length<3) {
    		return false;
    	}//fi
    	
    	//step 1, search for initial primary one three pattern
    	patList = new LinkedList<>();
    	int[] tmpPat = new int[2];
    	tmpPat[0] = nums[0];    	
    	int currInx;
    	for (currInx=1; currInx < nums.length; currInx++) {
    		if (nums[currInx]>tmpPat[0]) {
    			tmpPat[1] = nums[currInx];
    	    	patList.add(tmpPat);
    			break;
    		} else {
    			tmpPat[0] = nums[currInx];
    		}//fi
    	}//rof

    	Iterator<int[]> itr;    
    	NUMBER_LOOP:
    	for (currInx = currInx+1; currInx < nums.length; currInx++) {    		
    		//System.out.println("processing num : " + nums[currInx]);
    		itr = patList.iterator();
    		PATTERN_LOOP:
    		while (itr.hasNext()) {
    			tmpPat = itr.next();
    			//System.out.println("checking pat: " + Arrays.toString(currPat));
    			if (nums[currInx]<tmpPat[0]) { //case 1, found number that is lower than curr pat's ONE element, continue for next pat
        	    	continue PATTERN_LOOP;
        		} else if (nums[currInx]==tmpPat[0]) {//case 2, found number  that is equal to curr one pat's ONE element, continue for next pat number
        			if (itr.hasNext()) {
        				continue PATTERN_LOOP;
        			} else {
        				continue NUMBER_LOOP;
        			}//fi
        			
        		} else if (nums[currInx]<tmpPat[1]) {//case 3, found number that is lower than curr pat's THREE element, one three two pat found
        			//displayPatList();
        			return true;
        		} else  {//case 4, found number that is eq to or greater than curr pat's THREE element, expand this pat and continue for next number
        			if (itr.hasNext()) {
        				itr.remove();
        				continue PATTERN_LOOP;
        			} else {
        				tmpPat[1] = nums[currInx];
        				continue NUMBER_LOOP;
        			}//fi

        			//System.out.println("pat becomes: " + Arrays.toString(currPat));
        			
        		}//fi
    		}//end while
    		//when program arrives here it means current array element is smaller than all of pat's ONE element, create new pattern
    		tmpPat = new int[2];
    		tmpPat[0]=nums[currInx];		
    		tmpPat[1]=nums[currInx];
    		//System.out.println("pat created: " + Arrays.toString(tmpPat));
    		patList.addLast(tmpPat);
    	}//rof
    	//displayPatList();
        return false;
    }//end method
    
    private void displayPatList() {
    	System.out.print("[");
    	for (int[] currPat:patList ) {
    		System.out.print(Arrays.toString(currPat)+",");
    	}//rof
    	System.out.println("]");
    }//end method
}//end class
