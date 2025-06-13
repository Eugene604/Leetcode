/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
	
	let partitions = [];
	let singleCharPartition = s.split("");


	/**
	 * Checks if a portion of singleCharPartition is a palindrome
	 * 
	 * Preconditions:
	 * - The begin and end indices are valid and within the bounds of the string array.
	 * - singleCharPartition is available and instantiated
	 * 
	 * @param {number} beginInx - The begin index (inclusive).
	 * @param {number} endInx - The end index (inclusive).
	 * @returns {boolean} - Returns true if the specified portion of the array is a palindrome, otherwise false.
	 */
	let isPalidrome = function(beginInx, endInx){				
		do {
			if (singleCharPartition[beginInx] != singleCharPartition[endInx]) {
				return false;
			}//fi
			beginInx++;
			endInx--;
		} while (endInx > beginInx);
		
		return true;
	}//end method	
	
	/**
	 * Recursively generate partitions based on model single character partition array and store to the partitions array
	 * 
	 * Preconditions:
	 * - The begin index are valid and within the bounds of the model array.
	 * - partitions array is available and instantiated
	 * - singleCharPartition is available and instantiated
	 * 
	 * @param {number[][]} partitionInxArr - An array of character begin and end index pair
	 * @param {number} beginInx - The next begin index	 
	 * @returns {void} 
	 */	
	let generatePartition = function(beginInx, partitionInxArr) {
		if (isPalidrome(beginInx, singleCharPartition.length-1)){
			partitionInxArr.push([beginInx, singleCharPartition.length-1]);
			//console.log(getPartition(partitionInxArr));
			partitions.push(getPartition(partitionInxArr));
			partitionInxArr.pop();		
		}//fi

		if (beginInx === singleCharPartition.length-1) {
			return;
		}//fi
		
		for (let endInx=beginInx; endInx<singleCharPartition.length-1; endInx++){
			if (isPalidrome(beginInx, endInx)){
				partitionInxArr.push([beginInx, endInx]);
				generatePartition(endInx+1, partitionInxArr);
				partitionInxArr.pop();
			}//fi
		}//rof		
	}//end method
	
	/**
	 * Precondition:
	 * - partition index array contains valid indices
	 * - singleCharPartition is available and instantiated
	 * @param {number[][]} partitionInxArr - An array of character begin and end index pair
	 * @returns {string[]} - String array generated based on partition index array 
	 */
	let getPartition = function(partitionInxArr) {
		//console.log("partitionInxArr: " + JSON.stringify(partitionInxArr));
		let partition = [];
		for (let i=0; i<partitionInxArr.length; i++){
			partition.push(singleCharPartition.slice(partitionInxArr[i][0], partitionInxArr[i][1] + 1).join(""));	
		}//rof
		return partition;
	}//end method
	
	generatePartition(0,[]);
    return partitions;
};

var s;

s = "aab";
console.log("ans: " + JSON.stringify(partition(s)));

s = "abbab";
console.log("ans: " + JSON.stringify(partition(s)));


