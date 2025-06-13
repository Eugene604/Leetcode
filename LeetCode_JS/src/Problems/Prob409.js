/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
	let cntArr = new Array(123).fill(0, 65, 123);
	for (let i=0; i<s.length; i++) {
		cntArr[s.charCodeAt(i)]++;
	}//rof
	
	let palindromeLength = 0;	
	let containsAnOddCnt = false;
	for (let i=65; i<123; i++){
		if (cntArr[i]%2 == 1) {
			containsAnOddCnt = true;
			palindromeLength += cntArr[i]-1;
		} else {
			palindromeLength += cntArr[i];
		}//fi
		
	}//rof
	

	
    return containsAnOddCnt ? palindromeLength+1 : palindromeLength;
};

var testFunc = function() {
	let s;


	s = "abccccdd";
	console.log("ans: " + longestPalindrome(s));
};



testFunc();
