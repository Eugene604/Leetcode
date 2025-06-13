/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var minDays = function(bloomDay, m, k) {
    if (bloomDay.length / k < m){
        return -1;
    }//fi

	let maxDay = 0;
	let minDay = 2_000_000_000;
	
	for (let i=0; i<bloomDay.length; i++){
		if (bloomDay[i] > maxDay){
			maxDay = bloomDay[i];
		} else if (bloomDay[i] < minDay) {
			minDay = bloomDay[i];
		}//fi
	}//rof
	
    let getBouquets = function(day,k){
		let bCnt = 0;
		let bInx = -1;
		let localCDays;
		for (let i=0; i<bloomDay.length; i++){
			if (bloomDay[i] > day){
				if (bInx != -1){
					localCDays = i-bInx;
					bCnt += Math.floor(localCDays/k);
					bInx = -1;
				}//fi				
			} else {
				if (bInx === -1){					
					bInx = i;
				}//fi	
			}//fi
		}//rof
		if (bInx != -1){
			localCDays = bloomDay.length-bInx;
			bCnt += Math.floor(localCDays/k);
		}//fi	
		return bCnt;
	};//end method
	
	//console.log(getBouquets(10,1));

	
	let hi = maxDay;
	let lo = minDay;
	let mid;
	let currM;
	while (hi>lo){
		//console.log('hi: ' + hi + ' lo: ' + lo);
		mid = Math.floor((hi+lo)/2);
		currM = getBouquets(mid,k);
		if (currM > m){
			hi = mid-1;
		} else if (currM < m){
			lo = mid+1;
		} else {
			hi = mid;
		}
	}//end while
    return lo;
};
let bloomDay, m, k;

bloomDay = [1,10,3,10,2], m = 3, k = 1;

console.count('ans: ' + minDays(bloomDay, m, k) );
