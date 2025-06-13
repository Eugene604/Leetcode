const TWOS_PWR_ARR = new Array(34);
{
	TWOS_PWR_ARR[0]=0b0;
	TWOS_PWR_ARR[1]=0b1;
	TWOS_PWR_ARR[2]=0b10;
	TWOS_PWR_ARR[3]=0b100;
	TWOS_PWR_ARR[4]=0b1000;
	TWOS_PWR_ARR[5]=0b10000;
	TWOS_PWR_ARR[6]=0b100000;
	TWOS_PWR_ARR[7]=0b1000000;
	TWOS_PWR_ARR[8]=0b10000000;
	TWOS_PWR_ARR[9]=0b100000000;
	TWOS_PWR_ARR[10]=0b1000000000;
	TWOS_PWR_ARR[11]=0b10000000000;		
	TWOS_PWR_ARR[12]=0b100000000000;
	TWOS_PWR_ARR[13]=0b1000000000000;
	TWOS_PWR_ARR[14]=0b10000000000000;
	TWOS_PWR_ARR[15]=0b100000000000000;
	TWOS_PWR_ARR[16]=0b1000000000000000;
	TWOS_PWR_ARR[17]=0b10000000000000000;
	TWOS_PWR_ARR[18]=0b100000000000000000;
	TWOS_PWR_ARR[19]=0b1000000000000000000;
	TWOS_PWR_ARR[20]=0b10000000000000000000;
	TWOS_PWR_ARR[21]=0b100000000000000000000;		
	TWOS_PWR_ARR[22]=0b1000000000000000000000;
	TWOS_PWR_ARR[23]=0b10000000000000000000000;
	TWOS_PWR_ARR[24]=0b100000000000000000000000;
	TWOS_PWR_ARR[25]=0b1000000000000000000000000;
	TWOS_PWR_ARR[26]=0b10000000000000000000000000;
	TWOS_PWR_ARR[27]=0b100000000000000000000000000;
	TWOS_PWR_ARR[28]=0b1000000000000000000000000000;
	TWOS_PWR_ARR[29]=0b10000000000000000000000000000;
	TWOS_PWR_ARR[30]=0b100000000000000000000000000000;
	TWOS_PWR_ARR[31]=0b1000000000000000000000000000000;
	TWOS_PWR_ARR[32]=0b10000000000000000000000000000000;
	TWOS_PWR_ARR[33]=0b100000000000000000000000000000000;	
}
/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeBitwiseAnd = function(left, right) {	

	/**
	 * determine the greatest power of two that is less or equal to the number
	 * @param {number} num, the number in question
	 * @return {number}
	 */
	let getGreatestPwrOfTwo = function(num) {
		let lInx = 0; rInx = 33;
		let currInx;
		while (rInx > lInx+1) {
			currInx = Math.floor((rInx + lInx)/2);
			if (TWOS_PWR_ARR[currInx] > num) {
				rInx = currInx;
			} else if (TWOS_PWR_ARR[currInx] < num) {
				lInx = currInx;
			} else {
				return -TWOS_PWR_ARR[currInx];
			}//fi
		}//end while
		return TWOS_PWR_ARR[lInx];
	};//end getGreatestPwrOfTwo
	
	let gptOfLeft = getGreatestPwrOfTwo(left);
	let gptOfRight = getGreatestPwrOfTwo(right);
	
	//console.log(left + " : " + right + " gpw: " + gptOfLeft + ' l:r ' + gptOfRight);
	

	
	if (gptOfLeft === gptOfRight) {
		let andedVal = left;
		for (let i=left+1; i<= right; i++) {
			andedVal &= i;
		}//rof
		return andedVal;
	} else if (Math.abs(gptOfLeft) === Math.abs(gptOfRight)) { 	//special case: exactly one of the left or right is power of 2
		return Math.abs(gptOfLeft);
	} else {
	    return 0;		
	}//fi
};	

var testFunc = function() {
	let left, right;

	left = 1073741824;
	right = 2147483647;
	console.log("ans: " + rangeBitwiseAnd(left, right));
};



testFunc();
