/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    //special case: point length is 1
    if (points.length === 1){
        return 1;
    }//fi
    points.sort((a, b) => a[0] - b[0]);
    //console.log(points);
    
    let overlapArr = new Array();
    let overlapInterval = points[points.length-1];
    let i = points.length-2;
    while (i >= 0) {
        if (isOverlap(overlapInterval, points[i])) {
            overlapInterval = getOverlap(points[i], overlapInterval);
        } else {
            overlapArr.push(overlapInterval);
            overlapInterval = points[i];
        }//fi
        i--;
        //console.log(overlapArr);
    }//end while
    overlapArr.push(overlapInterval);
    //console.log(overlapArr);
    return overlapArr.length;
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
    if (interval1[0] > interval2[1] || interval1[1] < interval2[0]){
        return false;
    } else {
        return true;
    }//fi
}//end method

/**
 * combine two intervals and get their overlapping section
 * precondition:
 * - assume interval array to be valid and is well formed. 
 * - assume interval 1 and 2 overlap
 * - assume interval 1 is NOT behind interval 2
 * - fail to satisfy these preconditions will result in unexpected behavior
 * @param {number[]} interval1 - array of size 2
 * @param {number[]} interval2 - array of size 2
 * @return {number[]} overlapped interval
 */
function getOverlap(interval1, interval2) {
    let newInterval = new Array(2);
    newInterval[0] = interval2[0];
    newInterval[1] = interval1[1];
    return newInterval;
}//end method
