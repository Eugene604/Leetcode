/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    let markArr = new Array(1001).fill(0);
    for (let i=0; i<nums1.length; i++){
        markArr[nums1[i]] = 0b1;
    }//rof
    for (let i=0; i<nums2.length; i++){
        markArr[nums2[i]] |= 0b10;
    }//rof
    let unionArr = new Array();
    for (let i=0; i<markArr.length; i++){
        if (markArr[i]===0b11){
            unionArr.push(i);
        }//fi
    }//rof
    return unionArr;
};