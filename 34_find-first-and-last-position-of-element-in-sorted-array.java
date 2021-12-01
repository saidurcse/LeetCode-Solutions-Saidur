import java.io.*;
import java.util.*;

class Solution {

	public int[] searchRange(int[] nums, int target) {
        int firstPos = lowerBound(nums, target);
        int lastPos = upperBound(nums, target);
        if(firstPos > lastPos) return new int[]{-1, -1};
        
        return new int[]{firstPos, lastPos};
    }
    
    private int lowerBound(int[] nums, int target){
        final int N = nums.length;
        int low = 0, high = N;
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(target > nums[mid]) 
            	low = mid + 1;
            else high = mid; 
        }
        
        return low;
    }
    
    private int upperBound(int[] nums, int target){
        final int N = nums.length;
        int low = 0, high = N;
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(target < nums[mid]) 
            	high = mid;
            else 
            	low = mid + 1;
        }
        
        return high - 1;
    }
	
}