const MatrixUtils = require('../Utils/MatrixUtils.js');


/**
 * @param {number} k
 * @param {number[][]} rowConditions
 * @param {number[][]} colConditions
 * @return {number[][]}
 */
var buildMatrix = function(k, rowConditions, colConditions) {
	
    /**
	 * data structures:
	 * vOrderArr - array of numbers, vertical topology order array
	 * hOrderArr - array of numbers, horizontal topology order array
	 */
    let vOrderArr, hOrderArr;    
    
    /**
     * Traverses the graph and populates the topological order array.
     * @param {number} nodeID - The current node ID being processed.
     * @param {number[][]} graph - The adjacency list of the graph.
     * @param {number[]} orderArr - The array storing the topological order.
     * @param {number[]} traversalHistArr - The array recording the traversal history.
     * @returns {boolean} - Returns true if successful, false if a loop is detected.
     */
    let traverseAndPopulateOrderArr = function(nodeID, graph, orderArr, traversalHistArr){
		//console.log('processing ' + nodeID + ' its children: ' +  JSON.stringify(graph[nodeID]));
		if (traversalHistArr[nodeID] === 1){
			//base case: current node has been traversed but not pushed to order array, loop detected
			console.log('current node has been traversed but not pushed to order array, loop detected ' + nodeID);			
			return false;
		} else if (traversalHistArr[nodeID] === 2){
			//base case: current node has been traversed and pushed to order array, it means merged to sibling branch
			return true;
		} else {
			traversalHistArr[nodeID] = 1;
		}//fi
		
		let childrenArr = graph[nodeID];
		if (childrenArr == null){ //base case: leaf arrived			
			orderArr.unshift(nodeID);
			traversalHistArr[nodeID] = 2;
			return true;
		}//fi
		
		for (let childInx = 0; childInx < childrenArr.length; childInx++){
			if (!traverseAndPopulateOrderArr(childrenArr[childInx], graph, orderArr, traversalHistArr)){				
				return false;
			}//fi			
		}//rof
		orderArr.unshift(nodeID);
		traversalHistArr[nodeID] = 2;
		return true;
	};//end method
	
	/**
     * Builds the topological order array based on the given conditions.
     * @param {number[][]} conditionArr - The array of conditions representing edges in the graph.
     * @param {number} k - The total number of nodes.
     * @returns {number[] | null} - The topological order array or null if a loop is detected.
     */
	let buildOrderArr = function(conditionArr, k){

		/**
		 * data structures:
		 * nodeStatusArr - array of number, index: nodeID, value: 0 = single, 1 = only has children, 2 = other (has parent or parent + child)		 
		 * traversalID - number, records current traversal ID, used for recording traversal history
		 * traversalHistArr - array of nums, index: nodeID, value: traversal ID
		 * graph - array of arrays, index = node id, value = children array
		 * orderArr - array of numbers, this stores topology order		 
		 */
		
		//step 1: generate graph for graph and list of first generation parents
		let nodeStatusArr = new Array(k+1).fill(0); 
		graph = new Array(k+1);
	    for (let i=0; i<conditionArr.length; i++){
			if (graph[conditionArr[i][0]] == null){
				graph[conditionArr[i][0]] = [];	
			}//fi
			graph[conditionArr[i][0]].push(conditionArr[i][1]);
			nodeStatusArr[conditionArr[i][1]] = 2;
			if (nodeStatusArr[conditionArr[i][0]] === 0) {
				nodeStatusArr[conditionArr[i][0]] = 1;
			}//fi
		}//rof

		/*
		console.log('graph:');	
		for (let i=0; i<graph.length; i++){
			if (graph[i]) {
				console.log(i + ":" + JSON.stringify(graph[44]) + ' nodeStatus:' + nodeStatusArr[i]);	
			}
		}//rof */
		
		
		//step 2: build 1d graph topology order array also check for cycle:
		let traversalHistArr = new Array(k+1).fill(0);
		let orderArr = [];
		for (let nodeID = 1; nodeID <= k; nodeID++){
			if (nodeStatusArr[nodeID] !== 1){
				//contains a bug here
				//if there are self contained circle, all nodes are having status 2, and you can't detect this...
				continue;
			}//fi
			//console.log('try build from node: ' + nodeID);
			if (!traverseAndPopulateOrderArr(nodeID, graph, orderArr, traversalHistArr)){
				console.log('failed at 0, there is loop');
				return null;
			}//rof
		}//rof
	    if (orderArr.length === 0 && conditionArr.length > 0){
			//console.log('failed at 1, there is loop');
			return null;
		}//fi
		for (let i=0; i<k; i++){
			if (traversalHistArr[i] === 0 && nodeStatusArr[i] !== 0){
				return null;
			}//fi
		}//rof
		
		
		return orderArr;
	};//end method
	
	vOrderArr = buildOrderArr(rowConditions, k);    
	if (vOrderArr == null){
		return [];
	}//fi
   	//console.log('vOrderArr: ' + JSON.stringify(vOrderArr));

	hOrderArr = buildOrderArr(colConditions, k); 
	if (hOrderArr == null){
		return [];
	}//fi
    //console.log('hOrderArr: ' + JSON.stringify(hOrderArr));

	//step 5, generate answer matrix
	let nodeRowColInxArr = Array.from({ length: k+1 }, () => Array.from({ length: 2 }, () => -1));
	for (let i = 0; i < vOrderArr.length; i++){
		nodeRowColInxArr[vOrderArr[i]][0] = i;
	}//rof
	for (let i = 0; i < hOrderArr.length; i++){
		nodeRowColInxArr[hOrderArr[i]][1] = i;
	}//rof
	
	//console.log('nodeRowColInxArr: ' + JSON.stringify(nodeRowColInxArr));


	let ansMatrix = Array.from({ length: k }, () => Array.from({ length: k }, () => 0));
	let unusedRowInx = vOrderArr.length;
	let unusedColInx = hOrderArr.length;
	let rowInx, colInx;
	for (let nodeID = 1; nodeID <= k; nodeID++){
		rowInx = nodeRowColInxArr[nodeID][0];
		if (rowInx === -1) {
			rowInx = unusedRowInx;
			unusedRowInx++;
		}//fi
		colInx = nodeRowColInxArr[nodeID][1];
		if (colInx === -1) {
			colInx = unusedColInx;
			unusedColInx++;
		}//fi
		ansMatrix[rowInx][colInx] = nodeID;
	}//rof
	return ansMatrix;
};




let k;
let rowConditions, colConditions;



k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [];
let ansM = buildMatrix(k, rowConditions, colConditions);
console.log('ans: ');
MatrixUtils.displayMatrix(ansM);


/*

k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]];
let ansM = buildMatrix(k, rowConditions, colConditions);
console.log('ans: ');
MatrixUtils.displayMatrix(ansM);

let correctAnsM = correctBuildMatrix(k, rowConditions, colConditions);
console.log('correctAnsM size: ' + correctAnsM.length);
MatrixUtils.displayMatrix(correctAnsM);


k = 2;
rowConditions =[[0,0]];
colConditions =[[1,2],[2,1]];
let ansM = buildMatrix(k, rowConditions, colConditions);
console.log('ans: ');
MatrixUtils.displayMatrix(ansM);

//*/
