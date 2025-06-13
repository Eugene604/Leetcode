const MAX_MD = 1_048_576;
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maximumSafenessFactor = function(grid) {
	//special case: start or end point has thief
	if (grid[0][0] === 1 || grid[grid.length-1][grid.length-1] === 1){
		return 0;
	} //fi
	
	//step 1, build Manhattan distance grid
	let manhDistGrid = buildManhDistGrid(grid);
    //console.log(manhDistGrid);
    	
	//step 2, use BFS to determine safest route
	let isTravelledGrid = grid.map(row => new Array(row.length).fill(false));
	let maxSafeness;
	let coordQueue;
	let currCoord; //coordinate, an array of 2		
	let maxInx = grid.length-1;
	let neighborSafeness;
	let i,j;
	
	maxSafeness = Math.max(manhDistGrid[0][1], manhDistGrid[1][0]);
	maxSafeness = Math.min(maxSafeness, manhDistGrid[0][0]);
	coordQueue = new Array(maxSafeness+1).fill(null).map(() => []);
	coordQueue[Math.min(maxSafeness, manhDistGrid[0][1])].push([0,1]);
	coordQueue[Math.min(maxSafeness, manhDistGrid[1][0])].push([1,0]);
	isTravelledGrid[0][1] = true;
	isTravelledGrid[1][0] = true;
	while (maxSafeness > 0) {
		while (coordQueue[maxSafeness].length > 0){
			currCoord = coordQueue[maxSafeness].shift();
			if (currCoord[0] === maxInx && currCoord[1] === maxInx) {
				return maxSafeness;
			}//fi
				
			i = currCoord[0]-1;
			j = currCoord[1];
			if (i >= 0 && !isTravelledGrid[i][j]) {
				neighborSafeness = Math.min(maxSafeness, manhDistGrid[i][j]);
				coordQueue[neighborSafeness].push([i,j]);
				isTravelledGrid[i][j] = true;
			}//fi
			
			i = currCoord[0]+1;
			j = currCoord[1];
			if (i <= maxInx && !isTravelledGrid[i][j]) {
				neighborSafeness = Math.min(maxSafeness, manhDistGrid[i][j]);			
				coordQueue[neighborSafeness].push([i,j]);
				isTravelledGrid[i][j] = true;	
			}//fi
			
			i = currCoord[0];
			j = currCoord[1]-1;
			if (j >= 0 && !isTravelledGrid[i][j]) {
				neighborSafeness = Math.min(maxSafeness, manhDistGrid[i][j]);			
				coordQueue[neighborSafeness].push([i,j]);
				isTravelledGrid[i][j] = true;		
			}//fi
			
			i = currCoord[0];
			j = currCoord[1]+1;
			if (j <= maxInx && !isTravelledGrid[i][j]) {
				neighborSafeness = Math.min(maxSafeness, manhDistGrid[i][j]);			
				coordQueue[neighborSafeness].push([i,j]);
				isTravelledGrid[i][j] = true;		
			}//fi
		}//end while
		maxSafeness--;	
	}//end while		
    return maxSafeness;
};



/**
 * 
 * @param {number[][]} grid
 * @return {number[][]} Manhattan distance of thieves
 */
var buildManhDistGrid = function(grid) {
	let manhDistGrid = grid.map(row => new Array(row.length).fill(MAX_MD));	
	
	let coordQueue;	 //coordinate queue for BFS
	let manhDist; //Manhattan distance at current iteration			
	let queueSize;
	let currCoord; //coordinate, an array of 2		
	let maxInx = grid.length-1;
	for (let i=0; i<grid.length; i++) {
		for (let j=0; j<grid[0].length; j++){
			if (grid[i][j] === 0) {
				continue;
			}//fi
			manhDistGrid[i][j] = 0;
			coordQueue = [];
			coordQueue.push([i,j]);			
			manhDist = 1;
			while ((queueSize = coordQueue.length) > 0){
				while (queueSize > 0) {
					currCoord = coordQueue.shift();
					if (currCoord[0] > 0 && manhDistGrid[currCoord[0]-1][currCoord[1]] > manhDist) {
						manhDistGrid[currCoord[0]-1][currCoord[1]] = manhDist;
						coordQueue.push([currCoord[0]-1,currCoord[1]]);
					}//fi
					if (currCoord[0] < maxInx && manhDistGrid[currCoord[0]+1][currCoord[1]] > manhDist) {
						manhDistGrid[currCoord[0]+1][currCoord[1]] = manhDist;
						coordQueue.push([currCoord[0]+1,currCoord[1]]);
					}//fi
					if (currCoord[1] > 0 && manhDistGrid[currCoord[0]][currCoord[1]-1] > manhDist) {
						manhDistGrid[currCoord[0]][currCoord[1]-1] = manhDist; 
						coordQueue.push([currCoord[0],currCoord[1]-1]);
					}//fi
					if (currCoord[1] < maxInx && manhDistGrid[currCoord[0]][currCoord[1]+1] > manhDist) {
						manhDistGrid[currCoord[0]][currCoord[1]+1] = manhDist;
						coordQueue.push([currCoord[0],currCoord[1]+1]);
					}//fi					
					queueSize--;
				}//end while
				//console.log(' coordQueue.content:' + JSON.stringify(coordQueue));
				manhDist++;
			}//end while						
		}//rof
	}//rof
	return manhDistGrid;
};//end method


