/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
	let isPalCache = new Array(s.length).fill().map(() => Array(s.length).fill());
	{
		for (let i=0; i<s.length; i++){
			isPalCache[i][i] = true;
		}//rof
	}
	/**
	 * checks if the substring specified by begin index and end index (all inclusive) is palindromic or not
	 * precondition: 
	 *  - assume begin and end indices are valid. This method does NOT check for range validity
	 * @param {string} beginInx - begin index, inclusive
	 * @param {string} endInx - end index, inclusive
	 * @return {boolean} true if substring palidromic
	 */
	let isPalindromic = function(beginInx, endInx){
		if (isPalCache[beginInx][endInx] !== undefined){
			return isPalCache[beginInx][endInx];
		}//fi
		//base case - begin and end indices differ by 1
		if (endInx - beginInx === 1) {
			isPalCache[beginInx][endInx] = s.charCodeAt(beginInx) === s.charCodeAt(endInx);
			return isPalCache[beginInx][endInx];
		} else {
			isPalCache[beginInx][endInx] = s.charCodeAt(beginInx) === s.charCodeAt(endInx) && isPalindromic(beginInx+1,endInx-1);
			return isPalCache[beginInx][endInx];
		}//fi
		
	}//end method
	
	let palCnt = 0;
	for (let leftInx=0; leftInx<s.length; leftInx++){
		for (let rightInx=leftInx; rightInx<s.length; rightInx++){
			if (isPalindromic(leftInx, rightInx)){
				palCnt++;
			}//fi
				
			
		}//rof
	}//rof
	//console.log(isPalCache);
    return palCnt;
};

var str1 = "abc";
var str2 = "aaa";
var str3 = "kkkk";


let str;
str = str3;
console.log("ans: " + countSubstrings(str));
console.log("correctAns: " + correctAns(str));

/*
str = str2;
console.log("ans: " + countSubstrings(str));
//*/



/**
 * @param {string} s
 * @return {number}
 */
function correctAns(s) {
	const extendPalindrome = (s, left, right) => {
    let count = 0;
    while (left >= 0 && right < s.length && s[left] === s[right]) {
        count++;
        left--;
        right++;
    }
    return count;
};

    let totalCount = 0;
    for (let i = 0; i < s.length; i++) {
        // Count palindromes with odd length
        totalCount += extendPalindrome(s, i, i);
        // Count palindromes with even length
        totalCount += extendPalindrome(s, i, i + 1);
    }
    return totalCount;
};



