package Problems;

import java.util.*;

import DataStructs.Node;
import Utils.ListUtils;

public class Prob138 {
	
	
	public static Node testList1, testList2, testList3, testList4;
	
	
	static void buildList() {
		Node tmpeNode;
		testList4 = new Node(63);
		testList4 = new Node(22,testList4);
		tmpeNode = testList4;
		testList4 = new Node(12,testList4);
		testList4 = new Node(7,testList4);
		testList4.random = tmpeNode;
		testList4 = new Node(4,testList4);
		tmpeNode = testList4;
		testList4 = new Node(3,testList4);
		testList4 = new Node(3,testList4);
		testList4.random = tmpeNode;
		tmpeNode = testList4;
		testList4 = new Node(3,testList4);
		testList4 = new Node(1,testList4);
		testList4.random = tmpeNode;
		testList4 = new Node(-1,testList4);
		tmpeNode = testList4;
		testList4 = new Node(-5,testList4);
		testList4.random = tmpeNode;
		testList4 = new Node(-12,testList4);
		tmpeNode = testList4;
		testList4 = new Node(-20,testList4);	
		testList4.random = tmpeNode;
		
		
		testList1 = new Node(6);
		testList1 = new Node(5, testList1);
		
		testList2 = new Node(8);
		
		testList3 = null;
	
		
	}
	
	static void test() {
		Solution138 solObj = new Solution138();
		Node testList, newlyCopiedList; 
		buildList();
		
		testList = testList4;
		ListUtils.displayListWithRandomNext(testList);
		newlyCopiedList = solObj.copyRandomList(testList);
		ListUtils.displayListWithRandomNext(newlyCopiedList);
	}
	
		
		
	
	public static void main(String args[]) {
		test();
	}
	
}


class Solution138 {
	
    public Node copyRandomList(Node head) {
    	if (head==null) {
    		return null;
    	}//fi
    	
    	Map<Node, Node> origNewNodeMap = new HashMap<>();
    	
    	//1st step, specially process head node, ignoring random pointer
    	Node newHead = new Node(head.val);
		origNewNodeMap.put(head, newHead);
		
		//2nd step, populate rest of nodes, ignoring random pointer
    	Node currOrigNode = head;
    	Node currNewNode = newHead;
    	while ((currOrigNode = currOrigNode.next) != null) {
    		currNewNode.next = new Node(currOrigNode.val);
    		currNewNode = currNewNode.next; 
    		origNewNodeMap.put(currOrigNode, currNewNode);
    	}//end while
    	
    	//3rd step, reestablish random pointers
    	currOrigNode = head;
    	currNewNode = newHead;
    	do {
    		if (currOrigNode.random != null) {
    			currNewNode.random = origNewNodeMap.get(currOrigNode.random);
    		}//fi       		
    		currOrigNode = currOrigNode.next;
    		currNewNode = currNewNode.next;
    	}while(currOrigNode != null);//end do-while
    	
        return newHead;
    }//end method
}//end class





