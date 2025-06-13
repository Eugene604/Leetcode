const CNT_MARK = 0b10000000000000000;
const UNCNT_MASK = 0b1111111111111111;
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
	console.log(nums);
	let arrElement;
	let len = nums.length;
	for (let i=0; i<len; i++){
		arrElement = nums[i]&UNCNT_MASK;		
		nums[arrElement] |=  CNT_MARK;
	}//rof
	
	//console.log(nums);
	
	for (let i=0; i<nums.length; i++){
		if (nums[i] < CNT_MARK) {
			return i;
		}//fi
	}//rof	
    return nums.length;
};

var testFunc = function() {
	let nums1 = [1];
	let nums2 = [0,1];
	let nums3 = [9,6,4,2,3,5,7,0,1];

	let nums;


	nums = nums1;
	console.log("ans: " + missingNumber(nums));
};



testFunc();
