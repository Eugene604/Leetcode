package Problems;

import java.util.*;

public class Prob392 {
	

	
	public static void test() {

		Solution392 sol = new Solution392();
		String s, t;
		
		
		
		s = "abcd"; 
		t = "abcde";
		System.out.println("ans: " + sol.findTheDifference(s,t) + ", " + s + " : " + t);
		
		s = ""; 
		t = "y";
		System.out.println("ans: " + sol.findTheDifference(s,t) + ", " + s + " : " + t);

		s = ""; 
		t = " ";
		System.out.println("ans: " + sol.findTheDifference(s,t) + ", " + s + " : " + t);
			//*/
		
		s = "hauwehhfweuuowhwefguwowhfiauivbvnrwoanjksansdjkhfuweiohiguwhweoaigewfauiohfewuaohwauviobhvwauiohfewaiuohwiaougauiowauiowehfwoaiuhfouiawehofuiwaehioufeawhiauowehfiwuoaehfiowauehahkjlshkjlsvbwiuehfwoiauhiuowehhfhhgiowahoiwhofiwehoewaihijvawbnwhfwiaouehoauiwehfaoewiuhfpahawuphewfahawfeoihoauiwhufaiowhuaiowhiwaohfueaiowhawuiohwfaeouihewafoihewfauiohwefaouihewaoiuhfewaiouhewaiouhefwaiouhewafhaweuiofhewaiohawoihwefauiofwheauiohwafeuohawefiohwuaefiohfuaiwehvaiwohafwuioehhauwehhfweuuowhwefguwowhfiauivbvnrwoanjksansdjkhfuweiohiguwhweoaigewfauiohfewuaohwauviobhvwauiohfewaiuohwiaougauiowauiowehfwoaiuhfouiawehofuiwaehioufeawhiauowehfiwuoaehfiowauehahkjlshkjlsvbwiuehfwoiauhiuowehhfhhgiowahoiwhofiwehoewaihijvawbnwhfwiaouehoauiwehfaoewiuhfpahawuphewfahawfeoihoauiwhufaiowhuaiowhiwaohfueaiowhawuiohwfaeouihewafoihewfauiohwefaouihewaoiuhfewaiouhewaiouhefwaiouhewafhaweuiofhewaiohawoihwefauiofwheauiohwafeuohawefiohwuabefiohfuaiwehvaiwohafwuioeh"; 
		t = "hauwehhfweuuowhwefguwowhfiauivbvnrwoanjksansdjkhfuweiohiguwhweoaigewfauiohfewuaohwauviobhvwauiohfewaiuohwiaougauiowauiowehfwoaiuhfouiawehofuiwaehioufeawhiauowehfiwuoaehfiowauehahkjlshkjlsvbwiuehfwoiauhiuowehhfhhgiowahoiwhofiwehoewaihijvawbnwhfwiaouehoauiwehfaoewiuhfpahawuphewfahawfeoihoauiwhufaiowhuaiowhiwaohfueaiowhawuiohwfaeouihewafoihewfauiohwefaouihewaoiuhfewaiouhewaiouhefwaiouhewafhaweuiofhewaiohawoihwefauiofwheauiohwafeuohawefiohwuabefiohfuaiwehvaiwohafwuioehhauwehhfweuuowhwefguwowhfiauivbvnrwoanjksansdjkhfuweiohiguwhweoaigewfauiohfewuaohwauviobhvwauiohfewaiuohwiaougauiowauiowehfwoaiuhfouiawehofuiwaehioufeawhiauowehfiwuoaehfiowauehahkjlshkjlsvbwiuehfwoiauhiuowehhfhhgiowahoiwhofiwehoewaihijvawbnwhfwiaouehoauiwehfaoewiuhfpahawuphewfahawfeoihoauiwhufaiowhuaiowhiwaohfueaiowhawuiohwfaeouihewafoihewfauiohwefaouihewaoiuhfewaiouhewaiouhefwaiouhewafhaweuiofhewaiohawoihwefauiofwheauiohwafeuohawefiohwuabefiohfuaiwehvaiwohafwuioeh";
		System.out.println("ans: " + sol.findTheDifference(s,t) + ", " + s + " : " + t);
	}//end method
	
	
	
	public static void main(String[] args) {
		test();

	}//end method
	
}


class Solution392 {
	
	int[] sCountArr;
	int[] tCountArr;
	
    public char findTheDifference(String s, String t) {
    	//special case, s has 0 length
    	if (s.length()==0) {
    		return t.charAt(0);
    	}//fi
    	
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();    	
    	sCountArr = new int[26];
    	tCountArr = new int[26];
    	
    	int i;
    	for (i=0; i<sArr.length; i++) {
    		sCountArr[sArr[i]-'a']++;
    		tCountArr[tArr[i]-'a']++;
    	}//rof
    	tCountArr[tArr[i]-'a']++;
    	
    	for (i=0; i<26; i++) {
    		if (sCountArr[i]!=tCountArr[i]) {
    			return (char)('a'+i);
    		}//fi
    	}//rof
    	return ' ';
    }//end method

    
}//end class

class Solution392_v2 {
	
    public char findTheDifference(String s, String t) {
    	//special case, s has 0 length
    	if (s.length()==0) {
    		return t.charAt(0);
    	}//fi
    	
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();
    	
    	Arrays.sort(tArr);
    	Arrays.sort(sArr);

    	int i;
    	for (i=0; i<sArr.length; i++) {
    		if (tArr[i]!=sArr[i]) {
    			return tArr[i];
    		}//fi
    	}//rof
    	return tArr[i];
    }//end method

    
}//end class
