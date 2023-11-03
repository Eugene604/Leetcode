package Problems;

import java.util.*;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob141 {
	
	
	public static ListNode testList1, testList2, testList3, testList4;
	
	
	static void buildList() {
		ListNode tail;
		testList4 = new ListNode(63);
		tail = testList4;
		testList4 = new ListNode(22,testList4);
		testList4 = new ListNode(12,testList4);
		testList4 = new ListNode(7,testList4);
		testList4 = new ListNode(4,testList4);
		testList4 = new ListNode(3,testList4);
		testList4 = new ListNode(3,testList4);
		testList4 = new ListNode(3,testList4);
		testList4 = new ListNode(1,testList4);
		tail.next = testList4;
		testList4 = new ListNode(-1,testList4);
		testList4 = new ListNode(-5,testList4);
		testList4 = new ListNode(-12,testList4);
		testList4 = new ListNode(-20,testList4);	
		
		
		testList1 = new ListNode(6);
		testList1 = new ListNode(5, testList1);
		
		testList2 = new ListNode(8);
		
		testList3 = null;
	
		
	}
	
	static void test() {
		Solution141 solObj = new Solution141();
		ListNode testList; 
		buildList();
		
		testList = testList4;
		ListUtils.displayList(testList);
		System.out.println("contains loop? " + solObj.hasCycle(testList));

		testList = testList3;
		ListUtils.displayList(testList);
		System.out.println("contains loop? " + solObj.hasCycle(testList));
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}


class Solution141 {
	
    public boolean hasCycle(ListNode head) {
    	Set<ListNode> travelledSet = new HashSet<>();
		if (head == null) {			
			return false;
		}//fi
		ListNode currNode =  head;
		while (currNode.next != null) {
			if (!travelledSet.add(currNode)) {
				return true;
			}//fi		
			currNode = currNode.next;
		}//end while
        return false;
    }//end method
}//end class

class Solution141_v2 {
	
    public boolean hasCycle(ListNode head) {    	
		if (head == null) {			
			return false;
		}//fi
		ListNode currNode =  head;
		int count=0;
		while (currNode.next != null) {			
			currNode = currNode.next;
			count++;
			if (count>100001) {
				return true;
			}//fi
		}//end while
        return false;
    }//end method
}//end class



