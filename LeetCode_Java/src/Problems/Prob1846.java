package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob1846 {
	
	static int[] arr1 = {1,8,6,2,5,4,8,3,7}; 
	static int[] arr2 = {10,1,1000};
	static int[] arr10;

	
	public static void test() {

		Path filePath = Paths.get("./TestFiles/Prob1846.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_arr_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob1846.class.getDeclaredField(lines.get(i+1));
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
		
		Solution1846 sol = new Solution1846();
		

		
		int[] arr;
		
		/*
		arr = arr1;
		System.out.println("original arr: " + Arrays.toString(arr));
		System.out.println("ans: " + sol.maximumElementAfterDecrementingAndRearranging(arr) +  " : " + Arrays.toString(arr));
		
		arr = arr2;
		System.out.println("original arr: " + Arrays.toString(arr));
		System.out.println("ans: " + sol.maximumElementAfterDecrementingAndRearranging(arr) +  " : " + Arrays.toString(arr));
		//*/
		
		arr = arr10;
		System.out.println("original arr: " + Arrays.toString(arr));
		System.out.println("ans: " + sol.maximumElementAfterDecrementingAndRearranging(arr) +  " : " + Arrays.toString(arr));
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}

class Solution1846 {
	
	 public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		 
		 //step 1, populate value counts. To avoid confusing with original array value, counts are recorded in negative number 
		 int i = arr.length-1;
		 int tmpVal;		
		 while (i>=0) {
			 
			 //case 1. skip recording part
			 if (arr[i]>=arr.length) { //case 1-1. value larger than arr.length. discard it as it doesn't affect answer
				 arr[i]=0;
				 i--;
				 continue;
			 } else if (arr[i]<=0){ //case 1-2.  already recording count, skip it by decreasing i
				 i--;
				 continue;
			 }//fi
			 
			 //case 2. need to record count, record count at arr[val, which is arr[i]]
			 if (arr[arr[i]] <=0 ){ //case 2-1. already recording count				 
				 arr[arr[i]]--;		
				 arr[i] = 0;
				 i--;
			 } else if (arr[i]!=i) { //case 2-2. hasn't recorded count yet and is not pointing to itself				 
				 tmpVal = arr[arr[i]];
				 arr[arr[i]] = -1;
				 arr[i] = tmpVal;
			 } else { //case 2-3. hasn't recorded count and is pointing to itself				
				 arr[arr[i]] = -1;
				 i--;
			 }//fi		 
		 }//end method		 

		 
		 int possibleMax = arr.length;
		 int vacancy = 1;
		 

		 for (i=1; i<arr.length; i++) {
			 if (arr[i] == -1) {
				 //do nothing
			 } else if  (arr[i] == 0) {
				 vacancy++;
			 } else if ((vacancy += arr[i]) < 0){
				 possibleMax += vacancy;
				 vacancy = 1;
			 } else {//still vacant position to accumulate next duplicate values
				 //do nothing
			 }//fi
		 }//fi*/
		 return possibleMax;
	 }//end method    
}//end class


class Solution1846_v2 {
	
	 public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		 Arrays.sort(arr);
		 arr[0]=1;
		 for (int i=1; i<arr.length; i++) {
			 if (arr[i]==arr[i-1]) {
				 continue;
			 } else {
				 arr[i]=arr[i-1]+1;
			 }//fi
		 }//rof
		 return arr[arr.length-1];
	 }//end method    
}//end class