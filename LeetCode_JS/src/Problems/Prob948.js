/**
 * @param {number[]} tokens
 * @param {number} power
 * @return {number}
 */
var bagOfTokensScore = function(tokens, power) {
	tokens.sort((a, b) => a - b);
	//console.log(tokens);
	let lowValInx = 0;
	let highValInx = tokens.length-1;
	let score = 0;
	while (highValInx >= lowValInx){		
		if (power >= tokens[lowValInx]){//power is enough, play it
			power -= tokens[lowValInx];
			lowValInx++;
			score++;
			//continue;
		} else if (score > 0 && highValInx > lowValInx) {//exchange score for power, worth it if there's further move
			power += tokens[highValInx];
			highValInx--;
			score--;	
		} else {//dead end
			return score;
		}//fi
	}//end while
    return score;
};

var tokens1 = [100];
var tokens2 = [300,200,100,400];
var tokens3 = [200,100];



let tokens, power;

/*
tokens = tokens1;
power = 50;
console.log("ans : " + bagOfTokensScore(tokens, power));


tokens = tokens2;
power = 200;
console.log("ans : " + bagOfTokensScore(tokens, power));

//*/

tokens = tokens3;
power = 150;
console.log("ans : " + bagOfTokensScore(tokens, power));