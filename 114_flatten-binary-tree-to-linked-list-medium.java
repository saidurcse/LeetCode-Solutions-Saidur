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

/*

//This solution is based on recursion. We simply flatten left and right subtree and paste each sublist to the right child of the root. (don't forget to set left child to null)
public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
*/

class Solution {
	
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}