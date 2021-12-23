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