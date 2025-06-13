/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var beautifulSubsets = function(nums, k) {
	nums.sort((a, b) => a - b);
	//console.log(nums);
	
    let subsetCnt = 0;
	
	/**
	 * Recursively traverse the nums array and get all setsets under constraint that abs diff must not be k
	 * 
	 * Precondition:
	 * - The nums array is available and sorted
	 * - The number k is available 
	 * - The inx parameter is assumed to be within the bounds of the nums array.
	 * - The subsetArr variable is available and initialized to [].
	 * 
	 * @param {number} inx - The current index in the nums array.
	 * @param {number[]} subset - The subset accumulated so far.
 	 * @return {void}
	 */
	let traverseNum = function(inx, subset) {

		let canIncludeSelf = true;		
		for (let i=0; i<subset.length; i++) {
			if (nums[inx]-subset[i] === k) {				
				canIncludeSelf = false;
				break;
			}//rof
		}//rof
		
		//console.log("subset: " + JSON.stringify(subset) + " nums[inx]: " + nums[inx] + " canIncludeSelf:" + canIncludeSelf);
				
		if (canIncludeSelf) {
			let subsetWithSelf = [...subset, nums[inx]];
			if (inx === nums.length-1) {//last val
				subsetCnt++;//one for subset withself
				subsetCnt += (subset.length === 0)? 0:1;//one for subset without self, if not empty
			} else {
				traverseNum(inx+1, subsetWithSelf)
				traverseNum(inx+1, subset);
			}//fi	
		} else {
			if (inx === nums.length-1) {//last val
				subsetCnt += (subset.length === 0)? 0:1;
			} else {
				traverseNum(inx+1, subset);
			}//fi
		}//fi
		
	
	};//end method
	
	traverseNum(0, []);
    return subsetCnt;
};


let k, nums;
k=2;
nums = [2,4,6];
console.log("ans: " + JSON.stringify(beautifulSubsets(nums, k)));




