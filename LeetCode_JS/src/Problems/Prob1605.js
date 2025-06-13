const MatrixUtils = require('../Utils/MatrixUtils.js');



/**
 * @param {number[]} rowSum
 * @param {number[]} colSum
 * @return {number[][]}
 */
var restoreMatrix = function(rowSum, colSum) {
	
	let matrix = Array.from({ length: rowSum.length }, () => Array(colSum.length).fill(0));
	ROW_LOOP:
	for (let rowInx = 0, colStartingInx = 0; rowInx < rowSum.length; rowInx++){
		for (let colInx = colStartingInx; colInx < colSum.length; colInx++){
			if (rowSum[rowInx] < colSum[colInx]) { 
				matrix[rowInx][colInx] = rowSum[rowInx];
				colSum[colInx] -= rowSum[rowInx];
				continue ROW_LOOP;			
			} else {
				matrix[rowInx][colInx] = colSum[colInx];		
				rowSum[rowInx] -= colSum[colInx];
				colStartingInx++;
			}//fi
		}//rof
	}//rof
	
			
  	return matrix;  
};

let rowSum, colSum, ansMat;

rowSum = [1,1,6], colSum = [5,3];
ansMat  = restoreMatrix(rowSum, colSum);
console.log('ans: ');
MatrixUtils.displayMatrix(ansMat);

rowSum = [5,7,10], colSum = [8,6,8];
ansMat = restoreMatrix(rowSum, colSum);
console.log('ans: ');
MatrixUtils.displayMatrix(ansMat);

/*


rowSum = [5,7,10], colSum = [8,6,8];
let ansMat = restoreMatrix(rowSum, colSum);
console.log('ans: ');
MatrixUtils.displayMatrix(ansMat);


rowSum = [3,8], colSum = [4,7];
let ansMat = restoreMatrix(rowSum, colSum);
console.log('ans: ');
MatrixUtils.displayMatrix(ansMat);

//*/



//TLE
/**
 * @param {number[]} rowSum
 * @param {number[]} colSum
 * @return {number[][]}
 */
var restoreMatrix = function(rowSum, colSum) {
	let rowPrefixSumMat = Array.from({ length: rowSum.length }, () => Array.from({ length: colSum.length+1 }, () => 0));
	let colPrefixSumMat = Array.from({ length: rowSum.length+1 }, () => Array.from({ length: colSum.length }, () => 0));
	let matrix = Array.from({ length: rowSum.length }, () => Array.from({ length: colSum.length }, () => 0));
	let lastColInx = colSum.length - 1;
	let lastRowInx = rowSum.length - 1;
	
	//MatrixUtils.displayMatrix(rowPrefixSumMat);
	//MatrixUtils.displayMatrix(colPrefixSumMat);
	
   /**
     * Set the value of the matrix at the specified row and column indices.
     * Preconditions:
     * - Assumes the following data structures exist and are valid: rowSum, colSum.
     * - Assumes the following data structures exist and are properly initialized: rowPrefixSumMat, colPrefixSumMat, matrix.
     * - Assumes index values are valid.
     * Postconditions:
     * - The specified matrix value is set only when the specified value adheres to col & row sum rules.
     * - In the case of an illegal value, prefix sum arrays will NOT be reverted.
     * @param {number} rowInx - The row index.
     * @param {number} colInx - The column index.
     * @param {number} value - The value to set in the matrix.
     * @return {boolean} - Returns true if the value was set successfully, otherwise false.
     */
	let setMatrixVal = function(rowInx, colInx, value){
		//console.log('try set ' + rowInx + ':' + colInx + ' as ' + value);
		rowPrefixSumMat[rowInx][colInx+1] = rowPrefixSumMat[rowInx][colInx] + value;
		if (colInx === lastColInx) {			
			if (rowPrefixSumMat[rowInx][colInx+1] !== rowSum[rowInx]){
				return false;
			}//fi
		} else {			
			if (rowPrefixSumMat[rowInx][colInx+1] > rowSum[rowInx]) {
				return false;
			}//fi
		}//fi
		colPrefixSumMat[rowInx+1][colInx] = colPrefixSumMat[rowInx][colInx] + value;
		//console.log('colPrefixSumMat :');
		//MatrixUtils.displayMatrix(colPrefixSumMat);
		if (rowInx === lastRowInx) {			
			if (colPrefixSumMat[rowInx+1][colInx] !== colSum[colInx]){
				console.log('return false 1');
				return false;
			}//fi
		} else {			
			if (colPrefixSumMat[rowInx+1][colInx] > colSum[colInx]) {
				return false;
			}//fi
		}//fi
		matrix[rowInx][colInx] = value;
		return true;
	};//end method
	
	
    /**
     * Find a valid value for the matrix at the specified row and column indices.
     * Preconditions:
     * - Assumes the following data structures exist and are valid: rowPrefixSumMat, colPrefixSumMat.
     * - Assumes index values are valid.
     * @param {number} rowInx - The row index.
     * @param {number} colInx - The column index.
     * @return {boolean} - Returns true if a valid value was found and set, otherwise false.
     */
	let findValM = function(rowInx, colInx) {
		//console.log('enter findValM ' + rowInx + ':' + colInx);
		//MatrixUtils.displayMatrix(rowPrefixSumMat);
		//MatrixUtils.displayMatrix(colPrefixSumMat);
		
		if (rowInx === lastRowInx && colInx === lastColInx) {//matrix' last val, only one val is possible
			//console.log(' matrix last val, only one val is possible' );
			return setMatrixVal(rowInx, colInx, rowSum[rowInx] - rowPrefixSumMat[rowInx][colInx]) ? true : false;	
		} else if (rowInx === lastRowInx) {//last row, only one val is possible			
			if (setMatrixVal(rowInx, colInx, colSum[colInx] - colPrefixSumMat[rowInx][colInx])) {
				return findValM(rowInx, colInx+1);
			} else {
				return false;
			}//fi	
		} else if (colInx === lastColInx) {//last col, only one val is possible			
			if (setMatrixVal(rowInx, colInx, rowSum[rowInx] - rowPrefixSumMat[rowInx][colInx])) {
				return findValM(rowInx+1, 0);
			} else {
				return false;
			}//fi			
		}//fi
		
		

		
		//when reaching here, it means current indices are located some where not at lower / right edges
		let maxVal = rowSum[rowInx] - rowPrefixSumMat[rowInx][colInx];
		//console.log('reaching here 1 :' + rowInx + ':' + colInx + ' maxVal:' + maxVal);
		maxVal = Math.min(maxVal, colSum[colInx] - colPrefixSumMat[rowInx][colInx]);
			
		for (let value = 0; value <= maxVal; value++){
			if (setMatrixVal(rowInx, colInx, value) && findValM(rowInx, colInx+1)) {
				return true;
			}//fi

		}//rof
		
		return false;					
		
	};//end method
	
		
	
	//console.log('function returns: ' + findValM(0,0));
						
	findValM(0,0);
			
  	return matrix;  
};
