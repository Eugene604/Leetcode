package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob380 {
	
	
	
	public static void test() {
		RandomizedSet rSet = new RandomizedSet();
		rSet.insert(2);
		rSet.insert(2);
		rSet.insert(7);
		rSet.insert(7);
		System.out.println(rSet);
		rSet.remove(2);
		rSet.remove(2);
		System.out.println(rSet);
		rSet.remove(7);
		System.out.println(rSet);	
		rSet.remove(7);
		System.out.println(rSet);		
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		System.out.println(rSet.getRandom());
		
	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {
	
	private Map<Integer, Integer> valInxMap;
	private List<Integer> valList;
	private int nextAvailInx;
    public RandomizedSet() {
    	valInxMap = new HashMap<>(65536);
    	valList = new ArrayList<>(65536);
    	nextAvailInx = 0;
    }//end constructor
    
    public boolean insert(int val) {
    	if (valInxMap.containsKey(val)) {
    		return false;
    	}//fi
    	int valInx = nextAvailInx;
    	if (valList.size() == nextAvailInx) {
    		valList.add(val);    		
    	} else {
    		valList.add(valInx, val);
    	}//fi
    	nextAvailInx++;
    	valInxMap.put(val, valInx);
    	return true;        
    }//end method
    
    public boolean remove(int val) {
    	Integer valInx = valInxMap.get(val);    	
    	if (valInx == null) {
    		return false;
    	}//fi
    	valList.set(valInx, valList.get(nextAvailInx-1));
   		valInxMap.put(valList.get(valInx), valInx);
    	valInxMap.remove(val);
   		nextAvailInx--;
    	return true;    	
    }//end method
    
    public int getRandom() {
    	int randInx = (int) (Math.random()*nextAvailInx);
        return valList.get(randInx);
    }//end method
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("LIST: ");
    	sb.append(valList.toString());
    	sb.append(" Next available index: ");
    	sb.append(nextAvailInx);
    	sb.append('\n');
    	sb.append("MAP: ");
    	sb.append(valInxMap.toString());
    	return sb.toString();
    }//end method
}//end class





 