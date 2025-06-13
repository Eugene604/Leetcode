/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
	
	/**
	 * Comparator to determine the order of two strings representing numbers.
	 * The strings are compared by forming two combinations:
	 * 1. [newStr] + [existingStr] - combination A
	 * 2. [existingStr] + [newStr] - combination B
	 * 
	 * The comparator checks which of the two combinations is greater. If combination A
	 * is greater, the new string should come before the existing string in the sorted order.
	 * If combination B is greater, the existing string comes first.
	 * 
	 * @param {string} existingStr - A string representation of an existing number.
	 * @param {string} newStr - A string representation of a new number to compare.
	 * @return {number} - Returns 1 if newStr should come before existingStr,
	 * -1 if existingStr should come first, and 0 if they are equal.
	 */
	let strComparator = function(existingStr, newStr) {
		
		/**
		 * comparison :
		 * [new][existing number] - combination A
		 * [existing number][new] - combination B
		 * 
		 * 
		 */
		let totalLength = existingStr.length + newStr.length;
		let combinAStrPtr = newStr;
		let combinBStrPtr = existingStr;
		let combinAInx = 0, combinBInx = 0;

		for (let i=0; i<totalLength; i++){
			if (combinAStrPtr.charCodeAt(combinAInx) > combinBStrPtr.charCodeAt(combinBInx)){
				//new str should be in front
				return 1;
			} else if (combinAStrPtr.charCodeAt(combinAInx) < combinBStrPtr.charCodeAt(combinBInx)) {
				//new str should be behind
				return -1;
			} else {//equal
				//do nothing
			}//fi
			combinAInx++;
			if (combinAInx === combinAStrPtr.length){
				combinAInx = 0;
				combinAStrPtr = existingStr;
			}//fi
			combinBInx++;
			if (combinBInx === combinBStrPtr.length){
				combinBInx = 0;
				combinBStrPtr = newStr;
			}//fi			
		}//rof
		
		return 0;
		
	};//end method */

	//step 1, convert all nums to strings and push to array
	let numStrArr = new Array(nums.length);
	for (let i=0; i<nums.length; i++){	
		numStrArr[i] = nums[i].toString();
	}//rof
	
	//step 2, sort according to comparator rules
	//console.log(numStrArr);
	numStrArr.sort(strComparator);
	//console.log(numStrArr);
	
	//step 3, check for special case
	let resultStr = numStrArr.reduce((aggStr, currentStr) => aggStr + currentStr, "");
	if (resultStr.charCodeAt(0) === 48) {
		return "0";
	}//fi
	
	
    return resultStr;
};

let nums;
nums = [121, 12];
console.log('ans: ' + largestNumber(nums));
 
