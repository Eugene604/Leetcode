/**
 * @param {string[]} words
 * @param {character} x
 * @return {number[]}
 */
var findWordsContaining = function(words, x) {
	let inxArr = new Array();
	for (let wordInx = 0; wordInx < words.length; wordInx++) {
		if (words[wordInx].includes(x)){
			inxArr.push(wordInx);
		}//rof
	}//rof
    return inxArr;
};

let words, x;
words = ["leet","code"], x = "e";
console.log('ans: ' + findWordsContaining(words, x));