package Problems;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.TreeUtils;

import DataStructs.TreeNode;

public class Prob2096 {
	
	

	
	public static void test() {
		Solution2096 sol = new Solution2096();
		
		Integer[] treeArr;
		TreeNode root;
		int startValue, destValue;
		String ans;
		try {
            ObjectMapper mapper = new ObjectMapper();
            
          
            
            treeArr = mapper.readValue("[5,1,2,3,null,6,4]", Integer[].class);
            
            startValue = 3;
            destValue = 6;
            
            root = TreeUtils.buildTree(treeArr);
            TreeUtils.displayTree(root);
            ans = sol.getDirections(root, startValue, destValue);
            System.out.println("ans: " + ans);
        } catch (Exception e) {
            e.printStackTrace();
        }


	}//end method
	
	public static void main(String[] args) {
		test();
	}

}

class Solution2096 {
	private int startValue, destValue;
	private boolean isStartValEncountered, isDestValEncountered;
	private String pathString;
    public String getDirections(TreeNode root, int startValue, int destValue) {
    	this.startValue = startValue;
    	this.destValue = destValue;
    	isStartValEncountered = false;
    	isDestValEncountered = false;
    	traverse(root);
        return pathString;
    }//end method
    
    
    /**
     * precondition
     * - global variables startValue, destValue, pathString are set
     * - it is assumed that the tree and start, dest are set and valid
     * - it is assumed that there must exist a path
     * @param node
     * @param pathFromParent
     * @return StringBuilder, 
     * 			if null it means no start value or dest value is found along this path
     * 			if not null, the first character indicate whether the value found is start ('s') or dest ('d')
     */
    private StringBuilder traverse(TreeNode node) {    	
    	//base case, this node is null, caller is leaf
    	if (node == null) {
    		return null;
    	}//fi
    	
    	//base case, route has found
    	if (isStartValEncountered && isDestValEncountered) {
    		return null;
    	}//fi
    	
    	StringBuilder pathSBFromLeft, pathSBFromRight;
    	StringBuilder pathSB;
    	if (node.val == startValue) {//this node is the start node
    		//System.out.println("this node is the start node: " + node.val);
    		this.isStartValEncountered = true;
        	pathSBFromLeft = traverse(node.left);
        	pathSBFromRight = traverse(node.right);
    		if (pathSBFromLeft != null) {
    			pathSBFromLeft.append('L');    			
    			this.pathString = generatePathString(pathSBFromLeft, null);
    			return null;
    		} else if (pathSBFromRight != null) {
    			pathSBFromRight.append('R');    		
    			this.pathString = generatePathString(pathSBFromRight, null);
    			return null;
    		} else {
    			pathSB = new StringBuilder();
    			pathSB.append('S');
    			return pathSB;
    		}//fi
    	} else if (node.val == destValue) {//this node is the dest node
    		//System.out.println("this node is the dest node: " + node.val);
    		this.isDestValEncountered = true;
        	pathSBFromLeft = traverse(node.left);
        	pathSBFromRight = traverse(node.right);
    		if (pathSBFromLeft != null) {
    			pathSBFromLeft.append('U');
    			this.pathString = generatePathString(pathSBFromLeft, null);
    			return null;
    		} else if (pathSBFromRight != null) {
    			pathSBFromRight.append('U');
    			this.pathString = generatePathString(pathSBFromRight, null);
    			return null;
    		} else {
    			pathSB = new StringBuilder();
    			return pathSB;
    		}//fi    		    		
    	} else {//this node is either middle of the path or not relevant at all
        	pathSBFromLeft = traverse(node.left);
        	pathSBFromRight = traverse(node.right);
    		if (pathSBFromLeft == null && pathSBFromRight == null) {//this node is not at path
    			return null;
    		} else if (pathSBFromLeft == null) {//this node is on the path and involves only right child    			
    			if (pathSBFromRight.length()==0 ||  pathSBFromRight.charAt(0) != 'S') {
        			pathSBFromRight.append('R');
        			return pathSBFromRight;    				
        		} else {
        			pathSBFromRight.append('U');
        			return pathSBFromRight;
        		}//fi
    		} else if (pathSBFromRight == null) {//this node is on the path and involves only left child    			
    			if (pathSBFromLeft.length() == 0 || pathSBFromLeft.charAt(0) != 'S') {
        			pathSBFromLeft.append('L');        			
        			return pathSBFromLeft;    				
        		} else {
        			pathSBFromLeft.append('U');
        			return pathSBFromLeft;
        		}//fi
    		} else {//this node is on the path and is the lowest common ancestor
    			if (pathSBFromLeft.length() == 0 || pathSBFromLeft.charAt(0) != 'S') {//right contains start node and left contains dest node
    				pathSBFromLeft.append('L');
    				pathSBFromRight.append('U');    				
        		} else {//left contains start node and right contains dest node
    				pathSBFromLeft.append('U');
    				pathSBFromRight.append('R');
        		}//fi
    			this.pathString = generatePathString(pathSBFromLeft, pathSBFromRight);
    			return null;
    		}//fi
    	}//fi
    	
    
    }//end method
    
    /**
     * This method reads one or two string builder object(s) and generate path string
     * first character of string builder object may have a flag character to indicates path direction:
     * - if this string path is from start to destination, then first character is 'S'
     * - if this string path is from destination to start, then there's no flag character, first character is 'L' 'R' or 'U'
     * 
     * @param pathSBA - StringBuilder
     * @param pathSBB - StringBuilder, if null, it means pathSBA will be used to generate path string
     * @return String
     */
    private String generatePathString(StringBuilder pathSBA, StringBuilder pathSBB) {		
    	if (pathSBB == null) {//generate path by using only pathSBA
    		if (pathSBA.charAt(0) == 'S') {
    			return pathSBA.substring(1);
    		} else {
    			pathSBA.reverse();    			
    			return pathSBA.toString();
    		}//fi  
    	} else {
    		if (pathSBA.charAt(0) == 'S') {
    			pathSBB.reverse();
    			pathSBA.append(pathSBB);
    			return pathSBA.substring(1);
    		} else {
    			pathSBA.reverse();    			
    			pathSBB.append(pathSBA);
    			return pathSBB.substring(1);
    		}//fi
    	}//fi
    }//fi
}//end class



 