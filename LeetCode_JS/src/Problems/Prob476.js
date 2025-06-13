/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function(num) {
	let originalNum = num;
	
	//step 1: get mask
	let mask = 1;
	
	if (num > 1_073_741_823){
		mask =  2_147_483_647;
	} else {
		while (num > 0) {
			num >>= 1;
			mask <<= 1;
		}//end while
		mask--;	
	}//fi */
	//console.log('mask: ' + mask);
	
	//step 2, get result by substract mask by original number
    return mask - originalNum;
};

let num; 


num = 1073741824;

console.count('ans: ' + findComplement(num));
