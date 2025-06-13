/**
 * @param {string} s
 * @return {string}
 */
var maximumOddBinaryNumber = function(s) {	
	let numOfOne = 0;
	let i;
	for (i=0; i<s.length; i++){
		if (s.charCodeAt(i)===49){
			numOfOne++;
		}//fi
	}//rof
	
	let maxOddNumBitArr = new Array(s.length);
	maxOddNumBitArr[s.length-1] = '1';	
	for (i=0; i<numOfOne-1; i++){
		maxOddNumBitArr[i] = '1';
	}//rof
	
	for (; i<s.length-1; i++){
		maxOddNumBitArr[i] = '0';
	}//rof
	
    return maxOddNumBitArr.join('');
};

var testFunc = function() {
	let str;

	str = "010";
	console.log("ans: " + maximumOddBinaryNumber(str));
};



testFunc();
