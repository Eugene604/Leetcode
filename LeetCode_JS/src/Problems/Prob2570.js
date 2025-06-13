/**
 * @param {number[][]} nums1
 * @param {number[][]} nums2
 * @return {number[][]}
 */
var mergeArrays = function(nums1, nums2) {
    let nums1Inx = 0;
    let nums2Inx = 0;
    let mergedArr = new Array();
    while (nums1Inx < nums1.length && nums2Inx < nums2.length) {
        if (nums1[nums1Inx][0] === nums2[nums2Inx][0]) {
            mergedArr.push([nums1[nums1Inx][0],nums1[nums1Inx][1] + nums2[nums2Inx][1]]);
            nums1Inx++;
            nums2Inx++;
        } else if (nums1[nums1Inx][0] > nums2[nums2Inx][0]) {
            mergedArr.push([nums2[nums2Inx][0],nums2[nums2Inx][1]]);
            nums2Inx++;
        } else if (nums1[nums1Inx][0] < nums2[nums2Inx][0]) {
            mergedArr.push([nums1[nums1Inx][0],nums1[nums1Inx][1]]);
            nums1Inx++;
        }//fi

    }//end while

    while (nums1Inx < nums1.length) {
        mergedArr.push([nums1[nums1Inx][0],nums1[nums1Inx][1]]);
        nums1Inx++;
    }//end while

    while (nums2Inx < nums2.length) {
        mergedArr.push([nums2[nums2Inx][0],nums2[nums2Inx][1]]);
        nums2Inx++;
    }//end while
    
    return mergedArr;    
};