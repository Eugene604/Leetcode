/**
 * @param {number} n
 * @param {number[][]} roads
 * @return {number}
 */
var maximumImportance = function(n, roads) {
	let cityRdCnt = new Array(n).fill(0,0,n);
	for (let i=0; i<roads.length; i++){
		cityRdCnt[roads[i][0]]++;
		cityRdCnt[roads[i][1]]++;
	}//rof
	cityRdCnt.sort((a,b)=>b-a);
	console.log(cityRdCnt);
	let importance = 0;
	for (let i=0; i<cityRdCnt.length; i++){
		importance += n*cityRdCnt[i];
		n--;
	}//rof 
    return importance;
};

let n, roads; 

n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]];

console.count('ans: ' + maximumImportance(n, roads) );
