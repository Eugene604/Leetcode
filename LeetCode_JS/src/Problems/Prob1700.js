/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let sInx = 0;
    let maxGiveupCnt = students.length;
    let currTopS;
    do {
        //console.log(students + ' maxGiveupCnt: ' + maxGiveupCnt);
        currTopS = students[0];
        students.splice(0, 1);
        if (currTopS === sandwiches[0]) {
            sandwiches.splice(0, 1);
            maxGiveupCnt = students.length;
        } else { 
            students.push(currTopS);
            maxGiveupCnt--;
        }//fi
    } while (students.length > 0 
    && maxGiveupCnt > 0);
    

    return students.length;
};