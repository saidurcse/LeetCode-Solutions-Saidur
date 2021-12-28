import java.io.*;
import java.util.*;

/*
If you are not familiar with quick sort partition I suggest you get to know that before you read this solution.

Main Idea:

this solution will partition the array into 3 parts, 0,1,2 instead of just 2 parts like quick sort. We just put 0 on the left side, 2 on the right side.
we have two pointers low and high which indicate the bound of 0s and 2s (low is the right bound of 0 and high is the left bound of 2).
At the end of this partiton low and high will be like this.

During the partition, one thing is for sure: left side of low pointer will be all 0s and right side of high pointer will be all 2s.
This is guranteed by swaping nums[mid] with the number[low + 1] when nums[mid] == 0 and with number[high - 1] when nums[mid] == 2。
*/

class Solution {
    private int[] nums;
    public void sortColors(int[] nums) {
        // one pass
        this.nums = nums;
        int low = -1;
        int high = nums.length;
        int mid = 0;
        
        while(mid < high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                ++low;
                swap(mid,low);
                // skip one, must be 1 bcz you already go through it
                mid++;
            } else {
                high--;
                swap(mid,high);
            }
        }
    }
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
