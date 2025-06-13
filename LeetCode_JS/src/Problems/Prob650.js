var moCache;
{
	moCache = new Array(1001).fill(-1);
	moCache[1] = 0;
	moCache[2] = 2;
	moCache[3] = 3;
	moCache[4] = 4;
    moCache[5] = 5;
    moCache[7] = 7;
    moCache[11] = 11;
    moCache[13] = 13;
    moCache[17] = 17;
    moCache[19] = 19;
    moCache[23] = 23;
    moCache[29] = 29;
    moCache[31] = 31;
    moCache[37] = 37;
    moCache[41] = 41;
    moCache[43] = 43;
    moCache[47] = 47;
    moCache[53] = 53;
    moCache[59] = 59;
    moCache[61] = 61;
    moCache[67] = 67;
    moCache[71] = 71;
    moCache[73] = 73;
    moCache[79] = 79;
    moCache[83] = 83;
    moCache[89] = 89;
    moCache[97] = 97;
    moCache[101] = 101;
    moCache[103] = 103;
    moCache[107] = 107;
    moCache[109] = 109;
    moCache[113] = 113;
    moCache[127] = 127;
    moCache[131] = 131;
    moCache[137] = 137;
    moCache[139] = 139;
    moCache[149] = 149;
    moCache[151] = 151;
    moCache[157] = 157;
    moCache[163] = 163;
    moCache[167] = 167;
    moCache[173] = 173;
    moCache[179] = 179;
    moCache[181] = 181;
    moCache[191] = 191;
    moCache[193] = 193;
    moCache[197] = 197;
    moCache[199] = 199;
    moCache[211] = 211;
    moCache[223] = 223;
    moCache[227] = 227;
    moCache[229] = 229;
    moCache[233] = 233;
    moCache[239] = 239;
    moCache[241] = 241;
    moCache[251] = 251;
    moCache[257] = 257;
    moCache[263] = 263;
    moCache[269] = 269;
    moCache[271] = 271;
    moCache[277] = 277;
    moCache[281] = 281;
    moCache[283] = 283;
    moCache[293] = 293;
    moCache[307] = 307;
    moCache[311] = 311;
    moCache[313] = 313;
    moCache[317] = 317;
    moCache[331] = 331;
    moCache[337] = 337;
    moCache[347] = 347;
    moCache[349] = 349;
    moCache[353] = 353;
    moCache[359] = 359;
    moCache[367] = 367;
    moCache[373] = 373;
    moCache[379] = 379;
    moCache[383] = 383;
    moCache[389] = 389;
    moCache[397] = 397;
    moCache[401] = 401;
    moCache[409] = 409;
    moCache[419] = 419;
    moCache[421] = 421;
    moCache[431] = 431;
    moCache[433] = 433;
    moCache[439] = 439;
    moCache[443] = 443;
    moCache[449] = 449;
    moCache[457] = 457;
    moCache[461] = 461;
    moCache[463] = 463;
    moCache[467] = 467;
    moCache[479] = 479;
    moCache[487] = 487;
    moCache[491] = 491;
    moCache[499] = 499;
    moCache[503] = 503;
    moCache[509] = 509;
    moCache[521] = 521;
    moCache[523] = 523;
    moCache[541] = 541;
    moCache[547] = 547;
    moCache[557] = 557;
    moCache[563] = 563;
    moCache[569] = 569;
    moCache[571] = 571;
    moCache[577] = 577;
    moCache[587] = 587;
    moCache[593] = 593;
    moCache[599] = 599;
    moCache[601] = 601;
    moCache[607] = 607;
    moCache[613] = 613;
    moCache[617] = 617;
    moCache[619] = 619;
    moCache[631] = 631;
    moCache[641] = 641;
    moCache[643] = 643;
    moCache[647] = 647;
    moCache[653] = 653;
    moCache[659] = 659;
    moCache[661] = 661;
    moCache[673] = 673;
    moCache[677] = 677;
    moCache[683] = 683;
    moCache[691] = 691;
    moCache[701] = 701;
    moCache[709] = 709;
    moCache[719] = 719;
    moCache[727] = 727;
    moCache[733] = 733;
    moCache[739] = 739;
    moCache[743] = 743;
    moCache[751] = 751;
    moCache[757] = 757;
    moCache[761] = 761;
    moCache[769] = 769;
    moCache[773] = 773;
    moCache[787] = 787;
    moCache[797] = 797;
    moCache[809] = 809;
    moCache[811] = 811;
    moCache[821] = 821;
    moCache[823] = 823;
    moCache[827] = 827;
    moCache[829] = 829;
    moCache[839] = 839;
    moCache[853] = 853;
    moCache[857] = 857;
    moCache[859] = 859;
    moCache[863] = 863;
    moCache[877] = 877;
    moCache[881] = 881;
    moCache[883] = 883;
    moCache[887] = 887;
    moCache[907] = 907;
    moCache[911] = 911;
    moCache[919] = 919;
    moCache[929] = 929;
    moCache[937] = 937;
    moCache[941] = 941;
    moCache[947] = 947;
    moCache[953] = 953;
    moCache[967] = 967;
    moCache[971] = 971;
    moCache[977] = 977;
    moCache[983] = 983;
    moCache[991] = 991;
    moCache[997] = 997;	
}

/**
 * @param {number} n
 * @return {number}
 */
var minSteps = function(n) {
	if (moCache[n] !== -1){
		return moCache[n];	
	}//fi
    let minS = 1001;
    let currS;    
    for (let i=2; i<n/2; i++){
		if (n%i === 0){
			currS = minSteps(i) + n/i;
			minS = Math.min(currS, minS);
		}//fi
	}//rof
	moCache[n] = minS;
	return minS;
};

var testFunc = function() {
	let n;

	n=4;
	
	console.log("ans: " + minSteps(n));
};



testFunc();
