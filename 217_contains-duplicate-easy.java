import java.io.*;
import java.util.*;

/*
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); 
        for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i+1]) {
                    return true;
                }
        }
        return false;
    }
}
*/


// Time complexity: O(n)
// Space complexity: O(n)
/*
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a hashset...
        HashSet<Integer> hset = new HashSet<Integer>();
        // Traverse all the elements through the loop...
        for (int idx = 0; idx < nums.length; idx ++){
            // Searches hashset. if present, it contains duplicate...
            if (hset.contains(nums[idx])){
                return true;
            }
            // if not present it will update hashset...
            hset.add(nums[idx]);
        }
        // Otherwise return false...
        return false;
    }
}*/

/*Kotlin*/
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        
        Arrays.sort(nums)
        for(i in 0 until nums.size-1) {
            if(nums[i] == nums[i+1])
                return true
        }

        return false
    }
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        
        val hset = HashSet<Int>()

        for(i in 0 until nums.size) {
            if (hset.contains(nums[i])) {
                return true
            }
            hset.add(nums[i])
        }

        return false
    }
}
