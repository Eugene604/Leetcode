/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
	let sqrNumsArr = new Array();
	for (let i=0; i<nums.length; i++){
		sqrNumsArr.push(nums[i]*nums[i]);
	}//rof
	sqrNumsArr.sort((a, b) => a - b);
    return sqrNumsArr;
};

var nums1 = [-4,-1,0,3,10];
var nums2 = [-7,-3,2,3,11];



let nums;
nums = nums1;

console.log("ans : " + sortedSquares(nums));
