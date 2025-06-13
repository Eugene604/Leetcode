/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
	//special cases, nums length is 1 or 2
	if (nums.length < 3) {
		return nums[0];
	}//fi
	
	let cntMap = new Map();
	let cnt;
	for (let i=0; i<nums.length; i++){
		if ((cnt=cntMap.get(nums[i]))!==undefined) {
			cntMap.set(nums[i], cnt+1);
		} else {
			cntMap.set(nums[i], 1);
		}//fi
	}//rof	
	
	let threshold = nums.length / 2;	
	for (let [key, value] of cntMap) {
	  if (value > threshold){
		  return key;
	  }//fi
	}//rof
	//console.log(cntMap);
    return 0;
};

var arr1 = [3,2,3];
var arr2 = [2,2,1,1,1,2,2];

let arr;


arr = arr1;

console.log("ans: " + majorityElement(arr));



