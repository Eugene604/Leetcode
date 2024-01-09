#include <iostream>
#include "ProbTestList.h"
#include "../DataStructs/TreeNode.h"
using namespace std;

class Solution872 {
private:
	int leafArrMaxInx;
	int leafArr1[256];
	int leafArr2[256];
public:
	bool leafSimilar(TreeNode *root1, TreeNode *root2) {
		mapLeafToArray(root1, 1);
		mapLeafToArray(root2, 2);
		for (int i=0; i<leafArr1[0]; i++){
			if (leafArr1[i] != leafArr2[i]){
				return false;
			}//fi
		}//rof
		return true;
	} //end method

	/**
	 * precondition:
	 * leaf arrays are available and have size greater than 200
	 * @param root - TreeNode*, reference to the root of the tree
	 * @param leafArrID - which leaf array to store
	 */
	void mapLeafToArray(TreeNode* root, unsigned char leafArrID){
		int* arr;
		if (leafArrID == 1){
			arr = leafArr1;
		} else {
			arr = leafArr2;
		}//fi
		arr[0] = 1;
		traverseTree(root, arr);
	}//end method

	/**
	 * @param node - TreeNode*, reference to the current node of the tree
	 * @param arr - the array to store values to. arr[0] stores the next available index
	 */
	void traverseTree(TreeNode* node, int arr[]) {
		if (node == NULL){
			//do nothing;
		} else if (node->left == NULL && node->right == NULL) {
			arr[arr[0]] = node->val;
			arr[0]++;
		} else {
			traverseTree(node->left, arr);
			traverseTree(node->right, arr);
		}//fi
	}//end method

};

void prob872Test() {
	//build test tree
	TreeNode *n3 = new TreeNode(3);
	TreeNode *n7 = new TreeNode(7);
	TreeNode *n5 = new TreeNode(5, n3, n7);
	TreeNode *n18 = new TreeNode(18);
	TreeNode *n15 = new TreeNode(15, NULL, n18);
	TreeNode *n10 = new TreeNode(10, n5, n15);

	Solution872 sol;
	TreeNode *tree1, *tree2;;

	tree1 = n10;
	tree2 = n10;
	cout << "prob 872 ans: " << sol.leafSimilar(tree1, tree2);

} //end method //*/

