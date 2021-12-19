import java.io.*;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/* JAVA Graph + BFS */

/*
//Method 1: use HashMap
//1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
//2. do BFS with source vertice (target) to find all vertices with distance K to it.
class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap();
//here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
         List<Integer> res = new ArrayList<Integer> ();
        if (root == null || K < 0) return res;
        buildMap(root, null); 
        if (!map.containsKey(target)) return res;
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.add(next);
                }
            }
            K--;
        }
        return res;
    }
    
    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }    
}
*/
 
/* DFS Solution */
 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        depth(root, target, result, K);
        return result;
    }
    private int depth(TreeNode root, TreeNode target, List<Integer> result, int K) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            add(root, result, K);
            return 1;
        }
        int left = depth(root.left, target, result, K);
        int right = depth(root.right, target, result, K);
        if (left == K || right == K) {
            result.add(root.val);
        } else {
            if (left > -1) {
                add(root.right, result, K - left - 1);
                return left + 1;
            }
            if (right > -1) {
                add(root.left, result, K - right - 1);
                return right + 1;
            }
        }
        return -1;
    }
    private void add(TreeNode root, List<Integer> result, int K) {
        if (K < 0 || root == null) {
            return;
        }
        if (K == 0) {
            result.add(root.val);
            return;
        }
        add(root.left, result, K - 1);
        add(root.right, result, K - 1);
    }
}