var cntArr = new Array(123);
/**
 * @param {string} s
 * @return {number}
 */
var maxDifference = function(s) {
	cntArr.fill(0,97,123);
	for (let i=0; i<s.length; i++){
		cntArr[s.charCodeAt(i)]++;
	}
	
	let maxOddFreq = 1;
	let minEvenFreq = 100;
	
	for (let i=97; i<123; i++){
		if (cntArr[i] === 0) {
			continue;
		} else if (cntArr[i]%2 === 1) {//odd frequency
			maxOddFreq = Math.max(maxOddFreq, cntArr[i]);
		} else if (cntArr[i]%2 === 0) {//even frequency
			minEvenFreq = Math.min(minEvenFreq, cntArr[i]);
		}//fi
	}
    return maxOddFreq - minEvenFreq;
};

let s;

s = "aaaaabbc"

console.log(s + ':' + ' ans: ' + maxDifference(s));

