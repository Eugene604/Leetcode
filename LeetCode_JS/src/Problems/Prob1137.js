var tribonacciNumArr = new Array(40);
{
	tribonacciNumArr[0] = 0;
	tribonacciNumArr[1] = 1;
	tribonacciNumArr[2] = 1;
	for (let i=3; i<40; i++){
		tribonacciNumArr[i] = tribonacciNumArr[i-1] + tribonacciNumArr[i-2] + tribonacciNumArr[i-3];  
	}//rof
	
} 

/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    return tribonacciNumArr[n];
};

let n;

n=4;
console.log('ans: ' + tribonacci(n));