import java.io.*;
import java.util.*;

/*Best Solution*/
class Solution {
	private static int[][] DIRECTIONS = new int[][] {{1,0}, {0,1}};
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(k);
        if (nums1 == null || nums2 == null) return res;
        if (nums1.length == 0 || nums2.length == 0) return res;
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return ((a[0] + a[1]) - (b[0] + b[1]));
        });
        
        pq.add(new int[] {nums1[0], nums2[0], 0, 0});
        visited[0][0] = true;
        while (k > 0 && !pq.isEmpty()) {
            int[] small = pq.poll();
            res.add(Arrays.asList(small[0], small[1]));
            int x = small[2], y = small[3];
            visited[x][y] = true;
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0], newY = y + dir[1];
                boolean outOfBounds = newX < 0 || newX >= visited.length || newY < 0 || newY >= visited[0].length;
                if (outOfBounds || visited[newX][newY]) continue;
                pq.add(new int[] {nums1[newX], nums2[newY], newX, newY});
                visited[newX][newY] = true;
            }
            k--;
        }        
        
        return res;
    }
    
    /*List<List<Integer>> ans = new ArrayList<>();
    if(nums1.length < 1 || nums2.length < 1) {
        return ans;
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        }
    });
    int[] nums1Ptrs = new int[nums1.length];
    for(int i = 0; i < nums1Ptrs.length; i++) {
        pq.offer(new int[]{i, nums1Ptrs[i]});
    }

    while (ans.size() < k && pq.size() > 0) {
        int[] small = pq.poll();
        ans.add(List.of(nums1[small[0]], nums2[small[1]]));
        nums1Ptrs[small[0]]++;
        if(nums1Ptrs[small[0]] < nums2.length) {
            pq.offer(new int[]{small[0], nums1Ptrs[small[0]]});
        }
    }
    return ans;*/
}
