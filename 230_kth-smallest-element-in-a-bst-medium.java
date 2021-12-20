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
int idx = 0, res = 0;
public int kthSmallest(TreeNode root, int k) {
	helper(root, k);
	return res;
}

void helper(TreeNode root, int k) {
	if(root == null || idx == k) return;
	helper(root.left, k);
	if(++idx == k) {
		res = root.val;
		return;
	}
	helper(root.right, k);
}
*/

class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            if (--k == 0) {
                break;
            }
            
            cur = cur.right;
        }
        
        return cur.val; 
    }
}