import java.io.*;
import java.util.*;

/* 
This is a classic sliding window problem. Expand on the right at each iteration and shrink the left side until we are not fufilling our criteria - sum < k.
*/

/*Best Solution*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        
        while (right < nums.length) {
            sum += nums[right];
            right++;
            
            while (sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left);
                left++;
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/*
Binary Search Solution
*/

/**
 * This solution uses binary search method on window size and tries to find if a
 * window of size is available in the nums array or not.
 *
 * This solution only works if there are only positive numbers.
 *
 * T(k) = T(k/2) + O(N) ==> T(k) = O(N log(k)). Here k is N. Thus the time
 * complexity will be O(N log(N)).
 *
 * Time Complexity: O(N log(N))
 *
 * Space Complexity: O(1)
 *
 * N = Length of input array.
 */
 
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || target < 0) {
            throw new IllegalArgumentException("Input array is null");
        }

        int len = nums.length;
        int start = 1;
        int end = len;
        int minLen = len + 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int foundWindowSize = windowExists(nums, target, mid);
            if (foundWindowSize > 0) {
                end = foundWindowSize - 1;
                minLen = foundWindowSize;
            } else {
                start = mid + 1;
            }
        }

        return minLen % (len + 1);
    }

    private int windowExists(int[] nums, int target, int maxWindowSize) {
        int foundWindowSize = 0;
        for (int i = 0; i < nums.length; i++) {
            target -= nums[i];
            foundWindowSize++;

            if (i >= maxWindowSize) {
                foundWindowSize--;
                target += nums[i - maxWindowSize];
            }

            if (target <= 0) {
                return foundWindowSize;
            }
        }

        return -1;
    }
}

/*
Sliding Window Solution
*/

/**
 * This solution only works if there are only positive numbers. If there are
 * negative numbers too, then see solution for
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 *
 * Time Complexity: O(N). Each element of array is visited maximum twice.
 *
 * Space Complexity: O(1)
 *
 * N = Length of input array.
 */
 
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || target < 0) {
            throw new IllegalArgumentException("Input array is null");
        }

        int len = nums.length;
        int start = 0;
        int end = 0;
        int minLen = len + 1;

        while (end < len) {
            target -= nums[end];
            end++;

            while (target <= 0) {
                minLen = Math.min(minLen, end - start);
                target += nums[start];
                start++;
            }
        }

        return minLen % (len + 1);
    }
}
