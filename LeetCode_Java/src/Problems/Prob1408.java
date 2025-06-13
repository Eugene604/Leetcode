package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1408 {


	static void test() {
		

		Solution1408 solObj = new Solution1408();
		
		String[] words;
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            /*
            words = mapper.readValue("[\"mass\",\"as\",\"hero\",\"superhero\"]", new TypeReference<String[]>() {});
    		System.out.println(Arrays.toString(words));
    		System.out.println("ans: " + solObj.stringMatching(words));
    		//*/

            
            words = mapper.readValue("[\"leetcodeeeeeeee\",\"efse\",\"esfe\",\"fes\", \"sef\",\"eff\",\"se\",\"ef\", \"sem\", \"you\", \"yu\", \"o\", \"pen\", \"si\", \"enp\", \"p\", \"e\", \"n\", \"goal\", \"ol\", \"lol\", \"al\", \"midgo\"]", new TypeReference<String[]>() {});
    		System.out.println(Arrays.toString(words));
    		System.out.println("ans: " + solObj.stringMatching(words));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution1408 {
	
    public List<String> stringMatching(String[] words) {
    	List<String> ansList = new ArrayList<>();
    	boolean[] isAdded = new boolean[words.length];
    	String longerWrd, shorterWrd;
    	int shorterWrdInx;
    	for (int i = 0; i < words.length - 1; i++) {
    		if (isAdded[i]) {
    			continue;
    		}//fi
    		for (int j = i+1; j < words.length; j++) {
    			if (words[i].length() > words[j].length()) {
    				longerWrd = words[i];
    				shorterWrd = words[j];
    				shorterWrdInx = j;
    			} else if (words[i].length() < words[j].length()) {
    				longerWrd = words[j];
    				shorterWrd = words[i];
    				shorterWrdInx = i;
    			} else {
    				continue;
    			}//fi
    			if (!isAdded[shorterWrdInx] && longerWrd.indexOf(shorterWrd) != -1) {
    				ansList.add(shorterWrd);
    				isAdded[shorterWrdInx] = true;
    			}//fi
    		}//rof
    	}//rof
    	return ansList;
    }//end method
            
}// end class
