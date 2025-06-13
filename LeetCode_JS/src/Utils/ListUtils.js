const ListNode = require('../DataStructs/ListNode.js');

/**
 * Constructs a linked list from a numeric array.
 * @param {number[]} arr - The numeric array to build the linked list from.
 * @returns {ListNode|null} - The head of the constructed linked list, or null if the array is empty or undefined.
 */
function buildList(arr) {
    if (!arr || arr.length === 0) {
        return null; // Return null if array is empty or undefined
    }

    let head = new ListNode(arr[0]); // Create the head node
    let current = head;

    // Iterate through the array starting from index 1
    for (let i = 1; i < arr.length; i++) {
        let newNode = new ListNode(arr[i]); // Create a new node
        current.next = newNode; // Connect the current node to the new node
        current = newNode; // Update the current node
    }//rof
    return head; // Return the head of the linked list
}//end method

/**
 * Serialize the content of a linked list to string
 * @param {ListNode} head - The head of the linked list.
 * @returns {String} - Content of list in string
 */
function listToString(head) {
    let str = "{ ";
    let current = head;
    while (current !== null) {
        str += current.val;
        if (current.next !== null) {
            str += ", ";
        }
        current = current.next;
    }//end while
    str += " }";
    return str;
}//end method

/**
 * Displays the content of a linked list node in a specified format.
 * @param {ListNode} head - The head of the linked list.
 * @returns {void} - This function does not return anything; it logs the content of the linked list.
 */
function displayList(head) {    
    console.log(listToString(head));
}//end method

module.exports = {
	buildList,
	listToString,
	displayList
};