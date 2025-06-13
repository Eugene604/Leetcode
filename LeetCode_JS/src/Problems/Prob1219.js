/**
 * @param {number[][]} grid
 * @return {number}
 */
var getMaximumGold = function(grid) {
    let isTravelled = Array.from({ length: grid.length }, () => Array.from({ length: grid[0].length }));

    /**
     * Precondition:
     * - grid (number[][]) is available
     * - corresponding isTravelled (number[][]) is available and valid
     * - i and j are valid to the grid
     * @param {number} i - row index
     * @param {number} j - column index
     */
    let traverse = function(i,j) {
        if (isTravelled[i][j]) {
            return 0;
        } else if (grid[i][j] === 0) {
			isTravelled[i][j] = true;
			return 0;
		}//fi

		isTravelled[i][j] = true;
		let currAmnt = grid[i][j];
		let maxAmnt = currAmnt;
		
		if (i !== 0){
			maxAmnt = Math.max(maxAmnt, currAmnt + traverse(i-1,j));
		}//fi

		if (j !== 0){
			maxAmnt = Math.max(maxAmnt, currAmnt + traverse(i,j-1));
		}//fi
				
		if (i !== grid.length-1){
			maxAmnt = Math.max(maxAmnt, currAmnt + traverse(i+1,j));
		}//fi
		
		if (j !== grid[0].length-1){
			maxAmnt = Math.max(maxAmnt, currAmnt + traverse(i,j+1));
		}//fi					
		isTravelled[i][j] = false;
		return maxAmnt;
    }//end function
    
    let globalMaxAmnt = 0;
    for (let i=0; i<grid.length; i++) {
		for (let j=0; j<grid[i].length; j++) {
			globalMaxAmnt = Math.max(globalMaxAmnt, traverse(i,j));
		}//rof
	}//rof
    return globalMaxAmnt;
};

let grid;

/*
grid = [[0,6,0],[5,8,7],[0,9,0]];
console.log('Ans: ' + getMaximumGold(grid));
//*/

grid = [[80]];
console.log('Ans: ' + getMaximumGold(grid));