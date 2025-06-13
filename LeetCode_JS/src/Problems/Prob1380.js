/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var luckyNumbers  = function(matrix) {
	let ansArr = [];
	let minValOfRow = [];
	let findMinEleOfRow = function(rowInx){
		if (minValOfRow[rowInx]){
			return minValOfRow[rowInx];
		}//fi
		let minNum = Number.MAX_VALUE;
		for (let i=0; i<matrix[rowInx].length; i++){
			minNum = Math.min(minNum, matrix[rowInx][i]);
		}//rof
		minValOfRow[rowInx] = minNum;
		return minNum;
	};//end method
	
	let maxNumInCol;
	let maxNumRowInx;
	/**
     * Finds the minimum element of a given row in the matrix.
     *
     * @param {number} rowInx - The index of the row to find the minimum element in.
     * @return {number} - The minimum element in the specified row.
     */
	for (let colInx = 0; colInx<matrix[0].length; colInx++){	
		maxNumInCol = -1;
		for (let rowInx = 0; rowInx<matrix.length; rowInx++){
			if (matrix[rowInx][colInx] > maxNumInCol){
				maxNumInCol = matrix[rowInx][colInx];
				maxNumRowInx = rowInx;
			}//fi
		}//rof
		if (maxNumInCol === findMinEleOfRow(maxNumRowInx)){
			ansArr.push(maxNumInCol);
		}//fi
	}//rof
    return ansArr;
};

var matrix;

matrix = [[3,7,8],[9,11,13],[15,16,17]];
console.log("ans: " + JSON.stringify(luckyNumbers(matrix)));

process.exit(0); 
