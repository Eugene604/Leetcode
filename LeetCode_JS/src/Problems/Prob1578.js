/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function(colors, neededTime) {
	let subTotalCost = neededTime[0];
	let maxSingleCost = neededTime[0];
	let totalCost = 0;
    for (let i=1; i< colors.length; i++){
		if (colors[i-1] != colors[i]){
			totalCost += subTotalCost-maxSingleCost;
			subTotalCost = neededTime[i];
			maxSingleCost = neededTime[i];					
		} else {
			subTotalCost += neededTime[i];
			if (maxSingleCost < neededTime[i]){
				maxSingleCost = neededTime[i];
			}//fi			
		}//fi
	}//rof
    totalCost += subTotalCost-maxSingleCost;
    return totalCost;
    
};



var color1 = "abaac";
var color2 = "aabaa";
var color3 = "hmerry";

var nTime1 = [1,2,3,4,5];
var nTime2 = [1,2,3,4,1];
var nTime3 = [131,533,763,830,429,612];

let color, nTime;
color = color3;
nTime = nTime3;
console.log("ans: " + minCost(color, nTime));




