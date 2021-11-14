import java.io.*;
import java.util.*;

class Solution {
	
	/*   //Java BFS
	
	private int[][] increments = new int[][] {{0, +1}, {-1, 0}, {0, -1}, {+1, 0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        boolean[][] isVisted = new boolean[image.length][image[0].length];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {sr, sc});
        while (!q.isEmpty()) {
            int[] i = q.remove();
            int r = i[0];
            int c = i[1];
            isVisted[r][c] = true;
            for (int[] inc : increments) {
                int nr = r + inc[0];
                int nc = c + inc[1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && (!isVisted[nr][nc]) && image[nr][nc] == color) {
                    q.add(new int[] {nr, nc});
                }
            }
            image[r][c] = newColor;
        }
        return image;
    }
	*/
	
	/*   //Java DFS
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        
      int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        dfs(image,sr,sc,newColor,image[sr][sc],dir);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int newColor,int oldColor,int[][] dir){
        image[sr][sc]=newColor;
         for(int i=0;i<4;i++){
            int x= sr+dir[i][0];
            int y= sc+ dir[i][1];
            if(x<0 || y<0 || x>=image.length || y>= image[0].length || image[x][y]!=oldColor) continue;
             dfs(image,x,y,newColor,oldColor,dir);
        }
    }
	*/
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);/*check bottom*/
        fill(image, sr - 1, sc, color, newColor);/*check top*/
        fill(image, sr, sc + 1, color, newColor);/*check right*/
        fill(image, sr, sc - 1, color, newColor);/*check left*/
    }
}