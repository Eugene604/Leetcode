package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob907 {
	
	public static int[] arr20;
	public static int[] arr21;

	
	public static void test() {

		Path filePath = Paths.get("./TestFiles/Prob907.dat");
		
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob907.class.getDeclaredField(lines.get(i+1));
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
        
		Solution907 sol = new Solution907();
		
		int[] arr1 = {11,81,94,43,3};
		int[] arr2 = {3,1,2,4};
		int[] arr3 = {2,7,9,3,1};
		
		int[] arr;
		
		arr = arr1;
		System.out.println("ans: " + sol.sumSubarrayMins(arr));
		
		
		
		arr = arr20;
		System.out.println("ans: " + sol.sumSubarrayMins(arr));
		
		arr = arr21;
		System.out.println("ans: " + sol.sumSubarrayMins(arr));
		//*/
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution907 {
	private static final long MOD_CONST = 1000000007; 
	private static int[][] rangeArr = new int[30001][2]; //0 left, 1 right

	
	public int sumSubarrayMins(int[] arr) {		
		
		//step 1, populate left right ranges
		ArrayDeque<Integer> leftInxStack = new ArrayDeque<>();
		leftInxStack.push(-1);
		int topEle;
		for (int i=0; i<arr.length; i++) {
			while ((topEle=leftInxStack.peek())!=-1 && arr[topEle] > arr[i]) {
				leftInxStack.pop();
			}//end while
			rangeArr[i][0] = i-topEle;
			leftInxStack.push(i);
		}//rof
		
		ArrayDeque<Integer> rightInxStack = new ArrayDeque<>();
		rightInxStack.push(arr.length);
		for (int i=arr.length-1; i>=0; i--) {
			while ((topEle=rightInxStack.peek())!=arr.length && arr[topEle] >= arr[i]) {
				rightInxStack.pop();
			}//end while
			rangeArr[i][1] = topEle-i;
			rightInxStack.push(i);
		}//rof
		
		
		//step 2, get sum
		long sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += (arr[i]%MOD_CONST)*(rangeArr[i][0]*rangeArr[i][1]%MOD_CONST);
			sum %= MOD_CONST;			
		}//rof		
        return (int)sum;
    }//end method
    
}//end class



class Solution907_v2 {
	private static final long MOD_CONST = 1000000007; 
	private static int[] minCache = new int[30000];
	public int sumSubarrayMins(int[] arr) {
		long sum = arr[arr.length-1];
		//step 1, iterate through arr and populate first layer of min cache
		
		int maxInx = arr.length-2;
		for (int i=0; i<=maxInx; i++) {
			sum += arr[i];
			minCache[i] = Math.min(arr[i],  arr[i+1]);
		}//rof
		//System.out.println("minCache: " + Arrays.toString(minCache) + ":" + maxInx + " sum:" + sum);
		
		sum %= MOD_CONST;
		//maxInx--;

		//step 2, iterate through minCache itself until maxInx is 0
		while (maxInx >= 0) {
			for (int i=0; i<=maxInx; i++) {
				sum += minCache[i];
				minCache[i] = Math.min(minCache[i],  minCache[i+1]);
			}//rof
			//System.out.println("minCache: " + Arrays.toString(minCache) + ":" + maxInx + " sum:" + sum);
			sum %= MOD_CONST;
			maxInx--;
		}//end while
		
        return (int)sum;
    }//end method
    
}//end class