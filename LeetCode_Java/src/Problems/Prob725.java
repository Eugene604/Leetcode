package Problems;

import DataStructs.ListNode;
import Utils.ListUtils;

public class Prob725 {
	
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
	
		
	private static void test(){
		ListNode[] ansArr;
		buildList();
		ListUtils.displayList(testList);
		Solution725 sol = new Solution725();
		ansArr = sol.splitListToParts(testList, 3);
		ListUtils.displayList(ansArr[0]); //*/
		ListUtils.displayList(ansArr[1]); //*/
		ListUtils.displayList(ansArr[2]); //*/
	}//fi
	
	public static void main(String args[]) {

		test();
	}
	
}

class Solution725 {
	
	private static ListNode[] nodeArr = new ListNode[1001];
			
    public ListNode[] splitListToParts(ListNode head, int k) {
    	ListNode[] ansArr = new ListNode[k];
    	//special case 1: head is null
    	if (head==null) {
    		return ansArr;
    	}//fi
    	//special case 2: k is 1
    	ansArr[0]=head;
    	if (k==1) {
    		return ansArr;
    	}//fi
    	
    	nodeArr[0] = head;
    	int listSize = 0;
    	do {
    		listSize++;
    		nodeArr[listSize]=nodeArr[listSize-1].next;
    	} while (nodeArr[listSize]!=null);
    	System.out.println("list size is: " + listSize);
    	
    	
    	
    	int shortGap = listSize/k;
    	int longGap = shortGap+1;
    	int numOfLongGap = listSize%k;
    	int i=1;
    	int headNodeInx=0;
    	
    	for (;i<=numOfLongGap;i++) {
    		headNodeInx+=longGap;
    		ansArr[i]=nodeArr[headNodeInx];
    		nodeArr[headNodeInx-1].next = null;
    	}//rof
    	
    	for (;i<k;i++) {
    		headNodeInx+=shortGap;
    		ansArr[i]=nodeArr[headNodeInx];
    		nodeArr[headNodeInx-1].next = null;
    	}//rof
        return ansArr;
    }//end method  
}//end class


