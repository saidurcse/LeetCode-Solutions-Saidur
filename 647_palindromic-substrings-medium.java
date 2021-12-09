import java.io.*;
import java.util.*;

/*
Idea:
dp[i][j] is true if s[i..j] is a palindrome. So if we know dp[i+1][j-1] to be true that is s[i+1..j-1] is a palindrome and we know s[i] == s[j], then we can extend it by adding s[i] at the front and s[j] at the back.
Maintain max such string seen so far. Also, current cell depends on next row, prev col, we need to scan from bottom-up and right-left.
*/

public int countSubstrings(String s) {
	int count = 0, n = s.length();
	boolean[][] dp = new boolean[n][n];
	for(int i=n-1; i >= 0; i--){
		for(int j=i; j < n; j++){
			if(s.charAt(i) == s.charAt(j) && (i+1 > j-1 || dp[i+1][j-1] == true) ){
				dp[i][j] = true;
				++count;
			}
		}
	}
	
	return count;
}


/*
EXPLANATION AND IDEA:
BRUTEFORCE:
let say str: "aba" . check for every Possible subarray(o(n^2)) is it palindromic? if yes increase count by 1.

a              
ab        b 
aba      ba    a

Write a Palindromic function that will check either string is palindromic or not. and pass every substring to it. (O(n))
Time:O(n^3) [n^2*n]
Space:O(1)
But we can improve the timeComplexity .

OPTIMISED APPROCH:
eg s: abccba
Idea if we have checked for bccb earlier then we just have to check that is character before first b equal to character after last b.
means if dp[st+1][end-1]==true && s.charAt(st)==s.charAt(end) then its a palindromic substring.

if length of string is 1 then its a palindromic .
if length of string is 2 . just check if they are same then its palindromic.

CODE:

    public int countSubstrings(String s) {
        int count=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        
        for(int diag=0;diag<s.length();diag++){
            int st=0;
            int end=diag;
            while(end<s.length()){
                if(diag==0){
                    dp[st][end]=true;
                }else if(diag==1){
                    dp[st][end]=s.charAt(st)==s.charAt(end);
                }else{
                   if(s.charAt(st)==s.charAt(end) && dp[st+1][end-1]){
                       dp[st][end]=true;
                   }
                }
                
                if(dp[st][end]) count++;
                st++;
                end++;
            }
        }
        return count;
    }

COMPLEXITY
Time: O(n^2) Space: O(n^2)
Please UPVOTE if found it helpful and feel free to reach out me or comment down if you have any doubt.
*/

/**
 * Optimized Solution for continuous repeating characters.
 * Find the center and expand palindrome around the center.
 *
 * Time Complexity: O(N^2)
 *
 * Space Complexity: O(1)
 *
 * N = Length of the input string S.
 */
 /*
class Solution {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        int len = s.length();
        if (len <= 1) {
            return 1;
        }

        int result = 0;
        int i = 0;
        while (i < len) {
            int start = i++;
            // Finding the continuous repeating characters
            // We can optimize by finding all such chars and treat them as the palindrome
            // center for the next expandPalindrome call.
            while (i < len && s.charAt(start) == s.charAt(i)) {
                i++;
            }
			
            // Adding number of possible substrings of the center string
            int centerLen = i - start;
            result += centerLen * (centerLen + 1) / 2;

            result += expandPalindrome(s, start - 1, i);
        }

        return result;
    }

    private int expandPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}*/