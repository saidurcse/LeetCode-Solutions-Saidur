import java.io.*;
import java.util.*;

/*
   In the rotated array, there must be one half of the array is still in sorted order. We need to make a judgement to decide which half is ordered, and if the target in that half. If not, check the other half.
   Time complexity = O(logn)
*/

public int search(int[] A, int target) {   
	int start = 0, end = A.length - 1;
	while (start <= end) {
		int mid = (start + end) / 2;
		if (A[mid] == target) 
			return mid;
		
		if (A[start] <= A[mid]) {// Left part
			if (target >= A[start] && target < A[mid]) 
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		if (A[mid] <= A[end]) {// Right part
			if (target > A[mid] && target <= A[end])
				start = mid + 1;
			else
				end = mid - 1;
		}
	}		
	return -1;
}
