/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var areAlmostEqual = function(s1, s2) {
    let numOfMismatches = 0;
    let prevS1MMChr, prevS2MMChr;
    for (let i=0; i<s1.length; i++){
        if (s1.charAt(i) === s2.charAt(i)) {

        } else if (numOfMismatches > 2){
            return false;
        } else if (numOfMismatches == 0){
            numOfMismatches++;
            prevS1MMChr = s1.charAt(i);
            prevS2MMChr = s2.charAt(i);
        } else { //numOfMismatches == 1;
            if (s1.charAt(i) !== prevS2MMChr || s2.charAt(i) !== prevS1MMChr) {
                return false;
            } else {
                numOfMismatches++;
            }
        }//fi

    }//rof
    return (numOfMismatches !== 1);    
};