class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0') continue;
                q.offer(new int[]{i,j});

                int[] dx={-1,1,0,0};
                int[] dy={0,0,1,-1};
                while(!q.isEmpty()){
                    int[] c=q.poll();
                    grid[c[0]][c[1]]='0';
                    for(int k=0;k<4;k++){
                        int nr=c[0]+dy[k];
                        int nc=c[1]+dx[k];
                        if(nr<0 || nr>=m) continue;
                        if(nc<0 || nc>=n) continue;
                        if(grid[nr][nc]=='0') continue;
                        q.offer(new int[]{nr,nc});
                        grid[nr][nc]='0';
                    }
                }
                count++;
            }
        }
        return count;
    }
}