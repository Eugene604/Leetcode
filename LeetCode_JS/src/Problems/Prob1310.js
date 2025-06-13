/**
 * @param {number[]} arr
 * @param {number[][]} queries
 * @return {number[]}
 */
var xorQueries = function(arr, queries) {
    let resultArr = [];
    let prefixXorArr = [0];
    let prevXorTotal = 0;
    for (let i=0; i<arr.length; i++){
		prevXorTotal^=arr[i];
		prefixXorArr.push(prevXorTotal);		
	}//rof
	//console.log('prefixXorArr: ' + JSON.stringify(prefixXorArr));
	
	for (let [beginInx, endInx] of queries){
		//console.log(beginInx);
		resultArr.push(prefixXorArr[endInx+1]^prefixXorArr[beginInx]);
	}//rof
	
    return resultArr;
};

let arr, queries; 

arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]];

console.log('ans: ' + xorQueries(arr, queries));
