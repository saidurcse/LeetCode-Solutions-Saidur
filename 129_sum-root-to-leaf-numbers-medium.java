import java.io.*;
import java.util.*;

// dfs recursively
public int sumNumbers1(TreeNode root) {
    return dfs(root, 0);
}

private int dfs(TreeNode node, int path) {
    if (node == null) {
        return 0;
    }
    path = path*10 + node.val;
    if (node.left == null && node.right == null) {
        return path;
    }
    return dfs(node.left, path) + dfs(node.right, path);
}

// import javafx.util.Pair;
//dfs iteratively 
public int sumNumbers2(TreeNode root) {
    int ret = 0;
    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(new Pair(root, 0));
    while (!stack.isEmpty()) {
        Pair<TreeNode, Integer> p = stack.pop();
        TreeNode node = p.getKey();
        int value = p.getValue();
        if (node != null) {
            value = value*10 + node.val;
            if (node.left == null && node.right == null) {
                ret += value;
            }
            stack.push(new Pair(node.right, value));
            stack.push(new Pair(node.left, value));
        }
    }
    return ret;
}

// bfs iteratively 
public int sumNumbers(TreeNode root) {
    int ret = 0;
    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    while (!queue.isEmpty()) {
        Pair<TreeNode, Integer> p = queue.poll();
        TreeNode node = p.getKey();
        int value = p.getValue();
        if (node != null) {
            value = value * 10 + node.val;
            if (node.left == null && node.right == null) {
                ret += value;
            }
            queue.add(new Pair(node.left, value));
            queue.add(new Pair(node.right, value));
        }
    }
    return ret;
}