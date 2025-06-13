/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number[]} succProb
 * @param {number} start_node
 * @param {number} end_node
 * @return {number}
 */
var maxProbability = function(n, edges, succProb, start_node, end_node) {
    //index: node id, value[0] = children's node ids, value[1] = log (base 2) probability
    let graph =  Array.from({ length: n + 1 }, () => [[], []]);
  
    
    //step 1, build graph
    let logProb;
    for (let i=0; i<edges.length; i++){
		//console.log('process: ' + JSON.stringify(edges[i]));
		logProb = Math.log2(succProb[i]);
		graph[edges[i][0]][0].push(edges[i][1]);
		graph[edges[i][0]][1].push(logProb);
		graph[edges[i][1]][0].push(edges[i][0]);
		graph[edges[i][1]][1].push(logProb);
	}//rof
	
	//console.log('GRAPH: ' + JSON.stringify(graph));
    
    //step 2, use bfs to find highest probability
    let logProbArr = new Array(n+1).fill(Number.MIN_SAFE_INTEGER); //index: node id, value: base 2 log of probability
    let borderProbArr = []; //[nodeID, log prob to reach, nodeID, log prob...]
    let borderLength;
    let currNodeID;
    let currLogProb;
    let childID;
    let childLogProb;
    
    logProbArr[start_node] = 0;
    borderProbArr.push(start_node);
    borderProbArr.push(0);       
    while ((borderLength = borderProbArr.length) > 0) {
		while (borderLength > 0){
			currNodeID = borderProbArr.shift();
			currLogProb = borderProbArr.shift();
			for (let childInx = 0; childInx < graph[currNodeID][0].length; childInx++) {
				childID = graph[currNodeID][0][childInx];
				childLogProb = currLogProb + graph[currNodeID][1][childInx];
				if (childLogProb > logProbArr[childID]){
					logProbArr[childID] = childLogProb;
					borderProbArr.push(childID);
    				borderProbArr.push(childLogProb); 
				}//fi
			}//rof
			borderLength -= 2;
		}//end while
	}//end while
    
    if (logProbArr[end_node] === Number.MIN_SAFE_INTEGER){
		return 0;
	} else {
		return Math.pow(2,logProbArr[end_node]);
	}//fi    	
};

var testFunc = function() {

	let n, edges, succProb, start, end;
	
	n=5;
	edges =[[1,4],[2,4],[0,4],[0,3],[0,2],[2,3]];
	succProb = [0.37,0.17,0.93,0.23,0.39,0.04];
	start = 3;
	end = 4;
	
	console.log("ans: " + maxProbability(n, edges, succProb, start, end));
	
	/*
	
	n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2

	console.log("ans: " + maxProbability(n, edges, succProb, start, end));
	//*/
};



testFunc();
