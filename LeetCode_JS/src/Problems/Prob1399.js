var numToLGrpsizeMap = new Map();
{	
	let onesDig, tensDig, hundredsDig, thousandsDig;
	let wholeNum = 0;
	let largestGrpSize = 0;
	
	//array index = sum, array value = count of elements with same sum
	let samesumToGrpsizeArrMap = new Array(37).fill(0); 
	
	
	let sumOfDigs;
	let numOfGrpsWithLargestSize = 0;
	
	samesumToGrpsizeArrMap[0] = -1;
	for (thousandsDig=0; thousandsDig < 10; thousandsDig++){
		for (hundredsDig=0; hundredsDig < 10; hundredsDig++){
			for (tensDig=0; tensDig < 10; tensDig++){
				for (onesDig=0; onesDig < 10; onesDig++, wholeNum++){
					sumOfDigs = onesDig+tensDig+hundredsDig+thousandsDig;
					samesumToGrpsizeArrMap[sumOfDigs]++;
					if (samesumToGrpsizeArrMap[sumOfDigs] > largestGrpSize){
						largestGrpSize = samesumToGrpsizeArrMap[sumOfDigs];
						numOfGrpsWithLargestSize = 1;
					}  else if (samesumToGrpsizeArrMap[sumOfDigs] === largestGrpSize){
						numOfGrpsWithLargestSize++;
					}//fi
					numToLGrpsizeMap.set(wholeNum, numOfGrpsWithLargestSize);
				}//rof	
			}//rof
		}//rof
	}//rof
	
	numToLGrpsizeMap.set(10000, numOfGrpsWithLargestSize);
	

	//console.log(Object.fromEntries(numToLGrpsizeMap.entries()));
}

/**
 * @param {number} n
 * @return {number}
 */
var countLargestGroup = function(n) {
    return numToLGrpsizeMap.get(n);
};


let n;

n=3;
console.log('ans: ' + countLargestGroup(3));