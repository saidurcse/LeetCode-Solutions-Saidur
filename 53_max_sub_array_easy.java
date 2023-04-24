import java.io.*;
import java.util.*;

public class Solution {

	/*
     * Given an array, find the contiguous subarray with the largest sum.
     * Input: -4, 2,-5,1,2,3,6,-5,1
     * Output: the largest sum subarray starts at index 3 and ends at 6 and the largest sum is 12
     *
     *
     * Below solution has:
     * Runtime Complexity - Linear, O(n).
     * Memory Complexity - Constant, O(1).
     *
     * This can be solved by Kadane's algorithm:
     * The idea of Kadane’s algorithm is to maintain a variable "max_ending_here" that stores the maximum sum contiguous subarray ending at current index and
     * a variable "max_so_far" stores the maximum sum of contiguous subarray found so far, Everytime there is a positive-sum value in "max_ending_here" compare
     * it with max_so_far and update "max_so_far" if it is greater than "max_so_far".
	Initialize:
        max_so_far = INT_MIN
        max_ending_here = 0

	Loop for each element of the array

	(a) max_ending_here = max_ending_here + a[i]
	(b) if(max_so_far < max_ending_here)
		max_so_far = max_ending_here
	(c) if(max_ending_here < 0)
		max_ending_here = 0
	return max_so_far
	Exaplanation: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ (No need)
     * */
	
    public static int maxSubArray(int[] nums) {
    	
    	int size = nums.length;
	int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
 
        for (int i = 0; i < size; i++)
        {
        	max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here)
            	max_so_far = max_ending_here;
            if (max_ending_here < 0)
            	max_ending_here = 0;
        }
        return max_so_far;

    }

    public static void main(String[] args) {
        int[] arr = {-4, 2,-5,1,2,3,6,-5,1};
        System.out.println(maxSubArray(arr));
    }
}

/* Output: 12 */
