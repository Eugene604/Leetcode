/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
var countConsistentStrings = function(allowed, words) {
	
	
    let isAllowed = new Array(256).fill(false);
    for (let i=0; i<allowed.length; i++){
		isAllowed[allowed.charCodeAt(i)] = true;
	}//rof
	
	let consistecyCnt = 0;
	let isWordConsistent;
	for (let wordInx=0; wordInx < words.length; wordInx++){
		isWordConsistent = true;
		for (let i=0; i<words[wordInx].length; i++){
			isWordConsistent &&= isAllowed[words[wordInx].charCodeAt(i)];			
		}//rof
		if (isWordConsistent){
			consistecyCnt++;
		}//fi
	}//rof
	
	return consistecyCnt;
};

let allowed, words; 

allowed = "ab", words = ["ad","bd","aaab","baa","badab"]

console.log('ans: ' + countConsistentStrings(allowed, words));
