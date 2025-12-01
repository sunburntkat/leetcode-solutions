public class Solution {
    HashSet<int> visited=new HashSet<int>();
    public int FindCircleNum(int[][] isConnected) {
        int count=0;
        for(int i=0;i<isConnected.Length;i++){
            if(!visited.Contains(i)){
                DFS(i,isConnected);
                count++;
            }
        }
        return count;
    }

    void DFS(int node,int[][] isConnected){
        visited.Add(node);
        for(int i=0;i<isConnected.Length;i++){
            int neighbour=isConnected[node][i];
            if(!visited.Contains(i) && isConnected[node][i]==1){
                DFS(i,isConnected);
            }
        }
    }
}