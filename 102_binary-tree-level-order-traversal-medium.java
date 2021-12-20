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

Iterative:

class Solution {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
		
        List<List<Integer>> result = new LinkedList<>();
		
        if(root==null)
            return result;
		
        Deque<TreeNode> q = new java.util.LinkedList<>(); 
        q.add(root);
		
        while(!q.isEmpty()) {
            int size = q.size();            
            List<Integer> list = new ArrayList<>();
            for(int i  = 0 ; i < size ; i++) {
                TreeNode temp = q.pollFirst();
                list.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            result.add(list);
        }
        return result;
    }
}

Java concise BFS solution:

public List<List<Integer>> levelOrder(TreeNode root) {
	
	List<List<Integer>> ret = new ArrayList<>();
	
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        int l = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            TreeNode node = queue.poll(); 
            if (node != null) {
                level.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        if (!level.isEmpty()) {
            ret.add(level);
        }
    }
	
    return ret;
}

Recursive:

class Solution {
	
    List<List<Integer>> list=new ArrayList<>();
	
    public List<List<Integer>> levelOrder(TreeNode root) {
		
        if(root!=null){
            traverseTree(root,0);
        }
        return list;
    }
    
    public void traverseTree(TreeNode node,int depth){
        if(node==null){
            return ;
        }
        if(list.size()==depth){
            list.add(new ArrayList<>());
            
        }
        list.get(depth).add(node.val);
        traverseTree(node.left,depth+1);
        traverseTree(node.right,depth+1);
    }
}