/**
 * @param {number[]} nums
 * @return {number}
 */
var minSwaps = function(nums) {

	let totalOnesCnt;
	let prefixOnesCntArr = new Array(nums.length*2);
	
	//step 1: populate prefix one's count array and meanwhile store total one's count 	
	prefixOnesCntArr[0] = (nums[0] === 1)? 1 : 0;
	let i;
	for (i=1; i<nums.length; i++){
		if (nums[i] === 1) {
			prefixOnesCntArr[i] = prefixOnesCntArr[i-1] + 1;
		} else {
			prefixOnesCntArr[i] = prefixOnesCntArr[i-1];
		}//fi
	}//rof
	totalOnesCnt = prefixOnesCntArr[i-1];
	for (j=0; i<prefixOnesCntArr.length; i++, j++){
		prefixOnesCntArr[i] = prefixOnesCntArr[j] + totalOnesCnt;		
	}//rof
	
	//console.log(JSON.stringify(prefixOnesCntArr));
	
	//step 2: use slide window to find max # of 1s given window size = totalOnesCnt
	let maxOnesWithinWnd = 0;
	
	for (let leftInx = 1, rightInx = totalOnesCnt; rightInx < prefixOnesCntArr.length; leftInx++, rightInx++){
		maxOnesWithinWnd = Math.max(maxOnesWithinWnd, prefixOnesCntArr[rightInx] - prefixOnesCntArr[leftInx-1]);
	}//rof
	
    return totalOnesCnt - maxOnesWithinWnd;
};

let nums;

nums = [0,1,0,1,1,0,0];
console.log('ans: ' + minSwaps(nums));
