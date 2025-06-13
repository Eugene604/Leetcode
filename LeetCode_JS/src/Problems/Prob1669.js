/**
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function(list1, a, b, list2) {
    
    let preAPtr, postBPtr;
    let currNodePtr = list1;
    for (let currNodeInx = 0; currNodeInx <= b+1; currNodeInx++) {
        if (currNodeInx === a-1) {
            preAPtr = currNodePtr;
        } else if (currNodeInx === b+1) {
            postBPtr = currNodePtr;
        }//fi
        currNodePtr = currNodePtr.next;
    }//rof
    preAPtr.next = list2;
    let list2TailPtr = list2;
    while (list2TailPtr.next != null) {
        list2TailPtr = list2TailPtr.next;
    }//end while
    list2TailPtr.next = postBPtr;
    return list1;
};