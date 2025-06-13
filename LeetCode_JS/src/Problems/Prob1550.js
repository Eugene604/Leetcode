/**
 * @param {number[]} arr
 * @return {boolean}
 */
var threeConsecutiveOdds = function(arr) {
	let oddCnt = 0;
	for (let i=0; i<arr.length; i++){
		if (arr[i]%2 === 0){
			oddCnt = 0;
		} else {
			oddCnt++;
			if (oddCnt === 3){
				return true;
			}//fi
		}//fi
	}//rof
    return false;
};

let arr; 

/*

//*/

arr = [2,6,4,1];

console.count('ans: ' + threeConsecutiveOdds(arr));