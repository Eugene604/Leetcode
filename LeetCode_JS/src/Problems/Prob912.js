/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function(nums) {

	const DISPLACEMENT = 65536;
	
	let cntArr = new Array(DISPLACEMENT*2);
	let displcedInx;
	
	cntArr[nums[0] + DISPLACEMENT] = 1;
	let minVal = nums[0];
	let maxVal = nums[0];
	for (let i=1; i<nums.length; i++){
		if (nums[i] < minVal) {
			minVal = nums[i];		
		} else if (nums[i] > maxVal) {
			maxVal = nums[i];
		}//fi
		
		displcedInx = nums[i] + DISPLACEMENT;
		if (cntArr[displcedInx] == undefined){
			cntArr[displcedInx] = 1;
		} else {
			cntArr[displcedInx]++;
		}//fi
	}//rof
	
	
	let currInx = 0;
	for (let i=minVal; i<=maxVal; i++){
		displcedInx = i + DISPLACEMENT;
		if (cntArr[displcedInx] > 0){
			for (let repeat=0; repeat < cntArr[displcedInx]; repeat++ ) {
				nums[currInx] = i;
				currInx++;	
			}//rof				
		}//fi		
	}//rof
    return nums;
};


let nums;
nums = [5,1,1,2,0,0];
console.log('ans: ' + JSON.stringify(sortArray(nums)));


/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray_v2 = function(nums) {
	/**
	 * Recursively sorts a section of the array in place using the Quick Sort algorithm.
	 *
	 * This function selects a pivot element (using the last element in the current range), partitions
	 * the array into two subarrays (elements less than or equal to the pivot, and elements greater than the pivot),
	 * and then recursively sorts the subarrays.
	 *
	 * @param {number[]} nums - The array to be sorted.
	 * @param {number} leftInx - The starting index of the section to be sorted.
	 * @param {number} rightInx - The ending index of the section to be sorted.
	 */
	let pivotSort = function(nums, leftInx, rightInx){
		//console.log("leftInx:" + leftInx + " rightInx:"+rightInx);
		let inxGap = rightInx - leftInx;
		if (inxGap === 1){//base case 1: 2 elements
			if (nums[rightInx] < nums[leftInx] ) {
				[nums[leftInx] , nums[rightInx]] = [nums[rightInx] , nums[leftInx]];
			}//rof
			return;
		} else if (inxGap === 0) {//base case 2: 1 element
			return;
		} else if (inxGap < 0) {//base case 3: invalid left right inx
			return;
		}//fi
		
		let pivot = nums[rightInx];
		let inxToBeProcessed = leftInx;		
		let greaterValPlaceHolderInx = rightInx;
		while(greaterValPlaceHolderInx > inxToBeProcessed) {
			//console.log(inxToBeProcessed + ":" + greaterValPlaceHolderInx);
			if (nums[inxToBeProcessed] <= pivot){
				inxToBeProcessed++;
			} else {
				nums[greaterValPlaceHolderInx] = nums[inxToBeProcessed];
				greaterValPlaceHolderInx--;	
				nums[inxToBeProcessed] = nums[greaterValPlaceHolderInx];							
			}//fi
		}//end while
		nums[inxToBeProcessed] = pivot;
		pivotSort(nums, leftInx, inxToBeProcessed-1);
		pivotSort(nums, inxToBeProcessed+1, rightInx);
		
	};//end method
	pivotSort(nums, 0, nums.length-1);
    return nums;
};
