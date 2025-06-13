/**
 * @param {string[]} arr
 * @param {number} k
 * @return {string}
 */
var kthDistinct = function(arr, k) {
	let strCntMap = new Map();
	for (let i=0; i<arr.length; i++){
		if (strCntMap.has(arr[i])){
			strCntMap.set(arr[i], 987);			
		} else {
			strCntMap.set(arr[i], 1);
		}//fi
	}//rof
	
	for (let i=0; i<arr.length; i++){
		if (strCntMap.get(arr[i]) === 1){
			if (k === 1) {
				return arr[i];
			} else {
				k--;
			}//fi
		}//fi
	}//rof
    return "";
};

let k, arr;
arr = ["d","b","c","b","c","a"], k = 2;
console.log('ans: ' + kthDistinct(arr,k));