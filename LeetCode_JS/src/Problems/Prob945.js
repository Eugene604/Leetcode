var countArr = new Array(200_001);

/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function(nums) {
	//step 1, populate count
	countArr.fill(0);
	let minNum = 100_001;
	for (let i=0; i<nums.length; i++){
		countArr[nums[i]]++;
		minNum = Math.min(minNum, nums[i]);
	}//rof
	//console.log('minNum: ' + minNum);
	//console.log(countArr);
	//step 2, use duplicateQueue calculate number of increments needed
	let duplicateQueue = new Array();
	let increCnt = 0;
	for (let i=minNum; duplicateQueue.length > 0 || i<100_001; i++){
		if (countArr[i] === 0) {// empty slot encountered
			if (duplicateQueue.length > 0) {//has duplicates waiting
				increCnt += i-duplicateQueue.shift();
			}//fi			
			continue;
		}//fi
		
		while (countArr[i] > 1) {
			countArr[i]--;
			duplicateQueue.push(i);			
		}//fi		*/
	}//rof
	
    return increCnt;
};

var nums;

/*
nums = [1,2,2];
console.log("ans: " + JSON.stringify(minIncrementForUnique(nums)));
//*/

nums = [100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000,100000];
console.log("ans: " + JSON.stringify(minIncrementForUnique(nums)));
