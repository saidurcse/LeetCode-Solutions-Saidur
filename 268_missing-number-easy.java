import java.io.*;
import java.util.*;

/*This solution is easy for understanding. Suppose the input is [0,1,3,4], the numbers in the array have indices [0,1,2,3],
so the difference of each number between its corresponding index is [0,0,1,1], add up the differences, subtract it from
the length of the array, we can get the missing number from which the difference occurs. Please leave any comments for discussing the solution.*/

public int missingNumber(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++)
        sum += nums[i] - i;
    return nums.length - sum;
}

/*Binary Search*/

public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}