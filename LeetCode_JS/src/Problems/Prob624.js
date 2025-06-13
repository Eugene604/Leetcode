/**
 * @param {number[][]} arrays
 * @return {number}
 */
var maxDistance = function(arrays) {
    let maxVal, secMaxVal;
    let maxValInx, secMaxValInx;
    let minVal, secMinVal;
    let minValInx, secMinValInx;

    //step 1: find mins
    minVal = arrays[0][0];
    minValInx = 0;
    secMinVal = Number.MAX_SAFE_INTEGER;
    for (let i=1; i<arrays.length; i++){
        if (arrays[i][0] < minVal){
            secMinVal = minVal;
            secMinValInx = minValInx;
            minVal = arrays[i][0];
            minValInx = i;
        } else if (arrays[i][0] == minVal){
            minValInx = -2;
        } else if (arrays[i][0] < secMinVal){
            secMinVal = arrays[i][0];
            secMinValInx = i;
        }//fi
    }//rof

    //step 2: find maxes
    maxVal = arrays[0].pop();
    maxValInx = 0;
    secMaxVal = Number.MIN_SAFE_INTEGER;
    let localMax;
    for (let i=1; i<arrays.length; i++){
        localMax = arrays[i].pop();
        if (localMax > maxVal){
            secMaxVal = maxVal;
            secMaxValInx = maxValInx;
            maxVal = localMax;
            maxValInx = i;
        } else if (localMax == maxVal){
            maxValInx = -1;
        } else if (localMax > secMaxVal){
            secMaxVal = localMax;
            secMaxValInx = i;
        }//fi
    }//rof

    //step 3, calculate max dist
    if (maxValInx !== minValInx) {
        return maxVal - minVal;
    } else {
        return Math.max(maxVal - secMinVal, secMaxVal - minVal);
    }
    
};

let arrays;

arrays = [[1,2,3],[4,5],[1,2,3]]

console.count('ans: ' + maxDistance(arrays));
