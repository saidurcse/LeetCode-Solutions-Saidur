import java.io.*;
import java.util.*;

/*
This solution uses BFS approach to find the min number of transformations and generates new words with one char different for each word in the transformation chain.

Time and space complexities: I guess (26 ^ W * N) due to new word generation. Please correct me in your comments.
W - width of the words.
N - the number of elements in the word list.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> chain = new ArrayDeque<>();
        chain.add(beginWord);
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        
        int length = 0;
        while (!chain.isEmpty()) {
            length++;
            int size = chain.size();
            while (size-- > 0) {
                String word = chain.remove();
                if (word.equals(endWord)) {
                    return length;
                }
                
                for (int i = 0; i < word.length(); i++) {
                    String prefix = word.substring(0, i);
                    String suffix = word.substring(i + 1, word.length());
                    for (char c = 'a'; c <= 'z'; c++) {
                        String candidate = prefix + c + suffix;
                        if (dict.remove(candidate)) {
                            chain.add(candidate);
                        }
                    }
                }
            }
        }
        return 0;
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