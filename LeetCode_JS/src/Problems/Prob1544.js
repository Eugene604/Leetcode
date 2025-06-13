/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
	
	//special case: single character or empty string
	if (s.length < 2){
		return s;
	}//fi
	let i;
	let hasChanged = true;
	while (hasChanged) {
		i=0;
		hasChanged = false;
		while (i<s.length-1){
			if (s.charCodeAt(i) === s.charCodeAt(i+1)+32 || s.charCodeAt(i+1) === s.charCodeAt(i)+32 ) {
				s = s.slice(0,i) + s.slice(i+2);
				hasChanged = true;
			} else {
				i++;
			}//fi
		}//end while
	}//end while

    return s;
};

var str1 = "leEeetcode";
var str2 = "abBAcC";
var str3 = "s";


let str;

str = str1;
console.log("ans: " + makeGood(str));



str = str2;
console.log("ans: " + makeGood(str));

str = str3;
console.log("ans: " + makeGood(str));
//*/
