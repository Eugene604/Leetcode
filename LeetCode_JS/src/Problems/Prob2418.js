/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function(names, heights) {
	let heightMap = new Map();
	for (let i=0; i<names.length; i++){
		heightMap.set(heights[i], names[i]);
	}//rof
	heights.sort((a,b)=>b-a);
	//console.log(heightMap);
	//console.log(heights);
	
	let sortedNames = [];
	for (let i=0; i<heights.length; i++){
		sortedNames.push(heightMap.get(heights[i]));
	}//rof
    
    return sortedNames;
};

let names, heights;

names = ["Mary","John","Emma"], heights = [180,165,170]

console.log('ans: ' + JSON.stringify(sortPeople(names, heights)));