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
 
 //Recursive solution

	if (root == null) {
		return 0;
	}
	if (root.val < L) {
		return rangeSumBST(root.right, L, R);
	} else {
		return rangeSumBST(root.left, L, R);
	} else if (root.val >= L && root.val <= R) {
		return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
	}  
 
 /*
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int sum = 0;
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            
            if(current.val >= low && current.val <= high)
                sum += current.val;
            
            if(current.left != null && current.val >= low)
                q.offer(current.left);
            
            if(current.right != null && current.val <= high)
                q.offer(current.right);
        }
        return sum;
    }
}
*/
