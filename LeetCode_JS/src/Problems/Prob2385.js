const TreeNode = require('../DataStructs/TreeNode.js');
const TreeUtils = require('../Utils/TreeUtils.js');

var amountOfTime = function(root, start) {
	//step1, build adjacency map
	let adjMapObj = {};
	let buildAdjMap = (node) => {		
		if(node.left !== null && node.left !== undefined) {
			connectNodes(node, node.left);
			buildAdjMap(node.left);
		}//fi
		if(node.right !== null && node.right !== undefined) {
			connectNodes(node, node.right);
			buildAdjMap(node.right);
		}//fi		
	}//end buildAdjMap
	
	/**
	 * precondition:
	 * - assumes both nodes are valid
	 * - map object adjMapObj is present
	 * @param {TreeNode} node1
	 * @param {TreeNode} node2	 
	 * 
	 */
	let connectNodes = (node1, node2) => {
		//console.log("connect: " + node1 + ":" + node2);
		let neighborSet;
		if((neighborSet = adjMapObj[node1.val]) === undefined) {
			neighborSet = new Set();
			adjMapObj[node1.val] = neighborSet;
		}//fi
		neighborSet.add(node2.val);
		
		
		if((neighborSet = adjMapObj[node2.val]) === undefined) {
			neighborSet = new Set();
			adjMapObj[node2.val] = neighborSet;
		}//fi
		neighborSet.add(node1.val);
	}//end connectNodes
	
	buildAdjMap(root);
	
	//step 2, calculate length to reach end of graph
	let steps = 0;
	let nextNodeList, nodeList = [];
	let neighborSet;
	nodeList.push(start);
	while(nodeList.length>0){
		nextNodeList = [];
		for (let i=0; i<nodeList.length; i++) {
			
			if ((neighborSet = adjMapObj[nodeList[i]]) === undefined){
				continue;
			}//fi
			
			for (let nodeID of neighborSet){
				nextNodeList.push(nodeID);
				adjMapObj[nodeID].delete(nodeList[i]);		
			}//fi				
		
		}//end while
		steps++;			
		nodeList = nextNodeList;	
	}//end while
	

	return steps-1;
};


var testFunc = function() {
	let valArr1 = [1, 5, 3, null, 4, 10, 6, 9, 2];
	let valArr2 = [1];

	let root;
	let start;

	root = TreeUtils.buildTree(valArr2);
	start = 1;
	TreeUtils.displayTree(root);
	console.log("ans: " + amountOfTime(root, start));
};



testFunc();
