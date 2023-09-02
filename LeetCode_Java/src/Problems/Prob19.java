package Problems;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob19 {
	
	public static ListNode testList, testList1;
	
	
	static void buildList() {
		testList = new ListNode(6);
		testList = new ListNode(2,testList);
		testList = new ListNode(1,testList);
		testList = new ListNode(7,testList);
		testList = new ListNode(4,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(9,testList);
		testList = new ListNode(5,testList);
		testList = new ListNode(12,testList);
		testList = new ListNode(17,testList);
		testList = new ListNode(-5,testList);
		testList = new ListNode(-2,testList);
		testList = new ListNode(0,testList);	
		
		
		testList1 = new ListNode(6);
		testList1 = new ListNode(5, testList1);
	
		
	}
	
		
		
	
	public static void main(String args[]) {
		ListNode ansList;
		buildList();
		ListUtils.displayList(testList);
		Solution19 sol = new Solution19();
		ansList = sol.removeNthFromEnd(testList, 13);
		ListUtils.displayList(ansList); //*/
		//nodeIndexTest();
	}
	
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode preNthNode = head;
    	ListNode currNode = head.next;
    	//special case 1, only one node exists, delete entire list
    	if (currNode == null) {
    		head = null;
    		return head;  		
    	}//fi
    	
    	//step one, move currNode n steps further away
    	while (n > 1) {
    		currNode = currNode.next;
    		n--;
    	};
    	  	
    	if (currNode == null) {
    		//special case 2, whole length is used, remove the head and return the next node as head
    		return preNthNode.next;
    	}//end if
    	
    	
    	//System.out.println("pre n node is: " + preNthNode.val + " currNode is:  " + currNode.val);
    	
    	//step two, traverse currNode to end of list along with preNthNode
    	while (currNode.next != null) {
    		currNode = currNode.next;
    		preNthNode = preNthNode.next;
    	}//end while
    	
    	preNthNode.next = preNthNode.next.next;
    	
    	    	
        return head;    	
    }//end method  
}//end class


