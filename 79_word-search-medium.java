import java.io.*;
import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(solve(board, words, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean solve(char[][] board, char[] words, boolean[][] visited, int x, int y, int i) {
        if(i == words.length) {
            return true;
        }
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }
        
        if(board[x][y] != words[i]) {
            return false;
        }
        
        visited[x][y] = true;
        boolean exists = 
            solve(board, words, visited, x + 1, y, i + 1) ||
            solve(board, words, visited, x - 1, y, i + 1) ||
            solve(board, words, visited, x, y + 1, i + 1) ||
            solve(board, words, visited, x, y - 1, i + 1);
        visited[x][y] = false;
        return exists;
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