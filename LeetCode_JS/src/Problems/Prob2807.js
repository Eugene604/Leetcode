const ListNode = require('../DataStructs/ListNode.js');

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertGreatestCommonDivisors = function(head) {
	let currNode, prevNode;
	/**
	 * @param {number} a - First number
	 * @param {number} b - Second number
	 * @return {number} - The greatest common divisor (GCD) of a and b
	 * 
	 * This function calculates the greatest common divisor (GCD) of two numbers using the 
	 * Euclidean algorithm. It works by repeatedly replacing the larger number with the remainder 
	 * of dividing the larger number by the smaller number until the remainder is zero. 
	 * The GCD is the last non-zero remainder.
	 */
	let getGCD = function(a,b){
		let greater, smaller;
		if (a>b) {
			greater = a;
			smaller = b;
		} else {
			greater = b;
			smaller = a;
		}//fi
		
		let tmp;
		while (smaller!==0){
			tmp = smaller;
			smaller = greater % smaller;
			greater = tmp; 
		}//end method
		return greater;
	};//end method
	
	prevNode = head;
	currNode = head.next;
	while (currNode !== null){
		prevNode.next = new ListNode(getGCD(prevNode.val, currNode.val), currNode);
		prevNode = currNode;
		currNode = currNode.next;
	}//end while
    return head;
};
const { buildList, displayList, listToString } = require('../Utils/ListUtils.js');


let head;

head = buildList([18,6,10,3]);
displayList(head);
displayList(insertGreatestCommonDivisors(head)); 
