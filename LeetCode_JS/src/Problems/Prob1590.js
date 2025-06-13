/**
 * @param {number[]} nums
 * @param {number} p
 * @return {number}
 */
var minSubarray = function(nums, p) {
	let postfixModSumArr = new Array(nums.length+1);
	let pmsToInxMap = new Map();//postfixModSum to Index map
	
	//step 1: build postfix mod sum array 
	postfixModSumArr[nums.length] = 0;
	for (let i=nums.length-1; i>=0; i--){
		postfixModSumArr[i]=(postfixModSumArr[i+1]+nums[i])%p;		
	}//rof
	//console.log(postfixModSumArr);
	
	//step 2: check for edge cases
	if (postfixModSumArr[0] === 0){//whole array is already divisible by p
		return 0;
	}//fi
	
	let minLength = nums.length;
	for (let i=0; i<nums.length; i++){		
		if (nums[i]%p === postfixModSumArr[0]){ //removing one element will do
			return 1;
		} else if (postfixModSumArr[i] === 0){//removing from head to the element before this
			minLength = Math.min(minLength, i);
		}//fi		
	}//rof
	
		
	//step 3: iterate through whole array
	let modPMSDiff;
	let targetRightPMSInx;
	let targetRightPMS;
	
	for (let leftPMSInx=nums.length-1; leftPMSInx>0; leftPMSInx--){
		modPMSDiff = postfixModSumArr[0] - postfixModSumArr[leftPMSInx];		
		if (modPMSDiff === 0){
			minLength = Math.min(minLength, nums.length-leftPMSInx);
		} else if (modPMSDiff < 0){
			targetRightPMS = -modPMSDiff;
		} else if (modPMSDiff > 0){
			targetRightPMS = p - modPMSDiff;	
		}//fi	
		
		if ((targetRightPMSInx = pmsToInxMap.get(targetRightPMS)) !== undefined) {//check for right modPMS	
			minLength = Math.min(minLength, targetRightPMSInx-leftPMSInx);		
		}//fi
				
		pmsToInxMap.set(postfixModSumArr[leftPMSInx],leftPMSInx);
	}//rof 
	if (minLength === nums.length){
		return -1;	
	} else {
		return minLength;
	}//fi
    
};

/**
 * @param {number[]} nums
 * @param {number} p
 * @return {number}
 */
var minSubarray_correct = function(nums, p) {
    let totalSum = nums.reduce((a, b) => a + b, 0);

    // Find the remainder when total sum is divided by p
    let rem = totalSum % p;
    if (rem === 0) return 0;  // If the remainder is 0, no subarray needs to be removed

    let prefixMod = new Map();
    prefixMod.set(0, -1);  // Initialize to handle full prefix
    let prefixSum = 0;
    let minLength = nums.length;

    for (let i = 0; i < nums.length; i++) {
        prefixSum += nums[i];
        let currentMod = prefixSum % p;
        let targetMod = (currentMod - rem + p) % p;

        if (prefixMod.has(targetMod)) {
			console.log('right ans found: ' + prefixMod.get(targetMod) + ":" + i);		
            minLength = Math.min(minLength, i - prefixMod.get(targetMod));
        }//fi
        prefixMod.set(currentMod, i);
    }
	console.log(prefixMod);
    return minLength === nums.length ? -1 : minLength;
};

var testFunc = function() {
	let nums, p;

	nums = [15,14,48,5,12,53,1,11,1,32,14,51,11,44,45,33,8,24,42,56,54,54,14,8,44,45,48,16], p = 22;
	
	console.log("ans: " + minSubarray(nums, p));
	console.log("correct ans: " + minSubarray_correct(nums, p));
	
	/*
	
	nums = [6,3,5,2], p = 9;
	console.log("ans: " + minSubarray(nums, p));
	console.log("correct ans: " + minSubarray_correct(nums, p));
	
	
	nums = [19,25,39,31,20,10,40,38,28,35,11,11,18,26,26,24,29,14,10,37], p = 23;
	console.log("ans: " + minSubarray(nums, p));
	console.log("correct ans: " + minSubarray_correct(nums, p));	
	//*/
};



testFunc();


