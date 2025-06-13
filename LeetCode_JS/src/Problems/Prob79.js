/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word){
	let visited = new Array();
	for (let i=0; i<board.length; i++){
		visited.push(new Array(board[0].length).fill(false));
	}//rof
		
	/**
	 * precondition: 
	 * - board, word, visited variables are available and properly instantiated
	 * - rowInx and colInx are valid numbers 
	 */
	let searchWord = function(rowInx, colInx, wordInx) {
		//check if range is valid
		if (rowInx < 0 || colInx <0 || rowInx >= board.length || colInx >= board[0].length) {
			return false;
		}//fi
		//check for traversal state
		if (visited[rowInx][colInx]){
			return false;
		}//fi
		
		//can return false if letter @ wordInx  doesn't match the letter on board
		if (board[rowInx][colInx] != word[wordInx]){
			
			return false;
		}//fi
		
		//word index is last index, whole word is found
		if (wordInx === word.length-1){
			//console.log('word index is last index, whole word is found');
			return true;
		}//fi
		//recursively search for word
		
		visited[rowInx][colInx] = true;
		if (searchWord(rowInx-1, colInx, wordInx+1)){
			//console.log('going to return true 1: ' + board[rowInx][colInx] + ' : ' + word[wordInx]);
			return true;
		} else if (searchWord(rowInx+1, colInx, wordInx+1)){
			//console.log('going to return true 2: ' + board[rowInx][colInx] + ' : ' + word[wordInx]);
			return true;
		} else if (searchWord(rowInx, colInx-1, wordInx+1)){
			//console.log('going to return true 3: ' + board[rowInx][colInx] + ' : ' + word[wordInx]);
			return true;
		} else if (searchWord(rowInx, colInx+1, wordInx+1)){
			//console.log('going to return true 4: ' + board[rowInx][colInx] + ' : ' + word[wordInx]);
			return true;
		}//fi
		
		visited[rowInx][colInx] = false;		
		return false;
	}//end method
	
	for (let rowInx = 0; rowInx < board.length; rowInx++) {
		for (let colInx = 0; colInx < board[0].length; colInx++) {			
			if (searchWord(rowInx, colInx,0)){
				return true;
			}//fi
		}//rof
	}//rof
	
    return false;
};

let board, word;

board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]];
word = "ABCCED";

console.log('ans: ' + exist(board, word));