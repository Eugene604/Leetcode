/**
 * @param {string} sentence
 * @param {string} searchWord
 * @return {number}
 */
var isPrefixOfWord = function(sentence, searchWord) {
	let wordArr = sentence.split(' ');
	//console.log(wordArr);
	for (let i=0; i<wordArr.length; i++){
		if (wordArr[i].startsWith(searchWord)){
			return i+1;
		}
	}
	
  	return -1;  
};

let sentence, searchWord;

sentence = "i love eating burger", searchWord = "burg";
console.log('Ans: ' + isPrefixOfWord(sentence, searchWord));