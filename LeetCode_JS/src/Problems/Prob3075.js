/**
 * @param {number[]} happiness
 * @param {number} k
 * @return {number}
 */
var maximumHappinessSum = function(happiness, k) {
    happiness.sort((a,b) => b-a);
    //console.log(happiness);
    let totalHappiness = 0;
    let singleHappiness;

    for (let i=0; i<k; i++){
        singleHappiness = happiness[i] - i;
        singleHappiness = (singleHappiness < 0) ? 0 : singleHappiness;
        totalHappiness += singleHappiness;
    }//rof

    return totalHappiness;
    
};

let happiness, k;
happiness  = [1,1,1,1];
k = 2;

console.count('ans: ' + maximumHappinessSum(happiness, k));
