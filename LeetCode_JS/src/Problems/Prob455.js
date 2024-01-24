/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
	g.sort(function(a, b){return a - b});
	s.sort(function(a, b){return a - b});
	let currSInx = 0, currGInx = 0;
	let numOfCC = 0;
	while (currSInx < s.length && currGInx < g.length){
		if (s[currSInx] >= g[currGInx]){
			numOfCC++;
			currSInx++;
			currGInx++;
		} else {
			currSInx++;
		}//fi
	}//end while
    return numOfCC;
};

var g1 = [1,2,3];
var g2 = [10,9,8,7];

var s1 = [1,1];
var s2 = [5,6,7,8];	



let s, g;
g = g2;
s = s2;

console.log("ans: " + findContentChildren(g, s));


