/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
	let numCntMap = new Map(); //undefinied = not appeared yet, 1~n = appear n times
	let cntOccurMap = new Map(); // undefinied = not appeared yet, true = appear once, false = appear more than once
	
	let cnt;
	//step 1, populate count of each number
	for (let i = 0; i<arr.length; i++){
		cnt = numCntMap.get(arr[i]);
		if (cnt === undefined) {
			numCntMap.set(arr[i], 1);
		} else {
			numCntMap.set(arr[i], cnt+1);
		}//fi
	}//rof
	//step 2, populate occurance count map and if duplicate found, return false;
	let occurStatus;
	for (let occurCnt of numCntMap.values()){
		occurStatus = cntOccurMap.get(occurCnt);		
		if (occurStatus === undefined) {
			cntOccurMap.set(occurCnt, true);
		} else if (occurStatus) {
			return false;
		} else {
			return false;
		}//fi
	}//rof
	
    return true;
};

var testFunc = function() {
	let valArr1 = [1,2,2,1,1,3];
	let valArr2 = [1,2];

	let arr;


	arr = valArr2;
	console.log("ans: " + uniqueOccurrences(arr));
};



testFunc();
