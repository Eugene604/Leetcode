//key = string segment, value = number of decoding ways
var countMap = {};
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
	//console.log("entered s "  + s);
	/**
	 * base cases:
	 * - leading digit is 0
	 * - string length is 1 
	 * - string length is 2 but contains trailing zero
	 * - string length zero 
	 */
	if (s.charAt(0)=='0') {
		return 0; 
	} else if (s.length==0 || s.length==1 || (s.length==2&&(+s.charAt(0)<3)&&s.charAt(1)=='0')){		
		return 1;	
	}//fi
		
	
	if (s.length>5 && countMap[s]) {
		return countMap[s];
	}//fi
	
	let numOfDCWays = 0;
	
	if (s.charAt(0)=='1'){
		if (s.charAt(1)=='0') {
			numOfDCWays = numDecodings(s.slice(2));
		} else {
			numOfDCWays = numDecodings(s.slice(1)) + numDecodings(s.slice(2));
		}//fi		
	} else if (s.charAt(0)=='2') {		
		if (s.charAt(1)=='0') {
			numOfDCWays = numDecodings(s.slice(2));
		} else if(+s.charAt(1)>6) {
			numOfDCWays = numDecodings(s.slice(1));
		} else {
			numOfDCWays = numDecodings(s.slice(1)) + numDecodings(s.slice(2));
		}//fi
	} else {
		numOfDCWays = numDecodings(s.slice(1));
	}//fi */
	
	if (s.length>5) {
		countMap[s] = numOfDCWays;
	}//fi
    return numOfDCWays;
};



var str1 = "230";
var str2 = "2101";
var str3 = "111111111111111111111111111111111111111111111111111";
var testStr;
/*
testStr = str1;
console.log("ans: " + numDecodings(testStr));
testStr = str3;
console.log("ans: " + numDecodings(testStr));

testStr = str1;
console.log("ans: " + numDecodings(testStr));
//*/


