/**
 * @param {string} s
 * @return {number}
 */
var minLength = function(s) {
	
	let chrArr = [...s];
	
	
    /**
     * Computes the minimum length of the string after repeatedly removing all "AB" and "CD" pairs.
     * 
     * This function trims the input character array by:
     * 1. First removing unnecessary characters from the head and tail that cannot form "AB" or "CD" pairs.
     * 2. Handling base cases where the remaining array has a length of 1 or 2.
     * 3. Iteratively scanning and removing "AB" and "CD" pairs until no more pairs can be removed.
     * 
     * @param {Array} chrArr - The array of characters representing the string.
     * @return {number} - The minimum possible length of the string after all possible removals.
     */
	let getMinLength = function(chrArr){
		//console.log('fun called, chrArr: ' + JSON.stringify(chrArr));		
		let minLength = 0;		
		let inx;
		
		//count non ab cd and remove from tail first
		inx = chrArr.length-1; 
		while (inx>=0 && (chrArr[inx] !== 'B' && chrArr[inx] !== 'D')){
			inx--;
		}//end while
		if (inx<0){
			return chrArr.length;
		} else {
			minLength = chrArr.length - inx - 1;
			chrArr.length = inx+1;			
		}//fi
		
		//count non ab cd and remove from head
		inx = 0; 
		while (inx<chrArr.length-1 && (chrArr[inx] !== 'A' && chrArr[inx] !== 'C')){
			inx++;
		}//end while
		if (inx === chrArr.length-1){
			minLength += chrArr.length;	
			return minLength;
		} else {
			minLength += inx;
			chrArr.splice(0,inx);			
		}//fi
		
		//console.log('after initial counts: ' + minLength + ' inx:' + inx);
		
		//check for base cases:
		if (chrArr.length === 1) {//segment length 1			
			return minLength+1;
		} else if (chrArr.length === 2) {//segment length 2
			if (chrArr[0]==='A' && chrArr[1]==='B' || 
				chrArr[0]==='C' && chrArr[1]==='D') {
				return minLength;
			} else {
				return minLength+2;
			}//fi			
		}//fi
	
	
		//console.log('before while, minLength: ' + chrArr.length + ':' + JSON.stringify(chrArr));

	
		//remove all AB CD instances
		let trimmedArr;
		let prevIterationArrLength;
		do {
			prevIterationArrLength = chrArr.length;
			trimmedArr = new Array();
			for (inx=0; inx<chrArr.length-1; inx++) {
				if (chrArr[inx]==='A' && chrArr[inx+1]==='B' || chrArr[inx]==='C' && chrArr[inx+1]==='D') {
					inx++;
				} else {
					trimmedArr.push(chrArr[inx]);
				}//fi
			}//rof
			if (inx === chrArr.length-1){
				trimmedArr.push(chrArr[inx]);
			}//fi
			trimmedArrLength = trimmedArr.length;
			chrArr = trimmedArr;
			//console.log(chrArr + ' trimmedArrLength:' + trimmedArrLength + ' chrArr.length: ' + chrArr.length);
		} while (prevIterationArrLength !== trimmedArr.length);
	
		//console.log('while end, minLength: ' + chrArr.length + ':' + JSON.stringify(chrArr));
		minLength += chrArr.length;
		//console.log(chrArr);
		return minLength;
	};//end method
    
    return getMinLength(chrArr);
};

var testFunc = function() {
	
	let s;


	s = "ABFCACDB";
	console.log("ans: " + minLength(s));
	s = "ACBBD";
	console.log("ans: " + minLength(s));
	


	/*
	
	s = "ACBBD";
	console.log("ans: " + minLength(s));
	

	s = "ABFCACDB";
	console.log("ans: " + minLength(s));
	
	s = "EFFGEADEFEWG";
	console.log("ans: " + minLength(s));


	//*/
};

testFunc();


