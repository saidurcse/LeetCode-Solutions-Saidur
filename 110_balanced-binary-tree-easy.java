import java.io.*;
import java.util.*;

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
 
/*public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) 
                  && isBalanced(root.left)
                  && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
 }
*/
 
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return height(root) != -1;
    }
		private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = height(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

}