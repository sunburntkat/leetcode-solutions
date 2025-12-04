public class Solution {
    public void Solve(char[][] board) {
        int m=board.Length;
        int n=board[0].Length;
        List<(int i,int j)> Os=new();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                Os.Add((i,0));
            }
            if(board[i][n-1]=='O'){
                Os.Add((i,n-1));
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                Os.Add((0,j));
            }
            if(board[m-1][j]=='O'){
                Os.Add((m-1,j));
            }
        }
        int[] di={0,0,1,-1};
        int[] dj={1,-1,0,0};

        bool[,] visited=new bool[m,n];
        Stack<(int i,int j)> stack=new();
        for(int i=0;i<Os.Count;i++){
            stack.Push((Os[i].i,Os[i].j));
            while(stack.Count>0){
                var node=stack.Pop();
                if(visited[node.i,node.j]) continue;
                visited[node.i,node.j]=true;

                for(int k=0;k<4;k++){
                    int ni=node.i+di[k];
                    int nj=node.j+dj[k];

                    if(ni<0||nj<0||ni>=m||nj>=n) continue;
                    if(visited[ni,nj]) continue;
                    if(board[ni][nj]=='X') continue;

                    stack.Push((ni,nj)); 
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !visited[i,j]){
                    board[i][j]='X';
                }
            }
        }

    }
}