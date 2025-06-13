/**
 * @param {number} n
 * @param {number} time
 * @return {number}
 */
var passThePillow = function(n, time) {
	let numOfPassInOneRound = n-1;
	let quotient = Math.floor(time/numOfPassInOneRound);
	let remainder = time%numOfPassInOneRound;
	let direction = quotient % 2;
	//console.log('quotient: ' + quotient);
	//console.log('remainder: ' + remainder);
	if (direction === 0) {//from front
		return remainder + 1;	
	} else {//front back
		return n - remainder;
	}//fi
    
};

let n, time;
n = 4, time = 5;
console.log('ans: ' + passThePillow(n, time));    
