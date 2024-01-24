/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
	let cntArr = new Array(nums.length+1).fill(0);
	for (let i=0; i<nums.length; i++){
		cntArr[nums[i]]++;
	}//rof
    let ansArr = new Array(2);
    
    for (let i=1; i<cntArr.length; i++){
		if (cntArr[i] === 2) {
			ansArr[0] = i;
		} else if (cntArr[i] === 0) {
			ansArr[1] = i;
		}//fi
	}//rof
	return ansArr;
};

var nums1 = [1,2,2,4];
var nums2 = [1,1];


let nums;
nums = nums1;
console.log("ans: " + findErrorNums(nums));




