package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob432 {
	
	static class AllOne {
		
		static final Set<String> EMPTY_SET;
		static {
			EMPTY_SET = new HashSet<>();
			EMPTY_SET.add("");
		}//end static
		Map<String, Integer> strToCntMap;
		List<Set<String>> cntToStrsArr;
		int maxInx;
		int minInx;
		int dataSize;
		
	    public AllOne() {
	    	strToCntMap = new HashMap<>();
	    	cntToStrsArr = new ArrayList<>();
	    	cntToStrsArr.add(EMPTY_SET);
	    	maxInx = 0;
	    	minInx = 0;	
	    }//end method
	    
	    public void inc(String key) {
	    	Integer cnt = strToCntMap.getOrDefault(key, 0);
	    	int newCnt = cnt+1;	    	
	    	
	    	//expand array if necessary 
    		if (cntToStrsArr.size() <= newCnt) {
    			cntToStrsArr.add(new HashSet<>());
    			maxInx++;
    		}//fi
    		
	    	//update str to new count
	    	strToCntMap.put(key, newCnt);
	    	
	    	//remove from original cnt to strs array
	    	cntToStrsArr.get(cnt).remove(key);
	    	
	    	//add to new count position in count to strings array
	    	cntToStrsArr.get(newCnt).add(key);

    		//update max index if necessary
    		if (newCnt > maxInx) {
    			maxInx = newCnt;
    		}//fi
	    	
	    	//update min index if necessary
	    	if (newCnt == 1) {
	    		minInx = 1;
	    	} else if (cntToStrsArr.get(minInx).size() == 0){
	    		minInx++;
	    	}//fi
	    	
	    	
	    }//end method
	    
	    public void dec(String key) {
	    	Integer cnt = strToCntMap.getOrDefault(key, 0);
	    	int newCnt = cnt-1;	
	    	
	    	//update str to new count, zero count is allowed	    	
	    	strToCntMap.put(key, newCnt);
	    	
	    	//remove from original cnt to strs array 
	    	cntToStrsArr.get(cnt).remove(key);

	    	//add to new count position in count to strings array 
    		if (newCnt > 0) {
    			cntToStrsArr.get(newCnt).add(key);
    		}//fi
    		
    		//update max index if necessary
	    	while (cntToStrsArr.get(maxInx).size() == 0){
	    		maxInx--;
	    	}//end while
	    	
	    	//update min index if necessary
	    	if (maxInx <= 1) {//either 0 or 1
	    		minInx = maxInx;	    	
	    	} else if (newCnt == 0) {
		    	while (cntToStrsArr.get(minInx).size() == 0){
		    		minInx++;
		    	}//end while
	    	} else if (cntToStrsArr.get(minInx).size() == 0){
	    		minInx--;
	    	}//fi
	    	
	    }//end method
	    
	    public String getMaxKey() {
	    	return cntToStrsArr.get(maxInx).iterator().next();
	        
	    }
	    
	    public String getMinKey() {
	    	return cntToStrsArr.get(minInx).iterator().next();
	    }
	    
	    public String toString() {
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("map content:\n");
	    	sb.append(this.strToCntMap);
	    	sb.append("\n");
	    	sb.append("cnt to str array: \n");
	    	sb.append(this.cntToStrsArr);
	    	sb.append("\nmaxInx:"+this.maxInx + " minInx:" + this.minInx);
	    	sb.append("\n");
	    	return sb.toString();
	    }
	}//end class

	
	

	private static void test() throws JsonMappingException, JsonProcessingException {
		
		
		String[][] inputs;
		AllOne solObj;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		inputs = objectMapper.readValue("[[], [\"hello\"], [\"hello\"], [], [], [\"leet\"], [], []]", new TypeReference<String[][]>() {});
		
		
		solObj = new AllOne();
		System.out.println("max: " + solObj.getMaxKey());
		System.out.println("min: " + solObj.getMinKey());
		solObj.inc("h");
		solObj.inc("h");
		solObj.inc("w");
		solObj.inc("w");
		solObj.inc("h");
		

		System.out.println(solObj);
		
		solObj.dec("w");
		
		
		System.out.println(solObj);
		
		/*
		solObj.inc("w");
		solObj.inc("w");
		solObj.inc("l");
		System.out.println(solObj);
		
		solObj.inc("l");
		solObj.inc("l");
		
		
		System.out.println(solObj);
		
		
		solObj.dec("w");
		solObj.dec("l");
		solObj.dec("c");
		solObj.dec("d");
		
		
		System.out.println(solObj);
		solObj.inc("n");
		solObj.inc("n");
		solObj.inc("n");
		solObj.inc("n");
		solObj.inc("n");
		solObj.inc("n");

		System.out.println(solObj);

		//*/
		
		System.out.println("max: " + solObj.getMaxKey());
		System.out.println("min: " + solObj.getMinKey());
		
		
		/*
		
		//*/


	}//end method

	public static void main(String[] args) {
		try {
			test();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
