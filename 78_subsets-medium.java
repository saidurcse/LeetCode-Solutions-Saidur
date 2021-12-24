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
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; ++i) {
            
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            
            int number = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                
                int total = number + nums[low] + nums[high];
                
                if (total == 0) {
                    
                    List<Integer> list = Arrays.asList(nums[low], number, nums[high]);
                    
                    result.add(list);
                    
                    low++;
                    
                    while (low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                    
                    high--;
                    
                    while (low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                    
                } else if (total < 0) {
                    
                    low++;
                    
                } else {
                    
                    high--;
                }
            }
        }
        
        return result;
    
    }
}