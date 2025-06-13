/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var getCommon = function(nums1, nums2) {
    let nums1Inx = 0;
    let nums2Inx = 0;
    while (nums1Inx < nums1.length && nums2Inx < nums2.length) {
        if (nums1[nums1Inx] < nums2[nums2Inx]) {
            nums1Inx++;
        } else if (nums1[nums1Inx] > nums2[nums2Inx]) {
            nums2Inx++;
        } else {
            return nums1[nums1Inx];
        }//fi
    }//end while
    return -1;
};