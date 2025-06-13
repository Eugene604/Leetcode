/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function(numBottles, numExchange) {
	let bottlesDrank = numBottles;
	let emptyBottles = numBottles;
	let exchangedBottles;
	while (emptyBottles >= numExchange){
		exchangedBottles = Math.floor(emptyBottles/numExchange);		
		bottlesDrank += exchangedBottles;
		emptyBottles = (emptyBottles%numExchange) + exchangedBottles;
	}//end while
    return bottlesDrank;
    
};

var testFunc = function() {
	let numBottles, numExchange;
	
	numBottles = 9, numExchange = 3

	console.log("ans: " + numWaterBottles(numBottles, numExchange));
};



testFunc();
