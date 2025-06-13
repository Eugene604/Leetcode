/**
 * @param {number[][]} books
 * @param {number} shelfWidth
 * @return {number}
 */
var minHeightShelves = function(books, shelfWidth) {
	let minHeightCache = new Array(books.length+1); //min height when ith book is the leading book 
	minHeightCache[books.length-1] = books[books.length-1][1];
	minHeightCache[books.length] = 0;
	
	/**
	 * Recursively arrange books on the shelf and calculate the minimum height.
	 * 
	 *
	 * This function tries to place books in layers, ensuring the total width of books in a layer does not exceed
	 * the shelfWidth. It considers several cases to minimize the height:
	 * - Case 1: If the current book's height is less than or equal to the current layer's height, add the book to the current layer.
	 * - Case 2: If the current book's height is greater than the current layer's height, the function explores two options:
	 *   - Case 2-1: Start a new layer and calculate the height recursively.
	 *   - Case 2-2: Increase the current layer's height to accommodate the new book and continue adding books.
	 * - Case 3: If the end of the books array is reached, the height of the current layer is considered the possible total height.
	 * - Case 4: If the width limit is exceeded, the function calculates the height with a new layer starting from the current book.
	 *
	 * precondition:
	 * - data structures and variables are available and valid:
	 * 	- books array
	 *  - sehlfWidth
	 *  - minHeightCache
	 * @param {number} bookID - The index of the book to start arranging from (acting as the leading book).
	 * @return {number} - The minimum total height of the shelves starting with the given bookID as the leading book.
	 */
	let getMinHeight = function(bookID) {
		
		//base case 1: there's already calculated value stored in cache
		if (minHeightCache[bookID]){		
			return minHeightCache[bookID];
		};
		
		let originalBookID = bookID;
		let currLayerWidth, currLayerHeight;
		let totalLayerHeight = Number.MAX_VALUE;
		
		//remember, each function call means a new layer
		currLayerWidth = books[bookID][0];
		currLayerHeight = books[bookID][1];
		bookID++;			 
		
		//try to add books until width is used up OR all books have been arranged	
		while (bookID < books.length && currLayerWidth +  books[bookID][0] <= shelfWidth) {
			if (books[bookID][1] <= currLayerHeight) { //case 1: book height is lower than current layer height
				currLayerWidth += books[bookID][0];				
			} else {  //case 2: book height is higher
				//case 2-1: try create new layer and see how it goes
				totalLayerHeight = Math.min(totalLayerHeight, currLayerHeight + getMinHeight(bookID));
				
				//case 2-2: try increase current shelf's height
				currLayerHeight = books[bookID][1];
				currLayerWidth += books[bookID][0];				
			}//fi
			bookID++;
		}//end while
		
		
		//case 3: end of books arrived, current layer height is one of the possible total layer height starting with original book ID
		if (bookID === books.length) {
			minHeightCache[originalBookID] = Math.min(totalLayerHeight, currLayerHeight);
			return minHeightCache[originalBookID];
		}//fi
		
		//case 4: width has been used up
		if (currLayerWidth +  books[bookID][0] > shelfWidth) {
			minHeightCache[originalBookID] = Math.min(totalLayerHeight, currLayerHeight + getMinHeight(bookID));
		}//fi
		
		return minHeightCache[originalBookID];
		
	};//end function
	
	let minHeight = getMinHeight(0);
	
	 
    return minHeight;
};

let books, shelfWidth;

books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4;


console.log('ans: ' + minHeightShelves(books, shelfWidth));

/*
s = "aababbab";

//*/

