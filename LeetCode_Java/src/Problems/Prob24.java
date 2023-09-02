package Problems;

import java.util.*;


import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob24 {
	
	
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
		Solution24 solObj = new Solution24();
		ListNode ansList;
		buildList();
		ListUtils.displayList(testList);
		ansList = solObj.swapPairs(testList);
		ListUtils.displayList(ansList);
		System.out.println();
		
		ansList = solObj.swapPairs(null);
		ListUtils.displayList(ansList);
		System.out.println();
		
		ansList = solObj.swapPairs(testList2);
		ListUtils.displayList(ansList);
		System.out.println();		

		ansList = solObj.swapPairs(testList1);
		ListUtils.displayList(ansList);
		System.out.println();	
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	} //fi
    	ListNode newHead = head.next;
   		head.next = swapPairs(newHead.next);
   		newHead.next = head;
    	return newHead;
    }//end method
}//end class


