const MAX_ISLAND_ID = 1048576;

/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number}
 */
var maxNumEdgesToRemove = function(n, edges) {
	let islandIDArr = new Array(n+1).fill(MAX_ISLAND_ID);
	let removalCnt = 0;
	let aliceEdges = new Array();
	let bobEdges = new Array();
	let aliceIslandIDArr, bobIslandIDArr;
	
	let addEdge = function(islandIDArr, edge){
		let islandID0 = getIslandID(islandIDArr, edge[0]);
		let islandID1 = getIslandID(islandIDArr, edge[1]);
		
		if (islandID0===MAX_ISLAND_ID && islandID1===MAX_ISLAND_ID){
			islandID0 = Math.min(edge[0], edge[1]);
			islandIDArr[edge[0]] = islandID0;
			islandIDArr[edge[1]] = islandID0;
		} else if (islandID0===MAX_ISLAND_ID) {
			islandIDArr[edge[0]] = islandID1;
		} else if (islandID1===MAX_ISLAND_ID) {
			islandIDArr[edge[1]] = islandID0;			
		} else if (islandID0 > islandID1) {
			islandIDArr[islandID0] = islandID1;				
		} else if (islandID0 < islandID1) {
			islandIDArr[islandID1] = islandID0;				
		} else {
			removalCnt++;
		}//fi
	};//end method
	
	/**
	 * precondition:
	 * - node must not be 0
	 * 
	 * 
	 */
	let getIslandID = function(islandIDArr, node){
		let islandID = islandIDArr[node];
		if (islandID === MAX_ISLAND_ID || islandID === node){
			return islandID;
		} else {
			islandIDArr[node] = getIslandID(islandIDArr, islandID);
			return islandIDArr[node];
		}//fi
	};//end method
	

	for (let i=0; i<edges.length; i++){
		if (edges[i][0]===1){
			aliceEdges.push([edges[i][1],edges[i][2]]);
		} else if (edges[i][0]===2){
			bobEdges.push([edges[i][1],edges[i][2]]);
		} else if (edges[i][0]===3){
			addEdge(islandIDArr, [edges[i][1],edges[i][2]]);
		}//fi
	}//rof
	//console.log(islandIDArr);
		
	aliceIslandIDArr = [...islandIDArr];
	//console.log('aliceEdges: ' + JSON.stringify(aliceEdges));
	for (let i=0; i<aliceEdges.length; i++){
		addEdge(aliceIslandIDArr, aliceEdges[i]);
	}//rof	
	//console.log('aliceIslandIDArr: ' + JSON.stringify(aliceIslandIDArr));
	
	if (aliceIslandIDArr[1] === MAX_ISLAND_ID){
		return -1;
	}//fi
	for (let i=2; i<=n; i++){
		if (getIslandID(aliceIslandIDArr, i) != getIslandID(aliceIslandIDArr, 1)){
			return -1;
		}//fi
	}//rof
	
	bobIslandIDArr = [...islandIDArr];
	for (let i=0; i<bobEdges.length; i++){
		addEdge(bobIslandIDArr, bobEdges[i]);
	}//rof
	//console.log('bobIslandIDArr: ' + JSON.stringify(bobIslandIDArr));
	
	if (bobIslandIDArr[1] === MAX_ISLAND_ID){
		return -1;
	}//fi
	for (let i=2; i<=n; i++){
		if (getIslandID(bobIslandIDArr, i) != getIslandID(bobIslandIDArr, 1)){
			return -1;
		}//fi
	}//rof
    return removalCnt;
};


let n, edges; 

/*
n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]];

console.count('ans: ' + JSON.stringify(maxNumEdgesToRemove(n, edges) ));


n =4, edges = [[3,1,2],[3,3,4]];
console.count('ans: ' + JSON.stringify(maxNumEdgesToRemove(n, edges) ));
//*/

n = 2, edges = [[2,1,2]];

console.count('ans: ' + JSON.stringify(maxNumEdgesToRemove(n, edges) ));