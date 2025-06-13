/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    people.sort((a, b) => a - b);
    //console.log(people);
    let boatCnt = 0;
    let leftPtr = 0, rightPtr = people.length-1;
    while (leftPtr<=rightPtr){
        boatCnt++;
        if (leftPtr === rightPtr) {
            break;
        } else if (limit >= people[leftPtr]+people[rightPtr]){
            leftPtr++;
            rightPtr--;
        } else {
            rightPtr--;
        }//fi

    }//end while
    return boatCnt;
};

let people;
let limit;


people = [11,2,2,8,8];
limit = 11;
console.log('original arr: ' + JSON.stringify(people));
console.log('ans: ' + numRescueBoats(people, limit));


/*
people = [3,5,3,4];
limit = 5;
console.log('original arr: ' + JSON.stringify(people));
console.log('ans: ' + numRescueBoats(people, limit));
//*/