/**
 * @param {number[]} original
 * @param {number} m
 * @param {number} n
 * @return {number[][]}
 */
var construct2DArray = function(original, m, n) {
	let twoDArr = [];
	if (m*n !== original.length) {
		return twoDArr;
	}//fi
	
	let inx = 0;
	for (let rowInx=0; rowInx < m; rowInx++){
		twoDArr[rowInx] = [];
		for (let colInx=0; colInx<n; colInx++){
			twoDArr[rowInx][colInx] = original[inx];
			inx++;
		}//rof
	}//rof
    return twoDArr;
};

var testFunc = function() {
	
	let original, m, n;
	
	original = [1,2,3,4], m = 2, n = 2;
		

	console.log("ans: " + JSON.stringify(construct2DArray(original, m, n)));
	
};



testFunc();

