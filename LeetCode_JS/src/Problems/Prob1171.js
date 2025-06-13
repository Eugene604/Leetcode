
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeZeroSumSublists = function(head) {
    let psumNodeMap = new Map();
    let dummyHead = new ListNode(0, head);
    dummyHead.pSum = 0;
    psumNodeMap.set(0, dummyHead);
    /**
     * remove intermediate nodes and return the parent node of startNode. If head of linked list is included in the removal, then the immediate child of end node is returned
     * preconditions:
     * - assume startNode, endNode all belong to same valid linked list
     * - assume dummyHead is available and valid
     * - assume prefix sum map is available and valid
     * @param {ListNode} startNode - the starting node that will be deleted
     * @param {ListNode} endNode - the end of deletion 
     * @return {ListNode} head node
     */
    let removeNodes = function(startNode, endNode) {
        //console.log('remove: ' + startNode.val + ':' + endNode.val);
        let preNode = dummyHead;
        let currNode = dummyHead.next;
        //get start node and its parent node
        while (currNode !== startNode) {
            preNode = currNode;
            currNode = currNode.next;
        }//end while
        //get end node
        while (currNode !== endNode) {
            //console.log('now removing: ' + currNode.val + ':' + currNode.pSum);
            psumNodeMap.delete(currNode.pSum);
            currNode = currNode.next;
        }//end while
        psumNodeMap.delete(currNode.pSum);
        preNode.next = currNode.next; //we use dummy head, no need to worry head being deleted
        return preNode;    
    };
    
    let prefixSum = 0;

    let currNode = head;
    let preStartNode, tmpPreNode;
    
    while (currNode !== null) {
        prefixSum += currNode.val;
                //console.log('gone through ' + currNode.val + ' pSum: ' + prefixSum + ' head: ' + head.val);
        if ((preStartNode = psumNodeMap.get(prefixSum)) !== undefined) {
            //displayLL(dummyHead);
            //console.log(psumNodeMap);
            tmpPreNode = removeNodes(preStartNode.next, currNode);
           //displayLL(dummyHead);
            if (tmpPreNode.pSum === undefined) {//head is deleted, endNode's child is new head
                head = tmpPreNode;
                currNode = tmpPreNode;
                prefixSum = 0;
            } else {//some section in the midddle is deleted
                prefixSum = tmpPreNode.pSum;
                currNode = tmpPreNode.next;
            }//fi
        } else {// prefix sum not repeating, meaning no sub sequence sums to 0
            currNode.pSum = prefixSum;
            psumNodeMap.set(prefixSum, currNode);
            currNode = currNode.next;
        }//fi
    }//end while */
    
    return dummyHead.next;
};
