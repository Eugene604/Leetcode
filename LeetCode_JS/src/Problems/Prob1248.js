/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numberOfSubarrays = function(nums, k) {	
	for (let i=0; i<nums.length; i++){
		if (nums[i]%2 ===  0) {
			nums[i] = 0;
		} else {
			nums[i] = 1;
		}//fi
	}//rof
	
	//console.log(nums);
	
	/**
	 * 
	 * @param {number[]} nums - An array of integers where each integer is either 0 (even) or 1 (odd).
	 * @param {number} k - The maximum number of odd numbers allowed in a subarray.
	 * @return {number} - The number of subarrays that contain at most k odd numbers.
	 *
	 * This function calculates the number of subarrays that contain at most `k` odd numbers.
	 * It uses a sliding window approach to efficiently count the subarrays.
	 *
	 * The function maintains a sliding window defined by `leftInx` and `rightInx`.
	 * It iterates over the array with `rightInx` and adjusts `leftInx` to ensure that
	 * the number of odd numbers in the current window does not exceed `k`.
	 * The number of valid subarrays ending at `rightInx` is then added to `arrCnt`.
	 *
	 * Example:
	 * nums = [1, 1, 0, 1, 0]
	 * k = 2
	 * getSACnt(nums, k) returns 9, because there are 9 subarrays with at most 2 odd numbers:
	 * [1], [1], [0], [1], [0], [1, 1], [1, 0], [1, 0], [1, 1, 0]
	 */
	let getSACnt = function(nums, k){
		let arrCnt = 0;
		let leftInx = 0, rightInx = 0;
		let oddCnt = 0;
		while (rightInx < nums.length) {
			oddCnt += (nums[rightInx]===1)? 1 : 0;
			while (leftInx <= rightInx && oddCnt > k) {
				oddCnt -= (nums[leftInx]===1)? 1 : 0;
				leftInx++;
			}//end while
			
			arrCnt += rightInx - leftInx + 1;
			rightInx++;
		}//end while
		return arrCnt;
	};//end method
	
	let cnt = getSACnt(nums,k) - getSACnt(nums, k-1);
	return cnt;
};

var testFunc = function() {
	let nums, k;
	
	nums = [7,1,0,0,1,1], k = 1;
	console.log("ans: " + JSON.stringify(numberOfSubarrays(nums,k)));
	console.log("correct ans: " + JSON.stringify(numberOfSubarrays_v2(nums,k)));
};



testFunc();


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
function numberOfSubarrays_v2(nums, k) {
	let pfsArr = new Array(nums.length);
	if (nums[0]%2 ===  0) {
		pfsArr[0] = 0;
	} else {
		pfsArr[0] = 1;
	}//fi
	
	for (let i=1; i<nums.length; i++){
		if (nums[i]%2 ===  0) {
			pfsArr[i] = pfsArr[i-1];
		} else {
			pfsArr[i] = pfsArr[i-1] + 1;
		}//fi
	}//rof
	
	//console.log(pfsArr);
	
	let arrCnt = 0;
	let rightInx;
	let currOddCnt;
	let discrepancy;
	for (let length = k; length<=nums.length; length++) {
		for (let leftInx = 0; leftInx<nums.length-k; leftInx++){
			rightInx = leftInx + length - 1;
			if (pfsArr[rightInx] === k) {
				arrCnt++;
			}//fi
			leftInx++;
			rightInx++;
			while (rightInx < nums.length) {
				if ((currOddCnt = pfsArr[rightInx]-pfsArr[leftInx-1]) === k){
					arrCnt++;
					leftInx++;
					rightInx++;
				} else {
					discrepancy = Math.abs(k-currOddCnt);
					leftInx+=discrepancy;
					rightInx+=discrepancy;
				}//fi
			}//end while
		}//rof
	}//rof
    return arrCnt;
};
