/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let unclosedLeftPCnt = 0;
    let asteriskCnt = 0;
    for (let i=0; i<s.length; i++) {
        if (s[i] === "*") {
            asteriskCnt++;
        } else if (s[i] === "(") {
            unclosedLeftPCnt++;
        } else if (s[i] === ")") {
            unclosedLeftPCnt--;
        }//fi
        if (unclosedLeftPCnt === -1){
            if (asteriskCnt < 1) {
                return false;
            } else {
                asteriskCnt--;
                unclosedLeftPCnt = 0;
            }//fi
        }//fi
    }//rof
    //console.log(unclosedLeftPCnt);
    //console.log(asteriskCnt);
    if (unclosedLeftPCnt === 0) {
        return true;
    }//fi
    
    unclosedLeftPCnt = 0;
    asteriskCnt = 0;
    for (let i=s.length-1; i>=0; i--) {
        if (s[i] === "*") {
            asteriskCnt++;
        } else if (s[i] === "(") {
            unclosedLeftPCnt++;
        } else if (s[i] === ")") {
            unclosedLeftPCnt--;
        }//fi
        if (unclosedLeftPCnt === +1){
            if (asteriskCnt < 1) {
                return false;
            } else {
                asteriskCnt--;
                unclosedLeftPCnt = 0;
            }//fi
        }//fi
    }//rof
    return true;  
};