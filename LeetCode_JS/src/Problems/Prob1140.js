const ALICE_ID = 0;
const BOB_ID = 1;
/**
 * @param {number[]} piles
 * @return {number}
 */
var stoneGameII = function(piles) {
	let lastPInx = piles.length-1;
	let suffixPile = new Array(piles.length+1);
	let playerCache = Array.from({ length: 2 }, () => Array.from({ length: piles.length+1 }, () => []));

	/**
	 * 
	 * Calculates the maximum score the current player can achieve starting from the given pile index and m value.
	 * This function uses dynamic programming with memoization to optimize calculations and avoid redundant work.
	 * 	 
	 * precondition:
	 * - The following variables and data structs are available and correctly set:
	 *  player cache arrays, lastPinx, suffixPile   
	 * - m cannot be less than 1
	 * - pInx is assumed to be valid
	 * 
	 *
	 * @param {number} pInx - The current pile index from which the player is choosing stones.
	 * @param {number} m - The current value of m, which determines the maximum number of piles the player can pick.
	 * @param {number} playerID - The ID of the current player (ALICE_ID or BOB_ID).
	 * @return {number} The maximum score the current player can achieve starting from pile index `pInx`.
	 *
	 */
	let playerMove = function(pInx, m, playerID) {
		let nextPlayerID;
		if (playerID === ALICE_ID) {
			nextPlayerID = BOB_ID;
		} else if (playerID === BOB_ID){
			nextPlayerID = ALICE_ID;
		}//fi
		
		//cache hit
		if (playerCache[playerID][pInx][m] !== undefined ) {
			return playerCache[playerID][pInx][m];
		}//fi
		
		//base case: last few steps 
		if (lastPInx - pInx < 2*m) {			
			playerCache[playerID][pInx][m] = suffixPile[pInx];
			return playerCache[playerID][pInx][m];
		}//fi
		
		let currScore;
		let nextPlayerScore;
		let maxScore = 0;
		for (let i=1; i <= 2*m; i++) {
			nextPlayerScore = playerMove(pInx + i, Math.max(i, m), nextPlayerID); //this is score of opponent
			currScore = suffixPile[pInx + i] - nextPlayerScore;
			currScore += suffixPile[pInx] - suffixPile[pInx + i];
			maxScore = Math.max(maxScore, currScore);
		}//rof
		//console.log('playerID: ' + playerID + ' pInx: ' + pInx + ' m:' + m +  ' max score: ' + maxScore);
		playerCache[playerID][pInx][m] = maxScore;
		return maxScore;
		
	}//fi
		
	//step 1, generate post fix piles:
	suffixPile[piles.length] = 0;	
	for (let i=lastPInx; i >= 0; i--){
		suffixPile[i] = suffixPile[i+1] + piles[i];
	}//rof
	
	//console.log(suffixPile);
    return playerMove(0,1, ALICE_ID); 
};

let piles; 


piles = [2,7,9,4,4];

console.count('ans: ' + stoneGameII(piles));
