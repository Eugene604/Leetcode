var numCnt = new Array(100001);
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
	numCnt.fill(0, 1, nums.length+1);
	for (let i=0; i < nums.length; i++){
		numCnt[nums[i]]++;
	}//rof
	//console.log(numCnt);
	let ansArr = new Array();
	for (let i=1; i <= nums.length; i++){
		if (numCnt[i] === 2) {
			ansArr.push(i);
		}//fi
	}//rof
    return ansArr;
};


let nums;


nums = [4,3,2,7,8,2,3,1];
console.log("ans : " + findDuplicates(nums));
