/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
	let s1WSet = new Set();
	let s2WSet = new Set();
	
	for (const word of s1.split(' ')){
		if (s1WSet.has(word)){//duplicate
			s2WSet.add(word);
		} else {
			s1WSet.add(word);
		}//fi
	}//rof
	
	for (const word of s2.split(' ')){
		if (s2WSet.has(word)){//duplicate
			s1WSet.add(word);
		} else {
			s2WSet.add(word);
		}//fi
	}//rof
	
	let uncommonWArr = [];
	
	for (const word of s1WSet){
		if (!s2WSet.has(word)){//uncommon
			uncommonWArr.push(word);
		}//fi
	}//rof
	
	for (const word of s2WSet){
		if (!s1WSet.has(word)){//uncommon
			uncommonWArr.push(word);
		}//fi
	}//rof
	
    return uncommonWArr;
};

let s1, s2;

s1 = "this apple is sweet", s2 = "this apple is sour";
console.log('ans: ' + JSON.stringify(uncommonFromSentences(s1, s2)));
 
