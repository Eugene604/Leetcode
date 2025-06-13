/**
 * @param {string} sentence1
 * @param {string} sentence2
 * @return {boolean}
 */
var areSentencesSimilar = function(sentence1, sentence2) {
	let s1Arr = sentence1.split(' ');
	let s2Arr = sentence2.split(' ');
	let longerSArr, shorterSArr;
	
	if (s1Arr.length < s2Arr.length) {
		shorterSArr = s1Arr;
		longerSArr = s2Arr;
	} else if (s1Arr.length > s2Arr.length) {
		shorterSArr = s2Arr;
		longerSArr = s1Arr;
	} else { //special case, eq length
		for (let i=0; i<s1Arr.length; i++){
			if (s1Arr[i] !== s2Arr[i]) {
				return false;
			}//fi
		}//rof
		return true;
	}//fi
    //console.log(s1Arr);
    
    let prefixEndInx, suffixStartInx;
    let longerSInx;
    for (longerSInx=0, prefixEndInx=0; prefixEndInx < shorterSArr.length; longerSInx++, prefixEndInx++){
		if (longerSArr[longerSInx] === shorterSArr[prefixEndInx]) {
			continue;
		} else {
			prefixEndInx--;
			break;
		}//fi
	}//rof
	
	for (longerSInx=longerSArr.length-1, suffixStartInx=shorterSArr.length-1; 
		suffixStartInx >= 0, suffixStartInx >= prefixEndInx; 
		suffixStartInx--, longerSInx--){
		if (longerSArr[longerSInx] === shorterSArr[suffixStartInx]) {
			continue;
		} else {
			suffixStartInx++;
			break;
		}//fi;
	}//rof
    //console.log(prefixEndInx + ':' + suffixStartInx)
    if (prefixEndInx < suffixStartInx-1){
		return false;
	} else {
		return true;
	}//fi
};

var testFunc = function() {
	
	let sentence1, sentence2;
	
	
	

	sentence1 = "My name is Haley", sentence2 = "My Haley";
	console.log("ans: " + areSentencesSimilar(sentence1, sentence2));


	//*/
};

testFunc();


