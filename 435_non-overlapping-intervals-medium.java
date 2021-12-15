import java.io.*;
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res=0;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]); //sorting intervals with respect to end
        int prevStart = intervals[0][0]; //first intervals's start after sorting
        int prevEnd = intervals[0][1]; //first intervals's end after sorting
        for(int i=1;i<intervals.length; i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
			//Whenever the next interval's start is <= previous interval's start OR next intervals's start is lesser than previous intervals's end,
			//we need to remove that interval...Thus incrementing our res
            if(newStart<=prevStart || newStart<prevEnd) res++;
            else{
                prevStart = newStart;
                prevEnd = newEnd;
            }
        }
        return res;
    }
}