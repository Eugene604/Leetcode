const MatrixUtils = require('../Utils/MatrixUtils.js');
/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
	/**
	 * Calculates the perimeter contribution of a single land cell in the grid.
	 * 
	 * 
	 * This function computes the number of sides of the land cell at position [i][j]
	 * that are adjacent to water or the edge of the grid, thereby contributing to 
	 * the overall perimeter of the island.
	 * 
	 * Precondition: It is assumed that the cell at [i][j] is a land.
	 * 
	 * 
	 * @param {number[][]} grid - The 2D grid representing the island.
	 * @param {number} i - The row index of the land cell.
	 * @param {number} j - The column index of the land cell.
	 * @returns {number} - The local perimeter contribution of the land cell at [i][j].
	 */
	let getLocalPerimeter = function(grid, i, j) {
		let localPerimeter = 0;
		//check top
		if ( i-1 < 0 || grid[i-1][j] === 0 ){
			localPerimeter++;
		}//fi
		//check bottom
		if ( i+1 === grid.length || grid[i+1][j] === 0 ){
			localPerimeter++;
		}//fi
		//check left
		if ( j-1 < 0 || grid[i][j-1] === 0 ){
			localPerimeter++;
		}//fi		
		//check right
		if ( j+1 === grid[0].length || grid[i][j+1] === 0 ){
			localPerimeter++;
		}//fi		
		return localPerimeter;
	}//end method
	
	let perimeter = 0;
	for (let i=0; i<grid.length; i++){
		for (let j=0; j<grid[0].length; j++){
			if (grid[i][j]===0) {
				continue;
			} else {
				perimeter += getLocalPerimeter(grid, i,j);
			}//fi
			
		}//rof
	}//rof
    return perimeter;
};

var testFunc = function() {
	let grids1 = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]];
	let grids2 = [[1]];


	let grid;
	

	grid = grids1;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + islandPerimeter(grid));
	
	grid = grids2;	
	MatrixUtils.displayMatrix(grid);	
	console.log('ans: ' + islandPerimeter(grid));	
};



testFunc();

/**
 * @param {TreeNode} root
 * @return {string}
 */
var smallestFromLeaf_v2 = function(root) {
	let minArr = [111];
	
	/**
	 * 
	 * Recursively traverses the tree from the given node and constructs an array representing the path values.
	 * 
	 * Preconditions:
	 * - The provided node and arr are valid TreeNode and Array objects, respectively.
	 * - The external variable minArr is available and used to store the minimum path encountered so far.
	 * 
	 * @param {TreeNode} node - The current node being processed.
	 * @param {number[]} arr - The array representing the path values from root to the current node.
 	*/
	let findMinArr = function(node, arr){
		let currArr = [node.val, ...arr];		
		if (!node.left && !node.right) {
			minArr = getMinArr(currArr, minArr);					
			return;
		}//fi
		
		if (node.left) {
			findMinArr(node.left, currArr);
		}//fi
		
		if (node.right) {
			findMinArr(node.right, currArr);
		}//fi
	};//end method
	
	/**

	 * 
	 * Compares two arrays lexicographically and returns the smaller one.
	 * 
	 * Preconditions:
	 * - Both arr1 and arr2 are valid Array objects.
	 * 
	 * @param {number[]} arr1 - The first array to compare.
	 * @param {number[]} arr2 - The second array to compare.
	 * @return {number[]} - The smaller array lexicographically.
	 */
	let getMinArr = function(arr1, arr2) {
		//console.log('comparing: ' + arr1 + ' : ' + arr2);
		let shorterArr = (arr1.length > arr2.length) ? arr2 : arr1;
		for (let i=0; i<shorterArr.length; i++){
			if (arr1[i] > arr2[i]) {
				return arr2;
			} else if (arr1[i] < arr2[i]) {
				return arr1;
			}//fi
		}//rof
		return shorterArr;
	};//end method
	
	findMinArr(root, []);
	minArr = minArr.map(num => num + 97);
	

    return String.fromCharCode(...minArr);;
};

