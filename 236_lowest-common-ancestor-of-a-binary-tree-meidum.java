import java.io.*;
import java.util.*;

/*
Theory

For the recursive version we basically want to search for the nodes p and q. Once we find them return up to our parent. We initiate a search for p, q on both the left and right sides of the tree. If both left and right return non-null values, then that current node is the LCA, otherwise, return the non-null up to the parent. If what I said makes very little sense, trust me, once you actually understand this solution, it becomes trival.

As for the iterative version, we need to create a mapping to our parent Node. We can acheive this with a map. We build up this map until those mappings are defined for both p and q. Then we create a set, containing all the nodes that go from p- > null. We do the same for q, the first one found in our set is the LCA. Credit for the solution goes to: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65236/JavaPython-iterative-solution
*/

Solution(Recursive)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left == null) ? right : left;
    }

Solution (Iterative)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parentMap.put(root, null);
        stack.push(root);
        
        
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode curr = stack.pop();
            
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                stack.push(curr.right);
            }
            
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                stack.push(curr.left);
            }
        }
        
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        
        while (q != null) {
            if (set.contains(q)) return q;
            q = parentMap.get(q);
        }
        return null;
    }
