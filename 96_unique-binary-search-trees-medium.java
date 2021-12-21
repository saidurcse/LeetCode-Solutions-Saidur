import java.io.*;
import java.util.*;

/*
nit dp[0] = 1 for null;
for each n, pick any i = k (k = 1 - n) allocate rest n-1 child nodes to left or right;
*/

class Solution {
    public int numTrees(int n) {
		// dp(i) represents the no. of unique BSTs till i
        // dp(0) = 1, means there's a null node
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
			 // use j as root
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}