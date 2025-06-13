const LV_STCNT_MAP = new Array(10); //level subtotal count map
{
	LV_STCNT_MAP[8]=111_111_110;
	LV_STCNT_MAP[7]=11_111_110;
	LV_STCNT_MAP[6]=1_111_110;
	LV_STCNT_MAP[5]=111_110;
	LV_STCNT_MAP[4]=11_110;
	LV_STCNT_MAP[3]=1_110;
	LV_STCNT_MAP[2]=110;
	LV_STCNT_MAP[1]=10;
	LV_STCNT_MAP[0]=0;	
}
/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var findKthNumber = function(n, k) {
	
	/**
	 * precondition:
	 * currCnt must not be equal to k
	 */
    let cntNum = function(prefixNum, maxNum, currCnt, targetCnt, pwrLv){
		let currPrefixNum = prefixNum * 10;
		if (pwrLv < 0 || currPrefixNum > n) {//this level already exceeds original n
			return 0;
		}//fi
		let cnt, trialCnt;
		let maxBound = currPrefixNum+9;
		let currNum;
		//console.log('prefixNum is ' + prefixNum + ' targetCnt:'+targetCnt);
		//fast cnt increment by using power level
		for (currNum = currPrefixNum; currNum <= maxNum && currNum <= maxBound; currNum++){
			currCnt++;
			if (currCnt === targetCnt){
				return -currNum;
			}//fi
			trialCnt = currCnt + LV_STCNT_MAP[pwrLv];
			if (trialCnt < targetCnt){
				//console.log("trial accepted, currNum:" + currNum + " trialCnt:" + trialCnt);
				currCnt = trialCnt;
			} else if (trialCnt === targetCnt){
				console.log("return from here 5");
				return -((currNum+1)*Math.pow(10,porLv)-1);
			} else {
				//console.log('break from here 5');
				break;
			}//fi
		}//rof
		//console.log('currNum is: ' + currNum);
		cnt = cntNum(currNum, maxNum, currCnt, targetCnt, pwrLv-1);
		if (cnt < 0){
			return cnt;
		} else if (cnt === 0) {
			//break;
		} else {
			currCnt = cnt;
		}//fi
	
		
		return currCnt;
	};//end method
	
	let totalCnt = 0;
	let cnt;
	//special case, n<10
	if (n<10){
		return k;
	}//fi
	
	//step 1: get power level (base 10)
	let pwrLv = 0;
	let tmpN = n;
	while(tmpN > 9) {
		tmpN /= 10;
		Math.floor(tmpN);
		pwrLv++;
	}//end while
	
	console.log('pwr lv: ' + pwrLv);
	for (let i=1; i<=9; i++){
		totalCnt++;
		if (totalCnt === k){
			console.log("return from here 1");
			return i;
		}//fi
		cnt = cntNum(i, n, totalCnt, k, pwrLv-2);
		if (cnt < 0){
			console.log("return from here 2, cnt:" + cnt);
			return -cnt;
		} else if (cnt === 0) {
			console.log("cnt returns 0, i=" + i);
			//do nothing
		} else {
			console.log("cnt:" + cnt);
			totalCnt = cnt;	
		}//fi			
	}//rof

	//console.log("return from here 3");
	return totalCnt;
};


let n, k;

n = 13, k = 2;
console.log('Ans: ' + findKthNumber(n,k));

/*

n = 681692778, k = 351251360;
console.log('Ans: ' + findKthNumber(n,k));


n = 1000000000, k = 1000000000;
console.log('Ans: ' + findKthNumber(n,k));
//*/


/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var findKthNumber_v2 = function(n, k) {
	
	/**
	 * precondition:
	 * currCnt must not be equal to k
	 */
    let cntNum = function(prefixNum, maxNum, currCnt, k){
		let currPrefixNum = prefixNum * 10;
		if (currPrefixNum > n) {//this level already exceeds original n
			return 0;
		}//fi
		let cnt;
		let maxBound = currPrefixNum+9;
		for (let currNum = currPrefixNum; currNum <= maxNum && currNum <= maxBound; currNum++){
			currCnt++;
			if (currCnt === k){
				return -currNum;
			}//fi
			cnt = cntNum(currNum, maxNum, currCnt, k);
			if (cnt < 0){
				return cnt;
			} else if (cnt === 0) {
				//break;
			} else {
				currCnt = cnt;
			}//fi
		}//rof
		return currCnt;
	};//end method
	
	let totalCnt = 0;
	let cnt;
	//special case, n<10
	if (n<10){
		return k;
	} else {
		for (let i=1; i<=9; i++){
			totalCnt++;
			if (totalCnt === k){
				console.log("return from here 1");
				return i;
			}//fi
			cnt = cntNum(i, n, totalCnt, k);
			if (cnt < 0){
				//console.log("return from here 2");
				return -cnt;
			} else if (cnt === 0) {
				//console.log("cnt returns 0, i=" + i);
				//do nothing
			} else {
				console.log("cnt:" + cnt);
				totalCnt = cnt;	
			}//fi			
		}//rof
	}//fi
	//console.log("return from here 3");
	return totalCnt;
};
