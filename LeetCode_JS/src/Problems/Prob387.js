var cntArr;
{
	cntArr = new Array(2);
	cntArr[0] = new Array(123);
	cntArr[1] = new Array(123);
} 

/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
	cntArr[0].fill(0, 97,123);
	cntArr[1].fill(0, 97,123);
	
	let charCode;
	for (let i=0; i<s.length; i++){
		charCode = s.charCodeAt(i);
		cntArr[0][charCode]++;
		cntArr[1][charCode] = i;
	}//rof
	
	//console.log(JSON.stringify(cntArr));
	
	let smallestInx = 1048576;
	for (let i=97; i<123; i++){		
		if (cntArr[0][i] == 1 && cntArr[1][i] < smallestInx) {
			smallestInx = cntArr[1][i];
		}//fi
		
	}//rof
	
    return (smallestInx == 1048576)? -1 : smallestInx;
};



var s1 = "loveleetcode"; // 2
var s2 = "leetcode"; // 0
var s3 = "aabb"; //-1


let s;
s = s1;

console.log("ans: " + firstUniqChar(s));
