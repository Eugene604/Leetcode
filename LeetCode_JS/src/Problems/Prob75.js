/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
	let cntMap = new Map();
	cntMap.set(0,0);
	cntMap.set(1,0);
	cntMap.set(2,0);
	
	let i;
	for (i=0; i<nums.length; i++){
		cntMap.set(nums[i],cntMap.get(nums[i])+1);
	}//rof
		
	let numInx=0;
	for (i=0; i<cntMap.get(0); i++, numInx++){
		nums[numInx]=0;
	}//rof
	
	for (i=0; i<cntMap.get(1); i++, numInx++){
		nums[numInx]=1;
	}//rof

	for (i=0; i<cntMap.get(2); i++, numInx++){
		nums[numInx]=2;
	}//rof	
    return nums;
};


let nums;

nums = [2,0,1];


console.log('ans: ' + JSON.stringify(sortColors(nums)));