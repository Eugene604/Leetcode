
/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function(n) {
   /**
	* Precondition:
	* - This method is NOT suitable for populating single-digit numbers. 
	*   It is suitable for multi-digit situations where `prefixNum` is a digit 1-9.
	* 
	* Postcondition:
	* - The method appends numbers starting with `prefixNum` and extending lexicographically,
	*   up to `maxNum`, while ensuring it stays within bounds.
	* 
	* Algorithm:
	* - The method first extends `prefixNum` by multiplying it by 10 (to go to the next level of digits).
	* - If the current number formed exceeds `maxNum`, it stops recursion at that point.
	* - Otherwise, it appends numbers from `prefixNum*10` to `prefixNum*10 + 9`, recursively
	*   calling the method for each appended number to further extend the sequence.
	* @param {number[]} arr - The array to which numbers in lexicographical order are appended.
	* @param {number} prefixNum - The current prefix number to be extended by appending digits.
	* @param {number} maxNum - The maximum number (n) that bounds the appending process.
	* 	
	*/
	let appendNum = function(arr, prefixNum, maxNum){
		let currPrefixNum = prefixNum * 10;
		if (currPrefixNum > n) {//this level already exceeds original n
			return;
		}//fi
		let maxBound = currPrefixNum+9;
		for (let currNum = currPrefixNum; currNum <= maxNum && currNum <= maxBound; currNum++){
			arr.push(currNum);
			appendNum(arr, currNum, maxNum);
		}//rof
	};//end method
	
	let resultArr = [];
	//special case, n<10
	if (n<10){
		for (let i=1; i<=n; i++){
			resultArr.push(i);
		}//rof
	} else {
		for (let i=1; i<=9; i++){
			resultArr.push(i);
			appendNum(resultArr, i, n);
		}//rof
	}//fi
	return resultArr;

};

let n;


n = 13;
console.log('Ans: ' + JSON.stringify(lexicalOrder(n)));