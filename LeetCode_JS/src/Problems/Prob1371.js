const VOWEL_CODE_ARR =[97,101,105,111,117];

/**
 * @param {string} s
 * @return {number}
 */
var findTheLongestSubstring = function(s) {
	let isEvenPostfixArr = Array.from({ length: 5 }, () => {
		const arr = new Array(s.length + 1);
		arr[s.length] = true; 
		return arr;
	});

	//step 1: populate is even posfix arr
	for (let vInx=0; vInx<5; vInx++){
		for (let i=s.length-1; i>=0; i--){
			if (s.charCodeAt(i) === VOWEL_CODE_ARR[vInx]){//is specified vowel
				isEvenPostfixArr[vInx][i] = !isEvenPostfixArr[vInx][i+1];
			} else {//not specified vowel
				isEvenPostfixArr[vInx][i] = isEvenPostfixArr[vInx][i+1];
			}//fi
		}//rof
	}//rof
	//console.log(isEvenPostfixArr);
	//step 2: process special case: s.length = 1
	if (s.length === 1){
		if (isEvenPostfixArr[0][0] &&
			isEvenPostfixArr[1][0] &&
			isEvenPostfixArr[2][0] &&
			isEvenPostfixArr[3][0] &&
			isEvenPostfixArr[4][0]) {
				return 1;
			} else {
				return 0;
			}//fi
	}//fi
	
	//step 3: check all range
	let leftInx, rightInx;
	for (let length=s.length; length>1; length--){
		for (leftInx = 0, rightInx = length-1; rightInx < s.length; leftInx++, rightInx++){
			if (!(isEvenPostfixArr[0][leftInx]^isEvenPostfixArr[0][rightInx+1]) &&
				!(isEvenPostfixArr[1][leftInx]^isEvenPostfixArr[1][rightInx+1]) &&
				!(isEvenPostfixArr[2][leftInx]^isEvenPostfixArr[2][rightInx+1]) &&
				!(isEvenPostfixArr[3][leftInx]^isEvenPostfixArr[3][rightInx+1]) &&
				!(isEvenPostfixArr[4][leftInx]^isEvenPostfixArr[4][rightInx+1])
			) {
				return length;
			}//fi
		}//rof
	}//rof
    return 1;
};

let s;

s = "a";
console.log('ans: ' + findTheLongestSubstring(s));
 
/*
s = "leetcodeisgreat";
console.log('ans: ' + findTheLongestSubstring(s));
//*/
