/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    let numCnt = new Array(101).fill(0);
    for (let i=0; i<nums.length; i++){
        numCnt[nums[i]]++;
    }//rof
    //console.log(numCnt);
    let maxFreq = 0;
    let maxFreqFreq = 0;
    for (let i=1; i<=100; i++){
        if (numCnt[i]>maxFreq) {
            maxFreq = numCnt[i];
            maxFreqFreq = 1;
        } else if (numCnt[i] == maxFreq){
            maxFreqFreq++;
        }//fi
    }//rof 

    return maxFreq*maxFreqFreq;
    
};