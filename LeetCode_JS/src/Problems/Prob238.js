/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
	
	let prefixProd = new Array(nums.length);
	prefixProd[0] = nums[0];
	for (let i=1; i<nums.length-1; i++){
		prefixProd[i] = nums[i] * prefixProd[i-1];
	}//rof
	//console.log(prefixProd);
	
	let postfixProd = new Array(nums.length);
	postfixProd[nums.length-1] = nums[nums.length-1];
	for (let i=nums.length-2; i>0; i--){
		postfixProd[i] = nums[i] * postfixProd[i+1];		
	}//rof	
	//console.log(postfixProd);
	
	let ansArr = new Array(nums.length);
	ansArr[0] = postfixProd[1];
	ansArr[nums.length-1] = prefixProd[nums.length-2];
	for (let i=1; i<nums.length-1; i++){
		ansArr[i] = prefixProd[i-1] * postfixProd[i+1];
	}//rof
    return ansArr;
};

var nums1 = [1,2,3,4];



let nums;
nums = nums1;
console.log("ans: " + productExceptSelf(nums));
