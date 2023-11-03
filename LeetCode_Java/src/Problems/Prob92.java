package Problems;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob92 {
	
	public static ListNode testList, testList1;
	public static ListNode list1;
	public static ListNode list2;
	public static ListNode list3;
	public static ListNode list4;
	public static ListNode list5;
	public static ListNode list6;	
	
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
		
		list5 = new ListNode(5);
		list5 = new ListNode(4,list5);
		list5 = new ListNode(3,list5);
		list5 = new ListNode(2,list5);
		list5 = new ListNode(1,list5);

				
		
		list1 = new ListNode(5);
		
	
	}
	
	static void test() {
		ListNode currTestList;
		buildList();
		Solution92 solObj = new Solution92();
		
		
		currTestList = testList;
		ListUtils.displayList(currTestList);
		currTestList = solObj.reverseBetween(currTestList, 3,4);
		ListUtils.displayList(currTestList); 

		currTestList = list1;
		ListUtils.displayList(currTestList);
		currTestList = solObj.reverseBetween(currTestList, 1,1);
		ListUtils.displayList(currTestList); 
		//*/
		
		currTestList = list5;
		ListUtils.displayList(currTestList);
		currTestList = solObj.reverseBetween(currTestList, 1,2);
		ListUtils.displayList(currTestList); 
	}//end method
	
	public static void main(String[] args) {
		buildList();
		test();

	}

}

class Solution92 {
		
    public ListNode reverseBetween(ListNode head, int left, int right) {
    	//special case
    	if (left==right) {
    		return head;
    	}//fi
    	
    	ListNode origLeft, origLeftLeft, origRight, prevNode, currNode, nextNode;
    	
    	//step 2, traverse to left node
    	int currInx = 1;
    	origLeftLeft = origLeft = head;
    	
    	while (currInx<left) {
    		origLeftLeft = origLeft;
    		origLeft = origLeft.next;
    		currInx++;
    	}//fi
    	
    	//step 2, start swapping until right
    	nextNode = prevNode = currNode = origLeft;
    	while (currInx<=right) {
    		nextNode = currNode.next;
    		currNode.next = prevNode;
    		prevNode = currNode;
    		currNode = nextNode;
    		currInx++;
    	}//fi    	
    	origRight = prevNode;
    	
    	//step 3, link original left's next pointer to the right node's next (which is currNode from step 2)
    	origLeft.next = currNode;
    	
    	//step 4, link original left's left's next to the original right node (which is prevNode node from step 2)
    	//special case: origLeft is head
    	if (left==1) {
    		head = origRight;
    	} else {
    		origLeftLeft.next = origRight;
    	}//fi
    	

        return head;
    }//end method
	   
   
}//enc class
