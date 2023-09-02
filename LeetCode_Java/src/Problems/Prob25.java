package Problems;

import java.util.*;


import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob25 {
	
	
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
		Solution25 solObj = new Solution25();
		ListNode ansList;
		buildList();
		ListUtils.displayList(testList);
		ansList = solObj.reverseKGroup(testList,3);
		ListUtils.displayList(ansList);
		System.out.println();
			
		ListUtils.displayList(testList2);
		ansList = solObj.reverseKGroup(testList2,1);
		ListUtils.displayList(ansList);
		System.out.println();		

		ansList = solObj.reverseKGroup(testList1,3);
		ListUtils.displayList(ansList);
		System.out.println();	
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}

class Solution25 {
	private static ListNode[] stackArr;
	private static int stackSize = -1;
	private int lastStackElementInx = -1;
    public ListNode reverseKGroup(ListNode head, int k) {
    	initStack(k);
        return reverseKNode(head, k);
    }//end method
    
    /**
     * 
     * @param head ListNode type, it is assumed that head is not null
     * @param k
     * @return
     */
    private ListNode reverseKNode(ListNode head, int k) {
    	ListNode currNode = head;
    	int i = 0;
    	do {
    		push(currNode);
    		currNode = currNode.next;
    		i++;
    	} while (i<k && currNode != null);//end do while
    	//special case: left out nodes
    	if (i!=k) {
    		return head; // do nothing
    	}//fi
    	
    	ListNode nextOfTail = currNode;
    	ListNode newHead = pop();
    	currNode = newHead;
    	i--;
    	for (;i>0; i--) {
    		currNode.next = pop();
    		currNode = currNode.next;
    	}//rof
    	
    	if (nextOfTail == null) {
    		currNode.next = null; //do nothing
    	} else {
    		currNode.next = reverseKNode(nextOfTail, k);
    	}//fi
    	return newHead;
    }//end method
    
    /**
     * Precondition: it is assumed that number of push calls is not greater than stack size
     * @param node ListNode type
     */
    private void push(ListNode node) {
    	stackArr[++lastStackElementInx] = node;
    }//end method
    
    
    /**
     * 
     * @return null if stack is empty
     */
    private ListNode pop() {
    	if (lastStackElementInx < 0) {
    		return null;
    	} else {
    		return stackArr[lastStackElementInx--];
    	}//fi
    }//end method
    
    /**
     * 
     * @param k stack size
     */
    private void initStack(int k) {
    	if (k > stackSize) {
    		stackArr = new ListNode[k];
    	}//fi
    	stackSize = k;
    	lastStackElementInx = -1;
    }//end method
}//end class


