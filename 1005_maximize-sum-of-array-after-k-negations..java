import java.io.*;
import java.util.*;

public class Solution {

	/*
     * step 1 sort 
	 * step 2 if there are negative numbers, flip the negatives according to k, and find the minimum in the array 
	 * step 3 if k%2==1, we will subtract min twice. 
	 * time O(nlogn)
	 * space O(1)
     * */
	

    public static void main(String[] args) {
    	
    	int[] nums = {3,-1,0,2};
    	int k = 3;
    	
    	Arrays.sort(nums);
		int res = 0;
		int min = 101;
		for(int i=0; i<nums.length; ++i){
			if(nums[i] < 0 && k > 0){ // flip a negative number, 
				nums[i] = -nums[i];
				k--; 
			}
			if(nums[i] < min){
				min=nums[i]; // find the minimum in the array 
			}
			res += nums[i];
		}
		if(k%2==1) 
			res -= 2*min;
         
         System.out.println(res);
    }
}