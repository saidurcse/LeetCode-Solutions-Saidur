import java.io.*;
import java.util.*;

public class Solution {
	
    
	 /**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	 
	class Solution {
		public TreeNode invertTree(TreeNode root) {
		   
		   if(root == null){
				return root;
			}
			
			//swap root's left and right node
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
				
			//call left and right nodes of tree
			invertTree(root.right);
			invertTree(root.left);
			
			return root;
	  
		}
	}
}

