const LETTER_INTARR_MAP = new Map();
{
	LETTER_INTARR_MAP.set('a', 1);
	LETTER_INTARR_MAP.set('b', 2);
	LETTER_INTARR_MAP.set('c', 3);
	LETTER_INTARR_MAP.set('d', 4);
	LETTER_INTARR_MAP.set('e', 5);
	LETTER_INTARR_MAP.set('f', 6);
	LETTER_INTARR_MAP.set('g', 7);
	LETTER_INTARR_MAP.set('h', 8);
	LETTER_INTARR_MAP.set('i', 9);
	LETTER_INTARR_MAP.set('j', 1); // 1 + 0 = 1
	LETTER_INTARR_MAP.set('k', 2); // 1 + 1 = 2
	LETTER_INTARR_MAP.set('l', 3); // 1 + 2 = 3
	LETTER_INTARR_MAP.set('m', 4); // 1 + 3 = 4
	LETTER_INTARR_MAP.set('n', 5); // 1 + 4 = 5
	LETTER_INTARR_MAP.set('o', 6); // 1 + 5 = 6
	LETTER_INTARR_MAP.set('p', 7); // 1 + 6 = 7
	LETTER_INTARR_MAP.set('q', 8); // 1 + 7 = 8
	LETTER_INTARR_MAP.set('r', 9); // 1 + 8 = 9
	LETTER_INTARR_MAP.set('s', 10); // 1 + 9 = 10
	LETTER_INTARR_MAP.set('t', 2); // 2 + 0 = 2
	LETTER_INTARR_MAP.set('u', 3); // 2 + 1 = 3
	LETTER_INTARR_MAP.set('v', 4); // 2 + 2 = 4
	LETTER_INTARR_MAP.set('w', 5); // 2 + 3 = 5
	LETTER_INTARR_MAP.set('x', 6); // 2 + 4 = 6
	LETTER_INTARR_MAP.set('y', 7); // 2 + 5 = 7
	LETTER_INTARR_MAP.set('z', 8); // 2 + 6 = 8

}
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
	let passOneDigSum = 0;
	for (let i=0; i<s.length; i++){
		passOneDigSum += LETTER_INTARR_MAP.get(s[i]);
	}//rof
	
	let getDigSum = function(num){
		let sum = 0;
		let remainder;
		while (num>0){
			remainder = num%10;
			sum += remainder;
			num -= remainder;
			num /= 10;
		}//end sum 	
		return sum;
	};//end method
	//console.log(passOneDigSum);
	let digSum = passOneDigSum;
	for (;k>1;k--){
		digSum = getDigSum(digSum);
		//console.log(digSum);
	}
    return digSum;
};

 
let s, k;

s = "leetcode", k = 2;


console.log("ans: " + getLucky(s,k));

