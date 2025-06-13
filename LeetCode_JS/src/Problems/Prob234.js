/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
	let currNode = head;
	let valArr = new Array();
	while (currNode != null) {
		valArr.push(currNode.val);
		currNode = currNode.next;
	}//end while
	
	let frontInx = 0;
	let backInx = valArr.length - 1;
	while (frontInx < backInx) {
		if (valArr[frontInx] != valArr[backInx]) {
			return false;
		}//fi
		frontInx++;
		backInx--;
	}//end while
    return true;
};

const { buildList, displayList } = require('../Utils/ListUtils.js');


let head = buildList([1,2,2,1]);
displayList(head);
console.log('ans: ' + isPalindrome(head));    
