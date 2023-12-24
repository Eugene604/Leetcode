#include <iostream>
#include "ProbTestList.h"
#include "../DataStructs/TreeNode.h"
#include "../Utils/ArrayUtils.h"
using namespace std;



class Solution1422 {
public:
    int maxScore(string s) {

    	//step 1, populate zero counts
    	int* zeroCntArr = new int[s.length()];
    	int currZeroCnt = 0;
    	for (unsigned int i=0; i<s.length(); i++){
    		if (s.at(i)=='0'){
    			currZeroCnt++;
    		}//fi
    		zeroCntArr[i]=currZeroCnt;
    	}//rof
    	//step 2, iterate in reverse order and determine score
    	int currScore = zeroCntArr[s.length()-2];
    	if (zeroCntArr[s.length()-2]==zeroCntArr[s.length()-1]){//there has been one at last position
    		currScore++;
    	}//fi
		int maxScore = currScore;
    	for (unsigned int i=s.length()-3; i<0xffffffff; i--){
    		if (zeroCntArr[i]==zeroCntArr[i+1]){//there has been one
    			currScore++;
    			if (currScore > maxScore){
    				maxScore = currScore;
    			}//fi
    		} else { //there has been zero
    			currScore--;
    		}//fi
    	}//rof
    	delete [] zeroCntArr;
        return maxScore;
    }//end method
};


void prob1422Test(){
	Solution1422 sol;
	string str1 = "011101";
	string str2 = "00111";
	string str3 = "00";
	string str;

	str = str1;
	cout << "ans: " << sol.maxScore(str) << endl;

	str = str3;
	cout << " ans: " << sol.maxScore(str) << endl;
}//end method //*/


