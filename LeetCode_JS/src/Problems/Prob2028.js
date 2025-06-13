/**
 * @param {number[]} rolls
 * @param {number} mean
 * @param {number} n
 * @return {number[]}
 */
var missingRolls = function(rolls, mean, n) {
	let rollTotal;
	let nTotal;
	
	//step 1, get roll total;
	rollTotal = rolls.reduce((sum, cur) => sum + cur, 0);
	
	//step 2, get remainding values, which is equal to nTotal
	nTotal = mean*(n+rolls.length) - rollTotal;
	
	//console.log('nTotal: ' + nTotal);
	
	//step 3, determine if anser is possible:
	if (nTotal < n || nTotal > 6*n){
		return [];
	}//fi
	//step 4, if possible, populate ans array
	let lowerBound = Math.floor(nTotal/n);
	let additionalRolls = new Array(n).fill(lowerBound);
	nTotal -= lowerBound*n;
	let i=0;
	while (nTotal > 0){
		additionalRolls[i]++;
		nTotal--;
		i++;
		if(i === n){
			i=0;
		}//fi
		//console.log("additionalRolls: " + JSON.stringify(additionalRolls));
	}//end while
    return additionalRolls;
};
 
let rolls, mean, n;

rolls=[3,2,4,3], mean=4, n=2;
console.log("ans: " + JSON.stringify(missingRolls(rolls, mean, n)));

/*


//*/

