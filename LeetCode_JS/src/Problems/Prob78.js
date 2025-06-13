/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
	let subsetArr = [];
	
	/**
	 * Recursively traverse the nums array and get all setsets.
	 * 
	 * Precondition:
	 * - The nums array is available and contains the list of numbers.
	 * - The inx parameter is assumed to be within the bounds of the nums array.
	 * - The subsetArr variable is available and initialized to [].
	 * 
	 * @param {number} inx - The current index in the nums array.
	 * @param {number[]} subset - The subset accumulated so far.
 	 * @return {void}
	 */
	let traverseNum = function(inx, subset) {
		let subsetWithSelf = [...subset, nums[inx]];
				
		if (inx === nums.length-1) {//last val
			subsetArr.push(subset);
			subsetArr.push(subsetWithSelf);
		} else {
			traverseNum(inx+1, subsetWithSelf)
			traverseNum(inx+1, subset);
		}//fi		
	};//end method
	
	traverseNum(0, []);
    return subsetArr;
};


var nums;

nums = [1,3];
console.log("ans: " + JSON.stringify(subsets(nums)));




