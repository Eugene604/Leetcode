const MatrixUtils = require('../Utils/MatrixUtils.js');

/**
 * passed, but a better version is that instead of putting node into queue, you put [nodeID, path/time] tuple into queue
 * and also you maintain two queues, one for shortest path and one for second shortest path 
 */
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} time
 * @param {number} change
 * @return {number}
 */
var secondMinimum = function(n, edges, time, change) {
	
	let graph = Array.from({ length: n+1 }, () => new Array());
	let shortestPath, secondShortestPath;
		
	/**
	 * Determines arrival time to next node given departure time
	 * @param {number} departureTime - The time at which a traveler departs
	 * @return {number} - The earliest possible arrival time to next node.
	 */
	let getNextArrivalTime = function(departureTime) {		
		let trafficLightElapsedTime = departureTime % change;
		let nextArrivalTime;
		if (((departureTime - trafficLightElapsedTime)/change)%2 === 0) {//departs when traffic light is green
			nextArrivalTime = departureTime;
		} else {//departs when current node's traffic light is red
			nextArrivalTime = departureTime + (change - trafficLightElapsedTime);
		}//fi
		return nextArrivalTime + time;
	};//end method
	
	
	//step 1: build graph
	for (let i=0; i<edges.length; i++){
		graph[edges[i][0]].push(edges[i][1]);
		graph[edges[i][1]].push(edges[i][0]);
	}//rof
	
	//MatrixUtils.displayMatrix(graph);
	
	//step 2: use breadth first search to get shortest & second shortest time
	let isTravelled;
	let isTravelledBeforePrevQueue = new Array(n+1).fill(false);
	let isTravelledBeforePrevPrevQueue = new Array(n+1).fill(false);
	shortestPath = n*2;
	secondShortestPath = n*2;
	let nodeQueue = new Array(1).fill(1);
	let prevQueueSize;
	let pathLength = 0;
	let childrenArr;
	BFS_LOOP:
	while ((prevQueueSize = nodeQueue.length) > 0) {
		pathLength++;
		isTravelled = new Array(n+1).fill(false);
		for (let i=0; i<prevQueueSize; i++){
			childrenArr = graph[nodeQueue.shift()];
			for (let c=0; c<childrenArr.length; c++){
				if (childrenArr[c] === n) {//a path to n has been found
					if (pathLength === shortestPath){
						//do nothing
					} else if (pathLength < shortestPath) {//shortest path found, remember to remove parent from travelled mark
						shortestPath = pathLength;
					} else if (pathLength < secondShortestPath){
						secondShortestPath = pathLength;
						break BFS_LOOP;
					}//fi
				} else if (!isTravelledBeforePrevPrevQueue[childrenArr[c]]) {
					isTravelled[childrenArr[c]]=true;
					nodeQueue.push(childrenArr[c]);					
				}//fi
			}//rof
		}//rof
		isTravelledBeforePrevPrevQueue = isTravelledBeforePrevQueue.slice();
		isTravelledBeforePrevQueue = isTravelled.slice();
	};//end while
	
	
	//console.log('secondShortestPath : ' + secondShortestPath);
	//console.log('shortestPath : ' + shortestPath);

	let timeForShortestPath, timeForSecondShortestPath, timeForShortestPathPlusOneLoop = 0;
	
	timeForShortestPath = 0;
	for (let step = 0; step < shortestPath; step++){
		timeForShortestPath = getNextArrivalTime(timeForShortestPath);
	}//rof
	//console.log('timeForShortestPath: ' + timeForShortestPath);
	
	if (secondShortestPath < n*2) {
		timeForSecondShortestPath = timeForShortestPath;
		for (let step = shortestPath; step < secondShortestPath; step++){
			timeForSecondShortestPath = getNextArrivalTime(timeForSecondShortestPath);
		}//rof
	} else {
		timeForSecondShortestPath = 20_000_000;
	}//fi
	//console.log('timeForSecondShortestPath: ' + timeForSecondShortestPath);	
	
	timeForShortestPathPlusOneLoop = timeForShortestPath;
	for (let step = 0; step < 2; step++){
		timeForShortestPathPlusOneLoop = getNextArrivalTime(timeForShortestPathPlusOneLoop);
	}//rof
	//console.log('timeForShortestPathPlusOneLoop: ' + timeForShortestPathPlusOneLoop);	
	
    return Math.min(timeForSecondShortestPath, timeForShortestPathPlusOneLoop);
};


let n, edges, time, change;



n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5;
console.log('ans: ' + secondMinimum(n, edges, time, change));//13


/*

n = 4, edges = [[1,2],[2,3],[3,4],[4,1],[2,4]], time = 10, change = 15;
console.log('ans: ' + secondMinimum(n, edges, time, change));//20


n = 2, edges = [[1,2]], time = 3, change = 2;
console.log('ans: ' + secondMinimum(n, edges, time, change));//11


n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5;
console.log('ans: ' + secondMinimum(n, edges, time, change));//13

n=7, edges = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[1,3],[1,4]], time = 1, change = 3;
console.log('ans: ' + secondMinimum(n, edges, time, change)); //8


n=20, edges = [[1,2],[1,3],[1,4],[1,5],[2,6],[2,7],[3,8],[3,9],[4,10],[4,11],[5,12],[5,13],[6,14],[6,15],[7,16],[7,17],[8,18],[9,19],[10,20],[11,20],[12,19],[13,18],[14,17],[15,16],[16,19],[17,20]];
time = 10, change = 50;
console.log('ans: ' + secondMinimum(n, edges, time, change)); //40

//*/


