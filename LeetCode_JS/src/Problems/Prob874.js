const NORTH_DIR = 3;
const EAST_DIR = 2;
const SOUTH_DIR = 1;
const WEST_DIR = 0;

/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {

	let rowObstacleMap = new Map;
	let colObstacleMap = new Map;
	
	/**
	 * Determines the stopping index for the robot when moving in a given direction.
	 * 
	 * Precondition:
	 * - rowObstacleMap and colObstacleMap are present and valid
	 * 
	 * Postcondition:
	 * updated coordinates are stored back into coordArr.
	 * 
	 * The function calculates how many steps the robot can move along a given axis before encountering an obstacle.
	 * 
	 * @param {number[]} coordArr - The current [x, y] coordinates of the robot.
	 * @param {number} steps - The number of steps the robot intends to move.
	 * @param {number} dir - The direction in which the robot is moving, represented as an integer (0-3).
	 * - NORTH_DIR (3): Moving upwards along the y-axis.
	 * - SOUTH_DIR (1): Moving downwards along the y-axis.
	 * - WEST_DIR (0): Moving left along the x-axis.
	 * - EAST_DIR (2): Moving right along the x-axis.
	 */
	let getStopInx=function(coordArr,steps,dir){
		
		let obstacleSet;
		let movingCoordInx;
		let sign = 1;
		switch (dir) {
        case NORTH_DIR:
            obstacleSet =  colObstacleMap.get(coordArr[0]);
            movingCoordInx = 1;
            break;
        case SOUTH_DIR:
			obstacleSet =  colObstacleMap.get(coordArr[0]);
            movingCoordInx = 1;
            sign *= -1;
            break;
        case WEST_DIR:
            obstacleSet =  rowObstacleMap.get(coordArr[1]);
            movingCoordInx = 0;			
            sign *= -1;
            break;
        case EAST_DIR:
           	obstacleSet =  rowObstacleMap.get(coordArr[1]);
            movingCoordInx = 0;
            break;
        default:
            // Handle unexpected direction
            break;
        }//end switch
		
		if (obstacleSet === undefined){
			coordArr[movingCoordInx] += sign*steps;
			return;
		}//fi
		
		for (;steps>0; steps--){
			coordArr[movingCoordInx] += sign;
			if (obstacleSet.has(coordArr[movingCoordInx])){
				coordArr[movingCoordInx] -= sign;
				return;
			}//fi
		}//rof
		return;
	};//end method

	//step 1, build obstacle maps
	for (let [x, y] of obstacles){
		let obstacleSet;
		if ((obstacleSet=rowObstacleMap.get(y))===undefined){
			obstacleSet = new Set();
			rowObstacleMap.set(y,obstacleSet);			
		}//fi
		obstacleSet.add(x);
			
		if ((obstacleSet=colObstacleMap.get(x))===undefined){
			obstacleSet = new Set();
			colObstacleMap.set(x,obstacleSet);			
		}//fi
		obstacleSet.add(y);
	}//rof
	//console.log('rowObstacleMap: ' + JSON.stringify(rowObstacleMap));
	
	//step 2, perform simulation
	let coordArr = [0,0];
	let currDir = NORTH_DIR;
	let currCommand;
	let maxEucDistSqrt = 0;
	while (commands.length > 0){
		currCommand = commands.shift();
		//console.log('command is: ' + JSON.stringify(commands));
		switch (currCommand) {
        case -1://turn right 90 degrees
           if (currDir === WEST_DIR){
				currDir = NORTH_DIR;
			} else {
				currDir += -1;
			}//fi
            break;
        case -2://turn left 90 degrees
			if (currDir === NORTH_DIR){
				currDir = WEST_DIR;
			} else {
				currDir += 1;
			}//fi
            break;        
        default:
            getStopInx(coordArr,currCommand,currDir);
            maxEucDistSqrt = Math.max(maxEucDistSqrt, coordArr[0]*coordArr[0] + coordArr[1]*coordArr[1]);
            //console.log('coordArr: ' + JSON.stringify(coordArr));
            break;
        }//end switch
        				
	}//end while
	
    return maxEucDistSqrt;
};
 
let commands, obstacles;

commands = [6,-1,-1,6], obstacles = [];
console.log("ans: " + robotSim(commands, obstacles));

/*
commands = [4,-1,3], obstacles = [];
console.log("ans: " + robotSim(commands, obstacles));

//*/