//==================== v2 ================

/**
 * @param {number[][]} grid
 * @return {number}
 */
var maximumSafenessFactor_v2 = function(grid) {
	//special cases: start or end point has thief
	if (grid[0][0] === 1 || grid[grid.length-1][grid.length-1] === 1){
		return 0;
	} //fi
	
	//step 1, build Manhattan distance grid
	let manhDistGrid = buildManhDistGrid(grid);
    //console.log(manhDistGrid);
    	
	//step 2, use dfs to determine safest route
	let isTravelledGrid = grid.map(row => new Array(row.length).fill(false));
	let globalMaxSafeness = 0;
		
	/**
	 * traverse the grid and update safeness
	 * precondition:
	 * -manhDistGrid is available and correctly populated
	 * -isTravelledGrid is available and correctly initialized
	 * @param {number} i 
	 * @param {number} j
	 * @param {number} safeness, max safeness so far along this route
	 */
	let traverse = function(i, j, safeness){
		safeness = Math.min(safeness, manhDistGrid[i][j]);
		let maxInx = grid.length-1;
		//end case, i and j is the right corner
		if (i === maxInx && j === maxInx){
			globalMaxSafeness = Math.max(globalMaxSafeness, safeness);
			return;
		}//fi
		
		if (safeness <= globalMaxSafeness || safeness === 0) {
			return; //sub or same optimal route, no need to proceed
		}//fi
			
		isTravelledGrid[i][j] = true;
		if (i > 0 && !isTravelledGrid[i-1][j]) {
			traverse(i-1, j, Math.min(safeness, manhDistGrid[i][j]));
		}//fi
		if (i < maxInx && !isTravelledGrid[i+1][j]) {
			traverse(i+1, j, Math.min(safeness, manhDistGrid[i][j]));
		}//fi
		if (j > 0 && !isTravelledGrid[i][j-1]) {
			traverse(i, j-1, Math.min(safeness, manhDistGrid[i][j]));
		}//fi
		if (j < maxInx && !isTravelledGrid[i][j+1]) {
			traverse(i, j+1, Math.min(safeness, manhDistGrid[i][j]));
		}//fi		
		isTravelledGrid[i][j] = false;
		

	}//end method    

	traverse(0,0, MAX_MD);	
    return globalMaxSafeness;
};


let grid;
/*
grid = [[1,0,0],[0,0,0],[0,0,1]];
console.log('ans: ' + maximumSafenessFactor(grid));


grid = [[0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,0],[0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0],[1,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0],[0,0,0,0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[1,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0],[0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0],[1,1,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0],[0,1,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0],[0,0,0,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0],[0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0],[0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,1,0],[0,0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[0,0,0,0,1,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,1,0,0,0],[0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0],[0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,1,1,0],[0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0],[0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,1,0,0,1,1,1,0,0,0,0,0,0,1,0,1,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1],[1,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0],[0,1,1,1,1,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0],[0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,0,1,1,0],[0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0],[0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,1],[0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,1,1,0,1,0,0,1,0,0,1,0],[0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1],[0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1],[0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,1],[1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,1,1,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0],[1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0],[0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0],[1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0],[0,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0],[1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0],[0,0,1,0,0,0,1,1,1,1,0,1,1,1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,0,0,0,0,1,0,0,1,0,1,0]];
console.log('ans: ' + maximumSafenessFactor(grid));

grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]];
console.log('ans: ' + maximumSafenessFactor(grid));


grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]];
console.log('ans: ' + maximumSafenessFactor(grid));

//*/

grid = [[0,1,1],[0,0,0],[0,0,0]];
console.log('ans: ' + maximumSafenessFactor(grid));
