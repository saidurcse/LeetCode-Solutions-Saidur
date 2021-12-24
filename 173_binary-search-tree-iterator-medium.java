import java.io.*;
import java.util.*;

/*
Each time we keep pushing the left children into the stack until we reach a null node. Then the top node will always have the mininun value. It's kind of like the in-order traveral, except that we keep the "root" nodes in the stack for future use (such as adding the right children to the stack).

Time complexity:
suppose the binary search tree has height h (if it's a balanced bst, h is O(logn))
constructor: O(h) worst case
hasNext(): O(1)
next(): O(h) worst case
add(): O(h) worst case
*/

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
class BSTIterator {

        Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>(); // initialize the stack
        add(root); //add the current node and all its left child to the stack
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        add(node.right);
        return node.val;
    }
    
    /** @add the current node and all its left child to the stack*/
    private void add(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */