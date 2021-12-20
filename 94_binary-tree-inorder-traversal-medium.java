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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!= null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
*/ 
 
class Solution {
	
    private List<Integer> inorderlist = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left != null) {
            inorderTraversal(root.left);
        }

        inorderlist.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right);
        }

        return inorderlist;
    }
}