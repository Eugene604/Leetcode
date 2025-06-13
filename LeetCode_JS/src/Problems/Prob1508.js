const MOD_CONST = 1000000007; 
/**
 * @param {number[]} nums
 * @param {number} n
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeSum = function(nums, n, left, right) {
	let prefixSumArr;
	let sbSumsArr;
	
	//step 1: populate prefix sum array
	prefixSumArr = new Array(nums.length);
	prefixSumArr[0] = nums[0];
	for (i=1; i<nums.length; i++){
		prefixSumArr[i] = nums[i] + prefixSumArr[i-1];
	}//rof

    
    //step 2: populate sums of all sub arrays
    sbSumsArr = [...nums, ...prefixSumArr];	
    sbSumsArr.shift(); //over counting nums[0] since nums[0] == prefixSum[0]
    for (let leftInx = 1; leftInx<prefixSumArr.length-1; leftInx++){
		for (let rightInx = leftInx+1; rightInx < prefixSumArr.length; rightInx++){
			sbSumsArr.push(prefixSumArr[rightInx]-prefixSumArr[leftInx-1]);
		}//rof		
	}//rof
	
	//step 3: sort sums of all sub arrays
	sbSumsArr.sort((a,b)=>a-b);
	
	//console.log(sbSumsArr);
	
	//step 4: calculate ans
	let rangeSum = 0;
	for (let i = left-1; i<right; i++){
		rangeSum += sbSumsArr[i] % MOD_CONST;
	}//rof

	return rangeSum % MOD_CONST;
};

let nums, n, left, right;

nums = [1,2,3,4], n = 4, left = 1, right = 5;
console.log('ans: ' + rangeSum(nums, n, left, right));//13


