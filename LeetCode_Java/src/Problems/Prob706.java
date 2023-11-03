package Problems;

import java.util.*;
import java.util.Map.Entry;

public class Prob706 {

	private static final int OUTER_TABLE_SIZE = 0b100000000000;
	private static final int OUTER_TABLE_INX_SHIFT = 11;	
	private static final int INNER_TABLE_SIZE = 0b1000000000;	
	private static final int INNER_TABLE_MASK = 0b111111111;	
	
	public static void test2() {
		int i = 1000000;
		System.out.println("c: " + Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("c: " + Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("OUTER_TABLE_SIZE: " + OUTER_TABLE_SIZE);
		System.out.println("INNER_TABLE_SIZE: " + INNER_TABLE_SIZE);
		
		System.out.println("i: " + Integer.toBinaryString(i));
	}//end method
	
	public static void test() {

		MyHashMap testMap = new MyHashMap();
		testMap.put(157, 493);
		int param2 = testMap.get(157);
		testMap.remove(157);
		System.out.println(param2);
		

		testMap.put(1000000, 52);
		int param3 = testMap.get(1000000);
		testMap.remove(1);
		System.out.println(param3);
		
		testMap.put(1000000, 1000000);
		
		testMap.remove(1000000);
		testMap.remove(1000000);
		testMap.remove(1000000);
		testMap.put(1000000, 1000000);
		testMap.put(1000000, 22000);
		int param4 = testMap.get(1000000);
		System.out.println(param4);
	}// end method

	public static void main(String[] args) {
		test();
		//test2();
	}// end method

}

class MyHashMap {
	
	private static final int VALUE_MASK = 0b11111111111111111111;
	private static final int USAGE_MASK = 0b11111111111100000000000000000000;	
	private static final int USAGE_INCREMENT = 0b00000000000100000000000000000000;
	private static final int USAGE_LIMIT = 0b111111111111;
	
	private static final int OUTER_TABLE_SIZE = 0b100000000000;
	private static final int OUTER_TABLE_INX_SHIFT = 9;	
	private static final int INNER_TABLE_SIZE = 0b1000000000;	
	private static final int INNER_TABLE_MASK = 0b111111111;	
		
	private static int[][] hashTable = new int[OUTER_TABLE_SIZE][];
	private static int currUsage = USAGE_INCREMENT;
	
	public MyHashMap() {
		/*
		if (currUsage==USAGE_LIMIT) {
			hashTable = new int[OUTER_TABLE_SIZE];
			currUsage = USAGE_INCREMENT;
		} else {
			currUsage+=USAGE_INCREMENT;
		}//fi		*/
		currUsage+=USAGE_INCREMENT;
	}//end constructor

	public void put(int key, int value) {
		int outerInx = key>>OUTER_TABLE_INX_SHIFT;
		if (hashTable[outerInx]==null) {
			hashTable[outerInx] = new int[INNER_TABLE_SIZE];
		}//fi
		hashTable[outerInx][key&INNER_TABLE_MASK]=value+currUsage;
	}//end method

	public int get(int key) {
		int outerInx = key>>OUTER_TABLE_INX_SHIFT;
		if (hashTable[outerInx]==null) {
			return -1;
		}//fi
		int innerInx = key&INNER_TABLE_MASK; 
		if((hashTable[outerInx][innerInx]&USAGE_MASK)!=currUsage) {
			return -1;
		} else {
			return hashTable[outerInx][innerInx]&VALUE_MASK;
		}//fi
	}//end method

	public void remove(int key) {
		int outerInx = key>>OUTER_TABLE_INX_SHIFT;
		if (hashTable[outerInx]==null) {
			return;
		}//fi
		hashTable[outerInx][key&INNER_TABLE_MASK]=USAGE_INCREMENT;
	}//end method
}//end class


class MyHashMap_v2 {
	
	private static final int VALUE_MASK = 0b11111111111111111111;
	private static final int USAGE_MASK = 0b11111111111100000000000000000000;	
	private static final int USAGE_INCREMENT = 0b00000000000100000000000000000000;
	private static final int USAGE_LIMIT = 0b111111111111;
	
	private static final int INNER_TABLE_MASK = 0b1111111111;	
		
	private static int[] hashTable = new int[1000001];
	private static int currUsage = USAGE_INCREMENT;
	
	public MyHashMap_v2() {
		/*
		if (currUsage==USAGE_LIMIT) {
			hashTable = new int[1000001];
			currUsage = USAGE_INCREMENT;
		} else {
			currUsage+=USAGE_INCREMENT;
		}//fi		*/
		currUsage+=USAGE_INCREMENT;
	}//end constructor

	public void put(int key, int value) {
		hashTable[key]=value+currUsage;
	}//end method

	public int get(int key) {
		if((hashTable[key]&USAGE_MASK)!=currUsage) {
			return -1;
		} else {
			return hashTable[key]&VALUE_MASK;
		}//fi
	}//end method

	public void remove(int key) {
		hashTable[key]=USAGE_INCREMENT;
	}//end method
}//end class