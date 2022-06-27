import java.io.*;
import java.util.*;

/*
public int lengthOfLongestSubstring(String s) {
       
	int start = 0;
	int i = 0;
	int max = 0;
	Set<Character> set = new HashSet<>();
	while (i < s.length()) {
		if (!set.contains(s.charAt(i))) {
			set.add(s.charAt(i));
			i++;
			max = Math.max(set.size(), max);
		} else {
			set.remove(s.charAt(start));
			start++;
		}
	}

	return max;
}
*/

/*Best Solution*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
   
    	// Result count
        int max = 0;
  
        for (int i = 0; i < s.length(); i++) {
        	// Note : Default values in visited are false
        	boolean[] visited = new boolean[256];
        	
        	for(int j=i; j<s.length(); j++) {
        		// If current character is visited Break the loop
                if (visited[s.charAt(j)] == true)
                    break;
                
                // Else update the result if
                // this window is larger, and mark
                // current character as visited.
                else {
                	max = Math.max(max, j-i+1);
                	visited[s.charAt(j)] = true;
                }
        	}
        	// Remove the first character of previous window
        	visited[s.charAt(i)] = false;
        }
        
        return max;
    }
}

