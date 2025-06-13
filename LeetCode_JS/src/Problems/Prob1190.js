/**
 * @param {string} s
 * @return {string}
 */
var reverseParentheses = function(s) {
	
	/**
	 * Adds an element to the tail of the array.
	 *
	 * This function pushes the given element to the end of the specified array.
	 *
	 * @param {Array} arr - The array to which the element will be added.
	 * @param {*} element - The element to be added to the array.
	 */
	let addToArrayTail = function(arr, element) {
		arr.push(element);
	};

	/**
	 * Adds an element to the head of the array.
	 *
	 * This function unshifts the given element to the beginning of the specified array.
	 *
	 * @param {Array} arr - The array to which the element will be added.
	 * @param {*} element - The element to be added to the array.
	 */
	let addToArrayHead = function(arr, element) {
		arr.unshift(element);
	};
	
	/**
	 * precondition: 
	 * - string variable s is available
	 * - it is assumed that parentheses are valid
	 * - start and end char indices do NOT include the parathese from upper function call
	 * @param {number} startInx - Start char index of the string
	 * @param {number} endInx - End char index of the string 
	 * @param {boolean} isReverse - Whether to reverse or not at this iteration.
	 * @returns {string} - The concatenated string, optionally reversed.
	 */
	let parseStr = function(startInx, endInx, isReverse){
		let charArr = [];
		let numOfLeftParen = 0;
		let firstLeftParenInx;
		let addElement;
		if (isReverse) {
			//console.log('reverse mode');	
		    addElement = addToArrayHead;
		} else {
			//console.log('normal mode');
		    addElement = addToArrayTail;
		}//fi
		
		for (let i=startInx; i<=endInx; i++) {
			if (s[i] === "("){
				//console.log('gone here 1, i=' + i);	
				numOfLeftParen++;
				if (numOfLeftParen === 1) {
					firstLeftParenInx = i; 
				}//fi
			} else if (s[i] === ")"){
				//console.log('gone here 2, i=' + i);	
				numOfLeftParen--;
				if (numOfLeftParen === 0) {
					addElement(charArr, parseStr(firstLeftParenInx+1,i-1, !isReverse));
				}//fi
			} else if (numOfLeftParen===0){
				addElement(charArr, s[i]);	
			} else { //scan first level parenthese content mode
				//do nothing
			}//fi			
		}//fi
		
		return charArr.join("");
	};//end method
	
    return parseStr(0, s.length-1, false);
};

var testFunc = function() {
	let s;

	/*
	s = "(abcd)";
	console.log("ans: " + reverseParentheses(s));
	//*/
	
	s = "(u(love)(very)i)";
	console.log("ans: " + reverseParentheses(s));
};



testFunc();
