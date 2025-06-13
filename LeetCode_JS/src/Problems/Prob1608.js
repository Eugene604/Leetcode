/**
 * @param {number[]} nums
 * @return {number}
 */
var specialArray = function(nums) {
	nums.sort((a,b) => b-a);
	console.log(nums);
	let greaterEqualCnt = 0;
	let x = nums.length;	
	let inx=0;
	
	while (x>0 && inx<nums.length){
		if (nums[inx] >= x) {
			greaterEqualCnt++;
			inx++;
		} else if (x === greaterEqualCnt) {
				return x;
		} else {
			x--;
		}//fi		
	}//rof
	
	if (x===0 || x !== greaterEqualCnt ){
		return -1;
	} else {
		return x;
	}
        
};

let nums;

nums = [3,5];
console.log('ans: ' + specialArray(nums));


nums = [1,1,8];
console.log('ans: ' + specialArray(nums));