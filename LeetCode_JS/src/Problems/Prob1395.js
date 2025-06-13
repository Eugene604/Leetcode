/**
 * @param {number[]} rating
 * @return {number}
 */
var numTeams = function(rating) {
	let postFixGreater = new Array(rating.length).fill(0);
	let postFixLess = new Array(rating.length).fill(0);
	for (let j=1; j<rating.length-1; j++){
		for (let k=j+1; k<rating.length; k++){
			if (rating[j] > rating[k]) {
				postFixLess[j]++;
			} else {
				postFixGreater[j]++;
			}//fi
		}//rof
	}//rof
	
	let cnt = 0;
	for (let i=0; i<rating.length-2; i++){
		for (let j=i+1; j<rating.length-1; j++){			
			if (rating[i] < rating[j]) {
				cnt += postFixGreater[j];
			} else {
				cnt += postFixLess[j];
			}//fi	
		}//rof
	}//rof
    return cnt;
};

let rating;
rating = [2,1,3];

console.log("ans: " + numTeams(rating));


