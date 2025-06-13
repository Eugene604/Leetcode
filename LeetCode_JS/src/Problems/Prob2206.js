var cntArr = new Array(501);

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var divideArray = function(nums) {
	
	cntArr.fill(0);
	for (let num of nums){
		cntArr[num]++;		
	}//rof
	
	for (let cnt of cntArr) {
		if (cnt % 2 === 1) {
			return false;
		}
	}
    return true;
};

let nums;

nums = [3,2,3,2,2,2];

console.log('ans: ' + divideArray(nums));