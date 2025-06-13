const COMMON_DENOM = 2520;
//index: number, value: the multiplier to be used to obtain common denominator 
const MULTIPLIER = new Array(11);
{
	MULTIPLIER[1] = 2520;
	MULTIPLIER[2] = 1260;
	MULTIPLIER[3] = 840;
	MULTIPLIER[4] = 630;
	MULTIPLIER[5] = 504;
	MULTIPLIER[6] = 420;
	MULTIPLIER[7] = 360;
	MULTIPLIER[8] = 315;
	MULTIPLIER[9] = 280;
	MULTIPLIER[10] = 252;
}
const BASE_FACTORS = [5,2,2,2,7,3,3];

/**
 * @param {string} expression
 * @return {string}
 */
var fractionAddition = function(expression) {
	
	let regex = /([+-]?\d+)\/(\d+)/g;

	// Parse and store each fraction as a tuple [numerator, denominator]
	let fractions = Array.from(expression.matchAll(regex), match => [
	  parseInt(match[1]), // Numerator
	  parseInt(match[2])  // Denominator
	]);
	//console.log(fractions); 
		
	//find expanded result
	let expandedMumeratorSum = 0;
	for (let i=0; i<fractions.length; i++){
		expandedMumeratorSum += fractions[i][0]*MULTIPLIER[fractions[i][1]];
	}//rof

	//convert to irreducible fraction
	
	let denominator = COMMON_DENOM;
	for (let i=0; i<BASE_FACTORS.length; i++){
		if (expandedMumeratorSum%BASE_FACTORS[i] === 0) {
			expandedMumeratorSum /= BASE_FACTORS[i];
			denominator /= BASE_FACTORS[i];
		}//fi
	}//rof

    return expandedMumeratorSum + '/' + denominator;
};

let expression; 


expression = "-1/3+1/4-1/5+1/6-1/7+1/8-1/9+1/10-1/9+1/10";

console.count('ans: ' + fractionAddition(expression));
