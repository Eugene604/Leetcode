/**
 * @param {string} strs
 * @param {number[]} neededTime
 * @return {number}
 */
var makeEqual = function(words) {
    let charCntArr = new Array(123);
    charCntArr.fill(0, 97);

    for (let word of words) {		
	    for (let i = 0; i < word.length; i++){			
			charCntArr[word.charCodeAt(i)]++;
		}//rof
	}//rof
	
	const totalWords = words.length;
	 
	for (let i = 97; i < 123; i++){
		if(charCntArr[i]%totalWords!=0){
			return false;
		}//fi		
	}//rof */
	return true;
};

var str1 = ["abc","aabc","bc"];



let str;
str = str1;
console.log("ans: " + makeEqual(str));



var maxLengthBetweenEqualCharacters_v3 = function(s) {
	let charInxArr = new Array(123);
	let currLength, maxLength = -1;
	

	
	return maxLength;	
};