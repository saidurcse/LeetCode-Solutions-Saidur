import java.io.*;
import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        int len = s.length; 
        for(int i = 0; i < len / 2; i++) {
            char ch = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = ch;
        }
    }
}