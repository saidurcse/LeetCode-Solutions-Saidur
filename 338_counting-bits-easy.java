import java.io.*;
import java.util.*;

// Using one array loop
// Using bitwise operator counting the bits

/*
class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n+1];

        for(int i=1;i<=n; i++) {
            f[i] = f[i>>1] + (i&1);
        }

        return f;
    }
}*/


class Solution {
    fun countBits(n: Int): IntArray {
        val f = IntArray(n + 1)
        
        for (i in 1..n) {
            f[i] = f[i shr 1] + (i and 1)
        }

        return f
    }
}
