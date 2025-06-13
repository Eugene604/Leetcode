/**
 * @param {number[]} nums
 * @return {number}
 */
var largestPerimeter = function(nums) {
    //step 1, sort the array
    nums.sort((a, b) => a - b);
    
    //step 2, generate prefix sum up to last inx -1
    let pfsOfNums = new Array(nums.length);
    pfsOfNums[0] = nums[0];
    for (let i=1; i<nums.length-1; i++){
        pfsOfNums[i] = nums[i] + pfsOfNums[i-1];
    }//rof
    //console.log('pfs: ' + pfsOfNums);
    //step 3, iterate over the array from last element
    for (let i=nums.length-1; i>=2; i--){
        if (nums[i] < pfsOfNums[i-1]){
            return nums[i] + pfsOfNums[i-1];
        }//fi
        //console.log(nums[i]);
    }//rof
    return -1;  
};