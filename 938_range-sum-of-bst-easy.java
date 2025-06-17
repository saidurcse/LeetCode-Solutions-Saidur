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

	if (root == null) return 0; // base case.
        if (root.val < low) return rangeSumBST(root.right, low, high); // left branch excluded.
        if (root.val > high) return rangeSumBST(root.left, low, high); // right branch excluded.
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high); // count in both children.  
 
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
