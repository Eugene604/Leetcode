/**
 * @param {string} s
 * @param {string} t
 * @param {number} maxCost
 * @return {number}
 */
var equalSubstring = function(s, t, maxCost) {
	let costArr = [];
	for (let i=0; i<s.length; i++){
		costArr[i] = Math.abs(s.charCodeAt(i) - t.charCodeAt(i));	
	}//rof
	//console.log('cost arr: ' + JSON.stringify(costArr));
	let maxLength = 0;
	
	let leftInx = 0, rightInx = 0;
	
	let currCost =  costArr[0];
	
	do {
		while (currCost <= maxCost) {
			maxLength = (maxLength, rightInx - leftInx + 1);
			//console.log('currCost: ' + currCost + ' leftInx :  rightInx: ' + leftInx + ' : ' + rightInx + ' maxLength:' + maxLength);
			if (rightInx < t.length-1) {
				rightInx++;
				currCost += costArr[rightInx];
			} else {
				break;
			}//fi
		}//end while		
		
		currCost -= costArr[leftInx];
		leftInx++;
		rightInx++;
		currCost += costArr[rightInx];
	} while (rightInx < t.length) //end do while
	 
    return maxLength;
};

let s, t;
let maxCost;

s = "abcd";
t = "bcdf";
maxCost = 3;
console.log(s + ':' + t + ' maxCost:' + maxCost + ' ans: ' + equalSubstring(s, t, maxCost));


s = "abcd";
t = "cdef";
maxCost = 3;
console.log(s + ':' + t + ' maxCost:' + maxCost + ' ans: ' + equalSubstring(s, t, maxCost));

s = "abcd";
t = "acde";
maxCost = 0;
console.log(s + ':' + t + ' maxCost:' + maxCost + ' ans: ' + equalSubstring(s, t, maxCost));

//*/

s = "pxezla";
t = "loewbi";
maxCost = 25;
console.log(s + ':' + t + ' maxCost:' + maxCost + ' ans: ' + equalSubstring(s, t, maxCost));

