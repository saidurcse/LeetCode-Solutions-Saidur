import java.io.*;
import java.util.*;

/*
left[i] means the length of the left part of the mountain whose peak is a[i]
right[i] means the length of the right part of the mountain whose peak is a[i]
If left[i] or right[i] is 0, this means that a[i] can't be the peak.
Then just traversing again to get the longest mountain length;
*/

class Solution {
    public int longestMountain(int[] a) {
        int[] left = new int[a.length]; 
        for (int i = 0 ; i < a.length; i++) {
            if (i != 0) {
                if (a[i] > a[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }
        }
        int[] right = new int[a.length];
        for (int i = a.length - 1; i >= 0 ; i--) {
            if (i != a.length - 1) {
                if (a[i] > a[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0 ; i < a.length ; i++) {
            if (left[i] != 0 && right[i] != 0) {
                max = Math.max(left[i] + right[i] + 1, max);
            }
        }
        return max;
    }
}
