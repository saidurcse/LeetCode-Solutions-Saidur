import java.io.*;
import java.util.*;

/*
 
 public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }
    
    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);   
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
 
 */

class Solution {
    private int idx;
    
    public String decodeString(String s) {
    	idx = 0;
    	return helper(s);
    }
    
    private String helper(String s) {
    	StringBuilder ans = new StringBuilder();
    	int repeat = 0;
    	while (idx < s.length()) {
    		char ch = s.charAt(idx);
    		if(ch == ']') {
    			return ans.toString();
    		} else if (ch == '[') {
    			++idx;
    			String str =  helper(s);
    			while (repeat > 0) {
    				ans.append(str);
    				--repeat;
    			}
    		} else if (Character.isDigit(ch)){
				repeat = repeat * 10 + ch - '0';
			} else {
				ans.append(ch);
			}
    		++idx;
    	}
    	
    	return ans.toString();
    }
}
