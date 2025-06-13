
/**
 * @param {string} n
 * @return {string}
 */
var nearestPalindromic = function(n) {
	 /**
     * Generates a palindrome number based on a given root number.
     * @param {bigint} palinRootNum - The root number to generate a palindrome from.
     * @param {boolean} isEven - Indicates whether the length of the original number is even.
     * @return {bigint} - The generated palindrome number.
     */
	let generatePalinNum = function(palinRootNum, isEven){
		let palinNum = palinRootNum;
		if (isEven){
			palinNum = palinNum*10n + palinRootNum%10n;
		}//fi
		palinRootNum = palinRootNum/10n;
		
		while (palinRootNum > 0n){
			palinNum = palinNum*10n + palinRootNum%10n;
			palinRootNum = palinRootNum/10n;
			//console.log(palinRootNum);
		}//end while
		return palinNum;
	}//end method
	
	/**
     * Generates a list of palindrome candidates based on a given string number.
     * @param {string} numStr - The input number as a string.
     * @return {bigint[]} - An array of potential palindrome numbers.
     */
	let generatePalinCandidate = function(numStr){
		let strLen = numStr.length;
		let strHalfLen = Math.ceil(strLen/2);
		let palinRootNum = BigInt(numStr.slice(0,strHalfLen));
		let palinNum;
		
		let palinCandidateArr = new Array();
		
		//add 999 and 1001
		palinNum = 10n ** BigInt(strLen);
		palinCandidateArr.push(palinNum-1n);
		palinCandidateArr.push(palinNum+1n);
		palinNum = 10n ** BigInt(strLen-1);
		palinCandidateArr.push(palinNum-1n);
		palinCandidateArr.push(palinNum+1n);
		
		//add parlinRoot's palindrome
		if (strLen === 1) {//single digit
			palinNum = BigInt(n);
			palinCandidateArr.push(palinNum-1n);
			palinCandidateArr.push(palinNum+1n);
			
		}//fi
		
		let isEven = strLen%2 == 0;

		//self
		palinNum = generatePalinNum(palinRootNum, isEven);
		palinCandidateArr.push(palinNum);
			
		//mid + 1
		palinNum = generatePalinNum(palinRootNum+1n, isEven);
		palinCandidateArr.push(palinNum);

		palinNum = generatePalinNum(palinRootNum-1n, isEven);
		palinCandidateArr.push(palinNum);
		
		
		return palinCandidateArr;
	}//end method
	
	let palinCandidateArr = generatePalinCandidate(n);
	//console.log(palinCandidateArr);
	let minGap = Number.POSITIVE_INFINITY;
	let gap;
	let closetPalin;
	let originalNum = BigInt(n);
	for (let palinCandidate of palinCandidateArr){
		gap = originalNum - palinCandidate;
		gap = gap < 0n ? -gap : gap;
		if (gap === 0n){
			continue;
		} else if (gap < minGap) {
			minGap = gap;
			closetPalin = palinCandidate;
		} else if (gap === minGap) {
			closetPalin = closetPalin < palinCandidate ? closetPalin : palinCandidate;
		}//fi			
	}
	return closetPalin.toString();
};

let n; 


n = "19991";
console.count('ans: ' + nearestPalindromic(n));

