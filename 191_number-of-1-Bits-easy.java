import java.io.*;
import java.util.*;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        return Integer.bitCount(n);
    }
}