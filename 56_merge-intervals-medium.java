import java.io.*;
import java.util.*;

/* Help Post: https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution */

/* Help Post: https://www.geeksforgeeks.org/merging-intervals/ */

class Solution{
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
		    return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);

		for (int[] interval : intervals) {
		     if(interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
			newInterval[1] = Math.max(newInterval[1], interval[1]);
		     else {                             // Disjoint intervals, add the new interval to the list
			newInterval = interval;
			result.add(newInterval);
		    }
		}

		return result.toArray(new int[result.size()][]);
	}
}

/*
class Solution {
    public int[][] merge(int[][] intervals) {
         // Sort intervals by starts
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // ----
        // a   b
        //
        //  -----
        //  c   d
        //
        // If c <= b, two intervals overlap
        
        List<int[]> intervalList = new ArrayList<>();
        int j = 1;
        int[] intervalToCompare = intervals[0];
        while (j < intervals.length) {
            if (intervals[j][0] <= intervalToCompare[1]) {
                // Two intervals overlap, so we merge intervals as intervalToCompare
                intervalToCompare = new int[]{intervalToCompare[0], Math.max(intervalToCompare[1], intervals[j][1])};
            } else {
                // No possible overlaps moving on
                intervalList.add(intervalToCompare);
                intervalToCompare = intervals[j];
            }
            // System.out.println(Arrays.toString(interval));
            j++;
        }
        intervalList.add(intervalToCompare);
        
        int[][] res = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            res[i] = intervalList.get(i); 
        }
        
        return res;
    }
}
*/
