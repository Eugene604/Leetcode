/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
	let maxDepth = 0;
	let unclosedLeftBracketCnt = 0;
	for (let i=0; i<s.length; i++){
		if (s[i]==="("){
			unclosedLeftBracketCnt++;
		} else if (s[i]===")"){
			if (unclosedLeftBracketCnt > maxDepth) {
				maxDepth = unclosedLeftBracketCnt;
			}//fi
			unclosedLeftBracketCnt--;
		}//fi
	}//rof
    return maxDepth;
};

var str1 = "(1+(2*3)+((8)/4))+1";
var str2 = "(1)+((2))+(((3)))";



let str;
str = str2;
console.log("ans: " + maxDepth(str));

