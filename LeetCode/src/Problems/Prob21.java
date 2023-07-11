package Problems;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob21 {
	
	
	public static ListNode testList, testList1, testList2, testList3;
	
	
	static void buildList() {
		testList = new ListNode(63);
		testList = new ListNode(22,testList);
		testList = new ListNode(12,testList);
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
		
		
		testList1 = new ListNode(6);
		testList1 = new ListNode(5, testList1);
		
		testList2 = new ListNode(8);
		
		testList3 = null;
	
		
	}
	
	static void test() {
		Solution21 solObj = new Solution21();
		ListNode ansList;
		buildList();
		ListUtils.displayList(testList);
		ListUtils.displayList(testList1);	
		ansList = solObj.mergeTwoLists(testList, testList1);
		ListUtils.displayList(ansList);
		System.out.println();
		
		ListUtils.displayList(testList2);
		ListUtils.displayList(testList3);
		
		ansList = solObj.mergeTwoLists(testList2, testList3);
		ListUtils.displayList(ansList);
		System.out.println();
		
		ansList = solObj.mergeTwoLists(testList3, testList3);
		ListUtils.displayList(ansList);
		System.out.println();
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution21 {
	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode head = null;
    	ListNode currNode;
    	//first phase, decide head node and process special cases where either or both list is null
    	if (list1 != null && list2 != null) {
    		if (list1.val <= list2.val) {
    			head = list1;
    			list1 = list1.next;
    		} else {
    			head = list2;
    			list2 = list2.next;
    		}//fi
    		currNode = head;
    	} else if (list1==null && list2 == null) {
    		return null;
    	} else if (list1==null) {
    		return list2;
    	} else {
    		return list1;
    	}//fi
    	
    	//second phase, process rest nodes from both lists
    	while ((list1 != null && list2 != null)) {
    		if (list1.val <= list2.val) {
    			currNode.next = list1;    			
    			list1 = list1.next;
    		} else {
    			currNode.next = list2;
    			list2 = list2.next;
    		}//fi
    		currNode = currNode.next;
    	}//end while
    	
    	//phase three, one list has been process completely, just append another one
    	if (list1==null) {
    		currNode.next = list2;
    	} else {
    		currNode.next = list1;
    	}//fi
        return head;
    }//end method
}//end class


