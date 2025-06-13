let likeCntArr  = new Array(1001);
/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
	//special case 1: n is 1
	if (n===1){
		return 1;
	}//fi
	
	//special case 2: trust relations is less than n-1, no judge is possible
	if (trust.length < n-1) {
		return -1;
	}//fi
	
	likeCntArr.fill(0,0,n+1);
	
	for (let i=0; i<trust.length; i++){		
		likeCntArr[trust[i][0]] = -n;
		likeCntArr[trust[i][1]]++;
	}//rof
	//console.log(likeCntArr);
	for (let i=1; i<=n; i++){
		if (likeCntArr[i] === n-1 ) {
			return i;
		}//fi
	}//rof	
    return -1;
};

var testFunc = function() {
	let trust1 = [[1,2]];
	let trust2 = [[1,3],[2,3]];
	let trust3 = [[1,3],[2,3],[3,1]];
	
	let n;
	let trust;
	
	
	trust = trust3;
	n=3;
	console.log("ans: " + findJudge(n, trust));
};



testFunc();
