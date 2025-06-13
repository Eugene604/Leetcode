/**
 * @param {string[]} details
 * @return {number}
 */
var countSeniors = function(details) {
	
	let ageStr;
	let age;
	let cnt = 0;
	
	for (let i=0; i<details.length; i++){
		ageStr = details[i].slice(11, 13);
		age = Number.parseInt(ageStr);
		if (age>60) {
			cnt++;
		}//fi
	}//rof
	
	return cnt;
    
};

let details;

details = ["1313579440F2036","2921522980M5644"];

console.log('ans: ' + countSeniors(details));

/*
s = "aababbab";

//*/

