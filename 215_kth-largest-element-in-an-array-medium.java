import java.io.*;
import java.util.*;

/*
Personally, the most straightforward way is to use quick select. There is a simple conversion: Find kith largest element is equivalent to find (n - k)th smallest element
in array. It is worth mentioning that (n - k) is the real index (start from 0) of an element.
Pivot: First, quicksort determines something called a pivot, which is a somewhat arbitrary element in the collection. Next, using the pivot point,
it partitions (or divides) the larger unsorted collection into two, smaller lists.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
    
    private int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}
*/

/*Best Solution*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
		Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
