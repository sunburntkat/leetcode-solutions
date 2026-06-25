class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q =new LinkedList<>();
        int[] colours=new int[graph.length];
        for(int k=0;k<graph.length;k++){
            if(colours[k]!=0) continue;
            colours[k]=1;
            q.offer(k);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    int node=q.poll();
                    for(int j=0;j<graph[node].length;j++){
                        int neighbour=graph[node][j];
                        if(colours[neighbour]==0){
                            colours[neighbour]=-colours[node];
                            q.offer(neighbour);
                        }else if(colours[neighbour]==colours[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}