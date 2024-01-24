const cntCache = new Array(46);
(() => {
    cntCache[1] = 1;
    cntCache[2] = 2;
    cntCache[3] = 3;
    
    for (let i=4; i<=45; i++){
		cntCache[i] = cntCache[i-1] + cntCache[i-2];
	}//rof
    
})();


/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {	
    return cntCache[n];
};


var testFunc = function() {


	let n;


	n = 2;
	console.log(n + " ans: " + climbStairs(n));
};



testFunc();
