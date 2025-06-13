/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 */
var canBeEqual = function(target, arr) {
	let cntArr = new Array(1001).fill(0);
	
	for (let i=0; i<target.length; i++){
		cntArr[target[i]]++;
	}//rof

	for (let i=0; i<target.length; i++){		
		if (--cntArr[arr[i]] < 0){
			return false;
		}//fi
	}//rof
	
	return true;    
};

let target, arr;
target = [1,2,3,4], arr = [2,4,1,3]

console.log('ans: ' + canBeEqual(target, arr));
