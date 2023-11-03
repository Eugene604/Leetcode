package Utils;

import java.util.ArrayList;
import java.util.Collections;

import DataStructs.*;


public class ListUtils {
	
		
	
	static {
		
	}
	
	
	/**
	 * display the list given head
	 * @param head head node of ListNode type
	 */
	public static void displayList(ListNode head) {
		System.out.print("[");
		if (head == null) {
			System.out.println("]");
			return;
		}//fi
		ListNode currNode =  head;
		int count = 0;
		while (currNode.next != null && ++count < 50) {
			System.out.print(currNode.val + ",");
			currNode = currNode.next;
		}
		System.out.println(currNode.val + "]");
		if (count == 50) {
			System.out.println("warning: seems to be infinite loop");
		}//fi
	}//end method

	public static void displayListWithRandomNext(Node head) {
		System.out.print("[");
		if (head == null) {
			System.out.println("]");
			return;
		}//fi
		Node currNode =  head;
		int count = 0;
		while (currNode.next != null && ++count < 50) {
			System.out.print("(");
			System.out.print(currNode.val + "," + ((currNode.random==null)?" ":currNode.random.val));
			currNode = currNode.next;
			System.out.print("),");
		}
		System.out.println("(" + currNode.val  + "," + ((currNode.random==null)?" ":currNode.random.val) + ")]");
		if (count == 50) {
			System.out.println("warning: seems to be infinite loop");
		}//fi
	}//end method
}
