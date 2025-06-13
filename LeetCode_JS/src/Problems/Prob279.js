const lpsNumsCache = new Array(10001);
{
	for (let i=0; i<=100; i++){
		lpsNumsCache[i*i]=1;
	}//rof		
}
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
	if (lpsNumsCache[n] !== undefined) {
		return lpsNumsCache[n];
	}//fi
	
	let currLPS, minLPS = Number.MAX_SAFE_INTEGER;
	let isq;	
	for (let i=1; (isq=i*i)<=n; i++){
		currLPS = 1 + numSquares(n-isq);
				
		if (currLPS < minLPS) {
			minLPS = currLPS;
		}//fi
	}//end while
	lpsNumsCache[n]=minLPS;
	return minLPS;
};

/**
 * @param {number} n
 * @return {number}
 */
var numSquares_v2 = function(n) {
	if (lpsNumsCache[n] !== undefined) {
		return lpsNumsCache[n];
	}//fi
	
	let currLPS, minLPS = Number.MAX_SAFE_INTEGER;
		
	for (let i=1; i<=n/2; i++){
		
		currLPS = numSquares(i) + numSquares(n-i);
				
		if (currLPS < minLPS) {
			minLPS = currLPS;
		}//fi
	}//end while
	lpsNumsCache[n]=minLPS;
	return minLPS;
};

var n;

n=12;
console.log("ans: " + numSquares(n));


