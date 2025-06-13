/**
 * @param {number[]} chalk
 * @param {number} k
 * @return {number}
 */
var chalkReplacer = function(chalk, k) {
    let chalkSum = 0;
    for (let i=0; i<chalk.length; i++){
		chalkSum += chalk[i];
	}//rof
	let remainder = k%chalkSum;
	for (let i=0; i<chalk.length; i++){
		remainder -= chalk[i];
		if (remainder < 0){
			return i;
		}//fi
	}//rof 
};

 
let chalk, k;

chalk = [5,1,5], k = 22;


console.log("ans: " + chalkReplacer(chalk,k));

