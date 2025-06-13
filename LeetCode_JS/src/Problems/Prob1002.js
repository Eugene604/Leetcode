var baselineCntArr = new Array(123);
var cntArr = new Array(123);

/**
 * @param {string[]} words
 * @return {string[]}
 */
var commonChars = function(words) {
	baselineCntArr.fill(0,97,123);
	for (let cInx=0; cInx<words[0].length; cInx++){		
		baselineCntArr[words[0].charCodeAt(cInx)]++;		
	}//rof
	
	for (let i=1; i<words.length; i++) {
		cntArr.fill(0,97,123);
		for (let cInx=0; cInx<words[i].length; cInx++){
			cntArr[words[i].charCodeAt(cInx)]++;				
		}//rof
		
		for (let asciiCode=97; asciiCode<123; asciiCode++){
			if (baselineCntArr[asciiCode] > cntArr[asciiCode]){
				baselineCntArr[asciiCode] = cntArr[asciiCode];
			}//fi
		}//rof
	}//rof
	
	let commonCharsArr = [];
	for (let asciiCode=97; asciiCode<123; asciiCode++){
		for (let i=0; i<baselineCntArr[asciiCode]; i++){
			commonCharsArr.push(String.fromCharCode(asciiCode));
		}//rof
	}//rof
	return commonCharsArr;
    
};

var testFunc = function() {
	let words;
	
	words = ["cool","lock","cook"];


	console.log("ans: " + JSON.stringify(commonChars(words)));
};



testFunc();
