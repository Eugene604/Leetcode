/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
	let maxNum = 0;
	let maxSBLength = 0;
	let currConsecuMaxCnt = 0;
	
	for (let i=0; i<nums.length; i++){
		if (nums[i]<maxNum){
			currConsecuMaxCnt = 0;
			continue;			
		} else if (nums[i]>maxNum){
			maxNum = nums[i];
			maxSBLength = 0;
			currConsecuMaxCnt = 1;
			maxSBLength = Math.max(currConsecuMaxCnt, maxSBLength);
		} else { // nums[i] == maxNum
			currConsecuMaxCnt++;
			maxSBLength = Math.max(currConsecuMaxCnt, maxSBLength);
		}//fi
	}//rof
    
    return maxSBLength;
};

let nums; 

nums = [1,1,1,1,1,1,2,2];

console.log('ans: ' + longestSubarray(nums));
