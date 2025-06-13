/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    //special case 1, original array is empty
    if (intervals === null || intervals.length == 0){
        return [newInterval];
    }//fi
    
    //special case 2, new interval before original array
    if (intervals[0][0] > newInterval[1]) {
        return [newInterval, ...intervals];
    }//fi
    //special case 3, new interval after original array
    if (intervals[intervals.length-1][1] < newInterval[0]) {
        return [...intervals, newInterval];
    }//fi
    
    let updatedIntervals = new Array();
    let combinedInterval;
    let i = 0;
    //phase 1: read intervals before new interval
    while (i < intervals.length &&
    !isOverlap(intervals[i], newInterval) && intervals[i][0] < newInterval[0])  {
        updatedIntervals.push(intervals[i]);
        i++;
    }//end while
    //console.log('after phase 1: ' + JSON.stringify(updatedIntervals));
    
    //phase 2: try merge new interview into the interval array
    if (isOverlap(intervals[i], newInterval)){
        combinedInterval = combine(intervals[i], newInterval);
        i++;
        while (i < intervals.length && isOverlap(intervals[i], combinedInterval))  {
            combinedInterval = combine(intervals[i], combinedInterval);
            i++;
        }//end while
        updatedIntervals.push(combinedInterval);    
    } else {
        updatedIntervals.push(newInterval);
    }//fi
    
    
    
    //console.log('after phase 2: ' + JSON.stringify(updatedIntervals));
    
    //phase 3: fill in rest of intervals
    while (i < intervals.length) {
        updatedIntervals.push(intervals[i]);
        i++;
    }//end while
    //console.log('after phase 3: ' + JSON.stringify(updatedIntervals));

    return updatedIntervals;
    
};


/**
 * check if two intervals overlap
 * precondition:
 * it is assumed that interval array is valid and is well formed. 
 * @param {number[]} interval1 - array of size 2
 * @param {number[]} interval2 - array of size 2
 * @return {boolean} true overlap
 */
function isOverlap(interval1, interval2){
    //console.log('check: ' + JSON.stringify(interval1) + JSON.stringify(interval2));
    if (interval1[0] > interval2[1] || interval1[1] < interval2[0]){
        return false;
    } else {
        return true;
    }//fi
}//end method

/**
 * combine two intervals regardless whether they are overlapping or not
 * precondition:
 * it is assumed that interval array is valid and is well formed. 
 * @param {number[]} interval1 - array of size 2
 * @param {number[]} interval2 - array of size 2
 * @return {number[]} combined interval, null if two intervals do not overlap
 */
function combine(interval1, interval2) {
    let newInterval = new Array(2);
    newInterval[0] = Math.min(interval1[0], interval2[0]);
    newInterval[1] = Math.max(interval1[1], interval2[1]);
    return newInterval;
}//end method