#include <iostream>
#include "ProbTestList.h"
#include "../DataStructs/TreeNode.h"
using namespace std;



class Solution938 {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
    	//sepcial case, root is null
    	if (root == NULL){
    		return 0;
    	}//fi

    	bool isIncluded = true;
    	int sum = 0;
    	if (root->val >= low){
    		sum += rangeSumBST(root->left, low, high);
    	} else {
    		isIncluded = false;
    	}//fi

    	if (root->val <= high){
    		sum += rangeSumBST(root->right, low, high);
    	} else {
    		isIncluded = false;
    	}//fi

    	if (isIncluded){
    		sum += root->val;
    	}//fi
    	return sum;
    }//end method

};


void prob938Test(){
	//build test tree
	TreeNode* n3 = new TreeNode(3);
	TreeNode* n7 = new TreeNode(7);
	TreeNode* n5 = new TreeNode(5, n3, n7);
	TreeNode* n18 = new TreeNode(18);
	TreeNode* n15 = new TreeNode(15, NULL, n18);
	TreeNode* n10 = new TreeNode(10, n5, n15);

	Solution938 sol;
	TreeNode* root;
	int low, high;

	root = n10;
	low = 7;
	high = 15;
	cout << "prob 938 ans: " << sol.rangeSumBST(root, low, high);

}//end method //*/


