/**
 * @param {number[]} positions
 * @param {number[]} healths
 * @param {string} directions
 * @return {number[]}
 */
var survivedRobotsHealths = function(positions, healths, directions) {
	let sortedInxArr = [...Array(positions.length).keys()];
	//console.log("sortedInxArr: " + JSON.stringify(sortedInxArr));
	sortedInxArr.sort((a,b)=>positions[a]-positions[b]);
	//console.log("sortedInxArr: " + JSON.stringify(sortedInxArr));
	
	let inxStkArr = new Array(positions.length);
	let stkInx = -1;
	let inxArrInx = 0;
	while (inxArrInx<sortedInxArr.length){
		if (stkInx === -1){
			if (directions[sortedInxArr[inxArrInx]] !== "L") {
				stkInx++;
				inxStkArr[stkInx] = sortedInxArr[inxArrInx];				
			}//fi
			inxArrInx++;
		} else if (directions[sortedInxArr[inxArrInx]] === directions[inxStkArr[stkInx]]) {
			stkInx++;
			inxStkArr[stkInx] = sortedInxArr[inxArrInx];
			inxArrInx++;
		} else if (healths[sortedInxArr[inxArrInx]] > healths[inxStkArr[stkInx]]) {//collide and new element has higher health
			healths[inxStkArr[stkInx]] = 0;
			healths[sortedInxArr[inxArrInx]]--;
			stkInx--;			
		} else if (healths[sortedInxArr[inxArrInx]] < healths[inxStkArr[stkInx]]) {//collide and top stk element has higher health
			healths[sortedInxArr[inxArrInx]] = 0;
			healths[inxStkArr[stkInx]]--;
			inxArrInx++;
		} else if (healths[sortedInxArr[inxArrInx]] === healths[inxStkArr[stkInx]]) {//collide and equal health, delete both
			healths[sortedInxArr[inxArrInx]] = 0;
			healths[inxStkArr[stkInx]] = 0;
			stkInx--;
			inxArrInx++;
		}//fi
		//console.log("inxStk:" + JSON.stringify(inxStkArr));
		//console.log("health:" + JSON.stringify(healths));
	}//rof
	
	let healthArr = [];
	for (let i=0; i<healths.length; i++){
		if (healths[i] > 0) {
			healthArr.push(healths[i]);	
		}//fi
		
	}//rof
	return healthArr;  
};


let positions, healths, directions;

/*
positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL";
console.log("ans: " + survivedRobotsHealths(positions, healths, directions));
//*/

positions = [1, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000], healths = [10, 15, 20, 25, 30, 35, 40, 45, 50, 55], directions = "RLRLRLRLRL";
console.log("ans: " + survivedRobotsHealths(positions, healths, directions));
process.exit();


/**
 * @param {number[]} positions
 * @param {number[]} healths
 * @param {string} directions
 * @return {number[]}
 */
var survivedRobotsHealths_v2 = function(positions, healths, directions) {
	let sortedInxArr = [...Array(positions.length).keys()];
	//console.log("sortedInxArr: " + JSON.stringify(sortedInxArr));
	sortedInxArr.sort((a,b)=>positions[a]-positions[b]);
	//console.log("sortedInxArr: " + JSON.stringify(sortedInxArr));
	
	let inxStk = new Array();
	for (let i=0; i<sortedInxArr.length; i++){
		if (inxStk.length === 0){
			if (directions[sortedInxArr[i]] !== "L") {
				inxStk.unshift(sortedInxArr[i]);
			}
		} else if (directions[sortedInxArr[i]] === directions[inxStk[0]]) {
			inxStk.unshift(sortedInxArr[i]);
		} else if (healths[sortedInxArr[i]] > healths[inxStk[0]]) {//collide and new element has higher health
			healths[inxStk[0]] = 0;
			healths[sortedInxArr[i]]--;
			inxStk.shift();
			i--;//check again
		} else if (healths[sortedInxArr[i]] < healths[inxStk[0]]) {//collide and top stk element has higher health
			healths[sortedInxArr[i]] = 0;
			healths[inxStk[0]]--;
		} else if (healths[sortedInxArr[i]] === healths[inxStk[0]]) {//collide and equal health, delete both
			healths[sortedInxArr[i]] = 0;
			healths[inxStk[0]] = 0;
			inxStk.shift();
		}//fi
		//console.log("inxStk:" + JSON.stringify(inxStk));
		//console.log("health:" + JSON.stringify(healths));
	}//rof
	
	let healthArr = [];
	for (let i=0; i<healths.length; i++){
		if (healths[i] > 0) {
			healthArr.push(healths[i]);	
		}//fi
		
	}//rof
	return healthArr;  
};
