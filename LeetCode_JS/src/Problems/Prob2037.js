/**
 * @param {number[]} seats
 * @param {number[]} students
 * @return {number}
 */
var minMovesToSeat = function(seats, students) {
	seats.sort((a,b)=>a-b);
	students.sort((a,b)=>a-b);
	//console.log(seats);
	//console.log(students);
	let numOfMoves = 0;
	for (let i=0; i<seats.length; i++){
		numOfMoves += Math.abs(seats[i] - students[i]);
	}//rof
    return numOfMoves;
};

var testFunc = function() {
	let seats, students;
	
	seats = [3,1,5];
	students = [2,7,4];
	
	console.log("ans: " + minMovesToSeat(seats, students));
};



testFunc();
