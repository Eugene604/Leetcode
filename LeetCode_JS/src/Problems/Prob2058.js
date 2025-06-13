const MAX_DIST = 1_000_000;
/**
 * @param {ListNode} head
 * @return {number[]}
 */
var nodesBetweenCriticalPoints = function(head) {

	if (head.next === null){
		return [-1, -1];
	}//fi
	
	let firstCPInx;
	let prevCPInx;
	let currInx = 1;
	let currNode = head.next;
	let prevTrend;
	let nextTrend = head.next.val - head.val ;

	//step 1, get first critical point
	while (currNode.next != null){
		prevTrend = nextTrend;
		nextTrend = currNode.next.val - currNode.val;
		if (prevTrend>0 && nextTrend<0 || prevTrend<0 && nextTrend>0){
			firstCPInx = currInx;
			prevCPInx = currInx;
			break;
		}//fi
		currNode = currNode.next;
		currInx++;
	}//end while
	
	if (currNode.next === null){
		return [-1, -1];
	}//fi
	//console.log('after step 1: ' + firstCPInx);
	
	
	//step 2, get subsequent critical point
	currNode = currNode.next;
	currInx++;
	let ansArr = [MAX_DIST,-1];
	while (currNode.next != null){
		prevTrend = nextTrend;
		nextTrend = currNode.next.val - currNode.val;
		if (prevTrend>0 && nextTrend<0 || prevTrend<0 && nextTrend>0){		
			ansArr[0] = Math.min(ansArr[0], currInx - prevCPInx);			
			prevCPInx = currInx;
		}//fi
		currInx++;
		currNode = currNode.next;
	}//end while
	//console.log('after step 2: ' + prevCPInx);
	
	//step 3, finalize
	if (ansArr[0] === MAX_DIST){
		return [-1, -1];
	} else {
		ansArr[1] = prevCPInx - firstCPInx;
		return ansArr;
	}//fi
    
};

const { buildList, displayList, listToString } = require('../Utils/ListUtils.js');


let head = buildList([5,3,1,2,5,1,2]);
displayList(head);
console.log('ans: ' + JSON.stringify(nodesBetweenCriticalPoints(head)));    
