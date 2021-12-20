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

class Solution {
	
    Map<Integer, Integer> postOrderMap = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postOrderMap.put(postorder[i], i);
        }
		
        return constructFromPrePostHelper(preorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePostHelper(int[] preorder, int postOrderStartIndex, int postOrderEndIndex) {
		
        if (postOrderStartIndex > postOrderEndIndex) {
            return null;
        }
		
        TreeNode root = new TreeNode(preorder[preOrderIndex++]);

        if (postOrderStartIndex < postOrderEndIndex) {
            int postOrderIndex = postOrderMap.get(preorder[preOrderIndex]);
            root.left = constructFromPrePostHelper(preorder, postOrderStartIndex, postOrderIndex);
            root.right = constructFromPrePostHelper(preorder, postOrderIndex + 1, postOrderEndIndex - 1);
        }
		
        return root;
    }
}