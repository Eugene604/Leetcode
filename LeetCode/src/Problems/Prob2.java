package Problems;

public class Prob2 {
	
	public static ListNode list1;
	public static ListNode list2;
	public static ListNode list3;
	public static ListNode list4;
	public static ListNode list5;
	public static ListNode list6;	
	
	static void buildList() {
		list1 = new ListNode(1);
		list1 = new ListNode(9,list1);
		list1 = new ListNode(9,list1);
		
		list2 = new ListNode(4);
		list2 = new ListNode(6,list2);
		list2 = new ListNode(5,list2);
		
		list3 = new ListNode(1);
		list4 = new ListNode(8);
		
		list5 = new ListNode(9);
		list5 = new ListNode(9,list5);
		list5 = new ListNode(9,list5);
		list5 = new ListNode(9,list5);
		list5 = new ListNode(9,list5);
		list5 = new ListNode(9,list5);
		list5 = new ListNode(9,list5);		
		
		list6 = new ListNode(9);
		list6 = new ListNode(9,list6);
		list6 = new ListNode(9,list6);		
		list6 = new ListNode(9,list6);		
	}
	
	static void displayList(ListNode head) {
		System.out.print("[ ");
		ListNode currNode =  head;
		while (currNode.next != null) {
			System.out.print(currNode.val + " -> ");
			currNode = currNode.next;
		}
		System.out.println(currNode.val + " ]");
	}
	
	public static void main(String[] args) {
		buildList();
		displayList(list1);
		displayList(list3);
		Solution2 sol = new Solution2();
		ListNode solHead = sol.addTwoNumbers(list1, list3);
		displayList(solHead);

	}

}

class Solution2 {
		
	public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
		int tmpSum;
		int co = 0; //carry over
		ListNode ansList = l1; // use list 1 as answer list
		//first phase, add first node of two list
		tmpSum = l1.val + l2.val;
		if (tmpSum > 9) {
			co = 1;
			l1.val = tmpSum%10;
		} else {
			co = 0;
			l1.val = tmpSum;
		}
		
		//second phase, when both lists are available
		while (l1.next != null && l2.next != null) {
			l1 = l1.next;
			l2 = l2.next;
			tmpSum = co + l1.val + l2.val;
			if (tmpSum > 9) {
				co = 1;
				l1.val = tmpSum%10;
			} else {
				co = 0;
				l1.val = tmpSum;
			}
		}//end while
		
		//third phase, both lists reach end or one list is still available
		if (l1.next == null) { //list 1 is depleted, in this case make rest of list 2 to list 1
			l1.next = l2.next;
		}//fi;
		//now, only list 1 is considered, try adds back carry over
		while (co > 0) {
			if (l1.next != null) { //list 1 still has nodes 
				l1 = l1.next;
				tmpSum = co + l1.val;
		    	if (tmpSum > 9) {
		    		co = 1;
		    		l1.val = tmpSum%10;
		    	} else {
		    		l1.val = tmpSum;
		    		return ansList;
		    	}//fi
			} else { //list 1 also depleted		
				l1.next = new ListNode(co);
				return ansList;
			}//fi		        	
		}//end while   	
		return ansList;     
	}
	   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int tmpSum;
    	int co = 0; //carry over
    	ListNode ansList = new ListNode();
    	ListNode currAnsNode = ansList;
    	//first phase, add first node of two list
    	tmpSum = l1.val + l2.val;
    	if (tmpSum > 9) {
    		co = 1;
    		currAnsNode.val = tmpSum%10;
    	} else {
    		co = 0;
    		currAnsNode.val = tmpSum;
    	}
    	//second phase, when both lists are available
    	while (l1.next != null && l2.next != null) {
    		l1 = l1.next;
    		l2 = l2.next;
    		tmpSum = co + l1.val + l2.val;

        	if (tmpSum > 9) {
        		co = 1;
        		currAnsNode.next = new ListNode(tmpSum%10);
        	} else {
        		co = 0;
        		currAnsNode.next = new ListNode(tmpSum);
        	}
        	currAnsNode = currAnsNode.next;
    	}//end while
    	
    	//third phase, when only one list is available
		if (l2.next == null) { //only list 1 has nodes, in this case try loops through list 2
	    	while (l1.next != null) {
	    		l1 = l1.next;
	    		tmpSum = co + l1.val;
	        	if (tmpSum > 9) {
	        		co = 1;
	        		currAnsNode.next = new ListNode(tmpSum%10);
	        	} else {
	        		co = 0;
	        		currAnsNode.next = new ListNode(tmpSum);
	        	}
	        	currAnsNode = currAnsNode.next;
	    	}//end while
		} else if (l1.next == null) { //only list 2 has nodes, in this case try loops through list 1
	    	while (l2.next != null) {
	    		l2 = l2.next;
	    		tmpSum = co + l2.val;
	        	if (tmpSum > 9) {
	        		co = 1;
	        		currAnsNode.next = new ListNode(tmpSum%10);
	        	} else {
	        		co = 0;
	        		currAnsNode.next = new ListNode(tmpSum);
	        	}
	        	currAnsNode = currAnsNode.next;
	    	}//end while			
		 
		}//fi;
		
		//final phase, check if there is carry over
		if (co > 0) {
			currAnsNode.next = new ListNode(co);			
    	}
    	
		return ansList;     
    }	
}

/*
 Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { 
    	 this.val = val; 
    	 this.next = next; 
    }
 }