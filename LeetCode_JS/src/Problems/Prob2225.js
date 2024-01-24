const playerRecord = new Array(100001);
/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function(matches) {
	playerRecord.fill(0, 1, 100001);

	//step 1, populate game record
	let winnerID, loserID;
	for (let i = 0; i < matches.length; i++) {
		winnerID = matches[i][0];
		loserID = matches[i][1];

		if (playerRecord[winnerID] >= 0) { //if this winner has not lost before
			playerRecord[winnerID]++;
		}//fi

		if (playerRecord[loserID] >= 0) { //if this loser has not lost before
			playerRecord[loserID] = -1;
		} else { //this player has lost before
			playerRecord[loserID]--;
		}//fi


	}//rof

	//step 2, traverse through game record and populate answer list
	let zeroOneLossArr = new Array(2);
	zeroOneLossArr[0] = new Array();
	zeroOneLossArr[1] = new Array();

	for (let i = 1; i < playerRecord.length; i++) {
		if (playerRecord[i] > 0) {
			zeroOneLossArr[0].push(i);
		} else if (playerRecord[i] == -1) {
			zeroOneLossArr[1].push(i);
		}//fi
	}//rof
	return zeroOneLossArr;
};

var matches1 = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [4, 9], [10, 4], [10, 9]];
var matches2 = [[2, 3], [1, 3], [5, 4], [6, 4]];



let matches;
matches = matches1;
console.log("ans: " + JSON.stringify(findWinners(matches)));

