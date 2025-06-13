/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */
var maxProfitAssignment = function(difficulty, profit, worker) {
    
    worker.sort((a,b)=>b-a);
    //console.log('worker:' + JSON.stringify(worker));
    //console.log('worker:' + JSON.stringify(difficulty));
    let maxDoableDifficulty = worker[0];

    //max profit task array, index = difficulty, value = profit
    let maxPTaskArr = new Array(maxDoableDifficulty+1);

    for (let i=0; i<profit.length; i++){
        if (difficulty[i] > maxDoableDifficulty) {
            continue;
        } else if (!(profit[i] < maxPTaskArr[difficulty[i]])) {
            maxPTaskArr[difficulty[i]] = profit[i];
        }//fi
    }//rof

    //console.log(JSON.stringify(maxPTaskArr));
    OUTER_LOOP:
    for (let i=0; i<maxDoableDifficulty; i++){
        if (!maxPTaskArr[i]){
            maxPTaskArr[i]=0;
            continue;
        }//fi
        for (let j=i+1; j<=maxDoableDifficulty; j++){
            if (!(maxPTaskArr[i] <= maxPTaskArr[j])) {
                maxPTaskArr[j] = maxPTaskArr[i];
            } else {
                continue OUTER_LOOP;
            }//fi
        }//rof
    }//rof
    
    maxPTaskArr[maxDoableDifficulty] = (maxPTaskArr[maxDoableDifficulty])? maxPTaskArr[maxDoableDifficulty] : 0;

    //console.log(JSON.stringify(maxPTaskArr));
    let totalProfit = 0;

    for (let i=0; i<worker.length; i++){
        totalProfit += maxPTaskArr[worker[i]];
    }//rof

    return totalProfit;
};


let difficulty, worker, profit;
/*
difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7];
console.count('ans: ' + maxProfitAssignment(difficulty, profit, worker));



difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25];
console.count('ans: ' + maxProfitAssignment(difficulty, profit, worker));

//*/


difficulty = [64448,79457,42016,11665,2469,91969,46731,54320,5882,93835,21708,50277,16955,45755,72327,12268,15839,18850,10936,86865,31179,70806,862,89380,85395,37685,35989,22400,65446,89518,87777,70913,94050,19520,32338,6472,5200,80772,51039,17062,50872,15560,72431,78446,60361,6777,31654,21757,14900,97226];

profit = [55170,24810,99019,14644,60739,86776,3656,85057,88453,42411,63691,60967,64863,28688,57126,98045,43420,1719,81693,43774,89525,86382,83018,5553,3184,1542,40108,39794,79829,30024,96082,41089,60930,38049,63082,94078,7062,33691,18438,35911,30367,21478,97103,32558,53184,24942,53365,48591,38949,88794]; 

worker = [1934,65871,592,76268,61862,74422,53430,95603,70312,43409,30258,54173,99791,21407,42909,96179,64854,77416,24428,68409,21827,4982,72940,99041,52118,94881,31780,84764,7679,56624,41536,87404,39901,61306,81696,61301,46775,19110,95183,84615,2265,56050,69873,14041,41356,18511,15227,5037,23642,36803];
console.count('ans: ' + maxProfitAssignment(difficulty, profit, worker));
