package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob1436 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		String path1 = "[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]";
		String path2 = "[[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]";
		String path3 = "[[\"A\",\"Z\"]]";
				
				
		Solution1436 solObj = new Solution1436();
		List<List<String>> path;

		ObjectMapper objectMapper = new ObjectMapper();

        path = objectMapper.readValue(path1, new TypeReference<List<List<String>>>() {});;
		System.out.println(path);
		System.out.println("ans: " + solObj.destCity(path));
		
        path = objectMapper.readValue(path2, new TypeReference<List<List<String>>>() {});;
		System.out.println(path);
		System.out.println("ans: " + solObj.destCity(path));
		
        path = objectMapper.readValue(path3, new TypeReference<List<List<String>>>() {});;
		System.out.println(path);
		System.out.println("ans: " + solObj.destCity(path));
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

class Solution1436 {

	public String destCity(List<List<String>> paths) {
		Set<String> origSet = new HashSet<>();
		Set<String> destSet = new HashSet<>();
		String orig, dest;
		for (List<String> path:paths) {
			orig = path.get(0);
			if (!destSet.remove(orig)) {
				origSet.add(orig);
			}//fi
			
			dest = path.get(1);
			if (!origSet.remove(dest)) {
				destSet.add(dest);
			}//fi
								
		}//rof
		//System.out.println("origSet: " + origSet);
		//System.out.println("destSet: " + destSet);
		return destSet.iterator().next();
	}// end method

}// end class
