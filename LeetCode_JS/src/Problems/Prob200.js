const MatrixUtils = require('../Utils/MatrixUtils.js');

var islandIDMap = new Array(90000);

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
	
	islandIDMap.fill(-1, 0, grid.length*grid[0].length);

	
	/**
	 * retrieve the island ID for a given node ID.
	 * 
	 * This function retrieves the island ID associated with a given node ID 
	 * by traversing the islandIDMap and updating the IDs as necessary.
	 * precondition: 
	 * -islandIDMap array is available and initialized
	 * -node id is within valid range
	 * @param {number} nodeID - The node ID for which to retrieve the island ID.
	 * @returns {number} - The island ID associated with the given node ID.
	 */
	let getIslandID = function(nodeID) {
		if (islandIDMap[nodeID] === -1 || islandIDMap[nodeID] === nodeID || islandIDMap[nodeID] === islandIDMap[islandIDMap[nodeID]]) {
			//do nothing
		} else {
			islandIDMap[nodeID] = getIslandID(islandIDMap[nodeID]);
		}//fi
		return islandIDMap[nodeID];		
	};//end method
	
	/**
	 * get island ID given i,j
	 * precondition: 
	 * -i and j are within valid range
	 * -grid array is available
	 * @param {number} i - The row index of the grid.
	 * @param {number} j - The column index of the grid.
	 * @returns {number} - The calculated node ID.
	 */
	let getNodeID = function(i,j) {
		return i*grid[0].length+j;				
	};//end method
	
	let islandSet = new Set();
	let leftNeighborIID, upperNeighborIID, nodeID;
	
	//scan upper edge
	if (grid[0][0] === "1") {
		islandSet.add(0);
		islandIDMap[0]=0;
	}//fi
	for (let j=1; j<grid[0].length; j++){
		if (grid[0][j] === "0") {
			continue;
		} else if ((leftNeighborIID = getIslandID(j-1)) !== -1) {
			islandIDMap[j] = leftNeighborIID;
		} else {
			islandIDMap[j] = j;
			islandSet.add(j);
		}//fi		
	}//rof
	
	//scan left edge
	for (let i=1; i<grid.length; i++){
		if (grid[i][0] === "0") {
			continue;
		}//fi
		nodeID = i*grid[0].length;
		if ((upperNeighborIID = getIslandID((i-1)*grid[0].length)) !== -1) {
			islandIDMap[nodeID] = upperNeighborIID;
		} else {
			islandIDMap[nodeID] = nodeID;
			islandSet.add(nodeID);
		}//fi		
	}//rof
	
	//scan rest of grid
	for (let i=1; i<grid.length; i++){
		for (let j=1; j<grid[0].length; j++){
			if (grid[i][j] === "0") {
				continue;
			}//fi
			nodeID = getNodeID(i,j);
			upperNeighborIID = getIslandID(getNodeID(i-1,j));
			leftNeighborIID = getIslandID(getNodeID(i,j-1));
			
			if (upperNeighborIID === -1 && leftNeighborIID === -1) { //upper and left nodes are sea
				islandIDMap[nodeID] = nodeID;
				islandSet.add(nodeID);
			} else if (upperNeighborIID === -1){//left is an island
				islandIDMap[nodeID] = leftNeighborIID;
			} else if (leftNeighborIID === -1){//upper is an island
				islandIDMap[nodeID] = upperNeighborIID;	
			} else {//both upper and left belong to some island
				if (upperNeighborIID > leftNeighborIID) { //merge both islands, use left island id as merged id
					islandIDMap[nodeID] = leftNeighborIID;
					islandIDMap[upperNeighborIID] = leftNeighborIID;
					islandSet.delete(upperNeighborIID);
				} else if (upperNeighborIID < leftNeighborIID) { //merge both islands, use upper island id as merged id
					islandIDMap[nodeID] = upperNeighborIID;
					islandIDMap[leftNeighborIID] = upperNeighborIID;
					islandSet.delete(leftNeighborIID);					
				} else { //upper and left belong to same island
					islandIDMap[nodeID] = upperNeighborIID;	
				}//fi
			}//fi		
		}//rof		
	}//rof
	

    return islandSet.size;
};

var testFunc = function() {
	let grids1 = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
];
	let grids2 = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
];

	let grids3 = [["1"],["0"],["1"],["0"],["1"],["0"],["1"],["1"],["0"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["1"],["0"],["0"],["1"]];

	let grid;
	

	grid = grids3;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + numIslands(grid));
	
	/*
	grid = grids2;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + numIslands(grid));
	//*/	
};



testFunc();

