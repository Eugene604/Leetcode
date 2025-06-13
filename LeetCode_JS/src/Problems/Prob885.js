/**
 * @param {number} rows
 * @param {number} cols
 * @param {number} rStart
 * @param {number} cStart
 * @return {number[][]}
 */
var spiralMatrixIII = function(rows, cols, rStart, cStart) {
    
    let visitedArr = new Array();
    
	/**
	 * precondition:
	 * - assume following global variables exist: 
	 *   1. rows - number, specifies # of rows in the matrix 
	 *   2. cols - number, specifies # of cols in the matrix
	 *   3. visitedArr - Array, used to record traversed elements
	 *
	 * traverseRight:
	 * - Traverses the matrix to the right from the starting coordinates.
	 * - Records each valid (within bounds) position in the visitedArr.
	 * - Returns the new coordinates after completing the traversal.
	 *
	 * @param {number[]} startCoord - Array with two elements representing the starting row and column.
	 * @param {number} travelLength - Number representing the length of the traversal.
	 * @return {number[]} - Array with two elements representing the ending row and column after traversal.
	 */
    let traverseRight = function(startCoord, travelLength){
		let endColInx = startCoord[1]+travelLength;
		if (startCoord[0] < 0 || startCoord[0] >= rows) {
			return [startCoord[0], endColInx];
		}//fi
				
		for (let colInx = Math.max(startCoord[1], 0); colInx < Math.min(cols,endColInx); colInx++){
			visitedArr.push([startCoord[0], colInx]);
		}//rof
		return [startCoord[0], endColInx];
	};//end method
	
	/**
	 * precondition:
	 * - assume following global variables exist: 
	 *   1. rows - number, specifies # of rows in the matrix 
	 *   2. cols - number, specifies # of cols in the matrix
	 *   3. visitedArr - Array, used to record traversed elements
	 *
	 * traverseLeft:
	 * - Traverses the matrix to the left from the starting coordinates.
	 * - Records each valid (within bounds) position in the visitedArr.
	 * - Returns the new coordinates after completing the traversal.
	 *
	 * @param {number[]} startCoord - Array with two elements representing the starting row and column.
	 * @param {number} travelLength - Number representing the length of the traversal.
	 * @return {number[]} - Array with two elements representing the ending row and column after traversal.
	 */
	let traverseLeft = function(startCoord, travelLength){
		let endColInx = startCoord[1]-travelLength;
		if (startCoord[0] < 0 || startCoord[0] >= rows) {
			return [startCoord[0], endColInx];
		}//fi
				
		for (let colInx = Math.min(cols-1,startCoord[1]); colInx > Math.max(-1, endColInx); colInx--){			
			visitedArr.push([startCoord[0], colInx]);			
		}//rof
		return [startCoord[0], endColInx];		
	};//end method
	
	/**
	 * precondition:
	 * - assume following global variables exist: 
	 *   1. rows - number, specifies # of rows in the matrix 
	 *   2. cols - number, specifies # of cols in the matrix
	 *   3. visitedArr - Array, used to record traversed elements
	 *
	 * traverseDown:
	 * - Traverses the matrix downward from the starting coordinates.
	 * - Records each valid (within bounds) position in the visitedArr.
	 * - Returns the new coordinates after completing the traversal.
	 *
	 * @param {number[]} startCoord - Array with two elements representing the starting row and column.
	 * @param {number} travelLength - Number representing the length of the traversal.
	 * @return {number[]} - Array with two elements representing the ending row and column after traversal.
	 */
	let traverseDown = function(startCoord, travelLength){
		let endRowInx = startCoord[0]+travelLength;
		if (startCoord[1] < 0 || startCoord[1] >= cols) {
			return [endRowInx, startCoord[1]];
		}//fi
				
		for (let rowInx = Math.max(0, startCoord[0]); rowInx < Math.min(endRowInx, rows); rowInx++){			
			visitedArr.push([rowInx, startCoord[1]]);			
		}//rof
		return [endRowInx, startCoord[1]];		
	};//end method
    
	/**
	 * precondition:
	 * - assume following global variables exist: 
	 *   1. rows - number, specifies # of rows in the matrix 
	 *   2. cols - number, specifies # of cols in the matrix
	 *   3. visitedArr - Array, used to record traversed elements
	 *
	 * traverseUp:
	 * - Traverses the matrix upward from the starting coordinates.
	 * - Records each valid (within bounds) position in the visitedArr.
	 * - Returns the new coordinates after completing the traversal.
	 *
	 * @param {number[]} startCoord - Array with two elements representing the starting row and column.
	 * @param {number} travelLength - Number representing the length of the traversal.
	 * @return {number[]} - Array with two elements representing the ending row and column after traversal.
	 */    
    let traverseUp = function(startCoord, travelLength){
		let endRowInx = startCoord[0]-travelLength;
		if (startCoord[1] < 0 || startCoord[1] >= cols) {
			return [endRowInx, startCoord[1]];
		}//fi
				
		for (let rowInx = Math.min(startCoord[0], rows-1); rowInx > Math.max(-1, endRowInx); rowInx--){
			visitedArr.push([rowInx, startCoord[1]]);
		}//rof
		return [endRowInx, startCoord[1]];		
	};//end method
	
	let startCoord = [rStart, cStart];
    let travelLength = 0;
    let prevVistedArrLength = -1;    
    
   
    while (visitedArr.length !== prevVistedArrLength) {
		prevVistedArrLength = visitedArr.length;
		travelLength++;
		startCoord = traverseRight(startCoord, travelLength);
		//console.log('right finished ' + JSON.stringify(startCoord));
		startCoord = traverseDown(startCoord, travelLength);
		//console.log('down finished ' + JSON.stringify(startCoord));
		travelLength++;
		startCoord = traverseLeft(startCoord, travelLength);
		//console.log('left finished ' + JSON.stringify(startCoord));
		startCoord = traverseUp(startCoord, travelLength);
		//console.log('up finished ' + JSON.stringify(startCoord));
		//console.log('a loop finished ' + JSON.stringify(visitedArr));
	};//end while */
    
    
    return visitedArr;    
};


 
let rows, cols, rStart, cStart;

rows = 5, cols = 6, rStart = 1, cStart = 4;
console.log("ans: " + JSON.stringify(spiralMatrixIII(rows, cols, rStart, cStart)));

