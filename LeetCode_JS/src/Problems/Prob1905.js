const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {number[][]} grid1
 * @param {number[][]} grid2
 * @return {number}
 */
var countSubIslands = function(grid1, grid2) {
	const BASE_ISLAND_ID = 10;
	let currIslandID = BASE_ISLAND_ID;
	
	/**
     * Retrieves the status of the cell in the grid.
     *
     * Preconditions:
     * - The grid is valid.
     * - Island IDs are assumed to be >= BASE_ISLAND_ID.
     * 
     * @param {number[][]} grid - The grid from which to retrieve the cell status).
     * @param {number} rowInx - The current row index in the grid.
     * @param {number} colInx - The current column index in the grid.
     * @return {number} - The status of the cell:
     * - 0: The cell is water or out of bounds.
     * - 1: The cell is land and not yet categorized.
     * - >= BASE_ISLAND_ID: The cell is part of an island with a specific ID.
     */
	let getCellStatus = function(grid, rowInx, colInx) {
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
     * - The grid and masterGrid are valid and having same dimension.
     * - currIslandID is available and properly set.
     * - Island ID must be >= BASE_ISLAND_ID.
     * 
     * Grid value:
     * - land -> 1
     * - water -> 0
     * 
	 * @param {number[][]} grid - The grid where the island identification is being performed
     * @param {number} rowInx - The current row index in the grid.
     * @param {number} colInx - The current column index in the grid.
     * @param {number} islandID - The ID of the island that this cell and its connected cells belong to.
	 * @param {number[][]} masterGrid - The reference grid used to verify if the island in grid is a sub-island
     * @return {boolean} - Returns true if the region in grid2 is a sub-island of the corresponding region in grid1, false otherwise
     */
	let inviteToIsland = function(grid, rowInx, colInx, islandID, masterGrid) {
		//case 1: out of bound
		if (rowInx <0 || colInx < 0 || rowInx >= grid.length || colInx >= grid[0].length){
			return true;
		}//fi
		
		//case 2: this cell is water 
		if (grid[rowInx][colInx] === 0) { 
			return true;
		}//fi
		
		//case 3: this cell has been traversed with same islandID 
		if (grid[rowInx][colInx] === islandID) { 
			return true;
		}//fi
		
		//case 4: this cell is land
		let isSubOfMI = masterGrid[rowInx][colInx] === 1;
		grid[rowInx][colInx] = islandID;			
		isSubOfMI &= inviteToIsland(grid2, rowInx, colInx-1, islandID, grid1);			
		isSubOfMI &= inviteToIsland(grid2, rowInx-1, colInx, islandID, grid1);			
		isSubOfMI &= inviteToIsland(grid2, rowInx, colInx+1, islandID, grid1);
		isSubOfMI &= inviteToIsland(grid2, rowInx+1, colInx, islandID, grid1);	
		
		return isSubOfMI;
	};//end method
	
	let subIslandCnt = 0;		
	for (let rowInx=0; rowInx<grid2.length; rowInx++){
		for (let colInx=0; colInx<grid2[0].length; colInx++){
			if (grid2[rowInx][colInx] === 1){
				if (inviteToIsland(grid2, rowInx, colInx, currIslandID, grid1)){//two islands
					subIslandCnt++;
				}//fi
				currIslandID++;
			}//fi
		}//rof
	}//rof				
    return subIslandCnt;
};


let grid1, grid2;

grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]];
grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]];

MatrixUtils.displayMatrix(grid1);
console.log('');
MatrixUtils.displayMatrix(grid2);
console.log("ans: " + countSubIslands(grid1, grid2));

/*



//*/