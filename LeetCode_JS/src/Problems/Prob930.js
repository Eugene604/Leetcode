/**
 * @param {number[]} nums
 * @param {number} goal
 * @return {number}
 */
var numSubarraysWithSum = function(nums, goal) {
    let pSumArr = new Array(nums.length);
    pSumArr[0] = nums[0];
    for (let i=1; i<nums.length; i++){
        pSumArr[i] = pSumArr[i-1] + nums[i];
    }//rof
    //console.log(pSumArr);
    
    let saCnt = 0;
    let currSum;
    let lInx;
    for (let rInx = nums.length-1; rInx >= 0 && pSumArr[rInx] >= goal; rInx--){
        currSum = pSumArr[rInx];
        lInx = 0;
        while (currSum > goal && lInx < rInx) {
            currSum -= nums[lInx];
            lInx++;
        } //end while
        while (currSum === goal && lInx <= rInx) {
            //console.log(lInx + ':' + rInx);
            saCnt++;
            currSum -= nums[lInx];
            lInx++;
        }//end while
    }//rof
    return saCnt;
};