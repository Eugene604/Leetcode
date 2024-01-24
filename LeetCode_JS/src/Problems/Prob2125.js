/**
 * @param {string[]} bank
 * @return {number}
 */
var numberOfBeams = function(bank) {
	let numOfPrevLasers = 0, numOfCurrLasers;
	let beamCnt = 0;
	for (let row of bank){		
		numOfCurrLasers = numOfOnes(row);
		if (numOfCurrLasers === 0){
			continue;
		}//fi
		beamCnt += numOfPrevLasers*numOfCurrLasers;
		numOfPrevLasers = numOfCurrLasers;
	}//rof
    return beamCnt;
};

/**
 * @param {string} bStr - string that contains only 0 and 1
 * @return {number} number of ones 
 */
var numOfOnes = function(bStr) {
	let cnt = 0;
	/*
	for (let char of bStr){
		if (char === '1'){
			cnt++;
		}//rof
	}//rof */
	
	for (let i = 0; i<bStr.length; i++){
		if (bStr[i] === '1'){
			cnt++;
		}//rof
	}//rof */
    return cnt;
};

var bank1 = ["011001","000000","010100","001000"];
var bank2 = ["000","111","000"];



let bank;
bank = bank1;

console.log("ans : " + numberOfBeams(bank));
