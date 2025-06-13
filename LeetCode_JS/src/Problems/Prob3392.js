/**
 * @param {number[]} nums
 * @return {number}
 */
var countSubarrays = function(nums) {
	let cnt = 0;
	for (let fInx=0, mInx=1, rInx=2; rInx<nums.length; fInx++, mInx++, rInx++ ){
		if (nums[mInx]/2 === nums[fInx] + nums[rInx]){
			cnt++;
		}//fi
	}//rof
    return cnt;
};


let nums;
nums = [1,2,1,4,1];
console.log('ans: ' + countSubarrays(nums));