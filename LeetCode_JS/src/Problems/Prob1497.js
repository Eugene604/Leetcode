/**
 * @param {number[]} arr
 * @param {number} k
 * @return {boolean}
 */
var canArrange = function(arr, k) {
    let modFreqArr = new Array(k+1).fill(0);
    let positiveRemainder;
    for (let num of arr){
		positiveRemainder = ((num%k)+k)%k;
		modFreqArr[positiveRemainder]++;
	}//rof
	
	//check if freqArr[0] is even
	if (modFreqArr[0]%2 === 1){
		return false;
	}//fi
	
	//check midde case when k is even
	if (k%2 === 0 && modFreqArr[k/2]%2 === 1){
		return false;
	}//fi
	
	//check for rest of i pairs
	for (let i=1; i<Math.ceil(k/2); i++){
		if (modFreqArr[i] !== modFreqArr[k-i]){
			return false;
		}//fi
	}//rof
	//console.log('freArr: ' + JSON.stringify(modFreqArr));
	return true;
};

let arr, k;

arr = [1,2,3,4,5,10,6,7,8,9], k = 5;

console.log('ans:' + canArrange(arr,k));

