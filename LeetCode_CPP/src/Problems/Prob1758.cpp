#include <iostream>
#include "ProbTestList.h"
#include "../DataStructs/TreeNode.h"
#include "../Utils/ArrayUtils.h"
using namespace std;

class Solution1758 {
public:
	int minOperations(string s) {
		int numOfOp, prevNumOfOp;
		char correctChar;

		//try 1: correct initial character is 0
		correctChar = '0';
		numOfOp = 0;
		for (unsigned int i = 0; i < s.length(); i++) {
			if (s[i] != correctChar) {
				numOfOp++;
			} //fi
			correctChar ^= 0x1;
		} //rof
		prevNumOfOp = numOfOp;

		//try 1: correct initial character is 1
		correctChar = '1';
		numOfOp = 0;
		for (unsigned int i = 0; i < s.length(); i++) {
			if (s[i] != correctChar) {
				numOfOp++;
			} //fi
			correctChar ^= 0x1;
		} //rof

		return (numOfOp<prevNumOfOp)?numOfOp:prevNumOfOp;
	} //end method
};

void prob1758Test() {
	Solution1758 sol;
	string str1 = "011101";
	string str2 = "00111";
	string str3 = "00";
	string str;

	str = str1;
	cout << "prob 1758: " << sol.minOperations(str) << endl;

} //end method //*/

