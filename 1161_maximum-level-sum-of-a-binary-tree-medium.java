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
 
 
/* BFS */
 
class Solution {
    public int maxLevelSum(TreeNode root) {
        
        int max_sum = Integer.MIN_VALUE;
        int max_lvl = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        
        while (!q.isEmpty())
        {
            ++level;
            int sum = 0;
            int cnt = q.size();
            
            for(int i=0; i<cnt; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            
            if(sum > max_sum) {
                max_sum = sum;
                max_lvl = level;
            }
        }
        
        return max_lvl;
        
    }
}