//TLE
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} time
 * @param {number} change
 * @return {number}
 */
var secondMinimum_v2 = function(n, edges, time, change) {
	let graph = Array.from({ length: n+1 }, () => new Array());
	let shortestTime, looplessSecondShortestTime;
	let maxExtraLoopTime = time*2+change*2;
	
	let isTravelled = new Array(n+1).fill(false);
	//map key = departure time in terms of green light elapsed time, map value = shortest time to reach n
	//let timeCache = Array.from({ length: n+1 }, () => new Map()); 
	
	/**
	 * Determines the next possible departure time from a node based on the arrival time and traffic light cycles.
	 * @param {number} arrivalTime - The time at which a traveler arrives at the node.
	 * @return {number} - The earliest possible departure time from the node.
	 */
	let getNextDepartureTime = function(arrivalTime) {		
		let trafficLightElapsedTime = arrivalTime % change;
		let departureTime;
		if (((arrivalTime - trafficLightElapsedTime)/change)%2 === 0) {//arrives when traffic light is green
			departureTime = arrivalTime;
		} else {//arrives when current node's traffic light is red
			departureTime = arrivalTime + (change - trafficLightElapsedTime);
		}//fi
		return departureTime;
	};//end method
	
	/**
	 * Traverses the graph to calculate the shortest and second shortest times to reach node n without loops.
	 * 
	 * preconditions:
	 * - graph data structure is available and properly constructed
	 * - shortestTime, looplessSecondShortestTime global variables are available and properly initialized 
	 * - variable n and time are accessable
	 * 
	 * @param {number} nodeID - The current node being visited.
	 * @param {number} arrivalTime - The time at which the node is reached.
	 * @param {boolean[]} isTravelled - Array tracking if nodes have been visited in the current path.
	 */
	let traverse = function(nodeID, arrivalTime, isTravelled){
		//console.log('going in node: ' + nodeID + ' flags: ' + JSON.stringify(isTravelled));
		//base case 1: arrivalTime is no shorter than looplessSecondShortestTime
		if (arrivalTime >= (shortestTime + maxExtraLoopTime)){
			return;
		}//fi
		
		//base case 2: this node has been traversed along this path
		if (isTravelled[nodeID]){
			return;
		} else {
			isTravelled[nodeID] = true;
		}//fi
			
		//base case 3: reached end node
		if (nodeID === n){
			if (arrivalTime === shortestTime){
				//do nothing
			} else if (arrivalTime < shortestTime) {
				looplessSecondShortestTime = shortestTime;
				shortestTime = arrivalTime;
			} else if (arrivalTime < looplessSecondShortestTime){
				looplessSecondShortestTime = arrivalTime; 				
			}//fi
			isTravelled[nodeID] = false;
			//console.log('exit 3 at node iteration: ' + nodeID + ' arrivalTime: ' + arrivalTime);
			return;
		}//fi
		
		let neighborNodeArr = graph[nodeID];
		//base case 4: this is an end node and is not n. No need to cancel the travesal flag
		if (nodeID !== 1 && neighborNodeArr.length < 2){
			return;
		}//fi
		
		let depatureTime = getNextDepartureTime(arrivalTime);
		
		for (let i=0; i<neighborNodeArr.length; i++){
			traverse(neighborNodeArr[i], depatureTime + time, isTravelled);
		}//rof
			
		isTravelled[nodeID] = false;
	};//end method
	

	
	//step 1: build graph
	for (let i=0; i<edges.length; i++){
		graph[edges[i][0]].push(edges[i][1]);
		graph[edges[i][1]].push(edges[i][0]);
	}//rof
	
	//MatrixUtils.displayMatrix(graph);
	
	//step 2: traverse and get shortest & second shortest time
	shortestTime = 200_000_000;
	looplessSecondShortestTime = 200_000_000;
	traverse(1, 0, isTravelled);
	//console.log('looplessSecondShortestTime : ' + looplessSecondShortestTime);
	//console.log('shortestTime : ' + shortestTime);
	
	let shortestTimePlusOneLoop;	
	shortestTimePlusOneLoop = getNextDepartureTime(shortestTime); //get departure time from node n
	//console.log('get departure time from node n: ' + shortestTimePlusOneLoop);
	shortestTimePlusOneLoop += time; //now arrived one of n's neighbor
	//console.log('now arrived one of ns neighbor: ' + shortestTimePlusOneLoop);
	shortestTimePlusOneLoop = getNextDepartureTime(shortestTimePlusOneLoop); //now get departure time from n's neighbor
	//console.log('now get departure time from ns neighbor: ' + shortestTimePlusOneLoop);
	shortestTimePlusOneLoop += time; //now it has arrived n again
		
		
    return Math.min(shortestTimePlusOneLoop, looplessSecondShortestTime);
};

//TLE
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} time
 * @param {number} change
 * @return {number}
 */
var secondMinimum_v3 = function(n, edges, time, change) {
	
	let graph = Array.from({ length: n+1 }, () => new Array());
	let shortestPath, secondShortestPath;
	
	
	let isTravelled = new Array(n+1).fill(false);

	
	/**
	 * Determines arrival time to next node given departure time
	 * @param {number} departureTime - The time at which a traveler departs
	 * @return {number} - The earliest possible arrival time to next node.
	 */
	let getNextArrivalTime = function(departureTime) {		
		let trafficLightElapsedTime = departureTime % change;
		let nextArrivalTime;
		if (((departureTime - trafficLightElapsedTime)/change)%2 === 0) {//departs when traffic light is green
			nextArrivalTime = departureTime;
		} else {//departs when current node's traffic light is red
			nextArrivalTime = departureTime + (change - trafficLightElapsedTime);
		}//fi
		return nextArrivalTime + time;
	};//end method
	
	/**
	 * Traverses the graph to calculate the shortest and second shortest path to reach node n without loops.
	 * 
	 * preconditions:
	 * - graph data structure is available and properly constructed
	 * - shortestTime, looplessSecondShortestTime global variables are available and properly initialized 
	 * - variable n and time are accessable
	 * 
	 * @param {number} nodeID - The current node being visited.
	 * @param {number} pathLength - number of edges to traverse.
	 * @param {boolean[]} isTravelled - Array tracking if nodes have been visited in the current path.
	 */
	let traverse = function(nodeID, pathLength, isTravelled){
		//console.log('going in node: ' + nodeID + ' flags: ' + JSON.stringify(isTravelled));
		//base case 1: pathLength is no shorter than secondShortestPath
		if (pathLength  >= secondShortestPath){
			return;
		}//fi
		
		//base case 2: this node has been traversed along this path
		if (isTravelled[nodeID]){
			return;
		} else {
			isTravelled[nodeID] = true;
		}//fi
			
		//base case 3: reached end node
		if (nodeID === n){
			if (pathLength === shortestPath){
				//do nothing
			} else if (pathLength < shortestPath) {
				secondShortestPath = shortestPath;
				shortestPath = pathLength;
			} else if (pathLength < secondShortestPath){
				secondShortestPath = pathLength; 				
			}//fi
			isTravelled[nodeID] = false;
			//console.log('exit 3 at node iteration: ' + nodeID + ' pathLength: ' + pathLength);
			return;
		}//fi
		
		let neighborNodeArr = graph[nodeID];
		//base case 4: this is an end node and is not n. No need to cancel the travesal flag
		if (nodeID !== 1 && neighborNodeArr.length < 2){
			return;
		}//fi
				
		for (let i=0; i<neighborNodeArr.length; i++){
			traverse(neighborNodeArr[i], pathLength+1, isTravelled);
		}//rof
			
		isTravelled[nodeID] = false;
	};//end method
	

	
	//step 1: build graph
	for (let i=0; i<edges.length; i++){
		graph[edges[i][0]].push(edges[i][1]);
		graph[edges[i][1]].push(edges[i][0]);
	}//rof
	
	//MatrixUtils.displayMatrix(graph);
	
	//step 2: traverse and get shortest & second shortest time
	shortestPath = n*2;
	secondShortestPath = n*2;
	traverse(1, 0, isTravelled);
	//console.log('secondShortestPath : ' + secondShortestPath);
	//console.log('shortestPath : ' + shortestPath);
	//console.log('time to N: ' + JSON.stringify(timeToNArr));
	let timeForShortestPath, timeForSecondShortestPath, timeForShortestPathPlusOneLoop = 0;
	
	timeForShortestPath = 0;
	for (let step = 0; step < shortestPath; step++){
		timeForShortestPath = getNextArrivalTime(timeForShortestPath);
	}//rof
	//console.log('timeForShortestPath: ' + timeForShortestPath);
	
	if (secondShortestPath < n*2) {
		timeForSecondShortestPath = timeForShortestPath;
		for (let step = shortestPath; step < secondShortestPath; step++){
			timeForSecondShortestPath = getNextArrivalTime(timeForSecondShortestPath);
		}//rof
	} else {
		timeForSecondShortestPath = 20_000_000;
	}//fi
	//console.log('timeForSecondShortestPath: ' + timeForSecondShortestPath);	
	
	timeForShortestPathPlusOneLoop = timeForShortestPath;
	for (let step = 0; step < 2; step++){
		timeForShortestPathPlusOneLoop = getNextArrivalTime(timeForShortestPathPlusOneLoop);
	}//rof
	//console.log('timeForShortestPathPlusOneLoop: ' + timeForShortestPathPlusOneLoop);	
	
    return Math.min(timeForSecondShortestPath, timeForShortestPathPlusOneLoop);
};

