/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
	let nodeArr = new Array();
	for (let currNode = head; currNode != null; currNode = currNode.next) {
		nodeArr.push(currNode);
	}//rof
	let lPtr = 0;
	let rPtr = nodeArr.length - 1;
	while (lPtr < rPtr) {
		nodeArr[lPtr].next = nodeArr[rPtr];
		nodeArr[rPtr].next = nodeArr[lPtr+1];
		lPtr++;
		rPtr--;
	}//end while
	nodeArr[lPtr].next = null;
    return head;
};

const { buildList, displayList, listToString } = require('../Utils/ListUtils.js');


let head = buildList([1,2,3,4]);
displayList(head);
console.log('ans: ' + listToString(reorderList(head)));    
