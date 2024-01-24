/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findMatrix = function(nums) {
	//step 1: populate number count
	let numCntArr = new Array(nums.length+1).fill(0);
	for (let num of nums){
		numCntArr[num]++;
	}//rof
	
	//step 2: now populate 2d matrix
	let ansMat = new Array();
	for (let i = 1; i <= nums.length; i++){
		for (let repeat = 0; repeat < numCntArr[i]; repeat++){
			if (typeof ansMat[repeat] == 'undefined') {
				ansMat[repeat] = new Array();
			}//fi
			ansMat[repeat].push(i);
			
		}//rof
	}//rof
	
    return ansMat;
};

var nums1 = [1,3,4,1,2,3,1];
var nums2 = [2,1,1];



let nums;
nums = nums1;

console.log("ans mat: " + JSON.stringify(findMatrix(nums)));
