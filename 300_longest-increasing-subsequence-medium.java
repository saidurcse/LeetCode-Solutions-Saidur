import java.io.*;
import java.util.*;

/*
//1ms anwser
public int lengthOfLIS(int[] nums) {
    int len=nums.length;
    int[] st=new int[len];
    int top=-1;
    for(int i=0;i<len;i++)
    {
        int a=top;
        while(a!=-1&&st[a]>=nums[i]) a--;
        if(a==top) top++;
        st[++a]=nums[i];
    }
    return top+1;
}

The worst time complexity is O(n^2). If we use binary search to determine the index of the inserted element, it could achieve O(nlogn). I think the tag of this problem is very
confusing. The problem can be included as a DP problem but it doesn't make sense well, because the problem has only one sub-problem. When I saw the problem, the first thing
I came up with was stack...
*/

public int lengthOfLIS(int[] nums) {
  if (nums.length == 0) return 0;
  
  int n = nums.length, max = 0;
  int[] dp = new int[n];
  
  for (int i = 0; i < n; i++) {
    dp[i] = 1; /* Initialize LIS values for all indexes */
    
    for (int j = 0; j < i; j++) { /* Compute optimized LIS values in bottom up manner */
      if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
        dp[i] = dp[j] + 1;
      }
    }
    
    max = Math.max(max, dp[i]); /* Pick maximum of all LIS values */
  }
  
  return max;
}
