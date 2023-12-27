/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {

	let coord = "0:0";
	let xCoord=0, yCoord=0;
	const xUnit = 1;
	const yUnit = 1;

	const visitedCoord = {};
	visitedCoord[coord]=1;
	

	for (const m of path) {
		switch (m) {
			case 'N':
				yCoord = yCoord + yUnit;
				break;
			case 'S':
				yCoord = yCoord - yUnit;
				break;
			case 'W':
				xCoord = xCoord - xUnit;
				break;
			case 'E':
				xCoord = xCoord + xUnit;
				break;
		}//end switch
		coord = `${xCoord}:${yCoord}`;
		if (visitedCoord[coord]){
			return true;
		}//fi
		visitedCoord[coord]=1;
	}//rof

	return false;
};


var str1 = "NES";
var str2 = "NESWW";
var str3 = "luffy is still joyboy";
var path;
path = str1;
console.log("ans: " + isPathCrossing(path));
path = str2;
console.log("ans: " + isPathCrossing(path));


/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing_v2 = function(path) {

	let coord = (16384 << 15) + 16384;
	const xUnit = 1;
	const yUnit = 16384;

	const visitedCoord = new Set();
	visitedCoord.add(coord);

	for (const m of path) {
		switch (m) {
			case 'N':
				coord = coord + yUnit;
				break;
			case 'S':
				coord = coord - yUnit;
				break;
			case 'W':
				coord = coord - xUnit;
				break;
			case 'E':
				coord = coord + xUnit;
				break;
		}//end switch
		if (visitedCoord.has(coord)){
			return true;
		}//fi
		visitedCoord.add(coord);
	}//rof

	return false;
};
