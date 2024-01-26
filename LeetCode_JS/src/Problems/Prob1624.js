/**
 * @param {string} strs
 * @param {number[]} neededTime
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
	let charInxMap = new Map();
	let currLength, maxLength = -1;
	
    for (let i = 0; i < s.length; i++){
		if(typeof charInxMap[s.at(i)]=='undefined'){
			charInxMap[s.at(i)] = i;
		} else {
			currLength = i - charInxMap[s.at(i)] - 1;
			if (currLength > maxLength){
				maxLength = currLength;
			}//fi
		}//fi		
	}//rof */
	
	return maxLength;	
};

var str1 = "aa";
var str2 = "abca";
var str3 = "cbzxy";


let str;
str = str1;
console.log("ans: " + maxLengthBetweenEqualCharacters(str));

str = str2;
console.log("ans: " + maxLengthBetweenEqualCharacters(str));

str = str3;
console.log("ans: " + maxLengthBetweenEqualCharacters(str));


///=== v2 ===

var charInxArr = new Array(123);
for (let i = 97; i <= 122; i++) {
  charInxArr[i] = [-1,-1];
}//rof

/**
 * @param {string} strs
 * @param {number[]} neededTime
 * @return {number}
 */
var maxLengthBetweenEqualCharacters_v2 = function(s) {
	//step 1: populate character indices
    for (let i = 0; i < s.length; i++){
		if(charInxArr[s.charCodeAt(i)][0]==-1){
			charInxArr[s.charCodeAt(i)][0] = i;
		} else {
			charInxArr[s.charCodeAt(i)][1] = i;
		}//fi		
	}//rof */
	
	//step 2: scan through a-z and find max range, also do clean up
	let currLength, maxLength = -1;
	for (let i = 97; i <= 122; i++) {
		if(charInxArr[i][0]==-1 && charInxArr[i][1]==-1){
			//do nothing
		} else if (charInxArr[i][1]==-1) {
			//do nothing and clean up
			charInxArr[i][0]= -1;
		} else {//calculate and clean up		
			currLength = charInxArr[i][1] - charInxArr[i][0] - 1;
			if (currLength > maxLength){
				maxLength = currLength;
			}//fi
			charInxArr[i][0]= -1;
			charInxArr[i][1]= -1;
		}//fi
		

	}//rof */
	return maxLength;
	
};


//=== v3, actually slower than v2===
/**
 * @param {string} strs
 * @param {number[]} neededTime
 * @return {number}
 */
var maxLengthBetweenEqualCharacters_v3 = function(s) {
	let charInxArr = new Array(123);
	let currLength, maxLength = -1;
	
    for (let i = 0; i < s.length; i++){
		if(typeof charInxArr[s.charCodeAt(i)]=='undefined'){
			charInxArr[s.charCodeAt(i)] = i;
		} else {
			currLength = i - charInxArr[s.charCodeAt(i)] - 1;
			if (currLength > maxLength){
				maxLength = currLength;
			}//fi
		}//fi		
	}//rof */
	
	return maxLength;	
};