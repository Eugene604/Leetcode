/**
 * @param {number[]} prices
 * @return {number[]}
 */
var finalPrices = function(prices) {
	let finalPriceArr = [];
	let discount;
	for (let i=0; i<prices.length; i++){
		discount = 0;
		for (let j=i+1; j<prices.length && discount == 0; j++){
			if (prices[j] <= prices[i]) {
				discount = prices[j];
			}//fi
		}//rof
		finalPriceArr[i] = prices[i] - discount;
	}//rof
    return finalPriceArr;
};

var testFunc = function() {
	let prices;
	
	prices = [8,4,6,2,3];
	console.log("ans: " + finalPrices(prices));
};



testFunc();
