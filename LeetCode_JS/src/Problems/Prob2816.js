function ListNode(val) {
     this.val = val;
     this.next = null;
 }/**

 * @param {ListNode} head
 * @return {ListNode}
 */
var doubleIt = function(head) {
    let numArr = new Array();
    let currNode;

    //step 1, use an array to store all node values
    for (currNode = head; currNode != null; currNode = currNode.next) {
        numArr.push(currNode.val);
    }//rof
    
    //step 2, double content of this array
    let carryOver = 0;
    let tmpResult;
    let remainder;

    for (let i=numArr.length-1; i>=0; i--){
        tmpResult = numArr[i]*2 + carryOver;
        remainder = tmpResult%10;
        carryOver = (tmpResult-remainder)/10;
        numArr[i] = remainder;
    }//rof
    
    //console.log(numArr);

    //step 3, write array content back to the list
    currNode = head;
    for (let i=0; i<numArr.length; i++, currNode = currNode.next){
        currNode.val = numArr[i];
    }//rof      

    //step 4, return the head if there was no carry over. Otherwaise, create a new head node
    if (carryOver === 0) {
        return head;
    } else {
        let newHead = new ListNode;
        newHead.val = carryOver;
        newHead.next = head;
        return newHead;
    }//fi
};

doubleIt(null);