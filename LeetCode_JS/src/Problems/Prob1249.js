/**
 * @param {number[][]} customers
 * @return {number}
 */
var averageWaitingTime = function(customers) {
	let currTime = 0;
	let totalWaitingTime = 0;
	for (let i=0; i<customers.length; i++){
		if (customers[i][0] < currTime){
			currTime += customers[i][1];
		} else {
			currTime = customers[i][0] + customers[i][1];
		}//fi
		totalWaitingTime += currTime - customers[i][0];
	}//rof
    return totalWaitingTime/customers.length;
};


 
let customers;

customers = [[1,2],[2,5],[4,3]];


console.log("ans: " + averageWaitingTime(customers));

