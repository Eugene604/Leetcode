package Problems;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class Prob1759 {
	
	private static String str10, str11;
	
	public static void test() {

		Path filePath = Paths.get("./TestFiles/Prob1759.dat");
			
        try { 
            List<String> lines = Files.readAllLines(filePath);
            
            for (int i=0; i<lines.size(); i++) {
            	if (!lines.get(i).equalsIgnoreCase("test_str_data_begin")) {
            		continue;
            	}//fi
            	Field field = Prob1759.class.getDeclaredField(lines.get(i+1));
            	field.set(null, lines.get(i+2));
				
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
        
		Solution1759 sol = new Solution1759();
		String str;
		
		
		str = "aaaaabbbbb";
		System.out.println(str);
		System.out.println("ans: " + sol.countHomogenous(str));
		
		str = str10;
		System.out.println(str.length());
		System.out.println("ans: " + sol.countHomogenous(str));
		//*/
		str = str11;
		System.out.println(str.length());
		System.out.println("ans: " + sol.countHomogenous(str));
		
	}// end method

	public static void main(String[] args) {
		test();

	}// end method

}

class Solution1759 {
	private static final long MOD_CONST = 1000000007;
	private static Map<Integer, Long> combinCache;
	 
	static {
		combinCache = new HashMap<>();		
		combinCache.put(2,(long) 3);
	}//end method
	
	public int countHomogenous(String s) {
		//special case, string length is 1
		if (s.length()==1) {
			return 1;
		}//fi
		long currCount = 0;
		int currCharCount = 1;
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(i)!=s.charAt(i-1)) {
				currCount += getHStrCombCount(currCharCount);
				currCharCount = 1;
			} else {
				currCharCount++;
			}//fi
		}//rof		
		currCount += getHStrCombCount(currCharCount);	
		return (int) (currCount % MOD_CONST);
	}// method
	
	/**
	 * get homogeneous string combination count
	 * precondition:
	 * required data structure is instantiated - combinCache
	 * @param strLen - int, string length
	 * @return long - homogeneous string combination count
	 */
	private long getHStrCombCount(int length) {
		Long res;
		if ((res = combinCache.get(length))!=null) {
			return res;
		}//fi
		res = (long)(length+1)*length/2;
		combinCache.put(length, res);
		return res;
	}//end method
}// end class

class Solution1759_V2 {
	private static final long MOD_CONST = 1000000007;
	private static long[] combinCache;
	 
	static {
		combinCache = new long[100001];
		combinCache[1]=1;
		combinCache[2]=3;	
	}//end method
	
	public int countHomogenous(String s) {
		//special case, string length is 1
		if (s.length()==1) {
			return 1;
		}//fi
		long currCount = 0;
		int currCharCount = 1;
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(i)!=s.charAt(i-1)) {
				currCount += getHStrCombCount(currCharCount);
				currCharCount = 1;
			} else {
				currCharCount++;
			}//fi
		}//rof		
		currCount += getHStrCombCount(currCharCount);	
		return (int) (currCount % MOD_CONST);
	}// method
	
	/**
	 * get homogeneous string combination count
	 * precondition:
	 * required data structure is instantiated - combinCache
	 * @param strLen - int, string length
	 * @return long - homogeneous string combination count
	 */
	private long getHStrCombCount(int length) {
		if (combinCache[length]!=0) {
			return combinCache[length];
		}//fi
		combinCache[length] = (long)(length+1)*length/2;
		return combinCache[length];
	}//end method
}// end class
