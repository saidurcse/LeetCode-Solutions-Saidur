import java.io.*;
import java.util.*;

/*

https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean

*/

//DFS

class Solution {
    static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pac=new boolean[heights.length][heights[0].length];
        boolean[][] atl=new boolean[heights.length][heights[0].length];
        
        for(int i=0;i<n;i++){
            dfs(heights,0,i,Integer.MIN_VALUE,pac);
            dfs(heights,m-1,i,Integer.MIN_VALUE,atl);
        }
        for(int j=0;j<m;j++){
            dfs(heights,j,0,Integer.MIN_VALUE,pac);
            dfs(heights,j,n-1,Integer.MIN_VALUE,atl);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(pac[i][j] && atl[i][j]){
                   List<Integer> l=new ArrayList<>();
                   l.add(i);
                   l.add(j);
                   ans.add(l);
               }
            }
        }
        return ans;
    }
    public static void dfs(int[][] heights,int i, int j,int prev, boolean[][] arr){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || arr[i][j]==true || heights[i][j]<prev)return;
        
        arr[i][j]=true;
        for(int k=0;k<4;k++){
            int x=i+dir[k][0];
            int y=j+dir[k][1];
            
            dfs(heights,x,y,heights[i][j],arr);
        }
        
        
    }
}
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; ++i) {
            
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            
            int number = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                
                int total = number + nums[low] + nums[high];
                
                if (total == 0) {
                    
                    List<Integer> list = Arrays.asList(nums[low], number, nums[high]);
                    
                    result.add(list);
                    
                    low++;
                    
                    while (low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                    
                    high--;
                    
                    while (low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                    
                } else if (total < 0) {
                    
                    low++;
                    
                } else {
                    
                    high--;
                }
            }
        }
        
        return result;
    
    }
}