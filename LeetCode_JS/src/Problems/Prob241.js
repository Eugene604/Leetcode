const operatorMap = {
    '+': -1,
    '-': -2,
    '*': -3
};

/**
 * @param {string} expression
 * @return {number[]}
 */
var diffWaysToCompute = function(expression) {
	
	/**
	 * Computes the result of two numbers based on the given operator.
	 * 
	 * @param {number} num1 - The first operand.
	 * @param {number} num2 - The second operand.
	 * @param {number} operator - The operator represented by a negative number 
	 * (-1 for addition, -2 for subtraction, -3 for multiplication).
	 * 
	 * @returns {number} The computed result based on the operator.
	 */
	let compute = function(num1, num2, operator){
		switch (operator) {
			case -1:
				return num1+num2;
			case -2:
				return num1-num2;
			case -3:
				return num1*num2;
		}//end switch
	};//end method
	
	
	
	/**
	 * Recursively computes all possible results by dividing the expression
	 * array into smaller subarrays and solving each part.
	 * 
	 * Preconditions:
	 * - expArr is valid.
	 * - leftInx and rightInx are valid - must be within range, edge indices must not contain operators.
	 * 
	 * @param {number[]} expArr - The array containing numbers and operators in the format of [number, operator, number, ...].
	 * @param {number} leftInx - The left index of the subarray being processed.
	 * @param {number} rightInx - The right index of the subarray being processed.
	 * 
	 * @returns {number[]} An array of results from all possible computations for the given subexpression.
	 */
	let computeResult = function(expArr, leftInx, rightInx) {
		//base cases 
		if (leftInx === rightInx) {//single number
			return [expArr[leftInx]];
		} else if (rightInx - leftInx === 2) {//sub arr size is 3, means it's two number and one operator:
			return [compute(expArr[leftInx], expArr[rightInx], expArr[(leftInx + rightInx)/2])];
		}//fi
		
		let resultArr = [];
		let leftResultArr, rightResultArr;
		for (let operatorInx = leftInx+1; operatorInx < rightInx; operatorInx+=2){
			leftResultArr = computeResult(expArr, leftInx, operatorInx-1);
			rightResultArr = computeResult(expArr, operatorInx+1, rightInx);
			for (const leftResult of leftResultArr){
				for (const rightResult of rightResultArr){
					resultArr.push(compute(leftResult, rightResult, expArr[operatorInx]));
				}//rof
			}//rof
		}//rof
		return resultArr;
	};//end method
	
	const expressionArr = expression.split(/([+-/*])/).map(item => {
    	return isNaN(item) ? operatorMap[item] : Number(item);
	});
	console.log(expressionArr);
	
	let resultArr = computeResult(expressionArr, 0, expressionArr.length-1);
    return resultArr;
};

let expression;
expression = "2-1-1";

console.log('ans: ' + JSON.stringify(diffWaysToCompute(expression)));
 
