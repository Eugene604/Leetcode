/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[][]}
 */
var getAncestors = function(n, edges) {
	let dirAncestorList = new Array(n).fill().map(() => []);
	for (let i=0; i<edges.length; i++){
		dirAncestorList[edges[i][1]].push(edges[i][0]);
	}//rof
	
	
	let ancestorSetList = new Array(n);
	let ancestorQueue;
	let isAdded;
	let ancestor;
	let ancestorSet;
	
	for (let i=0; i<n; i++){
		ancestorQueue = [...dirAncestorList[i]];
		isAdded = [];
		dirAncestorList[i].forEach(inx => isAdded[inx] = true);	
		ancestorSet = new Set();		
		while (ancestorQueue.length>0) {
			ancestor = ancestorQueue.shift();		
			ancestorSet.add(ancestor);			
			if (ancestorSetList[ancestor] !== null){
				for (let ancInx=0; ancInx < dirAncestorList[ancestor].length; ancInx++){
					if (isAdded[dirAncestorList[ancestor][ancInx]] !== true){
						ancestorQueue.push(dirAncestorList[ancestor][ancInx]);		
						isAdded[dirAncestorList[ancestor][ancInx]] = true;
					}	
					//console.log('gone here 1: ' + ancestor + ":" + JSON.stringify(isAdded));				
				}						
			} else {
				ancestorSetList[ancestor].forEach(itm => ancestorSet.add(itm));					
			}//fi */
		}//end while	
		ancestorSetList[i] = ancestorSet; //*/
	}//rof
	
	let ancestorList = new Array(n);
	for (let i=0; i<n; i++){
		ancestorList[i] = [...ancestorSetList[i]];
		ancestorList[i].sort((a,b)=>a-b);
	}//rof

    return ancestorList;
};


let n, edgeList; 
/*
n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]];

console.count('ans: ' + getAncestors(n, edgeList) );
//*/

n = 13, edgeList = [[2,1],[3,2],[4,3],[5,4],[6,5],[7,6],[8,7],[9,8],[11,9]];

console.count('ans: ' + JSON.stringify(getAncestors(n, edgeList) ));
