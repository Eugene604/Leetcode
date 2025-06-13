"use strict";
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var largestDivisibleSubset = function(nums) {
	//step 1, sort
	nums.sort((a, b) => a - b);

	/**
	 * step 2, create new array, auxArr[][0] = largest divisible # count, auxArr[][1] = index of the largest divisor with such count
	 *  meanwhile, keep track of the longest one and its reference
	 */
	let globalLargestSetInx = 0;
	let auxArr = new Array(nums.length);
	auxArr[0] = new Array(2);
	auxArr[0][0] = 0;
	

	for (let i=1; i<nums.length; i++) {
		auxArr[i] = new Array(2);
		auxArr[i][0] = 0;
		for (let j=i-1; j>=0; j--) {			
			if (nums[i]%nums[j]===0 && auxArr[j][0] >= auxArr[i][0]){
				auxArr[i][0] = auxArr[j][0] + 1;
				auxArr[i][1] = j;
			}//fi
		}//rof
		if (auxArr[i][0] > auxArr[globalLargestSetInx][0]) {			
			globalLargestSetInx = i;				
		}//fi
	}//rof
	
	//step 3, retrieve the list of all divisible of longest element and return it
	let ansArr = new Array();
	let inx = globalLargestSetInx;
	while (inx !== undefined) {
		ansArr.push(nums[inx]);
		inx = auxArr[inx][1];
	}//end while
    return ansArr;
};

var nums1 = [5,9,18,54,90,180,360,720];
var nums2 = [1,2,4,8];
var nums3 = [1,2,3,4,6,8,9,10,12,14,15,16,18,20,21,22,24,26,27,28,30,32,33,34,36,38,39,40,42,44,45,46,48,50,51,52,54,56,57,58,60,62,63,64,66,68,69,70,72,74,75,76,78,81,84,87,90,93,96,99,102,105,108,111,114];
var nums4 = [5,9,18,54,108,540,90,180,360,720];


let nums;
nums = nums1;
console.log("ans: " + largestDivisibleSubset(nums));
console.log("correctAns: " + largestDivisibleSubset_v2(nums));

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function largestDivisibleSubset_v2(nums) {
	//step 1, sort
	nums.sort((a, b) => a - b);
	
	/**
	 * step 2, create new array, auxArr[][0] = largest divisible # count, auxArr[][1] = array of these numbers
	 *  meanwhile, keep track of the longest one and its reference
	 */
	let localLargestSetInx, globalLargestSetInx = 0;
	let auxArr = new Array(nums.length);
	auxArr[0] = new Array(2);
	auxArr[0][0] = 0;
	auxArr[0][1] = new Array(0);
	

	for (let i=1; i<nums.length; i++) {
		auxArr[i] = new Array(2);
		auxArr[i][0] = 0;
		auxArr[i][1] = new Array();
		localLargestSetInx = 0;
		for (let j=i-1; j>=0; j--) {			
			if (nums[i]%nums[j]===0 && auxArr[j][0] >= auxArr[i][0]){
				auxArr[i][0] = auxArr[j][0] + 1;
				localLargestSetInx = j;
				auxArr[i][1] = [nums[j],...auxArr[localLargestSetInx][1]];
			}//fi
		}//rof
		if (auxArr[i][0] > auxArr[globalLargestSetInx][0]) {			
			globalLargestSetInx = i;				
		}//fi
	}//rof
	
	//step 3, retrieve the list of all divisible of longest element and return it
	let ansArr = new Array();
	ansArr = [nums[globalLargestSetInx], ...auxArr[globalLargestSetInx][1]];
    return ansArr;
};



