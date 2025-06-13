const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {number[][]} land
 * @return {number[][]}
 */
var findFarmland = function(land) {
	let farmlandCoord = new Array();
	
	/**
	 * Finds the lower right corner of a farmland group given its upper left corner coordinates.
	 * Once found, the coordinates of both the upper left and lower right corners are pushed to the farmland coordinate array.
	 * 

	 * Precondition:
	 * - farmlandCoord array is available and initialized
	 * - land array is available and valid.
	 * - It is assumed that the cell at (upperI, leftJ) contains 1.
	 * 
	 * Postcondition:
	 * - The value of the left edge of the farmland group will be updated to signify the right edge's j index.
	 *   Specifically, the value in the left edge will be set to the negative of the farmland group's right edge's j index.
	 * 
	 * @param {number} upperI - The row index of the upper left corner of the farmland group.
	 * @param {number} leftJ - The column index of the upper left corner of the farmland group.
	 * @returns {void}
	 * 
	 */
	let findAndPushCorner = function(upperI,leftJ){
		//step 1, find right J
		let rightJ;		
		for (rightJ = leftJ+1; rightJ < land[0].length && land[upperI][rightJ] === 1; rightJ++) {}//rof
		rightJ--;
		if (rightJ>leftJ){
			land[upperI][leftJ+1] = -rightJ;
		}//fi
		
		//step 2, find lower I
		let lowerI; 
		for (lowerI = upperI+1; lowerI < land.length && land[lowerI][rightJ] === 1; lowerI++) {
			land[lowerI][leftJ] = -rightJ;
		}//rof
		lowerI--;
		
		farmlandCoord.push([upperI, leftJ, lowerI, rightJ]);		
	};//end method
	
	for (let i=0; i<land.length; i++){
		for (let j=0; j<land[0].length; j++){
			if (land[i][j] === 0) {
				continue;
			} else if (land[i][j] === 1) {
				//console.log('findAndPushCorner called ' + i + ':' + j);
				findAndPushCorner(i,j);
			} else {
				j = -land[i][j];
			}//fi
				
		}//rof		
	}//rof
	
	//MatrixUtils.displayMatrix(land);
	return farmlandCoord;
    
};

var testFunc = function() {
	let grids1 = [[1,0,0],[0,1,1],[0,1,1]];
	let grids2 = [[1,1],[1,1]];
	
	let grid;
	

	grid = grids1;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + findFarmland(grid));
	
	/*
	grid = grids2;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + numIslands(grid));
	//*/	
};



testFunc();

