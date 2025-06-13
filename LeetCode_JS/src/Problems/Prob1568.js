const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {number[][]} grid
 * @return {number}
 */
var minDays = function(grid) {
	const BASE_ISLAND_ID = 10;
	let currIslandID = BASE_ISLAND_ID;
	let neighborListMat = Array.from({ length: grid.length }, () => Array.from({ length: grid[0].length }, () => []));
	
	/**
     * Retrieves the status of the cell in the grid.
     *
     * Preconditions:
     * - The grid is available and valid.
     * - Island IDs are assumed to be >= BASE_ISLAND_ID.
     *  
     * @param {number} rowInx - The current row index in the grid.
     * @param {number} colInx - The current column index in the grid.
     * @return {number} - The status of the cell:
     * - 0: The cell is water or out of bounds.
     * - 1: The cell is land and not yet categorized.
     * - >= BASE_ISLAND_ID: The cell is part of an island with a specific ID.
     */
	let getCellStatus = function(rowInx, colInx) {
		//case 1: out of bound
		if (rowInx <0 || colInx < 0 || rowInx >= grid.length || colInx >= grid[0].length){
			return 0;
		}//fi
		
		//case 2: this cell is water 
		if (grid[rowInx][colInx] === 0) { 
			return 0;
		}//fi
		
		return grid[rowInx][colInx];			
	};//end method
	
	/**
     * Recursively assigns an island ID to all connected cells that are part of the same region.
     *
     * Preconditions:
     * - The grid is available and valid.
     * - currIslandID is available and properly set.
     * - Island ID must be >= BASE_ISLAND_ID.
     * 
     * Grid value:
     * - land -> 1
     * - water -> 0
     * 
     * @param {number} rowInx - The current row index in the grid.
     * @param {number} colInx - The current column index in the grid.
     * @param {number} islandID - The ID of the island that this cell and its connected cells belong to.
     * @return {void} - The function does not return a value.
     */
	let inviteToIsland = function(rowInx, colInx, islandID) {
		//case 1: out of bound
		if (rowInx <0 || colInx < 0 || rowInx >= grid.length || colInx >= grid[0].length){
			return;
		}//fi
		
		//case 2: this cell is water 
		if (grid[rowInx][colInx] === 0) { 
			return;
		}//fi
		
		//case 3: this cell has been traversed with same islandID 
		if (grid[rowInx][colInx] === islandID) { 
			return;
		}//fi
		
		//case 4: this cell is land 
		grid[rowInx][colInx] = islandID;			
		inviteToIsland(rowInx, colInx-1, islandID);			
		inviteToIsland(rowInx-1, colInx, islandID);			
		inviteToIsland(rowInx, colInx+1, islandID);
		inviteToIsland(rowInx+1, colInx, islandID);		
	};//end method
	
   /**
     * Checks if this cell is an island joint.
     *
     * A joint is a cell such that when deleted, it splits the land into two islands.
     *
     * Preconditions:
     * - The grid is available and valid.
     * - currIslandID is available and properly set.
     * - The current island ID must be >= BASE_ISLAND_ID, indicating the cell is valid land.
     * 
     * Grid value:
     * - land -> 1
     * - water -> 0
     * 
     * @param {number} rowInx - The current row index in the grid.
     * @param {number} colInx - The current column index in the grid.
     * @return {boolean} - Returns `true` if the cell is a joint, otherwise `false`.
     */
	let isCellIslandJoint = function(rowInx, colInx) {
		
		let neighborCoordArr = [];
		if (getCellStatus(rowInx, colInx-1) !== 0) {
			neighborCoordArr.push(rowInx);
			neighborCoordArr.push(colInx-1);
		}//fi 		
		if (getCellStatus(rowInx-1, colInx) !== 0) {
			neighborCoordArr.push(rowInx-1);
			neighborCoordArr.push(colInx);
		}//fi 							
		if (getCellStatus(rowInx, colInx+1) !== 0) {
			neighborCoordArr.push(rowInx);
			neighborCoordArr.push(colInx+1);
		}//fi 				
		if (getCellStatus(rowInx+1, colInx) !== 0) {
			neighborCoordArr.push(rowInx+1);
			neighborCoordArr.push(colInx);
		}//fi 				
		
		
		//check if # of neighbors < 2
		if (neighborCoordArr.length < 3) { 
			return false;
		}//fi
		
		
		grid[rowInx][colInx]++;			
		inviteToIsland(neighborCoordArr.shift(), neighborCoordArr.shift(), grid[rowInx][colInx]);
		while (neighborCoordArr.length > 0) {
			if (getCellStatus(neighborCoordArr.shift(), neighborCoordArr.shift()) !== grid[rowInx][colInx]) {
				return true;
			}//fi
		}//end while
		return false;
	};//end method
	
	//edge case: map size is 1
	if (grid.length === 1 && grid[0].length === 1) {
		return grid[0][0];
	}//fi
	
	//step 1. scan each grid element, create new island (if necessary) and recursively invite neighbors
	let oceanCnt = 0;
	let hasCreatedFirstIsland = false;
	for (let rowInx=0; rowInx<grid.length; rowInx++){
		for (let colInx=0; colInx<grid[0].length; colInx++){
			if (grid[rowInx][colInx] === 1){
				if (hasCreatedFirstIsland){//two islands
					return 0;
				} else {
					inviteToIsland(rowInx, colInx, currIslandID);
					hasCreatedFirstIsland = true;
				}//fi					
			} else if (grid[rowInx][colInx] === 0){
				oceanCnt++;
			}//fi
		}//rof
	}//rof
	
	//step 2. check if total land area is only 1 or no land in this map
	if (grid.length*grid[0].length - oceanCnt === 1){
		return 1;
	} else if (!hasCreatedFirstIsland) {
		return 0;
	}//fi
	
	//step 3, for each land cell, try to see if it's a joint		
	for (let rowInx=0; rowInx<grid.length; rowInx++){
		for (let colInx=0; colInx<grid[0].length; colInx++){
			if (getCellStatus(rowInx, colInx) > 0 && isCellIslandJoint(rowInx, colInx)){
				return 1;
			}//fi
		}//rof
	}//rof
	
    return 2;
    
    
};


let grid;


grid =  [[1,0,1,0]];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + minDays(grid));

/*
grid =  [[0,1,1,0],[0,1,1,0],[0,0,0,0]];
MatrixUtils.displayMatrix(grid);
console.log("ans: " + minDays(grid));


//*/