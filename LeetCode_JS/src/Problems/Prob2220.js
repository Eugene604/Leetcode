/**
 * @param {number} start
 * @param {number} goal
 * @return {number}
 */
var minBitFlips = function(start, goal) {
    let xoredVal = start^goal;
    let flipCnt = 0;
    while (xoredVal !== 0) {
		if (xoredVal%2 === 1){
			flipCnt++;
		}//fi
		xoredVal>>=1;
	}//end while
	return flipCnt;
};

let start, goal;

start = 10, goal = 7;
console.log('ans: ' + minBitFlips(start, goal));

/*


//*/