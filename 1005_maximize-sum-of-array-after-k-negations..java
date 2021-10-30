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
    	
    	/*Arrays.sort(nums);
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
		 */
		 
		// Create a priority queue and insert all array elements in the priority queue      TC: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums)
            pq.add(num);
        // Do k negations by removing a minimum element k times         TC: O(log n)
        while(k--> 0) {
            int temp = pq.poll();   // Retrieve and remove min element
            
            temp *= -1;     // Modify the min element and add it back to priority queue
            pq.add(temp);
        }
        
        // Compute sum of all elements in priority queue
        int sum = 0;
        for(int num : pq)
            sum += num;
        return sum;
         
    }
}