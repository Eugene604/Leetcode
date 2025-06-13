const MatrixUtils = require('../Utils/MatrixUtils.js');
/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} distanceThreshold
 * @return {number}
 */
var findTheCity = function(n, edges, distanceThreshold) {
	const MAX_DIST = distanceThreshold*2;
	let costM = Array.from({ length: n }, () => Array.from({ length: n }, () => MAX_DIST));

	
	//use Floyd-Warshall
	for (let i=0; i<n; i++){
		costM[i][i] = 0;
	}//rof
	
	for (let i=0; i<edges.length; i++){
		costM[edges[i][0]][edges[i][1]] = edges[i][2];
		costM[edges[i][1]][edges[i][0]] = edges[i][2];
	}//rof
	//console.log('initial m:');    
	//MatrixUtils.displayMatrix(costM);
	let tmpDist;
	for (let k = 0; k < n; k++) {
		for (let i = 0; i < n; i++) {
		    for (let j = i; j < n; j++) {
				tmpDist = costM[i][k] + costM[k][j];
		        if (costM[i][j] > tmpDist) {
		            costM[i][j] = tmpDist;
		            costM[j][i] = tmpDist;
		        }//rof
		    }//rof
		}//rof		
		//console.log('m after k=:' + k);
    	//MatrixUtils.displayMatrix(costM);
    }//rof

	let minTravableCityCnt = n;
	let travableCityCnt;
	let minCityID = n-1;
	
	for (let cityID = n-1; cityID >=0; cityID--){
		travableCityCnt = 0;
		for (let i=0; i<n; i++){
			if (costM[cityID][i] <= distanceThreshold) {
				travableCityCnt++;
			}//fi
		}//rof
		if (travableCityCnt < minTravableCityCnt) {
			minTravableCityCnt = travableCityCnt;
			minCityID = cityID;
		}//fi
	}//rof

	return minCityID;
};

let n, edges, distanceThreshold;

n = 6, edges = [[0,1,10],[0,2,1],[2,3,1],[1,3,1],[1,4,1],[4,5,10]], distanceThreshold = 20;
console.log('ans: ' + findTheCity(n, edges, distanceThreshold));

/*
n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4;
console.log('ans: ' + findTheCity(n, edges, distanceThreshold));

//*/