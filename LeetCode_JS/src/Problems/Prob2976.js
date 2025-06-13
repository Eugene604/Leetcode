const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {string} source
 * @param {string} target
 * @param {character[]} original
 * @param {character[]} changed
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(source, target, original, changed, cost) {
	const MAX_DIST = 1_000_000_000;
	let costM = Array.from({ length: 26 }, () => Array.from({ length: 26 }, () => MAX_DIST));
	let isConversionSrcChar = new Array(26).fill(false);
	let isConversionDestChar = new Array(26).fill(false);
    //step 1: build Floyd-Warshall cost matrix and also conversion source and destination character arrays
    for (let i=0; i<26; i++){
		costM[i][i] = 0;
	}//rof
	
	let srcCharInx, destCharInx;
	for (let i=0; i<original.length; i++){
		srcCharInx = original[i].charCodeAt(0)-97;
		destCharInx = changed[i].charCodeAt(0)-97;
		if (costM[srcCharInx][destCharInx] > cost[i]){
			costM[srcCharInx][destCharInx] = cost[i];
			isConversionSrcChar[srcCharInx] = true;
			isConversionDestChar[destCharInx] = true;	
		}//fi		
	}//rof
	
	//console.log('initial M');
    //MatrixUtils.displayMatrix(costM);
    	
	let tmpCost;
	for (let c = 0; c < 26; c++) {
		for (let i = 0; i < 26; i++) {
		    for (let j = 0; j < 26; j++) {
				tmpCost = costM[i][c] + costM[c][j];
		        if (costM[i][j] > tmpCost) {
		            costM[i][j] = tmpCost;
		        }//rof
		    }//rof
		}//rof		
		//console.log('m after c=:' + c);
    	//MatrixUtils.displayMatrix(costM);
    }//rof
	//console.log('m after c=:' + c);
    //MatrixUtils.displayMatrix(costM);
    
    let totalCost = 0;
    for (let i=0; i<target.length; i++){
		srcCharInx = source[i].charCodeAt(0)-97;
		destCharInx = target[i].charCodeAt(0)-97;
		if (srcCharInx === destCharInx) {
			//do nothing
		} else if (!isConversionSrcChar[srcCharInx]){
			return -1;
		} else if (!isConversionDestChar[destCharInx]){
			return -1;
		} else if (costM[srcCharInx][destCharInx] === MAX_DIST) {
			return -1;
		} //fi
		
		totalCost += costM[srcCharInx][destCharInx];
	}//rof
    return totalCost;
};


let source, target, original, changed, cost;

source = "adbaabacdc", target = "bccbbadcdc";
original = ["c","b","b","d","c","a","b"];
changed = ["b","a","c","a","a","d","d"];
cost = [5,2,6,1,7,7,1];
console.log('ans: ' + minimumCost(source, target, original, changed, cost));


/*
source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2];
console.log('ans: ' + minimumCost(source, target, original, changed, cost));
//*/