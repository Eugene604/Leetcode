/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
	let cntMap = new Map();
	//step 1: populate value count
	let cnt;
	for (let i=0; i<nums.length; i++){
		cnt = cntMap.get(nums[i]);
		if (cnt === undefined){
			cntMap.set(nums[i],1);
		} else {
			cntMap.set(nums[i],cnt+1);
		}//fi
	}//rof
	//console.log(cntMap);
	//step 2: iterate through each value count and obtain required operations
	let totalNumOfOp = 0;
	let currNumOfOp;
	for (let cnt of cntMap.values()){
		if (cnt === 1) {
			return -1;
		} else if (cnt%3 === 0) { //eg, 9, which is 3+3+3
			currNumOfOp = cnt/3;
		} else if (cnt%3 === 1) { //eg, 7, which is 3+2+2
			currNumOfOp = (cnt-4)/3;
			currNumOfOp += 2;
		} else if (cnt%3 === 2) { //eg, 5, which is 3+2 		
			currNumOfOp = (cnt-2)/3;
			currNumOfOp += 1;		
		}//rof
		//console.log("process " + cnt + " currNumOfOp: " + currNumOfOp);
		totalNumOfOp += currNumOfOp;
		
	}//rof
    return totalNumOfOp;
};



var arr1 = [2,3,3,2,2,4,2,3,4];
var arr2 = [2,1,2,2,3,3];



let nums;
nums = arr1;

console.log("ans : " + minOperations(nums));
