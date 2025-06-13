/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    let leftSum = 1, rightSum = n;
    let leftPtr = 1, rightPtr = n;
    while (rightPtr >= leftPtr) {
        //console.log('left:' + leftPtr + ' right:' + rightPtr + ' leftSum: ' + leftSum + ' rightSum:'+ rightSum);
        if (leftSum > rightSum) {
            rightPtr--;
            rightSum += rightPtr;
        } else if (leftSum < rightSum) {
            leftPtr++;
            leftSum += leftPtr;
        } else if (leftPtr === rightPtr) {
            return leftPtr; 
        } else {
            leftPtr++;
            leftSum += leftPtr;
            rightPtr--;
            rightSum += rightPtr;
        }//fi
    }//end while
  return -1;  
};