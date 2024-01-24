/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function(s) {
	/**
	 * @param {number} charCode - ascii code
	 * @return {number} 0 = consonants, 1 = vowel
	 */
	let checkChar = function(charCode) {
		if (charCode === 65) {
			return 1;
		} else if (charCode === 69) {
			return 1;
		} else if (charCode === 73) {
			return 1;
		} else if (charCode === 79) {
			return 1;
		} else if (charCode === 85) {
			return 1;
		} else if (charCode === 97) {
			return 1;
		} else if (charCode === 101) {
			return 1;
		} else if (charCode === 105) {
			return 1;
		} else if (charCode === 111) {
			return 1;
		} else if (charCode === 117) {
			return 1;
		} else {
			return 0;
		}//fi					
	};
	let halfLength = s.length / 2;
	let vowelCntArr = new Array(2).fill(0);

	//step 1, populate vowel count array for first half of string
	for (let i = 0; i < halfLength; i++) {
		vowelCntArr[checkChar(s.charCodeAt(i))]++;
	}//rof

	//step 2, substract from array
	for (let i = halfLength; i < s.length; i++) {
		vowelCntArr[checkChar(s.charCodeAt(i))]--;
	}//rof


	if (vowelCntArr[1] !== 0) {
		return false;
	} else {
		return true;
	}//fi


};


var testFunc = function() {
	let str1 = "book";
	let str2 = "textbook";

	let str;


	str = str2;
	console.log("ans: " + halvesAreAlike(str));
};



testFunc();
