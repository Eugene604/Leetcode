/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var findLeastNumOfUniqueInts = function(arr, k) {
  //step 1, build count map
  let cntMap = new Map();
  let cnt;
  for (let i=0; i<arr.length; i++) {
    cnt = (cntMap.get(arr[i]) || 0) + 1;  
    cntMap.set(arr[i], cnt);    
  }//rof

  //step 2, convert count map to array and sort it
  let cntArr = Array.from(cntMap.entries());
  cntArr.sort((a,b)=>(a[1]-b[1]));
  console.log(JSON.stringify(cntArr));

  //step 3, determine how many elements can be removed
  let removableInx;
  let kLeft = k;
  for (removableInx=0; removableInx<cntArr.length && cntArr[removableInx][1]<=kLeft; removableInx++){
      kLeft -= cntArr[removableInx][1];
  }//rof
  
  return cntArr.length - removableInx;    
};