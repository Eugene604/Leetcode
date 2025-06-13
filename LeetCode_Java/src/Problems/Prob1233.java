package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.MatrixUtils;


public class Prob1233 {


	static void test() {
		

		Solution1233 solObj = new Solution1233();
		
		String[] folder;
        try {
            ObjectMapper mapper = new ObjectMapper();         
            
            
            folder = mapper.readValue("[\"/c/d/e\",\"/a\",\"/a/b\",\"/c/d\",\"/c/f\"]", new TypeReference<String[]>() {});
            

    		System.out.println(Arrays.toString(folder));
    		System.out.println("ans: " + solObj.removeSubfolders(folder));
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
		
		
	}//end method


	
	public static void main(String[] args) {
		test();

	}

}

class Solution1233 {
	
    public List<String> removeSubfolders(String[] folder) {
    	Arrays.sort(folder);
    	//System.out.println(Arrays.toString(folder));
    	List<String> ansList = new ArrayList<>(folder.length/2);
    	ansList.add(folder[0]);
    	int ansLength = 1;
    	
    	FOLDER_LOOP:
    	for (int i=1; i<folder.length; i++) {
    		for (int ansLInx = 0; ansLInx < ansLength; ansLInx++) {
    			if (isAncestorFolder(ansList.get(ansLInx), folder[i])) {
    				continue FOLDER_LOOP;
    			}//fi
    		}//rof
			ansList.add(folder[i]);
			ansLength++;
    	}//rof
    	
        return ansList;
    }//end method
    
    /**
     * Checks if the shorterPath is an ancestor of the longerPath.
     *
     *
     * @param shorterPath - String, The path of the potential ancestor folder.
     * @param longerPath -String, The path of the folder to check against.
     * @return boolean, true if shorterPath is an ancestor of longerPath; false otherwise.
     */
    private boolean isAncestorFolder(String shorterPath, String longerPath) {
    	//System.out.println("check: " + shorterPath + " : " + longerPath );
    	if (!longerPath.startsWith(shorterPath)) {
    		return false;
    	} else if (shorterPath.length() == longerPath.length()) {
    		return true;
    	} else if (longerPath.charAt(shorterPath.length()) == '/') {
    		return true;
    	} else {
    		return false;
    	}//fi
    	
    }//end method
        
}// end class
