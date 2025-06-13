/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} minutes
 * @return {number}
 */
var maxSatisfied = function(customers, grumpy, minutes) {
	let baseSatisfaction = 0;
	for (let i=0; i<grumpy.length; i++){
		if (grumpy[i]===0) {
			baseSatisfaction += customers[i];	
		}
		
	}//rof
	//console.log('haha	1: ' + baseSatisfaction);
	
	let currSatBoost = 0;
	for (let i=0; i<minutes; i++){
		if (grumpy[i]===1){
			currSatBoost += customers[i];
		}//rof
	}//rof
	
	
	let maxSatBoost = currSatBoost;
	//console.log('haha: ' + maxSatBoost);
	
	for (let leftInx = 1, rightInx = leftInx+minutes-1; rightInx < grumpy.length; rightInx++, leftInx++){
		if (grumpy[leftInx-1]===1){
			currSatBoost -= customers[leftInx-1];			
		}
		if (grumpy[rightInx]===1){
			currSatBoost += customers[rightInx];
		}
		
		maxSatBoost = Math.max(maxSatBoost, currSatBoost);
		//console.log(maxSatBoost);
	}//rof
	
    return baseSatisfaction + maxSatBoost;
};

var testFunc = function() {
	let customers, grumpy, minutes;
	
	/*
	customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3;

	console.log("ans: " + JSON.stringify(maxSatisfied(customers, grumpy, minutes)));
	//*/
	
	
	customers = [556,116,10,515,108,764,97,735,997,978,767,723,357,2,406,552,864,140,222,390,28,816,369,786,294,92,839,335,426,234,614,895,201,299,163,170,510,674,697,841,152,487,607,232,638,843,347,386,44,673];
	grumpy = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1];
	minutes = 1;

	console.log("ans: " + JSON.stringify(maxSatisfied(customers, grumpy, minutes)));

};



testFunc();
