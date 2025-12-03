public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        Queue<(int i,int j)> queue=new();
        var visited=new bool[mat.Length,mat[0].Length];
        int[] di={0,0,1,-1};
        int[] dj={1,-1,0,0};

        for(int i=0;i<mat.Length;i++){
            for(int j=0;j<mat[0].Length;j++){
                if(mat[i][j]==0){
                    queue.Enqueue((i,j));
                }
            }
        }


        int iter=0;
        while(queue.Count!=0){
            int n=queue.Count;
            for(int i=0;i<n;i++){
                var node=queue.Dequeue();
                // if(visited.Contains(node)) continue;
                mat[node.i][node.j]=iter;
                for(int j=0;j<4;j++){
                    int ni=node.i+di[j];
                    int nj=node.j+dj[j];
                    if(ni<0||nj<0||ni>=mat.Length||nj>=mat[0].Length) continue;
                    if(mat[ni][nj]==0) continue;
                    if(visited[ni,nj]) continue;
                    queue.Enqueue((ni,nj));
                    visited[ni,nj]=true;
                }
            }
            iter++;
        }
        return mat;
    }
}