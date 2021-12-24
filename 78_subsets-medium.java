import java.io.*;
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    dfs(nums, 0, new ArrayList<>(), ret);
    return ret;
}

private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
    ret.add(path);
    for (int i = idx; i < nums.length; i++) {
        List<Integer> p = new ArrayList<>(path);
        p.add(nums[i]);
        dfs(nums, i+1, p, ret);
    }
}
}
