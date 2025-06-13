
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
	//special cases: list is empty or containly only one item
	if (head === null || head.next === null) {
		return head;
	}//fi
	
	let prevNode = head;
	let currNode = head.next;
	prevNode.next = null;
	let tmpNode;
	while (currNode != null){
		//console.log('currNode: ' + currNode.val);
		tmpNode = currNode.next;
		currNode.next = prevNode;
		prevNode = currNode;
		currNode = tmpNode;		
	}//end while
	return prevNode;
};


const { buildList, displayList } = require('../Utils/ListUtils.js');


let head = buildList([1,2,3,4]);
displayList(head);
displayList(reverseList(head));    
