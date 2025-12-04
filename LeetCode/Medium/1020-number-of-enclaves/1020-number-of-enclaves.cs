public class Solution {
    public int NumEnclaves(int[][] grid) {
        int m=grid.Length;
        int n=grid[0].Length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                DFS(i,0,grid);
            }
            if(grid[i][n-1]==1){
                DFS(i,n-1,grid);
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1){
                DFS(0,j,grid);
            }
            if(grid[m-1][j]==1){
                DFS(m-1,j,grid);
            }
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int i,int j,int[][] grid){
        if(i<0||j<0||i>=grid.Length||j>=grid[0].Length) return;
        if(grid[i][j]==0) return;
        grid[i][j]=0;
        DFS(i+1,j,grid);
        DFS(i-1,j,grid);
        DFS(i,j+1,grid);
        DFS(i,j-1,grid);
    }
}