const w1CntArr = new Array(123);
const w2CntArr = new Array(123);


/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */
var closeStrings = function(word1, word2) {
	//edge case: words length are different
	if (word1.length != word2.length){
		return false;
	}//fi
	
	w1CntArr.fill(0,97,123);
	w2CntArr.fill(0,97,123);
	
	//step 1: populate character counts for both words
	for (let i=0; i<word1.length; i++){
		w1CntArr[word1.charCodeAt(i)]++;
		w2CntArr[word2.charCodeAt(i)]++;
	}//rof
	
	//step 2: find different frequencies
	let w1DiscArr = new Array();
	let w2DiscArr = new Array();
	for (let i=97; i<123; i++){
		if (w1CntArr[i] !== w2CntArr[i]) {
			if (w1CntArr[i] === 0 || w2CntArr[i] === 0) {
				return false;
			}//fi
			w1DiscArr.push(w1CntArr[i]);
			w2DiscArr.push(w2CntArr[i]);
		}//fi
	}//rof
	
	w1DiscArr.sort();
	w2DiscArr.sort();
	
    return w1DiscArr.every((value, index) => value === w2DiscArr[index]);;
};

var s1 = "bab";
var s2 = "cabbba";
var s3 = "bbba";

var t1 = "aba";
var t2 = "abbccc";
var t3 = "aaac";

let words1, words2;
/*
words1 = s1;
words2 = t1;
console.log("ans: " + closeStrings(words1, words2));
//*/

words1 = s3;
words2 = t3;
console.log("ans: " + closeStrings(words1, words2));



