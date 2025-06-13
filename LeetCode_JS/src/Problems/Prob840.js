const MatrixUtils = require('../Utils/MatrixUtils.js');

const MAG_MAT_ARR = [];
{
	MAG_MAT_ARR.push([[4, 9, 2], [3, 5, 7], [8, 1, 6]]);
	MAG_MAT_ARR.push([[2, 9, 4], [7, 5, 3], [6, 1, 8]]);
	MAG_MAT_ARR.push([[8, 1, 6], [3, 5, 7], [4, 9, 2]]);
	MAG_MAT_ARR.push([[6, 1, 8], [7, 5, 3], [2, 9, 4]]);
	MAG_MAT_ARR.push([[4, 3, 8], [9, 5, 1], [2, 7, 6]]);
	MAG_MAT_ARR.push([[8, 3, 4], [1, 5, 9], [6, 7, 2]]);
	MAG_MAT_ARR.push([[6, 7, 2], [1, 5, 9], [8, 3, 4]]);
	MAG_MAT_ARR.push([[2, 7, 6], [9, 5, 1], [4, 3, 8]]);
}

/**
 * @param {number[][]} grid
 * @return {number}
 */
var numMagicSquaresInside = function(grid) {
	//edge cases: insufficient grid dimension
	if (grid.length < 3 || grid[0].length < 3){
		return 0;
	}//fi
	
	/**
	 * Check if subMat exists in the mainMat given indices of upper left corner
	 * precondition:
	 * - start row/col indices are valid. e.g. they are proper and valid upper left corner indices
	 * - subMat size must >= 1x1
	 */
	let hasSubMat = function(mainMat, startRowInx, startColInx, subMat){
		
		for (let rowInxOffset = 0; rowInxOffset < subMat.length; rowInxOffset++){
			for (let colInxOffset = 0; colInxOffset < subMat[0].length; colInxOffset++){
				if (subMat[rowInxOffset][colInxOffset] !== mainMat[startRowInx + rowInxOffset][startColInx + colInxOffset]) {
					return false;
				}//fi
			}//rof
		}//rof
		return true;
	};//end method
	
	/**
	 * precondition:
	 * - MAG_MAT_ARR which contains magic matrix templates magMat1... magMat8 is available
	 * - start row/col indices are valid. e.g. they are proper and valid upper left corner indices
	 */
	let isSubMatMagic = function(startRowInx, startColInx){
		for (let i=0; i<MAG_MAT_ARR.length; i++){
			if (hasSubMat(grid, startRowInx, startColInx, MAG_MAT_ARR[i])){
				return true;
			}//fi
		}//rof
		return false;
	};//end method
	
	let magMatCnt = 0;
	for (let rowInx = 0; rowInx < grid.length - 2; rowInx++) {
		for (let colInx = 0; colInx < grid[0].length - 2; colInx++) {
			if (isSubMatMagic(rowInx, colInx)){
				magMatCnt++;
			}//fi
		}//rof
	}//rof
  	return magMatCnt;  
};

 
let grid;

grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + numMagicSquaresInside(grid));

