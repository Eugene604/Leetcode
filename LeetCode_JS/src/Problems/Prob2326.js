/**
 * @param {number} m
 * @param {number} n
 * @param {ListNode} head
 * @return {number[][]}
 */
var spiralMatrix = function(m, n, head) {
	let mat = Array.from({ length: m }, () => Array(n).fill(-1));
	let rowInc = 0;
	let colInc = 1;
	/**
	 * Rotates the current direction vector by 90 degrees clockwise.
	 * 
	 * Precondition:
	 * - `rowInc` and `colInc` are present and properly initialized.
	 * - `rowInc` and `colInc` represent the current movement direction in the matrix.
	 * 
	 * Postcondition:
	 * - The direction vector (`rowInc`, `colInc`) is updated to reflect a 90-degree clockwise turn.
	 */
	let turnRight = function() {
		let tmp = rowInc;
    	rowInc = colInc;
    	colInc = -tmp;
	};//end method
	
	let rowInx = 0;
	let colInx = 0;
	let currNode = head;
	while (currNode !== null && currNode !== undefined) {
		//step 1, check boundary:
		if (rowInx<0 || colInx<0 || rowInx>=m || colInx>=n || mat[rowInx][colInx]!==-1){
			//out of bound or reached wall (previously stored indices). roll back a step and turn
			rowInx-=rowInc;
			colInx-=colInc;
			turnRight();
			rowInx+=rowInc;
			colInx+=colInc;
		}//fi
		mat[rowInx][colInx] = currNode.val;
		currNode = currNode.next;
		rowInx+=rowInc;
		colInx+=colInc;
	}//end while
    return mat;
};
const { buildList, displayList, listToString } = require('../Utils/ListUtils.js');
const MatrixUtil = require('../Utils/MatrixUtils.js');
let m, n, head;
m = 3, n = 5;
head = buildList([3,0,2,6,8,1,7,9,4,2,5,5,0]);
displayList(head);
MatrixUtil.displayMatrix(spiralMatrix(m, n, head));    
