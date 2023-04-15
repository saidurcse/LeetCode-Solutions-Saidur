import java.io.*;
import java.util.*;

public class Solution {
	
	/*
	private class Node {
		TreeNode node;
		int left, right;
		public Node(TreeNode node, int left, int right) {
			this.node = node;
			this.left = left;
			this.right = right;
		}
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		TreeNode root = new TreeNode(0);
		Stack<Node> stack = new Stack<>();
		Node node = new Node(root, 0, nums.length - 1);
		stack.push(node);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			int mid = cur.left + (cur.right - cur.left) / 2;
			cur.node.val = nums[mid];		
			if (cur.left < mid) {
				cur.left = new TreeNode(0);
				stack.push(new Node(cur.left, cur.left, mid - 1));
			}
			if (cur.right > mid) {
				cur.right = new TreeNode(0);
				stack.push(new Node(cur.right, mid + 1, cur.right));
			}
		}
		return root;
	}
	*/
	
	
	 /*Definition for a binary tree node.*/
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
    
	 public TreeNode sortedArrayToBST(int[] nums) {
	        if (nums.length == 0) {
	            return null;
	        }
	            
	        TreeNode head = helper(nums, 0, nums.length - 1);
	        return head;
	    }
	        
	   private TreeNode helper(int[] nums, int left, int right) {
	        if (left > right) {
	            return null;
	        }
	        
	        int mid = left + (right - left) / 2; // Pick the middle element as root // int mid = (left + right) / 2;
	        
	        TreeNode root = new TreeNode(nums[mid]);
	        root.left = helper(nums, left, mid - 1); // Check if any elements remaining on the left side // add left subtree
	        root.right = helper(nums, mid + 1, right); // Check if any elements remaining on the right side // add right subtree
	        
	        return root;
	    }
}

