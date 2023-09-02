package Utils;

import java.util.ArrayList;
import java.util.Collections;

import DataStructs.ListNode;
import DataStructs.TreeNode;

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
		while (currNode.next != null) {
			System.out.print(currNode.val + ",");
			currNode = currNode.next;
		}
		System.out.println(currNode.val + "]");
	}//end method

}
