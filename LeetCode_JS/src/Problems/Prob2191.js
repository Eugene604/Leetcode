/**
 * @param {number[]} mapping
 * @param {number[]} nums
 * @return {number[]}
 */
var sortJumbled = function(mapping, nums) {
	
	/**
	 * Converts a given value to a new value based on the provided mapping.
	 * 
	 * precondition:
	 * - mapping.length == 10
	 * - 0 <= mapping[i] <= 9
	 * - All the values of mapping[i] are unique.
	 *
	 * @param {number} val - The original value to be converted.
	 * @param {number[]} mapping - An array of 10 unique integers where mapping[i] 
	 *                             represents the digit to replace i with.
	 * @return {number} The new value after applying the digit mapping.
	 *
	 */
	let convertVal = function(val, mapping){
		let mappedVal = 0;
		let remainder;
		let basePower = 1;
		do {
			remainder = val%10;
			mappedVal += mapping[remainder] * basePower;
			basePower *= 10;
			val -= remainder;
			val /= 10;
		} while (val > 0);//end method
		return mappedVal;
	};//end method
	
	let tripletArr = new Array(nums.length);
	let triplet; //[original value, mapped value, original index]
	
	for (let i=0; i<nums.length; i++){
		triplet = new Array(3);
		triplet[0] = nums[i];
		triplet[1] = convertVal(nums[i], mapping);
		triplet[2] = i;
		tripletArr[i] = triplet;
	}//rof
	
	tripletArr.sort((a,b)=>{
		
		if (a[1] !== b[1]){
			return (a[1] - b[1]);
		}//fi			
		if (a[2] !== b[2]){
			return (a[2] - b[2]);
		}//fi		
	});//end method

	let ansArr = new Array(tripletArr.length);	
	for (let i=0; i<tripletArr.length; i++){
		ansArr[i] = tripletArr[i][0];
	}//rof
	
    return ansArr;
};


let mapping, nums;

/*
mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38];
console.log('ans: ' + JSON.stringify(sortJumbled(mapping, nums)));
//*/

mapping = [5,6,7,8,9,4,3,2,1,0], nums = [9,999,9999,9,999999,999];
console.log('ans: ' + JSON.stringify(sortJumbled(mapping, nums)));
