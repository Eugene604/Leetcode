const DP_CNT_MAP = Array.from({ length: 10 }, () => Array(10).fill(0));
/**
 * @param {number[][]} dominoes
 * @return {number}
 */
var numEquivDominoPairs = function(dominoes) {
	for (const domino of dominoes){
		if (domino[0] > domino[1]){
			DP_CNT_MAP[domino[1]][domino[0]]++;
		} else {
			DP_CNT_MAP[domino[0]][domino[1]]++;
		}
	}//rof
	
	let cnt = 0;
	for (let i=0; i<10; i++){
		for (let j=i; j<10; j++){
			cnt += (DP_CNT_MAP[i][j]-1)*DP_CNT_MAP[i][j]/2;
			DP_CNT_MAP[i][j] = 0;
		}
	}
  	return cnt;  
};

let dominoes;
dominoes = [[1,2],[2,1],[3,4],[5,6]];
console.log('ans: ' + numEquivDominoPairs(dominoes));