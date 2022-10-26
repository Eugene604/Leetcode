package Problems;

public class Prob2095 {
	
	public static ListNode testList;
	public static final ListNode END_NODE = new ListNode(-9999);
	
	static void buildList() {
		testList = new ListNode(6);
		testList = new ListNode(2,testList);
		testList = new ListNode(1,testList);
		testList = new ListNode(7,testList);
		testList = new ListNode(4,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(1,testList);
		testList = new ListNode(5,testList);
		testList = new ListNode(3,testList);
		testList = new ListNode(7,testList);
		testList = new ListNode(4,testList);
		testList = new ListNode(6,testList);
		testList = new ListNode(5,testList);		
		
	}
	
	static void displayList() {
		System.out.print("[");
		ListNode currNode =  testList;
		while (currNode.next != null) {
			System.out.print(currNode.val + ",");
			currNode = currNode.next;
		}
		System.out.println(currNode.val + "]");
	}
	
	static void nodeIndexTest() {
		int listLength, middleInx, preMiddleInx;
		listLength = 1;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 2;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 3;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 4;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 5;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 6;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 7;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 8;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);
		listLength = 9;
		middleInx = (int) Math.floor(listLength/2);
		preMiddleInx = middleInx-1;		
		System.out.println("Length:" + listLength + " Middle Index:" + middleInx + " pre Mid Index:" + preMiddleInx);

		
	}
	
	
	public static void main(String args[]) {
		
		buildList();
		displayList();
		Solution2095 sol = new Solution2095();
		sol.deleteMiddle(testList);
		displayList(); //*/
		//nodeIndexTest();
	}
	
}

class Solution2095 {
    public ListNode deleteMiddleV1(ListNode head) {
    	int stepCount = -1;
    	ListNode preMidNode = head;
    	ListNode currNode = head;
    	while(currNode.next != null) {
    		//System.out.println("curr node:" + currNode.val + " pre Mid Node:" + preMidNode.val);
    		stepCount++;
    		if (stepCount>1) {
    			stepCount = 0;
    			preMidNode = preMidNode.next;
    		}
    		currNode = currNode.next;
    			
    	}   
    	//System.out.println("curr node:" + currNode.val + " pre Mid Node:" + preMidNode.val);
    	
    	currNode = preMidNode.next; 
    	//special case, only one node exists, delete entire list
    	if (currNode == null) {
    		head = null;
    		return head;
    	} else {
    		currNode = currNode.next;
    		preMidNode.next = currNode;
    	}       	
		return head;
		
    }
    
    public ListNode deleteMiddle(ListNode head) {
    	//special case, only one node exists, delete entire list
    	if (head.next == null) {
    		head = null;
    		return head;    
    	}
    	ListNode preMidNode = head;
    	ListNode currNode = head.next;
    	ListNode nextNode = currNode.next;
    	
    	while(currNode.next != null && nextNode.next != null) {
    		System.out.println("curr node:" + currNode.val + " pre Mid Node:" + preMidNode.val);
    		currNode = nextNode.next;
    		nextNode = currNode.next;
       		preMidNode = preMidNode.next;  			
    	}      	
    	System.out.println("curr node:" + currNode.val + " pre Mid Node:" + preMidNode.val);
    	currNode = preMidNode.next.next;
    	preMidNode.next = currNode;	
		return head;	    	
    }    
}

/*
 Definition for singly-linked list.
 */
/*
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { 
    	 this.val = val; 
    	 this.next = next; 
    }
 } //*/

