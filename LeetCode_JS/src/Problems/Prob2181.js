/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var mergeNodes = function(head) {
	let currNode = head.next;
	let prevSegHead = head;
	let currSum = 0;
	while (currNode.next !== null){
		if (currNode.val === 0) {
			prevSegHead.val = currSum;
			prevSegHead = prevSegHead.next;
			currSum = 0;
		} else {
			currSum += currNode.val;			
		}//fi
		//console.log('currSum: ' + currSum);
		currNode = currNode.next;
	}//end while
	prevSegHead.val = currSum;
	prevSegHead.next = null;
    return head;
};

const { buildList, displayList } = require('../Utils/ListUtils.js');


let head = buildList([0,1,0,3,0,2,2,0]);
displayList(head);
displayList(mergeNodes(head));    
