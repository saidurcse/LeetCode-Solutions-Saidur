import java.io.*;
import java.util.*;

/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
       for(int i = 0; i < nums2.length; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}*/

/*Kotlin*/
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        
        for(i in 0 until nums2.size) {
            nums1[m+i] = nums2[i]
        }

        nums1.sort()

    }
}
