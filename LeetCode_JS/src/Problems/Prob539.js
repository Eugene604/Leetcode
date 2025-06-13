/**
 * @param {string[]} timePoints
 * @return {number}
 */
var findMinDifference = function(timePoints) {
	let smallMinArr = []; //store mins from 0:00~24:00
	let bigMinArr = []; //store mins from 12:00~36:00 (first 12 + 24hr)
	let hr, min, totalMin;
	for (let timeStr of timePoints){
		let [hrStr, minStr] = timeStr.split(':');
		hr = parseInt(hrStr);
		min = parseInt(minStr);
		totalMin = hr*60+min;
		if (totalMin<720) {//0:00~12:00
			smallMinArr.push(totalMin);
			bigMinArr.push(totalMin+1440);
		} else {//12:00~24:00
			smallMinArr.push(totalMin);
			bigMinArr.push(totalMin);
		}//fi
		//console.log(hrStr);
	}//rof
	
	smallMinArr.sort((a,b)=>a-b);
	bigMinArr.sort((a,b)=>a-b);
	//console.log(smallMinArr);
	let minDiff = 14400;
	for (let i=1; i<smallMinArr.length; i++){
		minDiff = Math.min(smallMinArr[i] - smallMinArr[i-1], minDiff);
		minDiff = Math.min(bigMinArr[i] - bigMinArr[i-1], minDiff);
	}//rof
    return minDiff;
};

let timePoints;

timePoints = ["01:01","02:01","03:00"];
console.log('ans: ' + findMinDifference(timePoints));
 
