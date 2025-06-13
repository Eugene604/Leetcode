var primaryStackArr = new Array(100_001);
var secondaryStackArr = new Array(100_001);
/**
 * @param {string} s
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var maximumGain = function(s, x, y) {
	let primaryPattern, secondaryPattern;
	let primaryScore, secondaryScore;
	if (x>y) {
		primaryPattern = [0,1];
		secondaryPattern = [1,0];
		primaryScore = x;
		secondaryScore = y;
	} else {
		primaryPattern = [1,0];
		secondaryPattern = [0,1];
		primaryScore = y;
		secondaryScore = x;
	}
	
	/**
	 * calculate the maximum score from removing patterns in sbArr.
	 * Precondition:
	 * - sbArr is an array representation of a substring that contains only 0s (representing 'a') and 1s (representing 'b').
	 * - primaryPattern, secondaryPattern, primaryScore, secondaryScore are set and valid.
	 * 
	 * 
	 * @param {number[]} sbArr - Array representation of a substring containing only 0s (representing 'a') and 1s (representing 'b').
	 * @returns {number} The maximum score obtained by removing patterns in sbArr.
	 */
	let getMaxScore = function (sbArr) {		
		//special case: 
		if (sbArr.length < 2) { //length too short
			return 0;
		}//fi
		
		//console.log('getMaxScore called, arr: ' + sbArr);
		
		let score = 0;
		//pass 1: remove primary pattern		
		let pStkPtr = -1;
		for (let sbArrPtr=0; sbArrPtr<sbArr.length; sbArrPtr++){
			//console.log('primaryStackArr: ' + primaryStackArr);
			if (primaryStackArr[pStkPtr]===primaryPattern[0] && sbArr[sbArrPtr]===primaryPattern[1]) {
				score += primaryScore;
				pStkPtr--;				
			} else{
				primaryStackArr[++pStkPtr] = sbArr[sbArrPtr];
			}//fi
		}//rof

		//console.log('primaryStackArr: ' + primaryStackArr);
		
		//pass 2: remove secondary pattern	
		let secStkPtr = -1;
		let primaryStkSize = pStkPtr+1;
		for (pStkPtr=0; pStkPtr<primaryStkSize; pStkPtr++){
			if (secondaryStackArr[secStkPtr]===secondaryPattern[0] && primaryStackArr[pStkPtr]===secondaryPattern[1]) {
				score += secondaryScore;
				secStkPtr--;
			} else{
				secondaryStackArr[++secStkPtr] = primaryStackArr[pStkPtr];
			}//fi
		}//rof */
		
		return score;
	};//end function
	
	let totalScore = 0;
	let abSbArr = [];
	for (let i=0; i<s.length; i++){
		if (s[i] === "a") {
			abSbArr.push(0);
		} else if (s[i] === "b") {
			abSbArr.push(1);
		} else if (abSbArr.length === 0) {
			//do nothing		
		} else if (abSbArr.length < 2) {			
			abSbArr = [];
		} else { //in this case,  abSbArr.length >= 2 
			totalScore += getMaxScore(abSbArr);
			abSbArr = [];		
		}//fi
	}//rof
	if (abSbArr.length > 1) {
		totalScore += getMaxScore(abSbArr);
	}//fi
  	return totalScore;  
};

var testFunc = function() {
	let s, x, y;

	/*
	s = "cdbcbbaaabab", x = 4, y = 5;	
	console.log("ans: " + maximumGain(s, x, y));
	//*/
	s = "cdbcbbaaabab", x = 4, y = 5;	
	console.log("ans: " + maximumGain(s, x, y));
};



testFunc();
