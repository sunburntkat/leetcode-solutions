class Solution {
    public int numIslands(char[][] grid) {
        //im gonna do it without modifying grid, hence the extra matrix
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]||grid[i][j]=='0') continue;
                q.offer(new int[]{i,j});
                while(!q.isEmpty()){
                    int[] c=q.poll();
                    if(c[0]<0 || c[0]>=m) continue;
                    if(c[1]<0 || c[1]>=n) continue;
                    if(visited[c[0]][c[1]]) continue;
                    if(grid[c[0]][c[1]]=='0') continue;
                    q.offer(new int[]{c[0]+1,c[1]});
                    q.offer(new int[]{c[0]-1,c[1]});
                    q.offer(new int[]{c[0],c[1]+1});
                    q.offer(new int[]{c[0],c[1]-1});
                    visited[c[0]][c[1]]=true;
                }
                count++;
            }
        }
        return count;
    }
}