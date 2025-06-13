/**
 * @param {string} s
 * @return {number}
 */
var minimumDeletions = function(s) {
	
	if (s.length === 1) { //special case: s.length is 1
		return 0;
	} else if (s.length === 2) { //special case: s.length is 2
		return (s === "ba") ? 1 : 0;
	}//fi
	
	let prefixBArr, postfixAArr;
	let firstNonZeroPrefixBInx, lastNonZero
	let minDeleteCnt, deleteCnt;
	
	//step 1, populate prefixB array and postfixA array and also determine first/last inx of nonzero values
	prefixBArr = new Array(s.length).fill(0);
	prefixBArr[0] = (s[0] === 'b') ? 1 : 0; 
	for (let i=1; i<s.length; i++){
		if (s[i] === 'b'){
			prefixBArr[i] = prefixBArr[i-1]+1;
		} else {
			prefixBArr[i] = prefixBArr[i-1];
		}//fi
	}//rof
	//console.log('prefixBArr:  ' + JSON.stringify(prefixBArr));
	
	postfixAArr = new Array(s.length).fill(0);
	postfixAArr[s.length-1] = (s[s.length-1] === 'a') ? 1 : 0;
	for (let i=s.length-2; i>=0; i--){
		if (s[i] === 'a'){
			postfixAArr[i] = postfixAArr[i+1]+1;
		} else {
			postfixAArr[i] = postfixAArr[i+1];
		}//fi
	}//rof
	//console.log('postfixAArr: ' + JSON.stringify(postfixAArr));
	
	//step 2, process first and last index and check for edge case
	if (postfixAArr[0] === 0 || prefixBArr[s.length-1] === 0) {//there's no a or b
		return 0;		
	}//fi
	
	minDeleteCnt = postfixAArr[1]; //let inx 0 as separator, delete every A behind 
	
	minDeleteCnt = Math.min(minDeleteCnt, prefixBArr[s.length-1]); //let last inx as separator, delete every B in front of it
	
	
	//step 3, for each index, try let it be a separator and then calculate its delete count 
	for (let i=1; i<s.length-1 && postfixAArr[i] !== 0; i++){
		if (prefixBArr[i] === 0){ //won't be a good separator
			continue;
		}//fi
		deleteCnt = prefixBArr[i-1]; //delete every B in front of it
		deleteCnt += postfixAArr[i+1]; //delete every A behind it 			
		minDeleteCnt = Math.min(minDeleteCnt, deleteCnt);
	}//rof
	
    return minDeleteCnt;
};

let s;

s = "bbbbaaaa";
console.log('s: ' + s);
console.log('ans: ' + minimumDeletions(s));

/*
s = "aababbab";
console.log('s: ' + s);
console.log('ans: ' + minimumDeletions(s));
//*/

