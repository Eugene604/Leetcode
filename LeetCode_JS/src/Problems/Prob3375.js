/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
	let distNumSet = new Set();
	for (let num of nums) {
		if (num < k) {
			return -1;
		} else if (num > k){
			distNumSet.add(num);
		}//fi
	}//rof
    return distNumSet.size;
};


let nums;
let k;

 nums = [5,2,5,4,5], k = 2;
 
 console.log('ans: ' + minOperations(nums, k));