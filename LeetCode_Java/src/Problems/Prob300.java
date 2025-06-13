package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob300{
	static int[] nums0 = {10,9,2,5,3,7,101,18}; //4
	static int[] nums1 = {1,2,-10,-8,-7}; //3
	static int[] nums2 = {678,482,667,859,670,554,934,914,485,774,887,812,727,778,869,590,505,769,734,779,629,500,821,913,889,735,401,735,900,715,976,922,513,430,429,518,823,558,975,927,589,973,928,830,496,541,855,501,726,435,465,710,936,845,734,452,730,927,571,909,896,598,939,489,945,566,773,783,885,912,469,616,708,628,970,629,744,482,402,624,998,609,610,944,851,565,843,714,731,975,841,676,765,442,978,562,453,408,429,762,817,788,971,681,737,961,896,891,760,866,431,420,815,838,691,488,471,589,997,522,878,967,482,522,791,629,715,615,995,638,437,984,708,676,871,447,868,546,977,510,503,471,734,953,779,475,652,472,733,454,858,594,817,494,930,639,781,568,952,955,830,557,458,675,830,599,564,807,470,436,523,952,946,480,434,598,800,759,484,599,868,992,579,861,835,829,990,638,710,715,623,908,723,599,613,885,891,997,474,957,620,641,802,645,531,607,457,932,936,632,994,815,880,505,771,929,567,513,811,738,988,935,525,555,934,609,907,522,654,483,421,907,679,729,552,980,941,952,745,906,892,610,459,562,635,587,476,556,943,945,494,1000,467,783,458,616,761,671,903,610,428,846,557,456,763,673,427,756,701,933,460,509,487,878,833,407,698,561,722,747,864,575,867,987,754,478,632,423,469,896,915,791};	
	static int[] nums3 = {24,39,-57,-42,-41};
	static int[] nums4 = {3,5,6,2,5,4,19,5,6,7,12};
	static int[] nums5 = {7,5,6,8,2,1,2,3,4,5,6,7,8};
	static int[] nums6 = {0,1,0,3,2,3};
	static int[] nums7 = {7,7,7,7,7,7,7};
	


	private static void test() {
		

	
		Solution300 solObj = new Solution300();
		Solution300_v2 correct_solObj = new Solution300_v2();		
		int[] nums;

		try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            
            nums = objectMapper.readValue("[1,20,40,80,2,3,4,5,6,7,8,9,10]", int[].class);
            System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("ans: " + solObj.lengthOfLIS(nums));
    		System.out.println("ans: " + correct_solObj.lengthOfLIS(nums));
    		
    		/*
            nums = objectMapper.readValue("[0,1,0,3,2,3]", int[].class);
            System.out.println("Arr: " + Arrays.toString(nums));
    		System.out.println("ans: " + solObj.lengthOfLIS(nums));    		 
    		//*/
       
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		

		
	}//end test
	
	public static void main(String[] args) {
		test();
	}//end main
}


class Solution300{

	
    public int lengthOfLIS(int[] nums) {
    	//array index = index of number array, array value = longest sequence length possible if to include # at this position
		int[] cntArr = new int[nums.length];     	
    	cntArr[0]=1;
    	int maxCnt = 1;
    	int currCnt;
    	for (int numInx=1; numInx<nums.length; numInx++) {
    		currCnt = 1;
    		for (int i=numInx-1; i>=currCnt-1; i--) {
        		if (nums[i] < nums[numInx]) {
        			currCnt = Math.max(currCnt,  cntArr[i]+1);
        		}//fi
        	}//rof */
    		cntArr[numInx] = currCnt;
    		maxCnt = Math.max(maxCnt,  currCnt);
    	}//rof
    	//System.out.println("cntArr" + Arrays.toString(cntArr));
    	return maxCnt;
    }//end method
       
}//end class



class Solution300_v2{
	
    public int lengthOfLIS(int[] nums) {
    	//Map <sequence count, current last (greatest) value of the sequence>
    	Map<Integer, Integer> cntMap = new HashMap<>();
    	cntMap.put(1,nums[0]);
    	for (int i=1; i<nums.length; i++) {
    		//System.out.println("\n=============== before add: " + nums[i]);
    		addNumToCntMap(nums[i],cntMap);
    		//System.out.println("=============== after add: " + nums[i] + " map: " + cntMap);
    	}//rof
    	//System.out.println(cntMap);
    	
    	int maxLength = 0;
    	for (int cnt:cntMap.keySet()) {
    		if (cnt > maxLength) {
    			maxLength = cnt;
    		}//fi
    	}//rof
    	return maxLength;
    }//end method
    
