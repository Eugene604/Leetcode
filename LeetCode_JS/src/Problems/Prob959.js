const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {string[]} grid
 * @return {number}
 */
var regionsBySlashes = function(grid) {
	const GROUP_ID_OFFSET = 10;
	let currGroupID = 0 + GROUP_ID_OFFSET;
	
	/**
	 * 
	 * Recursively assigns a group ID to all connected cells that are part of the same region.
	 * 
	 * preconditions:
	 * - grid is available and valid
	 * - grid has been extended from original grid argument and content has been converted to number
	 * - currGroupID is available and properly set
	 * 
	 * grid conversion:
	 * white space -> 0
	 * barrier -> -1	 
	 * 
	 * @param {number} rowInx - The current row index in the grid.
	 * @param {number} colInx - The current column index in the grid.
	 * @param {number} groupID - The ID of the group that this cell and its connected cells belong to.
	 * 
	 */
	let inviteToGroup = function(rowInx, colInx, groupID) {
		//case 1: out of bound
		if (rowInx <0 || colInx < 0 || rowInx >= grid.length || colInx >= grid.length){
			return;
		}//fi
		
		//case 2: this cell has been traversed or a barrier
		if (grid[rowInx][colInx] != 0) { 
			return;
		}//fi
		
		//case 3: this cell is white space
		if (grid[rowInx][colInx] === 0) { 
			grid[rowInx][colInx] = groupID;
			inviteToGroup(rowInx, colInx-1, groupID); //left
			inviteToGroup(rowInx-1, colInx, groupID); //up
			inviteToGroup(rowInx, colInx+1, groupID); //right
			inviteToGroup(rowInx+1, colInx, groupID); //down			
			return;			
		}//fi
	};//end method
	
	//step 1: extend grid
	let extGrid = Array.from({ length: grid.length*3 }, () => Array(grid.length*3).fill(0));
	for (let rowInx=0; rowInx<grid.length; rowInx++){
		for (let colInx=0; colInx<grid.length; colInx++){
			if (grid[rowInx].charCodeAt(colInx) === 47){ // == '/'
				extGrid[rowInx*3][colInx*3+2] = -1;
				extGrid[rowInx*3+1][colInx*3+1] = -1;
				extGrid[rowInx*3+2][colInx*3] = -1;
			} else if  (grid[rowInx].charCodeAt(colInx) === 92){ // == '\'
				extGrid[rowInx*3][colInx*3] = -1;
				extGrid[rowInx*3+1][colInx*3+1] = -1;
				extGrid[rowInx*3+2][colInx*3+2] = -1;
			}//fi
		}//rof
	}//rof	
	grid = extGrid;
	//MatrixUtils.displayMatrix(grid);
	
	//step 2: scan each grid element, create new group (if necessary) and recursively invite neighbors
	for (let rowInx=0; rowInx<grid.length; rowInx++){
		for (let colInx=0; colInx<grid.length; colInx++){
			if (grid[rowInx][colInx] === 0){
				currGroupID++;
				inviteToGroup(rowInx, colInx, currGroupID);				
			}//fi
		}//rof
	}//rof
	
	
    return currGroupID-GROUP_ID_OFFSET;
};

let grid;


grid =  ["/\\", "\\\\"];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + regionsBySlashes(grid));

/*

grid =  [" /\\"," \\/","\\  "];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + regionsBySlashes(grid));


grid =  ["/\\","\\/"];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + regionsBySlashes(grid));



grid =  [" /","/ "];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + regionsBySlashes(grid));

//*/