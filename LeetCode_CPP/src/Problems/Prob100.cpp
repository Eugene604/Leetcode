#include <iostream>
#include "ProbTestList.h"
#include "../DataStructs/TreeNode.h"
using namespace std;



class Solution100 {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
    	if (p==NULL && q==NULL){
    		return true;
    	}//fi
    	if (p!=NULL && q==NULL){
    		return false;
    	}//fi
    	if (p==NULL && q!=NULL){
    		return false;
    	}//fi
    	if (p->val != q->val){
    		return false;
    	}//fi
    	if (!isSameTree(p->left, q->left)) {
    		return false;
    	}//fi
    	if (!isSameTree(p->right, q->right)) {
    		return false;
    	}//fi
    	return true;
    }//end method
};


void prob100Test(){
	Solution100 sol;
	cout << " ans: " << sol.isSameTree(NULL, NULL);

}//end method //*/


