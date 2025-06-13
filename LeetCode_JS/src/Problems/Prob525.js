
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
	//special cases, length not >= 2
	if (nums.length < 2) {
		return 0;
	}//fi
	let pSumArr = new Array(nums.length+1);
	pSumArr[0] = 0;
	for (let i=0; i<nums.length; i++){
		pSumArr[i+1] = nums[i] + pSumArr[i];		
	}//rof
	//console.log(pSumArr);
	let length = (nums.length%2 === 0) ? nums.length : nums.length-1;
	let wndSum, correctSum, sumDeviation;
	let lInx, rInx;
	while (length>1) {
		//console.log('check: ' + length);
		lInx = 1;
		rInx = length;
		correctSum = length/2;	
		while (rInx <= nums.length) {
			wndSum = pSumArr[rInx] - pSumArr[lInx-1];				
			if ((sumDeviation = Math.abs(wndSum - correctSum)) === 0) {
				//console.log('found at range: ' + lInx + ':' + rInx + ' wndSum: ' + wndSum);
				return length;
			} else {
				//console.log('sumDeviation at range: ' + sumDeviation );
				lInx+= sumDeviation;				
				rInx+= sumDeviation;
			}//fi				
		}//end while
		
		length-=2;
	}//end while
    return length;
};

var nums1 = [0,1];
var nums2 = [0, 1, 1, 1, 1, 1, 0, 1, 0, 1];


let nums;
nums = nums1;
console.log(nums);
console.log("ans: " + findMaxLength(nums));
