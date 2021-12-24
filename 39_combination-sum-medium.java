import java.io.*;
import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    helper(candidates, 0, target, new ArrayList<Integer>());
    return res;
}

private void helper(int[] can, int start, int target,List<Integer> each) {
    for (int i = start; i < can.length; i++) {
        List<Integer> temp = new ArrayList<>(each);
        if (can[i] == target) {
            temp.add(can[i]);
            res.add(temp);
            break;
        } else if (can[i] < target) {
            temp.add(can[i]);
            helper(can, i, target - can[i], temp);
        } else {break;}
    }
    return;
}
}