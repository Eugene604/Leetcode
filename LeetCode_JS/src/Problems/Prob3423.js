/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAdjacentDistance = function(nums) {
	let absDiff = 0;
	let localDiff;
	for(let i=0; i< nums.length-1; i++){
		localDiff = Math.abs(nums[i+1] - nums[i]);
		absDiff = Math.max(localDiff, absDiff);
	}//rof
	absDiff = Math.max(absDiff, Math.abs(nums[0] - nums[nums.length-1]));
	return absDiff;
    
};

let nums;

nums = [-5,-10,-5];

console.log(' ans: ' + maxAdjacentDistance(nums));

