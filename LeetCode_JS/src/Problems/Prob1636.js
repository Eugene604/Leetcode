/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
	const SHIFT_VAL = 100;
	let cntArr = new Array(SHIFT_VAL + SHIFT_VAL + 1).fill(0);
	for (let i=0; i<nums.length; i++){
		cntArr[nums[i] + SHIFT_VAL]++;
	}//rof
	
	nums.sort((a,b) => {
		if (cntArr[a + SHIFT_VAL] != cntArr[b + SHIFT_VAL]){
			return cntArr[a + SHIFT_VAL] - cntArr[b + SHIFT_VAL];
		} else {
			return b-a;
		}//fi
	});
    return nums;
};


let nums;

nums = [1,1,2,2,2,3]
console.log('ans: ' + JSON.stringify(frequencySort(nums)));
