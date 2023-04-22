import java.io.*;
import java.util.*;

/*
int[] result = new int[2];
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (int i = 0; i < nums.length; i++) {
	if (map.containsKey(target - nums[i])) {
		result[1] = i;
		result[0] = map.get(target - nums[i]);
		return result;
	}
	map.put(nums[i], i);
}
return result;
*/

// First calling one arrary for storing result
// Two loops for traversing the numbers
// Checking with target, if found return the resutl

/*Best Solution*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int result [] = new int[2];
        
        
        for(int i=0; i<nums.length-1; i++) {
        	for(int j=i+1; j<nums.length; j++) {
	        	if(nums[i] + nums[j] == target) {
	        		result[0] = i;
	        		result[1] = j;
	        	} 
        	}
        }
       
        return result;
    }
}

/*
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        for(i in 0 until nums.size - 1) {
            for(j in i+1 until nums.size) {
                if(nums.get(i) + nums.get(j) == target) {
                    result[0] = i
                    result[1] = j
                }
            }
        }

        return result
    }
}
*/
