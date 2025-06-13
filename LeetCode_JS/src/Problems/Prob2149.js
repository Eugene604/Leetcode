/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function(nums) {
    let ansArr = new Array(nums.length);
    let posPtr = 0, negPtr = 0;
    let ansArrSize = 0;
    let currSign = 1;
    
    while (ansArrSize < nums.length) {
        //console.log('ansarr: ' + ansArr);
        if (currSign === 1) {
            while (nums[posPtr] < 0) {
                posPtr++;
            }//end while
            ansArr[ansArrSize] = nums[posPtr];
            posPtr++;
            currSign = -1;
        } else if (currSign === -1) {
            while (nums[negPtr] > 0) {
                negPtr++;
            }//end while
            ansArr[ansArrSize] = nums[negPtr];
            negPtr++;
            currSign = 1;
        }//fi
        ansArrSize++;
    }//end while
    
    return ansArr;
};