    /**
     * add number to count map
     * postcondition:
     * the number is added to the reverse count map if it is worthy to be added
     * @param num - int, the number to be inserted
     * @param cntMap - Map <sequence count, current last (greatest) value of the sequence>
     */
    private void addNumToCntMap(int num, Map<Integer, Integer> cntMap) {
    	List<Integer> keyList = new ArrayList<>(cntMap.size());
    	for (Integer key:cntMap.keySet()) {
    		keyList.add(key);
    	}   	
        Collections.sort(keyList, Comparator.reverseOrder());
    	int lastVal;
    	for (int key:keyList) {
    		lastVal = cntMap.get(key);
    		//System.out.println("......scan key: " + key + " map: " + cntMap);
    		if (lastVal == num-1) {
        		/*
        		 * number to be inserted is exactly one more than the last element of this sequence, extend the sequence
        		 * add 100: [...,98, 99, 100...], extend the sequence   		
        		 */ 
    			//System.out.println("gone here 1");
    			cntMap.put(key+1, num);
    			cntMap.remove(key);    			
			} else if(lastVal >= num) {
        		/*
        		 * number to be inserted is less or equal to the largest element of this sequence
        		 * skip if not less than (lastVal - sequence count)
        		 * add 100: [99, 100, 101, 100...], 100 > (101-3), hence skip. 
        		 * add 100: [200,100], or [198, 199, 200, 100]  
        		 * try add an entry for 100, so map contains 1=200    		
        		 */
    			//System.out.println("gone here 2-1");
    			if (lastVal - key >= num && num < cntMap.getOrDefault(1, Integer.MAX_VALUE)) {
    				//System.out.println("gone here 2-2");        			
        			cntMap.put(1, num);        		
    			}//fi  
			} else {
        		/*
        		 * number to be inserted is more than one plus the last element of this sequence, extend the sequence if worthy but also keep original
        		 * add 100: [...,49, 50, 100...], extend the sequence but also keep original. 
        		 * if cnt+1 exists and contains more optimal sequence, then don't add   		
        		 */
    			//System.out.println("gone here 3");
    			if (num < cntMap.getOrDefault(key+1, Integer.MAX_VALUE)) {
    				cntMap.put(key+1, num);
    			}//fi	
    			return;
			}//fi
    	}//rof
    	
    }//end method
    
}//end class

class Solution300_v3{
	static int[] cntArr = new int[2501]; 
	
    public int lengthOfLIS(int[] nums) {
    	//array index = sequence count, array value = current last (greatest) value of the sequence    	 
    	Arrays.fill(cntArr, 0, nums.length+1, Integer.MAX_VALUE);
    	cntArr[1]=nums[0];
    	for (int i=1; i<nums.length; i++) {
    		System.out.println("\n=============== before add: " + nums[i]);
    		addNumToCntArr(nums[i],cntArr, nums.length);
    		System.out.println("=============== after add: " + nums[i] + " map: " + cntArrToString(cntArr));
    	}//rof
    
    	
    	for (int i=nums.length; i>0; i--) {
    		if (cntArr[i] != Integer.MAX_VALUE) {
    			return i;
    		}//fi
    	}//rof */
    	return 1;
    }//end method
    
    /**
     * add number to count arr
     * postcondition:
     * the number is added to the count arr if it is worthy to be added
     * @param num - int, the number to be inserted
     * @param cntArr - int[], array index = sequence count, array value = current last (greatest) value of the sequence
     */
    private void addNumToCntArr(int num, int[] cntArr, int maxInx) {

    	for (int i=maxInx; i>=0; i--) {
    		
    		//System.out.println("......scan seq cnt: " + i + " last val: " + cntArr[i]);
    		if (cntArr[i] == num-1) {
        		/*
        		 * number to be inserted is exactly one more than the last element of this sequence, extend the sequence
        		 * add 100: [...,98, 99, 100...], extend the sequence   		
        		 */ 
    			//System.out.println("gone here 1");
    			cntArr[i+1]=num;
    			cntArr[i]=Integer.MAX_VALUE;    			
			} else if(cntArr[i] >= num) {
        		/*
        		 * number to be inserted is less or equal to the largest element of this sequence
        		 * skip if not less than (lastVal - sequence count)
        		 * add 100: [99, 100, 101, 100...], 100 > (101-3), hence skip. 
        		 * add 100: [200,100], or [198, 199, 200, 100]  
        		 * try add an entry for 100, so map contains 1=200    		
        		 */
    			//System.out.println("gone here 2-1");
    			if (cntArr[i] - i >= num && num < cntArr[1]) {
    				//System.out.println("gone here 2-2");        			
    				cntArr[1]=num;  		
    			}//fi  
			} else {
        		/*
        		 * number to be inserted is more than one plus the last element of this sequence, extend the sequence if worthy but also keep original
        		 * add 100: [...,49, 50, 100...], extend the sequence but also keep original. 
        		 * if cnt+1 exists and contains more optimal sequence, then don't add   		
        		 */
    			//System.out.println("gone here 3");
    			if (num < cntArr[i+1]) {
    				cntArr[i+1]=num;
    			}//fi				
			}//fi
    	}//rof
    	
    }//end method
    
    private String cntArrToString(int[] cntArr) {
    	int i=cntArr.length-1;
    	while (cntArr[i]==0) {
    		i--;
    	}//end while
    	StringBuilder sb = new StringBuilder();
    	sb.append('{');
    	for (; i>=0; i--) {
    		if  (cntArr[i]!=Integer.MAX_VALUE) {
    			sb.append(i);
    			sb.append('=');
    			sb.append(cntArr[i]);
    			sb.append(',');
    			sb.append(' ');
    		}//fi
    	}//rof
    	sb.append('}');
    	return sb.toString();
    }
}//end class

