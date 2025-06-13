/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function(nums) {
    let hasElement = {};
    let inx;
    for (inx  = nums.length-1; inx >=0; inx--){
        if (hasElement[nums[inx]]){
            return Math.ceil((inx+1)/3);
        }//fi
        hasElement[nums[inx]] = true;
    }//rof
    return 0;
};