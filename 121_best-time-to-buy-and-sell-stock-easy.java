import java.io.*;
import java.util.*;

// First need to find min_price whcih is the buying cost
// Subtract the min_price with every element of the price
// Compare the two cost maxCost and cost so that we can get the profit on the same day

/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cost = 0;
        int maxCost = 0;
 
        if (n == 0) {
            return 0;
        }
 
        // store the first element of array in a variable
 
        int min_price = prices[0];
 
        for (int i = 0; i < n; i++) {
 
            // now compare first element with all the
            // element of array and find the minimum element
 
            min_price = Math.min(min_price, prices[i]);
 
            // since min_price is smallest element of the
            // array so subtract with every element of the
            // array and return the maxCost
 
            cost = prices[i] - min_price;
 
            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }
}*/

/*Kotlin*/
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minCost = 0
        var maxCost = 0

        var min_price = prices[0]

        for(i in 0 until prices.size) {
            min_price = Math.min(min_price, prices[i])

            minCost = prices[i] - min_price;

            maxCost = Math.max(maxCost, minCost)
        }

        return maxCost
    }
}
