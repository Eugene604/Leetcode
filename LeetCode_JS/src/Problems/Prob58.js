/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
	s = s.trim();
	var words = s.split(" ");
    return words[words.length-1].length;
};


var str1 = "Hello World";
var str2 = "   fly me   to   the moon  ";
var str3 = "luffy is still joyboy";
var testStr;
testStr = str1;
console.log("ans: " + lengthOfLastWord(testStr));
testStr = str2;
console.log("ans: " + lengthOfLastWord(testStr));
testStr = str3;
console.log("ans: " + lengthOfLastWord(testStr));
