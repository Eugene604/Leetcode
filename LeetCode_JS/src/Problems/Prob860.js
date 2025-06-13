/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let numOf5 = 0;
    let numOf10 = 0;
    for (let i=0; i<bills.length; i++){
        if (bills[i] === 5){
            numOf5++;
        } else if (bills[i] === 10){
            if (numOf5 > 0){
                numOf5--;
                numOf10++;
            } else {
                return false;
            }//fi
        } else if (bills[i] === 20) {
            if (numOf10 >0 && numOf5> 0){
                numOf5--;
                numOf10--;
            } else if (numOf5 > 2){
                numOf5 -= 3;
            } else {
                return false;
            }//fi
        }///fi

    }//rof
    return true;
};

let bills;

bills = [5,5,5,10,20];

console.count('ans: ' + lemonadeChange(bills));
