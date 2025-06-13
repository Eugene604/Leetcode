/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
	let sum = 0;
	
	/**
	 * Recursively traverse the nums array and calculate the sum of all subset XOR values.
	 * 
	 * Precondition:
	 * - The nums array is available and contains the list of numbers.
	 * - The inx parameter is assumed to be within the bounds of the nums array.
	 * - The sum variable is available and initialized to 0.
	 * 
	 * @param {number} inx - The current index in the nums array.
	 * @param {number} cumXoredVal - The cumulative XOR value calculated so far.
 	 * @return {void}
	 */
	let traverseNum = function(inx, cumXoredVal) {
		if (inx === nums.length-1) {//last val
			sum += cumXoredVal;
			cumXoredVal ^= nums[inx];
			sum += cumXoredVal;
		} else {
			traverseNum(inx+1, cumXoredVal)
			traverseNum(inx+1, cumXoredVal ^= nums[inx]);
		}//fi		
	};//end method
	
	traverseNum(0, 0);
    return sum;
};


var nums;

nums = [1,3];
console.log("ans: " + subsetXORSum(nums));




