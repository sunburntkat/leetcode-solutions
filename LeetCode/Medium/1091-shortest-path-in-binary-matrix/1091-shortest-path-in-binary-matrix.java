class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx={0,0,-1,1,-1,1,1,-1};
        int[] dy={1,-1,0,0,-1,1,-1,1};
        int n=grid.length;
        Queue<int[]> qForward=new LinkedList<>();
        Queue<int[]> qBackward=new LinkedList<>();
        int[][] visited=new int[n][n];
        int forwardLength=0;
        int backwardLength=0;
        qForward.offer(new int[]{-1,-1});
        qBackward.offer(new int[]{n,n});
        while(!qForward.isEmpty() && !qBackward.isEmpty()){
            int size=qForward.size();
            for(int i=0;i<size;i++){
                int[] node=qForward.poll();
                for(int j=0;j<8;j++){
                    int[] nei=new int[]{node[0]+dy[j],node[1]+dx[j]};
                    if(nei[0]<0 || nei[0]>=n || nei[1]<0 ||nei[1]>=n){
                        continue;
                    }
                    if(visited[nei[0]][nei[1]]==1){
                        continue;
                    }
                    if(visited[nei[0]][nei[1]]==-1){
                        return forwardLength+backwardLength;
                    }
                    if(grid[nei[0]][nei[1]]==1){
                        continue;
                    }
                    qForward.offer(nei);
                    visited[nei[0]][nei[1]]=1;
                }
            }
            forwardLength++;
            size=qBackward.size();
            for(int i=0;i<size;i++){
                int[] node=qBackward.poll();
                for(int j=0;j<8;j++){
                    int[] nei=new int[]{node[0]+dy[j],node[1]+dx[j]};
                    if(nei[0]<0 || nei[0]>=n || nei[1]<0 ||nei[1]>=n){
                        continue;
                    }
                    if(visited[nei[0]][nei[1]]==-1){
                        continue;
                    }
                    if(visited[nei[0]][nei[1]]==1){
                        return forwardLength+backwardLength;
                    }
                    if(grid[nei[0]][nei[1]]==1){
                        continue;
                    }
                    qBackward.offer(nei);
                    visited[nei[0]][nei[1]]=-1;
                }
            }
            backwardLength++;
        }
        return -1;
    }
}