/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
	let lInx = 0;
	let rInx = s.length-1;
	let tmpChar;
	while (lInx < rInx) {
		tmpChar = s[lInx];
		s[lInx] = s[rInx];
		s[rInx] = tmpChar;
		lInx++;
		rInx--;
	}//end while
    return s;
};

var str1 =  ["h","e","l","l","o"];
var str2 = "abBAcC";
var str3 = "s";


let str;

str = str1;
console.log("ans: " + reverseString(str));



//*/
