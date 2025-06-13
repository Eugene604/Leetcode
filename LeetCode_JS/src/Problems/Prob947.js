const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * @param {number[][]} stones
 * @return {number}
 */
var removeStones = function(stones) {	
	const MAX_COORD = 10_001;
	let rowInx, colInx;
	
	let firstIDRow, firstIDCol;
	let parentIDArr;
	
	/**
	 * 
	 * Retrieves the root parent ID of the given node index in the union-find structure.
	 * This function implements path compression to optimize the union-find operation.
	 * 
	 * Preconditions:
	 * - `parentIDArr` exists and is properly initialized.
	 * - `nodeInx` is a valid index within the bounds of `parentIDArr`.
	 *
	 * @param {number} nodeInx - The index of the node whose root parent ID is to be found.
	 * @return {number} The root parent ID of the given node index.
	 */
	let getParentID = function(nodeInx) {
		if (parentIDArr[nodeInx] === nodeInx) {
			//do nothing
		} else {
			parentIDArr[nodeInx] = getParentID(parentIDArr[nodeInx]);			
		}//fi
		return parentIDArr[nodeInx];
	}//end function
	
	//step 1, populate parent graph.
	firstIDRow = new Array(MAX_COORD).fill(-1);
	firstIDCol = new Array(MAX_COORD).fill(-1);
	parentIDArr = new Array(stones.length).fill(-1);
	for (let i=0; i<stones.length; i++){
		rowInx = stones[i][0];
		colInx = stones[i][1];
		if (firstIDRow[rowInx] === -1 && firstIDCol[colInx] === -1){ //no island established
			firstIDRow[rowInx] = i; //this stone is the first id that appears in this row
			firstIDCol[colInx] = i;	//this stone is the first id that appears in this col	
			parentIDArr[i] = i;	
		} else if (firstIDRow[rowInx] === -1){//col got island whereas row doesn't
			firstIDRow[rowInx] = firstIDCol[colInx];
			parentIDArr[i] = firstIDCol[colInx];
		} else if (firstIDCol[colInx] === -1){//row got island whereas col doesn't
			firstIDCol[colInx] = firstIDRow[rowInx];
			parentIDArr[i] = firstIDRow[rowInx];
		} else if (firstIDRow[rowInx] === firstIDCol[colInx]){ //row and col got same island ID
			parentIDArr[i] = firstIDRow[rowInx];				
		} else {//row and col got different islandID, merge
			let mergedIslandID = Math.min(getParentID(firstIDRow[rowInx]),getParentID(firstIDCol[colInx]));
			parentIDArr[getParentID(firstIDRow[rowInx])] = mergedIslandID;
			parentIDArr[getParentID(firstIDCol[colInx])] = mergedIslandID;
			parentIDArr[i] = mergedIslandID;
		}//fi
	} //rof
	
	
	//step 2, count # of islands
	let islandSet = new Set();
	for (let i=0; i<stones.length; i++){
		islandSet.add(getParentID(i));
	}//rof

    return stones.length - islandSet.size;
};

let stones;
stones = [[3,1],[1,4],[1,1],[2,3],[0,3],[2,4]];
console.log("ans: " + removeStones(stones));


/*
stones = [[3,1],[1,4],[1,1],[2,3],[0,3],[2,4]];
console.log("ans: " + removeStones(stones));


stones = [[26,14],[11,4],[9,1],[24,20],[6,6],[3,0],[11,21],[11,11],[1,17],[19,15],[11,23],[27,1],[11,24],[15,19],[26,6],[27,29],[15,12],[10,8],[13,12],[14,5],[27,7],[13,25],[3,10],[17,11],[28,9],[1,12],[20,0],[27,16],[6,25],[23,21],[22,7],[7,28],[8,6],[22,10],[27,28],[5,29],[22,3],[24,19],[4,28],[3,2],[9,20],[12,2],[22,17],[14,24],[28,22],[23,1],[5,28],[22,0],[27,27],[18,13],[23,19],[22,25],[11,17],[28,11],[5,16],[8,12],[1,27],[12,19],[9,14],[6,20],[19,18],[29,24]];
console.log("ans: " + removeStones(stones)); //ans: 58


stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]];
console.log("ans: " + removeStones(stones));



//*/