package Problems;

import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prob2353 {

	private static void test() throws JsonMappingException, JsonProcessingException {
		String foods1 = "[\"kimchi\",\"miso\",\"sushi\",\"moussaka\",\"ramen\",\"bulgogi\"]";
		String cuisines1 = "[\"korean\",\"japanese\",\"japanese\",\"greek\",\"japanese\",\"korean\"]";
		String ratings1 = "[9,12,8,15,14,7]";
		
		String foods2 = "[\"opjbeacqz\",\"ndoisu\",\"ezp\",\"kmhb\",\"kidvuljw\",\"fnfte\",\"egozmbx\",\"yupk\",\"pwzaqdobu\",\"vvyaebh\"]";
		String cuisines2 = "[\"jtciksnma\",\"seyzb\",\"jtciksnma\",\"jtciksnma\",\"zxqtm\",\"jtciksnma\",\"jtciksnma\",\"zxqtm\",\"zxqtm\",\"jtciksnma\"]";
		String ratings2 = "[44756,38356,91049,5190,9505,37300,29881,6135,11915,55747]";
		
		String[] foods, cuisines;
		int[] ratings;
				


		ObjectMapper objectMapper = new ObjectMapper();

		/*
		foods = objectMapper.readValue(foods1, new TypeReference<String[]>() {});
		cuisines = objectMapper.readValue(cuisines1, new TypeReference<String[]>() {});
		ratings = objectMapper.readValue(ratings1, new TypeReference<int[]>() {});
		//*/
		
		foods = objectMapper.readValue(foods2, new TypeReference<String[]>() {});
		cuisines = objectMapper.readValue(cuisines2, new TypeReference<String[]>() {});
		ratings = objectMapper.readValue(ratings2, new TypeReference<int[]>() {});		
		FoodRatings solObj = new FoodRatings(foods, cuisines, ratings);
		System.out.println("ans1: " + solObj.highestRated("jtciksnma"));
		solObj.changeRating("ezp", 473);
		solObj.changeRating("opjbeacqz", 66491);
		solObj.changeRating("egozmbx", 57983);
		System.out.println("ans2: " + solObj.highestRated("jtciksnma"));
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

class FoodRatings {
	Map<String, String> foodCuisineMap;
	Map<String, Integer> foodRatingMap;
	//Map< cusine name, Tree< rating, set of food >>
	Map<String, TreeMap<Integer, TreeSet<String>>> cusineMap;
	
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    	foodCuisineMap = new HashMap<>();
    	foodRatingMap = new HashMap<>();
    	cusineMap = new HashMap<>();
    	TreeMap<Integer, TreeSet<String>> ratingFoodMap;
    	TreeSet<String> foodSet;
    	for (int i=0; i<foods.length; i++) {
    		foodCuisineMap.put(foods[i], cuisines[i]);
    		foodRatingMap.put(foods[i], ratings[i]);
    		if ((ratingFoodMap = cusineMap.get(cuisines[i]))==null) {
    			ratingFoodMap = new TreeMap<>();
    			cusineMap.put(cuisines[i], ratingFoodMap);
    		}//fi
    		if ((foodSet = ratingFoodMap.get(ratings[i]))==null) {
    			foodSet = new TreeSet<>();
    			ratingFoodMap.put(ratings[i], foodSet);
    		}//fi
    		foodSet.add(foods[i]);
    	}//rof
    	/*
    	System.out.println("foodCuisineMap: " + foodCuisineMap);
    	System.out.println("foodRatingMap: " + foodRatingMap);
    	System.out.println("cusineMap: " + cusineMap); //*/
    }//end constructor
    

    
    public void changeRating(String food, int newRating) {
    	//System.out.println("cusineMap before: " + cusineMap);
        Integer origRating = foodRatingMap.get(food);
        String cusine = foodCuisineMap.get(food);
        TreeMap<Integer, TreeSet<String>> ratingFoodMap =  cusineMap.get(cusine);
        TreeSet<String> foodSet = ratingFoodMap.get(origRating);       
        if (foodSet.size()>1) {
        	foodSet.remove(food);        	
        } else {
        	ratingFoodMap.remove(origRating); 
        }//fi
		if ((foodSet = ratingFoodMap.get(newRating))==null) {
			foodSet = new TreeSet<>();
			ratingFoodMap.put(newRating, foodSet);
		}//fi
		foodSet.add(food);
		foodRatingMap.put(food, newRating);
		//System.out.println("cusineMap after: " + cusineMap);
    }//end method
    
    public String highestRated(String cuisine) {

    	return cusineMap.get(cuisine).lastEntry().getValue().first();

    }//end method
    
    
}// end class
