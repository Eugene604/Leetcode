/**
 * @param {number[]} heights
 * @return {number}
 */
var heightChecker = function(heights) {
	let sortedHeight = heights.slice();
	sortedHeight.sort((a,b)=> a-b);
	let missplacedCnt = 0;
	for (let i=0; i<heights.length; i++){
		if (heights[i] !== sortedHeight[i]){
			missplacedCnt++;
		}//rof
	}//rof
    return missplacedCnt;
};


var heights;

heights = [1,1,4,2,1,3];

console.log('ans: ' + heightChecker(heights));