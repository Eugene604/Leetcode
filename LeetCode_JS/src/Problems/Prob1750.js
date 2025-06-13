/**
 * @param {string} s
 * @return {number}
 */
var minimumLength = function(s) {
	let prefixInx = 0;
	let sufficInx = s.length-1;
	let charCandidate;
	while (prefixInx < sufficInx && s[prefixInx] === s[sufficInx]){
		//console.log('before: ' + s.substring(prefixInx, sufficInx+1));
		charCandidate = s[prefixInx];
		while (prefixInx < sufficInx && s[prefixInx] === charCandidate){
			prefixInx++;
		}//fi
		while (prefixInx <= sufficInx && s[sufficInx] === charCandidate){
			sufficInx--;
		}//fi	
		//console.log('after: ' + s.substring(prefixInx, sufficInx+1));
	}//end while
	//console.log('prefixInx: ' + prefixInx + ' sufficInx: ' + sufficInx);
    return sufficInx - prefixInx +1;
};

var str1 = "aca";
var str2 = "aa";

var str3 = "aabccabba";
var str4 = "ca";
var str5 = "cabaabac";




let str;


str = str1;
console.log("ans : " + minimumLength(str));

/*
str = str1;
console.log("ans : " + minimumLength(str));


str = str3;
console.log("ans : " + minimumLength(str));
//*/