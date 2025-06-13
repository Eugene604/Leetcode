/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
	let valSet = new Set();
	for (num of arr){
		//console.log('checking: ' + num);
		if (valSet.has(num*2) || valSet.has(num/2)){
			return true;
		}//fi
		valSet.add(num);
	}//fi
	return false;    
};

let arr;
arr = [10,2,5,3];
console.log('Ans: ' + checkIfExist(arr));