var sqrNumArr;
{
    sqrNumArr = new Array();
    for (let i=0; i<=46340; i++){
        sqrNumArr.push(i*i);
    }//rof        
    //console.log(sqrNumArr);
}

/**
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    let bSearch = function(arr, num, leftInx=0, rightInx=arr.length-1){
        let currInx;
        while (leftInx <= rightInx) {
            currInx = Math.floor((leftInx + rightInx)/2);
            if (arr[currInx] === num) {
                return currInx;
            } else if (arr[currInx] > num) {
                rightInx = currInx-1;
            } else {
                leftInx = currInx+1;
            }//fi
        }//end while
        return -1;
    };//end method
    //console.log(bSearch(sqrNumArr,4, 1));

    let xVal, yVal;
    for (let xInx = 0; xInx < sqrNumArr.length - 1; xInx++) {
        xVal = sqrNumArr[xInx];
        yVal = c - xVal;  
        if (yVal < xVal) {
            return false;        
        } else if (bSearch(sqrNumArr,yVal, xInx) !== -1) {
            return true;
        }//fi
    }//rof
    return false;
};

let c;
c=5;

console.count('ans: ' + judgeSquareSum(c));
