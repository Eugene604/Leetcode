/**
 * @param {number[]} arr
 * @return {number[]}
 */
var arrayRankTransform = function(arr) {
	let valToInxMap = new Map(); // key: array value, value: rank
	let inxArr; //stores which indices contain such array value
	
	//step 1: populate value to rank map
	for (let i=0; i<arr.length; i++){
		valToInxMap.set(arr[i],0);
	} //rof
	
	//step 2: get distinct values and sort them
	let distValArr = Array.from(valToInxMap.keys());
	distValArr.unshift(Number.MIN_SAFE_INTEGER);
	distValArr.sort((a, b) => a - b);
	
	//step 3: get rank information and add this rank value back to the map
	for (let i=1; i<distValArr.length; i++){
		valToInxMap.set(distValArr[i],i);
	}//rof
	
	
	//step 4: write rank info back to the original array
	for (let i=0; i<arr.length; i++){
		arr[i] = valToInxMap.get(arr[i]);
	} //rof
	
	//console.log(arr);
    return arr;
};

let arr;

arr = [40,10,20,30,10];

console.log('ans:' + JSON.stringify(arrayRankTransform(arr)));


var arrayRankTransform_v2 = function(arr) {
	let valToInxMap = new Map(); // key: array value, value: number array that stores which indices contain such array value
	let inxArr; //stores which indices contain such array value
	
	//step 1: populate value to indices map
	for (let i=0; i<arr.length; i++){
		inxArr = valToInxMap.get(arr[i]);
		if (inxArr === undefined){
			inxArr = [];
			valToInxMap.set(arr[i],inxArr);
		}//fi
		inxArr.push(i);
	} //rof
	
	//step 2: get distinct values and sort them
	let distValArr = Array.from(valToInxMap.keys());
	distValArr.unshift(Number.MIN_SAFE_INTEGER);
	distValArr.sort((a, b) => a - b);
	
	//step 3: get rank information and use this rank value to replace values from original array
	for (let i=1; i<distValArr.length; i++){
		inxArr = valToInxMap.get(distValArr[i]);
		for (let inx of inxArr){
			arr[inx] = i;
		}//rof
	}//rof
	

	console.log(arr);
    return arr;
};
