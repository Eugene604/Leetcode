package Utils;

import java.util.ArrayList;
import java.util.Collections;

import DataStructs.TreeNode;

public class TreeUtils {
	
	
	static final ArrayList<String> LEFT_INDENT = new ArrayList<>(5);
	static final ArrayList<String> INNER_INDENT = new ArrayList<>(5);
	static final ArrayList<ArrayList<String>> NODE_LAYERS = new ArrayList<>(5);
	
	static {
		LEFT_INDENT.add("                                      ");
		LEFT_INDENT.add("                 ");
		LEFT_INDENT.add("        ");
		LEFT_INDENT.add("   ");
		LEFT_INDENT.add("");
		 
		INNER_INDENT.add("                              ");
		INNER_INDENT.add("                                    ");
		INNER_INDENT.add("               ");
		INNER_INDENT.add("     ");
		INNER_INDENT.add("");
	}
	
	
	
	/**
	 * Display tree structured given root of DataStruct.TreeNode type
	 * @param root
	 */
	public static void displayTree(TreeNode root) {	
		NODE_LAYERS.clear();
		NODE_LAYERS.add(new ArrayList<>(Collections.nCopies(1, "     ")));
		NODE_LAYERS.add(new ArrayList<>(Collections.nCopies(2, "     ")));
		NODE_LAYERS.add(new ArrayList<>(Collections.nCopies(4, "     ")));
		NODE_LAYERS.add(new ArrayList<>(Collections.nCopies(8, "     ")));
		NODE_LAYERS.add(new ArrayList<>(Collections.nCopies(16, "     "))); //*/
		addNodeToNL(0,0,root);
		
		for (int i = 0; i < 5; i++) {
			System.out.print(LEFT_INDENT.get(i));
			for (String str:NODE_LAYERS.get(i)) {
				System.out.print(str);
				System.out.print(INNER_INDENT.get(i));
			}//rof
			System.out.println();
			if (i == 4) {
				break;
			}
			System.out.print(LEFT_INDENT.get(i));
			for (String str:NODE_LAYERS.get(i)) {
				System.out.print("/   \\");
				System.out.print(INNER_INDENT.get(i));
			}//rof		
			System.out.println();
		}//*/
		
	}//end method
		
	/**
	 * 
	 * @param outerInx
	 * @param innerInx
	 * @param node
	 */
	private static void addNodeToNL(int outerInx, int innerInx, TreeNode node) {
		if (outerInx > 4) {
			return;
		}//fi
		if (node == null) {
			NODE_LAYERS.get(outerInx).set(innerInx, new String("(NUL)"));
			return;
		} else {
			NODE_LAYERS.get(outerInx).set(innerInx, new String((node.val>9?"(":"( ") + node.val + " )"));
			addNodeToNL(outerInx+1, innerInx*2, node.left);
			addNodeToNL(outerInx+1, innerInx*2+1, node.right);
		}//fi
	}

	/**
	 * Build tree given Integer array
	 * @param arr - Integer[]
	 * @return TreeNode, root of the tree
	 */
	public static TreeNode buildTree(Integer[] arr) {
		int arrL = arr.length;
		TreeNode[] treeArr = new TreeNode[arrL];
		for (int i = 0; i < arrL; i++) {
			if (arr[i] != null) {
				treeArr[i] = new TreeNode(arr[i]);
			}
		}
		int currNodeInx, lastAccessedNodeInx;
		
		for (currNodeInx = 0, lastAccessedNodeInx = 1; lastAccessedNodeInx < arrL; currNodeInx++) {
			try {

				treeArr[currNodeInx].left = treeArr[lastAccessedNodeInx];
				//System.out.println(currNodeInx + " L:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;

				treeArr[currNodeInx].right = treeArr[lastAccessedNodeInx];
				//System.out.println(currNodeInx + " R:" + lastAccessedNodeInx);
				lastAccessedNodeInx++;
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			} catch (NullPointerException e) {
				continue;
			}
		}//rof	
		
		return treeArr[0];
	}//end method
}
