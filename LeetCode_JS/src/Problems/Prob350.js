/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
	nums1.sort((a,b)=>a-b);
	nums2.sort((a,b)=>a-b);
	let intersectArr = [];
	let n1Inx = 0;
	let n2Inx = 0;
		
	while (n1Inx < nums1.length && n2Inx < nums2.length){
		if (nums1[n1Inx]===nums2[n2Inx]){
			intersectArr.push(nums1[n1Inx]);
			n1Inx++;
			n2Inx++;
		} else if (nums1[n1Inx]>nums2[n2Inx]){
			n2Inx++;
		} else {
			n1Inx++;
		}//fi
	}//end while
    return intersectArr;
};
let nums1, nums2; 

/*

//*/

nums1 = [1,2,2,1], nums2 = [2,2];

console.count('ans: ' + intersect(nums1, nums2));