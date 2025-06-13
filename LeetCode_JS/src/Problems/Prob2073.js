/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
	let timeElapsed = 0;
	let personPtr = 0;
	
 	while (true) {
		for (personPtr = 0; personPtr < tickets.length; personPtr++) {
			if (personPtr === k && tickets[k] === 1) {
				timeElapsed++;
				return timeElapsed;
			} else if (tickets[personPtr] > 0){
				timeElapsed++;
				tickets[personPtr]--				
			}//fi
		}//rof
	}//end while  
};

let tickets, k;

tickets = [2,3,2];
k = 2;
console.log('ans: ' + timeRequiredToBuy(tickets, k));