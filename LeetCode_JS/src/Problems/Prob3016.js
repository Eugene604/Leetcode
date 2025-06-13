
/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function(word) {
	let cntArr = new Array(26).fill(0);
	
	for (let i=0; i<word.length; i++){
		cntArr[word.charCodeAt(i)-97]++;	
	}//rof
	
	cntArr.sort((a,b)=>b-a);
	//console.log(cntArr);
	
	let pushCnt = 0;
	let charPush = 1;
	let cntInx;
	for (cntInx = 0; cntInx<8; cntInx++){
		pushCnt += cntArr[cntInx]*charPush;
	}//rof
	charPush++;
	for (; cntInx<16 && cntArr[cntInx]>0; cntInx++){
		pushCnt += cntArr[cntInx]*charPush;
	}//rof
	charPush++;
	for (; cntInx<24 && cntArr[cntInx]>0; cntInx++){
		pushCnt += cntArr[cntInx]*charPush;
	}//rof
	
	charPush++;
	for (; cntInx<26 && cntArr[cntInx]>0; cntInx++){
		pushCnt += cntArr[cntInx]*charPush;
	}//rof
	return pushCnt;
    
};

let word;


word = "abcde";
console.log('ans: ' + minimumPushes(word));



/*

//*/
