function ListNode(val) {
     this.val = val;
     this.next = null;
 }

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeNodes = function(head) {
    let nodeStack = new Array();
    let currNode = head;
    let lastInxOfStack = -1;
    while (currNode != null) {        
        if (lastInxOfStack === -1) {
            nodeStack.push(currNode);
            lastInxOfStack++;
            currNode = currNode.next;
        } else if (nodeStack[lastInxOfStack].val >= currNode.val) {            
            stackArr[lastInxOfStack].next = currNode;
            nodeStack.push(currNode);
            lastInxOfStack++;
            currNode = currNode.next;
        } else {
            nodeStack.pop();
            lastInxOfStack--;
        } //fi
        return nodeStack[0];
    }//end while
    
};