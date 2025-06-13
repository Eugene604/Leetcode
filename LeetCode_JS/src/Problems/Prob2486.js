/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var appendCharacters = function(s, t) {
	let tInx = 0;
	for (let sInx = 0; sInx < s.length && tInx < t.length; sInx++){
		if (s.charCodeAt(sInx) === t.charCodeAt(tInx)) {
			tInx++;
		}//fi
	}//rof
	
	if (tInx === t.length-1) {
		
	}//fi
    return t.length-tInx;
};



let s, t;

s = "coaching";
t = "coding"

console.log("ans: " + appendCharacters(s, t));
