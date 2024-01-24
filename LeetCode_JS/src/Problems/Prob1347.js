const cntArr = new Array(123);

/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function(s, t) {
	cntArr.fill(0,97,123);
	//step 1: populate character counts for both words
	for (let i=0; i<s.length; i++){
		cntArr[s.charCodeAt(i)]++;
		cntArr[t.charCodeAt(i)]--;
	}//rof
	
	//step 2: obtain steps by surveying the differences
	let steps = 0;
	for (let i=97; i<123; i++){
		if (cntArr[i] > 0) {
			steps += cntArr[i];
		}//fi
	}//rof
    return steps;
};



var s1 = "bab";
var s2 = "leetcode";
var s3 = "anagram";

var t1 = "aba";
var t2 = "practice";
var t3 = "mangaar";

let s, t;
s = s1;
t = t1;
console.log("ans: " + minSteps(s, t));

s = s2;
t = t2;
console.log("ans: " + minSteps(s, t));

s = s3;
t = t3;
console.log("ans: " + minSteps(s, t));



const sCCntArr = new Array(123);
const tCCntArr = new Array(123);

/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps_v2 = function(s, t) {
	sCCntArr.fill(0,97,123);
	tCCntArr.fill(0,97,123);
	//step 1: populate character counts for both words
	for (let i=0; i<s.length; i++){
		sCCntArr[s.charCodeAt(i)]++;
		tCCntArr[t.charCodeAt(i)]++;
	}//rof
	
	//step 2: obtain steps by surveying the differences
	let steps = 0;
	for (let i=97; i<123; i++){
		if (sCCntArr[i] > tCCntArr[i]) {
			steps += sCCntArr[i] - tCCntArr[i];
		}//fi
	}//rof
    return steps;
};
