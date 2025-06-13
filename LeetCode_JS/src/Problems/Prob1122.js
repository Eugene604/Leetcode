/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
	let numCntMap = new Map();
	for (let i=0; i<arr2.length; i++){
		numCntMap.set(arr2[i],0);
	}//rof
	
	let relSortedArr = new Array();
	let cnt;
	for (let i=0; i<arr1.length; i++){
		if ((cnt=numCntMap.get(arr1[i])) || cnt===0){
			cnt++;
			numCntMap.set(arr1[i],cnt);
		} else {
			relSortedArr.push(arr1[i]);
		}//fi
	}//rof
	relSortedArr.sort((a,b)=>a-b);
	//console.log(nonA2NumsArr);
	
	for (let i=arr2.length-1; i>=0; i--){
		relSortedArr.unshift(...Array.from({length: numCntMap.get(arr2[i])}, () => arr2[i]));
	}//rof
	 
    return relSortedArr;
};


let arr1, arr2;

arr1 = [2,3,1,3,2,4,6,7,9,2,19];
arr2 = [2,1,4,3,9,6];

console.log('ans: ' + JSON.stringify(relativeSortArray(arr1,arr2)));