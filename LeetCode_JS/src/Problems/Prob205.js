/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
	if (s.length != t.length) {
		return false;
	}//fi
	
	let getCharAppearanceInxArr = function(s){
		let charInxMap = new Map();
		let charAppearanceInxArr = new Array();	
		let charInx, nextAvailInx = 0;		
		for (let i=0; i<s.length; i++) {
			if ((charInx = charInxMap.get(s.charCodeAt(i)))===undefined) {
				charInxMap.set(s.charCodeAt(i), nextAvailInx);
				charInx = nextAvailInx;
				nextAvailInx++;
			}//fi
			charAppearanceInxArr.push(charInx);
		}//rof
		return charAppearanceInxArr;
	}//end method
	
	let sCharAppearanceInxArr = getCharAppearanceInxArr(s);
	let tCharAppearanceInxArr = getCharAppearanceInxArr(t);
	
	for (let i=0; i<s.length; i++) {
		if (sCharAppearanceInxArr[i] != tCharAppearanceInxArr[i]) {
			return false;
		}//fi
	}//rof
	return true;    
};


let str1 = "egg";
let str2 = "add";

let s,t;

s = str1;
t = str2;
console.log('ans: ' + isIsomorphic(s,t));
