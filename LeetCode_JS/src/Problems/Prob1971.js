const MatrixUtils = require('../Utils/MatrixUtils.js');


/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} source
 * @param {number} destination
 * @return {boolean}
 */
var validPath = function(n, edges, source, destination) {
	//special case, source is destination
	if (source === destination) {
		return true;
	}//fi
	//step 1, build edge map
	let edgeMapArr = Array(n).fill().map(() => []);	
	let edge;
	for (let i=0; i<edges.length; i++){
		edge = edges[i];
		edgeMapArr[edge[0]].push(edge[1]);
		edgeMapArr[edge[1]].push(edge[0]);
	}//rof
	//console.log(edgeMapArr);
	
	//step 2, use bfs to search for connectivity
	let incomingQueue = [];
	let outgoingQueue = [];
	let isTravelled = new Array(n).fill(false);
	outgoingQueue.push(source);
	isTravelled[source] = true;
	let currNode;
	while (incomingQueue.length>0 || outgoingQueue.length>0) {
		while (outgoingQueue.length>0){
			currNode = outgoingQueue.pop();
			for (let i=0; i<edgeMapArr[currNode].length; i++){
				if (edgeMapArr[currNode][i]===destination) {
					return true;
				} else if (isTravelled[edgeMapArr[currNode][i]]){
					continue;
				} else {
					incomingQueue.push(edgeMapArr[currNode][i]);
					isTravelled[edgeMapArr[currNode][i]] = true;
				}//fi				
			}//rof
		}//end while
		outgoingQueue = incomingQueue;
		incomingQueue = [];
	}//ennd while
	
    return false;
};

var testFunc = function() {
	let edges1 = [[0,1],[1,2],[2,0]];
	let edges2 = [];
	
	let edges, n, source, destination;
	
	/*
	n = 3;
	source = 0;
	destination = 2;
	edges = edges1;	
	MatrixUtils.displayMatrix(edges);	
	console.log('ans: ' + validPath(n, edges, source, destination));
	//*/
	
	
	n = 3;
	source = 0;
	destination = 2;
	edges = edges2;	
	MatrixUtils.displayMatrix(edges);	
	console.log('ans: ' + validPath(n, edges, source, destination));

};



testFunc();

