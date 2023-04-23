import java.io.*;
import java.util.*;

// Using one array loop
// Using bitwise operator counting the bits

class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n+1];

        for(int i=1;i<=n; i++) {
            f[i] = f[i>>1] + (i&1);
        }

        return f;
    }
}
