/**
 * @param {number[][]} edges
 * @return {number}
 */
var findCenter = function(edges) {
	let node1 = edges[0][0];
	let node2 = edges[0][1];
	let node3 = edges[1][0];
	if (node3 === node1) {
		return node3;	
	} else if  (node3 === node2) {
		return node3;
	} else {
		return edges[1][1];
	}//fi
    
};

var edges;

edges =  [[1,2],[2,3],[4,2]];
console.log("ans: " + JSON.stringify(findCenter(edges)));


