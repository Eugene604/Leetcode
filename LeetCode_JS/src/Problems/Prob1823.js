/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var findTheWinner = function(n, k) {
	//special case: k=1
	if (k===1){
		return n;
	}//fi
	let currQueue, nextQueue;
	let playerInx;
	let localK;
	//step 1, generate first round
	currQueue = [];
	playerInx = 1;
	localK = 0;
	while (playerInx <= n){
		localK++;
		if (localK === k){
			localK = 0;
		} else {
			currQueue.push(playerInx);			
		}//fi
		playerInx++;
	}//end while
	
	//step 2, simulate rest of rounds
	playerInx = 0;
	nextQueue = [];
	while (currQueue.length > 1){
		localK++;
		if (localK === k){
			localK = 0;
		} else {
			nextQueue.push(currQueue[playerInx]);						
		}//fi
		playerInx++;
		if (playerInx === currQueue.length){
			playerInx = 0;
			currQueue = nextQueue;
			nextQueue = [];
		}//fi
	}//end while
    return currQueue[0];
};

var testFunc = function() {
	let n,k;
	
	n = 5, k = 2;

	console.log("ans: " + findTheWinner(n,k));
};



testFunc();
