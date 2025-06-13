/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    let ver1NumInx = 0;
    let ver2NumInx = 0;
    let ver1DotInx, ver2DotInx;
    let ver1Num, ver2Num;
    let ver1Score = 0;
    let ver2Score = 0;

    while (ver1Score === ver2Score && (ver1NumInx < version1.length || ver2NumInx < version2.length)) {

        if (ver1NumInx < version1.length){
            if ((ver1DotInx = version1.indexOf('.', ver1NumInx)) === -1){ 
                ver1DotInx = version1.length;
            }//fi
            ver1Num = parseInt(version1.substring(ver1NumInx, ver1DotInx));
            ver1Score += ver1Num;
            ver1NumInx = ver1DotInx+1;
        }//fi
        
        if (ver2NumInx < version2.length){
            if ((ver2DotInx = version2.indexOf('.', ver2NumInx)) === -1){ 
                ver2DotInx = version2.length;
            }//fi
            ver2Num = parseInt(version2.substring(ver2NumInx, ver2DotInx));
            ver2Score += ver2Num;
            ver2NumInx = ver2DotInx+1;
        }//fi

        
        console.log('ver1Num: ' + ver1Num + ' ver2Num: ' + ver2Num);
        //console.log('ver1DotInx: ' + ver1DotInx + ' ver2DotInx: ' + ver2DotInx);
    }//end while

    if (ver1Score < ver2Score) {
        return -1;
    } else if (ver1Score > ver2Score) {
        return 1;
    } else {
        return 0;
    }//fi

      
};

let version1;
let version2;

version1 = "1.01";
version2 = "1.001";
console.log('ans: ' + compareVersion(version1, version2));

