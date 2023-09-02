package Problems;

import java.util.*;


import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob23 {
	
	
	public static ListNode testList, testList1, testList2, testList3, testList4, testList5;
	public static ListNode[] lists;
	
	
	static void buildList() {
		testList = new ListNode(63);
		testList = new ListNode(22,testList);
		testList = new ListNode(8,testList);
		testList = new ListNode(7,testList);
		testList = new ListNode(4,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(1,testList);
		testList = new ListNode(-1,testList);
		testList = new ListNode(-5,testList);
		testList = new ListNode(-12,testList);
		testList = new ListNode(-20,testList);	
		
		testList1 = new ListNode(8);
		testList1 = new ListNode(7, testList1);
		testList1 = new ListNode(5, testList1);
		testList1 = new ListNode(3, testList1);
		
		testList2 = new ListNode(8);
		
		testList3 = new ListNode(1);
		
		testList4 = new ListNode(1);
		
		testList5 = new ListNode(1);
	
		lists = new ListNode[9];
		lists[0] = testList;
		lists[1] = testList1;
		lists[2] = null;
		lists[3] = testList2;
		lists[4] = testList3;
		lists[5] = null;
		lists[6] = testList4;
		lists[7] = testList5;
		lists[8] = null;
		
	}
	
	static void test() {
		Solution23 solObj = new Solution23();
		ListNode ansList;
		buildList();
		//ListUtils.displayList(testList);
		//ListUtils.displayList(testList1);	
		ansList = solObj.mergeKLists(lists);
		ListUtils.displayList(ansList);
		System.out.println();
		
				
	
		System.out.println();
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution23 {
	private static Map<Integer, Integer> valCountMap = new TreeMap<>();
	
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode resultList = null;
    	
    	//special case 1, lists is null
    	if (lists == null) {
    		return resultList;
    	}//fi
    	
    	int firstNonNullInx = 0;
        for (; firstNonNullInx < lists.length; firstNonNullInx++) {
        	if (lists[firstNonNullInx] != null) {
        		resultList = lists[firstNonNullInx];
        		break;
        	}//fi
        }//rof
        
        //special case 2, lists is not null but contains only null element
        if (resultList == null) {
        	return resultList;
        }//fi
        
        //first phase, iterate through every list, concatenate them and also count occurrence of each value
    	valCountMap.clear();
        ListNode currNode = lists[firstNonNullInx];
        Integer currValCount, integerOne = Integer.valueOf(1);
        while (currNode.next != null) {
        	currValCount = valCountMap.get(currNode.val);
        	currValCount = (currValCount == null) ? integerOne : ++currValCount ;
        	valCountMap.put(currNode.val, currValCount);
        	currNode = currNode.next;
        };//end while
        
        
        for (int i = firstNonNullInx+1; i < lists.length; i++) {
        	if (lists[i] == null) {
        		continue;
        	}//rof
        	
        	currNode.next = lists[i];
            while (currNode.next != null) {          	
            	currValCount = valCountMap.get(currNode.val);          
            	currValCount = (currValCount == null) ? integerOne : ++currValCount;
            	valCountMap.put(currNode.val, currValCount);
            	currNode = currNode.next;
            };//end while        
        }//rof
        currValCount = valCountMap.get(currNode.val);
        currValCount = (currValCount == null) ? integerOne : ++currValCount;
        valCountMap.put(currNode.val, currValCount);

        //System.out.println(valCountMap);
        
        //second phase, iterate through the concatenated list and update the value
        currNode = resultList;
        int tmpVal, tmpCount;
        for (Map.Entry<Integer, Integer> entry:valCountMap.entrySet()) {
        	tmpVal = entry.getKey();
        	tmpCount = entry.getValue();
        	for (; tmpCount>0; tmpCount--) {
        		currNode.val = tmpVal;
        		currNode = currNode.next;
        	}//rof    	
        }//rof
        
    	return resultList;
    }//end method
}//end class


