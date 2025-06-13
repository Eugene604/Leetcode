/**
 * @param {string[]} logs
 * @return {number}
 */
var minOperations = function(logs) {
	let level = 0;
	for (let i=0; i<logs.length; i++){
		if (logs[i] === "./") {
			//do nothing
		} else if (logs[i] === "../") {
			if (level > 0) {
				level--;	
			}//fi			
		} else {
			level++;
		}//fi
	}//rof
	return level;    
};

var testFunc = function() {
	let logs;
	
	/*
	logs = ["d1/","d2/","../","d21/","./"];
	console.log("ans: " + minOperations(logs));
	//*/
	
	logs = ["d1/", "d2/", "d3/", "../", "../", "../", "../"];
	console.log("ans: " + minOperations(logs));
};



testFunc();
