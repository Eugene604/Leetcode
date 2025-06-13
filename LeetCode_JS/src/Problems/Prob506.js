/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let ansArr = new Array(score.length);
    let sortingArr = new Array();
    for (let i=0; i<score.length; i++){
        sortingArr.push([score[i], i]);
    }//rof
    sortingArr.sort((a,b) => {return b[0] - a[0];});
    ansArr[sortingArr[0][1]] = "Gold Medal";
    if (score.length>1){
        ansArr[sortingArr[1][1]] = "Silver Medal";
    }//fi
    if (score.length>2){
        ansArr[sortingArr[2][1]] = "Bronze Medal";
    }//fi
    
    //console.log(JSON.stringify(sortingArr));
    for (let i=3; i<score.length; i++){
        ansArr[sortingArr[i][1]] = (i+1).toString();
    }//rof
    return ansArr;
};

let score;
score = [10,3,8,9,4];

console.count('ans: ' + JSON.stringify(findRelativeRanks(score)));
