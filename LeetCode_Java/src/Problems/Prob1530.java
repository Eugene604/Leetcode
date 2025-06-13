package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob1530{
	
	

	
	public static void test() {
		Solution1530 sol = new Solution1530();
		
		Integer[] treeArr;
		int distance;
		TreeNode root;
		int ans;
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            /*
            treeArr = mapper.readValue("[1,2,3,null,4]", Integer[].class);
            distance  = 3;
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            ans = sol.countPairs(root, distance);
            System.out.println("ans: " + ans);
            //*/
            
           
            treeArr = mapper.readValue("[1,2,3,4,5,6,7]", Integer[].class);
            distance  = 3;
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            ans = sol.countPairs(root, distance);
            System.out.println("ans: " + ans);
            //*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution1530 {
	
	
	private int pairCnt;
	private int maxDist;
    public int countPairs(TreeNode root, int distance) {
    	this.maxDist = distance;
    	this.pairCnt = 0;
    	traverse(root,new int[distance+1]);
        return pairCnt;
    }//end method
    
    /**
     * General rule: when we say "distance from somewhere" it means the distance from the source to CURRENT node
     * so say distance array from left child = {0,1,0}, it means there's one node from left child that has distance of 1 to current node
     * this means at left child (which is a leaf), when generating distance array the method must put itself to index 1 instead of index 0
     * in other words it thinks from the perspective of the node (its parent) who receives the array
     * 
     * same for distance array from parent, the parent node must think from the role of its children
     * distance array format:
     * array index: distance, array value: number of elements at this distance.
     * 
     * @param node - int
     * @param distArrFromParent - int[]
     * @return int[] - distance arrays containing new nodes from this branch 
     */
    int[] traverse(TreeNode node, int[] distArrFromParent) {
    	//System.out.println("node: " + node.val + ":" + Arrays.toString(distArrFromParent));
    	//edge case: this node is leaf
    	if (node.left == null && node.right == null)  {             	
        	for (int distInx = maxDist; distInx >= 0; distInx--) {
        		pairCnt += distArrFromParent[distInx];
        	}//rof
        	
        	int[] distArr = new int[maxDist+1];
        	distArr[1]++;
    		return distArr;
    	}//fi
    	
    	//step 1, shift all elements of distArrFromParent. this signifies that all dists are added by 1
    	int[] distArrForChildren = new int[maxDist+1];
    	for (int i=this.maxDist; i>0; i--) {
    		distArrForChildren[i] = distArrFromParent[i-1];
    	}//rof
    	

    	//step 2, traverse left child, if there's
    	int[] distArrFromLeftChild;
    	if (node.left != null) {
    		distArrFromLeftChild = traverse(node.left, distArrForChildren);
    	} else {
    		distArrFromLeftChild = new int[maxDist+1];
    	}//fi
    	
    	//step 3, traverse right child, if there's
    	int[] distArrFromRightChild;
    	if (node.right != null) {
    		if (distArrFromLeftChild != null) {  			
    	    	for (int i=this.maxDist; i>0; i--) {
    	    		distArrForChildren[i] = distArrForChildren[i] + distArrFromLeftChild[i-1];
    	    	}//rof
    		}//fi
    		distArrFromRightChild = traverse(node.right, distArrForChildren);    		
    	} else {
    		distArrFromRightChild = new int[maxDist+1];
    	}//fi
    	

    	//step 4, combine dist arrays from both children and return it
    	for (int i=this.maxDist; i>0; i--) {
    		distArrFromRightChild[i] = distArrFromRightChild[i-1] + distArrFromLeftChild[i-1];
    	}//rof
    	
    	return distArrFromRightChild;
    }//end method
}//end class



 