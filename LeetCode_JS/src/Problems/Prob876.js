
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
   let slowPtr = head;
   let fastPtr = head;
   while (fastPtr.next !== null) {
     fastPtr = fastPtr.next;
     slowPtr = slowPtr.next;
     if (fastPtr.next !== null) {
       fastPtr = fastPtr.next;
     } else {
       break;
     }//fi
   }//end while
   return slowPtr;
};	