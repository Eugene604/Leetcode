/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {
    let charPriorityMap = new Array(123).fill(0, 97,123);
    for (let i=0; i<s.length; i++){
        charPriorityMap[order.charCodeAt(i)]=i+1;
    }//rof
    
    //console.log(charPriorityMap);
    let priortizedCharArr = Array.from({length:order.length+1}, () => new Array());
    
    for (let i=0; i<s.length; i++){
        priortizedCharArr[charPriorityMap[s.charCodeAt(i)]].push(s.charAt(i));
    }//rof
    
    //console.log(priortizedCharArr);
    
    let aggreStr = priortizedCharArr.flatMap(innerArr => innerArr).join('');
    
    

    return aggreStr;
};