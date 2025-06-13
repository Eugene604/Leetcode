/**
 * @param {string} s
 * @return {number}
 */
var scoreOfString = function(s) {
	let score = 0;
	for (let i=1; i<s.length; i++) {
		score += Math.abs(s.charCodeAt(i)-s.charCodeAt(i-1));
	}//rof
    return score;
};

var str1 = "hello";
var str2 = "abBAcC";
var str3 = "s";


let str;

str = str1;
console.log("ans: " + scoreOfString(str));



//*/
